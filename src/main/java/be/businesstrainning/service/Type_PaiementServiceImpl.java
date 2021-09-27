package be.businesstrainning.service;


import be.businesstrainning.domaine.*;
import be.businesstrainning.repository.ITypePaiementRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class Type_PaiementServiceImpl implements Type_PaiementService{

    private ITypePaiementRepository iTypePaiementRepository;

    public Type_PaiementServiceImpl(ITypePaiementRepository iTypePaiementRepository) {
        this.iTypePaiementRepository = iTypePaiementRepository;
    }


    @Override
    public TypePaiement addType_paiement(TypePaiement type_paiement) {
        TypePaiement typePaiements = iTypePaiementRepository.findByIdTypePaie(type_paiement.getIdTypePaie());
        if (typePaiements == null){
            iTypePaiementRepository.save(typePaiements);
        }
        else{
            System.out.println("le type de paiement existe déjà");
        }

        return typePaiements;
    }

    @Override
    public Set<TypePaiement> findAll() {
        return new HashSet<>(iTypePaiementRepository.findAll());
    }

    @Override
    public TypePaiement findByNomTypePaiement(String nomTypePaiement) {
        TypePaiement typePaiement = iTypePaiementRepository.findByNomTypePaiement(nomTypePaiement);
        return typePaiement;
    }

    @Override
    public TypePaiement updateType_paiement(TypePaiement type_paiement) {
        TypePaiement typePaiementUpdate = iTypePaiementRepository.findByIdTypePaie(type_paiement.getIdTypePaie());
        if(type_paiement.getNomTypePaiement() != null && type_paiement.getNomTypePaiement() != typePaiementUpdate.getNomTypePaiement()){
            typePaiementUpdate.setNomTypePaiement(type_paiement.getNomTypePaiement());
        }
        iTypePaiementRepository.save(typePaiementUpdate);
        return typePaiementUpdate;
    }


    @Override
    public void deleteType_paiement(Long id) {

        TypePaiement typePaiement = iTypePaiementRepository.findByIdTypePaie(id);
        if(null != typePaiement){
            iTypePaiementRepository.delete(typePaiement);
        }
        else{
            System.out.println("ce type de paiement n'existe pas");
        }
    }
}
