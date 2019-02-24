 <%@ page language="java" contentType="text/html; charset=windows-1256" 
 pageEncoding="windows-1256" import="mx.ipn.escom.wad.tarea6.entidad.*" %>
 
<html>
<body>
	<h1>Bienvenido</h1>
	<% Persona currentPersona = (Persona) (session.getAttribute("currentSessionPersona"));%> 
	<% Cuenta currentCuenta = (Cuenta) (session.getAttribute("currentSessionCuenta"));%>

	<br>
	<%= currentPersona.getNombre() + " " + currentPersona.getPrimerApellido() + " " + currentPersona.getSegundoApellido()%>
	<br>
	<br>
	<%= currentCuenta.getRol().getNombre() + ": " + currentCuenta.getRol().getDescripcion()%>
	<br>

</body>
</html>
