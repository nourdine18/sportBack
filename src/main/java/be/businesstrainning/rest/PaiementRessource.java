package be.businesstrainning.rest;

import be.businesstrainning.domaine.*;
import be.businesstrainning.service.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/paiement")
public class PaiementRessource {

    private PaiementService paiementService;
    private ClientService clientService;
    private Type_PaiementService typePaiementService;


    public PaiementRessource(PaiementService paiementService, ClientService clientService, Type_PaiementService typePaiementService) {
        this.paiementService = paiementService;
        this.clientService = clientService;
        this.typePaiementService = typePaiementService;
    }

    @PostMapping("/addPaiement")
    public ResponseEntity<?> addPaiement(@RequestBody Paiement paiements){
        Paiement paiement = null;
        try {
            paiement = paiementService.addPaiement(paiements);
            if(paiement != null){
                return new ResponseEntity<>(paiement, HttpStatus.OK);
            } else{
                return new ResponseEntity<>("Ce paiement existe déjà dans la base de donnée !", HttpStatus.CONFLICT);
            }
        }catch (Exception e){
            return new ResponseEntity<>("Error : " + e.getMessage(), HttpStatus.SEE_OTHER);
        }
    }

    @GetMapping("/findAll")
    public Set<Paiement> findAll(){
        return paiementService.findAll();
    }


    @GetMapping("/findPaiementByIdClient/{idClient}")
    public ResponseEntity<?>findPaiementByIdClient(@PathVariable("idClient") Long idClient){
        Paiement paiement;
        try{
            paiement = paiementService.findPaiementByIdClient(idClient);
            if (paiement != null){
                return new ResponseEntity<>(paiement, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Ce paiement n'existe pas !", HttpStatus.CONFLICT);
            }
        }catch (Exception e){
            return new ResponseEntity<>("Error : " + e.getMessage(), HttpStatus.SEE_OTHER);
        }
    }

    @PutMapping(path = "updatePaiement/{id_paie}")
    public ResponseEntity<?> updatePaiement(@PathVariable("id_paie") Long id_paie, @RequestBody Paiement paiement){
        Paiement paiementUpdated = paiementService.updatePaiement(paiement);
        if (paiementUpdated != null){
            return new ResponseEntity<>(paiementUpdated,HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Ce paiement n'existe pas", HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/deletePaiement/{id_paie}")
    public void deletePaiement(@PathVariable("id_paie") Long id_paie){
        paiementService.deletePaiement(id_paie);
    }
}
