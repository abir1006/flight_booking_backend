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
    public List<List<Flight>> searchFlights(Long departureAirportId, Long arrivalAirportId, LocalDate startDate, LocalDate endDate, Integer travellers) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        List<List<Flight>> flightsList = new ArrayList<>();

        // Flights on startDate
        if (startDate != null) {
            CriteriaQuery<Flight> startDateQuery = cb.createQuery(Flight.class);
            Root<Flight> startDateFlight = startDateQuery.from(Flight.class);
            List<Predicate> startDatePredicates = new ArrayList<>();

            if (departureAirportId != null) {
                startDatePredicates.add(cb.equal(startDateFlight.get("departureAirport").get("id"), departureAirportId));
            }
            if (arrivalAirportId != null) {
                startDatePredicates.add(cb.equal(startDateFlight.get("arrivalAirport").get("id"), arrivalAirportId));
            }
            startDatePredicates.add(cb.equal(startDateFlight.get("flightSchedule").get("departureDate"), startDate));
            if (travellers != null) {
                startDatePredicates.add(cb.greaterThanOrEqualTo(startDateFlight.get("availableSeats"), travellers));
            }

            startDateQuery.where(startDatePredicates.toArray(new Predicate[0]));
            List<Flight> startDateFlights = entityManager.createQuery(startDateQuery).getResultList();
            flightsList.add(startDateFlights);
        }

        // Flights on endDate
        if (endDate != null) {
            CriteriaQuery<Flight> endDateQuery = cb.createQuery(Flight.class);
            Root<Flight> endDateFlight = endDateQuery.from(Flight.class);
            List<Predicate> endDatePredicates = new ArrayList<>();

            if (departureAirportId != null) {
                endDatePredicates.add(cb.equal(endDateFlight.get("arrivalAirport").get("id"), departureAirportId));
            }
            if (arrivalAirportId != null) {
                endDatePredicates.add(cb.equal(endDateFlight.get("departureAirport").get("id"), arrivalAirportId));
            }
            endDatePredicates.add(cb.equal(endDateFlight.get("flightSchedule").get("departureDate"), endDate));
            if (travellers != null) {
                endDatePredicates.add(cb.greaterThanOrEqualTo(endDateFlight.get("availableSeats"), travellers));
            }

            endDateQuery.where(endDatePredicates.toArray(new Predicate[0]));
            List<Flight> endDateFlights = entityManager.createQuery(endDateQuery).getResultList();
            flightsList.add(endDateFlights);
        }

        return flightsList;
    }
}