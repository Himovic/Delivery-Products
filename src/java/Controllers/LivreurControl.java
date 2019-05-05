/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Functions.SupermarketFunction;
import Functions.UsersFunctions;
import Models.Personne;
import Models.Supermarket;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lenovo
 */
public class LivreurControl extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LivreurControl</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LivreurControl at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        processRequest(request, response);
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
        String HiddenAddLivreur = request.getParameter("HiddenAddLivreur");
        String HiddenShowInfoLivreur = request.getParameter("HiddenShowInfoLivreur");
        String HiddenConfirmLivreur = request.getParameter("HiddenConfirmLivreur");
        String HiddenDeleteLivreur = request.getParameter("HiddenDeleteLivreur");
        if(HiddenAddLivreur != null){
            String NomLivreur = request.getParameter("NomLivreur");
            String PrenomLivreur = request.getParameter("PrenomLivreur");
            String AdresseLivreur = request.getParameter("AdresseLivreur");
            int NumeroLivreur = Integer.valueOf(request.getParameter("NumeroLivreur"));
            String UserLivreur = request.getParameter("UserLivreur");
            String PasswordLivreur = request.getParameter("PasswordLivreur");
            int idSupermarket = Integer.valueOf(request.getParameter("idSupermarket"));
            Supermarket sup = SupermarketFunction.getSupermarketFromId(idSupermarket);
            List<Supermarket> livSup = new ArrayList<>();
            livSup.add(sup);
            int confirm = 1;
            String TypeLivreur="livreur";
            Personne p = new Personne(NomLivreur,PrenomLivreur,AdresseLivreur,NumeroLivreur,TypeLivreur,UserLivreur,PasswordLivreur, confirm);
            p.setSupermarkets(livSup);
            boolean confirmAddLivreur = UsersFunctions.inscription(p);
            if(!confirmAddLivreur){
                String returnResult = "error";
                response.setContentType("text/plain");
		response.getWriter().write(returnResult);
            }else{
                
            }
        }
        
        if(HiddenShowInfoLivreur != null){
            int idLivreur = Integer.valueOf(request.getParameter("idLivreurHidden"));
            Personne livreur = UsersFunctions.getPersonneFromId(idLivreur);
            JsonObject livObject = new JsonObject();
            livObject.addProperty("nom",livreur.getNom());
            livObject.addProperty("prenom",livreur.getPrenom());
            livObject.addProperty("adresse",livreur.getAdresse());
            livObject.addProperty("numero",livreur.getNumero());
            livObject.addProperty("id",idLivreur);
            if(livreur == null){
                String returnResult = "error";
                response.setContentType("text/plain");
                response.getWriter().write(returnResult);
            }else{
                String returnResult = livObject.toString();
                response.setContentType("text/plain");
                response.getWriter().write(returnResult);
            }
            
        }
        
        if(HiddenConfirmLivreur != null){
            String nomLivreur = request.getParameter("nomLivreur");
            String prenomLivreur = request.getParameter("prenomLivreur");
            String adresseLivreur = request.getParameter("adresseLivreur");
            int numeroLivreur = Integer.valueOf(request.getParameter("numeroLivreur"));
            System.out.println("id in string : "+request.getParameter("idLivreur"));
            int idLivreur = Integer.valueOf(request.getParameter("idLivreur"));
            
            Personne nouvLivreur = new Personne(nomLivreur,prenomLivreur,adresseLivreur,numeroLivreur);
            Personne ancLivreur = UsersFunctions.getPersonneFromId(idLivreur);
            boolean resultUpdate = UsersFunctions.updateLivreur(ancLivreur, nouvLivreur);
            if(!resultUpdate){
                String returnResult = "error";
                response.setContentType("text/plain");
                response.getWriter().write(returnResult);
            }else{
                
            }
        }
        
        if(HiddenDeleteLivreur != null){
            int idLivreur = Integer.valueOf(request.getParameter("idLivreur"));
            boolean confirmDelete = UsersFunctions.deleteLivreur(idLivreur);
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
