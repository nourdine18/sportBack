/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.businesstrainning.domaine;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.Nullable;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
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
@Table(name = "client")
@NamedQueries({
         @NamedQuery(name = "Client.findClientByIdTypeClient", query = "SELECT c FROM Client c WHERE c.idTypeClient = ?1")})

public class Client implements Serializable {

    private static final long serialVersionUID = 1L;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_client")
    @Id
    private Long idClient;

    @Size(min = 1, max = 20)
    @Column(name = "nom_client")
    private String nomClient;

    @Size(min = 1, max = 20)
    @Column(name = "prenom_client")
    private String prenomClient;

    @Size(min = 1, max = 12)
    @Column(name = "tel_client")
    private String telClient;

    @Size(max = 40)
    @Column(name = "email_client")
    private String emailClient;

    @Size(min = 1, max = 50)
    @Column(name = "adresse_client")
    private String adresseClient;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClient")
    @Nullable
    private Collection<Paiement> paiementCollection;

    //@JsonIgnore
    //@ManyToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "code_postal", referencedColumnName = "code_postal")
    //@Nullable
    //private Commune codePostal;

    @JoinColumn(name = "code_postal", referencedColumnName = "code_postal")
    @ManyToOne(optional = false)
    @Nullable
    private Commune codePostal;


    @JoinColumn(name = "id_type_client", referencedColumnName = "id_type_client")
    @ManyToOne(optional = false)
    @Nullable
    private TypeClient idTypeClient;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClient")
    @Nullable
    private Collection<Location> locationCollection;

    public Client() {
    }


    public Long getIdClient() {
        return idClient;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getPrenomClient() {
        return prenomClient;
    }

    public void setPrenomClient(String prenomClient) {
        this.prenomClient = prenomClient;
    }

    public String getTelClient() {
        return telClient;
    }

    public void setTelClient(String telClient) {
        this.telClient = telClient;
    }

    public String getEmailClient() {
        return emailClient;
    }

    public void setEmailClient(String emailClient) {
        this.emailClient = emailClient;
    }

    public String getAdresseClient() { return adresseClient;  }

    public void setAdresseClient(String adresseClient) {
        this.adresseClient = adresseClient;
    }

    public Collection<Paiement> getPaiementCollection() {
        return paiementCollection;
    }

    public void setPaiementCollection(Collection<Paiement> paiementCollection) {
        this.paiementCollection = paiementCollection;
    }

    public Commune getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(Commune codePostal) {
        this.codePostal = codePostal;
    }

    public TypeClient getIdTypeClient() {
        return idTypeClient;
    }

    public void setIdTypeClient(TypeClient idTypeClient) {
        this.idTypeClient = idTypeClient;
    }

    public Collection<Location> getLocationCollection() {
        return locationCollection;
    }

    public void setLocationCollection(Collection<Location> locationCollection) {
        this.locationCollection = locationCollection;
    }

    @Override
    public String toString() {
        return "Client{" +
                "idClient=" + idClient +
                ", nomClient='" + nomClient + '\'' +
                ", prenomClient='" + prenomClient + '\'' +
                ", telClient='" + telClient + '\'' +
                ", emailClient='" + emailClient + '\'' +
                ", adresseClient='" + adresseClient + '\'' +
                ", paiementCollection=" + paiementCollection +
                ", codePostal=" + codePostal +
                ", idTypeClient=" + idTypeClient +
                ", locationCollection=" + locationCollection +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return idClient == client.idClient &&
                telClient.equals(client.telClient) &&
                emailClient.equals(client.emailClient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idClient, telClient, emailClient);
    }
}
