package be.businesstrainning.service;

import be.businesstrainning.domaine.*;
import be.businesstrainning.repository.ITypeClientRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class Type_ClientServiceImpl implements Type_ClientService {

    private ITypeClientRepository iTypeClientRepository;

    public Type_ClientServiceImpl(ITypeClientRepository iTypeClientRepository) {
        this.iTypeClientRepository = iTypeClientRepository;
    }


    @Override
    public TypeClient addType_client(TypeClient type_client) {
        TypeClient typeClients = iTypeClientRepository.findByNomTypeClient(type_client.getNomTypeClient());
        if (typeClients == null){
            iTypeClientRepository.save(type_client);
        }
        else{
            System.out.println("le type de client existe déjà");
        }

        return type_client;
    }

    @Override
    public HashSet findAll() {
        return new HashSet<>(iTypeClientRepository.findAll());
    }

    @Override
    public TypeClient findByNom(String nom) {
        TypeClient typeClient = iTypeClientRepository.findByNomTypeClient(nom);
        return typeClient;
    }

    @Override
    public TypeClient updateType_client(TypeClient type_client) {
        TypeClient typeClientUpdate = iTypeClientRepository.findByIdTypeClient(type_client.getIdTypeClient());
        if(type_client.getNomTypeClient() != null && type_client.getNomTypeClient() != typeClientUpdate.getNomTypeClient()){
            typeClientUpdate.setNomTypeClient(type_client.getNomTypeClient());
        }
        iTypeClientRepository.save(typeClientUpdate);
        return typeClientUpdate;

    }

    @Override
    public void deleteType_client(Long idTypeClient) {
        TypeClient typeClient = iTypeClientRepository.findByIdTypeClient(idTypeClient);
        if(null != typeClient){
            iTypeClientRepository.delete(typeClient);
        }
        else{
            System.out.println("ce type de paiement n'existe pas");
        }
    }
}
