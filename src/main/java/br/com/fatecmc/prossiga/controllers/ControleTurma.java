package br.com.fatecmc.prossiga.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fatecmc.prossiga.model.dao.CursoDAO;
import br.com.fatecmc.prossiga.model.dao.TurmaDAO;
import br.com.fatecmc.prossiga.model.domain.Curso;
import br.com.fatecmc.prossiga.model.domain.EntidadeDominio;
import br.com.fatecmc.prossiga.model.domain.Turma;

/**
 * Servlet implementation class ControleTurma
 */
@WebServlet("/ControleTurma")
public class ControleTurma extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControleTurma() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");

		TurmaDAO turmaDAO = new TurmaDAO();

		if (action.equalsIgnoreCase("delete")) {
			int id_turma = Integer.parseInt(request.getParameter("id"));
			turmaDAO.excluir(id_turma);
		}
		response.sendRedirect("/eletivaWeb/faces/listaTurma.xhtml");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id_turma = request.getParameter("idTurma");
    	String id_curso = request.getParameter("idCurso");
        String txtDescricao = request.getParameter("txtDescricao");
        
    	if(id_turma=="" || id_turma==null) {
    		int id = Integer.parseInt(id_curso);
    		Curso curso = new Curso();
    		curso.setId(id);
    		System.out.println(curso.getId());
    		System.out.println(id);
            Turma turma = new Turma(txtDescricao, curso);
            TurmaDAO turmaDAO = new TurmaDAO();
            turmaDAO.salvar(turma);
            response.sendRedirect("/eletivaWeb/faces/listaTurma.xhtml");
    	}else {
    		int id = Integer.parseInt(id_turma);
    		int idcurso = Integer.parseInt(id_curso);
    		Curso curso = new Curso();
    		curso.setId(idcurso);
    		Turma turma= new Turma(txtDescricao, curso, id);
    		TurmaDAO turmaDAO = new TurmaDAO();
            turmaDAO.alterar(turma, id);
            response.sendRedirect("/eletivaWeb/faces/listaTurma.xhtml");
    	}
    	
	}
}


