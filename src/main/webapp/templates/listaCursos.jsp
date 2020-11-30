<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<?xml version='1.0' encoding='UTF-8' ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://xmlns.jcp.org/jsf/html"
	xmlns:c="http://java.sun.com/jsp/jstl/core">
<h:head>
	<link rel="stylesheet"
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
		integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
		crossorigin="anonymous" />
	<link href="../css/mystyle.css" rel="stylesheet" type="text/css" />
	<title>Listagem Cursos</title>
</h:head>
<h:body>
	<div>
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-item nav-link active"
					href="#">Home<span class="sr-only">(current)</span></a></li>
				<li class="nav-item active"><a class="nav-link btn-dark"
					href="#">Professores<span class="sr-only">(current)</span></a></li>
				<li class="nav-item active"><a class="nav-link btn-dark"
					href="#">Alunos<span class="sr-only">(current)</span></a></li>
				<li class="nav-item active"><a class="nav-link btn-dark"
					href="#">Disciplinas<span class="sr-only">(current)</span></a></li>
				<li class="nav-item active"><a class="nav-link btn-dark"
					href="#">Turmas<span class="sr-only">(current)</span></a></li>
			</ul>
		</div>
		</nav>
	</div>
	<div class="container centro ">
		<h2>Listagem de Cursos</h2>
		<table class="table table-bordered" id="minhatable">
			<thead class="thead-dark">
				<tr>
					<th>ID</th>
					<th>Nome</th>
					<th>Turno</th>
					<th>Descrição</th>
					<th>Editar</th>
					<th>Deletar</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${cursos}" var="cursoDAO" >
					<tr>
						<td><c:out value="${cursoDAO.id_curso}"></c:out></td>
						<td><c:out value="${cursoDAO.nome}"></c:out></td>
						<td><c:out value="${cursoDAO.turno}"></c:out></td>
						<td><c:out value="${cursoDAO.descricao}"></c:out></td>
						<td><a href="">Editar</a></td>
						<td><a href="">Deletar</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<h:panelGrid columns="2">
			<button type="button" class="btn btn-outline-dark" onclick="location.href='FormCursos.xhtml';">Cadastrar</button>
			<button type="button" class="btn btn-outline-dark">Pesquisar</button>
		</h:panelGrid>
	</div>
</h:body>
</html>

