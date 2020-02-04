<html>
	<head>
		<% import model.*; %>
		<title>KBB<title>
	</head>
	
	<body>
		<% 
			Automotive auto = request.getAttribute("auto");
			out.println(auto.getTotalPrice());
		 %>
	</body>
</html>