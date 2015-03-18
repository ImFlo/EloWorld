<html>
	<head>
		<script src="./js/jquery.js"></script>
		<script  src="./js/base.js"></script>
		<script>
			<!--mettez vos petit script habituelle-->
			login("true");
		</script>
	</head>
	<body>
		<!-- on autorise l acces a cette page que si la session est on-->
		<%
			if(session.getAttribute("login") == null)
				response.sendRedirect("index.jsp");
		%>
		<h1>Welcome mr. <%=session.getAttribute("login")%></h1>
	</body>
</html>
