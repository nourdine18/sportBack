package be.businesstrainning.service;

import be.businesstrainning.domaine.*;

import java.util.Set;

public interface Type_ClientService {

    TypeClient addType_client(TypeClient type_client);
    Set<TypeClient> findAll();
    TypeClient findByNom(String nom);
    TypeClient updateType_client(TypeClient type_client);
    void deleteType_client(Long id);
}
