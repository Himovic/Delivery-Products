$(document).ready(function(){
    
    var HiddenConfirmeCommande = "HiddenConfirmeCommande";
    var idCommandes = [];
    var idCommandeSelected = '';
    var checkBox = 'input[type="checkbox"]';
    $("#confirmCommande").click(function(){
        if ($(checkBox+':checked').length === $(checkBox).length) {
            $("#commandeInfo").find("input[type='checkbox']:checked").each(function(){
                idCommandes.push(this.value);
            });
            var montantProduit = $("#montantProduit").text();
            var prixLivraison = $("#prixLivraison").text();
            var montantTotal = $("#montantTotal").text();
            var priceProduit = montantProduit.split(" ")[3];//
            var priceTotal = montantTotal.split(" ")[3];//
            var priceLivraison = prixLivraison.split(" ")[3];//
            var idVisiteur = $("#idVisiteurD").val();//
            idCommandeSelected = idCommandes.toString();//
            
            $.ajax({
                url :"http://localhost:8080/Supermarket/CommandeController",
                method:"GET",
                dataType: 'text',
                data :{
                    HiddenConfirmeCommande:HiddenConfirmeCommande,
                    idCommandeSelected:idCommandeSelected,
                    priceProduit:priceProduit,
                    priceLivraison:priceLivraison,
                    priceTotal:priceTotal,
                    idVisiteur:idVisiteur
                    },
                success: function (result) {
                    if(result === "error"){
                        getMsg("Une érreur est apparue lors de la confirmation des commandes");
                        location.reload();
                    }else{
                        getMsg("Commande et facture enregistrés avec success et un méssage de confirmation est envoyé au client\n\
                                ! Relier la a un livreur pour la livrer au client");
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