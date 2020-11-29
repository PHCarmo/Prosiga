package br.com.fatecmc.prossiga.model.controle;

import java.sql.Connection;

import br.com.fatecmc.prossiga.model.connection.ConnectionFactory;
import br.com.fatecmc.prossiga.model.dao.CursoDAO;
import br.com.fatecmc.prossiga.model.domain.Curso;

public class Teste {
	public static void main(String[] args) {
		try {
			
			Curso curso = new Curso("ADS", "Noite", "Analise e Desenvolvimento de Sistemas FATEC");
			
			CursoDAO cursoDAO = new CursoDAO();
			cursoDAO.salvar(curso);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
