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
String turno = request.getParameter("turno");
turno=(turno!=null)?turno : "";
String descricao = request.getParameter("descricao");
descricao=(descricao!=null)?descricao : "";

%>

<body>
	<form action="ControleCurso" method="POST">		
		<label for="idCurso">Id:</label>
		<input type="text" id="idCurso" name="idCurso" readonly="readonly" value="<%=id%>"/>
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
		
		<input type="submit" value="SALVAR"/>
	
	</form>
</body>
</html>