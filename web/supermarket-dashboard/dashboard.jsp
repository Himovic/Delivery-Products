<%@page import="Functions.SupermarketFunction"%>
<%@page import="java.util.List"%>
<%@page import="Models.Supermarket"%>
<%@page import="Functions.UsersFunctions"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Required meta tags-->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="au theme template">
    <meta name="author" content="Hau Nguyen">
    <meta name="keywords" content="au theme template">

    <!-- Title Page-->
    <title>Gérer les supérmarchés</title>

    <!-- Fontfaces CSS-->
    <link href="css/font-face.css" rel="stylesheet" media="all">
    <link href="vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <link href="vendor/font-awesome-5/css/fontawesome-all.min.css" rel="stylesheet" media="all">
    <link href="vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">

    <!-- Bootstrap CSS-->
    <link href="vendor/bootstrap-4.1/bootstrap.min.css" rel="stylesheet" media="all">

    <!-- Vendor CSS-->
    <link href="vendor/animsition/animsition.min.css" rel="stylesheet" media="all">
    <link href="vendor/bootstrap-progressbar/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet" media="all">
    <link href="vendor/wow/animate.css" rel="stylesheet" media="all">
    <link href="vendor/css-hamburgers/hamburgers.min.css" rel="stylesheet" media="all">
    <link href="vendor/slick/slick.css" rel="stylesheet" media="all">
    <link href="vendor/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="vendor/perfect-scrollbar/perfect-scrollbar.css" rel="stylesheet" media="all">

    <!-- Main CSS-->
    <link href="css/theme.css" rel="stylesheet" media="all">

</head>
<%
    String nom = (String)request.getSession().getAttribute("nom");
    String prenom = (String)request.getSession().getAttribute("prenom");
    String email = (String)request.getSession().getAttribute("email");
    String fullName = nom+" "+prenom;
    int ID = UsersFunctions.getIdFromEmail(email);
    List<Supermarket> supermarkets = SupermarketFunction.listOfSupermarket(ID);
