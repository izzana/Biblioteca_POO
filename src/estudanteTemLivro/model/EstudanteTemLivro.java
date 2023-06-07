/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estudanteTemLivro.model;
import java.sql.Date;
/**
 *
 * @author izzana
 */

public class EstudanteTemLivro {
    private int id, idLivro, idUsuario;
    private Date dataEmprestimo, dataDevolucao;

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public EstudanteTemLivro(int idLivro, int idUsuario) {
        this. idLivro = idLivro;
        this.idUsuario = idUsuario;
    }

    public EstudanteTemLivro(int id, int idLivro, int idUsuario) {
        this.id = id;
        this. idLivro = idLivro;
        this.idUsuario = idUsuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    
}
