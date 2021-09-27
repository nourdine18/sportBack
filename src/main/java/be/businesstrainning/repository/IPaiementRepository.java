package be.businesstrainning.repository;

import be.businesstrainning.domaine.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.reflect.Type;
import java.util.List;

public interface IPaiementRepository extends JpaRepository<Paiement, Long> {

    Paiement findByIdPaie(Long id);
    Paiement findByIdClient(Long id);
    Paiement findByIdClient_IdClient(Long id);
    List<Paiement> findPaiementByIdTypePaie(TypePaiement idTypePaiement);
}
