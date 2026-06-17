/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import View.Registrar;
import View.eliminar;
import View.libros.Resgistarlibro;
import View.libros.EliminarLibro;
import View.Login;
import Moldel.*;
import Repository.*;
import Moldel.Persona;
import View.libros.DevolverLibro;
import View.libros.PrestamoLibro;
import java.util.List;
import javax.swing.JOptionPane;

public class BibliotecarioController extends UsuarioController{
     protected BibliotecarioRepository bibliotecarioRepo;
     protected InformeRepository informeRepo;
   //estos solo tiene setters
     protected Registrar registrar;
    protected eliminar eliminar;
    protected Login entrar;
    protected Resgistarlibro RLibro;
    protected EliminarLibro ELibro;

    public BibliotecarioController(BibliotecarioRepository bibliotecarioRepo, InformeRepository informeRepo, libroRepository libroRepo, prestamoRepository prestamoRepo, UsuarioRepository usuarioRepo) {
        super(libroRepo, prestamoRepo, usuarioRepo);
        this.bibliotecarioRepo = bibliotecarioRepo;
        this.informeRepo = informeRepo;
    }

   
   
     
     
   
     
     public void ResgistrarPersona(String cedula, String nombre,String apellido,String email,String telefono){
         if (cedula.trim().isEmpty() || nombre.trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Cédula y nombre son obligatorios.");
        return;
    }
    if (usuarioRepo.porCedula(cedula)) {
        JOptionPane.showMessageDialog(null, "Ya existe un usuario con esa cédula.");
        return;
    }
    if (usuarioRepo.porEmail(email)) {
        JOptionPane.showMessageDialog(null, "Ya existe un usuario con ese correo.");
        return;
    }

    Usuario usuario = new Usuario(null, cedula, nombre, apellido, email, telefono);
    usuarioRepo.guardar(usuario);
    JOptionPane.showMessageDialog(null, "Usuario registrado correctamente.");
         
     }
     
     public void eliminarPersona(String cedula){
         if (cedula == null || cedula.trim().isEmpty()){
            JOptionPane.showMessageDialog(null,"no se puede dejar el campo");
            return;
        }
        Usuario usuario = usuarioRepo.buscarporCedula(cedula);
        if (usuario == null){
           JOptionPane.showMessageDialog(null, "no se puede, usuario existente");
           return;
        }
        if (prestamoRepo.prestamosPendienteusuario(usuario.getCedula())){
            JOptionPane.showMessageDialog(null, "no se puede, usuario debe libros");
            return;
        }
        
        usuarioRepo.eliminar(cedula);
     
     }
     
     
     public void RegistarLibro(String nombre, String autor, String estado, int year){
       Libro libro= new Libro(0,nombre,autor,estado,year);
       libroRepo.guardar(libro);
     
     }
     
     
     public void eliminarLibro(int idLibro){
     
         if (!libroRepo.exist(idLibro )){
            JOptionPane.showMessageDialog(null,"no existe este libro");
            return;
         }
         Prestamo prestamoActivo = prestamoRepo.poridLibro(idLibro);
        if (prestamoActivo != null) {
                JOptionPane.showMessageDialog(null, "No se puede eliminar: el libro está actualmente prestado.");
        return;
    }
         Libro libro= libroRepo.buscarId(idLibro);
         libroRepo.eliminar(idLibro);
     
     
     }
     
      public void generarInforme() {
          String fecha = java.time.LocalDate.now().toString();
           int[] totales= obtenerTotales();
           Informe informe = new Informe(0, fecha, totales[0], totales[2], totales[3]);
                informeRepo.guardar(informe);
       }
      
    public boolean login(String email, String contrasena) {
      try {
        Bibliotecario biblio = bibliotecarioRepo.buscarEmail(email);
        if (biblio == null) return false;
        return biblio.getContraseña().equals(contrasena);
    } catch (Exception ex) {
        throw new RuntimeException("Error al verificar credenciales de bibliotecario", ex);
            } 
    
    }
    
    public int[] obtenerTotales() {
       List<Prestamo> todos  = prestamoRepo.buscarTodo();
        int totalPrestamos    = todos.size();
        int totalActivos      = (int) todos.stream().filter(p -> "prestado".equalsIgnoreCase(p.getEstado())).count();
        int totalDevueltos    = (int) todos.stream().filter(p -> "devuelto".equalsIgnoreCase(p.getEstado())).count();
        int totalEnMora       = (int) todos.stream().filter(p -> "en_mora".equalsIgnoreCase(p.getEstado())).count();
            return new int[]{totalPrestamos, totalActivos, totalDevueltos, totalEnMora};
    }
    
            public List<Usuario> listarUsuarios() {
                    return usuarioRepo.todos();
            }

            public List<Libro> listarLibros() {
                    return libroRepo.todos();
            }
    
        public void setRegistrar(Registrar registrar) {
            this.registrar = registrar;
        }
        public void setEliminar(eliminar eliminar) {
            this.eliminar = eliminar;
        }
        public void setLogin(Login entrar) {
            this.entrar = entrar;
        }
        public void setRLibro(Resgistarlibro RLibro) {
            this.RLibro = RLibro;
        }
        public void setELibro(EliminarLibro ELibro) {
            this.ELibro = ELibro;
        }
}