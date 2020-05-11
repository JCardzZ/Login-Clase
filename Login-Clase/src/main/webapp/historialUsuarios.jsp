<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Historial Usuario</title>
</head>
<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script src="http://code.jquery.com/jquery-latest.js">
</script>
<script type="text/javascript">
	$(document).ready(function () {
		
			
			$.post('ServletHistorialUsuario', {

			}, function (response) {
				
				let datos = JSON.parse(response);
				
				
				var tablaDatos = document.getElementById('tablaDatos');
				for (let item of datos) {
					
					tablaDatos.innerHTML += `

					`
				}
			
		});

	});

</script>
<body>
	
	<table class="table table-dark" id="tablaDatos">

		<head>
			<th>Id</th>
			<th>Nombre</th>
			<th>Precio</th>
			<th>Cantidad</th>
			<th>Total</th>
			<th>Opciones</th>
		</head>

		<tbody>


		</tbody>
	</table>

</body>

</html>