/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author izzana
 */
public class DatabaseUtilUsuarioTemLivro {
    private Connection conn;
    private Statement stmt;//possui métodos para fazermos manipulações no BD, como SELECT, CREATETABLE
    
    public void createUsuarioTemLivroTable() {
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver"); //registrando no projeto onde está a o driver de conexão com o sqldb 
            this.conn = DriverManager.getConnection("jdbc:hsqldb:file:./database/db_biblioteca");
            this.stmt = this.conn.createStatement(); 
            this.stmt.executeUpdate("CREATE TABLE usuario_tem_livro (id IDENTITY PRIMARY KEY,"+ //executeUpdate -> executa comandos no BD
                                    "id_livro INTEGER," +
                                    "id_usuario INTEGER," +
                                    "data_emprestimo DATE,"  + 
                                    "data_devolucao DATE" +
                                    "FOREIGN KEY(id_livro) REFERENCES livros(id)," +
                                    "FOREIGN KEY(id_usuario) REFERENCES usuario(id));");
            this.stmt.close();
            this.conn.close();
            System.out.println("Tabela usuario tem livro criada com sucesso!");
        } catch (ClassNotFoundException ex) {
            System.out.println("Classe não encontrada");
            Logger.getLogger(biblioteca.utils.DatabaseUtilUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(biblioteca.utils.DatabaseUtilUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String args[]) {
        DatabaseUtilUsuarioTemLivro util = new DatabaseUtilUsuarioTemLivro();
        util.createUsuarioTemLivroTable();
    }
}
