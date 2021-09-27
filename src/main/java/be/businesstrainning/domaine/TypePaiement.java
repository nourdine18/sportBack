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
@Table(name = "type_paiement")
public class TypePaiement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id_type_paie")
    private Long idTypePaie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nom_paie")
    private String nomTypePaiement;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTypePaie")
    private Collection<Paiement> paiementCollection;

    public TypePaiement() {
    }

    public TypePaiement(Long idTypePaie) {
        this.idTypePaie = idTypePaie;
    }

    public TypePaiement(Long idTypePaie, String nomTypePaiement) {
        this.idTypePaie = idTypePaie;
        this.nomTypePaiement = nomTypePaiement;
    }

    public Long getIdTypePaie() {
        return idTypePaie;
    }

    public void setIdTypePaie(Long idTypePaie) {
        this.idTypePaie = idTypePaie;
    }

    public String getNomTypePaiement() {
        return nomTypePaiement;
    }

    public void setNomTypePaiement(String nomTypePaiement) {
        this.nomTypePaiement = nomTypePaiement;
    }

    public Collection<Paiement> getPaiementCollection() {
        return paiementCollection;
    }

    public void setPaiementCollection(Collection<Paiement> paiementCollection) {
        this.paiementCollection = paiementCollection;
    }

//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (idTypePaie != null ? idTypePaie.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof TypePaiement)) {
//            return false;
//        }
//        TypePaiement other = (TypePaiement) object;
//        if ((this.idTypePaie == null && other.idTypePaie != null) || (this.idTypePaie != null && !this.idTypePaie.equals(other.idTypePaie))) {
//            return false;
//        }
//        return true;
//    }

    @Override
    public String toString() {
        return "be.businesstraining.domain.TypePaiement[ idTypePaie=" + idTypePaie + " ]";
    }
    
}
