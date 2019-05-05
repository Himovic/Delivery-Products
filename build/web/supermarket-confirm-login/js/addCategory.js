$(document).ready(function(){
   $("#add-categorie").toggle();
   var HiddenAddCategorie = "HiddenAddCategorie";
   $("#show_add_form").click(function(){
       $("#add-categorie").toggle();
   });
   $("#confirm-add-categorie").click(function(){
      var nomCat = $("#nom_categorie").val();
      var idSupermarket = $("#idSupermarket").val();
      $.ajax({
          url :"http://localhost:8080/Supermarket/CategorieControl",
          method:"POST",
          dataType: 'text',
          data :{
              HiddenAddCategorie:HiddenAddCategorie,
              nomCat:nomCat,
              idSupermarket:idSupermarket
          },
          success: function (result) {
                if(result === "error"){
                    getMsg("Erreur lors de l'ajout d'une categorie");
                }else{
                    getMsg("Categorie ajoutee avec succees");
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

function getMsg(message){
    alert(message);
}