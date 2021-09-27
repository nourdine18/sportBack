package be.businesstrainning.service;

import be.businesstrainning.domaine.*;

import java.util.Set;

public interface PaiementService {

    Paiement addPaiement(Paiement paiement);
    Set<Paiement> findAll();
    Paiement findPaiementByIdClient(Long id);
    Paiement updatePaiement(Paiement paiement);
    void deletePaiement(Long id);

}
