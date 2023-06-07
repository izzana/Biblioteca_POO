/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estudanteTemLivro.dao;

import estudanteTemLivro.model.EstudanteTemLivro;
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
    private Statement stmt;//possui métodos para fazermos manipulações no BD, como SELECT, CREATETABLE
    private PreparedStatement pstmt;//preparado para substituir interrogações por valores
            
    private void conectar() throws ClassNotFoundException, SQLException {
        Class.forName("org.hsqldb.jdbc.JDBCDriver"); //registrando no projeto onde está a o driver de conexão com o sqldb 
        this.conn = DriverManager.getConnection("jdbc:hsqldb:file:./database/db_biblioteca");
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
    
    public void salvar(EstudanteTemLivro estudanteTemLivro) throws ClassNotFoundException, SQLException {
        System.out.println("opa");
        this.conectar();

        String query = "INSERT INTO estudante_tem_livro" //criando query que vai inserir os dados
                + "(id_usuario, id_livro, data_emprestimo, data_devolucao)"
                + "VALUES (?, ?, ?, ?)"
                ;
        this.criarPreparedStatement(query);
        this.pstmt.setInt(1, estudanteTemLivro.getIdUsuario());//1 -> primeira interrogação para substituir
        this.pstmt.setInt(2, estudanteTemLivro.getIdLivro());
        this.pstmt.setDate(3, estudanteTemLivro.getDataEmprestimo());
        this.pstmt.setDate(4, estudanteTemLivro.getDataDevolucao());
        this.pstmt.executeUpdate();//não passamos a query como parâmetro, por isso usamos como execute
    }
    
    public void atualizar(EstudanteTemLivro estudanteTemLivro) throws SQLException, ClassNotFoundException {
        this.conectar();
        String query = "UPDATE estudante_tem_livro" 
                + "SET data_devolucao=?"
                + "WHERE id =?";
        this.criarPreparedStatement(query);
        this.pstmt.setDate(1, estudanteTemLivro.getDataDevolucao());
        this.pstmt.setInt(2, estudanteTemLivro.getId());//1 -> primeira interrogação para substituir
        this.pstmt.executeUpdate();
//        this.pstmt.execute();//não passamos a query como parâmetro, por isso usamos como execute
        System.out.println("Livro devolvido com sucesso");
    }
}
