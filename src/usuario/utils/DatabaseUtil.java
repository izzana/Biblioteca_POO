/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuario.utils;

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
public class DatabaseUtil {
    
    private Connection conn;
    private Statement stmt;//possui métodos para fazermos manipulações no BD, como SELECT, CREATETABLE
    
    public void createUsuarioTable() {
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver"); //registrando no projeto onde está a o driver de conexão com o sqldb 
            this.conn = DriverManager.getConnection("jdbc:hsqldb:file:./database/db_biblioteca");
            this.stmt = this.conn.createStatement(); 
            this.stmt.executeUpdate("CREATE TABLE usuario (id IDENTITY PRIMARY KEY,"+ //executeUpdate -> executa comandos no BD
                                    "nome VARCHAR(50)," +
                                    "cpf VARCHAR(11)," +
                                    "email VARCHAR(50)," +
                                    "telefone VARCHAR(14)," +
                                    "login VARCHAR(50)," +
                                    " senha VARCHAR(50));");
            this.stmt.close();
            this.conn.close();
            System.out.println("Tabela usuarios criada com sucesso!");
        } catch (ClassNotFoundException ex) {
            System.out.println("Classe não encontrada");
            Logger.getLogger(DatabaseUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String args[]) {
        DatabaseUtil util = new DatabaseUtil();
        util.createUsuarioTable();
    }
}


