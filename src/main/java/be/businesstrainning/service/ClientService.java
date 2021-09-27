package be.businesstrainning.service;

import be.businesstrainning.domaine.*;

import java.util.*;

public interface ClientService {

    Client addClient(Client client);
    Set<Client> findAll();
    Client findByIdClient(Long idClient);
    Client findClientByEmail(String email);
    Client updateClient(Client client);
    void deleteClient(Long idClient);

}
