/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Functions.SupermarketFunction;
import Models.Supermarket;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class SupermarketControl extends HttpServlet {

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
        String HiddenRegisterSupermarket = request.getParameter("HiddenRegisterSupermarket");
        String HiddenLoginSupermarket = request.getParameter("HiddenLoginSupermarket");
        String HiddenDeleteSupermarket = request.getParameter("HiddenDeleteSupermarket");
        String HiddenShowInfoSuper = request.getParameter("HiddenShowInfoSuper");
        String HiddenConfirmUpdateSupermarket = request.getParameter("HiddenConfirmUpdateSupermarket");
        if(HiddenRegisterSupermarket != null){
            int idPersonne = Integer.valueOf(request.getParameter("idPersonne"));
        String nom = request.getParameter("nom");
        String adresse = request.getParameter("adresse");
        int numero = Integer.valueOf(request.getParameter("numero"));
        String user = request.getParameter("user");
        String password = request.getParameter("password");
        String status = "en cours de vérification";
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
	Date date = new Date();
	String stringDate = dateFormat.format(date);
        Supermarket supermarket = new Supermarket(nom,adresse,numero,user,password,status,stringDate);
        boolean confirmeAddSupermarket = SupermarketFunction.addSupermarket(supermarket,idPersonne);
        if(!confirmeAddSupermarket){
            String returnResult = "error";
            response.setContentType("text/plain");
            response.getWriter().write(returnResult);
        }else{
            String returnResult = "success";
            response.setContentType("text/plain");
            response.getWriter().write(returnResult);
            }
        }
     
        if(HiddenLoginSupermarket != null){
            RequestDispatcher dispatcher = null;
            String user = request.getParameter("user");
            String password = request.getParameter("password");
            Supermarket supermarket = SupermarketFunction.authenticateSupermarket(user, password);
            if(supermarket == null){
                String returnResult = "error";
                response.setContentType("text/plain");
		response.getWriter().write(returnResult);
            }else{
                System.out.println("ID OF SUPERMARKET  IS : "+supermarket.getId());
                request.getSession().setAttribute("idSupermarket",supermarket.getId());
                //request.setAttribute("idSupermarket",supermarket.getId());
            }
        }
        
        if(HiddenDeleteSupermarket != null){
            int idSupermarket = Integer.valueOf(request.getParameter("idSupermarket"));
            Supermarket supermarket = SupermarketFunction.getSupermarketFromId(idSupermarket);
            boolean confirmeSuppresion = SupermarketFunction.deleteSupermarket(supermarket);
            if(!confirmeSuppresion){
                String returnResult = "error";
                response.setContentType("text/plain");
		response.getWriter().write(returnResult);
            }else{
                
            }
        }
        
        if(HiddenShowInfoSuper != null){
            int idSupermarket = Integer.valueOf(request.getParameter("id"));
            Supermarket supermarket = SupermarketFunction.getSupermarketFromId(idSupermarket);
            if(supermarket == null){
                String returnResult = "error";
                response.setContentType("text/plain");
		response.getWriter().write(returnResult);
            }else{
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("nom",supermarket.getNom());
                jsonObject.addProperty("adresse",supermarket.getAdresse());
                jsonObject.addProperty("numero",supermarket.getNumero());
                jsonObject.addProperty("user",supermarket.getUsername());
                String returnResult = jsonObject.toString();
                System.out.println("result : "+returnResult);
                response.setContentType("text/plain");
		response.getWriter().write(returnResult);
            }
        }
        
        if(HiddenConfirmUpdateSupermarket != null){
            int id = Integer.valueOf(request.getParameter("id"));
            String nom = request.getParameter("nom");
            String adresse = request.getParameter("adresse");
            int numero = Integer.valueOf(request.getParameter("numero"));
            String user = request.getParameter("user");
            Supermarket oldSupermarket = SupermarketFunction.getSupermarketFromId(id);
            Supermarket newSupermarket = new Supermarket(nom, adresse, numero, user);
            boolean confirmUpdate = SupermarketFunction.updateSupermarket(oldSupermarket,newSupermarket);
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
