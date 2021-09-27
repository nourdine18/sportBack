package be.businesstrainning.service;

import be.businesstrainning.domaine.*;

import java.util.Date;
import java.util.Set;

public interface LocationService {

    Location addLocation(Location location);
    Set<Location> findAll();
    Location findLocationById(Long id);
    Location findLocationByDate(Date dateLoc);
    Location findLocationByDateAndHeureDebutAndFin(Date dateLoc, Date heureDebut, Date heureFin);
    Location findLocationByTerrain(Long id);
    Location findLocationByTerrainAndDateAndHeureDebut(Long idTer, Date dateLoc, Date heureDebut);
    Location updateLocation(Location location);
    void deleteLocation(Long id);
}
