<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Current Person</title>
		<link type="text/css" href="Mancala.css" rel="stylesheet"/>
	</head>
	<body>

		<jsp:useBean id="vakjeLijst1" class="java.util.ArrayList" scope="request"/>
		<jsp:useBean id="vakjeLijst2" class="java.util.ArrayList" scope="request"/>
		<jsp:useBean id="kalaha1" class="nl.sogyo.mancala.Kalaha" scope="request"/>
		<jsp:useBean id="kalaha2" class="nl.sogyo.mancala.Kalaha" scope="request"/>
		
		<div class="grid-container">
			<div id = kalaha><jsp:getProperty name="kalaha1" property="aantalStenen"/></div>
			
			<c:forEach items="${vakjeLijst1}" var="vakje">
				<div>${vakje.aantalStenen}</div>
			</c:forEach>
			
			<div id = kalaha><jsp:getProperty name="kalaha2" property="aantalStenen"/></div>
			
			<c:forEach items="${vakjeLijst2}" var="vakje">
				<div>${vakje.aantalStenen}</div>
			</c:forEach>
		</div>


	</body>
</html>