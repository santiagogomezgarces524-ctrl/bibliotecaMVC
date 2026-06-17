/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Moldel;

/**
 *
 * @author santi
 */
public class Libro {
        private int idLibro;
        private String nombre;
        private String autor;
        private String estado;
        private int year;

    public Libro(int idLibro, String nombre, String autor, String estado, int year) {
        this.idLibro = idLibro;
        this.nombre = nombre;
        this.autor = autor;
        this.estado = estado;
        this.year = year;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
        
}
