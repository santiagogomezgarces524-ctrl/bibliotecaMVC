/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import View.libros.PrestamoLibro;
import View.libros.DevolverLibro;
import Repository.*;
import Moldel.*;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JOptionPane;

public class UsuarioController {
    protected libroRepository libroRepo;
    protected prestamoRepository prestamoRepo;
    protected UsuarioRepository usuarioRepo;
    protected PrestamoLibro Plibro;
    protected DevolverLibro Dlibro;

    public UsuarioController(libroRepository libroRepo, prestamoRepository prestamoRepo, UsuarioRepository usuarioRepo) {
        this.libroRepo = libroRepo;
        this.prestamoRepo = prestamoRepo;
        this.usuarioRepo = usuarioRepo;
    }

    
    
    
     public List<Libro> disponibilidad(){
        return libroRepo.estadoLibro("disponible");
    }
     
    public void solicitarPrestamo(String cedula, int idLibro, int diasPlazo) {

        
        Usuario usuario = usuarioRepo.buscarporCedula(cedula);
        if (usuario == null) {
            throw new IllegalArgumentException("No se encontró el usuario con esa cédula.");
        }

       
        if (prestamoRepo.prestamosPendienteusuario(usuario.getCedula())) {
            throw new IllegalStateException("El usuario tiene préstamos activos pendientes de devolución.");
        }

       
        if (!libroRepo.exist(idLibro)) {
            throw new IllegalArgumentException("No existe un libro con ese ID.");
        }

        Libro libro = libroRepo.buscarId(idLibro);
        if (!"disponible".equalsIgnoreCase(libro.getEstado())) {
            throw new IllegalStateException("El libro no está disponible en este momento.");
        }

        
        String fechaPrestamo    = LocalDate.now().toString();
        String fechaDevolucion  = LocalDate.now().plusDays(diasPlazo).toString();

        Prestamo prestamo = new Prestamo(0,cedula,idLibro,fechaPrestamo,fechaDevolucion,"prestado");
        prestamo.setCedulaUsuario(usuario.getCedula());
        prestamo.setIdlibro(idLibro);
        prestamo.setFechaPrestamo(fechaPrestamo);
        prestamo.setFechaDevolucion(fechaDevolucion);
        prestamo.setEstado("prestado");
        prestamoRepo.guardar(prestamo);
        
        libro.setEstado("prestado");
        libroRepo.actualizar(libro);
        JOptionPane.showMessageDialog(null, "prestamo hecho con exito");
    
    
    }
    
    public void devolverLibro(int idLibro) {

     Prestamo prestamo = prestamoRepo.poridLibro(idLibro);
        if (prestamo == null) {
                 throw new IllegalArgumentException("No hay un préstamo activo para ese libro.");
                }
        if ("devuelto".equalsIgnoreCase(prestamo.getEstado())) {
        throw new IllegalStateException("Este préstamo ya fue devuelto anteriormente.");
            }
   prestamo.setEstado("devuelto");
   prestamoRepo.actualizar(prestamo);

    Libro libro = libroRepo.buscarId(idLibro);
    if (libro != null) {
        libro.setEstado("disponible");
        libroRepo.actualizar(libro);
        JOptionPane.showMessageDialog(null, "devolucion del libro correcta");
                    }
    
    }
    
    public void setPlibro(PrestamoLibro Plibro) {
            this.Plibro = Plibro;
    }
    public void setDlibro(DevolverLibro Dlibro) {
            this.Dlibro = Dlibro;
    }
    
}
