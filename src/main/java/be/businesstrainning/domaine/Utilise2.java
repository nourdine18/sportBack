/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.businesstrainning.domaine;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "utilise_2")
public class Utilise2 implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected Utilise2PK utilise2PK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantite")
    private Integer quantite;
    @JoinColumn(name = "id_location", referencedColumnName = "id_location", insertable = false, updatable = false)
    @JsonIgnore
    @ManyToOne(optional = false)
    private Location location;
    @JoinColumn(name = "id_materiel", referencedColumnName = "id_materiel", insertable = false, updatable = false)
    @JsonIgnore
    @ManyToOne(optional = false)
    private Materiel materiel;

    public Utilise2() {
    }

    public Utilise2(Utilise2PK utilise2PK) {
        this.utilise2PK = utilise2PK;
    }

    public Utilise2(Utilise2PK utilise2PK, Integer quantite) {
        this.utilise2PK = utilise2PK;
        this.quantite = quantite;
    }

    public Utilise2(Long idMat, Long idLocation) {
        this.utilise2PK = new Utilise2PK(idMat, idLocation);
    }

    public Utilise2PK getUtilise2PK() {
        return utilise2PK;
    }

    public void setUtilise2PK(Utilise2PK utilise2PK) {
        this.utilise2PK = utilise2PK;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Materiel getMateriel() {
        return materiel;
    }

    public void setMateriel(Materiel materiel) {
        this.materiel = materiel;
    }

//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (utilise2PK != null ? utilise2PK.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof Utilise2)) {
//            return false;
//        }
//        Utilise2 other = (Utilise2) object;
//        if ((this.utilise2PK == null && other.utilise2PK != null) || (this.utilise2PK != null && !this.utilise2PK.equals(other.utilise2PK))) {
//            return false;
//        }
//        return true;
//    }

    @Override
    public String toString() {
        return "be.businesstraining.domain.Utilise2[ utilise2PK=" + utilise2PK + " ]";
    }
    
}
