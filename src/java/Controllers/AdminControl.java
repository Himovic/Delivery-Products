/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Functions.AdminFunction;
import Functions.ImportantFunctions;
import Functions.SupermarketFunction;
import Models.Supermarket;
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
public class AdminControl extends HttpServlet {

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
            out.println("<title>Servlet AdminControl</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminControl at " + request.getContextPath() + "</h1>");
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
        String HiddenConfirmSupermarket = request.getParameter("HiddenConfirmSupermarket");
        String HiddenRejectSupermarket = request.getParameter("HiddenRejectSupermarket");
        if(HiddenConfirmSupermarket != null){
            int idSupermarket = Integer.valueOf(request.getParameter("idSupermarket"));
            String numeroAdmin = request.getParameter("numeroAdmin");
            Supermarket sup = SupermarketFunction.getSupermarketFromId(idSupermarket);
            String message = "Le supermarché portant le nom de : "+sup.getNom()+" situé dans l'adresse suivante : "
                    + ""+sup.getAdresse()+" et a été inscrit en : "+sup.getDate()+
                    " a été vérifier et valider avec succées. \n Vous pouvez utiliser nos services maintenant. "
                    + "\n On vous remercie de votre confiance";
            boolean confirmUpdateStauts = AdminFunction.updateSupermarketStatus(idSupermarket);
            if(!confirmUpdateStauts){
                String returnResult = "error";
                response.setContentType("text/plain");
		response.getWriter().write(returnResult);
            }else{
                String resultSendSms = ImportantFunctions.sendMessageToPhone(numeroAdmin,message);
            }
        }
        
        if(HiddenRejectSupermarket != null){
            int idSupermarket = Integer.valueOf(request.getParameter("idSupermarket"));
            String numeroAdmin = request.getParameter("numeroAdmin");
            Supermarket sup = SupermarketFunction.getSupermarketFromId(idSupermarket);
            String message = "Le supermarché portant le nom de : "+sup.getNom()+" situé dans l'adresse suivante : "
                    + ""+sup.getAdresse()+" et a été inscrit en : "+sup.getDate()+
                    " a été rejeter parce qu'il n'est pas en régle administrative ou il n'est pas dans les normes. "
                    + "\n Merci de votre compréhension";
            boolean confirmRejectSupermarket = AdminFunction.rejectSupermarket(idSupermarket);
            if(!confirmRejectSupermarket){
                String returnResult = "error";
                response.setContentType("text/plain");
		response.getWriter().write(returnResult);
            }else{
                String resultSendSms = ImportantFunctions.sendMessageToPhone(numeroAdmin,message);
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
