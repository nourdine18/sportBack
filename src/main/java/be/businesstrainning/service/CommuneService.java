package be.businesstrainning.service;

import be.businesstrainning.domaine.*;

import java.util.Set;

public interface CommuneService {


    Commune addCommune(Commune commune);
    Set<Commune> findAll();
    Commune findByCodePostal(Long code_postal);
    Commune updateCommune(Commune commune);
    void deleteCommune(Long code_postal);
}
