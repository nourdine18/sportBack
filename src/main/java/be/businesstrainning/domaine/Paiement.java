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
import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "paiement")
public class Paiement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id_paie")
    private Long idPaie;
    @Basic(optional = false)
    @NotNull
    @Column(name = "montant")
    private Integer montant;
    @Basic(optional = false)
    @Column(name = "date_paie")
    @Temporal(TemporalType.DATE)
    private Date datePaie;
    @JoinColumn(name = "id_client", referencedColumnName = "id_client")
    @ManyToOne(optional = false)
    private Client idClient;
    @JoinColumn(name = "id_type_paie", referencedColumnName = "id_type_paie")

    @ManyToOne(optional = false)
    private TypePaiement idTypePaie;
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idPaie")
    private Location locationCollection;

    public Paiement() {
    }

    public Paiement(Long idPaie) {
        this.idPaie = idPaie;
    }

    public Paiement(Long idPaie, Integer montant, Date datePaie) {
        this.idPaie = idPaie;
        this.montant = montant;
        this.datePaie = datePaie;
    }
    public Paiement(Integer montant, Date datePaie, Client client, TypePaiement typePaiement) {
        this.montant = montant;
        this.datePaie = datePaie;
        this.idClient = client;
        this.idTypePaie= typePaiement;
    }


    public Long getIdPaie() {
        return idPaie;
    }

    public void setIdPaie(Long idPaie) {
        this.idPaie = idPaie;
    }

    public Integer getMontant() {
        return montant;
    }

    public void setMontant(Integer montant) {
        this.montant = montant;
    }

    public Date getDatePaie() {
        return datePaie;
    }

    public void setDatePaie(Date datePaie) {
        this.datePaie = datePaie;
    }

    public Client getIdClient() {
        return idClient;
    }

    public void setIdClient(Client idClient) {
        this.idClient = idClient;
    }

    public TypePaiement getIdTypePaie() {
        return idTypePaie;
    }

    public void setIdTypePaie(TypePaiement idTypePaie) {
        this.idTypePaie = idTypePaie;
    }

    public Location getLocationCollection() {
        return locationCollection;
    }

    public void setLocationCollection(Location locationCollection) {
        this.locationCollection = locationCollection;
    }

//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (idPaie != null ? idPaie.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof Paiement)) {
//            return false;
//        }
//        Paiement other = (Paiement) object;
//        if ((this.idPaie == null && other.idPaie != null) || (this.idPaie != null && !this.idPaie.equals(other.idPaie))) {
//            return false;
//        }
//        return true;
//    }

    @Override
    public String toString() {
        return "be.businesstraining.domain.Paiement[ idPaie=" + idPaie + " ]";
    }
    
}
