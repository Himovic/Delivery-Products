/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Functions;

import Models.Supermarket;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author lenovo
 */
public class AdminFunction {
    
    public static List<Supermarket> listSupermarketToConfirm(){
        List<Supermarket> supermarkets = new ArrayList<>();
        SessionFactory factory = SessionFunction.getSessionFactory();
        Session session = factory.getCurrentSession();
        try{
            session.beginTransaction();
            String sql = "SELECT * FROM supermarche WHERE status = :stat";
            SQLQuery query = session.createSQLQuery(sql);
            query.setParameter("stat","en cours de vérification");
            query.addEntity(Supermarket.class);
            List result = query.list();
            supermarkets = (List<Supermarket>) result.stream().distinct().collect(Collectors.toList());
            session.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            factory.close();
        }
        return supermarkets;
    }
    
    public static boolean updateSupermarketStatus(int idSupermarket){
        boolean result = false;
        SessionFactory factory = SessionFunction.getSessionFactory();
        Session session = factory.getCurrentSession();
        try{
            session.beginTransaction();
            String sql = "UPDATE supermarche SET status = :stat WHERE idSupermarket = :id";
            SQLQuery query = session.createSQLQuery(sql);
            query.setParameter("stat","vérifier");
            query.setParameter("id",idSupermarket);
            int res = query.executeUpdate();
            if(res != 0 && res != -1){
                result = true;
            } 
            session.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            factory.close();
        }
        return result;
    }
    
    public static boolean rejectSupermarket(int idSupermarket){
        boolean result = false;
        SessionFactory factory = SessionFunction.getSessionFactory();
        Session session = factory.getCurrentSession();
        try{
            session.beginTransaction();
            String sql = "DELETE FROM supermarche WHERE idSupermarket = :id";
            SQLQuery query = session.createSQLQuery(sql);
            query.setParameter("id",idSupermarket);
            int res = query.executeUpdate();
            if(res != 0 && res != -1){
                result = true;
            } 
            session.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            factory.close();
        }
        return result;
    }
}
