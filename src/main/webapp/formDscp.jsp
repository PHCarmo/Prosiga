<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
    <link href="css/mystyle.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.min.css" />
</head>
<%
String id = request.getParameter("id"); // aqui recebe o valor passado e manda para o select 
id=(id!=null)?id : "";
String nome = request.getParameter("nome");
nome=(nome!=null)?nome : "";
String ch = request.getParameter("ch");
ch=(ch!=null)?ch : "";
String ementa = request.getParameter("ementa");
ementa=(ementa!=null)?ementa : "";
String curso = request.getParameter("curso");
curso=(curso!=null)?curso : "";
String professor = request.getParameter("professor");
professor=(professor!=null)?professor : "";

%>

<body>
	<form action="ControleDscp" method="POST">		
		<label for="idDscp">Id:</label>
		<input type="text" id="idDscp" name="idDscp" readonly="readonly" value="<%=id%>"/>
		<br />
		
		<label for="txtDscp">Nome:</label>
		<input type="text" id="txtDscp" name="txtDscp" value="<%=nome%>" />
		<br />
		
		<label for="txtCH">Carga horaria:</label>
		<input type="text" id="txtCH" name="txtCH" value="<%=ch%>" />
		<br />	
		
		<label for="txtEmenta">Ementa:</label>
		<input type="text" id="txtEmenta" name="txtEmenta" value="<%=ementa%>" />
		<br/>
		
		<label for="idCurso">Curso:</label>
		<input type="text" id="idCurso" name="idCurso" value="<%=curso%>" />
		<br/>
		
		<label for="idProfessor">Professor:</label>
		<input type="text" id="idProfessor" name="idProfessor" value="<%=professor%>" />
		<br/>
		
		<h3>Favor inserir id de um curso e de um professor cadastrados.</h3>
		
		<input type="submit" value="Salvar"/>
	
	</form>
</body>
</html>