<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modifica Contatto</title>
</head>
<body>
	<h1 align="center" style="color: #0021BF;">Aggiorna il contatto</h1>
	<h2>
		<form action="update" method="post">
			<center>
			<div>
				<table id="tAggiornaContatto" style="align:center;">
					<tr>
						<td><label>Nome</label></td>
						<td><input type="text" id="nome" name="nome" value="${contact.nome}" required></td>
					</tr>
					<tr>
						<td><label>Cognome</label></td>
						<td><input type="text" id="cognome" name="cognome" value="${contact.cognome}" required></td>
					</tr>
					<tr>
						<td><label>Telefono</label></td>
						<td><input type="text" id="telefono" name="telefono" value="${contact.telefono}" required></td>
					</tr>
					<tr>
						<td><label>Email</label></td>
						<td><input type="text" id="email" name="email" value="${contact.email}"></td>
					</tr>
				</table>
			</div>
			<br>
			<input type="submit" value="Salva" id="salva" style="font-size: 0.9em;">
			</center>
		</form>
	</h2>
</body>
</html>