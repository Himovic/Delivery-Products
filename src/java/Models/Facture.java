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
public class Facture {
    
    private double priceProducts,priceLivraison,priceTotal;
    private String date;
    
    public Facture(){
        
    }
    
    public Facture(double priceProducts, double priceLivraison, double priceTotal, String date) {
        this.priceProducts = priceProducts;
        this.priceLivraison = priceLivraison;
        this.priceTotal = priceTotal;
        this.date = date;
    }

    /**
     * @return the priceProducts
     */
    public double getPriceProducts() {
        return priceProducts;
    }

    /**
     * @param priceProducts the priceProducts to set
     */
    public void setPriceProducts(double priceProducts) {
        this.priceProducts = priceProducts;
    }

    /**
     * @return the priceLivraison
     */
    public double getPriceLivraison() {
        return priceLivraison;
    }

    /**
     * @param priceLivraison the priceLivraison to set
     */
    public void setPriceLivraison(double priceLivraison) {
        this.priceLivraison = priceLivraison;
    }

    /**
     * @return the priceTotal
     */
    public double getPriceTotal() {
        return priceTotal;
    }

    /**
     * @param priceTotal the priceTotal to set
     */
    public void setPriceTotal(double priceTotal) {
        this.priceTotal = priceTotal;
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
    
    
}
