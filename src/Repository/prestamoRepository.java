/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Moldel.Prestamo;
import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class prestamoRepository implements iPrestamoRepository{
    private final Connection conn;

    public prestamoRepository(Connection conn) {
        this.conn = conn;
    }
    private Prestamo mapResultSetToPrestamo(ResultSet rs) 
            throws SQLException {

        Prestamo prestamo = new Prestamo(rs.getInt("idprestamo"),rs.getString("cedula"),rs.getInt("idLibro"),
                        rs.getString("fechaPrestamo"),rs.getString("FechaDevolucion"),rs.getString("estado"));
        

        return prestamo;
    }
    
    @Override
    public void guardar(Prestamo prestamo) {
            String sql = "INSERT INTO prestamo (cedula, idlibro, fechaprestamo, fechadevolucion, estado) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, prestamo.getCedulaUsuario());
            ps.setInt(2, prestamo.getIdlibro());
            ps.setString(3, prestamo.getFechaPrestamo());
            ps.setString(4, prestamo.getFechaDevolucion());
            ps.setString(5, prestamo.getEstado());

            ps.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException("Error registrar prestamo", ex);
        }
    }

    @Override
    public void actualizar(Prestamo prestamo) {
        String sql = "UPDATE prestamo SET cedula = ?, idlibro = ?, fechaprestamo = ?, fechaDevolucion =?, estado = ? WHERE idprestamo = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, prestamo.getCedulaUsuario());
            ps.setInt(2, prestamo.getIdlibro());
            ps.setString(3, prestamo.getFechaPrestamo());
            ps.setString(4, prestamo.getFechaDevolucion());
            ps.setString(5, prestamo.getEstado());
            ps.setInt(6, prestamo.getIdPrestamo());

            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Error al cargar prestamo", ex);
        }
    }

    @Override
    public void eliminar(int idprestamo) {
            String sql = "DELETE FROM prestamo WHERE idprestamo = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idprestamo);
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Error al borrar prestamo", ex);
        }
    }

    @Override
    public Prestamo buscarporid(int idprestamo) {
            String sql = "SELECT * FROM prestamo WHERE idprestamo = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idprestamo);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return mapResultSetToPrestamo(rs);
            }

        } catch (SQLException ex) {
            throw new RuntimeException("Error al buscar el prestamo", ex);
        }

        return null;
    }

    @Override
    public List<Prestamo> buscarTodo() {
         List<Prestamo> listprestamos = new ArrayList<>();

        String sql = "SELECT * FROM prestamo";

        try (PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                listprestamos.add(mapResultSetToPrestamo(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error listing all loans", e);
        }

        return listprestamos;
    }

    @Override
    public List<Prestamo> buscarporEstado(String estado) {
        List<Prestamo> listprestamos= new ArrayList<>();
        String sql = "SELECT * FROM prestamo WHERE estado = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, estado);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                listprestamos.add(mapResultSetToPrestamo(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error searching for loans by state", e);
        }

        return listprestamos;
    }

    @Override
    public List<Prestamo> buscarporIdUsuario(String cedula) {
        List<Prestamo> listPrestamos= new ArrayList<>();
        String sql="SELECT * FROM prestamo WHERE idUsuario = ?";
            try(PreparedStatement ps = conn.prepareStatement(sql)){
                 ps.setString(1, cedula);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                listPrestamos.add(mapResultSetToPrestamo(rs));
            }
            } catch (SQLException ex) {
                    throw new RuntimeException("Error searching for user loans", ex);
            }
            return listPrestamos;
    }

    @Override
    public List<Prestamo> buscarporidLibro(int idlibro) {
            List<Prestamo> listPrestamos= new ArrayList<>();
        String sql="SELECT * FROM prestamo WHERE idlibro = ?";
            try(PreparedStatement ps = conn.prepareStatement(sql)){
                 ps.setInt(1, idlibro);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                listPrestamos.add(mapResultSetToPrestamo(rs));
            }
            } catch (SQLException ex) {
                    throw new RuntimeException("Error searching for user loans", ex);
            }
            return listPrestamos;

    }

    @Override
    public List<Prestamo> prestamosactivos() {
        return buscarporEstado("prestado");
    }

    @Override
    public boolean prestamosPendienteusuario(String cedula) {
          String sql = "SELECT COUNT(*) FROM prestamo WHERE cedula = ? AND estado = 'prestado'";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, cedula);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Error verifying active loans", ex);
        }

        return false;
    }

    @Override
    public Prestamo poridLibro(int idLibro) {
             String sql = "SELECT * FROM prestamo WHERE idlibro = ? AND estado = 'prestado'";
    try (PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, idLibro);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) return mapResultSetToPrestamo(rs);
    } catch (SQLException ex) {
        throw new RuntimeException("Error al buscar prestamo por libro", ex);
    }
    return null;

    }

   
}

