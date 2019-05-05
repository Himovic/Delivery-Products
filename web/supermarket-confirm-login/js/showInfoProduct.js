$(document).ready(function(){
   $("#show_info_product").hide();
   var HiddenShowInfoProduct = "HiddenShowInfoProduct";
   $("#update-prod").click(function(){
       var idProduit = $("#idProduitHidden").val();
       $.ajax({
                url : "http://localhost:8080/Supermarket/ProductControl",
                method : "POST",
                dataType: 'text',
                data: {
                    idProduit: idProduit,
                    HiddenShowInfoProduct: HiddenShowInfoProduct
                },
                success: function (result) {
                    if(result === "error"){
                        getMsg("Une érreur est apparue lors de l'affichage du produit");
                    }else{
                        var obj = JSON.parse(result);
                        $("#showNomProd").val(obj.nom);
                        $("#showQteProd").val(obj.quantite);
                        $("#showPrixProd").val(obj.prix);
                        $("#showCatProd").val(obj.categorie);
                        $("#idProduit").val(obj.idProduit);
                        $("#show_info_product").toggle();
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