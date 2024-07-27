package flight_booking.controller;

import flight_booking.service.GenericService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
public abstract class GenericController<ID, DTO> {
    private final GenericService<ID, DTO> service;

    @GetMapping
    public List<DTO> getAll() {
        return service.findAll();
    }

    @PostMapping
    public DTO create(@RequestBody DTO dto) {
        return service.save(dto);
    }

    @PutMapping("/{id}")
    public DTO update(@PathVariable ID id,  @RequestBody DTO dto) {
        return service.update(id,dto);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable ID id) {
        service.deleteById(id);
    }

    @GetMapping("/{id}")
    public DTO get(@PathVariable ID id) {
     return    service.findById(id).orElse(null);
    }
}