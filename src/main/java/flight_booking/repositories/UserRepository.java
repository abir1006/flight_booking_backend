package flight_booking.repositories;


import flight_booking.domain.Role;
import flight_booking.domain.User;
import flight_booking.repositories.genericrepository.GenericRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends GenericRepository<User,Long> {

    Optional<User> findByEmail(String email);
    List<User> findAllByRole(Role role);
    Page<User> findAllByRole(Role role, Pageable pageable);
}
