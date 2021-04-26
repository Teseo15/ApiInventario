package group7.inventario.inventario.registration;

import group7.inventario.inventario.User.AppUser;
import group7.inventario.inventario.User.AppUserRole;
import group7.inventario.inventario.User.AppUserService;

import group7.inventario.inventario.registration.token.ConfirmationTokenService;
import group7.inventario.inventario.registration.token.ConfirmattionToken;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RegistrationService {
    private final AppUserService appUserService;
    private final EmailValidator emailValidator;

    private final ConfirmationTokenService confirmationTokenService;

    public RegistrationService(AppUserService appUserService, EmailValidator emailValidator, ConfirmationTokenService confirmationTokenService) {
        this.appUserService = appUserService;
        this.emailValidator = emailValidator;

        this.confirmationTokenService = confirmationTokenService;
    }


    public String register(RegistrationRequest request)
    {
        boolean isValidEmail = emailValidator.test(request.getEmail());
        if(!isValidEmail){
            throw new IllegalStateException("Email no valido");
        }
        return appUserService.signUpUser(
                new AppUser(
                        request.getFirstName(),
                        request.getLastName(),
                        request.getEmail(),
                        request.getPassword(),
                        AppUserRole.USER
                )
        );
    }
    @Transactional
    public String confirmToken(String token) {
        ConfirmattionToken confirmationToken = confirmationTokenService
                .getToken(token)
                .orElseThrow(() ->
                        new IllegalStateException("token not found"));

        if (confirmationToken.getConfirmedAt() != null) {
            throw new IllegalStateException("email already confirmed");
        }

        LocalDateTime expiredAt = confirmationToken.getExpiresAt();

        if (expiredAt.isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("token expired");
        }

        confirmationTokenService.setConfirmedAt(token);
        appUserService.enableAppUser(
                confirmationToken.getAppUser().getEmail());
        return "confirmed";
    }
}
