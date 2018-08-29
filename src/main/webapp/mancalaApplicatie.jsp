<!DOCTYPE html>
<html>
	<head>
		<title>Current Person</title>
	</head>
	<body>
   		vak1:
		<jsp:useBean id="vakje1" class="nl.sogyo.mancala.Vakje" scope="request"/>       
		<jsp:getProperty name="vakje1" property="aantalStenen"/>
		vak2:
		<jsp:useBean id="vakje2" class="nl.sogyo.mancala.Vakje" scope="request"/>       
		<jsp:getProperty name="vakje2" property="aantalStenen"/>


	</body>
</html>