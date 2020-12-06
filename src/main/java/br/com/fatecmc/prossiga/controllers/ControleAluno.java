package br.com.fatecmc.prossiga.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fatecmc.prossiga.model.dao.AlunoDAO;
import br.com.fatecmc.prossiga.model.dao.TurmaDAO;
import br.com.fatecmc.prossiga.model.domain.Aluno;
import br.com.fatecmc.prossiga.model.domain.Curso;
import br.com.fatecmc.prossiga.model.domain.Turma;

/**
 * Servlet implementation class ControleAluno
 */
@WebServlet("/ControleAluno")
public class ControleAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControleAluno() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");

		AlunoDAO alunoDAO = new AlunoDAO();

		if (action.equalsIgnoreCase("delete")) {
			int id_aluno = Integer.parseInt(request.getParameter("id"));
			alunoDAO.excluir(id_aluno);
		}
		response.sendRedirect("/eletivaWeb/faces/listaAlunos.xhtml");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id_aluno = request.getParameter("idAluno");
		String txtAluno = request.getParameter("txtAluno");
		String txtRA = request.getParameter("txtRA");
    	String id_turma = request.getParameter("idTurma");
        
    	if(id_aluno=="" || id_aluno==null) {
    		int id = Integer.parseInt(id_turma);
    		Turma turma= new Turma();
    		turma.setId(id);
    		System.out.println(turma.getId());
            Aluno aluno = new Aluno(txtAluno, txtRA, turma);
            AlunoDAO alunoDAO = new AlunoDAO();
            alunoDAO.salvar(aluno);
            response.sendRedirect("/eletivaWeb/faces/listaAlunos.xhtml");
    	}else {
    		int id = Integer.parseInt(id_aluno);
    		int idturma = Integer.parseInt(id_turma);
    		Turma turma = new Turma();
    		turma.setId(idturma);
    		Aluno aluno = new Aluno(txtAluno, txtRA, turma);
    		AlunoDAO alunoDAO = new AlunoDAO();
    		alunoDAO.alterar(aluno, id);
            response.sendRedirect("/eletivaWeb/faces/listaAlunos.xhtml");
    	}
    	
	}
}

