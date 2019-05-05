/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Functions;

import Models.Livraison;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author lenovo
 */
public class LivraisonFunctions {
    
    public static boolean addLivraison(Livraison livraison){
        boolean result = false;
        Connection cnx = DBConnect.ConnectDB();
        try{
            String sql = "INSERT INTO livraison(idVisiteur,idLivreur,Etat)VALUES(?,?,?)";
            PreparedStatement stat = cnx.prepareStatement(sql);
            stat.setInt(1,livraison.getIdVisiteur());
            stat.setInt(2,livraison.getIdLivreur());
            stat.setString(3,livraison.getEtat());
            int execute = stat.executeUpdate();
            if(execute != 0 && execute != -1){
                result = true;
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            DBConnect.connection = null;
        }
        return result;
    }
}
