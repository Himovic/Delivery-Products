$(document).ready(function(){
   var HiddenDeleteProduct = "HiddenDeleteProduct";
   $("#delete-prod").click(function(){
      $.confirm({
          text : "Vous etes sur de vouloir supprimer ce produit ?",
          confirm : function(){
              var idProduit = $("#idProduitHidden").val();
              $.ajax({
                url : "http://localhost:8080/Supermarket/ProductControl",
                method : "POST",
                dataType: 'text',
                data: {
                    HiddenDeleteProduct:HiddenDeleteProduct,
                    idProduit:idProduit
                },
                success: function (result) {
                    if(result === "error"){
                        getMsg("Une érreur est apparue lors de la suppréssion du produit");
                    }else{
                        getMsg("Produit supprimé avec succées");
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