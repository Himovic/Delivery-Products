$(document).ready(function(){
   var HiddenDeleteLivreur = "HiddenDeleteLivreur";
   $("#delete-liv").click(function(){
      var idLivreur = $("#idLivreurHidden").val(); 
      var r = confirm("Vous voulez supprimer ce livreur catégoriquement ?");
      if(r === true){
        $.ajax({
            url:"http://localhost:8080/Supermarket/LivreurControl",
             method:"POST",
             dataType:"text",
             data: {
                HiddenDeleteLivreur:HiddenDeleteLivreur,
                idLivreur:idLivreur
             },
             success: function (result) {
                if(result === "error"){
                        getMsg("Une érreur est apparue lors de la suppréssion du livreur");
                }else{
                       getMsg("Livreur supprimé avec succées");
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
      }else{
          
      }
   });
});

function getMsg(msg){
    alert(msg);
}