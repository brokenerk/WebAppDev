 <%@ page language="java" contentType="text/html; charset=utf-8" 
 pageEncoding="windows-1256" import="mx.ipn.escom.wad.servlets.p2.entidad.*" %>
 
<html>
	<head>
		<title>Welcome!!!!</title>
	</head>
	<body>
		<h1>Bienvenido</h1><br>
		<% Persona currentPersona = (Persona) (session.getAttribute("currentSessionPersona"));%> 
		<% Cuenta currentCuenta = (Cuenta) (session.getAttribute("currentSessionCuenta"));%>

		<%= currentPersona.getNombre() + " " + currentPersona.getPrimerApellido() + " " + currentPersona.getSegundoApellido()%>
		<br><br>
		<%= currentCuenta.getRol().getNombre() + ": " + currentCuenta.getRol().getDescripcion()%><br>
		
		<a href="punto2.jsp"><button>Ver recursos</button></a><br>
		<a href="/ramos_diaz/"><button>Index</button></a>
	</body>
</html>
