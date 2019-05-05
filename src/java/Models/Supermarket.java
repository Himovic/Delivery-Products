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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * Entity model : Supermarhé
 */
@Entity
@Table(name = "supermarche")
public class Supermarket implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSupermarket")
    private int id;
    @Column(name = "Nom")
    private String nom;
    @Column(name = "Adresse")
    private String adresse;
    @Column(name = "Numero")
    private int numero;
    @Column(name = "Username")
    private String username;
    @Column(name = "Password")
    private String password;
    @Column(name = "status")
    private String status;
    @Column(name = "date")
    private String date;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "perssuper",
            joinColumns = {
                @JoinColumn(name = "idSupermarket")},
            inverseJoinColumns = {
                @JoinColumn(name = "idPersonne")})
    private List<Personne> administrators;
    @ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name = "superproduit",
            joinColumns = {
                @JoinColumn(name = "idSupermarket")},
            inverseJoinColumns = {
                @JoinColumn(name = "idProduit")})
    private List<Produit> produitsMarket;
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "supermarket",cascade = {CascadeType.REFRESH,CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST})
    private List<Categorie> categories;
    /*
        Constructors
     */
    public Supermarket() {

    }

    public Supermarket(String nom, String adresse, int numero, String username, String password,String status,String date) {
        this.nom = nom;
        this.adresse = adresse;
        this.numero = numero;
        this.username = username;
        this.password = password;
        this.status = status;
        this.date = date;
    }
    
    public Supermarket(String nom,String adresse,int numero,String username){
        this.nom=nom;
        this.adresse=adresse;
        this.numero=numero;
        this.username=username;
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
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
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
     * @return the administrators
     */
    public List<Personne> getAdministrators() {
        return administrators;
    }

    /**
     * @param administrators the administrators to set
     */
    public void setAdministrators(List<Personne> administrators) {
        this.administrators = administrators;
    }

    /**
     * @return the produits
     */
    public List<Produit> getProduits() {
        return getProduitsMarket();
    }

    /**
     * @param produitsMarket the produits to set
     */
    public void setProduits(List<Produit> produitsMarket) {
        this.setProduitsMarket(produitsMarket);
    }
    
    
    @Override
    public String toString() {
        return "Supermarket{" + "id=" + id + ", nom=" + nom + ", adresse=" + adresse + ", numero=" + numero + ", username=" + username + ", password=" + password + ", administrators=" + administrators + ", produitsMarket=" + getProduitsMarket() + '}';
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the produitsMarket
     */
    public List<Produit> getProduitsMarket() {
        return produitsMarket;
    }

    /**
     * @param produitsMarket the produitsMarket to set
     */
    public void setProduitsMarket(List<Produit> produitsMarket) {
        this.produitsMarket = produitsMarket;
    }

    /**
     * @return the categories
     */
    public List<Categorie> getCategories() {
        return categories;
    }

    /**
     * @param categories the categories to set
     */
    public void setCategories(List<Categorie> categories) {
        this.categories = categories;
    }
    
    
}
