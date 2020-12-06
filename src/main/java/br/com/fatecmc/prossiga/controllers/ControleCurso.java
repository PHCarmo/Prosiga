package br.com.fatecmc.prossiga.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fatecmc.prossiga.model.dao.CursoDAO;
import br.com.fatecmc.prossiga.model.dao.ProfessorDAO;
import br.com.fatecmc.prossiga.model.domain.Curso;
import br.com.fatecmc.prossiga.model.domain.Professor;

/**
 * Servlet implementation class ControleCurso
 */
@WebServlet("/ControleCurso")
public class ControleCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControleCurso() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String action = request.getParameter("action");

		CursoDAO cursoDAO = new CursoDAO();

		if (action.equalsIgnoreCase("delete")) {
			int id_curso = Integer.parseInt(request.getParameter("id"));
			cursoDAO.excluir(id_curso);
		}
		response.sendRedirect("/eletivaWeb/faces/listaCursos.xhtml");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id_curso = request.getParameter("idCurso");
    	String txtCurso = request.getParameter("txtCurso");
        String txtTurno = request.getParameter("txtTurno");
        String txtDescricao = request.getParameter("txtDescricao");
        System.out.println(id_curso);
    	if(id_curso=="" || id_curso==null) {
    		

            Curso curso = new Curso(txtCurso, txtTurno, txtDescricao);
            CursoDAO cursoDAO = new CursoDAO();
            cursoDAO.salvar(curso);
            response.sendRedirect("/eletivaWeb/faces/listaCursos.xhtml");
    	}else {
    		
    		int id = Integer.parseInt(id_curso);
    		Curso curso = new Curso(txtCurso, txtTurno, txtDescricao);
            CursoDAO cursoDAO = new CursoDAO();
            cursoDAO.alterar(curso, id);
            response.sendRedirect("/eletivaWeb/faces/listaCursos.xhtml");
    	}
    	
	}

}
