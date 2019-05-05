<%@page import="Functions.CommandeFunctions"%>
<%@page import="Models.Visiteur"%>
<%@page import="Models.Produit"%>
<%@page import="Functions.ProductFunction"%>
<%@page import="java.util.List"%>
<%@page import="Models.Categorie"%>
<%@page import="Functions.CategorieFunction"%>
<%@page import="Models.Supermarket"%>
<%@page import="Functions.SupermarketFunction"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Gestion des produits</title>
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
    List<Categorie> listCat = CategorieFunction.listCategorie(Integer.valueOf(ss));
    List<Produit> listProd = (List<Produit>) ProductFunction.listProduit(Integer.valueOf(ss));
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
					<li><a class="" href="#">
						<span class="fa fa-arrow-right">&nbsp;</span>Ajouter des livreurs
					</a></li>
					<li><a class="" href="#">
						<span class="fa fa-arrow-right">&nbsp;</span>Confirmer les livraisons
					</a></li>
					<li><a class="" href="#">
						<span class="fa fa-arrow-right">&nbsp;</span>Consulter les factures
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
			<button type="button" id="show_add_product" class="btn btn-success">Ajouter un produit</button>
                        <form method="POST" id="confirm_show_add_product">
                            <br>
                            <select class="form-control" id="categorie">
                                <option value="0">Sélectionner une catégorie</option>
                                <%for(int i=0;i<listCat.size();i++){ %>
                                <option value="<%= listCat.get(i).getId() %>"><%= listCat.get(i).getNom() %></option>
                                <%}%>
                            </select>
                            <div id="show_options_form">
                                
                                <div class="form-group">
                                    <label for="nomProd">Nom produit</label>
                                    <input type="text" id="nomProd" placeholder="Entrer le nom du produit" class="form-control"/>
                                </div>
                                <div class="form-group">
                                    <label for="qteProd">Quantité</label>
                                    <input type="number" id="qteProd" placeholder="Entrer la quantité existées" class="form-control"/>
                                </div>
                                <div class="form-group">
                                    <label for="prixProd">Prix</label>
                                    <input type="text" id="prixProd" placeholder="Entrer le prix du produit" class="form-control"/>
                                </div>
                                <input type="hidden" id="idSuper" value="<%=idSupermarket%>"/>
                                <button type="button" class="btn btn-danger" id="confirm-add-product">Confirmer</button>
                            </div>
                        </form>
                        
                                <br>
                                <%if(listProd.size() == 0){%>
                                    <h3>Aucune produit éxiste dans le supermarché</h3>
                                <%}else{%>
                                <table class="table table-striped">
                                    <thead>
                                        <tr>
                                            <th>Nom</th>
                                            <th>Quantité</th>
                                            <th>Prix</th>
                                            <th>Catégorie</th>
                                            <th>Modifier</th>
                                            <th>Supprimer</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%for(int i=0; i<listProd.size();i++){%>
                                            <input type="hidden" id="idProduitHidden" value="<%= listProd.get(i).getId() %>"/>
                                            <tr>
                                                <td><%= listProd.get(i).getNom() %></td>
                                                <td><%= listProd.get(i).getQuantite() %></td>
                                                <td><%= listProd.get(i).getPrix() %></td>
                                                <td><%= listProd.get(i).getCategorie().getNom() %></td>
                                                <td><button type="button" id="update-prod" class="btn btn-warning">Modifier</button></td>
                                                <td><button type="button" id="delete-prod" class="btn btn-warning">Supprimer</button></td>
                                            </tr>
                                        <%}%>
                                    </tbody>
                                </table>
                              <%}%>
                              <br><br>
                              <form method="POST" id="show_info_product">
                                  <div class="form-group">
                                      <label for="showNomProd">Nom Produit</label>
                                      <input type="text" id="showNomProd" class="form-control" />
                                  </div>
                                  <div class="form-group">
                                      <label for="showQteProd">Quantité</label>
                                      <input type="number" id="showQteProd" class="form-control" />
                                  </div>
                                  <div class="form-group">
                                      <label for="showPrixProd">Prix</label>
                                      <input type="number" id="showPrixProd" class="form-control" />
                                  </div>
                                  <div class="form-group">
                                      <label for="showCatProd">Catégorie du produit</label>
                                      <input type="text" id="showCatProd" class="form-control" />
                                  </div>
                                  <input type="hidden" id="idProduit" />
                                  <br>
                                  <button type="button" id="confirm-update-product" class="btn btn-danger">Confirmer</button>
                              </form>
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
        <script src="js/showInfoProduct.js"></script>
        <script src="js/confirmUpdateProduct.js"></script>
        <script src="js/deleteProduct.js"></script>
        <script src="js/jquery.confirm.min.js"></script>
        <script src="js/addProducts.js"></script>
          
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