/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Moldel.*;
import Repository.*;
import View.Login;
import View.Registrar;
import View.libros.DevolverLibro;
import View.libros.EliminarLibro;
import View.libros.PrestamoLibro;
import View.libros.Resgistarlibro;
import java.util.List;
import javax.swing.JOptionPane;
public class AdministradorController extends BibliotecarioController {
    
    private final AdiministradorRepository administradorRepo;

    public AdministradorController(AdiministradorRepository administradorRepo, BibliotecarioRepository bibliotecarioRepo, InformeRepository informeRepo, libroRepository libroRepo, prestamoRepository prestamoRepo, UsuarioRepository usuarioRepo) {
        super(bibliotecarioRepo, informeRepo, libroRepo, prestamoRepo, usuarioRepo);
        this.administradorRepo = administradorRepo;
    }

    
    

    

   

    


     public void registrarBibliotecario(String cedula, String nombre, String apellido,
                                       String email, String telefono, String contrasena) {

        if (bibliotecarioRepo.existenciaPorCedula(cedula)) {
            JOptionPane.showMessageDialog(null, "Ya existe un bibliotecario con esa cédula.");
            return;
        }
        if (bibliotecarioRepo.existenciaPorEmail(email)) {
            JOptionPane.showMessageDialog(null, "Ya existe un bibliotecario con ese correo.");
            return;
        }

        Bibliotecario bibliotecario = new Bibliotecario(contrasena, cedula, nombre, apellido, email, telefono);
        bibliotecarioRepo.guardar(bibliotecario);
        JOptionPane.showMessageDialog(null, "Bibliotecario registrado correctamente.");
    }
     
    public void eliminarBibliotecario(String cedula) {

        if (cedula == null || cedula.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "La cédula no puede estar vacía.");
            return;
        }

        Bibliotecario bibliotecario = bibliotecarioRepo.buscarPorcedula(cedula);
        if (bibliotecario == null) {
            JOptionPane.showMessageDialog(null, "No se encontró un bibliotecario con esa cédula.");
            return;
        }

        bibliotecarioRepo.eliminar(cedula);
        JOptionPane.showMessageDialog(null, "Bibliotecario eliminado correctamente.");
    }
    
    public List<Prestamo> verTodosPrestamos() {
        return prestamoRepo.buscarTodo();
    }
    
    public List<Usuario> verTodosUsuarios() {
        return usuarioRepo.todos();
    }
    
    public List<Bibliotecario> verTodosBibliotecarios() {
        return bibliotecarioRepo.todos();
    }
    
    public List<Libro> verTodosLibros() {
        return libroRepo.todos();
    }
    
    public List<Informe> verTodosInformes() {
        return informeRepo.buscarTodos();
    }
    @Override
    public boolean login(String email, String contrasena) {
    try {
        Administrador admin = administradorRepo.buscarporEmail(email);
        if (admin == null) return false;
        return admin.getContraseña().equals(contrasena);
         
    } catch (Exception ex) {
        throw new RuntimeException("Error al verificar credenciales de administrador", ex);
        }
       
    }

}
