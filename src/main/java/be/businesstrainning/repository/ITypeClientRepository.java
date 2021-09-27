package be.businesstrainning.repository;

import be.businesstrainning.domaine.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface ITypeClientRepository extends JpaRepository<TypeClient, Long> {

    TypeClient findByIdTypeClient(Long id);
/*    @Modifying
    @Transactional
    @Query(value = "DELETE FROM type_client WHERE id_type_client in (id_type_client)", nativeQuery = true)
    int deleteTypeClientById(@Param("id_type_client") Long idTypeClient);*/
    TypeClient findByNomTypeClient(String nom);

}
