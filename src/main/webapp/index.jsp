<%@ page session="true" %>
<!DOCTYPE html>
<html lang="fr">
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="./css/bootstrap.min.css">
		<script src="./js/jquery.js" ></script>
		<script src="./js/base.js"></script>
		<script src="js/cookie.js"></script>
		<script src="./js/bootstrap.min.js"></script>
		<script>
			$(document).ready(function(){
				<!-- si lutilisateur est deja co -->
				if(readCookie("id") != null){
					 document.location.href="homepage.jsp"; 
				}

				$("#login").append(FORM_LOGIN);
				$("#submit").click(function(){
					var lgn = $("#login", $("#form_login")).val();
					var mdp = $("#passwd", $("#form_login")).val();
					console.log(login);
					$.ajax({
 						url: "http://localhost:8080/v1/joueurdb/" + lgn + "&" + mdp,
						data: {},
						type:"GET",
						dataType:"text",
						success:function(a) {
							createCookie("id",a,new Date());
							document.location.href="homepage.jsp";
						},
						error: function(a){
							alert("fail" + a);
							console.log(a);
						}
					});

				});
				create();
				$("#welcome").append(MSG_WELCOME);
				$("#sub_account").click(function(){
						console.log("je suis une patate douce !");
						console.log($("#passwd" ,$("#form_create")).val());
						var player = new Object();
						player.pseudo = $("#pseudo").val();
						player.email = $("#mail").val();
						player.mdp = $("#passwd", $("#form_create")).val();
						player.prenom = $("#prenom").val();
						player.nom = $("#nom").val();
						console.log(player);
						alert("clicked");
						createAccount(player);
					});
			  		
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

				<!-- le form commence la !-->
				<form class="form" role="form" id="form_create">
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
						<center><input id="sub_account" type="button" class="btn btn-success" value="Creer le compte" ></center>
					</div>
				</form>
				<!-- il fini la !-->
			
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
