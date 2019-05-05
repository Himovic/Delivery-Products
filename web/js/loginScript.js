$(document).ready(function(){
    var HiddenLoginValue = "HiddenLoginValue";
    $("#connect").click(function(){
        var email = $('#email').val();
        var password = $('#password').val();
        if(email === ""){
            getMsg("Vous devez renseigner le champs email !");
        }else if(password === ""){
            getMsg("Vous devez renseigner le champ mot de passe !");
        }else if(password.length <= 5){
            getMsg("Le mot de passe doit étre supérieur a 5 caractéres !");
        }else{
            $.ajax({
            url : 'http://localhost:8080/Supermarket/UserControl',
            method : 'POST',
            dataType: 'text',
            data : {
                HiddenLoginValue: HiddenLoginValue,
                email : email,
                password : password
            },
            success: function (result) {
                if(result === "error"){
                    getMsg("Email ou mot de passe incorrect");
                }else{
                    window.location.href ="supermarket-dashboard/dashboard.jsp";
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
        }
    });
});

function getMsg(message){
    alert(message);
}