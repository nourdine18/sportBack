package be.businesstrainning.service;

import be.businesstrainning.domaine.Commune;
import be.businesstrainning.repository.ICommuneRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
public class CommuneServiceImpl implements CommuneService {

    private ICommuneRepository iCommuneRepository;


    public CommuneServiceImpl(ICommuneRepository iCommuneRepository) {
        this.iCommuneRepository = iCommuneRepository;
    }

    @Override
    public Commune addCommune(Commune commune) {
        Commune communes = iCommuneRepository.findByCodePostal(commune.getCodePostal());
        if (communes == null){

            iCommuneRepository.save(commune);
        }
        else{
            System.out.println("la commune existe déjà");
        }

        return commune;
    }

    @Override
    public Set<Commune> findAll() {
        return new HashSet<>(iCommuneRepository.findAll());
    }

    @Override
    public Commune findByCodePostal(Long code_postal) {
        Commune commune = iCommuneRepository.findByCodePostal(code_postal);
        return commune;
    }

    @Override
    public Commune updateCommune(Commune commune) {
        Commune communeUpdate = iCommuneRepository.findByCodePostal(commune.getCodePostal());
        if(commune.getCodePostal() != null && commune.getCodePostal() != communeUpdate.getCodePostal()){
            communeUpdate.setCodePostal(commune.getCodePostal());
        }
        if(commune.getCommuneName() != null && commune.getCommuneName() != communeUpdate.getCommuneName()){
            communeUpdate.setCommuneName(commune.getCommuneName());
        }
        iCommuneRepository.save(communeUpdate);
        return communeUpdate;
    }

    @Override
    public void deleteCommune(Long code_postal) {
        Commune commune = iCommuneRepository.findByCodePostal(code_postal);
        if(null != commune){
            iCommuneRepository.delete(commune);
        }
        else{
            System.out.println("cette commune n'existe pas");
        }

    }
}
