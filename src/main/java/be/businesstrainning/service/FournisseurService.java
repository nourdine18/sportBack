package be.businesstrainning.service;

import be.businesstrainning.domaine.*;

import java.util.Set;

public interface FournisseurService {


    Fournisseur addFournisseur(Fournisseur fournisseur);
    Set<Fournisseur> findAll();
    Fournisseur findFournisseurById(Long idFourni);
    Fournisseur updateFournisseur(Fournisseur fournisseur);
    void deleteFournisseur(Long idFournisseur);
}
