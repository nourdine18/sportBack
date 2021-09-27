package be.businesstrainning.repository;

import be.businesstrainning.domaine.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITypePaiementRepository extends JpaRepository<TypePaiement, Long> {

    TypePaiement findByIdTypePaie(Long id);
    TypePaiement findByNomTypePaiement(String nomTypePaiement);
}
