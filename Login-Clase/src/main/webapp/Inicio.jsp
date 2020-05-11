<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%
HttpSession seccion = (HttpSession) request.getSession();
String usuariovariabledesesion = (String)(seccion).getAttribute("usuario");
if(usuariovariabledesesion==null){
	response.sendRedirect("index.jsp");
}
%>
<body>
<form action="ServletUser" method="post">
<input type="submit" value="CERRAR" name="btncerrar">
</form>

<a href="historialUsuarios.jsp">VER HISTORIAL DE USUARIOS</a>
<h1>Bienvenido a la pagina principal</h1>
</body>
</html>