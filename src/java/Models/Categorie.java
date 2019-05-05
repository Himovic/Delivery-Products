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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * Entity model : Categorie
 */
@Entity
@Table(name = "categorie")
public class Categorie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCategorie")
    private int id;
    @ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.REFRESH,CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST})
    @JoinColumn(name = "idSupermarket")
    private Supermarket supermarket;
    @Column(name = "NomCategorie")
    private String nom;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "categorie", cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private List<Produit> produits;

    /*
        Constructors
     */
    public Categorie() {

    }

    public Categorie(String nom) {
        this.nom = nom;
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
     * @return the produits
     */
    public List<Produit> getProduits() {
        return produits;
    }

    /**
     * @param produits the produits to set
     */
    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }
    
    
    @Override
    public String toString() {
        return "Categorie{" + "id=" + id + ", nom=" + nom + ", produits=" + produits + '}';
    }

    /**
     * @return the supermarket
     */
    public Supermarket getSupermarket() {
        return supermarket;
    }

    /**
     * @param supermarket the supermarket to set
     */
    public void setSupermarket(Supermarket supermarket) {
        this.supermarket = supermarket;
    }

}
