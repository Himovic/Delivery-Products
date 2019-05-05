$(document).ready(function(){
   var HiddenAssociateLivreur = "HiddenAssociateLivreur";
   var idCommandes = [];
   var idCommandeSelected = '';
   var checkBox = 'input[type="checkbox"]';
   $("#associerLivreur").click(function(){
       if ($(checkBox+':checked').length === $(checkBox).length){
           $("#commandeInfo").find("input[type='checkbox']:checked").each(function(){
                idCommandes.push(this.value);
           });
           var idVisiteur = $("#idVisiteur").val();
           var idLivreur = $("#selectLivreur").val();
           idCommandeSelected = idCommandes.toString();
           $.ajax({
               url :"http://localhost:8080/Supermarket/LivraisonController",
                method:"POST",
                dataType: 'text',
                data :{
                    HiddenAssociateLivreur:HiddenAssociateLivreur,
                    idCommandeSelected:idCommandeSelected,
                    idVisiteur:idVisiteur,
                    idLivreur:idLivreur
                },
                success: function (result) {
                    if(result === "error"){
                        getMsg("Une érreur est apparue lors de l'association des commandes au livreur");
                    }else{
                        getMsg("La commande a été associer au livreur sélectionné! Consulter son avancement dans l'onglet livreur");
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
            getMsg("Vous devez sélectionner toutes les commandes");
       }
   });
});

function getMsg(msg){
    alert(msg);
}