package be.businesstrainning.repository;

import be.businesstrainning.domaine.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMaterielRepository extends JpaRepository<Materiel, Long> {

    Materiel findByNomMat(String nom);
    Materiel findByIdMat(Long id);
    Materiel findMaterielByIdFourni(Long idMateriel);

}
