package com.codeki.travelagency.flight.controller;

import com.codeki.travelagency.flight.dto.FlightDto;
import com.codeki.travelagency.flight.model.Flight;
import com.codeki.travelagency.flight.service.FlightService;
import com.codeki.travelagency.flight.service.FlightServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/travelagency/v1")
public class FlightController {
    // -----------  DEPENDENCY INJECTION  ------------
    FlightService flightService;

    public FlightController(FlightServiceImpl flightServiceImpl) {
        this.flightService = flightServiceImpl;
    }


    // -------------  CRUD METHODS  -------------
    @PostMapping("/flight/create")
    public ResponseEntity<FlightDto> createFlight(@RequestBody  Flight flight, @RequestParam("companyId") Long companyId) {
        return new ResponseEntity<>(flightService.createFlight(flight, companyId), HttpStatus.CREATED);
    }

    @GetMapping("/flight")
    public ResponseEntity<List<FlightDto>> findAllFlights() {
        return new ResponseEntity<>(flightService.findAllFights(), HttpStatus.OK);
    }

    @GetMapping("/flight/{flightId}")
    public ResponseEntity<FlightDto> findFlightById(@PathVariable("flightId") Long flightId) {
        return new ResponseEntity<>(flightService.findFlightById(flightId), HttpStatus.OK);
    }

    @PutMapping("/flight/update/{flightId}")
    public ResponseEntity<FlightDto> updateFlight(@PathVariable("flightId") Long flightId, @RequestParam("companyId") Long companyId, @RequestBody Flight flight) {
        return new ResponseEntity<>(flightService.updateFlight(flightId, companyId, flight), HttpStatus.OK);
    }

    @DeleteMapping("/flight/delete/{flightId}")
    public ResponseEntity<String> deleteFlight(@PathVariable("flightId") Long flightId) {
        flightService.deleteFlightById(flightId);
        return new ResponseEntity<>("Flight deleted!", HttpStatus.OK);
    }


    // ------------  OTHERS METHODS  ------------
    @GetMapping("/flight/offers")
    public ResponseEntity<List<Flight>> getFlightOffers(@RequestParam("offerPrice") Integer offerPrice) {
        return new ResponseEntity<>(flightService.getFlightOffers(offerPrice), HttpStatus.OK);
    }

    @GetMapping("/flight/origin")
    public ResponseEntity<List<FlightDto>> findFlightByOrigin(@RequestParam("origin") String origin) {
        return new ResponseEntity<>(flightService.findFlightByOrigin(origin), HttpStatus.OK);
    }

    @GetMapping("flight/originAndDestiny")
    public ResponseEntity<List<FlightDto>> findFlightByOriginAndDestiny(@RequestParam("origin") String origin, @RequestParam("destiny") String destiny) {
        return new ResponseEntity<>(flightService.findFlightByOriginAndDestiny(origin, destiny), HttpStatus.OK);
    }
}