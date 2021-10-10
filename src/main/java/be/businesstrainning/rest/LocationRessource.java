package be.businesstrainning.rest;

import be.businesstrainning.domaine.*;
import be.businesstrainning.repository.*;
import be.businesstrainning.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/location")
public class LocationRessource {

    @Autowired
    private ILocationRepository repository;
    @Autowired
    private ITerrainRepository repositoryTerrain;
    @Autowired
    private IMaterielRepository repositoryMateriel;
    @Autowired
    private IClientRepository repositoryClient;
    @Autowired
    private IPaiementRepository repositoryPaiement;

    private LocationService locationService;
    private ClientService clientService;
    private PaiementService paiementService;

    public LocationRessource(LocationService locationService, ClientService clientService, PaiementService paiementService) {
        this.locationService = locationService;
        this.clientService = clientService;
        this.paiementService = paiementService;
    }


    @PostMapping("/addLocation")
    public String addLocation(@RequestBody Location locations) {
        if(locations.getIdPaie() != null) {
            Paiement paiement = locations.getIdPaie();
            Paiement paiementSaved = repositoryPaiement.save(paiement);
            locations.setIdPaie(paiementSaved);
        }
        System.out.println(locations.getDateLoc()+ "bouuuuuuuuuuuuuuuuuuuuu");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.FRANCE);
        //Date date = formatter.parse(date_loc);
        System.out.println();
        Utilise1 utilise1 = new Utilise1();
        utilise1.setLocation(locations);
        for ( Terrain terrain: locations.getTerrainCollection()) {
            utilise1.setTerrain(terrain);
        }

        Utilise2 utilise2 = new Utilise2();
        utilise2.setLocation(locations);
        for ( Materiel materiel: locations.getMaterielCollection()) {
            utilise2.setMateriel(materiel);
        }
        repository.save(locations);
        return "ce client existe déjà";
        }

    @GetMapping("/findAll")
    public Set<Location> findAll(){
        Set<Location> location = locationService.findAll(Sort.by(Sort.Direction.ASC, "id_location"));
        for(Location l:location){
            for (Materiel m:l.getMaterielCollection()
                 ) {
                System.out.println(m);
            }
            System.out.println(l.getMaterielCollection().size());
        }
        return locationService.findAll(Sort.by(Sort.Direction.ASC, "date_loc"));
    }


    @GetMapping("/findLocationById/{id_location}")
    public ResponseEntity<?>findLocationById(@PathVariable("id_location") Long id_location){
        Location location;
        try{
            location = locationService.findLocationById(id_location);
            if (location != null){
                return new ResponseEntity<>(location, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Cette location n'existe pas !", HttpStatus.CONFLICT);
            }
        }catch (Exception e){
            return new ResponseEntity<>("Error : " + e.getMessage(), HttpStatus.SEE_OTHER);
        }
    }

    @GetMapping("/findLocationByDate/{date_loc}")
    public ResponseEntity<?>findLocationByDate(@PathVariable("date_loc") String date_loc) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.FRANCE);
        Date date = formatter.parse(date_loc);
        HashSet<Location> location;
        System.out.println(date);
        try{
            System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            location = locationService.findLocationByDateLoc(date);
            System.out.println(location + " ----------------------------------------------- ");
            if (location != null){
                return new ResponseEntity<>(location, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Cette location n'existe pas !", HttpStatus.CONFLICT);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Error : " + e.getMessage(), HttpStatus.SEE_OTHER);
        }

//        return null;
    }


    @GetMapping("/findLocationByDateAndHeureDebutAndFin/{dateLoc}/{heureDebut}/{heureFin}")
    public ResponseEntity<?>findLocationByDateAndHeureDebutAndFin(@PathVariable("dateLoc") Date dateLoc, @PathVariable("heureDebut") int heureDebut, @PathVariable("heureFin") int heureFin){
        Location location;
        try{
            location = locationService.findLocationByDateAndHeureDebutAndFin(dateLoc, heureDebut, heureFin);
            if (location != null){
                return new ResponseEntity<>(location, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Cette location n'existe pas !", HttpStatus.CONFLICT);
            }
        }catch (Exception e){
            return new ResponseEntity<>("Error : " + e.getMessage(), HttpStatus.SEE_OTHER);
        }
    }

    @GetMapping("/findLocationByTerrain/{terrainCollection}")
    public ResponseEntity<?>findLocationByTerrain(@PathVariable("terrainCollection") Long terrainCollection){
        Location location;
        try{
            location = locationService.findLocationByTerrain(terrainCollection);
            if (location != null){
                return new ResponseEntity<>(location, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Cette location n'existe pas !", HttpStatus.CONFLICT);
            }
        }catch (Exception e){
            return new ResponseEntity<>("Error : " + e.getMessage(), HttpStatus.SEE_OTHER);
        }
    }

    @GetMapping("/findLocationByTerrainAndDateAndHeureDebut/{terrainCollection}/{dateLoc}/{heureDebut}")
    public ResponseEntity<?>findLocationByTerrainAndDateAndHeureDebut(@PathVariable("terrainCollection") Long terrainCollection, @PathVariable("dateLoc") Date dateLoc, @PathVariable("heureDebut") Date heureDebut){
        Location location;
        try{
            location = locationService.findLocationByTerrainAndDateAndHeureDebut(terrainCollection, dateLoc, heureDebut);
            if (location != null){
                return new ResponseEntity<>(location, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Cette location n'existe pas !", HttpStatus.CONFLICT);
            }
        }catch (Exception e){
            return new ResponseEntity<>("Error : " + e.getMessage(), HttpStatus.SEE_OTHER);
        }
    }

    @PutMapping(path = "updateLocation/{id_location}")
    public ResponseEntity<?> updateLocation(@PathVariable("id_location") Long id_location, @RequestBody Location location){
        Location locationUpdated = locationService.updateLocation(location);
        if (locationUpdated != null){
            return new ResponseEntity<>(locationUpdated,HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Cette location n'existe pas", HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/deleteLocation/{id_location}")
    public void deleteLocation(@PathVariable("id_location") Long id_location){
        Location location = locationService.findLocationById(id_location);
        if(location.getIdPaie() != null) {
            paiementService.deletePaiement(location.getIdPaie().getIdPaie());
        }
        locationService.deleteLocation(id_location);
    }
}
