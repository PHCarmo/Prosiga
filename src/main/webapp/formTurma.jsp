<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
    <link href="css/mystyle.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.min.css" />
    <title>Prossiga - Turma</title>
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
                        <a class="nav-link btn-dark" href="listaCursos.xhtml">Cursos<span class="sr-only">(current)</span></a>
                    </li>
                </ul>
            </div>
        </nav>
    </div>
    <div class="container centro ">
	<form action="ControleTurma" method="POST">		
		<label for="idTurma">Id:</label>
		<input type="number" id="idTurma" name="idTurma" value="<%=id%>" readonly />
		<br />
		
		<label for="txtDescricao">Descricao:</label>
		<input type="text" id="txtDescricao" name="txtDescricao" maxlength="30" value="<%=descricao%> " />
		<br />
		
		<label for="idCurso">Curso:</label>
		<input type="text" id="idCurso" name="idCurso" min="1" max="99999" value="<%=curso%>"/>
		<h5>Favor inserir id de um curso cadastrado.</h5>
		<br />	
		
		<input type="submit" class="btn btn-outline-dark" value="Salvar"/>
	
	</form>
    </div>
</body>
</html>