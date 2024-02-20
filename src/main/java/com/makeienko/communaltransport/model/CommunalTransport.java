package com.makeienko.communaltransport.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @Column(name = "from_place")
    private String fromPlace;

    @Column(name = "to_place")
    private String toPlace;

    @Column(name = "departure_time")
    private String departureTime;

    @Column(name = "arrival_time")
    private String arrivalTime;

    @Column(name = "number_of_transfers")
    private Integer numberOfTransfers;

    @Column(name = "travel_time")
    private String travelTime;

    @Column(name = "walk_time")
    private String walkTime;

    @Column(name = "delay_report")
    private String delayReport;

    @Column(name = "estimated_delay")
    private String estimatedDelay;

    @Column(name = "is_favourite")
    private Boolean isFavourite;

    @Override
    public String toString() {
        return "CommunalTransport{" +
                "id=" + id +
                ", fromPlace='" + fromPlace + '\'' +
                ", toPlace='" + toPlace + '\'' +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                ", numberOfTransfers=" + numberOfTransfers +
                ", travelTime=" + travelTime +
                ", walkTime=" + walkTime +
                ", delayReport='" + delayReport + '\'' +
                ", estimatedDelay=" + estimatedDelay +
                ", isFavourite=" + isFavourite +
                '}';
    }
}
