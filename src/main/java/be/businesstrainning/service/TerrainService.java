package be.businesstrainning.service;

import be.businesstrainning.domaine.*;

import java.util.Set;

public interface TerrainService {


    Terrain addTerrain(Terrain terrain);
    Set<Terrain> findAll();
    Terrain updateTerrain(Terrain terrain);
    void deleteTerrain(Long id);
}
