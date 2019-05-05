$(document).ready(function(){
   $("#livreurInfo").hide();
   var HiddenShowInfoLivreur = "HiddenShowInfoLivreur";
   $("#update-liv").click(function(){
      var idLivreurHidden = $("#idLivreurHidden").val();
      $.ajax({
            url:"http://localhost:8080/Supermarket/LivreurControl",
             method:"POST",
             dataType:"text",
             data: {
                HiddenShowInfoLivreur:HiddenShowInfoLivreur,
                idLivreurHidden:idLivreurHidden
             },
             success: function (result) {
                if(result === "error"){
                        getMsg("Une érreur est apparue lors de la récupération des informations");
                }else{
                       var obj = JSON.parse(result);
                       $("#nomLivreurc").val(obj.nom);
                       $("#prenomLivreurc").val(obj.prenom);
                       $("#adresseLivreurc").val(obj.adresse);
                       $("#numeroLivreurc").val(obj.numero);
                       $("#idLivreurc").val(idLivreurHidden);
                       $("#livreurInfo").toggle();
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