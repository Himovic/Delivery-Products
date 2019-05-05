$(document).ready(function(){
   $("#show_info_update").hide();
   var HiddenShowInfoUpdate= "HiddenShowInfoUpdate";
   $("#cat-update").click(function(){
      var idCategorie = $("#cat-update").val();
      $.ajax({
          url :"http://localhost:8080/Supermarket/CategorieControl",
          method:"POST",
          dataType: 'text',
          data :{
              HiddenDeleteCategorie:HiddenShowInfoUpdate,
              idCategorie: idCategorie
          },
          success: function (result) {
                if(result === "error"){
                    getMsg("Erreur lors de l'affichage des informations! refaire a nouveau!");
                }else{
                    getMsg(result);
                    $("#nomCat").val(result);
                    $("#show_info_update").show();
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
   });
});

function getMsg(msg){
    alert(msg);
}