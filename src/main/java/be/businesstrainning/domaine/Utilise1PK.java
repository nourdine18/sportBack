/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.businesstrainning.domaine;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;


@Embeddable
public class Utilise1PK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_terrain")
    private Long idTerrain;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_location")
    private Long idLocation;

    public Utilise1PK() {
    }

    public Utilise1PK(Long idTerrain, Long idLocation) {
        this.idTerrain = idTerrain;
        this.idLocation = idLocation;
    }

    public Long getIdTerrain() {
        return idTerrain;
    }

    public void setIdTerrain(Long idTerrain) {
        this.idTerrain = idTerrain;
    }

    public Long getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(Long idLocation) {
        this.idLocation = idLocation;
    }

//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (int) idMat;
//        hash += (int) idLocation;
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof Utilise2PK)) {
//            return false;
//        }
//        Utilise2PK other = (Utilise2PK) object;
//        if (this.idMat != other.idMat) {
//            return false;
//        }
//        if (this.idLocation != other.idLocation) {
//            return false;
//        }
//        return true;
//    }

    @Override
    public String toString() {
        return "be.businesstraining.domain.Utilise2PK[ idTerrain=" + idTerrain + ", idLocation=" + idLocation + " ]";
    }

}