/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Functions;

import Models.Visiteur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author lenovo
 */
public class VisiteurFunction {
    
    public static Visiteur getVisiteurById(int id){
        Visiteur visiteur = null;
        Connection cnx = DBConnect.ConnectDB();
        try{
            String sql = "SELECT * FROM visiteur WHERE idVisiteur = ?";
            PreparedStatement stat = cnx.prepareStatement(sql);
            stat.setInt(1,id);
            ResultSet result = stat.executeQuery();
            while(result.next()){
                String nom = result.getString("Nom");
                String prenom = result.getString("Prenom");
                String adresse = result.getString("Adresse");
                int numero = result.getInt("Numero");
                visiteur = new Visiteur(id, nom, prenom, adresse, numero);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            DBConnect.connection = null;
        }
        return visiteur;
    }
}
