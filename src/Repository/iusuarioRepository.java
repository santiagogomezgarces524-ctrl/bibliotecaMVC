/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository;

import Moldel.Usuario;
import java.util.List;
public interface iusuarioRepository {
    void guardar(Usuario usuario);

    void actualizar(Usuario usuario);

    void eliminar(String cedula);

    Usuario buscarporCedula(String cedula);

    Usuario buscarporEmail(String email);

    List<Usuario> todos();

    boolean porCedula(String cedula);

    boolean porEmail(String email);
}
