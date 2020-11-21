package br.com.fatecmc.prossiga.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fatecmc.prossiga.model.domain.EntidadeDominio;
import br.com.fatecmc.prossiga.controllers.tabela.*;
import br.com.fatecmc.prossiga.model.dao.*;

@WebServlet("/dadosTabelaController")
public class DadosTabelaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IGeradorJson geradorJson;
       
    public DadosTabelaController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tabela = request.getParameter("tabela");
		
		String json = "";
		IDAO dao = null;
		List<EntidadeDominio> entidades = new ArrayList<>();
		
		switch(tabela) {
			case "aluno":
				geradorJson = new GeradorTabelaAluno();
				dao = new AlunoDAO();
				break;
			case "curso":
				geradorJson = new GeradorTabelaCurso();
				dao = new CursoDAO();
				break;
			case "disciplina":
				geradorJson = new GeradorTabelaDisciplina();
				dao = new DisciplinaDAO();
				break;
			case "professor":
				geradorJson = new GeradorTabelaProfessor();
				dao = new ProfessorDAO();
				break;
			case "turma":
				geradorJson = new GeradorTabelaTurma();
				dao = new TurmaDAO();
				break;
			default:
				return;
		}
		
		entidades = dao.consultar();
		json = geradorJson.gerar(entidades);
		
		response.setStatus(200);
		response.getWriter().write(json);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
