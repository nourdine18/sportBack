/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.businesstrainning.domaine;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "location")
public class Location implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id_location")
    private Long idLocation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_loc")
    @Temporal(TemporalType.DATE)
    private Date dateLoc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "heure_debut")
    @Temporal(TemporalType.TIME)
    private Date heureDebut;
    @Basic(optional = false)
    @NotNull
    @Column(name = "heure_fin")
    @Temporal(TemporalType.TIME)
    private Date heureFin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "montant_total")
    private Integer montantTotal;
    @JoinTable(name = "utilise_1", joinColumns = {
        @JoinColumn(name = "id_location", referencedColumnName = "id_location")}, inverseJoinColumns = {
        @JoinColumn(name = "id_terrain", referencedColumnName = "id_terrain")})
    @JsonIgnore
    @ManyToMany
    private Collection<Terrain> terrainCollection;
    @JoinColumn(name = "id_client", referencedColumnName = "id_client")
    @JsonIgnore
    @ManyToOne(optional = false)
    private Client idClient;
    @JoinColumn(name = "id_paie", referencedColumnName = "id_paie")
    @JsonIgnore
    @ManyToOne(optional = false)
    private Paiement idPaie;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "location")
    private Collection<Utilise2> utilise2Collection;

    public Location() {
    }

    public Location(Long idLocation) {
        this.idLocation = idLocation;
    }

    public Location(Long idLocation, Date dateLoc, Date heureDebut, Date heureFin, Integer montantTotal) {
        this.idLocation = idLocation;
        this.dateLoc = dateLoc;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.montantTotal = montantTotal;
    }

    public Long getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(Long idLocation) {
        this.idLocation = idLocation;
    }

    public Date getDateLoc() {
        return dateLoc;
    }

    public void setDateLoc(Date dateLoc) {
        this.dateLoc = dateLoc;
    }

    public Date getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(Date heureDebut) {
        this.heureDebut = heureDebut;
    }

    public Date getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(Date heureFin) {
        this.heureFin = heureFin;
    }

    public Integer getMontantTotal() {
        return montantTotal;
    }

    public void setMontantTotal(Integer montantTotal) {
        this.montantTotal = montantTotal;
    }

    public Collection<Terrain> getTerrainCollection() {
        return terrainCollection;
    }

    public void setTerrainCollection(Collection<Terrain> terrainCollection) {
        this.terrainCollection = terrainCollection;
    }

    public Client getIdClient() {
        return idClient;
    }

    public void setIdClient(Client idClient) {
        this.idClient = idClient;
    }

    public Paiement getIdPaie() {
        return idPaie;
    }

    public void setIdPaie(Paiement idPaie) {
        this.idPaie = idPaie;
    }

    public Collection<Utilise2> getUtilise2Collection() {
        return utilise2Collection;
    }

    public void setUtilise2Collection(Collection<Utilise2> utilise2Collection) {
        this.utilise2Collection = utilise2Collection;
    }

//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (idLocation != null ? idLocation.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof Location)) {
//            return false;
//        }
//        Location other = (Location) object;
//        if ((this.idLocation == null && other.idLocation != null) || (this.idLocation != null && !this.idLocation.equals(other.idLocation))) {
//            return false;
//        }
//        return true;
//    }

    @Override
    public String toString() {
        return "be.businesstraining.domain.Location[ idLocation=" + idLocation + " ]";
    }
    
}
