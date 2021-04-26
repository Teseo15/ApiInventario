package group7.inventario.inventario.registration.token;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ConfirmationTokenService {
    private final ConfirmationRepository confirmationRepository;

    public ConfirmationTokenService(ConfirmationRepository confirmationRepository) {
        this.confirmationRepository = confirmationRepository;
    }


    public void saveConfirmationToken(ConfirmattionToken token){
        confirmationRepository.save(token);
    }
    public Optional<ConfirmattionToken> getToken(String token) {
        return confirmationRepository.findByToken(token);
    }

    public int setConfirmedAt(String token) {
        return confirmationRepository.updateConfirmedAt(
                token, LocalDateTime.now());
    }
}
