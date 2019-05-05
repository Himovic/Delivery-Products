/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author lenovo
 */

public class Commande implements Serializable{

    private int idCommande;
    private int idVisiteur;
    private int idProduit;
    private int idSupermarche;
    private int quantite;
    private int etat;
    
    public Commande(){
        
    }
    
    public Commande(int idCommande,int idVisiteur){
        this.idCommande=idCommande;
        this.idVisiteur=idCommande;
    }
    
    public Commande(int idProduit, int idSupermarche, int quantite) {
        this.idProduit = idProduit;
        this.idSupermarche = idSupermarche;
        this.quantite = quantite;
    }
    
    public Commande(int idVisiteur,int idProduit, int idSupermarche, int quantite, int etat) {
        this.idProduit = idProduit;
        this.idSupermarche = idSupermarche;
        this.quantite = quantite;
        this.etat = etat;
        this.idVisiteur = idVisiteur;
    }
    
    public Commande(int idCommande,int idVisiteur,int idProduit, int idSupermarche, int quantite, int etat) {
        this.idProduit = idProduit;
        this.idSupermarche = idSupermarche;
        this.quantite = quantite;
        this.etat = etat;
        this.idVisiteur = idVisiteur;
        this.idCommande = idCommande;
    }

    /**
     * @return the idProduit
     */
    public int getIdProduit() {
        return idProduit;
    }

    /**
     * @param idProduit the idProduit to set
     */
    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    /**
     * @return the idSupermarche
     */
    public int getIdSupermarche() {
        return idSupermarche;
    }

    /**
     * @param idSupermarche the idSupermarche to set
     */
    public void setIdSupermarche(int idSupermarche) {
        this.idSupermarche = idSupermarche;
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
     * @return the etat
     */
    public int getEtat() {
        return etat;
    }

    /**
     * @param etat the etat to set
     */
    public void setEtat(int etat) {
        this.etat = etat;
    }

	public int getIdVisiteur() {
		return idVisiteur;
	}

	public void setIdVisiteur(int idVisiteur) {
		this.idVisiteur = idVisiteur;
	}
        
        
        
	@Override
	public String toString() {
		return "Commande [idVisiteur=" + idVisiteur + ", idProduit=" + idProduit + ", idSupermarche=" + idSupermarche
				+ ", quantite=" + quantite + ", etat=" + etat + "]";
	}

    /**
     * @return the idCommande
     */
    public int getIdCommande() {
        return idCommande;
    }

    /**
     * @param idCommande the idCommande to set
     */
    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }
	
	
    
}
