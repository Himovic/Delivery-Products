<%-- 
    Document   : index
    Created on : 23 mars 2019, 09:53:39
    Author     : lenovo
--%>

<%@page import="Models.Coordinate"%>
<%@page import="Functions.PlacesFunctions"%>
<%@page import="Models.CommandeInfo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Models.Visiteur"%>
<%@page import="java.util.List"%>
<%@page import="Functions.CommandeFunctions"%>
<%@page import="Models.Supermarket"%>
<%@page import="Functions.SupermarketFunction"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Consultation des factures</title>
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/font-awesome.min.css" rel="stylesheet">
	<link href="css/datepicker3.css" rel="stylesheet">
	<link href="css/styles.css" rel="stylesheet">
	
	<!--Custom Font-->
	<link href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">
	<!--[if lt IE 9]>
	<script src="js/html5shiv.js"></script>
	<script src="js/respond.min.js"></script>
	<![endif]-->
</head>
<%
    Object idSupermarket = request.getSession().getAttribute("idSupermarket");
    String ss = idSupermarket.toString();
    Supermarket supermarket = SupermarketFunction.getSupermarketFromId(Integer.valueOf(ss));
    Coordinate suprCoordinate = PlacesFunctions.getLatLongFromAdresse(supermarket.getAdresse());
    int commandeEnAttente = CommandeFunctions.commandeEnAttente(Integer.valueOf(ss));
    List<Visiteur> visiteursCommandes = CommandeFunctions.getVisitorsOfCommandes(Integer.valueOf(ss));
    double montantProduit = 0.0;
    int idVisiteur =0;
