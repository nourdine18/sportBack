package be.businesstrainning.service;

import be.businesstrainning.domaine.Fournisseur;
import be.businesstrainning.repository.IFournisseurRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
public class FournisseurServiceImpl implements FournisseurService{
    private IFournisseurRepository iFournisseurRepository;

    public FournisseurServiceImpl(IFournisseurRepository iFournisseurRepository) {
        this.iFournisseurRepository = iFournisseurRepository;
    }



    @Override
    public Fournisseur addFournisseur(Fournisseur fournisseur) {
        Fournisseur fournisseurs = iFournisseurRepository.findByIdFourni(fournisseur.getIdFourni());
        if (fournisseurs == null){
            iFournisseurRepository.save(fournisseurs);
        }
        else{
            System.out.println("le fournisseur existe déjà");
        }

        return fournisseurs;
    }

    @Override
    public Set<Fournisseur> findAll() {
        return new HashSet<>(iFournisseurRepository.findAll());
    }

    @Override
    public Fournisseur findFournisseurById(Long idFourni) {
        Fournisseur fournisseur = iFournisseurRepository.findByIdFourni(idFourni);
        return fournisseur;
    }

    @Override
    public Fournisseur updateFournisseur(Fournisseur fournisseur) {
        Fournisseur fournisseurUpdate = iFournisseurRepository.findByIdFourni(fournisseur.getIdFourni());
        if(fournisseur.getNomFourni() != null && fournisseur.getNomFourni() != fournisseurUpdate.getNomFourni()){
            fournisseurUpdate.setNomFourni(fournisseur.getNomFourni());
        }
        if(fournisseur.getEmailFourni() != null && fournisseur.getEmailFourni() != fournisseurUpdate.getEmailFourni()){
            fournisseurUpdate.setEmailFourni(fournisseur.getEmailFourni());
        }
        if(fournisseur.getTelFourni() != null && fournisseur.getTelFourni() != fournisseurUpdate.getTelFourni()){
            fournisseurUpdate.setTelFourni(fournisseur.getTelFourni());
        }
        iFournisseurRepository.save(fournisseurUpdate);
        return fournisseurUpdate;
    }

    @Override
    public void deleteFournisseur(Long idFournisseur) {
        Fournisseur fournisseur = iFournisseurRepository.findByIdFourni(idFournisseur);
        if(null != fournisseur){
            iFournisseurRepository.delete(fournisseur);
        }
        else{
            System.out.println("ce fournisseur n'existe pas");
        }
    }
}
