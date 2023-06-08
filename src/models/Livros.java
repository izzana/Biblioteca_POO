/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;


/**
 *
 * @author angel
 */
public class Livros {
    private int id, anoPublicacao;
    private String titulo, autor, editora, tipoLivro, local;
    private boolean impresso;

        public Livros(String titulo, String autor, int anoPublicacao,  
            String editora, String tipoLivro, boolean impresso, String local) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.editora = editora;
        this.tipoLivro = tipoLivro;
        this.impresso = impresso;
        this.local = local;
    }
    
    public Livros(int id, String titulo, String autor, int anoPublicacao,  
            String editora, String tipoLivro, boolean impresso, String local) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.editora = editora;
        this.tipoLivro = tipoLivro;
        this.impresso = impresso;
        this.local = local;
    }

    public String getTipoLivro() {
        return tipoLivro;
    }

    public void setTipoLivro(String tipoLivro) {
        this.tipoLivro = tipoLivro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
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
