$(document).ready(function(){
    var HiddenUpdateInfo = "HiddenUpdateInfo";
    $("#update").click(function(){
        var nom = $("#nom").val();
        var prenom = $("#prenom").val();
        var adresse = $("#adresse").val();
        var numero = $("#numero").val();
        var type = $("#type").val();
        var idPersonne = $("#idPersonne").val();
        $.ajax({
           url : 'http://localhost:8080/Supermarket/UserControl',
            method : 'POST',
            dataType: 'text',
            data : {
                HiddenUpdateInfo: HiddenUpdateInfo,
                nom: nom,
                prenom: prenom,
                adresse: adresse,
                numero: numero,
                type: type,
                idPersonne: idPersonne
            },
            success: function (result) {
                if(result === "error"){
                    getMsg("Une érreur est apparue ! refaire a nouveau!");
                }else{
                    getMsg("Modification des informations confirmées");
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

function getMsg(message){
    alert(message);
}