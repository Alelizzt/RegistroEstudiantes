<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- %@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Lista de estudiantes</title>
<!-- Bootstrap -->
<link href="http://getbootstrap.com/dist/css/bootstrap.min.css"
	rel="stylesheet">

</head>
<body>

<div class="container">
<form method="get" action="find" class="form-inline">
<div class="form-group">
      <label for="nombreEst">Nombre:</label>
      <input id="nombreEst" name="nombreEst" placeholder="Nombre" class="form-control"/>
    </div>
	<div class="form-group">
		<label for="apellidoEst">Apellido:</label>
		<input id="apellidoEst" name="apellidoEst" placeholder="Apellido" class="form-control" />
	</div>
	
	<button type="submit" class="btn btn-default">Buscar</button>
</form>
</div>
<div class="container">
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>Apellidos</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ListaEstudiantes}" var="ListaEstudiante">
				<tr>
					<td><c:out value="${ListaEstudiante.id}"/> </td>
					<td><c:out value="${ListaEstudiante.nombre}"/></td>
					<td><c:out value="${ListaEstudiante.apellido}"/></td>
					
					<td><a href="./edit/${ListaEstudiante.id}" class="btn btn-success">Editar</a></td>
					<td><a href="./delete/${ListaEstudiante.id}" class="btn btn-success">Eliminar</a></td>
					
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<a href="./newStudent" class="btn btn-link" role="button">Agregar nuevo estudiante</a>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="http://getbootstrap.com/dist/js/bootstrap.min.js"></script>
</body>
</html>