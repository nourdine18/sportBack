package be.businesstrainning.service;

import be.businesstrainning.domaine.*;

import java.util.Set;

public interface MaterielService {


    Materiel addMateriel(Materiel materiel);
    Set<Materiel> findAll();
    Materiel findMaterielByName(String nomMat);
    Materiel updateMateriel(Materiel materiel);
    void deleteMateriel(Long id);
}
