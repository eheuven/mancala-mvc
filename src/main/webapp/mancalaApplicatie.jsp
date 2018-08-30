<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Current Person</title>
		<link type="text/css" href="Mancala.css" rel="stylesheet"/>
	</head>
	<body>

		<jsp:useBean id="vakjeInfoLijst1" class="java.util.ArrayList" scope="session"/>
		<jsp:useBean id="vakjeInfoLijst2" class="java.util.ArrayList" scope="session"/>
		<jsp:useBean id="kalaha1" class="nl.sogyo.BordItemInfo" scope="session"/>
		<jsp:useBean id="kalaha2" class="nl.sogyo.BordItemInfo" scope="session"/>
		<jsp:useBean id="message" class="nl.sogyo.Message" scope="session"/>
		
		<h1><jsp:getProperty name="message" property="message"/></h1>
		
		<form action="${pageContext.request.contextPath}/Servlet1" method="post">
			<div class="grid-container">
				<div id = kalaha><input type = "submit" name = "${kalaha1.itemNr}" value = "${kalaha1.aantalStenen}"/></div>
				<!-- kalaha button zit bovenin ipv gestrekt over 2 rows -->
				
				<c:forEach items="${vakjeInfoLijst1}" var="vakje">
					<div><input type = "submit" name = "${vakje.itemNr}" value = "${vakje.aantalStenen}"/></div> 
				</c:forEach>
				
				<div id = kalaha><input type = "submit" name = "${kalaha2.itemNr}" value = "${kalaha2.aantalStenen}"/></div> 
				
				<c:forEach items="${vakjeInfoLijst2}" var="vakje">
					<div><input type = "submit" name = "${vakje.itemNr}" value = "${vakje.aantalStenen}"/></div> 
				</c:forEach>
			</div>
		</form>

	</body>
</html>