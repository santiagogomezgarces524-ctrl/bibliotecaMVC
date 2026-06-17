/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View.Menus;
import View.Registrar;
import View.eliminar;
import Controller.*;
import Moldel.Bibliotecario;
import Moldel.Libro;
import Moldel.Usuario;
import View.Bibliotecario.*;
import View.libros.*;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuAdministrador extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MenuAdministrador.class.getName());

    public AdministradorController administrador;
    public MenuAdministrador( AdministradorController administrador) {
        this.administrador=administrador;
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        btniCerrarSesion = new javax.swing.JMenu();
        MenuiCerrarSesion = new javax.swing.JMenuItem();
        EliminarLibro = new javax.swing.JMenu();
        btniRegistrarLibro = new javax.swing.JMenuItem();
        btniEliminarLibro = new javax.swing.JMenuItem();
        btniConsultarListadoLibro = new javax.swing.JMenuItem();
        btniPrestamo = new javax.swing.JMenuItem();
        btniDevolverLibro = new javax.swing.JMenuItem();
        btnCliente = new javax.swing.JMenu();
        btniRegistrarCliente = new javax.swing.JMenuItem();
        btniEliminarPersona = new javax.swing.JMenuItem();
        btniConsultarListado = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        btniRegistrarBibliotecario = new javax.swing.JMenuItem();
        btniEliminarBibliotecario = new javax.swing.JMenuItem();
        btniConsultarBibliotecario = new javax.swing.JMenuItem();
        btniGenerarInformes = new javax.swing.JMenu();
        btniGenerarInforme = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 204));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenBiblioteca/library (2).png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(jLabel1)
                .addContainerGap(115, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        btniCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenBiblioteca/member.png"))); // NOI18N
        btniCerrarSesion.setText("cuenta");
        btniCerrarSesion.setToolTipText("Cerrar Sesion");
        btniCerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        MenuiCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/door_out.png"))); // NOI18N
        MenuiCerrarSesion.setText("Cerrar Sesion");
        MenuiCerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        MenuiCerrarSesion.addActionListener(this::MenuiCerrarSesionActionPerformed);
        btniCerrarSesion.add(MenuiCerrarSesion);

        jMenuBar1.add(btniCerrarSesion);

        EliminarLibro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenBiblioteca/documentation.png"))); // NOI18N
        EliminarLibro.setText("Libros");
        EliminarLibro.setToolTipText("Click para registra nuevo libro");
        EliminarLibro.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btniRegistrarLibro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/book_add.png"))); // NOI18N
        btniRegistrarLibro.setText("Registrar Libro");
        btniRegistrarLibro.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btniRegistrarLibro.addActionListener(this::btniRegistrarLibroActionPerformed);
        EliminarLibro.add(btniRegistrarLibro);

        btniEliminarLibro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/book_delete.png"))); // NOI18N
        btniEliminarLibro.setText("Eliminar Libro");
        btniEliminarLibro.setToolTipText("");
        btniEliminarLibro.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btniEliminarLibro.addActionListener(this::btniEliminarLibroActionPerformed);
        EliminarLibro.add(btniEliminarLibro);

        btniConsultarListadoLibro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/database_go.png"))); // NOI18N
        btniConsultarListadoLibro.setText("consultar Listado");
        btniConsultarListadoLibro.setToolTipText("");
        btniConsultarListadoLibro.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btniConsultarListadoLibro.addActionListener(this::btniConsultarListadoLibroActionPerformed);
        EliminarLibro.add(btniConsultarListadoLibro);

        btniPrestamo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/book_addresses.png"))); // NOI18N
        btniPrestamo.setText("Prestamo");
        btniPrestamo.setToolTipText("");
        btniPrestamo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btniPrestamo.addActionListener(this::btniPrestamoActionPerformed);
        EliminarLibro.add(btniPrestamo);

        btniDevolverLibro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/book.png"))); // NOI18N
        btniDevolverLibro.setText("Devolver Libro");
        btniDevolverLibro.setToolTipText("");
        btniDevolverLibro.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btniDevolverLibro.addActionListener(this::btniDevolverLibroActionPerformed);
        EliminarLibro.add(btniDevolverLibro);

        jMenuBar1.add(EliminarLibro);

        btnCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenBiblioteca/book (1).png"))); // NOI18N
        btnCliente.setText("Clientes");
        btnCliente.setToolTipText("Nuevo cliente");
        btnCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btniRegistrarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/user_add.png"))); // NOI18N
        btniRegistrarCliente.setText("Registrar Cliente");
        btniRegistrarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btniRegistrarCliente.addActionListener(this::btniRegistrarClienteActionPerformed);
        btnCliente.add(btniRegistrarCliente);

        btniEliminarPersona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/user_delete.png"))); // NOI18N
        btniEliminarPersona.setText("Eliminar Cliente");
        btniEliminarPersona.setToolTipText("");
        btniEliminarPersona.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btniEliminarPersona.addActionListener(this::btniEliminarPersonaActionPerformed);
        btnCliente.add(btniEliminarPersona);

        btniConsultarListado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/database_go.png"))); // NOI18N
        btniConsultarListado.setText("Consultar Listado");
        btniConsultarListado.setToolTipText("");
        btniConsultarListado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btniConsultarListado.addActionListener(this::btniConsultarListadoActionPerformed);
        btnCliente.add(btniConsultarListado);

        jMenuBar1.add(btnCliente);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenBiblioteca/book.png"))); // NOI18N
        jMenu1.setText("Bibliotecarios");
        jMenu1.setToolTipText("Registrar, Eliminar o Consultar listado");
        jMenu1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btniRegistrarBibliotecario.setText("Registrar Bibliotecario");
        btniRegistrarBibliotecario.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btniRegistrarBibliotecario.addActionListener(this::btniRegistrarBibliotecarioActionPerformed);
        jMenu1.add(btniRegistrarBibliotecario);

        btniEliminarBibliotecario.setText("Eliminar Bibliotecario");
        btniEliminarBibliotecario.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btniEliminarBibliotecario.addActionListener(this::btniEliminarBibliotecarioActionPerformed);
        jMenu1.add(btniEliminarBibliotecario);

        btniConsultarBibliotecario.setText("Consultar Listado");
        btniConsultarBibliotecario.addActionListener(this::btniConsultarBibliotecarioActionPerformed);
        jMenu1.add(btniConsultarBibliotecario);

        jMenuBar1.add(jMenu1);

        btniGenerarInformes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenBiblioteca/learning.png"))); // NOI18N
        btniGenerarInformes.setText("informes");
        btniGenerarInformes.setToolTipText("Generar Informes");
        btniGenerarInformes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btniGenerarInforme.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenBiblioteca/ebook.png"))); // NOI18N
        btniGenerarInforme.setText("Generar Informes");
        btniGenerarInforme.addActionListener(this::btniGenerarInformeActionPerformed);
        btniGenerarInformes.add(btniGenerarInforme);

        jMenuBar1.add(btniGenerarInformes);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuiCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuiCerrarSesionActionPerformed
        System.exit(0);
    }//GEN-LAST:event_MenuiCerrarSesionActionPerformed

    private void btniConsultarListadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btniConsultarListadoActionPerformed
         List<Usuario> usuarios = administrador.listarUsuarios();

        String[] columnas = {"Cédula", "Nombre", "Email"};
        javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(columnas, 0);
            for (Usuario u : usuarios) {
                model.addRow(new Object[]{u.getCedula(), u.getNombre(), u.getEmail()});
            }

            JFrame frame = new JFrame("Listado de Usuarios");
            frame.setSize(500, 400);
            frame.setLocationRelativeTo(this);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            javax.swing.JTable tabla = new javax.swing.JTable(model);
            tabla.setDefaultEditor(Object.class, null);
            frame.add(new javax.swing.JScrollPane(tabla));
            frame.setVisible(true);
    }//GEN-LAST:event_btniConsultarListadoActionPerformed

    private void btniRegistrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btniRegistrarClienteActionPerformed
            Registrar re= new Registrar(administrador, this);
                re.setVisible(true);
                dispose();
        
    }//GEN-LAST:event_btniRegistrarClienteActionPerformed

    private void btniEliminarPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btniEliminarPersonaActionPerformed
            eliminar el= new eliminar(administrador,this);
            el.setVisible(true);
            dispose();
    }//GEN-LAST:event_btniEliminarPersonaActionPerformed

    private void btniRegistrarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btniRegistrarLibroActionPerformed
        Resgistarlibro re= new Resgistarlibro(administrador,this);
        re.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_btniRegistrarLibroActionPerformed

    private void btniEliminarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btniEliminarLibroActionPerformed
      EliminarLibro el= new EliminarLibro(administrador,this);
      el.setVisible(true);
      dispose();
    }//GEN-LAST:event_btniEliminarLibroActionPerformed

    private void btniPrestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btniPrestamoActionPerformed
        PrestamoLibro pre= new PrestamoLibro(administrador,this);
        pre.setVisible(true);
        dispose();
    }//GEN-LAST:event_btniPrestamoActionPerformed

    private void btniDevolverLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btniDevolverLibroActionPerformed
       DevolverLibro del= new DevolverLibro(administrador,this);
       del.setVisible(true);
       dispose();
    }//GEN-LAST:event_btniDevolverLibroActionPerformed

    private void btniGenerarInformeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btniGenerarInformeActionPerformed
         administrador.generarInforme();
    
    int[] totales = administrador.obtenerTotales();
    
    JFrame frameInforme = new JFrame("Informe del día");
    frameInforme.setSize(300, 250);
    frameInforme.setLocationRelativeTo(this);
    frameInforme.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    
    JPanel panel = new JPanel();
    panel.setLayout(new java.awt.GridLayout(5, 1, 10, 10));
    panel.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
    
    panel.add(new JLabel("Fecha: " + java.time.LocalDate.now().toString()));
    panel.add(new JLabel("Total préstamos:" + totales[0]));
    panel.add(new JLabel("Activos:" + totales[1]));
    panel.add(new JLabel("Devueltos:" + totales[2]));
    panel.add(new JLabel("En mora: " + totales[3]));
    
    frameInforme.add(panel);
    frameInforme.setVisible(true);
    }//GEN-LAST:event_btniGenerarInformeActionPerformed

    private void btniConsultarListadoLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btniConsultarListadoLibroActionPerformed
        List<Libro> libros = administrador.listarLibros();

    String[] columnas = {"ID", "Nombre"};
    javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(columnas, 0);

    for (Libro l : libros) {
        model.addRow(new Object[]{l.getIdLibro(), l.getNombre()});
    }

    JFrame frame = new JFrame("Listado de Libros");
    frame.setSize(400, 400);
    frame.setLocationRelativeTo(this);
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    javax.swing.JTable tabla = new javax.swing.JTable(model);
    tabla.setDefaultEditor(Object.class, null);
    frame.add(new javax.swing.JScrollPane(tabla));
    frame.setVisible(true);
    }//GEN-LAST:event_btniConsultarListadoLibroActionPerformed

    private void btniConsultarBibliotecarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btniConsultarBibliotecarioActionPerformed
        List<Bibliotecario> bibliotecarios = administrador.verTodosBibliotecarios();

    String[] columnas = {"Cédula", "Nombre", "Email"};
    javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(columnas, 0);

    for (Bibliotecario b : bibliotecarios) {
        model.addRow(new Object[]{b.getCedula(), b.getNombre(), b.getEmail()});
    }

        JFrame frame = new JFrame("Listado de Bibliotecarios");
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(this);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        javax.swing.JTable tabla = new javax.swing.JTable(model);
        tabla.setDefaultEditor(Object.class, null);
        frame.add(new javax.swing.JScrollPane(tabla));
        frame.setVisible(true);
    }//GEN-LAST:event_btniConsultarBibliotecarioActionPerformed

    private void btniRegistrarBibliotecarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btniRegistrarBibliotecarioActionPerformed
        RegistrarBibliotecario reb= new RegistrarBibliotecario(administrador, this);
        reb.setVisible(true);
        dispose();
    }//GEN-LAST:event_btniRegistrarBibliotecarioActionPerformed

    private void btniEliminarBibliotecarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btniEliminarBibliotecarioActionPerformed
       EliminarBibliotecario elb= new EliminarBibliotecario(administrador, this);
       elb.setVisible(true);
       dispose();
    }//GEN-LAST:event_btniEliminarBibliotecarioActionPerformed

   
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu EliminarLibro;
    private javax.swing.JMenuItem MenuiCerrarSesion;
    private javax.swing.JMenu btnCliente;
    private javax.swing.JMenu btniCerrarSesion;
    private javax.swing.JMenuItem btniConsultarBibliotecario;
    private javax.swing.JMenuItem btniConsultarListado;
    private javax.swing.JMenuItem btniConsultarListadoLibro;
    private javax.swing.JMenuItem btniDevolverLibro;
    private javax.swing.JMenuItem btniEliminarBibliotecario;
    private javax.swing.JMenuItem btniEliminarLibro;
    private javax.swing.JMenuItem btniEliminarPersona;
    private javax.swing.JMenuItem btniGenerarInforme;
    private javax.swing.JMenu btniGenerarInformes;
    private javax.swing.JMenuItem btniPrestamo;
    private javax.swing.JMenuItem btniRegistrarBibliotecario;
    private javax.swing.JMenuItem btniRegistrarCliente;
    private javax.swing.JMenuItem btniRegistrarLibro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
