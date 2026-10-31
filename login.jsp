<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Craveo | Login</title>
<link rel="stylesheet" href="css/login.css">
</head>

<body>

<div class="container">

	<div class="logo">Craveo</div>

	<h1>Login</h1>

	<form action="login" method="post">

		<label>Email</label>
		<input type="text" name="email" placeholder="Email">

		<label>Password</label>
		<input type="password" name="password" placeholder="Password">

		<button type="submit">Login</button>

	</form>

	<p>
		Don't have an account?
		<a href="register.jsp">Sign Up</a>
	</p>

</div>

</body>
</html>