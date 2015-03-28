var FORM_LOGIN = "<form class=\"form\" role=\"form\" id=\"form_login\">" +
		"<div class=\"form-group\">" +
		"<label for=\"login\">Login : </label>" +
        "<input type=\"text\" class=\"form-control\" placeholder=\"login\" id=\"login\" name=\"login\">" +
        "</div>" +
        "<div class=\"form-group\">" +
		"<label for=\"passwd\">Password : </label>" +
        "<input type=\"password\" class=\"form-control\" placeholder=\"password\"id=\"passwd\" name=\"password\">" +
        "</div>" +
        "<div class=\"form-group\">" +
        "<center><input type=\"button\" class=\"btn btn-success\" value=\"Envoyer\" id=\"submit\"></center>" +
        "</form>";

var LINK_CREATE = "Pas de compte ? <button id=\"button_create\">Cree en un !</button><br>" +
        "<a href=\"./lostPasswd.html\">Mot de passe perdu</a>";

var FORM_CREATE = "<form class=\"form\" role=\"form\" id=\"create_form\">" +
		"<div class=\"form-group\">" +
		"<label for=\"pseudo\">Pseudo : </label>" +
        "<input type=\"text\" class=\"form-control\" placeholder=\"pseudo\" id=\"pseudo\" value=\"\">" +
        "<input type=\"password\" placeholder=\"password\" id =\"passwd\">" +
        "<input type=\"password\" placeholder=\"repeat password\" id=\"verif_passwd\">" +
        "<input type=\"text\" placeholder=\"e-mail\" id=\"mail\">" +
				 "<input type=\"text\" placeholder=\"e-mail\" id=\"nom\">" +
				  "<input type=\"text\" placeholder=\"e-mail\" id=\"prenom\">" +
        "<input type=\"button\" id=\"sub_account\" value=\"Envoyer\">" +
        "</center><>";


var BUTTON_ADD_FRIEND = "<button id=\"add_friend\">ajouter en ami</button>";

var connecting_key = "";

function trouver_gens(str){
	var ret;
	$.ajax({
		url:"http://localhost:8080/v1/joueurdb/search/" + str,
		data:{},
		type:"GET",
		dataType:"json",
		async:false,
		success:function(s){ret = s;},
		error:function(){}
	});
	return ret;
}

function ajouter_ami(idJ1, idJ2){
	console.log(idj1 + "" + idJ2);
	$.ajax({
		url:"http://localhost:8080/v1/amidb/"+idJ1 + "&" + idJ2,
		data:{},
		type:"POST",
		dataType:"text",
		success:function(){
			alert("cette utilisateur a etait ajouter a votre liste d'ami..");
		},
		error:function(e){
			console.log(e);
		}
	});
}

function sont_ami(id1, id2){
	var ret;
	$.ajax({
		url:"http://localhost:8080/v1/amidb/" + id1 + "&" + id2,
		data:{},
		type:"GET",
		dataType:"text",
		async:false,
		success:function(s){
			ret = s;
		},
		error:function(e){}
	});
	return ret; 
}

function login(str) {	
	switch (str) {
		case "true":  
			$("#login").append(welcome);
			break;
		case "false":
			$("#login").append(FORM_LOGIN);
			break;
		case "":
			$("#login").append(FORM_LOGIN);
			break;
	}
}

function ajouter_en_ami(j1, j2){
	$.ajax({
		url: "http://localhost:8080/v1/amidb",
		data:"ami="+ami,
		type:"POST",
		dataType:"json",
		succes:function(s){
			return s;
		},
		error:function(e){
			console.log(e);
			return undefined;
		}
	});
}

function getJoueur(id){
	var IDENTIFICATE_PLAYER;
	$.ajax({
		url:"http://localhost:8080/v1/joueurdb/" + id,
		data:{},
		type:"GET",
		dataType:"json",
		async: false,
		success:function(a){
			IDENTIFICATE_PLAYER = a;
		},
		error:function(e){
			console.log("fail" + e);
		}
	});
	return IDENTIFICATE_PLAYER;
}

function signIn(log, mdp){
    if((connecting_key = loginIn(log, mdp)) != undefined){
        /*renvoi vers la page prioncipal avec la cle en param*/
    }else{
        alert("login in Failed !");
    }
}

function createAccount(player){
	$.ajax({
 		url: "http://localhost:8080/v1/joueurdb/create:"+ player.pseudo +":"+player.mdp+":"
																										+player.email+":"+player.nom+":"
																										+player.prenom,
		data: {},
		type:"POST",
		dataType:"text",
		success:function() {
			alert("account created");
		},
		error: function(){
			alert("fail");
		}
	});
}

function createPublication(publication, id, jeu){
	$.ajax({
		url: "http://localhost:8080/v1/publicationdb/" + id + "/create&"+publication.texte+"&"+publication.date +"&" + jeu,
		data: {},
		type:"POST",
		dataType:"text",
		success:function(e) {
			console.log(e);
			alert(publication.date + " publication created");
		},
		error: function(){
			alert(publication.date + " fail");
		}
	});
}

function insertPossedeJeu(player, game){
	$.ajax({
		url: "http://localhost:8080/v1/possede_jeudb/insert:"+player+":"+game,
		data: {},
		type:"POST",
		dataType:"text",
		success:function(e) {
			alert("game added");
		},
		error: function(){
			alert("fail");
		}
	});
}

//fonction pour obtenir l'id du jeu	
function getIdByName(name){
	var ret;
	$.ajax({
		url: "http://localhost:8080/v1/jeudb/name=" + name,
		data: {},
		type:"GET",
		dataType:"text",
		async:false,
		success: function(e){
			ret = e;
		},
		error: function(e){
			alert("fail");
		}
		
		
	});
	return ret;
}
