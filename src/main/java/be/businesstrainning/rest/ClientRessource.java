package be.businesstrainning.rest;


import be.businesstrainning.domaine.*;
import be.businesstrainning.repository.IClientRepository;
import be.businesstrainning.repository.ICommuneRepository;
import be.businesstrainning.repository.ITypeClientRepository;
import be.businesstrainning.service.ClientService;
import be.businesstrainning.service.ClientServiceImpl;
import be.businesstrainning.service.CommuneService;
import be.businesstrainning.service.Type_ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/client")
public class ClientRessource {


    @Autowired
    private IClientRepository clientRepository;


    @Autowired
    private ICommuneRepository communeRepository;

    @Autowired
    private ITypeClientRepository typeClientRepository;

    private ClientService clientService;
    private CommuneService communeService;
    private Type_ClientService type_clientService;

    public ClientRessource(ClientService clientService, CommuneService communeService, Type_ClientService type_clientService) {
        this.clientService = clientService;
        this.communeService = communeService;
        this.type_clientService = type_clientService;
    }



    @PostMapping("/addClient")
    public String addClient(@RequestBody Client clients) {




        Client client = clientRepository.findByEmailClient(clients.getEmailClient());

        if (client == null) {

            Commune commune = communeRepository.findByCodePostal(clients.getCodePostal().getCodePostal());


            TypeClient typeClient = typeClientRepository.findByIdTypeClient(clients.getIdTypeClient().getIdTypeClient());

            if (commune != null && typeClient != null) {
                clients.setIdTypeClient(typeClient);
                clients.setCodePostal(commune);
                clientRepository.save(clients);
            } else {
                //throw new bussines exception to indicate that imposible to do this operation (Cest mn pote qui t'as ecris ici, tu dois rajouter un error exceptuion.... tu connais)
            }
            return clients.getNomClient() + " a bien ??t?? ajout??";
        } else {
            return "ce client existe d??j??";
        }


    }

    @GetMapping("/findAll")
    public Set<Client> findAll() {
        return clientService.findAll();
    }

    @GetMapping("/findByIdClient/{idClient}")
    public ResponseEntity<?> findByIdClient(@PathVariable("idClient") Long idClient) {
        Client client;
        try {
            client = clientService.findByIdClient(idClient);
            if (client != null) {
                return new ResponseEntity<>(client, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Ce client n'existe pas !", HttpStatus.CONFLICT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error : " + e.getMessage(), HttpStatus.SEE_OTHER);
        }
    }


    @GetMapping("/findClientByEmail/{emailClient}")
    public ResponseEntity<?> findClientByEmail(@PathVariable("emailClient") String emailClient) {
        Client client;
        try {
            client = clientService.findClientByEmail(emailClient);
            if (client != null) {
                return new ResponseEntity<>(client, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Ce client n'existe pas !", HttpStatus.CONFLICT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error : " + e.getMessage(), HttpStatus.SEE_OTHER);
        }
    }


    @PutMapping(path = "updateClient/{idClient}")
    public ResponseEntity<?> updateClient(@PathVariable("idClient") Long idClient, @RequestBody Client client) {
        Client clientExist = clientRepository.findByEmailClient(client.getEmailClient());
        Commune commune = communeRepository.findByCodePostal(client.getCodePostal().getCodePostal());
        TypeClient typeClient = typeClientRepository.findByIdTypeClient(client.getIdTypeClient().getIdTypeClient());

        if (commune != null && typeClient != null) {
            client.setIdTypeClient(typeClient);
            client.setCodePostal(commune);
        Client clientUpdated = clientService.updateClient(client);
        return new ResponseEntity<>(clientUpdated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Ce client n'existe pas", HttpStatus.BAD_REQUEST);
        }
    }


    @DeleteMapping("/deleteClient/{idClient}")
    public void deleteClient(@PathVariable("idClient") Long idClient) {
        clientService.deleteClient(idClient);
    }


}
