<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
    <link href="css/mystyle.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.min.css" />
    <title>Prossiga - Curso</title>
</head>
<%
String id = request.getParameter("id"); // aqui recebe o valor passado e manda para o select 
id=(id!=null)?id : "";
String nome = request.getParameter("nome");
nome=(nome!=null)?nome : "";
String turno = request.getParameter("turno");
turno=(turno!=null)?turno : "";
String descricao = request.getParameter("descricao");
descricao=(descricao!=null)?descricao : "";

%>

<body>
	<form action="ControleCurso" method="POST">		
		<label for="idCurso">Id:</label>
		<input type="text" id="idCurso" name="idCurso" readonly="readonly" value="<%=id%>" readonly />
		<br />
		
		<label for="txtCurso">Nome:</label>
		<input type="text" id="txtCurso" name="txtCurso" value="<%=nome%>" />
		<br />
		
		<label for="txtTurno">Turno:</label>
		<input type="text" id="txtTurno" name="txtTurno" value="<%=turno%>" />
		<br />	
		
		<label for="txtDescricao">Descricao:</label>
		<input type="text" id="txtDescricao" name="txtDescricao" value="<%=descricao%>" />
		<br />	
		
		<input type="submit" value="Salvar"/>
	
	</form>
</body>
</html>