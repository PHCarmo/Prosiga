package br.com.fatecmc.prosiga.model.dao;

import br.com.fatecmc.prosiga.model.connection.ConnectionFactory;
import br.com.fatecmc.prosiga.model.domain.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DisciplinaDAO implements IDAO {
    private Connection conn;

    @Override
    public boolean salvar(EntidadeDominio entidade) {
        this.conn = ConnectionFactory.getConnection();
        String sql = "INSERT INTO disciplinas(nome, carga_horaria, ementa, id_curso, id_professor) VALUES(?, ?, ?, ?, ?)";

        PreparedStatement stmt = null;
        
        if(entidade instanceof Disciplina){
            try {
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, ((Disciplina) entidade).getNome());
                stmt.setInt(2, ((Disciplina) entidade).getCarga_horaria());
                stmt.setString(3, ((Disciplina) entidade).getEmenta());
                stmt.setInt(4, ((Disciplina) entidade).getCurso().getId());
                stmt.setInt(5, ((Disciplina) entidade).getProfessor().getId());

                stmt.execute();
                return true;
            } catch (SQLException ex) {
                System.out.println("Não foi possível salvar os dados no banco de dados.\nErro: " + ex.getMessage());
            } finally {
                ConnectionFactory.closeConnection(conn, stmt);
            }
        }
        return false;
    }

    @Override
    public boolean alterar(EntidadeDominio entidade) {
        this.conn = ConnectionFactory.getConnection();
        String sql = "UPDATE disciplinas SET nome=?, carga_horaria=?, ementa=?, id_curso=?, id_professor=? WHERE id_disciplina=?";

        PreparedStatement stmt = null;
        
        if(entidade instanceof Disciplina){
            try {
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, ((Disciplina) entidade).getNome());
                stmt.setInt(2, ((Disciplina) entidade).getCarga_horaria());
                stmt.setString(3, ((Disciplina) entidade).getEmenta());
                stmt.setInt(4, ((Disciplina) entidade).getCurso().getId());
                stmt.setInt(5, ((Disciplina) entidade).getProfessor().getId());
                stmt.setInt(6, entidade.getId());

                if(stmt.executeUpdate() == 1){
                    return true;
                }
            } catch (SQLException ex) {
                System.out.println("Não foi possível alterar os dados no banco de dados.\nErro: " + ex.getMessage());
            } finally {
                ConnectionFactory.closeConnection(conn, stmt);
            }
        }
        return false;
    }

    @Override
    public boolean excluir(int id) {
        this.conn = ConnectionFactory.getConnection();
        String sql = "DELETE FROM disciplinas WHERE id_disciplina=?";

        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            if(stmt.executeUpdate() == 1){
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Não foi possível excluir os dados no banco de dados.\nErro: " + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(conn, stmt);
        }
        return false;
    }
    
    @Override
    public List consultar() {
        this.conn = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM disciplinas";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Disciplina> disciplinas = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            Disciplina disciplina = new Disciplina();
            Curso curso = new Curso();
            Professor professor = new Professor();
            while(rs.next()) {
                curso.setId(rs.getInt("id_curso"));
                professor.setId(rs.getInt("id_professor"));
                disciplina.setId(rs.getInt("id_disciplina"));
                disciplina.setNome(rs.getString("nome"));
                disciplina.setCarga_horaria(rs.getInt("carga_horaria"));
                disciplina.setEmenta(rs.getString("ementa"));
                disciplina.setCurso(curso);
                disciplina.setProfessor(professor);
                disciplinas.add(disciplina);
            }
                
            return disciplinas;
        } catch (SQLException ex) {
            System.out.println("Não foi possível consultar os dados no banco de dados.\nErro: " + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }
        return null;
    }
    
    @Override
    public List consultar(int id) {
        this.conn = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM disciplinas WHERE id_disciplina=?";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Disciplina> disciplinas = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            Disciplina disciplina = new Disciplina();
            Curso curso = new Curso();
            Professor professor = new Professor();
            while(rs.next()) {
                curso.setId(rs.getInt("id_curso"));
                professor.setId(rs.getInt("id_professor"));
                disciplina.setId(rs.getInt("id_disciplina"));
                disciplina.setNome(rs.getString("nome"));
                disciplina.setCarga_horaria(rs.getInt("carga_horaria"));
                disciplina.setEmenta(rs.getString("ementa"));
                disciplina.setCurso(curso);
                disciplina.setProfessor(professor);
                disciplinas.add(disciplina);
            }
                
            return disciplinas;
        } catch (SQLException ex) {
            System.out.println("Não foi possível consultar os dados no banco de dados.\nErro: " + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }
        return null;
    }
    
}
