/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Functions;

import Models.Personne;
import Models.Supermarket;
import com.mchange.v1.util.IteratorUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author lenovo
 */
public class UsersFunctions {
    //méthode pour crypter le mot de passe
    public static String encryptPasswordMD5(String password) throws NoSuchAlgorithmException{
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte [] passwordByte =  password.getBytes();
        md.reset();
        byte[] digested = md.digest(passwordByte);
        StringBuffer sb = new StringBuffer();
        for(int i=0 ; i<digested.length ; i++){
            sb.append(Integer.toHexString(0xff & digested[i]));
        }
        return sb.toString();
    }
    
    public static boolean inscription(Personne p){
        SessionFactory factory = SessionFunction.getSessionFactory();
        Session session = factory.getCurrentSession();
        boolean result = false;
        try{
            session.beginTransaction();
            session.save(p);
            session.getTransaction().commit();
            result = true;
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            factory.close();
        }
        return result;
    }
    public static boolean systemConfirmationUser(String email){
        SessionFactory factory = SessionFunction.getSessionFactory();
        Session session = factory.getCurrentSession();
        boolean returnResult = false;
        try{
            session.beginTransaction();
            String sql = "UPDATE personne SET confirme = 1 WHERE Email = :email";
            SQLQuery query = session.createSQLQuery(sql);
            query.setParameter("email",email);
            query.executeUpdate();
            session.getTransaction().commit();
            returnResult = true;
        }catch(Exception ex){
            returnResult = false;
            ex.printStackTrace();
        }finally{
            factory.close();
        }
        return returnResult;
    }
    public static Personne authentification(String email,String password){
        SessionFactory factory = SessionFunction.getSessionFactory();
        Session session = factory.getCurrentSession();
        Personne personne = null;
        try{
            String sql = "SELECT * FROM personne WHERE Email = :email AND Password = :password AND confirme = 1";
            session.beginTransaction();
            SQLQuery query = session.createSQLQuery(sql);
            query.setParameter("email",email);
            query.setParameter("password",password);
            query.addEntity(Personne.class);
            List result =  query.list();
            //System.out.println("Size :"+result.get(0).getNom());
            if(!result.isEmpty()){
                personne = (Personne) result.get(0);
                session.getTransaction().commit();
            }else{
                personne = null;
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            factory.close();
        }
        return personne;
    }
    
    public static Personne getPersonneFromId(int id){
        SessionFactory factory = SessionFunction.getSessionFactory();
        Session session = factory.getCurrentSession();
        Personne personne = null;
        try{
            session.beginTransaction();
            personne = (Personne)session.get(Personne.class,id);
            session.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            factory.close();
        }
        return personne;
    }
    
    public static int getIdFromEmail(String email){
        SessionFactory factory = SessionFunction.getSessionFactory();
        Session session = factory.getCurrentSession();
        int id=0;
        try{
            session.beginTransaction();
            String sql = "SELECT * FROM Personne WHERE Email = :email";
            SQLQuery query = session.createSQLQuery(sql);
            query.setParameter("email",email);
            query.addEntity(Personne.class);
            List result = query.list();
            Personne p = (Personne)result.get(0);
            id = p.getId();
            session.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            factory.close();
        }
        return id;
    }
    
    public static boolean updatePersonne(Personne newPersonne,Personne oldPersonne){
        SessionFactory factory = SessionFunction.getSessionFactory();
        Session session = factory.getCurrentSession();
        boolean result = false;
        try{
            session.beginTransaction();
            oldPersonne.setNom(newPersonne.getNom());
            oldPersonne.setPrenom(newPersonne.getPrenom());
            oldPersonne.setAdresse(newPersonne.getAdresse());
            oldPersonne.setNumero(newPersonne.getNumero());
            oldPersonne.setType(newPersonne.getType());
            session.update(oldPersonne);
            session.getTransaction().commit();
            result = true;
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            factory.close();
        }
        return result;
    }
    
    public static List<Personne> listLivreur(int idSupermarket){
       List<Personne> livreurs = null;
       SessionFactory factory = SessionFunction.getSessionFactory();
       Session session = factory.getCurrentSession();
       try{
           session.beginTransaction();
           String sql = "SELECT * FROM personne WHERE Type= :type";
           SQLQuery query = session.createSQLQuery(sql);
           query.setParameter("type","livreur");
           query.addEntity(Personne.class);
           List result = query.list();
           livreurs = (List<Personne>)result.stream().distinct().collect(Collectors.toList());
           session.getTransaction().commit();
       }catch(Exception ex){
           ex.printStackTrace();
       }finally{
           factory.close();
       }
       return livreurs;
    }
    
    public static boolean updateLivreur(Personne ancLivreur,Personne nouvLivreur){
        boolean result = false;
        SessionFactory factory = SessionFunction.getSessionFactory();
        Session session = factory.getCurrentSession();
        try{
            session.beginTransaction();
            ancLivreur.setNom(nouvLivreur.getNom());
            ancLivreur.setPrenom(nouvLivreur.getPrenom());
            ancLivreur.setAdresse(nouvLivreur.getAdresse());
            ancLivreur.setNumero(nouvLivreur.getNumero());
            session.update(ancLivreur);
            session.getTransaction().commit();
            result = true;
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            factory.close();
        }
        return result;
    }
    
    public static boolean deleteLivreur(int idLivreur){
        boolean result = false;
        SessionFactory factory = SessionFunction.getSessionFactory();
        Session session = factory.getCurrentSession();
        try{
            session.beginTransaction();
            String sql = "DELETE FROM personne WHERE idPersonne = :id";
            String sqlAssoc = "DELETE FROM perssuper WHERE idPersonne = :id";
            SQLQuery query = session.createSQLQuery(sql);
            query.setParameter("id",idLivreur);
            SQLQuery queryassoc = session.createSQLQuery(sqlAssoc);
            queryassoc.setParameter("id",idLivreur);
            int confirmeDelete = query.executeUpdate();
            int confirmeDeleteAssoc = queryassoc.executeUpdate();
            result = confirmeDeleteAssoc != 0 && confirmeDeleteAssoc != -1 && confirmeDelete != 0 && confirmeDelete != -1;
            session.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            factory.close();
        }
        return result;
    }
}
