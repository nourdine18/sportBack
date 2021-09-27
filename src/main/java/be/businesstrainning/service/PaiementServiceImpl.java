package be.businesstrainning.service;


import be.businesstrainning.domaine.Paiement;
import be.businesstrainning.repository.IClientRepository;
import be.businesstrainning.repository.IPaiementRepository;
import be.businesstrainning.repository.ITypePaiementRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
public class PaiementServiceImpl implements PaiementService {

    private IPaiementRepository iPaiementRepository;
    private ITypePaiementRepository iTypePaiementRepository;
    private IClientRepository iClientRepository;

    public PaiementServiceImpl(IPaiementRepository iPaiementRepository, ITypePaiementRepository iTypePaiementRepository, IClientRepository iClientRepository) {
        this.iPaiementRepository = iPaiementRepository;
        this.iTypePaiementRepository = iTypePaiementRepository;
        this.iClientRepository = iClientRepository;
    }

    @Override
    public Paiement addPaiement(Paiement paiement) {
        Paiement paiements = iPaiementRepository.findByIdPaie(paiement.getIdPaie());
        if (paiements == null){
            iPaiementRepository.save(paiements);
        }
        else{
            System.out.println("le paiement existe déjà");
        }

        return paiements;
    }

    @Override
    public Set<Paiement> findAll() {
        return new HashSet<>(iPaiementRepository.findAll());
    }

    @Override
    public Paiement findPaiementByIdClient(Long id) {
        Paiement paiement = iPaiementRepository.findByIdClient_IdClient(id);
        return paiement;
    }

    @Override
    public Paiement updatePaiement(Paiement paiement) {
        // a voir si on laisse le montant a modif
        Paiement paiementUpdate = iPaiementRepository.findByIdPaie(paiement.getIdPaie());
        if(paiement.getMontant() != null && paiement.getMontant() != paiementUpdate.getMontant()){
            paiementUpdate.setMontant(paiement.getMontant());
        }
        if(paiement.getDatePaie() != null && paiement.getDatePaie() != paiementUpdate.getDatePaie()){
            paiementUpdate.setDatePaie(paiement.getDatePaie());
        }
        if(paiement.getIdClient() != null){
            if(paiement.getIdClient().getNomClient() != paiementUpdate.getIdClient().getNomClient()){
                paiementUpdate.getIdClient().setNomClient(paiement.getIdClient().getNomClient());
            }
            if(paiement.getIdClient().getPrenomClient() != paiementUpdate.getIdClient().getPrenomClient()){
                paiementUpdate.getIdClient().setPrenomClient(paiement.getIdClient().getPrenomClient());
            }
        }
        if(paiement.getIdTypePaie() != null){
            if(paiement.getIdTypePaie().getNomTypePaiement() != paiementUpdate.getIdTypePaie().getNomTypePaiement()){
                paiementUpdate.getIdTypePaie().setNomTypePaiement(paiement.getIdTypePaie().getNomTypePaiement());
            }
        }
        iPaiementRepository.save(paiementUpdate);
        return paiementUpdate;
    }

    @Override
    public void deletePaiement(Long id) {

        Paiement paiement = iPaiementRepository.findByIdClient(id);

        if(null != paiement){
            iPaiementRepository.delete(paiement);
        }
        else{
            System.out.println("ce paiement n'existe pas");
        }

    }
}
