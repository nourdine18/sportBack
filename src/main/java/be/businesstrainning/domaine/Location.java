/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.businesstrainning.domaine;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.Nullable;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.*;
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
//    @Temporal(TemporalType.TIME)
    private int heureDebut;
    @Basic(optional = false)
    @NotNull
    @Column(name = "heure_fin")
//    @Temporal(TemporalType.TIME)
    private int heureFin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "montant_total")
    private Integer montantTotal;
    @JoinTable(name = "utilise_1", joinColumns = {
        @JoinColumn(name = "id_location", referencedColumnName = "id_location")}, inverseJoinColumns = {
        @JoinColumn(name = "id_terrain", referencedColumnName = "id_terrain")})
    @ManyToMany
    private Collection<Terrain> terrainCollection;
    @JoinTable(name = "utilise_2", joinColumns = {
            @JoinColumn(name = "id_location", referencedColumnName = "id_location")}, inverseJoinColumns = {
            @JoinColumn(name = "id_materiel", referencedColumnName = "id_materiel")})
    @ManyToMany
    private Collection<Materiel> materielCollection;
    @JoinColumn(name = "id_client", referencedColumnName = "id_client")
    @ManyToOne(optional = false)
    private Client idClient;
    @JoinColumn(name = "id_paie", referencedColumnName = "id_paie")
    @OneToOne(optional = false)
    private Paiement idPaie;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "location")
    private Collection<Utilise2> utilise2Collection;


    public Location() {
    }

    public Location(Long idLocation) {
        this.idLocation = idLocation;
    }

    public Location(Long idLocation, Date dateLoc, int heureDebut, int heureFin, Integer montantTotal, Client idClient) {
        this.idLocation = idLocation;
        this.dateLoc = dateLoc;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.montantTotal = montantTotal;
        this.idClient = idClient;
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

    public int getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(int heureDebut) {
        this.heureDebut = heureDebut;
    }

    public int getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(int heureFin) {
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

    public Collection<Materiel> getMaterielCollection() {
        return materielCollection;
    }

    public void setMaterielCollection(Collection<Materiel> materielCollection) {
        this.materielCollection = materielCollection;
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

    public String getDateAppBE() {
        String tmp;

        if (this.dateLoc == null)
            tmp = "";
        else
        {
            SimpleDateFormat dateParser = new SimpleDateFormat("dd/MM/yyyy");
            tmp = dateParser.format(this.dateLoc);
        }
        return tmp;
    }

    public void setDateAppBE(String dateApp) {
        SimpleDateFormat dateParser = new SimpleDateFormat("dd/MM/yyyy");
        try {
            this.dateLoc = dateParser.parse(dateApp);
        } catch (ParseException ex) {
            Logger.getLogger(Location.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//
//    public String getDateAppSQL() {
//        String tmp;
//
//        if (this.dateLoc == null)
//            tmp = "";
//        else
//        {
//            SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-MM-dd");
//            tmp = "'" + dateParser.format(this.dateLoc) + "'";
//        }
//        return tmp;
//    }
//
//    public String getDateAppUS() {
//        String tmp;
//
//        if (this.dateLoc == null)
//            tmp = "";
//        else
//        {
//            tmp = this.dateLoc.toString();
//        }
//        return tmp;
//    }

//    @Override
//    public String toString() {
//        return "be.businesstraining.domain.Location[ idLocation=" + idLocation + ", client"+ " ]";
//    }


    @Override
    public String toString() {
        return "Location{" +
                "idLocation=" + idLocation +
                ", dateLoc=" + dateLoc +
                ", heureDebut=" + heureDebut +
                ", heureFin=" + heureFin +
                ", montantTotal=" + montantTotal +
                ", idClient=" + idClient +
                '}';
    }
}
