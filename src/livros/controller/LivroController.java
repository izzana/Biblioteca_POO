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
 * @author angelo
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
} //funcionando
    
    public void salvar(Livros livro){
        try {
            dao.salvar(livro);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LivroController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LivroController.class.getName()).log(Level.SEVERE, null, ex);
        }
    } //funcionando
    
    public void atualizar(Livros livro){
        try {
            dao.atualizarLivro(livro);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LivroController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LivroController.class.getName()).log(Level.SEVERE, null, ex);
        }
    } //funcionando
    
    public void obterLivrosPeloNome(String nomeLivro){
        LivroDao livrosDao = new LivroDao();

        try {
            List<Livros> livrosEncontrados = livrosDao.obterLivroPeloNome(nomeLivro);
            
            if (!livrosEncontrados.isEmpty()) {
                System.out.println("Livros encontrados com o titulo:" + nomeLivro);
                for(Livros livro : livrosEncontrados){
                    System.out.println("Id: " + livro.getId());
                    System.out.println("Título: " + livro.getTitulo());
                    System.out.println("Autor: " + livro.getAutor());
                    System.out.println("Editora " + livro.getEditora());
                    System.out.println("Tipo Livro: " + livro.getTipoLivro());
                    System.out.println("Impresso: " + livro.isImpresso());
                    System.out.println("Local: " + livro.getLocal());                    
                }

            } else {
                System.out.println("Nenhum");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LivroController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LivroController.class.getName()).log(Level.SEVERE, null, ex);
        }

    } //funcionando
    
    public void remover(int id) {
        try {
            dao.remover(id);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LivroController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LivroController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    //funcionando
    

   
}
