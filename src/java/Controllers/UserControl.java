/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Functions.ImportantFunctions;
import Functions.UsersFunctions;
import Models.Personne;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author lenovo
 */
public class UserControl extends HttpServlet {



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
        String verification = request.getParameter("verif");
        if(verification != null){
            RequestDispatcher dispatcher = null;
            String code = request.getParameter("code").replace(" ","+");
            System.out.println("code : "+code);
            String decryptedCode = "";
            try {
                decryptedCode = ImportantFunctions.decryptEmail(code);
            } catch (Exception ex) {
                Logger.getLogger(UserControl.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("email : "+decryptedCode);
            boolean confirmationUser = UsersFunctions.systemConfirmationUser(decryptedCode);
            if(confirmationUser){
                dispatcher = request.getRequestDispatcher("login_confirm_success.html");
            }else{
                dispatcher = request.getRequestDispatcher("login_confirm_error.html");
            }
            dispatcher.forward(request, response);
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
        String HiddenLoginValue = request.getParameter("HiddenLoginValue");
        String HiddenRegisterValue = request.getParameter("HiddenRegisterValue");
        String HiddenUpdateInfo = request.getParameter("HiddenUpdateInfo");
        if(HiddenLoginValue != null){
            String email = request.getParameter("email");
            String password="";
            try {
                password = UsersFunctions.encryptPasswordMD5(request.getParameter("password"));
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(UserControl.class.getName()).log(Level.SEVERE, null, ex);
            }
            Personne personne = UsersFunctions.authentification(email, password);
            if(personne == null){
                String returnResult = "error";
                response.setContentType("text/plain");
		response.getWriter().write(returnResult);
            }else{
                HttpSession session = request.getSession();
		session.setAttribute("nom",personne.getNom());
		session.setAttribute("prenom",personne.getPrenom());
                session.setAttribute("email",personne.getEmail());
            }
        }
        
        if(HiddenRegisterValue != null){
            String nom = request.getParameter("nom");
            String prenom = request.getParameter("prenom");
            String adresse = request.getParameter("adresse");
            int numero = Integer.parseInt(request.getParameter("numero"));
            String type = request.getParameter("type");
            String email = request.getParameter("email");
            String password = "";
            int confirme =0;
            try {
                password = UsersFunctions.encryptPasswordMD5(request.getParameter("password"));
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(UserControl.class.getName()).log(Level.SEVERE, null, ex);
            }
            Personne personne = new Personne(nom, prenom, adresse, numero, type, email, password, confirme);
            boolean InscriptionResult = UsersFunctions.inscription(personne);
            if(!InscriptionResult){
                String returnResult = "error";
                response.setContentType("text/plain");
		response.getWriter().write(returnResult);
            }else{
                boolean mailConfirmeSend = false;
                try {
                    mailConfirmeSend = ImportantFunctions.sendConfirmationEmail(email);
                } catch (Exception ex) {
                    Logger.getLogger(UserControl.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(!mailConfirmeSend){
                    String returnResult = "errormail";
                    response.setContentType("text/plain");
                    response.getWriter().write(returnResult);
                }else{
                    //everything is fine
                }
            }
        }
        
        if(HiddenUpdateInfo != null){
            String nom = request.getParameter("nom");
            String prenom = request.getParameter("prenom");
            String adresse = request.getParameter("adresse");
            int numero = Integer.valueOf(request.getParameter("numero"));
            String type = request.getParameter("type");
            int idPersonne = Integer.valueOf(request.getParameter("idPersonne"));
            Personne oldPersonne = UsersFunctions.getPersonneFromId(idPersonne);
            Personne newPersonne = new Personne(nom,prenom,adresse,numero,type);
            boolean confirmUpdate = UsersFunctions.updatePersonne(newPersonne,oldPersonne);
            if(!confirmUpdate){
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
