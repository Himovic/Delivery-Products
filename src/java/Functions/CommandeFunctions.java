/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Functions;

import Models.Commande;
import Models.CommandeInfo;
import Models.Visiteur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author lenovo
 */
public class CommandeFunctions {
    
    public static int commandeEnAttente(int idSupermarche){
        int count =0;
        Connection cnx = DBConnect.ConnectDB();
        try{
            String sql = "SELECT COUNT(idCommande) FROM commande WHERE idSupermarche = ? AND Etat = 1";
            PreparedStatement query = cnx.prepareStatement(sql);
            query.setInt(1,idSupermarche);
            ResultSet result = query.executeQuery();
            if(result.next()){
                count = result.getInt(1);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            DBConnect.connection = null;
        }
        return count;
    }
    
    public static List<Visiteur> getVisitorsOfCommandes(int idSupermarche){
        List<Visiteur> visitors = new ArrayList<>();
        Connection cnx = DBConnect.ConnectDB();
        try{
            String sql = "SELECT idVisiteur FROM commande WHERE idSupermarche= ? AND Etat=1 GROUP BY idVisiteur";
            PreparedStatement stat = cnx.prepareStatement(sql);
            stat.setInt(1,idSupermarche);
            ResultSet result = stat.executeQuery();
            while(result.next()){
                int idVisiteur = result.getInt("idVisiteur");
                visitors.add(VisiteurFunction.getVisiteurById(idVisiteur));
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            DBConnect.connection = null;
        }
        return visitors;
    }
    public static List<Visiteur> getVisitorsOfConfirmCommandes(int idSupermarche){
        List<Visiteur> visitors = new ArrayList<>();
        Connection cnx = DBConnect.ConnectDB();
        try{
            String sql = "SELECT idVisiteur FROM commande WHERE idSupermarche= ? AND Etat=2 GROUP BY idVisiteur";
            PreparedStatement stat = cnx.prepareStatement(sql);
            stat.setInt(1,idSupermarche);
            ResultSet result = stat.executeQuery();
            while(result.next()){
                int idVisiteur = result.getInt("idVisiteur");
                visitors.add(VisiteurFunction.getVisiteurById(idVisiteur));
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            DBConnect.connection = null;
        }
        return visitors;
    }
    public static List<CommandeInfo> getCommandeInfo(int idVisiteur,int idSupermarche){
        List<CommandeInfo> commandesInfo = new ArrayList<>();
        String sql = "SELECT * FROM commande WHERE idVisiteur = ? AND idSupermarche = ? AND Etat = 1";
        Connection cnx = DBConnect.ConnectDB();
        try{
            PreparedStatement stat = cnx.prepareStatement(sql);
            stat.setInt(1,idVisiteur);
            stat.setInt(2,idSupermarche);
            ResultSet result = stat.executeQuery();
            while(result.next()){
                int idCommande = result.getInt("idCommande");
                int idProduit = result.getInt("idProduit");
                String nomProduit = ProductFunction.getProduitFromId(idProduit).getNom();//
                double prixProduit = ProductFunction.getProduitFromId(idProduit).getPrix();//
                int QteCommande = result.getInt("Quantite");//
                double PrixTotal = prixProduit * QteCommande;//
                commandesInfo.add(new CommandeInfo(idCommande,nomProduit, QteCommande,prixProduit,PrixTotal));
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            DBConnect.connection = null;
        }
        return commandesInfo;
    }
    
    public static List<CommandeInfo> getConfirmCommandeInfo(int idVisiteur,int idSupermarche){
        List<CommandeInfo> commandesInfo = new ArrayList<>();
        String sql = "SELECT * FROM commande WHERE idVisiteur = ? AND idSupermarche = ? AND Etat = 2";
        Connection cnx = DBConnect.ConnectDB();
        try{
            PreparedStatement stat = cnx.prepareStatement(sql);
            stat.setInt(1,idVisiteur);
            stat.setInt(2,idSupermarche);
            ResultSet result = stat.executeQuery();
            while(result.next()){
                int idCommande = result.getInt("idCommande");
                int idProduit = result.getInt("idProduit");
                String nomProduit = ProductFunction.getProduitFromId(idProduit).getNom();//
                double prixProduit = ProductFunction.getProduitFromId(idProduit).getPrix();//
                int QteCommande = result.getInt("Quantite");//
                double PrixTotal = prixProduit * QteCommande;//
                commandesInfo.add(new CommandeInfo(idCommande,nomProduit, QteCommande,prixProduit,PrixTotal));
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            DBConnect.connection = null;
        }
        return commandesInfo;
    }
    
    public static boolean UpdateCommande(String[]idCommandes,int Etat){
        boolean result = false;
        Connection cnx = DBConnect.ConnectDB();
        try{
            String sql = "UPDATE commande SET Etat = ? WHERE idCommande = ?";
            PreparedStatement stat = cnx.prepareStatement(sql);
            stat.setInt(1,Etat);
            for (String idCommande : idCommandes) {
                stat.setInt(2, Integer.valueOf(idCommande));
                stat.executeUpdate();
            }
            result = true;
        }catch(NumberFormatException | SQLException ex){
            ex.printStackTrace();
        }finally{
            DBConnect.connection = null;
        }
        return result;
    }
    
    public static List<Commande> commandesPourAssocierLivreur(int idSupermarche){
        List<Commande> commandes = new ArrayList<>();
        Connection cnx = DBConnect.ConnectDB();
        try{
            String sql = "SELECT idCommande,idVisiteur FROM commande WHERE Etat = 2 AND idSupermarche = ?";
            PreparedStatement stat = cnx.prepareStatement(sql);
            stat.setInt(1,idSupermarche);
            ResultSet result = stat.executeQuery();
            while(result.next()){
                commandes.add(new Commande(result.getInt("idCommande"),result.getInt("idVisiteur")));
            }
            commandes = commandes.stream().distinct().collect(Collectors.toList());
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            DBConnect.connection = null;
        }
        return commandes;
    }
    
}
