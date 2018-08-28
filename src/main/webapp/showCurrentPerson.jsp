<!DOCTYPE html>
<html>
   <head>
       <title>Current Person</title>
   </head>
   <body>
       Current Person’s first name:
<jsp:useBean id="currentPerson" class="nl.sogyo.Person" scope="request"/>       
<jsp:getProperty name="currentPerson" property="firstName"/>
       Current Person’s last name:
       <jsp:getProperty name="currentPerson" property="lastName"/>
   </body>
</html>