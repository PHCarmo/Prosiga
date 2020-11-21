package br.com.fatecmc.prossiga.model.dao;


import br.com.fatecmc.prossiga.model.domain.Aluno;
import br.com.fatecmc.prossiga.model.domain.EntidadeDominio;
import br.com.fatecmc.prossiga.model.domain.Turma;
import br.com.fatecmc.prossiga.model.connection.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO implements IDAO {
    private Connection conn;

    @Override
    public boolean salvar(EntidadeDominio entidade) {
        this.conn = ConnectionFactory.getConnection();
        String sql = "INSERT INTO alunos(nome, ra, id_turma) VALUES(?, ?, ?)";

        PreparedStatement stmt = null;
        
        if(entidade instanceof Aluno){
            try {
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, ((Aluno) entidade).getNome());
                stmt.setString(2, ((Aluno) entidade).getRa());
                stmt.setInt(3, ((Aluno) entidade).getTurma().getId());

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
        String sql = "UPDATE alunos SET nome=?, ra=?, id_turma=? WHERE id_aluno=?";

        PreparedStatement stmt = null;
        
        if(entidade instanceof Aluno){
            try {
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, ((Aluno) entidade).getNome());
                stmt.setString(2, ((Aluno) entidade).getRa());
                stmt.setInt(3, ((Aluno) entidade).getTurma().getId());
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
        String sql = "DELETE FROM alunos WHERE id_aluno=?";

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
    
    public List consultar() {
        this.conn = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM alunos";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Aluno> alunos = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            Aluno aluno = new Aluno();
            Turma turma = new Turma();
            while(rs.next()) {
                turma.setId(rs.getInt("id_turma"));
                aluno.setId(rs.getInt("id_aluno"));
                aluno.setNome(rs.getString("nome"));
                aluno.setRa(rs.getString("ra"));
                aluno.setTurma(turma);
                alunos.add(aluno);
            }
                
            return alunos;
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
        String sql = "SELECT * FROM alunos WHERE id_aluno=?";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Aluno> alunos = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            
            rs = stmt.executeQuery();
            
            Aluno aluno = new Aluno();
            Turma turma = new Turma();
            while(rs.next()) {
                turma.setId(rs.getInt("id_turma"));
                aluno.setId(rs.getInt("id_aluno"));
                aluno.setNome(rs.getString("nome"));
                aluno.setRa(rs.getString("ra"));
                aluno.setTurma(turma);
                alunos.add(aluno);
            }
                
            return alunos;
        } catch (SQLException ex) {
            System.out.println("Não foi possível consultar os dados no banco de dados.\nErro: " + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }
        return null;
    }
    
}
