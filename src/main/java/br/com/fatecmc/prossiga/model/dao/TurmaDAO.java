package br.com.fatecmc.prossiga.model.dao;


import br.com.fatecmc.prossiga.model.domain.Curso;
import br.com.fatecmc.prossiga.model.domain.EntidadeDominio;
import br.com.fatecmc.prossiga.model.domain.Turma;
import br.com.fatecmc.prossiga.model.connection.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TurmaDAO implements IDAO {
    private Connection conn;

    @Override
    public boolean salvar(EntidadeDominio entidade) {
        this.conn = ConnectionFactory.getConnection();
        String sql = "INSERT INTO turmas(descricao, id_curso) VALUES(?, ?)";

        PreparedStatement stmt = null;
        
        if(entidade instanceof Turma){
            try {
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, ((Turma) entidade).getDescricao());
                stmt.setInt(2, ((Turma) entidade).getCurso().getId());
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
        String sql = "UPDATE turmas SET descricao=?, id_curso=? WHERE id_turma=?";

        PreparedStatement stmt = null;
        
        if(entidade instanceof Turma){
            try {
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, ((Turma) entidade).getDescricao());
                stmt.setInt(2, ((Turma) entidade).getCurso().getId());
                stmt.setInt(3, entidade.getId());

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
    
    public boolean alterar(EntidadeDominio entidade, int id) {
        this.conn = ConnectionFactory.getConnection();
        String sql = "UPDATE turmas SET descricao=?, id_curso=? WHERE id_turma=?";

        PreparedStatement stmt = null;
        
        if(entidade instanceof Turma){
            try {
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, ((Turma) entidade).getDescricao());
                stmt.setInt(2, ((Turma) entidade).getCurso().getId());
                stmt.setInt(3, id);

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
        String sql = "DELETE FROM turmas WHERE id_turma=?";

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
        String sql = "SELECT * FROM turmas";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Turma> turmas = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            
           
            while(rs.next()) {
            	Turma turma = new Turma();
                Curso curso = new Curso();
                curso.setId(rs.getInt("id_curso"));
                turma.setId(rs.getInt("id_turma"));
                turma.setCurso(curso);
                turma.setDescricao(rs.getString("descricao"));
                turmas.add(turma);
            }
                
            return turmas;
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
        String sql = "SELECT * FROM turmas WHERE id_turma=?";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Turma> turmas = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            Turma turma = new Turma();
            Curso curso = new Curso();
            while(rs.next()) {
                curso.setId(rs.getInt("id_curso"));
                turma.setId(rs.getInt("id_turma"));
                turma.setDescricao(rs.getString("descricao"));
                turmas.add(turma);
            }
                
            return turmas;
        } catch (SQLException ex) {
            System.out.println("Não foi possível consultar os dados no banco de dados.\nErro: " + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }
        return null;
    }
    
}
