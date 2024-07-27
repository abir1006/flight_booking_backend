package flight_booking.service;

import java.util.List;
import java.util.Optional;

public interface GenericService<ID,DTO> {
    DTO save(DTO dto);

    List<DTO> findAll();

    Optional<DTO> findById(ID id);

    DTO update(ID id, DTO dto);

    void deleteById(ID id);
}