/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.businesstrainning.domaine;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.lang.Nullable;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "commune")
public class Commune implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Nullable
    @Column(name = "code_postal")
    private Long codePostal;
    @Basic(optional = false)
    @Nullable
    @Size(min = 1, max = 30)
    @Column(name = "commune")
    private String communeName;

//    @JsonIgnore
//    @OneToMany(mappedBy = "codePostal")
//    @Nullable
//    private Collection<Client> clientCollection;

    public Commune() {
    }

    public Commune(Long codePostal) {
        this.codePostal = codePostal;
    }

    public Commune(Long codePostal, String communeName) {
        this.codePostal = codePostal;
        this.communeName = communeName;
    }

    public Long getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(Long codePostal) {
        this.codePostal = codePostal;
    }

    public String getCommuneName() {
        return communeName;
    }

    public void setCommuneName(String communeName) {
        this.communeName = communeName;
    }



//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (codePostal != null ? codePostal.hashCode() : 0);
//        return hash;
//    }

//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof Commune)) {
//            return false;
//        }
//        Commune other = (Commune) object;
//        if ((this.codePostal == null && other.codePostal != null) || (this.codePostal != null && !this.codePostal.equals(other.codePostal))) {
//            return false;
//        }
//        return true;
//    }

    @Override
    public String toString() {
        return "be.businesstraining.domain.Commune[ codePostal=" + codePostal + " ]";
    }
    
}
