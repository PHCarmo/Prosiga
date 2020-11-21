package br.com.fatecmc.prossiga.model.dao;


import br.com.fatecmc.prossiga.model.domain.Curso;
import br.com.fatecmc.prossiga.model.domain.EntidadeDominio;
import br.com.fatecmc.prossiga.model.connection.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO implements IDAO {
    private Connection conn;

    @Override
    public boolean salvar(EntidadeDominio entidade) {
        this.conn = ConnectionFactory.getConnection();
        String sql = "INSERT INTO cursos(nome, turno, descricao) VALUES(?, ?, ?)";

        PreparedStatement stmt = null;
        
        if(entidade instanceof Curso){
            try {
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, ((Curso) entidade).getNome());
                stmt.setString(2, ((Curso) entidade).getTurno());
                stmt.setString(3, ((Curso) entidade).getDescricao());

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
        String sql = "UPDATE cursos SET nome=?, turno=?, descricao=? WHERE id_curso=?";

        PreparedStatement stmt = null;
        
        if(entidade instanceof Curso){
            try {
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, ((Curso) entidade).getNome());
                stmt.setString(2, ((Curso) entidade).getTurno());
                stmt.setString(3, ((Curso) entidade).getDescricao());
                stmt.setInt(4, entidade.getId());

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
        String sql = "DELETE FROM cursos WHERE id_curso=?";

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
        String sql = "SELECT * FROM cursos";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Curso> cursos = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            Curso curso = new Curso();
            while(rs.next()) {
                curso.setId(rs.getInt("id_curso"));
                curso.setNome(rs.getString("nome"));
                curso.setTurno(rs.getString("turno"));
                curso.setDescricao(rs.getString("descricao"));
                cursos.add(curso);
            }
                
            return cursos;
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
        String sql = "SELECT * FROM cursos WHERE id_curso=?";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Curso> cursos = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            
            rs = stmt.executeQuery();
            
            Curso curso = new Curso();
            while(rs.next()) {
                curso.setId(rs.getInt("id_curso"));
                curso.setNome(rs.getString("nome"));
                curso.setTurno(rs.getString("turno"));
                curso.setDescricao(rs.getString("descricao"));
                cursos.add(curso);
            }
                
            return cursos;
        } catch (SQLException ex) {
            System.out.println("Não foi possível consultar os dados no banco de dados.\nErro: " + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }
        return null;
    }
    
}
