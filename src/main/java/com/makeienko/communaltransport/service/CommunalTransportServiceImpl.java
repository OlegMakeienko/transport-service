package com.makeienko.communaltransport.service;

import com.makeienko.communaltransport.model.CommunalTransport;
import com.makeienko.communaltransport.repository.CommunalTransportRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;

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
    public void reportDelaysAndFaults(Long id, String delayReport, Duration estimatedDelay) {

    }

    @Override
    public List<CommunalTransport> getDelaysAndFaults() {
        return null;
    }

    @Override
    public void markRouteAsFavourite(Long id) {

    }

    @Override
    public List<CommunalTransport> getFavouriteRoutes() {
        return null;
    }

    @Override
    public void unmarkRouteAsFavourite(Long id) {

    }
}
