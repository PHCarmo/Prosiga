package br.com.fatecmc.prossiga.model.controle;

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
 * Servlet implementation class ControleProfessor
 */
@WebServlet("/ControleProfessor")
public class ControleProfessor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControleProfessor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String txtProfessor = request.getParameter("txtProfessor");
		String txtTitulacao = request.getParameter("txtTitulacao");
		
		Professor professor = new Professor(txtProfessor, txtTitulacao);

		ProfessorDAO professorDAO = new ProfessorDAO();
		professorDAO.salvar(professor);
		response.sendRedirect("/eletivaWeb/templates/listagemProfessores.xhtml");
	}

}
