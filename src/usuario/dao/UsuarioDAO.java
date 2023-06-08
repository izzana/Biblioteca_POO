/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuario.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.usuario.Usuario;

/**
 *
 * @author izzana
 */
public class UsuarioDAO {
    public static List<Usuario> listaContatos = new ArrayList();
    private Connection conn;
    private Statement stmt;
    private PreparedStatement pstmt;
            
    private void conectar() throws ClassNotFoundException, SQLException {
        Class.forName("org.hsqldb.jdbc.JDBCDriver"); 
        this.conn = DriverManager.getConnection("jdbc:hsqldb:file:./database/db_biblioteca");
    }
    
    private void criarStatement() throws SQLException {
        this.stmt = this.conn.createStatement(); 
    }
    
     private void criarPreparedStatement(String query) throws SQLException {
        this.pstmt = this.conn.prepareStatement(query); 
    }
    
    private void desconectar() throws SQLException {
         if(this.pstmt != null) {
            this.pstmt.close();
        }
        if(this.stmt != null) {
            this.stmt.close();
        }
        if(this.conn != null) {
            this.conn.close();
        }
    }
    
    public void salvar(Usuario usuario) throws ClassNotFoundException, SQLException {

        this.conectar();
        String query = "INSERT INTO usuario" 
                + "(nome, cpf, email, telefone, login, senha)"
                + "VALUES (?, ?, ?, ?, ?, ?)"
                ;
        this.criarPreparedStatement(query);
        this.pstmt.setString(1, usuario.getNome());
        this.pstmt.setString(2, usuario.getCpf());
        this.pstmt.setString(3, usuario.getEmail());
        this.pstmt.setString(4, usuario.getTelefone());
        this.pstmt.setString(5, usuario.getLogin());
        this.pstmt.setString(6, usuario.getSenha());
        this.pstmt.executeUpdate();
        this.desconectar();
        System.out.println("Usuário salvo com sucesso");

    }
    
    public void atualizar(Usuario usuario) throws SQLException, ClassNotFoundException {
        this.conectar();
        String query = "UPDATE usuario " 
                + "SET nome=?, cpf=?, email=?, telefone=?, login=?, senha=? "
                + "WHERE id =?";
        this.criarPreparedStatement(query);
        this.pstmt.setString(1, usuario.getNome());
        this.pstmt.setString(2, usuario.getCpf());
        this.pstmt.setString(3, usuario.getEmail());
        this.pstmt.setString(4, usuario.getTelefone());
        this.pstmt.setString(5, usuario.getLogin());
        this.pstmt.setString(6, usuario.getSenha());
        this.pstmt.setInt(7, usuario.getId());
        this.pstmt.execute();
        this.desconectar();
        System.out.println("Usuário atualizado com sucesso");
    }
    
    public void remover(int id) throws ClassNotFoundException, SQLException {
        this.conectar();
        System.out.println("conectou");
        String query = "DELETE FROM usuario "
                + "WHERE id=?";
        this.criarPreparedStatement(query);
        this.pstmt.setInt(1, id);
        this.pstmt.executeUpdate();
        this.desconectar();
        this.desconectar();
        System.out.println("Usuário removido com o sucesso");
    }
    
    public List<Usuario> obterTodosUsuarios() throws ClassNotFoundException, SQLException {
        this.conectar();
        this.criarStatement();
        List<Usuario> usuarios = new ArrayList();
        String query = "SELECT * FROM usuario;";
        ResultSet rs = this.stmt.executeQuery(query);
        while(rs.next()) {
            int id = rs.getInt("id");
            String nome = rs.getString("nome");
            String cpf = rs.getString("cpf");
            String email = rs.getString("email");
            String telefone = rs.getString("telefone");
            String login = rs.getString("login");
            String senha = rs.getString("senha");
            Usuario usuario = new Usuario(id, nome, cpf, email, telefone, login, senha);
            usuarios.add(usuario);
        }
        this.desconectar();
        return usuarios;
    }
    
    public Usuario obterUsuarioPorId(int idUsuario) throws ClassNotFoundException, SQLException {
        this.conectar();
        this.criarStatement();
        
        String query = "SELECT * FROM usuario "
                + "WHERE id=?";
        this.criarPreparedStatement(query);
        this.pstmt.setInt(1, idUsuario);
        ResultSet rs = this.pstmt.executeQuery();
        
        Usuario usuario = null;
        if (rs.next()) {
            int usuarioId = rs.getInt("id");
            String nome = rs.getString("nome");
            String cpf = rs.getString("cpf");
            String email = rs.getString("email");
            String telefone = rs.getString("telefone");
            String login = rs.getString("login");
            String senha = rs.getString("senha");

            usuario = new Usuario(usuarioId, nome, cpf, email, telefone, login, senha);
        }
        this.desconectar();
        return usuario;
    }
}
