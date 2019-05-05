$(document).ready(function(){
    var HiddenRegisterValue = "HiddenRegisterValue";
    $("#register").click(function(){
        var nom = $("#nom").val();
        var prenom = $("#prenom").val();
        var adresse = $("#adresse").val();
        var numero = $("#numero").val();
        var type = $("#type").val();
        var email = $("#email").val();
        var password = $("#password").val();
        var repassword = $("#password").val();
        
        if(nom.length === 0){
            getMsg("Vous devez renseigner le champ nom");
            return;
        }else if(nom.length < 5){
            getMsg("Le nom doit dépasser 5 caractéres");
            return;
        }else if(prenom.length === 0){
            getMsg("Vous devez renseigner le champ prénom");
            return;
        }else if(prenom.length < 3){
            getMsg("Le prénom doit dépasser 3 caractéres");
            return;
        }else if(adresse.length < 8){
            getMsg("Vous devez entrer une adresse valide");
            return;
        }else if(numero.length < 9){
            getMsg("Le numéro doit contenir 9 chiffres");
            return;
        }else if(type === "none"){
            getMsg("Vous devez selectionner le type de l'utilisateur");
            return;
        }else if(password.length < 6){
            getMsg("Le mot de passe doit contenir au moins 6 caractéres!");
            return;
        }else if(password.length > 50){
            getMsg("Le mot de passe ne doit pas dépasser 50 caractéres");
            return;
        }else if(password.search(/\d/) === -1){
            getMsg("Le mot de passe doit contenir au moins un chiffre");
            return;
        }else if(password.search(/[a-zA-Z]/) === -1){
            getMsg("Le mot de passe doit contenur au moins une lettre");
            return;
        }else if(repassword.length === 0){
            getMsg("Vous devez renseigner le champ vérification mot de passe");
            return;
        }else if(password !== repassword){
            getMsg("Les mots de passes sont pas identiques !");
            return;
        }else{
            $.ajax({
            url : 'http://localhost:8080/Supermarket/UserControl',
            method : 'POST',
            dataType: 'text',
            data : {
                HiddenRegisterValue: HiddenRegisterValue,
                nom : nom,
                prenom : prenom,
                adresse : adresse,
                numero : numero,
                type : type,
                email : email,
                password : password
            },
            success: function (result) {
                if(result === "error"){
                    getMsg("Une érreur est apparue ! refaire a nouveau!");
                }else if(result === "errormail"){
                    getMsg("Erreur dans l'envoi de confirmation de l'email ! refaire a nouveau!");
                }else{
                    getMsg("Un email de confirmation est envoyé a votre compte.\n Valider avant d'utiliser nos services");
                    window.location.href ="login.html";
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

function getMsg(message){
    alert(message);
}
