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
    <div>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item active">
                        <a class="nav-item nav-link active" href="..">Home<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link btn-dark" href="listaProf.xhtml">Professores<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link btn-dark" href="listaAlunos.xhtml">Alunos<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link btn-dark" href="listaDscp.xhtml">Disciplinas<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link btn-dark" href="listaTurma.xhtml">Turmas<span class="sr-only">(current)</span></a>
                    </li>
                </ul>
            </div>
        </nav>
    </div>
    <div class="container centro ">
	<form action="ControleCurso" method="POST">		
		<label for="idCurso">Id:</label>
		<input type="number" id="idCurso" name="idCurso" value="<%=id%>" readonly />
		<br />
		
		<label for="txtCurso">Nome:</label>
		<input type="text" id="txtCurso" name="txtCurso" maxlength="30" value="<%=nome%>" />
		<br />
		
		<label for="txtTurno">Turno:</label>
		<input type="text" id="txtTurno" name="txtTurno" maxlength="10" value="<%=turno%>" />
		<br />	
		
		<label for="txtDescricao">Descricao:</label>
		<input type="text" id="txtDescricao" name="txtDescricao" maxlength="60" value="<%=descricao%>" />
		<br />	
		
		<input type="submit" class="btn btn-outline-dark" value="Salvar"/>
	
	</form>
    </div>
</body>
</html>