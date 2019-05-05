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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * Entity model : Produit
 */
@Entity
@Table(name = "produit")
public class Produit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProduit")
    private int id;
    @Column(name = "NomProduit")
    private String nom;
    @Column(name = "Quantite")
    private int quantite;
    @Column(name = "Prix")
    private double prix;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "idCategorie")
    private Categorie categorie;
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name = "superproduit",
            joinColumns = {
                @JoinColumn(name = "idProduit")},
            inverseJoinColumns = {
                @JoinColumn(name = "idSupermarket")})
    private List<Supermarket> supermarketsProduit;

    /*
        Constructors
     */
    public Produit() {

    }

    public Produit(String nom, int quantite, double prix) {
        this.nom = nom;
        this.quantite = quantite;
        this.prix = prix;
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
     * @return the categorie
     */
    public Categorie getCategorie() {
        return categorie;
    }

    /**
     * @param categorie the categorie to set
     */
    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    /**
     * @return the supermarkets
     */
    public List<Supermarket> getSupermarkets() {
        return supermarketsProduit;
    }

    /**
     * @param supermarketsProduit the supermarkets to set
     */
    public void setSupermarkets(List<Supermarket> supermarketsProduit) {
        this.supermarketsProduit = supermarketsProduit;
    }

    /**
     * @return the quantite
     */
    public int getQuantite() {
        return quantite;
    }

    /**
     * @param quantite the quantite to set
     */
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    /**
     * @return the prix
     */
    public double getPrix() {
        return prix;
    }

    /**
     * @param prix the prix to set
     */
    public void setPrix(double prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Produit{" + "id=" + id + ", nom=" + nom + ", quantite=" + quantite + ", prix=" + prix + ", categorie=" + categorie + ", supermarketsProduit=" + supermarketsProduit + '}';
    }

}
