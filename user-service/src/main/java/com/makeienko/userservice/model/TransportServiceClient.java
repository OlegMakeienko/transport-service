package com.makeienko.userservice.model;

import com.makeienko.userservice.dto.CommunalTransportDto;
import org.springframework.web.client.RestTemplate;


public class TransportServiceClient {

    private RestTemplate restTemplate = new RestTemplate();
    private String transportServiceUrl = "http://localhost:8089/api/communal-transport";

    public CommunalTransportDto getRoute(Long routeId) {
        return restTemplate.getForObject(transportServiceUrl + "/" + routeId, CommunalTransportDto.class);
    }
}

