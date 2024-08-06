package flight_booking.repositories;

import flight_booking.domain.Flight;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FlightRepositoryCustomImpl implements FlightRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Flight> searchFlights(Long departureAirportId, Long arrivalAirportId, LocalDate startDate, LocalDate endDate, Integer travellers) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Flight> query = cb.createQuery(Flight.class);
        Root<Flight> flight = query.from(Flight.class);

        List<Predicate> predicates = new ArrayList<>();

        if (departureAirportId != null) {
            predicates.add(cb.equal(flight.get("departureAirport").get("id"), departureAirportId));
        }
        if (arrivalAirportId != null) {
            predicates.add(cb.equal(flight.get("arrivalAirport").get("id"), arrivalAirportId));
        }
        if (startDate != null) {
            predicates.add(cb.greaterThanOrEqualTo(flight.get("flightSchedule").get("departureDate"), startDate));
        }
        if (endDate != null) {
            predicates.add(cb.lessThanOrEqualTo(flight.get("flightSchedule").get("departureDate"), endDate));
        }
        if (travellers != null) {
            predicates.add(cb.greaterThanOrEqualTo(flight.get("availableSeats"), travellers));
        }

        query.where(predicates.toArray(new Predicate[0]));

        List<Flight> outboundFlights = entityManager.createQuery(query).getResultList();

        // Reverse criteria query for return flights
        CriteriaQuery<Flight> reverseQuery = cb.createQuery(Flight.class);
        Root<Flight> reverseFlight = reverseQuery.from(Flight.class);
        List<Predicate> reversePredicates = new ArrayList<>();

        if (departureAirportId != null) {
            reversePredicates.add(cb.equal(reverseFlight.get("arrivalAirport").get("id"), departureAirportId));
        }
        if (arrivalAirportId != null) {
            reversePredicates.add(cb.equal(reverseFlight.get("departureAirport").get("id"), arrivalAirportId));
        }
        if (startDate != null) {
            reversePredicates.add(cb.greaterThanOrEqualTo(reverseFlight.get("flightSchedule").get("departureDate"), startDate));
        }
        if (endDate != null) {
            reversePredicates.add(cb.lessThanOrEqualTo(reverseFlight.get("flightSchedule").get("departureDate"), endDate));
        }
        if (travellers != null) {
            reversePredicates.add(cb.greaterThanOrEqualTo(reverseFlight.get("availableSeats"), travellers));
        }

        reverseQuery.where(reversePredicates.toArray(new Predicate[0]));

        List<Flight> returnFlights = entityManager.createQuery(reverseQuery).getResultList();

        // Combine outbound and return flights
        List<Flight> allFlights = new ArrayList<>();
        allFlights.addAll(outboundFlights);
        allFlights.addAll(returnFlights);

        // Sort flights by departure date
        allFlights.sort((f1, f2) -> f1.getFlightSchedule().getDepartureDate().compareTo(f2.getFlightSchedule().getDepartureDate()));

        return allFlights;
    }
}
