/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Functions.CategorieFunction;
import Functions.ProductFunction;
import Models.Categorie;
import Models.Produit;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lenovo
 */
public class ProductControl extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String HiddenAddProduct = request.getParameter("HiddenAddProduct");
        String HiddenShowInfoProduct = request.getParameter("HiddenShowInfoProduct");
        String HiddenConfirmUpdateProduct = request.getParameter("HiddenConfirmUpdateProduct");
        String HiddenDeleteProduct = request.getParameter("HiddenDeleteProduct");
        if(HiddenAddProduct != null){
            String nomProd = request.getParameter("nomProd");
            int qteProd = Integer.valueOf(request.getParameter("qteProd"));
            double prixProd = Double.valueOf(request.getParameter("prixProd"));
            int idCat = Integer.valueOf(request.getParameter("cat_value"));
            int idSupermarket = Integer.valueOf(request.getParameter("idSuper"));
            Produit produit = new Produit(nomProd,qteProd,prixProd);
            boolean confirmAddProduct = ProductFunction.addProduct(produit, idSupermarket, idCat);
            if(!confirmAddProduct){
                String returnResult = "error";
                response.setContentType("text/plain");
		response.getWriter().write(returnResult);
            }else{
                
            }
        }
        
        if(HiddenShowInfoProduct != null){
            int idProduct = Integer.valueOf(request.getParameter("idProduit"));
            Produit produit = ProductFunction.getProduitFromId(idProduct);
            if(produit == null){
                String returnResult = "error";
                response.setContentType("text/plain");
		response.getWriter().write(returnResult);
            }else{
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("nom",produit.getNom());
                jsonObject.addProperty("quantite",produit.getQuantite());
                jsonObject.addProperty("prix",produit.getPrix());
                jsonObject.addProperty("categorie",produit.getCategorie().getNom());
                jsonObject.addProperty("idProduit",produit.getId());
                String returnResult = jsonObject.toString();
                System.out.println("result : "+returnResult);
                response.setContentType("text/plain");
		response.getWriter().write(returnResult);
            }
        }
        
        if(HiddenConfirmUpdateProduct != null){
            int idProduit = Integer.valueOf(request.getParameter("idProduit"));
            Produit oldProduit = ProductFunction.getProduitFromId(idProduit);
            String newNom = request.getParameter("newNom");
            int newQte = Integer.valueOf(request.getParameter("newQte"));
            double newPrix = Double.valueOf(request.getParameter("newPrix"));
            Produit newProduit = new Produit(newNom,newQte,newPrix);
            boolean confirmUpdate = ProductFunction.updateProduct(oldProduit, newProduit);
            if(!confirmUpdate){
                String returnResult = "error";
                response.setContentType("text/plain");
		response.getWriter().write(returnResult);
            }else{
                
            }
        }
        
        if(HiddenDeleteProduct != null){
            int idProduit = Integer.valueOf(request.getParameter("idProduit"));
            boolean confirmDelete = ProductFunction.deleteProduct(idProduit);
            if(!confirmDelete){
                String returnResult = "error";
                response.setContentType("text/plain");
		response.getWriter().write(returnResult);
            }else{
                
            }
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
