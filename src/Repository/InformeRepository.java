/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Moldel.Informe;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;


public class InformeRepository implements iInformerepository{
    
    private final Connection conn;

    public InformeRepository(Connection conn) {
        this.conn = conn;
    }
    
    private Informe mapResultsetToInfo(ResultSet rs)
    throws SQLException {
            Informe informe = new Informe(
                    rs.getInt("idInforme"),
                    rs.getString("fechaDelInfo"),
                    rs.getInt("totalPrestamos"),
                    rs.getInt("totalDevueltos"),
                    rs.getInt("totalEnMora" ));
            
            
        return informe;
    } 

    @Override
    public void guardar(Informe informe) {
        String sql = "INSERT INTO informe (fechaDelInfo, totaldeprestamos, totalDevueltos, totalEnMora) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, informe.getFechaDelInfo());
            ps.setInt(2, informe.getTotalDePrestamos());
            ps.setInt(3, informe.getTotalDevuletos());
            ps.setInt(4, informe.getTotalEnMora());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error saving report", e);
        }
    }

    @Override
    public void actualizar(Informe informe) {
        
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM informe WHERE id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Error deleting report", ex);
        }
    }

    @Override
    public Informe buscarporId(int id) {
            String sql = "SELECT * FROM Report WHERE idReport = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return mapResultsetToInfo(rs);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Error searching for a report", ex);
        }

        return null;
    }

    @Override
    public List<Informe> buscarTodos() {
            List<Informe> listInforme = new ArrayList<>();

        String sql = "SELECT * FROM informe";

        try (PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                listInforme.add(mapResultsetToInfo(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error listing all reports", e);
        }

        return listInforme;
    }
        
        
}