%>
<body>
	<nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#sidebar-collapse"><span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span></button>
				<a class="navbar-brand" href="#"><span>GERER DES</span>Produits et des factures</a>
				<ul class="nav navbar-top-links navbar-right">
					
					<li class="dropdown"><a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
						<em class="fa fa-bell"></em><span class="label label-info"><%=commandeEnAttente%></span>
					</a>
						<ul class="dropdown-menu dropdown-alerts">
                                                    <%if(commandeEnAttente == 0){%>
                                                        
                                                        <h6>Aucune commande en attente</h6>
                                                    
                                                    <%}else{%>
                                                        <h6>Vous avez <%=commandeEnAttente%> Commande(s) de la part de ce(s) client(s) :</h6>
                                                        <%for(int i=0 ; i<visiteursCommandes.size();i++){ String fullName =visiteursCommandes.get(i).getNom() + " "+ visiteursCommandes.get(i).getPrenom();%>
                                                        <p><%= fullName%></p>
                                                        <%}}%>
                                                    
						</ul>
					</li>
				</ul>
			</div>
		</div><!-- /.container-fluid -->
	</nav>
	<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
		<div class="profile-sidebar">
			<div class="profile-userpic">
				<img src="http://placehold.it/50/30a5ff/fff" class="img-responsive" alt="">
			</div>
			<div class="profile-usertitle">
				<div class="profile-usertitle-name"><%= supermarket.getNom() %></div>
				<div class="profile-usertitle-status"><span class="indicator label-success"></span><%= supermarket.getAdresse() %></div>
			</div>
			<div class="clear"></div>
		</div>
		<div class="divider"></div>
		<ul class="nav menu">
			<li class="active"><a href="index.jsp"><em class="fa fa-dashboard">&nbsp;</em>Accueil</a></li>
                        <li class="active"><a href="categorie.jsp"><em class="fa fa-dashboard">&nbsp;</em>Gérer les catégories</a></li>
			<li class="active"><a href="products.jsp"><em class="fa fa-dashboard">&nbsp;</em>Gérer les produits</a></li>
			<li class="parent "><a data-toggle="collapse" href="#sub-item-1">
				<em class="fa fa-navicon">&nbsp;</em>Gestion des livraisons<span data-toggle="collapse" href="#sub-item-1" class="icon pull-right"><em class="fa fa-plus"></em></span>
				</a>
				<ul class="children collapse" id="sub-item-1">
					<li><a class="" href="livreurs.jsp">
						<span class="fa fa-arrow-right">&nbsp;</span>Ajouter des livreurs
					</a></li>
					<li><a class="" href="factures.jsp">
						<span class="fa fa-arrow-right">&nbsp;</span>Consulter les factures
					</a></li>
					<li><a class="" href="#">
						<span class="fa fa-arrow-right">&nbsp;</span>Confirmer les livraisons
					</a></li>
				</ul>
			</li>
			<li><a href="#"><em class="fa fa-power-off">&nbsp;</em>Déconnecter</a></li>
		</ul>
	</div><!--/.sidebar-->
		
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
		
		
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Consultation des factures</h1>
			</div>
		</div><!--/.row-->
		
		<div class="panel panel-container">
                    <%if(visiteursCommandes.size() == 0){%>
                        <h5>Aucune commande éxistée pour le moment</h5>
                        <%}else{%>
                                <%
                                for(int j=0;j<visiteursCommandes.size();j++){
                                idVisiteur = visiteursCommandes.get(j).getIdVisiteur();
                                String fullName = visiteursCommandes.get(j).getNom()+" "+ visiteursCommandes.get(j).getPrenom();
                                Coordinate livrCoordinate = PlacesFunctions.getLatLongFromAdresse(visiteursCommandes.get(j).getAdresse());
                                double calculateDistance = PlacesFunctions.calculateDistance(suprCoordinate,livrCoordinate);
                                List<CommandeInfo> commandesInfo = CommandeFunctions.getCommandeInfo(visiteursCommandes.get(j).getIdVisiteur(),Integer.valueOf(ss));
                                %>
                                <h5>Pour le client <strong style="color:darkgreen;"><%=fullName%></strong>, il(elle) a le(s) commande(s) suivante(s) : </h5>
                                <table id="commandeInfo" class="table table-striped">
                                    <thead class="thead-dark">
                                        <tr>
                                            <th>Sélection commande</th>
                                            <th>Produit</th>
                                            <th>Quantité commandée</th>
                                            <th>Prix</th>
                                            <th>Prix totale</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%for(int k=0; k<commandesInfo.size();k++){%>
                                            <%montantProduit = montantProduit + commandesInfo.get(k).getPrixTot();%>
                                            <tr>
                                                <td><input type="checkbox" id="idCommande" value="<%= commandesInfo.get(k).getId() %>" /></td>
                                                <td><%= commandesInfo.get(k).getNomProduit() %></td>
                                                <td><%= commandesInfo.get(k).getQuantite() %></td>
                                                <td><%= commandesInfo.get(k).getPrix() %> DA</td>
                                                <td><%= commandesInfo.get(k).getPrixTot() %> DA</td>
                                            </tr>
                                    <input type="hidden" id="idVisiteurD" value="<%= visiteursCommandes.get(j).getIdVisiteur() %>"/>
                                        <%}%>
                                    </tbody>
                                </table>
                                    <%double prixLivraison = PlacesFunctions.calculatePrixLivraison(calculateDistance);%>
                                    <h5 id="montantProduit">Montant produit : <%= montantProduit %> DA</h5>
                                    <h5 id="prixLivraison">Prix livraison : <%= prixLivraison %> DA</h5>
                                    <%double totalFinal = montantProduit + prixLivraison; %>
                                    <h5 id="montantTotal">Montant total : <%= totalFinal %> DA</h5>
                            <%montantProduit = 0.0;}%>
                            <button type="button" class="btn btn-danger" id="confirmCommande">Confirmer</button>
                            <hr>
                        <%}%>
                </div>
		

	</div>	<!--/.main-->
	
	<script src="js/jquery-1.11.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/chart.min.js"></script>
	<script src="js/chart-data.js"></script>
	<script src="js/easypiechart.js"></script>
	<script src="js/easypiechart-data.js"></script>
	<script src="js/bootstrap-datepicker.js"></script>
	<script src="js/custom.js"></script>
        <script src="js/confirmeCommande.js"></script>
		
</body>
</html>
