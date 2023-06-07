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
    
    public void buscarLivrosPorAutor(String autor) {
    LivroDao livroDAO = new LivroDao();
    try {
        List<Livros> livrosEncontrados = livroDAO.buscaLivrosAutor(autor);
        if (!livrosEncontrados.isEmpty()) {
            for (Livros livro : livrosEncontrados) {
                System.out.println("Livro encontrado:");
                System.out.println("Id: " + livro.getId());
                System.out.println("Título: " + livro.getTitulo());
                System.out.println("Autor: " + livro.getAutor());
                System.out.println("Editora " + livro.getEditora());
                System.out.println("Tipo Livro: " + livro.getTipoLivro());
                System.out.println("Impresso: " + livro.isImpresso());
                System.out.println("Local: " + livro.getLocal());
            }
        } else {
            System.out.println("Nenhum livro encontrado para o autor: " + autor);
        }
    } catch (ClassNotFoundException | SQLException e) {
        System.out.println("Ocorreu um erro ao buscar os livros por autor: " + e.getMessage());
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
    
        public static void main(String args[]) throws ClassNotFoundException, SQLException {
            LivroController livroController = new LivroController();
            Livros livro = new Livros("titulo", "autor", 1995, "editora", "terror", true, "comoda" );
            Livros livro2 = new Livros("titulo2", "autor2", 19952, "editora2", "terror2", true, "comoda2" );
            Livros livro3 = new Livros("titulo3", "autor", 1995, "editora", "terror", true, "comoda" );
            livroController.salvar(livro);
            livroController.salvar(livro2);
            livroController.salvar(livro3);
            livroController.buscarLivrosPorAutor("autor");
    }       
}
