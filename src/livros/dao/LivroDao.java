
package livros.dao;

import livros.model.Livros;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

/**
 *
 * @author angelo
 */

public class LivroDao {
    public static List <Livros> listaLivros = new ArrayList<>();
    private Connection conn;
    private Statement stmt;
    private PreparedStatement pstmt;
    
    
    private void conectar() throws ClassNotFoundException, SQLException{
        Class.forName("org.hsqldb.jdbc.JDBCDriver");
        this.conn = DriverManager.getConnection("jdbc:hsqldb:file:./database/db_biblioteca");
    }
    
    
    private void criarStatement() throws SQLException{
        this.stmt = this.conn.createStatement();
    }
    
    private void criarPrepareStatement(String query) throws SQLException{
        this.pstmt = this.conn.prepareStatement(query);
    }
    
    private void desconectar() throws SQLException{
        if(this.pstmt != null)
            this.pstmt.close();
        if(this.stmt != null)
            this.stmt.close();
        if(this.conn != null)
            this.conn.close();
    }

    public void atualizarLivro(Livros livro) throws ClassNotFoundException, SQLException{
        this.conectar();
        String query = "UPDATE livros "
                + "set titulo=?, autor=?, ano_publicacao=?, editora=?, "
                + "impresso=?, localizacao=?"
                + "WHERE id = ?";
        this.criarPrepareStatement(query);
        this.pstmt.setString(1, livro.getTitulo());
        this.pstmt.setString(2, livro.getAutor());
        this.pstmt.setInt(3, livro.getAnoPublicacao());
        this.pstmt.setString(4, livro.getEditora());
        this.pstmt.setBoolean(5, livro.isImpresso());
        this.pstmt.setString(6, livro.getLocal());
        this.pstmt.setInt(7, livro.getId());
        this.pstmt.execute();
        this.desconectar();
    }
    
    public void salvar(Livros livro) throws ClassNotFoundException, SQLException{
        this.conectar();
        String query = "INSERT INTO livros"
                + "(titulo, autor, ano_publicacao, editora, tipo_livro, impresso, localizacao)"
                +"VALUES(?,?,?,?,?,?,?)";
        this.criarPrepareStatement(query);
        this.pstmt.setString(1, livro.getTitulo());
        this.pstmt.setString(2, livro.getAutor());
        this.pstmt.setInt(3, livro.getAnoPublicacao());
        this.pstmt.setString(4, livro.getEditora());
        this.pstmt.setString(5, livro.getTipoLivro());
        this.pstmt.setBoolean(6, livro.isImpresso());
        this.pstmt.setString(7, livro.getLocal());
        this.pstmt.execute();
        this.desconectar();
        System.out.println("salvou");
        
    }
    
    public List<Livros> buscaLivrosAutor(String autorRecebido) throws ClassNotFoundException, SQLException{
        this.conectar();
        this.criarStatement();
        String query = "SELECT * FROM livros "
                + "WHERE autor like ?";
        this.criarPrepareStatement(query);
        this.pstmt.setString(1, '%' + autorRecebido +'%');
        ResultSet result = this.pstmt.executeQuery();
        
        List<Livros> livros = new ArrayList();
        
        while(result.next()){
            int id = result.getInt("id");
            String titulo = result.getString("titulo");
            String autor = result.getString("autor");
            int anoPublicacao = result.getInt("ano_publicacao");
            String editora = result.getString("editora");
            String tipoLivro = result.getString("tipo_livro");
            boolean impresso = result.getBoolean("impresso");
            String localizacao = result.getString("localizacao");
            Livros livro = new Livros(id, titulo, autor, anoPublicacao, editora, tipoLivro, impresso, localizacao);
            livros.add(livro);
        }
        this.desconectar();
        return livros;
    }
    
    public List<Livros> obterLivroPeloNome(String nomeLivro) throws ClassNotFoundException, SQLException {
        this.conectar();
        this.criarStatement();
        
        String query = "SELECT * FROM livros "
                + "WHERE titulo like ?";
        this.criarPrepareStatement(query);
        this.pstmt.setString(1, '%' + nomeLivro + '%');
        ResultSet rs = this.pstmt.executeQuery();
        
        List <Livros> livros = new ArrayList();
        
        while(rs.next()) {
            int livroId = rs.getInt("id");
            String titulo = rs.getString("titulo");
            String autor = rs.getString("autor");
            int anoPublicacao = rs.getInt("ano_publicacao");
            String editora = rs.getString("editora");
            String tipoLivro = rs.getString("tipo_livro");
            boolean impresso = rs.getBoolean("impresso");
            String localizacao = rs.getString("localizacao");

            Livros livro = new Livros(livroId, titulo, autor, anoPublicacao, editora, tipoLivro, impresso, localizacao);
            livros.add(livro);
        }
        this.desconectar();
        return livros;
    }

    public void remover(int id) throws ClassNotFoundException, SQLException {
        this.conectar();
        System.out.println("conectou");
        String query = "DELETE FROM livros " //criando query que vai remover os dados
                + "WHERE id=?";
        this.criarPrepareStatement(query);
        this.pstmt.setInt(1, id);
        this.pstmt.executeUpdate();//não passamos a query como parâmetro, por isso usamos como execute
        System.out.println("Livro removido com o sucesso");
        this.desconectar();
    }    
    
}
