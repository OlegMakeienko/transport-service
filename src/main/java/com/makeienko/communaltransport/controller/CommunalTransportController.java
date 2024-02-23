package com.makeienko.communaltransport.controller;

import com.makeienko.communaltransport.model.CommunalTransport;
import com.makeienko.communaltransport.request.MarkAsFavouriteRequest;
import com.makeienko.communaltransport.service.CommunalTransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/communal-transport")
public class CommunalTransportController {

    @Autowired
    private CommunalTransportService communalTransportService;

    @GetMapping("/getCommunalRoute")
    public ResponseEntity<CommunalTransport> getCommunalRoute(@RequestParam String fromPlace, @RequestParam String toPlace) {
        CommunalTransport result = communalTransportService.getCommunalRoute(fromPlace, toPlace);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/getAllRoutes")
    public ResponseEntity<List<CommunalTransport>> getAllRoutes() {
        List<CommunalTransport> routes = communalTransportService.getAllRoutes();
        return routes != null && !routes.isEmpty() ? ResponseEntity.ok(routes) : ResponseEntity.noContent().build();
    }

    @GetMapping("/getDelaysAndFaults")
    public ResponseEntity<List<CommunalTransport>> getDelaysAndFaults() {
        List<CommunalTransport> transportsWithDelaysAndFaults = communalTransportService.findAllWithDelaysAndFaults();
        if (!transportsWithDelaysAndFaults.isEmpty()) {
            return new ResponseEntity<>(transportsWithDelaysAndFaults, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getDelaysAndFaults/{routeId}")
    public ResponseEntity<String> getDelaysAndFaultsById(@PathVariable("routeId") Long id) {
        try {
            Optional<CommunalTransport> transport = communalTransportService.findById(id);
            if (transport.isPresent()) {
                CommunalTransport actualTransport = transport.get();
                String delayReport = actualTransport.getDelayReport();
                String estimatedDelay = actualTransport.getEstimatedDelay();
                return new ResponseEntity<>("Delay Report: " + delayReport + ", Estimated Delay: " + estimatedDelay, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("No CommunalTransport found with id: " + id, HttpStatus.NOT_FOUND);
            }
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getFavoriteRoutes")
    public ResponseEntity<List<CommunalTransport>> getFavouriteRoutes() {
        List<CommunalTransport> transportsWithFavoriteRoutes = communalTransportService.getFavouriteRoutes();
        if(!transportsWithFavoriteRoutes.isEmpty()) {
            return new ResponseEntity<>(transportsWithFavoriteRoutes, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    @PostMapping("/markRouteAsFavourite")
    public ResponseEntity<Void> markRouteAsFavourite(@RequestBody MarkAsFavouriteRequest request) {
        if (request.getIsFavourite()) {
            communalTransportService.markRouteAsFavourite(request.getRouteId());
        } else {
            communalTransportService.unmarkRouteAsFavourite(request.getRouteId());
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
