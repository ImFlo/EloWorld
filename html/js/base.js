var FORM_LOGIN = "<form>" +
								 	"<input type=\"text\" placeholder=\"login\" id=\"login\">" +
									"<input type=\"password\" placeholder=\"password\"id=\"passwd\">" +
									"<input type=\"submit\" value=\"envoyer\" id=\"submit\">" +
								"</form>";
								
var LINK_CREATE = "Pas de compte ? <button id=\"button_create\">Cree en un !</button><br>" +
								"<a href=\"./lostPasswd.html\">Mot de passe perdu</a>";

var MSG_WELCOME = "<a href=\"./index.html\">Elo World</a>";

var FORM_CREATE = "<center><h3>Creer un compte :</h3>" +
		"<form>" +
"<input type=\"text\" placeholder=\"pseudo\" id=\"pseudo\">"+
"<input type=\"password\" placeholder=\"password\" id =\"passwd\">"+
"<input type=\"password\" placeholder=\"repeat password\" id=\"verif_passwd\">"+
"<input type=\"text\" placeholder=\"e-mail\" id=\"mail\">"+
"<input type=\"button\" id=\"submit\" value=\"envoyer\">"+
"</form></center>";

function login(){
	$("#login").append(FORM_LOGIN);
	$("#login").append(LINK_CREATE);	
}

function create(){
	$("#create").append(FORM_CREATE);
	$("#create").hide();
}

function verifSyn(str){
	var len = str.length;
	for(var x = 0; x < len; x++){
		if(str.charCodeAt(x) < 33 || str.charCodeAt(125))
				return false
	}
	return true;
}

function verifChamp(field){
	if(field.length < 2 || field.length > 16){
		return false;
	}
	return verifSyn(field);
}

