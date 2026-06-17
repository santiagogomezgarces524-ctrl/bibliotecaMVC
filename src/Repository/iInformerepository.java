/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository;

import Moldel.Informe;
import java.util.List;

/**
 *
 * @author santi
 */
public interface iInformerepository {
        void guardar(Informe informe);
        void actualizar(Informe informe);
        void eliminar(int id);
        Informe buscarporId (int id);
        List<Informe> buscarTodos();
}
