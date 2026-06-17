/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Moldel;

/**
 *
 * @author santi
 */
public class Usuario  extends Persona{
    protected String contraseña;

    public Usuario(String contraseña, String cedula, String nombre, String Apellido, String email, String telefono) {
        super(cedula, nombre, Apellido, email, telefono);
        this.contraseña = contraseña;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

       
    
}
