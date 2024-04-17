package com.codeki.travelagency.flight.utils;

import com.codeki.travelagency.flight.dto.FlightDto;
import com.codeki.travelagency.flight.model.Flight;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class FlightUtils {
    public FlightDto flightMapper(Flight flight, double dollarPrice){
        return new FlightDto(flight.getId(),flight.getOrigin(), flight.getDestiny(), flight.getDepartureTime(),
                flight.getArrivingTime(), flight.getPrice() * dollarPrice, flight.getFrequency(), flight.getCompany());
    }

    public List<FlightDto> flightMapperList(List<Flight> flightList, double dollarPrice) {
        return flightList.stream()
                .map(flight -> flightMapper(flight, dollarPrice))
                .collect(Collectors.toList());
    }

    public List<Flight> detectOffers(List<Flight> flightList, Integer offerPrice) {
        return flightList.stream()
                .filter(flight -> flight.getPrice() < offerPrice)
                .collect(Collectors.toList());
    }
}