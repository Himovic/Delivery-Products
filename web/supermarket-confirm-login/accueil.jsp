<%-- 
    Document   : index
    Created on : 23 mars 2019, 09:53:39
    Author     : lenovo
--%>

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
	<title>Gestion du supermarché</title>
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
    int commandeEnAttente = CommandeFunctions.commandeEnAttente(Integer.valueOf(ss));
    List<Visiteur> visiteursCommandes = CommandeFunctions.getVisitorsOfCommandes(Integer.valueOf(ss));
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
					<li><a class="" href="livraisons.jsp">
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
				<h1 class="page-header">Acceuil</h1>
			</div>
		</div><!--/.row-->
		
		<div class="panel panel-container">
			<div class="row">
				<div class="col-xs-6 col-md-3 col-lg-3 no-padding">
					<div class="panel panel-teal panel-widget border-right">
						<div class="row no-padding"><em class="fa fa-xl fa-shopping-cart color-blue"></em>
							<div class="large">120</div>
							<div class="text-muted">Nombre de produits</div>
						</div>
					</div>
				</div>
				<div class="col-xs-6 col-md-3 col-lg-3 no-padding">
					<div class="panel panel-blue panel-widget border-right">
						<div class="row no-padding"><em class="fa fa-xl fa-comments color-orange"></em>
							<div class="large">52</div>
							<div class="text-muted">Produits commandés</div>
						</div>
					</div>
				</div>
				<div class="col-xs-6 col-md-3 col-lg-3 no-padding">
					<div class="panel panel-orange panel-widget border-right">
						<div class="row no-padding"><em class="fa fa-xl fa-users color-teal"></em>
							<div class="large">24</div>
							<div class="text-muted">Livraisons en attente</div>
						</div>
					</div>
				</div>
				<div class="col-xs-6 col-md-3 col-lg-3 no-padding">
					<div class="panel panel-red panel-widget ">
						<div class="row no-padding"><em class="fa fa-xl fa-search color-red"></em>
							<div class="large">25</div>
							<div class="text-muted">Livraisons confirmées</div>
						</div>
					</div>
				</div>
			</div><!--/.row-->
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
	<script>
		window.onload = function () {
	var chart1 = document.getElementById("line-chart").getContext("2d");
	window.myLine = new Chart(chart1).Line(lineChartData, {
	responsive: true,
	scaleLineColor: "rgba(0,0,0,.2)",
	scaleGridLineColor: "rgba(0,0,0,.05)",
	scaleFontColor: "#c5c7cc"
	});
};
	</script>
		
</body>
</html>
