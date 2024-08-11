package flight_booking.repositories.customImpl;



import flight_booking.domain.Flight;

import flight_booking.repositories.FlightRepositoryCustom;
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
    public List<Flight> searchFlights(Long departureAirportId, Long arrivalAirportId, LocalDate date, Integer travellers, boolean isOutbound, List<Long> airlines, Double ticketPrice) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Flight> query = cb.createQuery(Flight.class);
        Root<Flight> flight = query.from(Flight.class);

        List<Predicate> predicates = new ArrayList<>();

        // Handle direction
        if (isOutbound) {
            if (departureAirportId != null) {
                predicates.add(cb.equal(flight.get("departureAirport").get("id"), departureAirportId));
            }
            if (arrivalAirportId != null) {
                predicates.add(cb.equal(flight.get("arrivalAirport").get("id"), arrivalAirportId));
            }
        } else {
            if (arrivalAirportId != null) {
                predicates.add(cb.equal(flight.get("departureAirport").get("id"), arrivalAirportId));
            }
            if (departureAirportId != null) {
                predicates.add(cb.equal(flight.get("arrivalAirport").get("id"), departureAirportId));
            }
        }

        // Handle date
        if (date != null) {
            predicates.add(cb.equal(flight.get("flightSchedule").get("departureDate"), date));
        }

        // Handle travellers
        if (travellers != null) {
            predicates.add(cb.greaterThanOrEqualTo(flight.get("availableSeats"), travellers));
        }

        // Handle ticketPrice
        if (ticketPrice != null) {
            predicates.add(cb.lessThanOrEqualTo(flight.get("ticketPrice"), ticketPrice));
        }

        // Handle airlines filter
        if (airlines != null && !airlines.isEmpty()) {
            predicates.add(flight.get("airline").get("id").in(airlines));
        }

        query.where(predicates.toArray(new Predicate[0]));
        return entityManager.createQuery(query).getResultList();
    }
}
