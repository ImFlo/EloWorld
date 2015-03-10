var FORM_LOGIN = "<form>" +
								 	"<input type=\"text\" value=\"login\" id=\"login\">" +
									"<input type=\"password\" value=\"password\"id=\"passwd\">" +
									"<input type=\"submit\" value=\"envoyer\" id=\"submit\">" +
								"</form>" + 
								"Pas de compte ?<a href=\"./signIn.html\">Cree en un !</a>" +
								"<a href=\"./lostPasswd.html\">Mot de passe perdu</a>";

var MSG_WELCOME = "<a href=\"./index.html\">Elo World</a>"

function login(){
	$("#login").append(FORM_LOGIN);
}
