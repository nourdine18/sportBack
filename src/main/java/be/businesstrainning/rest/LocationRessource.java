package be.businesstrainning.rest;

import be.businesstrainning.domaine.*;
import be.businesstrainning.service.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Date;
import java.util.Set;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/location")
public class LocationRessource {

    private LocationService locationService;
    private ClientService clientService;
    private PaiementService paiementService;

    public LocationRessource(LocationService locationService, ClientService clientService, PaiementService paiementService) {
        this.locationService = locationService;
        this.clientService = clientService;
        this.paiementService = paiementService;
    }


    @PostMapping("/addLocation")
    public ResponseEntity<?> addLocation(@RequestBody Location locations){
        Location location = null;
        try {
            location = locationService.addLocation(locations);
            if(location != null){
                return new ResponseEntity<>(location, HttpStatus.OK);
            } else{
                return new ResponseEntity<>("Cette location existe déjà dans la base de donnée !", HttpStatus.CONFLICT);
            }
        }catch (Exception e){
            return new ResponseEntity<>("Error : " + e.getMessage(), HttpStatus.SEE_OTHER);
        }
    }

    @GetMapping("/findAll")
    public Set<Location> findAll(){
        return locationService.findAll();
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
    public ResponseEntity<?>findLocationByDate(@PathVariable("date_loc") Date date_loc){
        Location location;
        try{
            location = locationService.findLocationByDate(date_loc);
            if (location != null){
                return new ResponseEntity<>(location, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Cette location n'existe pas !", HttpStatus.CONFLICT);
            }
        }catch (Exception e){
            return new ResponseEntity<>("Error : " + e.getMessage(), HttpStatus.SEE_OTHER);
        }
    }


    @GetMapping("/findLocationByDateAndHeureDebutAndFin/{dateLoc}/{heureDebut}/{heureFin}")
    public ResponseEntity<?>findLocationByDateAndHeureDebutAndFin(@PathVariable("dateLoc") Date dateLoc, @PathVariable("heureDebut") Date heureDebut, @PathVariable("heureFin") Date heureFin){
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
        locationService.deleteLocation(id_location);
    }
}
