$(document).ready(function(){
   var HiddenConfirmSupermarket = "HiddenConfirmSupermarket";
   $("#confirm-supermarket").click(function(){
      var idSupermarket = $("#idSupermarket").val();
      $("td:eq(2)").each(function(){
         var numero = $(this).html();
         var numeroAdmin = "+213"+numero;
         $.ajax({
             url:"http://localhost:8080/Supermarket/AdminControl",
             method:"POST",
             dataType:"text",
             data: {
                HiddenConfirmSupermarket:HiddenConfirmSupermarket,
                idSupermarket:idSupermarket,
                numeroAdmin:numeroAdmin
             },
             success: function (result) {
                if(result === "error"){
                        getMsg("Une érreur est apparue lors de l'activation du supérmarché");
                }else{
                       getMsg("Le supermarché a été confirmé avec succées");
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
         return;
      });
   });
});

function getMsg(msg){
    alert(msg);
}