<%@ page session="true" %>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="css/style_index.css">
		<script src="./js/jquery.js" ></script>
		<script src="./js/base.js"></script>
		<script>
			$(document).ready(function(){
				var url = window.location.search;
				url = url.substring(url.lastIndexOf("fail")+5);
				<%
					/*on checkl si la session a etait créer*/
					if(session.getAttribute("login") != null)
						out.print("login(\"true\")");
					else
						out.print("login(\"false\")");
				%>
				create();
				$("#welcome").append(MSG_WELCOME);
				
				$("#button_create").click(function(){
					$("#create").show();
			  });		
				if(url === "true")
					alert("login/mdp incorrect");
			});
		</script>
	</head>
	<body>
		<h1 id="welcome"></h1>
		<div id="login"></div>
		<div id="create"></div>
	</body>
</html>
