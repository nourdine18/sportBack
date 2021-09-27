package be.businesstrainning.repository;

import be.businesstrainning.domaine.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICommuneRepository extends JpaRepository<Commune, Long> {

    Commune findByCodePostal(Long codePostal);
    List<Commune> findByCommuneName(String communeName);
}
