$(document).ready(function(){
   var HiddenDeleteCategorie = "HiddenDeleteCategorie";
   $("#cat-delete").click(function(){
       var idCategorie = $("#cat-delete").val();
       $.ajax({
          url :"http://localhost:8080/Supermarket/CategorieControl",
          method:"POST",
          dataType: 'text',
          data :{
              HiddenDeleteCategorie:HiddenDeleteCategorie,
              idCategorie: idCategorie
          },
          success: function (result) {
                if(result === "error"){
                    getMsg("Erreur lors de la suppression d'une categorie");
                }else{
                    getMsg("Categorie supprimer avec succees");
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