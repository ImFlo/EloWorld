<%@ page session="true" %>
<!DOCTYPE html>
<html lang="fr">
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="./css/bootstrap.min.css">
		<script src="./js/jquery.js" ></script>
		<script src="./js/base.js"></script>
		<script src="./js/bootstrap.min.js"></script>
		<script>
			$(document).ready(function(){
				var url = window.location.search;
				url = url.substring(url.lastIndexOf("fail")+5);
				<%
					/*on checkl si la session a etait créer*/
					if(session.getAttribute("login") != null)
						out.print("login(\"true\");");
					else
						out.print("login(\"false\");");
				%>
				create();
				$("#welcome").append(MSG_WELCOME);
				
				
				
					$("#sub_account").click(function(){
						console.log("patate");
						var player = new Object();
						player.pseudo = $("#pseudo").value;
						player.email = $("#passwd").value;
						player.mdp = $("#mail").value;
						player.prenom = $("#prenom").value;
						player.nom = $("#nom").value;
						alert("clicked");
						createAccount(player);
					});
			  		
				if(url === "true")
					alert("login/mdp incorrect");
			});
		</script>
	</head>
	
	<body>
		<div class="container">
			<div class="jumbotron" id="elo">
				<center><h1 id="welcome"></h1>
				<p>Le réseau social des gamers</p></center>
			</div>
			
			<h2>Se connecter</h2>
			<div id="login"></div>		
		</div>
		
			<!--- <div id="create"></div>--->
			<div class="container">
			<div class="panel-group" id="accordion">
	<div class="panel panel-default">
		<div class="panel-heading">
			<h4 class="panel-title">
				<center><a data-toggle="collapse" data-parent="#accordion" href="#create">
					Pas encore inscrit ? Créez un compte !
				</a></center>
			</h4>
		</div>

		<div id="create" class="panel-collapse collapse">
			<div class="panel-body">
				<form class="form" role="form">
					<div class="form-group">
						<label for="nom">Last-Name : </label>
						<input type="text" placeholder="Last-Name" id="nom" class="form-control">
					</div>
					<div class="form-group">
						<label for="prenom">First-Name : </label>
						<input type="text" placeholder="First-Name" id="prenom" class="form-control">
					</div>
					<div class="form-group">
						<label for="mail">E-mail : </label>
						<input type="email" placeholder="E-mail" id="mail" class="form-control">
					</div>
					<div class="form-group">
						<label for="pseudo">Pseudo : </label>
						<input type="text" placeholder="Pseudo" id="pseudo" class="form-control">
					</div>
					<div class="form-group">
						<label for="passwd">Password : </label>
						<input type="password" placeholder="Password" id="passwd" class="form-control">
					</div>
					<div class="form-group">
						<center><button id=\"sub_account\" type="submit" class="btn btn-success">Créer le compte</button></center>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
</div>
	
		<div class="container">
			<h3>Qu'est-ce que "Elo World" ?</h3>
			<p>Elo World est un réseau social qui réunit des joueurs du monde entier, afin de partager leurs connaissances, leurs points de vue.<br />
			Mais surtout dans le but de faire rencontrer les joueurs entre eux, pour s'affronter !<br />
			En effet, ce réseau social comprends des algorythmes qui "match" les joueurs jouant au même jeu, en fonction de leurs niveaux<br />
			Vous ne tomberez jamais contre quelqu'un ayant un niveau nettement supérieur à vous, sauf si c'est un smurf ;)</p>
		</div>
	</body>
</html>
