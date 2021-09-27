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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "terrain")
public class Terrain implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id_terrain")
    private Long idTerrain;

    @Column(name = "typeTerrain")
    private String typeTerrain;
//    @JsonIgnore
//    @ManyToMany(mappedBy = "terrainCollection")
//    private Collection<Location> locationCollection;

    public Terrain() {
    }

    public Terrain(Long idTerrain) {
        this.idTerrain = idTerrain;
    }

    public Long getIdTerrain() {
        return idTerrain;
    }

    public void setIdTerrain(Long idTerrain) {
        this.idTerrain = idTerrain;
    }

    public String getTypeTerrain() {
        return typeTerrain;
    }

    public void setTypeTerrain(String typeTerrain) {
        this.typeTerrain = typeTerrain;
    }


//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (idTerrain != null ? idTerrain.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof Terrain)) {
//            return false;
//        }
//        Terrain other = (Terrain) object;
//        if ((this.idTerrain == null && other.idTerrain != null) || (this.idTerrain != null && !this.idTerrain.equals(other.idTerrain))) {
//            return false;
//        }
//        return true;
//    }

    @Override
    public String toString() {
        return "be.businesstraining.domain.Terrain[ idTerrain=" + idTerrain + " ]";
    }
    
}
