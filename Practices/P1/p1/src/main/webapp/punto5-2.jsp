<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Parameters and values</title>
</head>
<body>
	
	<form method="POST" action="Punto5">
		<label>First name:</label>
		<input type name="firstname" id="firstname">
		<br>
		<label>Last name:</label>
		<input type name="lastname" id="lastname">
		<br>
		<label>Second last name:</label>
		<input type name="secondname" id="secondname">
		<br>
		<label>CURP:</label>
		<input type name="curp" id="curp">
		<br>
		<label>Birthday:</label>
		<input type name="birthday" id="birthday">
		<br>
		<label>Login:</label>
		<input type name="login" id="login">
		<br>
		<label>Password:</label>
		<input type name="password" id="password">
		<br>
		<label>Confirm Password:</label>
		<input type name="newpassword" id="newpassword">
		<br>
		<input type="submit" value="Save">
	</form>
	<a href="index.jsp"><button>Cancel</button></a>

</body>
</html>