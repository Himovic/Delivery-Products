$(document).ready(function(){
    $("#supermarket-add").hide();
    $("#form-add").click(function(){
        $("#supermarket-add").toggle();
    });
    
    $("#add-supermarket").click(function(){
        var HiddenRegisterSupermarket ="HiddenRegisterSupermarket";
        var idPersonne = $("#idPersonne").val();
        var nom = $("#nom").val();
        var adresse = $("#adresse").val();
        var numero = $("#numero").val();
        var user = $("#user").val();
        var password = $("#password").val();
        var repassword = $("#repassword").val();
        
        if(nom === ""){
            getMsg("Vous devez renseigner le champ nom");
        }else if(adresse === ""){
            getMsg("Vous devez renseigner le champ adresse");
        }else if(numero === ""){
            getMsg("Vous devez renseigner le champ numéro");
        }else if(user === ""){
            getMsg("Vous devez renseigner le champ user");
        }else if(password === ""){
            getMsg("Vous devez entrer un mot de passe");
        }else if(repassword === ""){
            getMsg("Vous devez entrer a nouveau le mot de passe pour vérification");
        }else if(nom.length < 5){
            getMsg("Le nom du supérmarché doit contenir au moins 5 caractéres");
        }else if(adresse.length < 8){
            getMsg("L'adresse du supermarché doit contenir au moins 8 caractéres");
        }else if(numero.length < 9 || numero.search(/[a-zA-Z]/) !== -1 ){
            getMsg("Le numéro n'est pas valide");
        }else if(password.length < 6){
            getMsg("Le mot de passe doit contenir au moins 6 caractéres!");
        }else if(password.length > 50){
            getMsg("Le mot de passe ne doit pas dépasser 50 caractéres");
        }else if(password.search(/\d/) === -1){
            getMsg("Le mot de passe doit contenir au moins un chiffre");
        }else if(password.search(/[a-zA-Z]/) === -1){
            getMsg("Le mot de passe doit contenur au moins une lettre");
        }else if(repassword.length === 0){
            getMsg("Vous devez renseigner le champ vérification mot de passe");
        }else if(password !== repassword){
            getMsg("Les mots de passes sont pas identiques !");
        }else {
            $.ajax({
                url : "http://localhost:8080/Supermarket/SupermarketControl",
                method : "POST",
                dataType: 'text',
                data: {
                    HiddenRegisterSupermarket:HiddenRegisterSupermarket,
                    idPersonne: idPersonne,
                    nom: nom,
                    adresse: adresse,
                    numero: numero,
                    user: user,
                    password: password
                },
                success: function (result) {
                    if(result === "error"){
                        getMsg("Une érreur est apparue lors de l'ajout d'un supérmarché! refaire a nouveau");
                    }else{
                        getMsg("Confirmation de l'ajout du supermarche");
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