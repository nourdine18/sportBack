package be.businesstrainning.service;

import be.businesstrainning.domaine.Terrain;
import be.businesstrainning.repository.ITerrainRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
public class TerrainServiceImpl implements TerrainService{

    private ITerrainRepository iTerrainRepository;

    public TerrainServiceImpl(ITerrainRepository iTerrainRepository) {
        this.iTerrainRepository = iTerrainRepository;
    }

    @Override
    public Terrain addTerrain(Terrain terrain) {
        Terrain terrains = iTerrainRepository.findByIdTerrain(terrain.getIdTerrain());

        if (terrains == null){
            iTerrainRepository.save(terrains);
        }
        else{
            System.out.println("le terrain existe déjà");
        }

        return terrains;
    }



    @Override
    public Set<Terrain> findAll() {
        return new HashSet<>(iTerrainRepository.findAll());
    }

    @Override
    public Terrain updateTerrain(Terrain terrain) {
        Terrain terrains = iTerrainRepository.findByIdTerrain(terrain.getIdTerrain());
        if(terrain.getIdTerrain() != null && terrain.getIdTerrain() != terrains.getIdTerrain()){
            terrains.setIdTerrain(terrain.getIdTerrain());
        }
        iTerrainRepository.save(terrains);
        return terrains;
    }

    @Override
    public void deleteTerrain(Long id) {
        Terrain terrains = iTerrainRepository.findByIdTerrain(id);
        if(null != terrains){
            iTerrainRepository.delete(terrains);
        }
        else{
            System.out.println("ce terrain n'existe pas");
        }
    }
}
