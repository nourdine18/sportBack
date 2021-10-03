package be.businesstrainning.service;

import be.businesstrainning.domaine.Location;
import be.businesstrainning.repository.IClientRepository;
import be.businesstrainning.repository.ILocationRepository;
import be.businesstrainning.repository.IPaiementRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Service
public class LocationServiceImpl implements LocationService{

    private ILocationRepository iLocationRepository;
    private IClientRepository iClientRepository;
    private IPaiementRepository iPaiementRepository;

    public LocationServiceImpl(ILocationRepository iLocationRepository, IClientRepository iClientRepository, IPaiementRepository iPaiementRepository) {
        this.iLocationRepository = iLocationRepository;
        this.iClientRepository = iClientRepository;
        this.iPaiementRepository = iPaiementRepository;
    }

    @Override
    public Location addLocation(Location location) {
        Location locations = iLocationRepository.findLocationByIdLocation(location.getIdLocation());
        if (locations == null){
            iLocationRepository.save(locations);
        }
        else{
            System.out.println("le client existe déjà");
        }

        return locations;
    }

    @Override
    public Set<Location> findAll() {
        return new HashSet<>(iLocationRepository.findAll());
    }

    @Override
    public Location findLocationById(Long id) {
        Location location = iLocationRepository.findLocationByIdLocation(id);
        return location;
    }

    @Override
    public Location findLocationByDate(Date dateLoc) {
        Location location = iLocationRepository.findLocationByDateLoc(dateLoc);
        return location;
    }

    @Override
    public Location findLocationByDateAndHeureDebutAndFin(Date dateLoc, Date heureDebut, Date heureFin) {
        Location location = iLocationRepository.findLocationByDateLocAndHeureDebutAndHeureFin(dateLoc, heureDebut, heureFin);
        return location;
    }

    @Override
    public Location findLocationByTerrain(Long id) {
        Location location = iLocationRepository.findLocationByTerrainCollection(id);
        return location;
    }

    @Override
    public Location findLocationByTerrainAndDateAndHeureDebut(Long idTer, Date dateLoc, Date heureDebut) {
        Location location = iLocationRepository.findLocationByTerrainCollectionAndDateLocAndHeureDebut(idTer, dateLoc, heureDebut);
        return location;
    }


    @Override
    public Location updateLocation(Location location) {

        Location locationUpdate = iLocationRepository.findLocationByIdLocation(location.getIdLocation());
        if(location.getDateLoc() != null && location.getDateLoc() != locationUpdate.getDateLoc()){
            locationUpdate.setDateLoc(location.getDateLoc());
        }
        if(location.getHeureDebut() != 0 && location.getHeureDebut() != locationUpdate.getHeureDebut()){
            locationUpdate.setHeureDebut(location.getHeureDebut());
        }
        if(location.getHeureFin() != 0 && location.getHeureFin() != locationUpdate.getHeureFin()){
            locationUpdate.setHeureFin(location.getHeureFin());
        }
        if(location.getMontantTotal() != null && location.getMontantTotal() != locationUpdate.getMontantTotal()){
            locationUpdate.setMontantTotal(location.getMontantTotal());
        }
        if(location.getIdClient() != null){
            if(location.getIdClient().getNomClient() != locationUpdate.getIdClient().getNomClient()){
                locationUpdate.getIdClient().setNomClient(location.getIdClient().getNomClient());
            }
            if(location.getIdClient().getPrenomClient() != locationUpdate.getIdClient().getPrenomClient()){
                locationUpdate.getIdClient().setPrenomClient(location.getIdClient().getPrenomClient());
            }
        }
        if(location.getIdPaie() != null){
            if (location.getIdPaie().getMontant() != locationUpdate.getIdPaie().getMontant()){
                locationUpdate.getIdPaie().setMontant(location.getIdPaie().getMontant());
            }
        }

        iLocationRepository.save(locationUpdate);
        return locationUpdate;
    }

    @Override
    public void deleteLocation(Long id) {
        Location locations = iLocationRepository.findLocationByIdLocation(id);
        if(null != locations){
            iLocationRepository.delete(locations);
        }
        else{
            System.out.println("cette location n'existe pas");
        }

    }
}
