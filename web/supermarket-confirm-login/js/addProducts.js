$(document).ready(function(){
    $("#confirm_show_add_product").hide();
    $("#show_add_product").click(function(){
       $("#show_options_form").hide();
       $("#confirm_show_add_product").toggle(); 
    });
    
    $("#categorie").change(function(){
        var valueSelected = this.value;
        if(valueSelected !== 0){
            $("#show_options_form").show();
        }
    });
    
    $("#confirm-add-product").click(function(){
       var HiddenAddProduct = "HiddenAddProduct";
       var cat_value = $("#categorie").val();
       var nomProd = $("#nomProd").val();
       var qteProd = $("#qteProd").val();
       var prixProd = $("#prixProd").val();
       var idSuper = $("#idSuper").val();
       
       if(nomProd === ""){
            getMsg("Vous devez renseigner le nom du produit");
       }else if(nomProd.length < 4){
            getMsg("Le nom du produit doit contenir au moins 4 caractéres");
       }else if(qteProd === ""){
            getMsg("Vous devez renseigner la quantité du produit");
       }else if(prixProd === ""){
            getMsg("Vous devez renseinger le prix du produit");
       }else {
           $.ajax({
                url : "http://localhost:8080/Supermarket/ProductControl",
                method : "POST",
                dataType: 'text',
                data: {
                    HiddenAddProduct:HiddenAddProduct,
                    nomProd:nomProd,
                    qteProd:qteProd,
                    prixProd:prixProd,
                    cat_value:cat_value,
                    idSuper:idSuper
                },
                success: function (result) {
                    if(result === "error"){
                        getMsg("Une érreur est apparue lors de l'ajout d'un produit! refaire a nouveau");
                    }else{
                        getMsg("Confirmation de l'ajout du produit");
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