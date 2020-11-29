package br.com.fatecmc.prossiga.model.controle;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fatecmc.prossiga.model.dao.CursoDAO;
import br.com.fatecmc.prossiga.model.domain.Curso;

/**
 * Servlet implementation class ControleCurso
 */
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

		CursoDAO cursoDAO = new CursoDAO();
		request.setAttribute("cursos", cursoDAO.consultar());
		getServletContext().getRequestDispatcher("/src/main/webapp/templates/listaCursos.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String txtCurso = request.getParameter("txtCurso");
		String txtTurno = request.getParameter("txtTurno");
		String txtDescricao = request.getParameter("txtDescricao");

		Curso curso = new Curso(txtCurso, txtTurno, txtDescricao);

		CursoDAO cursoDAO = new CursoDAO();
		cursoDAO.salvar(curso);
		response.sendRedirect("/eletivaWeb/templates/listaCursos.jsp");

	}

}
