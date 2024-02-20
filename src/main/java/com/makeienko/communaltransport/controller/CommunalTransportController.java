package com.makeienko.communaltransport.controller;

import com.makeienko.communaltransport.model.CommunalTransport;
import com.makeienko.communaltransport.service.CommunalTransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/communal-transport")
public class CommunalTransportController {

    @Autowired
    private CommunalTransportService communalTransportService;

    @GetMapping("/getCommunalRoute")
    public CommunalTransport getCommunalRoute(@RequestParam String fromPlace, @RequestParam String toPlace) {
        return communalTransportService.getCommunalRoute(fromPlace, toPlace);
    }

    @GetMapping("/getAllRoutes")
    public ResponseEntity<List<CommunalTransport>> getAllRoutes() {
        List<CommunalTransport> routes = communalTransportService.getAllRoutes();
        return routes != null && !routes.isEmpty() ? ResponseEntity.ok(routes) : ResponseEntity.noContent().build();
    }
}
