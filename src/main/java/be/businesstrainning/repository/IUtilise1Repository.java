package be.businesstrainning.repository;

import be.businesstrainning.domaine.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUtilise1Repository extends JpaRepository<Utilise1, Long> {
    Utilise1 findByLocationAndTerrain(Location location, Terrain terrain);
    Utilise1 findByUtilise1PK(Utilise1PK utilise1PK);
}
