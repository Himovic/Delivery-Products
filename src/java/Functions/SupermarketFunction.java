/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Functions;

import Models.Personne;
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
public class SupermarketFunction {
    
    public static boolean addSupermarket(Supermarket supermarket,int id){
        boolean result= false;
        SessionFactory factory = SessionFunction.getSessionFactory();
        Session session = factory.getCurrentSession();
        System.out.println("id in supermarket is : "+id);
        try{
            session.beginTransaction();
            Personne admin = UsersFunctions.getPersonneFromId(id);
            List<Personne> administrators = new ArrayList<>();
            administrators.add(admin);
            supermarket.setAdministrators(administrators);
            session.save(supermarket);
            session.getTransaction().commit();
            result = true;
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            factory.close();
        }
        return result;
    }
    
    public static List<Supermarket> listOfSupermarket(int id){
        List<Supermarket> supermarkets = new ArrayList<>();
        SessionFactory factory = SessionFunction.getSessionFactory();
        Session session = factory.getCurrentSession();
        try{
            session.beginTransaction();
            Personne personne = UsersFunctions.getPersonneFromId(id);
            supermarkets = personne.getSupermarkets().stream().distinct().collect(Collectors.toList());
            session.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            factory.close();
        }
        return supermarkets;
    }
    
    public static Supermarket authenticateSupermarket(String user,String password){
        SessionFactory factory = SessionFunction.getSessionFactory();
        Session session = factory.getCurrentSession();
        Supermarket supermarket = null;
        try{
            String sql = "SELECT * FROM supermarche WHERE Username = :user AND Password = :password AND status = :stat";
            session.beginTransaction();
            SQLQuery query = session.createSQLQuery(sql);
            query.setParameter("user",user);
            query.setParameter("password",password);
            query.setParameter("stat","vérifier");
            query.addEntity(Supermarket.class);
            List result = query.list();
            if(!result.isEmpty()){
                supermarket = (Supermarket) result.get(0);
                session.getTransaction().commit();
            }else{
                supermarket = null;
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            factory.close();
        }
        return supermarket;
    }
    
    public static Supermarket getSupermarketFromId(int id){
        SessionFactory factory = SessionFunction.getSessionFactory();
        Session session = factory.getCurrentSession();
        Supermarket supermarket = null;
        try{
            session.beginTransaction();
            supermarket = (Supermarket) session.get(Supermarket.class,id);
            session.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            factory.close();
        }
        return supermarket;
    }
    
    public static boolean deleteSupermarket(Supermarket supermarket){
        SessionFactory factory = SessionFunction.getSessionFactory();
        Session session = factory.getCurrentSession();
        boolean result = false;
        try{
            session.beginTransaction();
            session.delete(supermarket);
            session.getTransaction().commit();
            result = true;
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            factory.close();
        }
        return result;
    }
    
    public static boolean updateSupermarket(Supermarket oldSupermarket,Supermarket newSupermarket){
        SessionFactory factory = SessionFunction.getSessionFactory();
        Session session = factory.getCurrentSession();
        boolean result = false;
        try{
            session.beginTransaction();
            oldSupermarket.setNom(newSupermarket.getNom());
            oldSupermarket.setAdresse(newSupermarket.getAdresse());
            oldSupermarket.setNumero(newSupermarket.getNumero());
            oldSupermarket.setUsername(newSupermarket.getUsername());
            session.update(oldSupermarket);
            session.getTransaction().commit();
            result = true;
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            factory.close();
        }
        return result;
    }
}
