<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>:::: CADASTRO DE FUNCIONARIO::::</title>
</head>
<%
String id = request.getParameter("id"); // aqui recebe o valor passado e manda para o select 
id=(id!=null)?id : "";
String nome = request.getParameter("nome");
nome=(nome!=null)?nome : "";
String ra = request.getParameter("ra");
ra=(ra!=null)?ra : "";
String turma = request.getParameter("turma");
turma=(turma!=null)?turma : "";

%>

<body>
	<form action="ControleAluno" method="POST">		
		<label for="idAluno">Id:</label>
		<input type="text" id="idAluno" name="idAluno" readonly="readonly" value="<%=id%>"/>
		<br />
		
		<label for="txtAluno">Nome:</label>
		<input type="text" id="txtAluno" name="txtAluno" value="<%=nome%>" />
		<br />
		
		<label for="txtRA">RA:</label>
		<input type="text" id="txtRA" name="txtRA" value="<%=ra%>" />
		<br />	
		
		<label for="idTurma">Turma:</label>
		<input type="text" id="idTurma" name="idTurma" value="<%=turma%>" />
		<br/>
		
		<h3>Favor inserir id de uma turma cadastrada.</h3>
		
		<input type="submit" value="SALVAR"/>
	
	</form>
</body>
</html>