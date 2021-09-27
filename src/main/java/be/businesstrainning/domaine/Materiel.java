/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.businesstrainning.domaine;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "materiel")
public class Materiel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id_mat")
    private Long idMat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stock")
    private Integer stock;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nom_mat")
    private String nomMat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prix_unitaire")
    private Integer prixUnitaire;
    @JoinColumn(name = "id_fourni", referencedColumnName = "id_fourni")
    @ManyToOne(optional = false)
    private Fournisseur idFourni;

//    @JsonIgnore
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materiel")
//    private Collection<Utilise2> utilise2Collection;

    public Materiel() {
    }

    public Materiel(Long idMat) {
        this.idMat = idMat;
    }

    public Materiel(Long idMat, Integer stock, String nomMat, Integer prixUnitaire) {
        this.idMat = idMat;
        this.stock = stock;
        this.nomMat = nomMat;
        this.prixUnitaire = prixUnitaire;
    }

    @JsonCreator
    public Materiel(@JsonProperty("idMat") Long idMat, @JsonProperty("stock")Integer stock, @JsonProperty("nomMat")String nomMat, @JsonProperty("prixUnitaire")Integer prixUnitaire, @JsonProperty("idFourni")Fournisseur idFourni) {
        this.idMat = idMat;
        this.stock = stock;
        this.nomMat = nomMat;
        this.prixUnitaire = prixUnitaire;
        this.idFourni = idFourni;
    }

    public Long getIdMat() {
        return idMat;
    }

    public void setIdMat(Long idMat) {
        this.idMat = idMat;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getNomMat() {
        return nomMat;
    }

    public void setNomMat(String nomMat) {
        this.nomMat = nomMat;
    }

    public Integer getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(Integer prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public Fournisseur getIdFourni() {
        return idFourni;
    }

    public void setIdFourni(Fournisseur idFourni) {
        this.idFourni = idFourni;
    }

//    public Collection<Utilise2> getUtilise2Collection() {
//        return utilise2Collection;
//    }
//
//    public void setUtilise2Collection(Collection<Utilise2> utilise2Collection) {
//        this.utilise2Collection = utilise2Collection;
//    }

//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (idMat != null ? idMat.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof Materiel)) {
//            return false;
//        }
//        Materiel other = (Materiel) object;
//        if ((this.idMat == null && other.idMat != null) || (this.idMat != null && !this.idMat.equals(other.idMat))) {
//            return false;
//        }
//        return true;
//    }

    @Override
    public String toString() {
        return "be.businesstraining.domain.Materiel[ idMat=" + idMat + " ]";
    }
    
}
