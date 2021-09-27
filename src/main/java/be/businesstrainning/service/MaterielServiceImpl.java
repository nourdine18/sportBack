package be.businesstrainning.service;

import be.businesstrainning.domaine.Materiel;
import be.businesstrainning.repository.IFournisseurRepository;
import be.businesstrainning.repository.IMaterielRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
public class MaterielServiceImpl implements MaterielService{

    private IMaterielRepository iMaterielRepository;
    private IFournisseurRepository iFournisseurRepository;

    public MaterielServiceImpl(IMaterielRepository iMaterielRepository, IFournisseurRepository iFournisseurRepository) {
        this.iMaterielRepository = iMaterielRepository;
        this.iFournisseurRepository = iFournisseurRepository;
    }

    @Override
    public Materiel addMateriel(Materiel materiel) {
        Materiel materiels = iMaterielRepository.findByIdMat(materiel.getIdMat());
        if (materiels == null){
            iMaterielRepository.save(materiels);
        }
        else{
            System.out.println("le matériel existe déjà");
        }

        return materiels;
    }

    @Override
    public Set<Materiel> findAll() {
        return new HashSet<>(iMaterielRepository.findAll());
    }

    @Override
    public Materiel findMaterielByName(String nomMat) {
        Materiel materiel = iMaterielRepository.findByNomMat(nomMat);
        return materiel;
    }



    @Override
    public Materiel updateMateriel(Materiel materiel) {
        Materiel materielUpdate = iMaterielRepository.findByIdMat(materiel.getIdMat());
        if(materiel.getStock() != null && materiel.getStock() != materielUpdate.getStock()){
            materielUpdate.setStock(materiel.getStock());
        }
        if(materiel.getNomMat() != null && materiel.getNomMat() != materielUpdate.getNomMat()){
            materielUpdate.setNomMat(materiel.getNomMat());
        }
        if(materiel.getPrixUnitaire() != null && materiel.getPrixUnitaire() != materielUpdate.getPrixUnitaire()){
            materielUpdate.setPrixUnitaire(materiel.getPrixUnitaire());
        }
        if(materiel.getIdFourni() != null){
            if (materiel.getIdFourni().getNomFourni() != materielUpdate.getIdFourni().getNomFourni()) {
                materielUpdate.getIdFourni().setNomFourni(materiel.getIdFourni().getNomFourni());
            }
        }
        iMaterielRepository.save(materielUpdate);
        return materielUpdate;
    }

    @Override
    public void deleteMateriel(Long id) {
        Materiel materiel = iMaterielRepository.findByIdMat(id);
        if(null != materiel){
            iMaterielRepository.delete(materiel);
        }
        else{
            System.out.println("ce matériel n'existe pas");
        }

    }
}