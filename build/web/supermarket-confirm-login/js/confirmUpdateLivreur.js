$(document).ready(function(){
   var HiddenConfirmLivreur = "HiddenConfirmLivreur";
   $("#confirmUpdateLivreur").click(function(){
      var nomLivreur = $("#nomLivreurc").val();
      var prenomLivreur = $("#prenomLivreurc").val();
      var adresseLivreur = $("#adresseLivreurc").val();
      var numeroLivreur = $("#numeroLivreurc").val();
      var idLivreur = $("#idLivreurc").val();
      $.ajax({
            url:"http://localhost:8080/Supermarket/LivreurControl",
             method:"POST",
             dataType:"text",
             data: {
                HiddenConfirmLivreur:HiddenConfirmLivreur,
                nomLivreur:nomLivreur,
                prenomLivreur:prenomLivreur,
                adresseLivreur:adresseLivreur,
                numeroLivreur:numeroLivreur,
                idLivreur:idLivreur
             },
             success: function (result) {
                if(result === "error"){
                        getMsg("Une érreur est apparue lors de la modification des informations du livreur");
                }else{
                       getMsg("Modification réussie avec succées");
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