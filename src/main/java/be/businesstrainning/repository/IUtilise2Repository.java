package be.businesstrainning.repository;

import be.businesstrainning.domaine.*;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IUtilise2Repository extends JpaRepository<Utilise2, Long> {
    Utilise2 findByLocationAndMateriel(Location location, Materiel materiel);
    Utilise2 findByUtilise2PK(Utilise2PK utilise2PK);
}

