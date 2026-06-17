/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository;

import Moldel.Libro;
import java.util.List;
public interface iLibroRepository {
    void guardar(Libro libro);
    void actualizar(Libro libro);
    void eliminar(int idLibro);
    Libro buscarId(int idLibro);
    List<Libro> todos();
    List<Libro> estadoLibro(String estado);
    boolean exist(int idLibro);
}
