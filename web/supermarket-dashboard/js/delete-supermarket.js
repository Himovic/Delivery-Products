$(document).ready(function(){
    var HiddenDeleteSupermarket = "HiddenDeleteSupermarket";
    $("#super-delete").click(function(){
        $.confirm({
            text : "Vous etes sur de vouloir supprimer ce supermarche ?",
            confirm : function(){
                var idSupermarket = $("#idSupermarket").val();
                $.ajax({
                url : "http://localhost:8080/Supermarket/SupermarketControl",
                method : "POST",
                dataType: 'text',
                data: {
                    HiddenDeleteSupermarket: HiddenDeleteSupermarket,
                    idSupermarket: idSupermarket
                },
                success: function (result) {
                    if(result === "error"){
                        getMsg("Une erreur est apparue lors de la suppression du supermarche");
                    }else{
                        getMsg("Confirmation de la suppression");
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
            },
            cancel : function(){
            
            }
        });
    });
});

function getMsg(msg){
    alert(msg);
}