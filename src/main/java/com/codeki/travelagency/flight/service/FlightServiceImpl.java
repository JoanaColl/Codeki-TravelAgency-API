package com.codeki.travelagency.flight.service;

import com.codeki.travelagency.company.model.Company;
import com.codeki.travelagency.company.repository.CompanyRepository;
import com.codeki.travelagency.dollar.model.Dollar;
import com.codeki.travelagency.dollar.utils.DollarUtils;
import com.codeki.travelagency.exception.ResourceNotFoundException;
import com.codeki.travelagency.flight.dto.FlightDto;
import com.codeki.travelagency.flight.model.Flight;
import com.codeki.travelagency.flight.repository.FlightRepository;
import com.codeki.travelagency.flight.utils.FlightUtils;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {
    // -----------  DEPENDENCY INJECTION  ------------
    FlightRepository flightRepository;
    FlightUtils flightUtils;
    DollarUtils dollarUtils;
    CompanyRepository companyRepository;

    public FlightServiceImpl(FlightRepository flightRepository, FlightUtils flightUtils, DollarUtils dollarUtils, CompanyRepository companyRepository) {
        this.flightRepository = flightRepository;
        this.flightUtils = flightUtils;
        this.dollarUtils = dollarUtils;
        this.companyRepository = companyRepository;
    }


    // -------------  CRUD METHODS  -------------
    @Override
    public FlightDto createFlight(Flight flight, Long companyId) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new ResourceNotFoundException("Company ID not found!"));
        flight.setCompany(company);
        flightRepository.save(flight);
        return flightUtils.flightMapper(flight, getDollarPrice());
    }

    @Override
    public List<FlightDto> findAllFights() {
        List<Flight> flightList = flightRepository.findAll();
        return flightUtils.flightMapperList(flightList, getDollarPrice());
    }

    @Override
    public FlightDto findFlightById(Long flightIid) throws ResourceNotFoundException  {
        Flight findedFlight = flightRepository.findById(flightIid).orElseThrow(()-> new ResourceNotFoundException("Flight ID not found!"));
        return flightUtils.flightMapper(findedFlight, getDollarPrice());
    }

    @Override
    public FlightDto updateFlight(Long flightIid, Long companyId, Flight flight) throws ResourceNotFoundException {
        if(!flightRepository.existsById(flightIid)) {
            throw new ResourceNotFoundException("Flight ID not found!");
        }
        flight.setId(flightIid);
        Company updatedCompany = companyRepository.findById(companyId).orElseThrow(()-> new ResourceNotFoundException("Company ID not found!"));
        flight.setCompany(updatedCompany);
        return flightUtils.flightMapper(flightRepository.save(flight), getDollarPrice());
    }

    @Override
    public void deleteFlightById(Long flightIid) throws ResourceNotFoundException {
        Flight deletedFlight = flightRepository.findById(flightIid).orElseThrow(()-> new ResourceNotFoundException("Flight ID not found!"));
        flightRepository.deleteById(deletedFlight.getId());
    }


    // ------------  OTHERS METHODS  ------------
    private double getDollarPrice() {
        Dollar dollarPrice = dollarUtils.fetchDollar();
        return dollarPrice.getPromedio();
    }

    public List<Flight> getFlightOffers(Integer offerPrice) {
        List<Flight> flightList = flightRepository.findAll();
        return flightUtils.detectOffers(flightList, offerPrice);
    }

    public List<FlightDto> findFlightByOrigin(String origin) {
        List<Flight> originFlightList = flightRepository.findByOrigin(origin);
        return flightUtils.flightMapperList(originFlightList, getDollarPrice());
    }

    public List<FlightDto> findFlightByOriginAndDestiny(String origin, String destiny) {
        List<Flight> originDestinyFlightList = flightRepository.findByOriginAndDestiny(origin, destiny);
        return flightUtils.flightMapperList(originDestinyFlightList, getDollarPrice());
    }
}