var FORM_LOGIN = "<form method=\"POST\" action=\"loging\">" +
        "<input type=\"text\" placeholder=\"login\" id=\"login\">" +
        "<input type=\"password\" placeholder=\"password\"id=\"passwd\">" +
        "<input type=\"submit\" value=\"envoyer\" id=\"submit\">" +
        "</form>";

var LINK_CREATE = "Pas de compte ? <button id=\"button_create\">Cree en un !</button><br>" +
        "<a href=\"./lostPasswd.html\">Mot de passe perdu</a>";

var MSG_WELCOME = "<a href=\"./index.jsp\">Elo World</a>";

var FORM_CREATE = "<center><h3>Creer un compte :</h3>" +
        "<input type=\"text\" placeholder=\"pseudo\" id=\"pseudo\" value=\"\">" +
        "<input type=\"password\" placeholder=\"password\" id =\"passwd\">" +
        "<input type=\"password\" placeholder=\"repeat password\" id=\"verif_passwd\">" +
        "<input type=\"text\" placeholder=\"e-mail\" id=\"mail\">" +
				 "<input type=\"text\" placeholder=\"e-mail\" id=\"nom\">" +
				  "<input type=\"text\" placeholder=\"e-mail\" id=\"prenom\">" +
        "<input type=\"button\" id=\"sub_account\" value=\"envoyer\">" +
        "</center>";

var connecting_key = "";

function login(str) {	
	switch (str) {
		case "true":  
			$("#login").append(welcome);
			break;
		case "false":
			$("#login").append(FORM_LOGIN);
			$("#login").append(LINK_CREATE);
			break;
		case "":
			$("#login").append(FORM_LOGIN);
			$("#login").append(LINK_CREATE);
			break;
	}
   /* if (isConnected(connecting_key)) {
        $("#login").append("welcome");
    } else {
        $("#login").append(FORM_LOGIN);
        $("#login").append(LINK_CREATE);
    }*/
}

function signIn(log, mdp){
    if((connecting_key = loginIn(log, mdp)) != undefined){
        /*renvoi vers la page prioncipal avec la cle en param*/
    }else{
        alert("login in Failed !");
    }
}

function create() {
    
	$("#create").append(FORM_CREATE);
    $("#create").hide();
}

function createAccount(player){

	var ps = player.pseudo;

	$.ajax({
 		url: "http://localhost:8080/v1/joueurdb/create:"+ player.pseudo +":"+player.mdp+":"
																										+player.email+":"+player.nom+":"
																										+player.prenom,
		data: {},
		type:"POST",
		dataType:"json",
		success:function() {
			alert("patate");
		},
		error: function(){
			alert("fail");
		}
	});
}

function verifSyn(str) {
    var len = str.length;
    for (var x = 0; x < len; x++) {
        if (str.charCodeAt(x) < 33 || str.charCodeAt(125))
            return false
    }
    return true;
}

function verifChamp(field) {
    if (field.length < 2 || field.length > 16) {
        return false;
    }
    return verifSyn(field);
}

