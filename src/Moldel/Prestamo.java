/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Moldel;

/**
 *
 * @author santi
 */
public class Prestamo {
       protected int idPrestamo;
       protected String cedulaUsuario;
       protected int idlibro;
       protected String fechaPrestamo;
       protected String FechaDevolucion;
       protected String estado;

    public Prestamo(int idPrestamo, String cedulaUsuario, int idlibro, String fechaPrestamo, String FechaDevolucion, String estado) {
        this.idPrestamo = idPrestamo;
        this.cedulaUsuario = cedulaUsuario;
        this.idlibro = idlibro;
        this.fechaPrestamo = fechaPrestamo;
        this.FechaDevolucion = FechaDevolucion;
        this.estado = estado;
    }

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public String getCedulaUsuario() {
        return cedulaUsuario;
    }

    public void setCedulaUsuario(String cedulaUsuario) {
        this.cedulaUsuario = cedulaUsuario;
    }

    public int getIdlibro() {
        return idlibro;
    }

    public void setIdlibro(int idlibro) {
        this.idlibro = idlibro;
    }

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public String getFechaDevolucion() {
        return FechaDevolucion;
    }

    public void setFechaDevolucion(String FechaDevolucion) {
        this.FechaDevolucion = FechaDevolucion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

   
       
}
