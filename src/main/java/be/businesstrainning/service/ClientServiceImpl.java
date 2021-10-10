package be.businesstrainning.service;


import be.businesstrainning.domaine.Client;
import be.businesstrainning.domaine.Commune;
import be.businesstrainning.domaine.TypeClient;
import be.businesstrainning.repository.IClientRepository;
import be.businesstrainning.repository.ICommuneRepository;
import be.businesstrainning.repository.ITypeClientRepository;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.*;


@Service
public class ClientServiceImpl implements ClientService {
    private IClientRepository iClientRepository;
    private CommuneService communeService;
    private Type_ClientService type_clientService;


    public ClientServiceImpl(IClientRepository iClientRepository, CommuneService communeService, Type_ClientService type_clientService) {
        this.iClientRepository = iClientRepository;
        this.communeService = communeService;
        this.type_clientService = type_clientService;
    }

    @Override
    public Client addClient(Client client) {
        Commune communeTest = communeService.findByCodePostal(client.getCodePostal().getCodePostal());
        if (communeTest == null) {
            communeTest = communeService.addCommune(client.getCodePostal());
        }
        TypeClient typeClients = type_clientService.findByNom(client.getIdTypeClient().getNomTypeClient());
        if (typeClients == null) {
            typeClients = type_clientService.addType_client(client.getIdTypeClient());
        }
        iClientRepository.save(client);


        return client;
    }

    @Override
    public Set<Client> findAll() {
        return new HashSet<>(iClientRepository.findAll());
    }

    @Override
    public Client findByIdClient(Long idClient) {
        Client client = iClientRepository.findByIdClient(idClient);
        return client;
    }

    @Override
    public Client findClientByEmail(String email) {
        Client client = iClientRepository.findByEmailClient(email);
        return client;
    }



    @Override
    public Client updateClient(Client client) {
        Client clientUpdate = iClientRepository.findByIdClient(client.getIdClient());
        if(client.getNomClient() != null && client.getNomClient() != clientUpdate.getNomClient()){
            clientUpdate.setNomClient(client.getNomClient());
        }
        if(client.getPrenomClient() != null && client.getPrenomClient() != clientUpdate.getPrenomClient()){
            clientUpdate.setPrenomClient(client.getPrenomClient());
        }
        if(client.getTelClient() != null && client.getTelClient() != clientUpdate.getTelClient()){
            clientUpdate.setTelClient(client.getTelClient());
        }
        if(client.getEmailClient() != null && client.getEmailClient() != clientUpdate.getEmailClient()){
            clientUpdate.setEmailClient(client.getEmailClient());
        }
        if(client.getAdresseClient() != null && client.getAdresseClient() != clientUpdate.getAdresseClient()){
            clientUpdate.setAdresseClient(client.getAdresseClient());
        }
        if(client.getCodePostal() != null) {
            if (client.getCodePostal().getCodePostal() != clientUpdate.getCodePostal().getCodePostal()) {
                clientUpdate.setCodePostal(client.getCodePostal());
            }
        }
        if(client.getIdTypeClient() != null){
            if(client.getIdTypeClient().getNomTypeClient() != clientUpdate.getIdTypeClient().getNomTypeClient()){
                clientUpdate.setIdTypeClient(client.getIdTypeClient());
            }
        }
        iClientRepository.save(clientUpdate);
        return clientUpdate;
    }


    @Override
    public void deleteClient(Long idClient) {
        Client clients = iClientRepository.findByIdClient(idClient);
        if(null != clients){
            iClientRepository.delete(clients);
        }
        else{
            System.out.println("ce client n'existe pas");
        }

    }
}
