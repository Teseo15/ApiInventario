package group7.inventario.inventario.registration;

import group7.inventario.inventario.User.AppUser;
import group7.inventario.inventario.User.AppUserRole;
import group7.inventario.inventario.User.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service

public class RegistrationService {
    private final AppUserService appUserService;
    private final EmailValidator emailValidator;

    public RegistrationService(AppUserService appUserService, EmailValidator emailValidator) {
        this.appUserService = appUserService;
        this.emailValidator = emailValidator;
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
}
