/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author lenovo
 */
public class Livraison {
    
    private int idLivreur,idVisiteur;
    private String Etat;
    
    public Livraison(){
        
    }
    
    public Livraison(int idLivreur, int idVisiteur, String Etat) {
        this.idLivreur = idLivreur;
        this.idVisiteur = idVisiteur;
        this.Etat = Etat;
    }

    /**
     * @return the idLivreur
     */
    public int getIdLivreur() {
        return idLivreur;
    }

    /**
     * @param idLivreur the idLivreur to set
     */
    public void setIdLivreur(int idLivreur) {
        this.idLivreur = idLivreur;
    }

    /**
     * @return the idVisiteur
     */
    public int getIdVisiteur() {
        return idVisiteur;
    }

    /**
     * @param idVisiteur the idVisiteur to set
     */
    public void setIdVisiteur(int idVisiteur) {
        this.idVisiteur = idVisiteur;
    }

    /**
     * @return the Etat
     */
    public String getEtat() {
        return Etat;
    }

    /**
     * @param Etat the Etat to set
     */
    public void setEtat(String Etat) {
        this.Etat = Etat;
    }
    
    
}
