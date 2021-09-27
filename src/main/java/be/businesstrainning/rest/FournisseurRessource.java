package be.businesstrainning.rest;

import be.businesstrainning.domaine.*;
import be.businesstrainning.repository.IFournisseurRepository;
import be.businesstrainning.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/fournisseur")
public class FournisseurRessource {

    @Autowired
    private IFournisseurRepository repository;

    private FournisseurService fournisseurService;

    public FournisseurRessource(FournisseurService fournisseurService) {
        this.fournisseurService = fournisseurService;
    }
    //    Fournisseur updateFournisseur(Fournisseur fournisseur);
    //    void deleteFournisseur(Long id);

    @PostMapping("/addFournisseur")
    public String addFournisseur(@RequestBody Fournisseur fournisseurs) {
        System.out.println(fournisseurs.getNomFourni());
        List<Fournisseur> fournisseur = repository.findByNomFourni(fournisseurs.getNomFourni());
        System.out.println("taille " + fournisseur.size());
        if (fournisseur.isEmpty()) {
            repository.save(fournisseurs);
            return "Hi " + fournisseurs.getNomFourni() + " your Registration process successfully completed";
        } else {
            return "ce fournisseur existe déjà";
        }

    }


    @GetMapping("/findAll")
    public Set<Fournisseur> findAll() {
        return fournisseurService.findAll();
    }

    @GetMapping("/findFournisseurById/{id_fourni}")
    public Set<Fournisseur> findFournisseurById(@PathVariable("id_fourni") Long id_fourni) {
        Set<Fournisseur> set = new HashSet<>();
        Fournisseur fournisseur = repository.findByIdFourni(id_fourni);
        set.add(fournisseur);
        System.out.println(fournisseur.getEmailFourni());

        return set;
//        try{
//            fournisseur = fournisseurService.findFournisseurById(id_fourni);
//            System.out.println(fournisseur.getEmailFourni());
//            if (fournisseur != null){
//                return fournisseur;
//                //return new ResponseEntity<>(fournisseur, HttpStatus.OK);
//            } else {
//                return null;
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//            return null;
//        }
    }

    @PutMapping(path = "updateFournisseur/{id_fourni}")
    public ResponseEntity<?> updateFournisseur(@PathVariable("id_fourni") Long id_fourni, @RequestBody Fournisseur fournisseur) {
        Fournisseur fournisseurUpdated = fournisseurService.updateFournisseur(fournisseur);
        if (fournisseurUpdated != null) {
            return new ResponseEntity<>(fournisseurUpdated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Ce fournisseur n'existe pas", HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/deleteFournisseur/{id_fourni}")
    public void deleteFournisseur(@PathVariable("id_fourni") Long id_fourni) {
        fournisseurService.deleteFournisseur(id_fourni);
    }

}
