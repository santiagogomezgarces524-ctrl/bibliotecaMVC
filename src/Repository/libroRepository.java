/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Moldel.Libro;
import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
/**
 *
 * @author santi
 */
public class libroRepository implements iLibroRepository{
    private final Connection conn;

    public libroRepository(Connection conn) {
        this.conn = conn;
    }
    private Libro mapResultSetTolibro(ResultSet rs)
       throws SQLException {
        Libro libro = new Libro(rs.getInt("idlibro"),rs.getString("nombre"),rs.getString("autor"), rs.getString("estado"), rs.getInt("year"));
        return libro;
    }
    
    @Override
    public void guardar(Libro libro) {
            String sql = "INSERT INTO libro (nombre, autor, year, estado) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, libro.getNombre());
            ps.setString(2, libro.getAutor());
            ps.setInt(3, libro.getYear());
            ps.setString(4, libro.getEstado());
            

            ps.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException("Error al registrar libro", ex);
        }
    }

    @Override
    public void actualizar(Libro libro) {
      String sql="UPDATE libro SET estado=? WHERE idlibro=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)){
                ps.setString(1, libro.getEstado());
                ps.setInt(2, libro.getIdLibro());
                ps.executeUpdate();
        }catch (SQLException ex) {
                    throw new RuntimeException("Error deleting a library", ex);
            }
    }

    @Override
    public void eliminar(int idlibro) {
          String sql = "DELETE FROM libro WHERE idlibro = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idlibro);
            ps.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException("Error al eliminar libro", ex);
        }
    }

    @Override
    public Libro buscarId(int idlibro) {
            String sql = "SELECT * FROM libro WHERE idlibro = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idlibro);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return mapResultSetTolibro(rs);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Error al buscar un libro", ex);
        }

        return null;

    }

    @Override
    public List<Libro> todos() {
            List<Libro> listlibros = new ArrayList<>();
            String sql = "SELECT * FROM libro";

        try (PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                listlibros.add(mapResultSetTolibro(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error al listar todos los libros", e);
        }

        return listlibros;
    }

    @Override
    public List<Libro> estadoLibro(String estado) {
        List<Libro> listlibros = new ArrayList<>();

        String sql = "SELECT * FROM libro WHERE estado = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, estado);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                listlibros.add(mapResultSetTolibro(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error searching for books by status", e);
        }

        return listlibros;    
    }

    @Override
    public boolean exist(int idlibro) {
        String sql = "SELECT COUNT(*) FROM libro WHERE idlibro = ?";
    try (PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, idlibro);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) return rs.getInt(1) > 0;
    } catch (SQLException ex) {
        throw new RuntimeException("Error al verificar existencia del libro", ex);
    }
        return false;
    }
    
}
