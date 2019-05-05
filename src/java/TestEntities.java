
import Functions.SessionFunction;
import Functions.SupermarketFunction;
import Functions.UsersFunctions;
import Models.Categorie;
import Models.Personne;
import Models.Produit;
import Models.Supermarket;
import com.mchange.v1.util.IteratorUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */ 

/**
 *
 * @author lenovo
 */
public class TestEntities {
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
    public static void main(String[]args){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Personne.class)
                .addAnnotatedClass(Supermarket.class)
                .addAnnotatedClass(Produit.class)
                .addAnnotatedClass(Categorie.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        try{
            //session.beginTransaction();
            /**
             * Using save options
             * /
            /*Personne personne_one = new Personne("CHABANE","HICHEM","Cité Boussouf, Constantine",
                    542216729,"admin","chabannehichem@gmail.com","hichem");
            Personne personne_two = new Personne("CHEHILI","HOUSSEM","Saint jean, Constantine",
                    542216729,"admin","chehilihoussem@gmail.com","houssem");
            session.save(personne_one);
            session.save(personne_two);*/
            /*Personne admin = (Personne) session.get(Personne.class,1);
            List<Personne> administrators = new ArrayList<Personne>();
            administrators.add(admin);
            Supermarket super_one = new Supermarket("Ritej","Ali Mendjli",31525252,"ritej_15","ritej");
            Supermarket super_two = new Supermarket("Rahma","Ali Mendjli",31888995,"rahma_43","rahma");
            super_one.setAdministrators(administrators);
            super_two.setAdministrators(administrators);
            session.save(super_one);
            session.save(super_two);*/
            /*Categorie cat_one = new Categorie("Boissons");
            Categorie cat_two = new Categorie("Produits laitiers");
            session.save(cat_one);
            session.save(cat_two);*/
            /*Supermarket supermarket = (Supermarket) session.get(Supermarket.class,4);
            Categorie boisson = (Categorie) session.get(Categorie.class,1);
            Categorie produits_lait = (Categorie) session.get(Categorie.class,2);
            Produit prod_one = new Produit("O Jue",30,100);
            Produit prod_two = new Produit("Yaourt",200,25);
            prod_one.setCategorie(boisson);
            prod_two.setCategorie(produits_lait);
            List<Supermarket> supermarkets = new ArrayList<>();
            supermarkets.add(supermarket);
            prod_one.setSupermarkets(supermarkets);
            prod_two.setSupermarkets(supermarkets);
            session.save(prod_one);
            session.save(prod_two);*/
            /*
                Using read options
            */
            /*Personne p = (Personne) session.get(Personne.class,1);
            System.out.println(p.getNom()+" "+p.getPrenom());
            List<Supermarket> supermarkets = p.getSupermarkets();
            for(int i=0; i<supermarkets.size(); i++){
                System.out.println(supermarkets.get(i).getNom());
            }
            //System.out.println(p.getSupermarkets().toString());*/
            /*Supermarket s = (Supermarket) session.get(Supermarket.class,3);
            List<Produit> produits = s.getProduits();
            for(int i=0; i<produits.size(); i++){
                System.out.println(produits.get(i).getNom()+" - "+produits.get(i).getPrix()+"DA, avec la catégorie : "+produits.get(i).getCategorie().getNom());
            }*/
            /*int id = UsersFunctions.getIdFromEmail("chabannehichem@gmail.com");
            System.out.println("ID : "+id);
            session.getTransaction().commit();*/
            System.out.println(TestEntities.encryptPasswordMD5("aymen16"));
            System.out.println("done");
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            factory.close();
        }
        
    }
}
