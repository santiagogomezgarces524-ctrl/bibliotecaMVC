
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Moldel;

/**
 *
 * @author santi
 */
public class Informe {
    private int idInforme;
    private String fechaDelInfo;
    private int totalDePrestamos;
    private int TotalDevuletos;
    private int TotalEnMora;

    public Informe(int idInforme, String fechaDelInfo, int totalDePrestamos, int TotalDevuletos, int TotalEnMora) {
        this.idInforme = idInforme;
        this.fechaDelInfo = fechaDelInfo;
        this.totalDePrestamos = totalDePrestamos;
        this.TotalDevuletos = TotalDevuletos;
        this.TotalEnMora = TotalEnMora;
    }

    public int getIdInforme() {
        return idInforme;
    }

    public void setIdInforme(int idInforme) {
        this.idInforme = idInforme;
    }

    public String getFechaDelInfo() {
        return fechaDelInfo;
    }

    public void setFechaDelInfo(String fechaDelInfo) {
        this.fechaDelInfo = fechaDelInfo;
    }

    public int getTotalDePrestamos() {
        return totalDePrestamos;
    }

    public void setTotalDePrestamos(int totalDePrestamos) {
        this.totalDePrestamos = totalDePrestamos;
    }

    public int getTotalDevuletos() {
        return TotalDevuletos;
    }

    public void setTotalDevuletos(int TotalDevuletos) {
        this.TotalDevuletos = TotalDevuletos;
    }

    public int getTotalEnMora() {
        return TotalEnMora;
    }

    public void setTotalEnMora(int TotalEnMora) {
        this.TotalEnMora = TotalEnMora;
    }

    
}
