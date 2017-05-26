<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center" style="color: #0021BF;">Registrazione MyContact2</h1>
	<center>
		<div>
			Effettua la registrazione a MyContact2<br>
		<table align="center" id="tSignin" style="padding: 15px;">
				<form action="signin?action=signin" method="post">
				<tr>
					<td>
						<label>Nome</label>
					</td>
					<td>
						<input type="text" placeholder="Nome" id="name" name="name" required>
					</td>
				</tr>
				<tr>
					<td>
						<label>Cognome</label>
					</td>
					<td>
						<input type="text" placeholder="Cognome" id="surname" name="surname" required>
					</td>
				</tr>
				<tr>
					<td>
						<label>Data di Nascita</label>
					</td>
					<td>
						<input type="text" placeholder="dd/mm/aaaa" id="dob" name="dob">
					</td>
				</tr>
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
							<input type="submit" value="Registrami" id="signin" style="font-size: 0.9em;">

					</td>
				</tr>
			</form>
			</table>

		</div>
	</center>

</body>
</html>