/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Moldel.Administrador;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;


public class AdiministradorRepository  implements iAdministrador{
       private Connection conn = null; 

    public AdiministradorRepository(Connection conn) {
        this.conn = conn;
    }

   
       
    private Administrador mapResultSetToAdministracion(ResultSet rs)throws SQLException {
        Administrador administrador= new Administrador(rs.getString("contraseña"),rs.getString("cedula"),rs.getString("nombre"),
                                                        rs.getString("apellido"),rs.getString("email"),rs.getString("telefono"));
        return administrador;
    } 
    @Override
    public void guardar(Administrador administrador) {
         
         
    }

    @Override
    public void eliminar(String cedula) {
    }

    @Override
    public Administrador BuscarporCedula(String cedula) {
         return null;
    }

    @Override
    public List<Administrador> todos() {
        return null;
    }

    @Override
    public Administrador buscarporEmail(String email) {
            String sql = "SELECT * FROM administrador WHERE email = ?";
    try (PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) return mapResultSetToAdministracion(rs);
    } catch (SQLException ex) {
        throw new RuntimeException("Error al buscar administrador por email", ex);
    }
    return null;
    }
    
}
