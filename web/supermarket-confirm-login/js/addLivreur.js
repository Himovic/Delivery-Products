$(document).ready(function(){
    $("#add-livreur").hide();
    $("#show-form-add-livreur").click(function(){
        $("#add-livreur").toggle();
    });

   var HiddenAddLivreur = "HiddenAddLivreur";
    $("#confirm-add-livreur").click(function(){
        var NomLivreur = $("#nomLivreur").val();
        var PrenomLivreur = $("#prenomLivreur").val();
        var AdresseLivreur = $("#adresseLivreur").val();
        var NumeroLivreur = $("#numLivreur").val();
        var UserLivreur = $("#userLivreur").val();
        var idSupermarket = $("#idSupermarket").val();
        var PasswordLivreur = $("#passwordLivreur").val();
        if(NomLivreur === ""){
            getMsg("Vous devez renseigner le champ nom du livreur");
        }else if(NomLivreur.length < 3){
            getMsg("Le nom du livreur doit contenir au moins 3 caractéres");
        }else if(PrenomLivreur === ""){
            getMsg("Vous devez renseigner le champ prénom du livreur");
        }else if(PrenomLivreur.length < 3){
            getMsg("Le prénom du livreur doit contenir au moins 3 caractéres");
        }else if(AdresseLivreur === ""){
            getMsg("Vous devez renseigner le champ adresse du livreur");
        }else if(AdresseLivreur.length < 3){
            getMsg("L'adresse du livreur doit contenir au moins 8 caractéres");
        }else if(NumeroLivreur === ""){
            getMsg("Vous devez renseigner le champ numéro du livreur");
        }else if(NumeroLivreur.length < 8){
            getMsg("Le numéro doit contenir au moins 8 chiffres");
        }else if(UserLivreur === ""){
            getMsg("Vous devez renseigner le champ utilisateur");
        }else if(UserLivreur.length < 5){
            getMsg("Le nom d'utilisateur doit contenir au moins 5 caracétres");
        }else if(PasswordLivreur === ""){
            getMsg("Vous devez renseigner le champ mot de passe du livreur");
        }else if(PasswordLivreur.length < 6){
            getMsg("Le mot de passe doit contenir au moins 6 caractéres");
        }else{
            $.ajax({
            url:"http://localhost:8080/Supermarket/LivreurControl",
             method:"POST",
             dataType:"text",
             data: {
                HiddenAddLivreur:HiddenAddLivreur,
                idSupermarket:idSupermarket,
                NomLivreur:NomLivreur,
                PrenomLivreur:PrenomLivreur,
                AdresseLivreur:AdresseLivreur,
                NumeroLivreur:NumeroLivreur,
                UserLivreur:UserLivreur,
                PasswordLivreur:PasswordLivreur
             },
             success: function (result) {
                if(result === "error"){
                        getMsg("Une érreur est apparue lors de l'ajout du livreur ! refaire a nouveau!");
                }else{
                       getMsg("Le livreur a été ajouté avec succées");
                       location.reload();
                }
            },
            error : function(jqXHR, exception){
                var msg = '';
            if (jqXHR.status === 0) {
                msg = 'Not connect.\n Verify Network.';
            } else if (jqXHR.status === 404) {
                msg = 'Requested page not found. [404]';
            } else if (jqXHR.status === 500) {
                msg = 'Internal Server Error [500].';
            } else if (exception === 'parsererror') {
                msg = 'Requested JSON parse failed.'+jqXHR.responseText;
            } else if (exception === 'timeout') {
                msg = 'Time out error.';
            } else if (exception === 'abort') {
                msg = 'Ajax request aborted.';
            } else {
                msg = 'Uncaught Error.\n' + jqXHR.responseText;
            }
            getMsg(msg);
        }
   });
   return false;
        }
    });
});

function getMsg(msg){
    alert(msg);
}