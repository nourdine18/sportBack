/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.businesstrainning.domaine;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "fournisseur")
@NamedQueries({
    @NamedQuery(name = "Fournisseur.findAll", query = "SELECT f FROM Fournisseur f")
    , @NamedQuery(name = "Fournisseur.findByIdFourni", query = "SELECT f FROM Fournisseur f WHERE f.idFourni = ?1")
    , @NamedQuery(name = "Fournisseur.findByNomFourni", query = "SELECT f FROM Fournisseur f WHERE f.nomFourni = :nomFourni")
    , @NamedQuery(name = "Fournisseur.findByEmailFourni", query = "SELECT f FROM Fournisseur f WHERE f.emailFourni = :emailFourni")
    , @NamedQuery(name = "Fournisseur.findByTelFourni", query = "SELECT f FROM Fournisseur f WHERE f.telFourni = :telFourni")})
public class Fournisseur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id_fourni")
    private Long idFourni;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nom_fourni")
    private String nomFourni;
    @Size(max = 40)
    @Column(name = "email_fourni")
    private String emailFourni;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "tel_fourni")
    private String telFourni;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFourni")
    private Collection<Materiel> materielCollection;

    public Fournisseur() {
    }

    public Fournisseur(Long idFourni) {
        this.idFourni = idFourni;
    }

    public Fournisseur(Long idFourni, String nomFourni, String telFourni) {
        this.idFourni = idFourni;
        this.nomFourni = nomFourni;
        this.telFourni = telFourni;
    }

    public Long getIdFourni() {
        return idFourni;
    }

    public void setIdFourni(Long idFourni) {
        this.idFourni = idFourni;
    }

    public String getNomFourni() {
        return nomFourni;
    }

    public void setNomFourni(String nomFourni) {
        this.nomFourni = nomFourni;
    }

    public String getEmailFourni() {
        return emailFourni;
    }

    public void setEmailFourni(String emailFourni) {
        this.emailFourni = emailFourni;
    }

    public String getTelFourni() {
        return telFourni;
    }

    public void setTelFourni(String telFourni) {
        this.telFourni = telFourni;
    }

    public Collection<Materiel> getMaterielCollection() {
        return materielCollection;
    }

    public void setMaterielCollection(Collection<Materiel> materielCollection) {
        this.materielCollection = materielCollection;
    }

//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (idFourni != null ? idFourni.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof Fournisseur)) {
//            return false;
//        }
//        Fournisseur other = (Fournisseur) object;
//        if ((this.idFourni == null && other.idFourni != null) || (this.idFourni != null && !this.idFourni.equals(other.idFourni))) {
//            return false;
//        }
//        return true;
//    }

    @Override
    public String toString() {
        return "be.businesstraining.domain.Fournisseur[ idFourni=" + idFourni + " ]";
    }
    
}
