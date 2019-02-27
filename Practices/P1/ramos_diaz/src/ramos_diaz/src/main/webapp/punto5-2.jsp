<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New User</title>
</head>
<body>
	<h2>New User</h2>
	<form method="POST" action="Punto5">
		<label>First name:</label>
		<input type="text" name="firstName" id="firstName" required>
		<br>
		<label>Last name:</label>
		<input type="text" name="lastName" id="lastName" required>
		<br>
		<label>Second last name:</label>
		<input type="text" name="secondName" id="secondName" required>
		<br>
		<label>CURP:</label>
		<input type="text" name="curp" id="curp" required>
		<br>
		<label>Birthday:</label>
		<input type="date" name="birthday" id="birthday" required>
		<br>
		<label>Login:</label>
		<input type="email" name="login" id="login" required>
		<br>
		<label>Password:</label>
		<input type="password" name="password" id="password" required>
		<br>
		<label>Confirm Password:</label>
		<input type="password" name="confirmPassword" id="confirmPassword" required>
		<br>
		<a href="Punto5"><button type="button">Cancel</button></a>
		<input type="submit" value="Save">	
	</form>
</body>
</html>