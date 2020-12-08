<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
    <link href="css/mystyle.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.min.css" />
    <title>Prossiga - Disciplina</title>
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
                        <a class="nav-link btn-dark" href="listaCursos.xhtml">Cursos<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link btn-dark" href="listaTurma.xhtml">Turmas<span class="sr-only">(current)</span></a>
                    </li>
                </ul>
            </div>
        </nav>
    </div>
    <div class="container centro ">
	<form action="ControleDscp" method="POST">		
		<label for="idDscp">Id:</label>
		<input type="number" id="idDscp" name="idDscp" value="<%=id%>" readonly />
		<br />
		
		<label for="txtDscp">Nome:</label>
		<input type="text" id="txtDscp" name="txtDscp" maxlength="30" value="<%=nome%>" />
		<br />
		
		<label for="txtCH">Carga horaria:</label>
		<input type="number" id="txtCH" name="txtCH" min="0" max="9999" value="<%=ch%>" />
		<br />	
		
		<label for="txtEmenta">Ementa:</label>
		<input type="text" id="txtEmenta" name="txtEmenta" maxlength="100" value="<%=ementa%>" />
		<br/>
		
		<label for="idCurso">Curso:</label>
		<input type="number" id="idCurso" name="idCurso" min="1" max="99999" value="<%=curso%>" />
		<br/>
		
		<label for="idProfessor">Professor:</label>
		<input type="number" id="idProfessor" name="idProfessor" min="1" max="99999" value="<%=professor%>" />
		<br/>
		
		<h5>Favor inserir id de um curso e de um professor cadastrados.</h5>
		
		<input type="submit" class="btn btn-outline-dark" value="Salvar"/>
	
	</form>
    </div>
</body>
</html>