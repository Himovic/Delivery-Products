/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Functions.CommandeFunctions;
import Functions.FactureFunctions;
import Functions.ImportantFunctions;
import Functions.UsersFunctions;
import Functions.VisiteurFunction;
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
public class CommandeController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

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
        System.out.println("Test servlet");
        String HiddenConfirmeCommande = request.getParameter("HiddenConfirmeCommande");
        if(HiddenConfirmeCommande != null){
            String idCommandeSelected = request.getParameter("idCommandeSelected");
            double priceProduit = Double.valueOf(request.getParameter("priceProduit"));
            double priceLivraison = Double.valueOf(request.getParameter("priceLivraison"));
            double priceTotal = Double.valueOf(request.getParameter("priceTotal"));
            int idVisiteur = Integer.valueOf(request.getParameter("idVisiteur"));
            System.out.println("ID VISITEUR : "+idVisiteur);
            String splitIdCommandes[] = idCommandeSelected.split(",");
            boolean updateCommande = CommandeFunctions.UpdateCommande(splitIdCommandes,2);
            String showResult = "";
            if(updateCommande){
                boolean insertFacture = FactureFunctions.addFacture(idVisiteur, priceProduit, priceLivraison, priceTotal);
                if(insertFacture){
                    int number = VisiteurFunction.getVisiteurById(idVisiteur).getNumero();
                    String stringNumber = "0"+number;
                    String messageConfirmation = ImportantFunctions.generateMessageConfirmation(idVisiteur, priceProduit, priceLivraison, priceTotal);
                    String sendMsg = ImportantFunctions.sendMessageToPhone(stringNumber,messageConfirmation);
                    showResult ="success";
                    response.setContentType("text/plain");
                    response.getWriter().write(showResult);
                }else{
                    showResult = "error";
                    response.setContentType("text/plain");
                    response.getWriter().write(showResult);
                }
            }else{
                showResult = "error";
                response.setContentType("text/plain");
                response.getWriter().write(showResult);
            }
            
            System.out.println("ID COMMANDES : "+idCommandeSelected);
            System.out.println("PRICE PRODUIT : "+priceProduit);
            System.out.println("PRICE LIVRAISON : "+priceLivraison);
            System.out.println("PRICE TOTAL : "+priceTotal);
            System.out.println("ID VISITEUR : "+idVisiteur);
        }
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
