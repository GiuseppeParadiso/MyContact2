<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login MyContact2</title>
</head>
<body>
	<h1 align="center" style="color: #0021BF;">Login MyContact2</h1>
	<center>
		<div>
			Effettua il login<br>
		<table align="center" id="tLogin" style="padding: 15px;">
						<form action="login?action=login" method="post">
				<tr>
					<td>
						<label>Username</label>
					</td>
					<td>
						<input type="text" placeholder="username" id="username" name="username" required>
					</td>
				</tr>
				<tr>
					<td>
						<label>Password</label>
					</td>
					<td>
						<input type="password" placeholder="password" id="password" name="password" required>
					</td>
				</tr>
			</table>
			
			<table align="center" id="tExecute" style="padding: 15px;">
				<tr>
					<td>
						
							<input type="submit" value="Login" id="login" style="font-size: 0.9em;">
						</form>
					</td>
					<td>
						<form action="login?action=signin" method="post">
							<input type="submit" value="Registrati" id="registrati" style="font-size: 0.9em;">					
						</form>
					</td>
				</tr>
			</table>
		</div>
	</center>
</body>
</html>