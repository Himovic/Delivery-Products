/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Functions;

import Models.Facture;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author lenovo
 */
public class FactureFunctions {
    
    public static boolean addFacture(int idVisiteur,double prixProduitTotal,double prixLivraison,double prixTotal){
        boolean result = false;
        Connection cnx = DBConnect.ConnectDB();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
	String stringDate = dateFormat.format(date);
        try{
            String sql = "INSERT INTO facture(idVisiteur,prixProduit,prixLivraison,prixTotal,Date)VALUES(?,?,?,?,?)";
            PreparedStatement stat = cnx.prepareStatement(sql);
            stat.setInt(1,idVisiteur);
            stat.setDouble(2,prixProduitTotal);
            stat.setDouble(3,prixLivraison);
            stat.setDouble(4,prixTotal);
            stat.setString(5,stringDate);
            int executeResult = stat.executeUpdate();
            if(executeResult != 0 && executeResult != -1){
                result = true;
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            DBConnect.connection = null;
        }
        return result;
    }
    
    public static Facture selectFactureFromClient(int idVisiteur){
        Facture facture = null;
        String sql = "SELECT * FROM facture WHERE idVisiteur = ?";
        Connection cnx = DBConnect.ConnectDB();
        try{
            PreparedStatement stat = cnx.prepareStatement(sql);
            stat.setInt(1,idVisiteur);
            ResultSet result = stat.executeQuery();
            while(result.next()){
                double prixProduit = result.getDouble("prixProduit");
                double prixLivraison = result.getDouble("prixLivraison");
                double prixTotal = result.getDouble("prixTotal");
                String date = result.getString("Date");
                facture = new Facture(prixProduit, prixLivraison, prixTotal, date);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            DBConnect.connection = null;
        }
        return facture;
    }
}
