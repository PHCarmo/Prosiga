package com.mycompany.prossiga.model.dao;


import br.com.fatecmc.prosiga.model.domain.EntidadeDominio;
import br.com.fatecmc.prosiga.model.domain.Professor;
import com.mycompany.prossiga.model.connection.ConnectionFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDAO implements IDAO {
    private Connection conn;

    @Override
    public boolean salvar(EntidadeDominio entidade) {
        this.conn = ConnectionFactory.getConnection();
        String sql = "INSERT INTO professores(nome, titulacao) VALUES(?, ?)";

        PreparedStatement stmt = null;
        
        if(entidade instanceof Professor){
            try {
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, ((Professor) entidade).getNome());
                stmt.setString(2, ((Professor) entidade).getTitulacao());

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
        String sql = "UPDATE professores SET nome=?, titulacao=? WHERE id_professor=?";

        PreparedStatement stmt = null;
        
        if(entidade instanceof Professor){
            try {
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, ((Professor) entidade).getNome());
                stmt.setString(2, ((Professor) entidade).getTitulacao());
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

    @Override
    public boolean excluir(int id) {
        this.conn = ConnectionFactory.getConnection();
        String sql = "DELETE FROM professores WHERE id_professor=?";

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
        String sql = "SELECT * FROM professores";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Professor> professores = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            Professor professor = new Professor();
            while(rs.next()) {
                professor.setId(rs.getInt("id_professor"));
                professor.setNome(rs.getString("nome"));
                professor.setTitulacao(rs.getString("titulacao"));
                professores.add(professor);
            }
                
            return professores;
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
        String sql = "SELECT * FROM professores WHERE id_professor=?";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Professor> professores = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            Professor professor = new Professor();
            while(rs.next()) {
                professor.setId(rs.getInt("id_professor"));
                professor.setNome(rs.getString("nome"));
                professor.setTitulacao(rs.getString("titulacao"));
                professores.add(professor);
            }
                
            return professores;
        } catch (SQLException ex) {
            System.out.println("Não foi possível consultar os dados no banco de dados.\nErro: " + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }
        return null;
    }
    
}
