$(document).ready(function(){
    $("#dialog").hide();
    $("#super-login").click(function(){
        $('#dialog').dialog({
            title:'Connecter a votre supermarche',
        });
    });
    
    $("#confirm-login").click(function(){
        var HiddenLoginSupermarket = "HiddenLoginSupermarket";
        $("td:eq(5)").each(function () {
            var user = $(this).html();
            var password = $("#dialog").find('input[name="password"]').val();
            if(password === ""){
                getMsg("Vous devez renseigner le champ mot de passe");
            }else if(password.length < 6){
                getMsg("Le mot de passe doit contenir au moins 6 caractéres!");
            }else{
                $.ajax({
                url : "http://localhost:8080/Supermarket/SupermarketControl",
                method : "POST",
                dataType: 'text',
                data: {
                    HiddenLoginSupermarket: HiddenLoginSupermarket,
                    user: user,
                    password: password
                },
                success: function (result) {
                    if(result === "error"){
                        getMsg("Le mot de passe n'est pas correct!");
                    }else{
                       window.location.href="../supermarket-confirm-login/accueil.jsp";
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
            return;
        });
    });
});

function getMsg(msg){
    alert(msg);
}