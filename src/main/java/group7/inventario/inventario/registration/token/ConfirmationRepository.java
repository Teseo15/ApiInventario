package group7.inventario.inventario.registration.token;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface ConfirmationRepository extends JpaRepository<ConfirmattionToken,Long> {

    //Esto devolvera una confirmación


    Optional<ConfirmattionToken> findByToken(String token);
    @Transactional
    @Modifying
    @Query("UPDATE ConfirmattionToken c " +
            "SET c.confirmedAt = ?2 " +
            "WHERE c.token = ?1")
    int updateConfirmedAt(String token,
                          LocalDateTime confirmedAt);
}
