package be.businesstrainning.service;

import be.businesstrainning.domaine.Utilise1;

import java.util.Set;

public interface Utilise1Service {

    Utilise1 addUtilise1(Utilise1 utilise1);
    Set<Utilise1> findAll();
    Utilise1 updateUtilise1(Utilise1 utilise1);
}
