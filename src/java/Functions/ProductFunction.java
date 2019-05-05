/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Functions;

import Models.Categorie;
import Models.Produit;
import Models.Supermarket;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author lenovo
 */
public class ProductFunction {
    
    public static boolean addProduct(Produit produit, int idSupermarket,int idCategorie){
        boolean result= false;
        SessionFactory factory = SessionFunction.getSessionFactory();
        Session session = factory.getCurrentSession();
        try{
            session.beginTransaction();
            Categorie cat = CategorieFunction.getCategorieFromId(idCategorie);
            Supermarket supermarket = SupermarketFunction.getSupermarketFromId(idSupermarket);
            List<Supermarket> listSupermarket = new ArrayList<>();
            listSupermarket.add(supermarket);
            produit.setCategorie(cat);
            produit.setSupermarkets(listSupermarket);
            session.save(produit);
            session.getTransaction().commit();
            result = true;
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            factory.close();
        }
        return result;
    }
    
   public static Produit getProduitFromId(int idProduit){
       Produit produit = null;
       SessionFactory factory = SessionFunction.getSessionFactory();
       Session session = factory.getCurrentSession();
       try{
           session.beginTransaction();
           produit = (Produit)session.get(Produit.class,idProduit);
           session.getTransaction().commit();
       }catch(Exception ex){
           ex.printStackTrace();
       }finally{
           factory.close();
       }
       return produit;
   }
    
    public static List<Produit> listProduit(int idSupermarket){
        List<Produit> listProduit = null;
        SessionFactory factory = SessionFunction.getSessionFactory();
        Session session = factory.getCurrentSession();
        try{
            session.beginTransaction();
            Supermarket supermarket = SupermarketFunction.getSupermarketFromId(idSupermarket);
            listProduit = supermarket.getProduits().stream().distinct().collect(Collectors.toList());
            session.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            factory.close();
        }
        return listProduit;
    }
    
    public static boolean updateProduct(Produit oldProduct,Produit newProduct){
       boolean result = false;
       SessionFactory factory = SessionFunction.getSessionFactory();
       Session session = factory.getCurrentSession(); 
       try{
           session.beginTransaction();
           oldProduct.setNom(newProduct.getNom());
           oldProduct.setQuantite(newProduct.getQuantite());
           oldProduct.setPrix(newProduct.getPrix());
           session.update(oldProduct);
           session.getTransaction().commit();
           result = true;
       }catch(Exception ex){
           ex.printStackTrace();
       }finally{
           factory.close();
       }
       return result;
    }
    
    public static boolean deleteProduct(int idProduit){
       boolean result = false;
       SessionFactory factory = SessionFunction.getSessionFactory();
       Session session = factory.getCurrentSession(); 
       try{
           session.beginTransaction();
           Produit prod = (Produit)session.get(Produit.class,idProduit);
           session.delete(prod);
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
