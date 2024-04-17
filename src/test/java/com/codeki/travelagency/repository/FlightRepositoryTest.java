package com.codeki.travelagency.repository;

import com.codeki.travelagency.flight.model.Flight;
import com.codeki.travelagency.flight.repository.FlightRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FlightRepositoryTest {
    @Autowired
    private FlightRepository flightRepository;
    private Flight flight;

    @BeforeEach
    void setup() {
        flight = new Flight("COR", "EZE", "Sab 20 Abr", "Sab 20 Abr", 200, "Diaria");
    }

    @Test
    void saveFlightTest() {
        Flight savedFlight = flightRepository.save(flight);

        assertThat(savedFlight).isNotNull();
    }

    @Test
    void findAllFlightsTest() {
        Flight flight2 = new Flight("MEN", "COR", "Vie 15 Mar", "Vie 15 Mar", 400, "Diaria");

        flightRepository.save(flight);
        flightRepository.save(flight2);

        List<Flight> listFlights = flightRepository.findAll();

        assertThat(listFlights).isNotNull();
        assertThat(listFlights.size()).isEqualTo(2);
    }

    @Test
    void findFlightByIdTest() {
        Flight savedFlight = flightRepository.save(flight);

        Flight findedFlight = flightRepository.findById(savedFlight.getId()).get();

        assertThat(findedFlight).isNotNull();
    }

    @Test
    void updateFlightTest() {
        Flight savedFlight = flightRepository.save(flight);
        Flight findedFlight = flightRepository.findById(savedFlight.getId()).get();

        findedFlight.setOrigin("BRA");
        findedFlight.setDestiny("ARG");

        Flight updatedFlight = flightRepository.save(findedFlight);

        assertThat(updatedFlight.getOrigin()).isEqualTo("BRA");
        assertThat(updatedFlight.getDestiny()).isEqualTo("ARG");
    }

    @Test
    void deleteFlightByIdTest() {
        Flight savedFlight = flightRepository.save(flight);
        flightRepository.deleteById(savedFlight.getId());

        Optional<Flight> findedFlight = flightRepository.findById(savedFlight.getId());

        assertThat(findedFlight).isEmpty();
    }

    @Test
    void findFlightByOriginTest() {
        Flight flight2 = new Flight("COR", "TUC", "Vie 15 Mar", "Vie 15 Mar", 400, "Diaria");

        flightRepository.save(flight);
        flightRepository.save(flight2);

        List <Flight> listFlights = flightRepository.findByOrigin("COR");

        assertThat(listFlights).isNotNull();
        assertThat(listFlights.size()).isEqualTo(2);
    }

    @Test
    void findFlightByOriginAndDestiny() {
        Flight flight2 = new Flight("COR", "EZE", "Vie 15 Mar", "Vie 15 Mar", 400, "Diaria");

        flightRepository.save(flight);
        flightRepository.save(flight2);

        List <Flight> listFlights = flightRepository.findByOriginAndDestiny("COR", "EZE");

        assertThat(listFlights).isNotNull();
        assertThat(listFlights.size()).isEqualTo(2);
    }
}