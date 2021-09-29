package be.businesstrainning.rest;

import be.businesstrainning.domaine.*;
import be.businesstrainning.repository.IClientRepository;
import be.businesstrainning.repository.ITypeClientRepository;
import be.businesstrainning.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/typeClient")
public class TypeClientRessource {

    @Autowired
    private ITypeClientRepository repository;

    @Autowired
    private IClientRepository clientRepository;

    @Autowired
    private Type_ClientService type_clientService;

    public TypeClientRessource(Type_ClientService type_clientService) {
        this.type_clientService = type_clientService;
    }

//    @PostMapping("/addTypeClient")
//    public String addTypeClient(@RequestBody TypeClient typeClients) {
//        repository.save(typeClients);
//        return "Hi " + typeClients.getNomTypeClient() + " your Registration process successfully completed";
//    }


    @PostMapping("/addTypeClient")
    public String addTypeClient(@RequestBody TypeClient typeClients) {

        TypeClient typeClient = repository.findByNomTypeClient((typeClients.getNomTypeClient()));
        if (typeClient == null){
            repository.save(typeClients);
            return "Hi " + typeClients.getNomTypeClient() + " your Registration process successfully completed";
        }
        else{
            return "ce type de client existe déjà";
        }

    }






    @GetMapping("/findAll")
    public Set<TypeClient> findAll(){
        return type_clientService.findAll();
    }

    @GetMapping("/findByNom/{nomTypeClient}")
    public ResponseEntity<?>findByNom(@PathVariable("nomTypeClient") String nomTypeClient){
        TypeClient typeClient;
        try{
            typeClient = type_clientService.findByNom(nomTypeClient);
            if (typeClient != null){
                return new ResponseEntity<>(typeClient, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Ce type de client n'existe pas !", HttpStatus.CONFLICT);
            }
        }catch (Exception e){
            return new ResponseEntity<>("Error : " + e.getMessage(), HttpStatus.SEE_OTHER);
        }
    }

//    @GetMapping("/findById/{idTypeClient}")
//    public Set<TypeClient> findTypeClientById(@PathVariable("idTypeClient") Long idTypeClient){
//        Set<TypeClient> set = new HashSet<>();
//        TypeClient typeClient= repository.findByIdTypeClient(idTypeClient);
//        set.add(typeClient);
//        System.out.println(typeClient.getNomTypeClient());
//
//        return set;
//    }
    @GetMapping("findById/{idTypeClient}")
    public TypeClient findTypeClientById(@PathVariable("idTypeClient") Long idTypeClient){
        System.out.println(idTypeClient);
        TypeClient typeClient = repository.findByIdTypeClient(idTypeClient);
        return typeClient;
    }

    @PutMapping(path = "updateType_client/{idTypeClient}")
    public ResponseEntity<?> updateType_client(@PathVariable("idTypeClient") Long idTypeClient, @RequestBody TypeClient typeClient){
        TypeClient typeClientList = repository.findByNomTypeClient(typeClient.getNomTypeClient());


        if (idTypeClient != null && typeClientList == null){
            TypeClient typeClientUpdated = type_clientService.updateType_client(typeClient);
            return new ResponseEntity<>(typeClientUpdated,HttpStatus.OK);

        } else {
            return new ResponseEntity<>("Ce type de client n'existe pas", HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/deleteType_client/{idTypeClient}")
    public String deleteType_client(@PathVariable("idTypeClient") Long idTypeClient) {

        TypeClient typeClient =  repository.findByIdTypeClient(idTypeClient);
        List<Client> client = clientRepository.findClientByIdTypeClient(typeClient);
        System.out.println("clieeeent" + client);
        System.out.println(idTypeClient);
        if(client.isEmpty()){
            type_clientService.deleteType_client(idTypeClient);
            return "Le client a été supprimer avec succés";
        }
        else{
            return "Le type client est utilisé par des clients !";

        }


    }
}
