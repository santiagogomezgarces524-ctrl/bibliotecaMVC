/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Moldel.Bibliotecario;
import java.util.List;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.Connection;


public class BibliotecarioRepository implements ibibliotecariorepository {
    
     private final Connection conn;

    public BibliotecarioRepository(Connection conn) {
        this.conn= conn;
    }
    
    private Bibliotecario mapResultset(ResultSet rs)
    throws SQLException {
            Bibliotecario bibliotecario = new Bibliotecario(
                    rs.getString("contraseña"),
                    rs.getString("cedula"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("email"), 
                    rs.getString("telefono") );
        
        return bibliotecario;
    } 
    
    
    
    
    
    
     

    @Override
    public void guardar(Bibliotecario bibliotecario) {
        String sql = "INSERT INTO bibliotecario (cedula, nombre, apellido, telefono , email, contraseña) VALUES (?, ?, ?, ?, ?, ?)";
                try(PreparedStatement ps = conn.prepareStatement(sql)){
                    ps.setString(1, bibliotecario.getCedula());
                    ps.setString(2, bibliotecario.getNombre());
                    ps.setString(3, bibliotecario.getApellido());
                    ps.setString(4, bibliotecario.getTelefono());
                    ps.setString(5, bibliotecario.getEmail());
                    ps.setString(6, bibliotecario.getContraseña());
                    ps.executeUpdate();
                } catch (SQLException ex) {
                         throw new RuntimeException("Error al guardar bibliotecario con exito", ex);
                }
    }
    

    @Override
    public void actualizar(Bibliotecario bibliotecario) {
        
    }

    @Override
    public void eliminar(String cedula) {
        String sql = "DELETE FROM bibliotecario WHERE cedula = ?";
            try(PreparedStatement ps = conn.prepareStatement(sql)){
                ps.setString(1, cedula);
                ps.executeUpdate();
            } catch (SQLException ex) {
                    throw new RuntimeException("Error deleting a library", ex);
            }
        
    }

    @Override
    public Bibliotecario buscarPorcedula(String cedula) {
        String sql = "SELECT * FROM bibliotecario WHERE cedula = ?";
            try(PreparedStatement ps = conn.prepareStatement(sql)){
                   ps.setString(1, cedula);
                   ResultSet rs=ps.executeQuery();
                   if(rs.next()){
                   return mapResultset(rs);
                   }
                   
            }catch(SQLException ex){
                throw new RuntimeException("Error al buscar bibliotecario", ex);
            }
         return null;
        
        
    }

    @Override
    public Bibliotecario buscarEmail(String email) {
         String sql = "SELECT * FROM bibliotecario WHERE email = ?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                 ps.setString(1, email);
                ResultSet rs = ps.executeQuery();
                 if (rs.next()) return mapResultset(rs);
            } catch (SQLException e) {
        throw new RuntimeException("Error al buscar bibliotecario por email", e);
    }
    return null;
         
    }

    @Override
    public List<Bibliotecario> todos() {
        List < Bibliotecario> listbibliotecarios= new ArrayList<>();
        String sql = "SELECT * FROM bibliotecario";
            try(PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                        listbibliotecarios.add(mapResultset(rs));
                }
            } catch (SQLException ex) {
                    throw new RuntimeException("Error al listar todos los bibliotecarios", ex);
            }
         return listbibliotecarios;
    }

    @Override
    public boolean existenciaPorCedula(String cedula) {
        String sql = "SELECT COUNT(*) FROM bibliotecario WHERE cedula = ?";
            try(PreparedStatement ps = conn.prepareStatement(sql)){
                ps.setString(1, cedula);
                 ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                return rs.getInt(1) > 0;
            }
            } catch (SQLException ex) {
                throw new RuntimeException("Error al buscar si la identificacion existe", ex);
        }
         return false;
    }

    @Override
    public boolean existenciaPorEmail(String email) {
         String sql = "SELECT COUNT(*) FROM bibliotecario WHERE email = ?";
         try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1,email);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0;
            }

        } catch (SQLException ex) {
            throw new RuntimeException("Error al revisar el correo", ex);
        }

        return false;
    }
   
    
}
