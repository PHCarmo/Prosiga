package br.com.fatecmc.prossiga.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fatecmc.prossiga.model.dao.AlunoDAO;
import br.com.fatecmc.prossiga.model.dao.DisciplinaDAO;
import br.com.fatecmc.prossiga.model.domain.Aluno;
import br.com.fatecmc.prossiga.model.domain.Curso;
import br.com.fatecmc.prossiga.model.domain.Disciplina;
import br.com.fatecmc.prossiga.model.domain.Professor;
import br.com.fatecmc.prossiga.model.domain.Turma;

/**
 * Servlet implementation class ControleDscp
 */
@WebServlet("/ControleDscp")
public class ControleDscp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControleDscp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

		DisciplinaDAO disciplinaDAO = new DisciplinaDAO();

		if (action.equalsIgnoreCase("delete")) {
			int id_disciplina = Integer.parseInt(request.getParameter("id"));
			disciplinaDAO.excluir(id_disciplina);
		}
		response.sendRedirect("/eletivaWeb/faces/listaDscp.xhtml");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id_disciplina = request.getParameter("idDscp");
		String txtDscp = request.getParameter("txtDscp");
		String txtCH = request.getParameter("txtCH");
    	String txtEmenta = request.getParameter("txtEmenta");
    	String id_curso = request.getParameter("idCurso");
    	String id_professor = request.getParameter("idProfessor");
        int ch = Integer.parseInt(txtCH);
    	
    	if(id_disciplina=="" || id_disciplina==null) {
    		int idc = Integer.parseInt(id_curso);
    		int idp = Integer.parseInt(id_professor);
    		Curso curso= new Curso();
    		curso.setId(idc);
    		Professor professor = new Professor();
    		professor.setId(idp);
            Disciplina disciplina = new Disciplina(txtDscp, ch, txtEmenta, curso, professor);
            DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
            disciplinaDAO.salvar(disciplina);
            response.sendRedirect("/eletivaWeb/faces/listaDscp.xhtml");
    	}else {
    		int id = Integer.parseInt(id_disciplina);
    		int idc = Integer.parseInt(id_curso);
    		int idp = Integer.parseInt(id_professor);
    		Curso curso= new Curso();
    		curso.setId(idc);
    		Professor professor = new Professor();
    		professor.setId(idp);
    		Disciplina disciplina = new Disciplina(txtDscp, ch, txtEmenta, curso, professor);
            DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
            disciplinaDAO.alterar(disciplina, id);
            response.sendRedirect("/eletivaWeb/faces/listaDscp.xhtml");
    	}
	}

}
