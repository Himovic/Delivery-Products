$(document).ready(function(){
   $("#detail-supermarket").hide();
   var HiddenShowInfoSuper = "HiddenShowInfoSuper";
   $("#super-update").click(function(){
       var id = $("#super-update").val();
       $.ajax({
                url : "http://localhost:8080/Supermarket/SupermarketControl",
                method : "POST",
                dataType: 'text',
                data: {
                    HiddenShowInfoSuper:HiddenShowInfoSuper,
                    id:id
                },
                success: function (result) {
                    if(result === "error"){
                        getMsg("Le mot de passe n'est pas correct!");
                    }else{
                        var obj = JSON.parse(result);
                        $("#supr-nom").val(obj.nom);
                        $("#supr-adresse").val(obj.adresse);
                        $("#supr-numero").val(obj.numero);
                        $("#supr-user").val(obj.user);
                        $("#detail-supermarket").show();
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