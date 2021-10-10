package be.businesstrainning.service;

import be.businesstrainning.domaine.Client;
import be.businesstrainning.domaine.Utilise2;
import be.businesstrainning.repository.IUtilise2Repository;

import java.util.HashSet;
import java.util.Set;

public class Utilise2ServiceImpl implements Utilise2Service{
    private IUtilise2Repository iUtilise2Repository;
    private Utilise2Service utilise2Service;

    public Utilise2ServiceImpl(IUtilise2Repository iUtilise2Repository, Utilise2Service utilise2Service) {
        this.iUtilise2Repository = iUtilise2Repository;
        this.utilise2Service = utilise2Service;
    }

    @Override
    public Utilise2 addUtilise2(Utilise2 utilise2) {
        iUtilise2Repository.save(utilise2);
        return utilise2;
    }

    @Override
    public Set<Utilise2> findAll() {
        return new HashSet<>(iUtilise2Repository.findAll());
    }

    @Override
    public Utilise2 updateUtilise2(Utilise2 utilise2) {
        Utilise2 utilise2Update = iUtilise2Repository.findByLocationAndMateriel(utilise2.getLocation(), utilise2.getMateriel());
        return utilise2Update;
    }


}
