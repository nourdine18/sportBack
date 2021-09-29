package be.businesstrainning.repository;

import be.businesstrainning.domaine.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface ITypeClientRepository extends JpaRepository<TypeClient, Long> {

    TypeClient findByIdTypeClient(Long id);
    TypeClient findByNomTypeClient(String nom);

}
