package be.businesstrainning.repository;

import be.businesstrainning.domaine.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface ILocationRepository extends JpaRepository<Location, Long> {

    Location findLocationByIdLocation(Long id);
    Location findLocationByDateLoc(Date dateLoc);
    Location findLocationByDateLocAndHeureDebutAndHeureFin(Date dateLoc, Date heureDeb, Date heureFin);
    Location findLocationByTerrainCollection(Long id);
    Location findLocationByTerrainCollectionAndDateLocAndHeureDebut(Long idTer, Date dateLoc, Date heureDeb);
}
