package com.makeienko.communaltransport.service;

import com.makeienko.communaltransport.model.CommunalTransport;

import java.time.Duration;
import java.util.List;

public interface CommunalTransportService {
    CommunalTransport getCommunalRoute(String fromPlace, String toPlace);
    List<CommunalTransport> getAllRoutes();
    void reportDelaysAndFaults(Long id, String delayReport, Duration estimatedDelay);
    List<CommunalTransport> getDelaysAndFaults();
    void markRouteAsFavourite(Long id);
    List<CommunalTransport> getFavouriteRoutes();
    void unmarkRouteAsFavourite(Long id);
}
