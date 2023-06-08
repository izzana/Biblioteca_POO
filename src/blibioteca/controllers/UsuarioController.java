/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blibioteca.controllers;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Usuario;
import biblioteca.dao.UsuarioDAO;

/**
 *
 * @author izzana
 */
public class UsuarioController {
    private UsuarioDAO dao = new UsuarioDAO();

    public void salvar(Usuario usuario) {
        try {
            dao.salvar(usuario);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void atualizar(Usuario usuario) {
        try {
            dao.atualizar(usuario);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void remover(int id) {
        try {
            dao.remover(id);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   public void obterUsuarioPorId() {
       
   }
   
   public void obterUsuarioPorId(int usuarioId) {
        UsuarioDAO usuarioDAO1 = new UsuarioDAO();
        try {
            Usuario usuarioTeste = usuarioDAO1.obterUsuarioPorId(usuarioId);
            if (usuarioTeste != null) {
                System.out.println("Usuário encontrado:");
                System.out.println("Id: " + usuarioTeste.getId());
                System.out.println("Nome: " + usuarioTeste.getNome());
                System.out.println("CPF: " + usuarioTeste.getCpf());
                System.out.println("Email " + usuarioTeste.getEmail());
                System.out.println("Telefone: " + usuarioTeste.getTelefone());
                System.out.println("Login: " + usuarioTeste.getLogin());
            } else {
                System.out.println("Nenhum Usuário encontrado para o id: " + usuarioId);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Ocorreu um erro ao buscar os livros por autor: " + e.getMessage());
        }
    }
   
   public void obterTodosUsuarios() {
        UsuarioDAO usuarioDAO = new UsuarioDAO(); // substitua "UsuarioDao" pelo nome da classe que contém o método "obterTodosUsuarios()"
    
        try {
            List<Usuario> usuarios;
            usuarios = usuarioDAO.obterTodosUsuarios();
            if (!usuarios.isEmpty()) {
                System.out.println("Usuários cadastrados na Biblioteca");
                for (Usuario usuario : usuarios) {
                    System.out.println("ID: " + usuario.getId());
                    System.out.println("Nome: " + usuario.getNome());
                    System.out.println("CPF: " + usuario.getCpf());
                    System.out.println("Email: " + usuario.getEmail());
                    System.out.println("Telefone: " + usuario.getTelefone());
                    System.out.println("Login: " + usuario.getLogin());
                    System.out.println("Senha: " + usuario.getSenha());
                    System.out.println("--------------------------------------");
                }
            } else {
                System.out.println("Nenhum usuário encontrado.");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
   
}
