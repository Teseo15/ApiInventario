package group7.inventario.inventario.User;

import group7.inventario.inventario.registration.token.ConfirmationTokenService;
import group7.inventario.inventario.registration.token.ConfirmattionToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class AppUserService  implements UserDetailsService {
    private final static String USER_NOT_FOUND = "usuario con email no existente ";
    private  final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private  final ConfirmationTokenService confirmationTokenService;

    public AppUserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, ConfirmationTokenService confirmationTokenService) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.confirmationTokenService = confirmationTokenService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).orElseThrow(()->
                new UsernameNotFoundException(String.format(USER_NOT_FOUND,email)));
    }
    public String signUpUser(AppUser appUser){
        boolean userExists= userRepository
                .findByEmail(appUser.getEmail())
                .isPresent();
        if(userExists){
            throw new IllegalStateException("email ya tomado");
        }
        String encodedPassword = bCryptPasswordEncoder.encode(appUser.getPassword());
        appUser.setPassword(encodedPassword);
        userRepository.save(appUser);
        String token = UUID.randomUUID().toString();
        //Crear un toke  y luego guardarlo
        ConfirmattionToken confirmattionToken= new ConfirmattionToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                appUser
        );
        confirmationTokenService.saveConfirmationToken(confirmattionToken);
        //Se envia la respuesta de email
        return token;
    }

    public void enableAppUser(String email) {
    }
}
