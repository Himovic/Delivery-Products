$(document).ready(function(){
   var HiddenConfirmUpdateProduct = "HiddenConfirmUpdateProduct";
   $("#confirm-update-product").click(function(){
       var newNom = $("#showNomProd").val();
       var newQte = $("#showQteProd").val();
       var newPrix = $("#showPrixProd").val();
       var idProduit = $("#idProduit").val();
       $.ajax({
                url : "http://localhost:8080/Supermarket/ProductControl",
                method : "POST",
                dataType: 'text',
                data: {
                    HiddenConfirmUpdateProduct:HiddenConfirmUpdateProduct,
                    newNom:newNom,
                    newQte:newQte,
                    newPrix:newPrix,
                    idProduit:idProduit
                },
                success: function (result) {
                    if(result === "error"){
                        getMsg("Une érreur est apparue lors de la modification d'un produit");
                    }else{
                        getMsg("Modification confirmée");
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

function getMsg(msg){
    alert(msg);
}