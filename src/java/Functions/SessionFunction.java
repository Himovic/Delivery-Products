/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Functions;

import Models.Categorie;
import Models.Commande;
import Models.Personne;
import Models.Produit;
import Models.Supermarket;
import Models.Visiteur;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author lenovo
 */
public class SessionFunction {
    
    public static SessionFactory getSessionFactory(){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Personne.class)
                .addAnnotatedClass(Supermarket.class)
                .addAnnotatedClass(Produit.class)
                .addAnnotatedClass(Categorie.class)
                .addAnnotatedClass(Visiteur.class)
                .addAnnotatedClass(Commande.class)
                .buildSessionFactory();
        return factory;
    }
}