%>
<body class="animsition">
    <div class="page-wrapper">
        <!-- HEADER DESKTOP-->
        <header class="header-desktop3 d-none d-lg-block">
            <div class="section__content section__content--p35">
                <div class="header3-wrap">
                    <div class="header__logo">
                        <a href="#">
                            <img src="images/icon/logo-white.png" alt="CoolAdmin" />
                        </a>
                    </div>
                    <div class="header__tool">
                        <div class="header-button-item has-noti js-item-menu">
                            <i class="zmdi zmdi-notifications"></i>
                            <div class="notifi-dropdown notifi-dropdown--no-bor js-dropdown">
                                <div class="notifi__title">
                                    <p>You have 3 Notifications</p>
                                </div>
                                <div class="notifi__item">
                                    <div class="bg-c1 img-cir img-40">
                                        <i class="zmdi zmdi-email-open"></i>
                                    </div>
                                    <div class="content">
                                        <p>You got a email notification</p>
                                        <span class="date">April 12, 2018 06:50</span>
                                    </div>
                                </div>
                                <div class="notifi__item">
                                    <div class="bg-c2 img-cir img-40">
                                        <i class="zmdi zmdi-account-box"></i>
                                    </div>
                                    <div class="content">
                                        <p>Your account has been blocked</p>
                                        <span class="date">April 12, 2018 06:50</span>
                                    </div>
                                </div>
                                <div class="notifi__item">
                                    <div class="bg-c3 img-cir img-40">
                                        <i class="zmdi zmdi-file-text"></i>
                                    </div>
                                    <div class="content">
                                        <p>You got a new file</p>
                                        <span class="date">April 12, 2018 06:50</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="account-wrap">
                            <div class="account-item account-item--style2 clearfix js-item-menu">
                                <div class="image">
                                    <img src="images/icon/avatar-01.jpg" alt="John Doe" />
                                </div>
                                <div class="content">
                                    <a class="js-acc-btn" href="#"><%=fullName%></a>
                                </div>
                                <div class="account-dropdown js-dropdown">
                                    <div class="info clearfix">
                                        <div class="image">
                                            <a href="#">
                                                <img src="images/icon/avatar-01.jpg" alt="John Doe" />
                                            </a>
                                        </div>
                                        <div class="content">
                                            <h5 class="name">
                                                <a href="#"><%=fullName%></a>
                                            </h5>
                                            <span class="email"><%=email%></span>
                                        </div>
                                    </div>
                                    <div class="account-dropdown__body">
                                        <div class="account-dropdown__item">
                                            <a href="update.jsp">
                                                <i class="zmdi zmdi-account"></i>Account</a>
                                        </div>
                                    </div>
                                    <div class="account-dropdown__footer">
                                        <a href="../login.jsp">
                                            <i class="zmdi zmdi-power"></i>Logout</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </header>
        <!-- END HEADER DESKTOP-->

        <!-- HEADER MOBILE-->
        <header class="header-mobile header-mobile-2 d-block d-lg-none">
            <div class="header-mobile__bar">
                <div class="container-fluid">
                    <div class="header-mobile-inner">
                        <a class="logo" href="index.html">
                            <img src="images/icon/logo-white.png" alt="CoolAdmin" />
                        </a>
                        <button class="hamburger hamburger--slider" type="button">
                            <span class="hamburger-box">
                                <span class="hamburger-inner"></span>
                            </span>
                        </button>
                    </div>
                </div>
            </div>
        </header>
        <div class="sub-header-mobile-2 d-block d-lg-none">
            <div class="header__tool">
                <div class="header-button-item has-noti js-item-menu">
                    <i class="zmdi zmdi-notifications"></i>
                    <div class="notifi-dropdown notifi-dropdown--no-bor js-dropdown">
                        <div class="notifi__title">
                            <p>You have 3 Notifications</p>
                        </div>
                        <div class="notifi__item">
                            <div class="bg-c1 img-cir img-40">
                                <i class="zmdi zmdi-email-open"></i>
                            </div>
                            <div class="content">
                                <p>You got a email notification</p>
                                <span class="date">April 12, 2018 06:50</span>
                            </div>
                        </div>
                        <div class="notifi__item">
                            <div class="bg-c2 img-cir img-40">
                                <i class="zmdi zmdi-account-box"></i>
                            </div>
                            <div class="content">
                                <p>Your account has been blocked</p>
                                <span class="date">April 12, 2018 06:50</span>
                            </div>
                        </div>
                        <div class="notifi__item">
                            <div class="bg-c3 img-cir img-40">
                                <i class="zmdi zmdi-file-text"></i>
                            </div>
                            <div class="content">
                                <p>You got a new file</p>
                                <span class="date">April 12, 2018 06:50</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- END HEADER MOBILE -->

        <!-- PAGE CONTENT-->
        <div class="page-content--bgf7">

            <!-- WELCOME-->
            <section class="welcome p-t-10">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">
                            <h1 class="title-4">Bienvenue
                                <span><%=prenom%></span>
                            </h1>
                            <hr class="line-seprate">
                        </div>
                    </div>
                </div>
            </section>
            <!-- END WELCOME-->

            <!-- DATA TABLE-->
            <section class="p-t-20">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="table-data__tool">
                                <div class="table-data__tool-right">
                                    <button id="form-add" class="au-btn au-btn-icon au-btn--green au-btn--small">
                                        <i class="zmdi zmdi-plus"></i>Ajouter un supermarché</button>
                                </div>
                                <form class="col-md-9" id="supermarket-add" method="POST">
                                    <input type="hidden" id="idPersonne" value="<%=ID%>"/>
                                    <div class="form-group">
                                        <label for="nom">Nom</label>
                                        <input type="text" class="form-control" id="nom" placeholder="Entrer le nom du supermarché"/>
                                    </div>
                                    <div class="form-group">
                                        <label for="adresse">Adresse</label>
                                        <input type="text" class="form-control" id="adresse" placeholder="Entrer l'adresse du supermarché"/>
                                    </div>
                                    <div class="form-group">
                                        <label for="numero">Numéro</label>
                                        <input type="text" class="form-control" id="numero" placeholder="Numéro du supermarché"/>
                                    </div>
                                    <div class="form-group">
                                        <label for="user">Utilisateur</label>
                                        <input type="text" class="form-control" id="user" placeholder="Entrer le nom d'utilisateur"/>
                                    </div>
                                    <div class="form-group">
                                        <label for="password">Mot de passe</label>
                                        <input type="password" class="form-control" id="password" placeholder="Entrer le mot de passe"/>
                                    </div>
                                    <div class="form-group">
                                        <label for="repassword">Vérification mot de passe</label>
                                        <input type="password" class="form-control" id="repassword" placeholder="Entrer le mot de passe a nouveau pour la vérification"/>
                                    </div>
                                    <button type="button" id="add-supermarket" class="btn btn-primary">Confirmer</button>
                                </form>
                            </div>
                            <%if(supermarkets.size() == 0) {%>
                                <h3>Aucun supermarché n'est disponible pour le moment</h3>
                            <%}else{%>
                            <div class="table-responsive table-responsive-data2">
                                <table id="mytable" class="table table-data2">
                                    <thead>
                                        <tr>
                                            <th>Nom</th>
                                            <th>Adresse</th>
                                            <th>Date</th>
                                            <th>Numéro</th>
                                            <th>Status</th>
                                            <th>Utilisateur</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%for(int i=0; i<supermarkets.size(); i++){%>
                                        <tr class="spacer"></tr>
                                        <tr class="tr-shadow">
                                            <td><%=supermarkets.get(i).getNom()%></td>
                                            <td>
                                                <span class="block-email"><%=supermarkets.get(i).getAdresse()%></span>
                                            </td>
                                            <td class="desc"><%=supermarkets.get(i).getDate() %></td>
                                            <td><%= supermarkets.get(i).getNumero() %></td>
                                            <td>
                                                <span class="status--process"><%=supermarkets.get(i).getStatus() %></span>
                                            </td>
                                            <td><%=supermarkets.get(i).getUsername() %></td>
                                            <td>
                                                <div class="table-data-feature">
                                                    <button class="item" data-toggle="tooltip" data-placement="top" id="super-login" title="Connecter">
                                                        <i class="zmdi zmdi-mail-send"></i>
                                                    </button>
                                                    <button class="item" data-toggle="tooltip" value="<%= supermarkets.get(i).getId()%>" id="super-update" data-placement="top" title="Modifer">
                                                        <i class="zmdi zmdi-edit"></i>
                                                    </button>
                                                    <button class="item" data-toggle="tooltip" id="super-delete" data-placement="top" title="Supprimer">
                                                        <i class="zmdi zmdi-delete"></i>
                                                    </button>
                                                </div>
                                            </td>
                                        </tr>
                                        <%}%>
                                    </tbody>
                                </table>
                                    <form id="dialog" class="form-group" style="background-color: whitesmoke">
                                        <input class="form-control" name="password" type="password" id="password" placeholder="Entrer le mot de passe"/>
                                        <button type="button" id="confirm-login" class="btn btn-success">Confirmer</button>
                                    </form>
                            </div>
                            <%}%>
                        </div>
                    </div>
                        <br>
                        <form class="col-md-5" id="detail-supermarket">
                            <div class="form-group">
                                <label for="supr-nom">Nom</label>
                                <input class="form-control" type="text" id="supr-nom" />
                            </div>
                            <div class="form-group">
                                <label for="supr-adresse">Adresse</label>
                                <input class="form-control" type="text" id="supr-adresse" />
                            </div>
                            <div class="form-group">
                                <label for="supr-numero">Numero</label>
                                <input class="form-control" type="text" id="supr-numero" />
                            </div>
                            <div class="form-group">
                                <label for="supr-user">Utilisateur</label>
                                <input class="form-control" type="text" id="supr-user" />
                            </div>
                            <button type="button" id="confirm-update" class="btn btn-success">Confirmer</button>
                        </form>
                </div>
            </section>
            <!-- END DATA TABLE-->

            <!-- COPYRIGHT-->
            <section class="p-t-60 p-b-20">
                <div class="container">
                    
                </div>
            </section>
            <!-- END COPYRIGHT-->
        </div>

    </div>

    <!-- Jquery JS-->
    <script src="vendor/jquery-3.2.1.min.js"></script>
    <!-- Bootstrap JS-->
    <script src="vendor/bootstrap-4.1/popper.min.js"></script>
    <script src="vendor/bootstrap-4.1/bootstrap.min.js"></script>
    <!-- Vendor JS       -->
    <script src="vendor/slick/slick.min.js">
    </script>
    <script src="vendor/wow/wow.min.js"></script>
    <script src="vendor/animsition/animsition.min.js"></script>
    <script src="vendor/bootstrap-progressbar/bootstrap-progressbar.min.js">
    </script>
    <script src="vendor/counter-up/jquery.waypoints.min.js"></script>
    <script src="vendor/counter-up/jquery.counterup.min.js">
    </script>
    <script src="vendor/circle-progress/circle-progress.min.js"></script>
    <script src="vendor/perfect-scrollbar/perfect-scrollbar.js"></script>
    <script src="vendor/chartjs/Chart.bundle.min.js"></script>
    <script src="vendor/select2/select2.min.js">
    </script>

    <!-- Main JS-->
    <script src="js/main.js"></script>
    <script src="js/jquery-ui.js"></script>
    <script src="js/jquery.confirm.min.js"></script>
    <script src="js/add-supermarket.js"></script>
    <script src="js/login-supermarket.js"></script>
    <script src="js/delete-supermarket.js"></script>
    <script src="js/detail-supermarket.js"></script>
    <script src="js/detail-confirm-supermarket.js"></script>
</body>

</html>
<!-- end document-->