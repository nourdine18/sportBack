package be.businesstrainning.rest;
import be.businesstrainning.domaine.*;
import be.businesstrainning.repository.IFournisseurRepository;
import be.businesstrainning.repository.IMaterielRepository;
import be.businesstrainning.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/materiel")
public class MaterielRessource {

    @Autowired
    private IMaterielRepository repository;

    @Autowired// notice  Autowiring n'est plus du spring best practice  use construct is the best
    private IFournisseurRepository fournisseurRepository;

    private MaterielService materielService;

    public MaterielRessource(MaterielService materielService) {
        this.materielService = materielService;
    }

    //Materiel findMaterielByFournisseur(Long id);

    @PostMapping("/addMateriel")
    public String addMateriel(@RequestBody Materiel materiels) {
        // ON A MMODIFIER CETTE METHODE donc enfaite nour : On ajout un materiel tout simplement avec son n° id et ensuite on utilise findByIdFourni
             Fournisseur fournisseur= fournisseurRepository.findByIdFourni(materiels.getIdFourni().getIdFourni());
             if(fournisseur !=null){
                 materiels.setIdFourni(fournisseur);
                repository.save(materiels);
             }else{
                 //throw new bussines exception to indicate that imposible to do this operation (Cest mn pote qui t'as ecris ici, tu dois rajouter un error exceptuion.... tu connais)
             }
        return "Hi " + materiels.getNomMat() + " your Registration process successfully completed";
    }

    @GetMapping("/findAll")
    public Set<Materiel> findAll(){
        return materielService.findAll();
    }

    @GetMapping("/findMaterielByName/{nom_mat}")
    public ResponseEntity<?>findMaterielByName(@PathVariable("nom_mat") String nom_mat){
        Materiel materiel;
        try{
            materiel = materielService.findMaterielByName(nom_mat);
            if (materiel != null){
                return new ResponseEntity<>(materiel, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Ce matériel n'existe pas !", HttpStatus.CONFLICT);
            }
        }catch (Exception e){
            return new ResponseEntity<>("Error : " + e.getMessage(), HttpStatus.SEE_OTHER);
        }
    }


    @GetMapping("/findMaterielByFournisseur/{nom_mat}")
    public ResponseEntity<?>findMaterielByFournisseur(@PathVariable("nom_mat") String nom_mat){
        Materiel materiel;
        try{
            materiel = materielService.findMaterielByName(nom_mat);
            if (materiel != null){
                return new ResponseEntity<>(materiel, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Ce matériel n'existe pas !", HttpStatus.CONFLICT);
            }
        }catch (Exception e){
            return new ResponseEntity<>("Error : " + e.getMessage(), HttpStatus.SEE_OTHER);
        }
    }


    @PutMapping(path = "updateMateriel/{id_mat}")
    public ResponseEntity<?> updateMateriel(@PathVariable("id_mat") Long id_Mat, @RequestBody Materiel materiel){
        Materiel materielUpdated = materielService.updateMateriel(materiel);
        if (materielUpdated != null){
            return new ResponseEntity<>(materielUpdated,HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Ce matériel n'existe pas", HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/deleteMateriel/{id_mat}")
    public void deleteMateriel(@PathVariable("id_mat") Long id_mat){
        materielService.deleteMateriel(id_mat);
    }

}
