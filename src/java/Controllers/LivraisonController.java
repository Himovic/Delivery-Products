/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Functions.CommandeFunctions;
import Functions.LivraisonFunctions;
import Models.Livraison;
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
public class LivraisonController extends HttpServlet {

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
       
        String HiddenAssociateLivreur = request.getParameter("HiddenAssociateLivreur");
        if(HiddenAssociateLivreur != null){
            String idCommandeSelected = request.getParameter("idCommandeSelected");
            String commandesIds []  = idCommandeSelected.split(",");
            int idVisiteur = Integer.valueOf(request.getParameter("idVisiteur"));
            int idLivreur = Integer.valueOf(request.getParameter("idLivreur"));
            boolean updateCommande = CommandeFunctions.UpdateCommande(commandesIds,3);
            String result = "";
            if(updateCommande){
                Livraison livraison = new Livraison(idLivreur, idVisiteur, "En Attente");
                boolean confirmLivraison = LivraisonFunctions.addLivraison(livraison);
                if(confirmLivraison){
                    result = "success";
                }else{
                    result = "error";
                }
            }else{
                boolean reverseUpdateCommande = CommandeFunctions.UpdateCommande(commandesIds,2);
                result = "error";
            }
            response.setContentType("text/plain");
            response.getWriter().write(result);
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
