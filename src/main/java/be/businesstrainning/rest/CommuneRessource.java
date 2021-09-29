package be.businesstrainning.rest;
import be.businesstrainning.domaine.*;
import be.businesstrainning.repository.ICommuneRepository;
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
@RequestMapping("/commune")



public class CommuneRessource {

    @Autowired
    private ICommuneRepository repository;

    private CommuneService communeService;

    public CommuneRessource(CommuneService communeService) {
        this.communeService = communeService;
    }

    @PostMapping("/addCommune")
    public String addCommune(@RequestBody Commune communes) {

        Commune commune = repository.findByCodePostal(communes.getCodePostal());
        if (commune == null){
            repository.save(communes);
            return "Hi " + communes.getCodePostal() + " your Registration process successfully completed";
        }
        else{
            return "ce code postal existe déjà";
        }
    }





    @GetMapping("/findAll")
    public Set<Commune> findAll(){
        return communeService.findAll();
    }

//    @GetMapping("/findByCodePostal/{code_postal}")
//    public ResponseEntity<?>findByCodePostal(@PathVariable("code_postal") Long code_postal){
//        Commune commune;
//        try{
//            commune = communeService.findByCodePostal(code_postal);
//            if (commune != null){
//                return new ResponseEntity<>(commune, HttpStatus.OK);
//            } else {
//                return new ResponseEntity<>("Cette commune n'existe pas !", HttpStatus.CONFLICT);
//            }
//        }catch (Exception e){
//            return new ResponseEntity<>("Error : " + e.getMessage(), HttpStatus.SEE_OTHER);
//        }
//    }


    @GetMapping("/findByCodePostal/{codePostal}")
    public Commune findByCodePostal(@PathVariable("codePostal")Long codePostal){
        System.out.println(codePostal);
        Commune commune = repository.findByCodePostal(codePostal);

        return commune;
    }



    @PutMapping(path = "updateCommune/{code_postal}")
    public ResponseEntity<?> updateCommune(@PathVariable("code_postal") Long code_postal, @RequestBody Commune commune){
        List<Commune> communeList = repository.findByCommuneName(commune.getCommuneName());
        System.out.println(communeList.size());
        if (commune != null && (communeList.isEmpty())){
            Commune communeUpdated = communeService.updateCommune(commune);
            return new ResponseEntity<>(communeUpdated,HttpStatus.OK);

        } else {
            return new ResponseEntity<>("Cette commune n'existe pas", HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/deleteCommune/{code_postal}")
    public void deleteCommune(@PathVariable("code_postal") Long code_postal){
        communeService.deleteCommune(code_postal);
    }


}
