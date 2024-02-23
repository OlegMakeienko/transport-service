package com.makeienko.communaltransport.repository;

import com.makeienko.communaltransport.model.CommunalTransport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommunalTransportRepository extends JpaRepository<CommunalTransport, Long> {
    CommunalTransport findByFromPlaceAndToPlace(String fromPlace, String toPlace);
    List<CommunalTransport> findByIsFavouriteTrue();
}

