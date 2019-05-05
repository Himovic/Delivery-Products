$(document).ready(function(){
    var HiddenConfirmUpdateSupermarket = "HiddenConfirmUpdateSupermarket";
    $("#confirm-update").click(function(){
        var nom = $("#supr-nom").val();
        var adresse = $("#supr-adresse").val();
        var numero = $("#supr-numero").val();
        var user = $("#supr-user").val();
        var id = $("#super-update").val();
        $.ajax({
                url : "http://localhost:8080/Supermarket/SupermarketControl",
                method : "POST",
                dataType: 'text',
                data: {
                    HiddenConfirmUpdateSupermarket:HiddenConfirmUpdateSupermarket,
                    nom:nom,
                    adresse:adresse,
                    numero:numero,
                    user:user,
                    id:id
                },
                success: function (result) {
                    if(result === "error"){
                        getMsg("Une erreur est apparue lors de la modification des parametres");
                    }else{
                        getMsg("Confirmation des modifications");
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
    });
});