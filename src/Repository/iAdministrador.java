/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository;

import Moldel.Administrador;
import java.util.List;
public interface iAdministrador {
    void guardar(Administrador administrador);
    void eliminar(String cedula);
    Administrador buscarporEmail(String email);
    Administrador BuscarporCedula(String cedula);
    List<Administrador> todos();
    
}
