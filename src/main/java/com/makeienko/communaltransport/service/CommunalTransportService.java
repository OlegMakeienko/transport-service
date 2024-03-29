package com.makeienko.communaltransport.service;

import com.makeienko.communaltransport.model.CommunalTransport;

import java.util.List;
import java.util.Optional;

public interface CommunalTransportService {
    public CommunalTransport createCommunalRoute(CommunalTransport newRoute);
    CommunalTransport getCommunalRoute(String fromPlace, String toPlace);
    List<CommunalTransport> getAllRoutes();
    Optional<CommunalTransport> findById(Long id);

    void findBestBetweenTransportAndWalking(Long id, String delayReport, String estimatedDelay);

    List<CommunalTransport> getDelaysAndFaults();
    void markRouteAsFavourite(Long id);
    List<CommunalTransport> getFavouriteRoutes();
    void unmarkRouteAsFavourite(Long id);

    List<CommunalTransport> findAllWithDelaysAndFaults();

    Optional<CommunalTransport> getRoute(Long routeId);

    void updateDelayReport(Long routeId, String delayReport, String estimatedDelay);

}
