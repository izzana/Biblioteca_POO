/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package livro.model;


/**
 *
 * @author angel
 */
public class Livros {
    private int id, anoPublicao;
    private String titulo, autor, editora, local;
    private boolean impresso;

        public Livros(String titulo, String autor, int anoPublicacao,  
            String editora, boolean impresso, String local) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicao = anoPublicacao;
        this.editora = editora;
        this.impresso = impresso;
        this.local = local;
    }
    
    public Livros(int id, String titulo, String autor, int anoPublicacao,  
            String editora, boolean impresso, String local) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicao = anoPublicacao;
        this.editora = editora;
        this.impresso = impresso;
        this.local = local;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAnoPublicacao() {
        return anoPublicao;
    }

    public void setAnoPublicacao(int anoPublicao) {
        this.anoPublicao = anoPublicao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public boolean isImpresso() {
        return impresso;
    }

    public void setImpresso(boolean impresso) {
        this.impresso = impresso;
    }
}
