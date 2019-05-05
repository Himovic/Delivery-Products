/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * Entity model : Personne
 */
@Entity
@Table(name = "personne")
public class Personne implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPersonne")
    private int id;
    @Column(name = "Nom")
    private String nom;
    @Column(name = "Prenom")
    private String prenom;
    @Column(name = "Adresse")
    private String adresse;
    @Column(name = "Numero")
    private int numero;
    @Column(name = "Type")
    private String type;
    @Column(name = "Email")
    private String email;
    @Column(name = "Password")
    private String password;
    @Column(name = "confirme")
    private int confirme;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "perssuper",
            joinColumns = {
                @JoinColumn(name = "idPersonne")},
            inverseJoinColumns = {
                @JoinColumn(name = "idSupermarket")})
    private List<Supermarket> supermarkets;

    /*
        Constructors
     */
    public Personne() {

    }

    public Personne(String nom, String prenom, String adresse, int numero, String type,
            String email, String password,int confirme) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.numero = numero;
        this.type = type;
        this.email = email;
        this.password = password;
        this.confirme = confirme;
    }
    public Personne(String nom,String prenom,String adresse,int numero){
        this.nom=nom;
        this.prenom=prenom;
        this.adresse=adresse;
        this.numero=numero;
    }
    public Personne(String nom,String prenom,String adresse,int numero,String type){
        this.nom=nom;
        this.prenom=prenom;
        this.adresse=adresse;
        this.numero=numero;
        this.type=type;
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @return the adresse
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * @param adresse the adresse to set
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the supermarkets
     */
    public List<Supermarket> getSupermarkets() {
        return supermarkets;
    }

    /**
     * @param supermarkets the supermarkets to set
     */
    public void setSupermarkets(List<Supermarket> supermarkets) {
        this.supermarkets = supermarkets;
    }
    
    /**
     * @return the confirme
     */
    public int getConfirme() {
        return confirme;
    }

    /**
     * @param confirme the confirme to set
     */
    public void setConfirme(int confirme) {
        this.confirme = confirme;
    }
    
    @Override
    public String toString() {
        return "Personne{" + "nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", numero=" + numero + ", type=" + type + ", email=" + email + ", password=" + password + ", supermarkets=" + supermarkets + '}';
    }

}
