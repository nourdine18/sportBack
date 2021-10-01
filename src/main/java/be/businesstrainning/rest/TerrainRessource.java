package be.businesstrainning.rest;

import be.businesstrainning.domaine.*;
import be.businesstrainning.repository.ITerrainRepository;
import be.businesstrainning.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/terrain")
public class TerrainRessource {

    @Autowired
    private ITerrainRepository repository;

    private TerrainService terrainService;

    public TerrainRessource(TerrainService terrainService) {
        this.terrainService = terrainService;
    }

    @PostMapping("/addTerrain")
        public String addTerrain(@RequestBody Terrain terrains) {
            repository.save(terrains);
            return terrains.getTypeTerrain() + " a bien été ajouté";
        }

    @GetMapping("/findAll")
    public Set<Terrain> findAll(){
        return terrainService.findAll();
    }


    @PutMapping(path = "updateTerrain/{id_terrain}")
    public ResponseEntity<?> updateTerrain(@PathVariable("id_terrain") Long id_terrain, @RequestBody Terrain terrain){
        Terrain terrainUpdated = terrainService.updateTerrain(terrain);
        if (terrainUpdated != null){
            return new ResponseEntity<>(terrainUpdated,HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Ce terrain n'existe pas", HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/deleteTerrain/{id_terrain}")
    public void deleteTerrain(@PathVariable("id_terrain") Long id_terrain){
        terrainService.deleteTerrain(id_terrain);
    }
}
