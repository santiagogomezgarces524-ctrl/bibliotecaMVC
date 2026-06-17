/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository;

import Moldel.Bibliotecario;
import java.util.List;


public interface ibibliotecariorepository {
        void guardar(Bibliotecario bibliotecario);
        
        void actualizar(Bibliotecario bibliotecario);
        
        void eliminar(String cedula);
        
        Bibliotecario buscarPorcedula (String cedula);
        
        Bibliotecario buscarEmail(String email);
        
        List<Bibliotecario> todos();
        
        boolean existenciaPorCedula(String cedula);
        boolean existenciaPorEmail(String email);
        
}
