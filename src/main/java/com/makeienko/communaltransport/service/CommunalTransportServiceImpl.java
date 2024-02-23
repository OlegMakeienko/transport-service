package com.makeienko.communaltransport.service;

import com.makeienko.communaltransport.model.CommunalTransport;
import com.makeienko.communaltransport.repository.CommunalTransportRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("communalTransportService")
@Slf4j
public class CommunalTransportServiceImpl implements CommunalTransportService {

    @Autowired
    private CommunalTransportRepository communalTransportRepository;

    @Override
    public CommunalTransport getCommunalRoute(String fromPlace, String toPlace) {
        return communalTransportRepository.findByFromPlaceAndToPlace(fromPlace, toPlace);
    }

    @Override
    public List<CommunalTransport> getAllRoutes() {
        return communalTransportRepository.findAll();
    }

    @Override
    public Optional<CommunalTransport> findById(Long id) {
        return communalTransportRepository.findById(id);
    }

    @Override
    public void findBestBetweenTransportAndWalking(Long id, String delayReport, String estimatedDelay) {
        Optional<CommunalTransport> transport = communalTransportRepository.findById(id);
        if(transport.isPresent()) {
            CommunalTransport actualTransport = transport.get();
            actualTransport.setDelayReport(delayReport);
            actualTransport.setEstimatedDelay(estimatedDelay);

//            // Hämta gångtiden från den enskilda transport-API:en
//            Duration walkingTime = getWalkingTime(actualTransport.getFromPlace(), actualTransport.getToPlace());
//
//            // Om förseningen gör att tiden för resan överstiger gångtiden, föreslå en gå-rutt
//            if (estimatedDelay.compareTo(walkingTime) > 0) {
//                actualTransport.setAlternativeRoute("Walking is faster due to delay. Estimated walking time: " + walkingTime);
//                communalTransportRepository.save(actualTransport);
//            }

        } else {
            throw new RuntimeException("No CommunalTransport found with id: " + id);
        }
    }

    @Override
    public List<CommunalTransport> getDelaysAndFaults() {
        return null;
    }

    @Override
    public void markRouteAsFavourite(Long id) {
        Optional<CommunalTransport> transport = communalTransportRepository.findById(id);
        if(transport.isPresent()) {
            CommunalTransport actualTransport = transport.get();
            actualTransport.setIsFavourite(true);
            communalTransportRepository.save(actualTransport);
        } else {
            throw new RuntimeException("No CommunalTransport found with id: " + id);
        }
    }

    @Override
    public void unmarkRouteAsFavourite(Long id) {
        Optional<CommunalTransport> transport = communalTransportRepository.findById(id);
        if(transport.isPresent()) {
            CommunalTransport actualTransport = transport.get();
            actualTransport.setIsFavourite(false);
            communalTransportRepository.save(actualTransport);
        } else {
            throw new RuntimeException("No CommunalTransport found with id: " + id);
        }
    }

    @Override
    public List<CommunalTransport> getFavouriteRoutes() {
        return communalTransportRepository.findByIsFavouriteTrue();
    }

    @Override
    public List<CommunalTransport> findAllWithDelaysAndFaults() {
        return null;
    }
}
