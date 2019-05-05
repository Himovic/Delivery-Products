<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Required meta tags-->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Colorlib Templates">
    <meta name="author" content="Colorlib">
    <meta name="keywords" content="Colorlib Templates">
    
    <!-- Title Page-->
    <title>Authentification des administrateurs</title>

    <!-- Icons font CSS-->
    <link href="vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
    <link href="vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <!-- Font special for pages-->
    <link href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i" rel="stylesheet">

    <!-- Vendor CSS-->
    <link href="vendor/select2/select2.min.css" rel="stylesheet" media="all">

    <!-- Main CSS-->
    <link href="css/main.css" rel="stylesheet" media="all">
</head>
<% 
    request.getSession().invalidate();
%>
<body>
    <div class="page-wrapper bg-red p-t-180 p-b-100 font-robo">
        <div class="wrapper wrapper--w960">
            <div class="card card-2">
                <div class="card-heading"></div>
                <div class="card-body">
                    <h2 class="title">Connecter pour accéder a votre éspace</h2>
                    <form method="POST">
                        <div class="input-group">
                            <input class="input--style-2" id="email" type="email" placeholder="Entrer votre email" name="email">
                        </div>
                        <div class="input-group">
                            <input class="input--style-2" id="password" type="password" placeholder="Entrer votre mot de passe" name="password">
                        </div>
                        <div class="p-t-30">
                            <button class="btn btn--radius btn--green" id="connect" type="submit">Connecter</button>
                        </div>
                    </form>
                    <br><br>
                    <hr>
                    <span>Si vous n'avez de compte <a href="register.html">Cliquez ici</a></span>
                </div>
            </div>
        </div>
    </div>

    <!-- Jquery JS-->
    <script src="vendor/jquery/jquery.js"></script>
    <!-- Vendor JS-->
    <script src="vendor/select2/select2.min.js"></script>
    
    <!-- Main JS-->
    <script src="js/global.js"></script>
    <script src="js/loginScript.js"></script>
    
</body><!-- This templates was made by Colorlib (https://colorlib.com) -->

</html>
<!-- end document-->