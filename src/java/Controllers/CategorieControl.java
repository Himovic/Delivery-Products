/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Functions.CategorieFunction;
import Models.Categorie;
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
public class CategorieControl extends HttpServlet {

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
        
        String HiddenAddCategorie = request.getParameter("HiddenAddCategorie");
        String HiddenDeleteCategorie = request.getParameter("HiddenDeleteCategorie");
        String HiddenShowInfoUpdate = request.getParameter("HiddenShowInfoUpdate");
        if(HiddenAddCategorie != null){
            Categorie cat = new Categorie(request.getParameter("nomCat"));
            int idSupermarket = Integer.valueOf(request.getParameter("idSupermarket"));
            boolean confirmAddCat = CategorieFunction.addCategorie(cat, idSupermarket);
            if(!confirmAddCat){
                String returnResult = "error";
                response.setContentType("text/plain");
		response.getWriter().write(returnResult);
            }else{
                
            }
        }
        
        if(HiddenDeleteCategorie != null){
            int idCategorie = Integer.valueOf(request.getParameter("idCategorie"));
            Categorie cat = CategorieFunction.getCategorieFromId(idCategorie);
            boolean confirmDelete = CategorieFunction.deleteCategorie(cat);
            if(!confirmDelete){
                String returnResult = "error";
                response.setContentType("text/plain");
		response.getWriter().write(returnResult);
            }else{
                
            }
        }
        
        if(HiddenShowInfoUpdate != null){
            System.out.println("Update case show");
            int idCategorie = Integer.valueOf(request.getParameter("idCategorie"));
            System.out.println("id category in catcontrol :"+idCategorie);
            /*Categorie cat = CategorieFunction.getCategorieFromId(idCategorie);
            if(cat == null){
                String returnResult = "error";
                response.setContentType("text/plain");
		response.getWriter().write(returnResult);
            }else{
                System.out.println("Cat : "+cat.getNom());
                String returnResult = cat.getNom();
                response.setContentType("text/plain");
		response.getWriter().write(returnResult);
            }*/
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
