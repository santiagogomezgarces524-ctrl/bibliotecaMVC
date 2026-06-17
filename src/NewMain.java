
import Controller.AdministradorController;
import Controller.BibliotecarioController;
import configured.Config;
import View.*;
import Repository.*;
import Controller.*;
import View.libros.DevolverLibro;
import View.libros.EliminarLibro;
import View.libros.PrestamoLibro;
import View.libros.Resgistarlibro;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


public class NewMain {

    private static Object View;

    
    public static void main(String[] args) {
        configured.Config cg= new Config();
        
        Repository.UsuarioRepository       usuarioRepo        = new Repository.UsuarioRepository(cg.conn);
        Repository.BibliotecarioRepository bibliotecarioRepo  = new Repository.BibliotecarioRepository(cg.conn);
        Repository.libroRepository         libroRepo          = new Repository.libroRepository(cg.conn);
        Repository.prestamoRepository      prestamoRepo       = new Repository.prestamoRepository(cg.conn);
        Repository.InformeRepository       informeRepo        = new Repository.InformeRepository(cg.conn);
        Repository.AdiministradorRepository administradorRepo  = new Repository.AdiministradorRepository(cg.conn);
        
        BibliotecarioController bibliotecarioController = new BibliotecarioController(
        bibliotecarioRepo,informeRepo, libroRepo, prestamoRepo, usuarioRepo
    );
    AdministradorController administradorController = new AdministradorController(
        administradorRepo, bibliotecarioRepo, informeRepo, libroRepo, prestamoRepo, usuarioRepo
    );
    
            //Registrar    registrar = new Registrar(bibliotecarioController);
           // eliminar       elim      = new eliminar(bibliotecarioController);
            //Resgistarlibro RLibro    = new Resgistarlibro(bibliotecarioController);
            //EliminarLibro  ELibro    = new EliminarLibro(bibliotecarioController);
           // PrestamoLibro  Plibro    = new PrestamoLibro(bibliotecarioController);
           // DevolverLibro  Dlibro    = new DevolverLibro(bibliotecarioController);
            
         // bibliotecarioController.setRegistrar(registrar);
        //bibliotecarioController.setEliminar(elim);
        //bibliotecarioController.setRLibro(RLibro);
        //bibliotecarioController.setELibro(ELibro);
        //bibliotecarioController.setPlibro(Plibro);
        //bibliotecarioController.setDlibro(Dlibro);

         java.awt.EventQueue.invokeLater(() -> {
            new View.Login(bibliotecarioController, administradorController).setVisible(true);
        });
    }
    
}
