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
public class Utilise1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected Utilise1PK utilise1PK;
    @JoinColumn(name = "id_location", referencedColumnName = "id_location", insertable = false, updatable = false)
    @JsonIgnore
    @ManyToOne(optional = false)
    private Location location;
    @JoinColumn(name = "id_terrain", referencedColumnName = "id_terrain", insertable = false, updatable = false)
    @JsonIgnore
    @ManyToOne(optional = false)
    private Terrain terrain;

    public Utilise1() {
    }

    public Utilise1(Utilise1PK utilise1PK, Location location, Terrain terrain) {
        this.utilise1PK = utilise1PK;
        this.location = location;
        this.terrain = terrain;
    }

    public Utilise1PK getUtilise1PK() {
        return utilise1PK;
    }

    public void setUtilise1PK(Utilise1PK utilise1PK) {
        this.utilise1PK = utilise1PK;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }

    @Override
    public String toString() {
        return "Utilise1{" +
                "utilise1PK=" + utilise1PK +
                ", location=" + location +
                ", terrain=" + terrain +
                '}';
    }
}