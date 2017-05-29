<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Editando estudiante</title>
<!-- Bootstrap -->
    <link href="http://getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

	
	<!-- ${not empty op ? ´../edit´ : ´addStudent´}-->
	<form:form method="POST" action="edit" modelAttribute="studentForm">
		<form:hidden path="id"/>		 
    		<form:label path="nombre">Nombre</form:label>
    		<form:input path="nombre"/>
  		<br>
    		<form:label path="apellido">Apellidos</form:label>
    		<form:input path="apellido"/>
  		<br>
  		<input type="submit" value="yeah" class="btn btn-primary">
	</form:form>

	


	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="http://getbootstrap.com/dist/js/bootstrap.min.js"></script>
</body>
</html>