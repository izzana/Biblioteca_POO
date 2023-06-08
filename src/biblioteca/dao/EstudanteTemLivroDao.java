/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca.dao;

import models.EstudanteTemLivro;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author izzana
 */
public class EstudanteTemLivroDao {
    public static List<EstudanteTemLivro> listaContatos = new ArrayList();
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
    
    public void salvar(EstudanteTemLivro estudanteTemLivro) throws ClassNotFoundException, SQLException {
        System.out.println("opa");
        this.conectar();

        String query = "INSERT INTO estudante_tem_livro"
                + "(id_usuario, id_livro, data_emprestimo, data_devolucao)"
                + "VALUES (?, ?, ?, ?)"
                ;
        this.criarPreparedStatement(query);
        this.pstmt.setInt(1, estudanteTemLivro.getIdUsuario());
        this.pstmt.setInt(2, estudanteTemLivro.getIdLivro());
        this.pstmt.setDate(3, estudanteTemLivro.getDataEmprestimo());
        this.pstmt.setDate(4, estudanteTemLivro.getDataDevolucao());
        this.pstmt.executeUpdate();
    }
    
    public void atualizar(EstudanteTemLivro estudanteTemLivro) throws SQLException, ClassNotFoundException {
        this.conectar();
        String query = "UPDATE estudante_tem_livro" 
                + "SET data_devolucao=?"
                + "WHERE id =?";
        this.criarPreparedStatement(query);
        this.pstmt.setDate(1, estudanteTemLivro.getDataDevolucao());
        this.pstmt.setInt(2, estudanteTemLivro.getId());
        this.pstmt.executeUpdate();
        System.out.println("Livro devolvido com sucesso");
    }
}
