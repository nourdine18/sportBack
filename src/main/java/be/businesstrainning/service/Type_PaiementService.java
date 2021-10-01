package be.businesstrainning.service;

import be.businesstrainning.domaine.*;

import java.util.Set;

public interface Type_PaiementService {

    TypePaiement addType_paiement(TypePaiement type_paiement);
    Set<TypePaiement> findAll();
    TypePaiement findByNomTypePaiement(String nomTypePaiement);
    TypePaiement updateType_paiement(TypePaiement type_paiement);
    void deleteType_paiement(Long id);
}
