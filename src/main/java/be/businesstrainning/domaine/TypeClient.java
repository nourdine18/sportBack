/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.businesstrainning.domaine;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.data.jpa.repository.Modifying;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Transactional
@Entity
@Table(name = "type_client")
/*@NamedQueries({
        @NamedQuery(name = "TypeClient.deleteTypeClientById", query = "DELETE  FROM TypeClient WHERE idTypeClient = :idTypeClient")})*/


public class TypeClient implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_type_client")
    private Long idTypeClient;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nom_type_client")
    private String nomTypeClient;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTypeClient")
    private Collection<Client> clientCollection;

    public TypeClient() {
    }

    public TypeClient(Long idTypeClient) {
        this.idTypeClient = idTypeClient;
    }



    public TypeClient(Long idTypeClient, String nomTypeClient) {
        this.idTypeClient = idTypeClient;
        this.nomTypeClient = nomTypeClient;
    }

    public Long getIdTypeClient() {
        return idTypeClient;
    }

    public void setIdTypeClient(Long idTypeClient) {
        this.idTypeClient = idTypeClient;
    }

    public String getNomTypeClient() {
        return nomTypeClient;
    }

    public void setNomTypeClient(String nomTypeClient) {
        this.nomTypeClient = nomTypeClient;
    }

    public Collection<Client> getClientCollection() {
        return clientCollection;
    }

    public void setClientCollection(Collection<Client> clientCollection) {
        this.clientCollection = clientCollection;
    }

//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (idTypeClient != null ? idTypeClient.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof TypeClient)) {
//            return false;
//        }
//        TypeClient other = (TypeClient) object;
//        if ((this.idTypeClient == null && other.idTypeClient != null) || (this.idTypeClient != null && !this.idTypeClient.equals(other.idTypeClient))) {
//            return false;
//        }
//        return true;
//    }

    @Override
    public String toString() {
        return "be.businesstraining.domain.TypeClient[ idTypeClient=" + idTypeClient + " ]";
    }
    
}
