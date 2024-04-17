package com.codeki.travelagency.flight.service;

import com.codeki.travelagency.flight.dto.FlightDto;
import com.codeki.travelagency.flight.model.Flight;
import java.util.List;

public interface FlightService {

    // -------------  CRUD METHODS  -------------
    FlightDto createFlight(Flight flight, Long companyId);
    List<FlightDto> findAllFights();
    FlightDto findFlightById(Long flightIid);
    FlightDto updateFlight(Long flightIid, Long companyId, Flight flight);
    void deleteFlightById(Long flightIid);


    // ------------  OTHERS METHODS  ------------
    List<FlightDto> findFlightByOrigin(String origin);
    List<FlightDto> findFlightByOriginAndDestiny(String origin, String destiny);
    List<Flight> getFlightOffers(Integer offerPrice);
}