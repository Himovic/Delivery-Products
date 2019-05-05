<%-- 
    Document   : administrateur
    Created on : 25 mars 2019, 10:45:41
    Author     : lenovo
--%>

<%@page import="java.util.List"%>
<%@page import="Models.Supermarket"%>
<%@page import="Functions.AdminFunction"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listes Supermarché A Confirmer</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <% 
        List<Supermarket> supermarket = AdminFunction.listSupermarketToConfirm();
    %>
    <body>
        <div class="container mt-3">
            <%if(supermarket.size() == 0){%>
                <h3>Aucun supermarché est en attente pour le moment</h3>
            <%}else{%>
                <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Nom résponsable</th>
                        <th>Prénom résponsable</th>
                        <th>Numéro résponsable</th>
                        <th>Nom supermarché</th>
                        <th>Adresse supermarché</th>
                        <th>Numéro suermarché</th>
                        <th>Confirmer</th>
                        <th>Annuler</th>
                    </tr>
                </thead>
                <tbody>
                    <%for(int i=0; i<supermarket.size();i++){%>
                    <tr>
                        <td><%= supermarket.get(i).getAdministrators().get(0).getNom() %></td>
                        <td><%= supermarket.get(i).getAdministrators().get(0).getPrenom() %></td>
                        <td><%= supermarket.get(i).getAdministrators().get(0).getNumero() %></td>
                        <td><%= supermarket.get(i).getNom() %></td>
                        <td><%= supermarket.get(i).getAdresse() %></td>
                        <td><%= supermarket.get(i).getNumero() %></td>
                        <td><button type="button" id="confirm-supermarket" class="btn btn-primary">Confirmer</button></td>
                        <td><button type="button" id="reject-supermarket" class="btn btn-danger">Annuler</button></td>
                        <input type="hidden" id="idSupermarket" value="<%= supermarket.get(i).getId() %>"
                    </tr>
                    <%}%>
                </tbody>
            </table>
            <%}%>
        </div>
    </body>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script src="confirmSupermarket.js"></script>
<script src="rejectSupermarket.js"></script>
<script src="jquery-3.2.1.min.js"></script>
</html>
