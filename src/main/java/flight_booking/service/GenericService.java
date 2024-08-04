package flight_booking.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface GenericService<ID,DTO> {
    DTO save(DTO dto);

    List<DTO> findAll();

    Optional<DTO> findById(ID id);

    DTO update(ID id, DTO dto);

    void deleteById(ID id);

     Page<DTO> getPaginated(Pageable pageable);
}