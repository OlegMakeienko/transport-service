package com.makeienko.communaltransport.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "common_routes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommonRoute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "individual_route_start")
    private String individualRouteStart;

    @Column(name = "communal_route_finish")
    private String communalTransportFinish;
}
