package flight_booking.controller;

import flight_booking.controller.genericcontroller.GenericController;
import flight_booking.dto.FlightDto;
import flight_booking.service.FlightService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/flights")
public class FlightController extends GenericController<Long,FlightDto> {



    private final FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService) {
        super(flightService);
        this.flightService = flightService;
    }

    // Admin Panel: Manage flights
    @PostMapping("/admin")
    public ResponseEntity<FlightDto> create(@RequestBody FlightDto dto) {
        return new ResponseEntity<>(flightService.save(dto), HttpStatus.CREATED);
    }

    @PutMapping("/admin/{id}")
    public ResponseEntity<FlightDto> update(@PathVariable long id, @RequestBody FlightDto dto) {
        FlightDto updatedDto = flightService.update(id, dto);
        if (updatedDto != null) {
            return ResponseEntity.ok(updatedDto);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/admin/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        flightService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

//    // Flight Search
    @GetMapping("/search/byAirport")
    public ResponseEntity<List<FlightDto>> searchByAirport(@RequestParam Long airportId) {
        List<FlightDto> flights = flightService.searchByAirport(airportId);
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }

    @GetMapping("/search/byDateRange")
    public ResponseEntity<List<FlightDto>> searchByDateRange(@RequestParam LocalDateTime startDate, @RequestParam LocalDateTime endDate) {
        List<FlightDto> flights = flightService.searchFlightsByDateRange(startDate, endDate);
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }

    @GetMapping("/search/byAvailableSeats")
    public ResponseEntity<List<FlightDto>> searchByAvailableSeats(@RequestParam int availableSeats) {
        List<FlightDto> flights = flightService.searchByAvailableSeats(availableSeats);
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<List<FlightDto>>> searchFlights(
            @RequestParam(required = false) Long departureAirportId,
            @RequestParam(required = false) Long arrivalAirportId,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
            @RequestParam(required = false) Integer travellers,
            @RequestParam(required = false) List<Long> airlines,
            @RequestParam(required = false) Double ticketPrice) {

        List<List<FlightDto>> flights = flightService.searchFlights(departureAirportId, arrivalAirportId, startDate, endDate, travellers, airlines, ticketPrice);
        return ResponseEntity.ok(flights);
    }

    //There should be Airplane Entity Model
//    @GetMapping("/search/byAvailablePlanes")
//    public ResponseEntity<List<FlightDto>> searchByAvailablePlanes(@RequestParam String planeModel) {
//        List<FlightDto> flights = flightService.searchByAvailablePlanes(planeModel);
//        return new ResponseEntity<>(flights, HttpStatus.OK);
//    }

    @GetMapping("search/public")
    public ResponseEntity<List<FlightDto>> searchPublicEndpoint() {
        List<FlightDto> flights = flightService.searchPublicEndpoint();
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }


    @GetMapping("admin/paged")
    @Override
    public Page<FlightDto> pagedSearch(
            @RequestParam int page,
            @RequestParam int size
    ){
        Pageable pageable = PageRequest.of(page, size);
        return flightService.getPaginated(pageable);
    }


}