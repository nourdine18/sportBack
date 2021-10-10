package be.businesstrainning.repository;

import be.businesstrainning.domaine.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.HashSet;

public interface ILocationRepository extends JpaRepository<Location, Long> {

    HashSet<Location> findAllByOrderByIdLocationAsc();
    Location findLocationByIdLocationOrderByIdLocation(Long idLocation);
    Location findLocationByIdLocation(Long id);
    HashSet<Location> findLocationByDateLoc(Date dateLoc);
    Location findLocationByDateLocAndHeureDebutAndHeureFin(Date dateLoc, int heureDeb, int heureFin);
    Location findLocationByTerrainCollection(Long id);
    Location findLocationByTerrainCollectionAndDateLocAndHeureDebut(Long idTer, Date dateLoc, Date heureDeb);
}
