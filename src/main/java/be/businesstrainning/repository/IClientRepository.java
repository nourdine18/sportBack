package be.businesstrainning.repository;

import be.businesstrainning.domaine.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IClientRepository extends JpaRepository<Client, Long> {

    Client findByEmailClient(String email);
    Client findByIdClient(Long id);
    Client findClientByNomClientAndPrenomClient(String nomClient, String prenomClient);
    List<Client> findClientByIdTypeClient(TypeClient idTypeClient);
    Long countByIdTypeClient(Long idTypeClient);

}
