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
String curso = request.getParameter("curso");
curso=(curso!=null)?curso : "";
String descricao = request.getParameter("descricao");
descricao=(descricao!=null)?descricao : "";
%>

<body>
	<form action="ControleTurma" method="POST">		
		<label for="idTurma">Id Turma:</label>
		<input type="text" id="idTurma" name="idTurma" readonly="readonly" value="<%=id%>"/>
		<br />
		
		<label for="txtDescricao">Descricao:</label>
		<input type="text" id="txtDescricao" name="txtDescricao" value="<%=descricao%> " />
		<br />
		
		<label for="idCurso">Id Curso:</label>
		<input type="text" id="idCurso" name="idCurso" value="<%=curso%>"/>
		<h3>Favor inserir id de um curso cadastrado.</h3>
		<br />	
		
		<input type="submit" value="SALVAR"/>
	
	</form>
</body>
</html>