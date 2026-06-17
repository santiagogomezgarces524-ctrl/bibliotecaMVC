/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View.Menus;
import View.Registrar;
import View.eliminar;
import Controller.*;
import Moldel.Usuario;
import View.libros.*;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MenuBibliotecario extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MenuBibliotecario.class.getName());
        public BibliotecarioController bibliotecario;
    
    public MenuBibliotecario(BibliotecarioController bibliotecario) {
        this.bibliotecario=bibliotecario;
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        btnCuenta = new javax.swing.JMenu();
        btniCerrarSesion = new javax.swing.JMenuItem();
        btnLibros = new javax.swing.JMenu();
        btniRegistrarlibro = new javax.swing.JMenuItem();
        btniEliminarLibro = new javax.swing.JMenuItem();
        btniPrestamo = new javax.swing.JMenuItem();
        btniDelvolverLibro = new javax.swing.JMenuItem();
        btnClientes = new javax.swing.JMenu();
        btniRegistrarCliente = new javax.swing.JMenuItem();
        btniEliminarCliente = new javax.swing.JMenuItem();
        btniConsultarListado = new javax.swing.JMenuItem();
        btnInformes = new javax.swing.JMenu();
        btniGenerarInforme = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 204));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenBiblioteca/library (3).png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(112, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
        );

        btnCuenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenBiblioteca/member.png"))); // NOI18N
        btnCuenta.setText("Cuenta");
        btnCuenta.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btniCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/door_out.png"))); // NOI18N
        btniCerrarSesion.setText("Cerrar Sesion");
        btniCerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btniCerrarSesion.addActionListener(this::btniCerrarSesionActionPerformed);
        btnCuenta.add(btniCerrarSesion);

        jMenuBar1.add(btnCuenta);

        btnLibros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenBiblioteca/documentation.png"))); // NOI18N
        btnLibros.setText("Libros");
        btnLibros.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btniRegistrarlibro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/book_add.png"))); // NOI18N
        btniRegistrarlibro.setText("Registar Libro");
        btniRegistrarlibro.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btniRegistrarlibro.addActionListener(this::btniRegistrarlibroActionPerformed);
        btnLibros.add(btniRegistrarlibro);

        btniEliminarLibro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/book_delete.png"))); // NOI18N
        btniEliminarLibro.setText("Eliminar Libro");
        btniEliminarLibro.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btniEliminarLibro.addActionListener(this::btniEliminarLibroActionPerformed);
        btnLibros.add(btniEliminarLibro);

        btniPrestamo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/book_go.png"))); // NOI18N
        btniPrestamo.setText("Prestamo");
        btniPrestamo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btniPrestamo.addActionListener(this::btniPrestamoActionPerformed);
        btnLibros.add(btniPrestamo);

        btniDelvolverLibro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/book.png"))); // NOI18N
        btniDelvolverLibro.setText("Devolver Libro");
        btniDelvolverLibro.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btniDelvolverLibro.addActionListener(this::btniDelvolverLibroActionPerformed);
        btnLibros.add(btniDelvolverLibro);

        jMenuBar1.add(btnLibros);

        btnClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenBiblioteca/book (1).png"))); // NOI18N
        btnClientes.setText("Clientes");
        btnClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btniRegistrarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/user_add.png"))); // NOI18N
        btniRegistrarCliente.setText("Registrar Cliente");
        btniRegistrarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btniRegistrarCliente.addActionListener(this::btniRegistrarClienteActionPerformed);
        btnClientes.add(btniRegistrarCliente);

        btniEliminarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/user_delete.png"))); // NOI18N
        btniEliminarCliente.setText("Eliminar Cliente");
        btniEliminarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btniEliminarCliente.addActionListener(this::btniEliminarClienteActionPerformed);
        btnClientes.add(btniEliminarCliente);

        btniConsultarListado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/database_go.png"))); // NOI18N
        btniConsultarListado.setText("consultar Listado");
        btniConsultarListado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btniConsultarListado.addActionListener(this::btniConsultarListadoActionPerformed);
        btnClientes.add(btniConsultarListado);

        jMenuBar1.add(btnClientes);

        btnInformes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenBiblioteca/learning.png"))); // NOI18N
        btnInformes.setText("Informes");

        btniGenerarInforme.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenBiblioteca/ebook.png"))); // NOI18N
        btniGenerarInforme.setText("Generar Informe");
        btniGenerarInforme.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btniGenerarInforme.addActionListener(this::btniGenerarInformeActionPerformed);
        btnInformes.add(btniGenerarInforme);

        jMenuBar1.add(btnInformes);

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

    private void btniEliminarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btniEliminarLibroActionPerformed
         eliminar el= new eliminar(bibliotecario,this);
            el.setVisible(true);
            dispose();
    }//GEN-LAST:event_btniEliminarLibroActionPerformed

    private void btniConsultarListadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btniConsultarListadoActionPerformed
            List<Usuario> usuarios = bibliotecario.listarUsuarios();

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
         Registrar re= new Registrar(bibliotecario,this);
                re.setVisible(true);
                dispose();
        
    }//GEN-LAST:event_btniRegistrarClienteActionPerformed

    private void btniRegistrarlibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btniRegistrarlibroActionPerformed
      Resgistarlibro re= new Resgistarlibro(bibliotecario,this);
        re.setVisible(true);
        dispose();
    }//GEN-LAST:event_btniRegistrarlibroActionPerformed

    private void btniPrestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btniPrestamoActionPerformed
        PrestamoLibro pre= new PrestamoLibro(bibliotecario,this);
        pre.setVisible(true);
        dispose();
    }//GEN-LAST:event_btniPrestamoActionPerformed

    private void btniDelvolverLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btniDelvolverLibroActionPerformed
        DevolverLibro del= new DevolverLibro(bibliotecario,this);
       del.setVisible(true);
       dispose();
    }//GEN-LAST:event_btniDelvolverLibroActionPerformed

    private void btniGenerarInformeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btniGenerarInformeActionPerformed
        bibliotecario.generarInforme();
    
    int[] totales = bibliotecario.obtenerTotales();
    
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

    private void btniCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btniCerrarSesionActionPerformed
      System.exit(0);
    }//GEN-LAST:event_btniCerrarSesionActionPerformed

    private void btniEliminarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btniEliminarClienteActionPerformed
         eliminar el= new eliminar(bibliotecario,this);
            el.setVisible(true);
            dispose();
    }//GEN-LAST:event_btniEliminarClienteActionPerformed

   
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu btnClientes;
    private javax.swing.JMenu btnCuenta;
    private javax.swing.JMenu btnInformes;
    private javax.swing.JMenu btnLibros;
    private javax.swing.JMenuItem btniCerrarSesion;
    private javax.swing.JMenuItem btniConsultarListado;
    private javax.swing.JMenuItem btniDelvolverLibro;
    private javax.swing.JMenuItem btniEliminarCliente;
    private javax.swing.JMenuItem btniEliminarLibro;
    private javax.swing.JMenuItem btniGenerarInforme;
    private javax.swing.JMenuItem btniPrestamo;
    private javax.swing.JMenuItem btniRegistrarCliente;
    private javax.swing.JMenuItem btniRegistrarlibro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
