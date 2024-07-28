package flight_booking.config.securityConfig;


import flight_booking.domain.User;
import flight_booking.repositories.genericrepository.GenericRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends GenericRepository<User,Long> {

    Optional<User> findByEmail(String email);
}
