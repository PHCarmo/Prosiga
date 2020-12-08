<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
    <link href="css/mystyle.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.min.css" />
    <title>Prossiga - Professor</title>
</head>
<%
String id = request.getParameter("id"); // aqui recebe o valor passado e manda para o select 
id=(id!=null)?id : "";
String nome = request.getParameter("nome");
nome=(nome!=null)?nome : "";
String titulacao = request.getParameter("titulacao");
titulacao=(titulacao!=null)?titulacao : "";

%>

<body>
	<form action="ControleProfessor" method="POST">		
		<label for="idProfessor">Id:</label>
		<input type="text" id="idProfessor" name="idProfessor" readonly="readonly" value="<%=id%>" readonly />
		<br />
		
		<label for="txtProfessor">Nome:</label>
		<input type="text" id="txtProfessor" name="txtProfessor" value="<%=nome%>" />
		<br />
		
		<label for="txtTitulacao">Titulacao:</label>
		<input type="text" id="txtTitulacao" name="txtTitulacao" value="<%=titulacao%>" />
		<br />	
		
		<input type="submit" value="Salvar"/>
	
	</form>
</body>
</html>