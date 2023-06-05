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
    //representando o banco de dados
    public static List<Usuario> listaContatos = new ArrayList();
    private Connection conn;
    private Statement stmt;//possui métodos para fazermos manipulações no BD, como SELECT, CREATETABLE
    private PreparedStatement pstmt;//preparado para substituir interrogações por valores
            
    private void conectar() throws ClassNotFoundException, SQLException {
        Class.forName("org.hsqldb.jdbc.JDBCDriver"); //registrando no projeto onde está a o driver de conexão com o sqldb 
        this.conn = DriverManager.getConnection("jdbc:hsqldb:file:./database/dbagenda");
    }
    
    private void criarStatement() throws SQLException {//criar instância da classe statement
        this.stmt = this.conn.createStatement(); 
    }
    
     private void criarPreparedStatement(String query) throws SQLException {//criar instância da classe statement
        this.pstmt = this.conn.prepareStatement(query); 
    }
    
    private void desconecar() throws SQLException {
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
    
    private Usuario buscaContato(int id) { //é privado pois só será usado nessa classe //transformar pra ir pra o bd
        for(Usuario contato: UsuarioDAO.listaContatos) {
            if(contato.getId() == id) {
                return contato;
            }
        }
        return null;
    }
    
    public void salvar(Usuario usuario) throws ClassNotFoundException, SQLException {
        this.conectar();
        String query = "INSERT INTO contatos" //criando query que vai inserir os dados
                + "(nome, cpf, email, telefone, login, senha)"
                + "VALUES (?, ?, ?, ?, ?)"
                ;
        this.criarPreparedStatement(query);
        this.pstmt.setString(1, usuario.getNome());//1 -> primeira interrogação para substituir
        this.pstmt.setString(2, usuario.getCpf());
        this.pstmt.setString(3, usuario.getEmail());
        this.pstmt.setString(4, usuario.getTelefone());
        this.pstmt.setString(5, usuario.getLogin());
        this.pstmt.setString(6, usuario.getSenha());
        this.pstmt.execute();//não passamos a query como parâmetro, por isso usamos como execute
    }
    
    public void atualizar(Usuario contato) throws SQLException, ClassNotFoundException {
        this.conectar();
        String query = "UPDATE usuario" //criando query que vai inserir os dados
                + "set nome=?, cpf=?, email=?, telefone=?, login=?, senha=? "
                + "where id =?";
        this.criarPreparedStatement(query);
        this.pstmt.setString(1, contato.getNome());//1 -> primeira interrogação para substituir
        this.pstmt.setString(2, contato.getCpf());
        this.pstmt.setString(3, contato.getEmail());
        this.pstmt.setString(4, contato.getTelefone());
        this.pstmt.setString(5, contato.getLogin());
        this.pstmt.setString(6, contato.getSenha());
        this.pstmt.setInt(7, contato.getId());
        this.pstmt.execute();//não passamos a query como parâmetro, por isso usamos como execute
    }
    
    public void remover(int id) throws ClassNotFoundException, SQLException {
        this.conectar();
        String query = "DELETE usuario" //criando query que vai remover os dados
                + "WHERE id =?";
        this.criarPreparedStatement(query);
        this.pstmt.setInt(1, id);
        this.pstmt.execute();//não passamos a query como parâmetro, por isso usamos como execute
    }
    
    public List<Usuario> obterTodosContatos() throws ClassNotFoundException, SQLException {
        this.conectar();
        this.criarStatement();
        List<Usuario> usuarios = new ArrayList();
        String query = "SELECT * FROM usuario;";
        ResultSet rs = this.stmt.executeQuery(query);
        while(rs.next()) {
            int id = rs.getInt("id");
            String cpf = rs.getString("cpf");
            String nome = rs.getString("nome");
            String email = rs.getString("email");
            String telefone = rs.getString("telefone");
            String login = rs.getString("login");
            String senha = rs.getString("senha");
            Usuario usuario = new Usuario(id, cpf, nome, email, telefone, login, senha);
            usuarios.add(usuario);
        }
        return null;
    }
}
