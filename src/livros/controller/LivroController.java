/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package livros.controller;

import java.sql.SQLException;
import livros.dao.LivroDao;
import livros.model.Livros;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author angel
 */
public class LivroController {
    private LivroDao dao = new LivroDao();
    public void buscaLivrosAutor(String autor){
        try {
            dao.buscaLivrosAutor(autor);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LivroController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LivroController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void salvar(Livros livro){
        try {
            dao.salvar(livro);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LivroController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LivroController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void atualizar(Livros livro){
        try {
            dao.atualizarLivro(livro);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LivroController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LivroController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List<Livros> obterTodososLivros(){
        return LivroDao.listaLivros;
    }
    
        public static void main(String args[]) {
            LivroController livroController = new LivroController();
            Livros livro = new Livros("titulo", "autor", 1995, "editora", "terror", true, "comoda" );
            livroController.salvar(livro);
            livroController.buscaLivrosAutor("autor");
    }       
}
