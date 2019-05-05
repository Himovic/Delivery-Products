/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Functions;

import Models.Categorie;
import Models.Supermarket;
import java.util.List;
import java.util.stream.Collectors;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author lenovo
 */
public class CategorieFunction {
    
    public static boolean addCategorie(Categorie cat,int idSupermarket){
        boolean result= false;
        SessionFactory factory = SessionFunction.getSessionFactory();
        Session session = factory.getCurrentSession();
        try{
            session.beginTransaction();
            Supermarket supermarket = (Supermarket)session.get(Supermarket.class,idSupermarket);
            cat.setSupermarket(supermarket);
            session.save(cat);
            session.getTransaction().commit();
            result = true;
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            factory.close();
        }
        return result;
    }
    public static Categorie getCategorieFromId(int id){
        Categorie categorie = null;
        SessionFactory factory = SessionFunction.getSessionFactory();
        Session session = factory.getCurrentSession();
        try{
            session.beginTransaction();
            categorie = (Categorie) session.get(Categorie.class,id);
            session.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            factory.close();
        }
        return categorie;
    }
    public static boolean updateCategorie(Categorie oldCat,Categorie newCat){
        boolean result= false;
        SessionFactory factory = SessionFunction.getSessionFactory();
        Session session = factory.getCurrentSession();
        try{
            session.beginTransaction();
            oldCat.setNom(newCat.getNom());
            session.update(oldCat);
            session.getTransaction().commit();
            result = true;
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            factory.close();
        }
        return result;
    }
    
    public static boolean deleteCategorie(Categorie cat){
        boolean result= false;
        SessionFactory factory = SessionFunction.getSessionFactory();
        Session session = factory.getCurrentSession();
        try{
            session.beginTransaction();
            session.delete(cat);
            session.getTransaction().commit();
            result = true;
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            factory.close();
        }
        return result;
    }
    
    public static List<Categorie> listCategorie(int idSupermarket){
        List<Categorie> listCat = null;
        SessionFactory factory = SessionFunction.getSessionFactory();
        Session session = factory.getCurrentSession();
        try{
            session.beginTransaction();
            Supermarket supermarket = (Supermarket)session.get(Supermarket.class,idSupermarket);
            listCat =(List<Categorie>) supermarket.getCategories().stream().distinct().collect(Collectors.toList());
            session.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            factory.close();
        }
        return listCat;
    }
}
