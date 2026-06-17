/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;


import Moldel.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UsuarioRepository  implements iusuarioRepository{
    private final Connection conn;

    public UsuarioRepository(Connection conn) {
        this.conn = conn;
    }
    private Usuario mapResultset(ResultSet rs)
    throws SQLException {
            Usuario usuario = new Usuario(
                    rs.getString("contraseña"),
                    rs.getString("cedula"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("email"), 
                    rs.getString("telefono"));
        return usuario;
    } 
    @Override
    public void guardar(Usuario usuario) {
            String sql = "INSERT INTO usuario (cedula, nombre, apellido, telefono, email, contraseña) VALUES (?, ?, ?, ?, ?, ?)";
                try(PreparedStatement ps = conn.prepareStatement(sql)){
                    ps.setString(1, usuario.getCedula());
                    ps.setString(2, usuario.getNombre());
                    ps.setString(3, usuario.getApellido());
                    ps.setString(4, usuario.getTelefono());
                    ps.setString(5, usuario.getEmail());
                    ps.setString(6, usuario.getContraseña());
                    ps.executeUpdate();
                } catch (SQLException ex) {
                         throw new RuntimeException("Error al guardar usuario con exito", ex);
                }
    }

    @Override
    public void actualizar(Usuario usuario) {
    }

    @Override
    public void eliminar(String cedula) {
        String sql = "DELETE FROM usuario WHERE cedula = ?";
            try(PreparedStatement ps = conn.prepareStatement(sql)){
                ps.setString(1, cedula);
                ps.executeUpdate();
            } catch (SQLException ex) {
                    throw new RuntimeException("Error al eliminar usuario", ex);
            }
    }

    @Override
    public Usuario buscarporCedula(String cedula) {
             String sql = "SELECT * FROM usuario WHERE cedula = ?";
            try(PreparedStatement ps = conn.prepareStatement(sql)){
                   ps.setString(1, cedula);
                   ResultSet rs=ps.executeQuery();
                   if(rs.next()){
                   return mapResultset(rs);
                   }
                   
            }catch(SQLException ex){
                throw new RuntimeException("Error al buscar ususario", ex);
            }
         return null;
    }

    @Override
    public Usuario  buscarporEmail(String email) {
         return null;
    }

    @Override
    public List<Usuario> todos() {
        List <Usuario> listusuarios= new ArrayList<>();
        String sql = "SELECT * FROM usuario";
            try(PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                        listusuarios.add(mapResultset(rs));
                }
            } catch (SQLException ex) {
                    throw new RuntimeException("Error al listar todos los usuario", ex);
            }
         return listusuarios;
    }

    @Override
    public boolean porCedula(String cedula) {
            String sql = "SELECT COUNT(*) FROM usuario WHERE cedula = ?";
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
    public boolean porEmail(String email) {
            String sql = "SELECT COUNT(*) FROM usuario WHERE email = ?";
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
