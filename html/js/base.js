var FORM_LOGIN = "<form>" +
								 	"<input type=\"text\" placeholder=\"login\" id=\"login\">" +
									"<input type=\"password\" placeholder=\"password\"id=\"passwd\">" +
									"<input type=\"submit\" value=\"envoyer\" id=\"submit\">" +
								"</form>" + 
								"Pas de compte ? <a href=\"./signIn.html\">Cree en un !</a><br>" +
								"<a href=\"./lostPasswd.html\">Mot de passe perdu</a>";

var MSG_WELCOME = "<a href=\"./index.html\">Elo World</a>";

function login(){
	$("#login").append(FORM_LOGIN);
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

