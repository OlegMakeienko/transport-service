package com.makeienko.communaltransport;

import com.makeienko.communaltransport.model.CommunalTransport;
import com.makeienko.communaltransport.service.CommunalTransportService;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

public class TestApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(CommunalTransportApplication.class, args);
        CommunalTransportService service = context.getBean(CommunalTransportService.class);
        showAllRoutesInConsole(service);
    }
    private static void showAllRoutesInConsole(CommunalTransportService service) {
        List<CommunalTransport> routes = service.getAllRoutes();
        for (CommunalTransport route : routes) {
            System.out.println(route);
        }
    }
}
