package flight_booking.controller;

import flight_booking.dto.FlightDto;
import flight_booking.service.FlightService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@NoArgsConstructor
public class FlightController {



    private FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    // Admin Panel: Manage flights
    @PostMapping("/admin/flights")
    public ResponseEntity<FlightDto> createFlight(@RequestBody FlightDto flightDto) {
        FlightDto createdFlight = flightService.createFlight(flightDto);
        return new ResponseEntity<>(createdFlight, HttpStatus.CREATED);
    }

    @GetMapping("/admin/flights")
    public ResponseEntity<List<FlightDto>> getAllFlights() {
        List<FlightDto> flights = flightService.getAllFlights();
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }

    @GetMapping("/admin/flights/{id}")
    public ResponseEntity<FlightDto> getFlightById(@PathVariable Long id) {
        FlightDto flight = flightService.getFlightById(id);
        return new ResponseEntity<>(flight, HttpStatus.OK);
    }

    @PutMapping("/admin/flights/{id}")
    public ResponseEntity<FlightDto> updateFlight(@PathVariable Long id, @RequestBody FlightDto flightDto) {
        FlightDto updatedFlight = flightService.updateFlight(id, flightDto);
        return new ResponseEntity<>(updatedFlight, HttpStatus.OK);
    }

    @DeleteMapping("/admin/flights/{id}")
    public ResponseEntity<Void> deleteFlight(@PathVariable Long id) {
        flightService.deleteFlight(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

//    // Flight Search
    @GetMapping("flights/search/byAirport")
    public ResponseEntity<List<FlightDto>> searchByAirport(@RequestParam Long airportId) {
        List<FlightDto> flights = flightService.searchByAirport(airportId);
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }

    @GetMapping("flights/search/byDateRange")
    public ResponseEntity<List<FlightDto>> searchByDateRange(@RequestParam LocalDateTime startDate, @RequestParam LocalDateTime endDate) {
        List<FlightDto> flights = flightService.searchFlightsByDateRange(startDate, endDate);
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }

    @GetMapping("flights/search/byAvailableSeats")
    public ResponseEntity<List<FlightDto>> searchByAvailableSeats(@RequestParam int availableSeats) {
        List<FlightDto> flights = flightService.searchByAvailableSeats(availableSeats);
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }

    //There should be Airplane Entity Model
//    @GetMapping("/search/byAvailablePlanes")
//    public ResponseEntity<List<FlightDto>> searchByAvailablePlanes(@RequestParam String planeModel) {
//        List<FlightDto> flights = flightService.searchByAvailablePlanes(planeModel);
//        return new ResponseEntity<>(flights, HttpStatus.OK);
//    }

    @GetMapping("flights/search/public")
    public ResponseEntity<List<FlightDto>> searchPublicEndpoint() {
        List<FlightDto> flights = flightService.searchPublicEndpoint();
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }
}