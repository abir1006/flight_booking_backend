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
    public List<Flight> searchFlights(Long departureAirportId, Long arrivalAirportId, LocalDate flightDate, LocalDate returnDate, Integer travellers) {
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
        if (flightDate != null) {
            predicates.add(cb.equal(flight.get("flightSchedule").get("departureDate"), flightDate));
        }
        if (travellers != null) {
            predicates.add(cb.greaterThanOrEqualTo(flight.get("availableSeats"), travellers));
        }

        query.where(predicates.toArray(new Predicate[0]));
        List<Flight> outboundFlights = entityManager.createQuery(query).getResultList();

        if (returnDate != null) {
            CriteriaQuery<Flight> returnQuery = cb.createQuery(Flight.class);
            Root<Flight> returnFlight = returnQuery.from(Flight.class);
            List<Predicate> returnPredicates = new ArrayList<>();

            if (departureAirportId != null) {
                returnPredicates.add(cb.equal(returnFlight.get("arrivalAirport").get("id"), departureAirportId));
            }
            if (arrivalAirportId != null) {
                returnPredicates.add(cb.equal(returnFlight.get("departureAirport").get("id"), arrivalAirportId));
            }
            returnPredicates.add(cb.equal(returnFlight.get("flightSchedule").get("departureDate"), returnDate));
            if (travellers != null) {
                returnPredicates.add(cb.greaterThanOrEqualTo(returnFlight.get("availableSeats"), travellers));
            }

            returnQuery.where(returnPredicates.toArray(new Predicate[0]));
            List<Flight> returnFlights = entityManager.createQuery(returnQuery).getResultList();
            outboundFlights.addAll(returnFlights);
        }

        return outboundFlights;
    }
}
