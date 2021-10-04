package be.businesstrainning.service;

import be.businesstrainning.domaine.Utilise1;
import be.businesstrainning.repository.IUtilise1Repository;

import java.util.HashSet;
import java.util.Set;

public class Utilise1ServiceImpl implements Utilise1Service{
    private IUtilise1Repository iUtilise1Repository;
    private Utilise1Service utilise1Service;

    public Utilise1ServiceImpl(IUtilise1Repository iUtilise1Repository, Utilise1Service utilise1Service) {
        this.iUtilise1Repository = iUtilise1Repository;
        this.utilise1Service = utilise1Service;
    }

    @Override
    public Utilise1 addUtilise1(Utilise1 utilise1) {
        iUtilise1Repository.save(utilise1);
        return utilise1;
    }

    @Override
    public Set<Utilise1> findAll() {
        return new HashSet<>(utilise1Service.findAll());
    }

    @Override
    public Utilise1 updateUtilise1(Utilise1 utilise1) {
        return null;
    }



}
