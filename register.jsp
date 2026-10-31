<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Craveo | Register</title>
<link rel="stylesheet" href="css/register.css">
</head>

<body>

<div class="container">

	<div class="logo">Craveo</div>

	<h1>Register</h1>

	<form action="register" method="post">

		<label>User Name</label>
		<input type="text" name="userName" placeholder="Enter your name">

		<label>Email</label>
		<input type="email" name="email" placeholder="Enter your email">

		<label>Password</label>
		<input type="password" name="password" placeholder="Enter password">

		<label>Address</label>
		<input type="text" name="address" placeholder="Enter address">

		<input type="hidden" name="role" value="customer">

		<button type="submit">Create Account</button>

	</form>

	<p>
		Already have an account?
		<a href="login.jsp">Login</a>
	</p>

</div>

</body>
</html>