/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository;
import Moldel.Prestamo;
import java.util.List;
/**
 *
 * @author santi
 */
public interface iPrestamoRepository {
    void guardar(Prestamo prestamo);
    void actualizar(Prestamo prestamo);
    void eliminar(int idPrestamo);
    Prestamo buscarporid(int idPrestamo);
    Prestamo poridLibro(int idLibro);
    List<Prestamo> buscarTodo();
    List<Prestamo> buscarporEstado(String estado);
    List<Prestamo> buscarporIdUsuario(String cedula);
    List<Prestamo> buscarporidLibro(int idlibro);
    List<Prestamo> prestamosactivos();
    boolean prestamosPendienteusuario(String cedula);
    
    
    
}
