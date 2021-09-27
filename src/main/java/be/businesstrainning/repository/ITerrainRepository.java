package be.businesstrainning.repository;

import be.businesstrainning.domaine.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITerrainRepository extends JpaRepository<Terrain, Long> {

    Terrain findByIdTerrain(Long id);
}
