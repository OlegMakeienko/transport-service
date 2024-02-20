package com.makeienko.communaltransport.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Duration;
import java.time.LocalDateTime;

@Entity
@Table(name = "communal_transport")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CommunalTransport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fromPlace")
    private String fromPlace;

    @Column(name = "toPlace")
    private String toPlace;

    @Column(name = "departureTime")
    private LocalDateTime departureTime;

    @Column(name = "arrivalTime")
    private LocalDateTime arrivalTime;

    @Column(name = "numberOfTransfers")
    private Integer numberOfTransfers;

    @Column(name = "travelTime")
    private Duration travelTime;

    @Column(name = "walkTime")
    private Duration walkTime;

    @Column(name = "delayReport")
    private String delayReport;

    @Column(name = "estimatedDelay")
    private Duration estimatedDelay;

    @Column(name = "isFavourite")
    private Boolean isFavourite;
}
