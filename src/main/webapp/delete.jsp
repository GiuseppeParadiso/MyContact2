<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Elimina Contatto</title>
</head>
<body>
	<h1 align="center" style="color: #0021BF;">Dati Contatto da eliminare</h1>
	<h2>
		<form action="delete" method="post">
			<center>
				<div>
					<table id="tDeleteContatto" style="align:center;">
						<tr>
							<td><label>Nome: ${contact.nome}</label></td>
						</tr>
						<tr>
							<td><label>Cognome: ${contact.cognome}</label></td>
						</tr>
						<tr>
							<td><label>Telefono: ${contact.telefono}</label></td>
						</tr>
						<tr>
							<td><label>Email: ${contact.email}</label></td>
						</tr>
					</table>
				</div>
				<br>
				<input type="submit" value="Conferma" id="conferma" style="font-size: 0.9em;">
			</center>
		</form>
		
	</h2>
</body>
</html>