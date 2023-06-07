/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuario.controler;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.usuario.Usuario;
import usuario.dao.UsuarioDAO;

/**
 *
 * @author izzana
 */
public class UsuarioController {
    private UsuarioDAO dao = new UsuarioDAO();
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        UsuarioDAO dao2 = new UsuarioDAO();
        Usuario usuario1 = new Usuario("asdfas","ajlads","jakdsçfl","ajflidsf", "qwer", "5678");
        Usuario usuario2 = new Usuario("wert","pmnb","ftvw","zwvnm", "uop8", "8976");
        dao2.salvar(usuario1);
        dao2.salvar(usuario2);
//        dao2.remover(1);
//        dao2.obterTodosUsuarios();
//        int id = usuario2.getId();
//        Usuario usuarioObtido = dao2.obterUsuario(id);
//        if (usuarioObtido != null) {
//            System.out.println("Usuário obtido: ");
//            System.out.println("ID: " + usuarioObtido.getId());
//            System.out.println("Nome: " + usuarioObtido.getNome());
//            System.out.println("Email: " + usuarioObtido.getEmail());
//        } else {
//            System.out.println("Usuário não encontrado.");
//        }
        List<Usuario> usuarios = dao2.obterTodosUsuarios();

//        for (Usuario usuario : usuarios) {
//            System.out.println("ID: " + usuario.getId());
//            System.out.println("CPF: " + usuario.getCpf());
//            System.out.println("Nome: " + usuario.getNome());
//            System.out.println("Email: " + usuario.getEmail());
//            System.out.println("Telefone: " + usuario.getTelefone());
//            System.out.println("Login: " + usuario.getLogin());
//            System.out.println("Senha: " + usuario.getSenha());
//            System.out.println();
//        }
        
//        System.out.println(dao2.obterUsuario(id));
//        System.out.println("ID: " + usuario3.getId());
//        System.out.println("CPF: " + usuario3.getCpf());
//        System.out.println("Nome: " + usuario3.getNome());
//        System.out.println("Email: " + usuario3.getEmail());
//        System.out.println("Telefone: " + usuario3.getTelefone());
//        System.out.println("Login: " + usuario3.getLogin());
//        System.out.println("Senha: " + usuario3.getSenha());
//        System.out.println();
        
        usuario2.setCpf("lsdalflsdaf");
        dao2.atualizar(usuario2);
        System.out.println("atualizado");
                int id = usuario2.getId();
        Usuario usuarioObtido = dao2.obterUsuario(id);
        if (usuarioObtido != null) {
            System.out.println("Usuário obtido: ");
            System.out.println("ID: " + usuarioObtido.getId());
            System.out.println("Nome: " + usuarioObtido.getNome());
            System.out.println("Email: " + usuarioObtido.getEmail());
            System.out.println("CPF: " + usuarioObtido.getCpf());
        } else {
            System.out.println("Usuário não encontrado.");
        }
//        for (Usuario usuario : usuarios) {
//            System.out.println("ID: " + usuario.getId());
//            System.out.println("CPF: " + usuario.getCpf());
//            System.out.println("Nome: " + usuario.getNome());
//            System.out.println("Email: " + usuario.getEmail());
//            System.out.println("Telefone: " + usuario.getTelefone());
//            System.out.println("Login: " + usuario.getLogin());
//            System.out.println("Senha: " + usuario.getSenha());
//            System.out.println();
//        }
        
    }
    
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
    
   public List<Usuario> obterTodosUsuarios() {
        return UsuarioDAO.listaContatos;
    }
}
