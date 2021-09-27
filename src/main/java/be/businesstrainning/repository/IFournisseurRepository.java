package be.businesstrainning.repository;

import be.businesstrainning.domaine.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IFournisseurRepository extends JpaRepository<Fournisseur, Long> {

    Fournisseur findByIdFourni(Long id);
    List<Fournisseur> findByNomFourni(String nomFourni);

}
