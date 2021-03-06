package be.businesstrainning.rest;

import be.businesstrainning.domaine.*;
import be.businesstrainning.repository.IPaiementRepository;
import be.businesstrainning.repository.ITypePaiementRepository;
import be.businesstrainning.service.*;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/typePaiement")
public class TypePaiementRessource {

    @Autowired
    private ITypePaiementRepository repository;

    @Autowired
    private IPaiementRepository paiementRepository;

    private Type_PaiementService typePaiementService;

    public TypePaiementRessource(Type_PaiementService typePaiementService) {
        this.typePaiementService = typePaiementService;
    }

    @PostMapping("/addTypePaiement")
    public String addTypePaiement(@RequestBody TypePaiement typePaiements) {
        TypePaiement typePaiement = repository.findByNomTypePaiement(typePaiements.getNomTypePaiement());
        if (typePaiement == null){
            repository.save(typePaiements);
            return typePaiements.getNomTypePaiement() + " a bien été ajouté";
        }
        else{
            return "ce type de paiement existe déjà";
        }
    }

    @GetMapping("findById/{idTypePaiement}")
    public TypePaiement findTypePaiementById(@PathVariable("idTypePaiement") Long idTypePaiement){
        System.out.println(idTypePaiement);
        TypePaiement typePaiement = repository.findByIdTypePaie(idTypePaiement);
        return typePaiement;
    }


    @GetMapping("/findAll")
    public Set<TypePaiement> findAll(){
        return typePaiementService.findAll();
    }

    @GetMapping("/findByNom/{nomPaie}")
    public ResponseEntity<?>findByNom(@PathVariable("nomTypePaiement") String nomTypePaiement){
        TypePaiement typePaiement;
        try{
            typePaiement = typePaiementService.findByNomTypePaiement(nomTypePaiement);
            if (typePaiement != null){
                return new ResponseEntity<>(typePaiement, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Ce type de paiement n'existe pas !", HttpStatus.CONFLICT);
            }
        }catch (Exception e){
            return new ResponseEntity<>("Error : " + e.getMessage(), HttpStatus.SEE_OTHER);
        }
    }

    @PutMapping(path = "updateTypePaiement/{idTypePaiement}")
    public ResponseEntity<?> updateType_paiement(@PathVariable("idTypePaiement") Long idTypePaiement, @RequestBody TypePaiement typePaiement){
        typePaiement.setIdTypePaie(idTypePaiement);
        TypePaiement typePaiement1 = repository.findByNomTypePaiement(typePaiement.getNomTypePaiement());
        if (typePaiement != null && typePaiement1 == null){
            TypePaiement typePaiementUpdated = typePaiementService.updateType_paiement(typePaiement);
            return new ResponseEntity<>(typePaiementUpdated,HttpStatus.OK);

        } else {
            return new ResponseEntity<>("Ce type de paiement n'existe pas", HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/deleteType_paiement/{idTypePaie}")
    public String deleteType_paiement(@PathVariable("idTypePaie") Long idTypePaie){

        TypePaiement typePaiement =  repository.findByIdTypePaie(idTypePaie);
        List<Paiement> paiement = paiementRepository.findPaiementByIdTypePaie(typePaiement);
        System.out.println("paiement" + paiement);
        System.out.println(idTypePaie);
        if(paiement.isEmpty()){
            typePaiementService.deleteType_paiement(idTypePaie);
            return "Le type de paiement a été supprimer avec succés";
        }
        else{
            return "Le type de paiement est utilisé par des clients !";

        }

    }
}
