package be.businesstrainning.service;

import be.businesstrainning.domaine.*;
import org.springframework.data.domain.Sort;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public interface LocationService {

    Location addLocation(Location location);
    HashSet<Location> findAll(Sort date_loc);
    Location findLocationById(Long id);
    HashSet<Location> findLocationByDateLoc(Date dateLocation);
    Location findLocationByDateAndHeureDebutAndFin(Date dateLoc, int heureDebut, int heureFin);
    Location findLocationByTerrain(Long id);
    Location findLocationByTerrainAndDateAndHeureDebut(Long idTer, Date dateLoc, Date heureDebut);
    Location updateLocation(Location location);
    void deleteLocation(Long id);
}
