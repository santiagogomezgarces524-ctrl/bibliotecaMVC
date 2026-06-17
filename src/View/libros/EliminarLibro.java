/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View.libros;

import Controller.*;
import Moldel.Libro;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class EliminarLibro extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(EliminarLibro.class.getName());

    public BibliotecarioController bibliotecario;
     private javax.swing.JFrame menuAnterior;
    public EliminarLibro( BibliotecarioController bibliotecario,JFrame menuAnterior) {
        this.bibliotecario= bibliotecario;
        this.menuAnterior=menuAnterior;
        initComponents();
    }

    void Limpiar(){
    txtIdLibro.setText("");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtIdLibro = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        brnCancelar = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel1.setText("Eliminar Libro");

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel2.setText("idLibro:");

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/bullet_red.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEliminar.addActionListener(this::btnEliminarActionPerformed);

        brnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cancel.png"))); // NOI18N
        brnCancelar.setText("Cancelar");
        brnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        brnCancelar.addActionListener(this::brnCancelarActionPerformed);

        btnConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/database_go.png"))); // NOI18N
        btnConsultar.setText("consultar");
        btnConsultar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnConsultar.addActionListener(this::btnConsultarActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 18, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIdLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConsultar)
                .addGap(28, 28, 28))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(btnEliminar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(brnCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIdLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultar))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(brnCancelar)
                    .addComponent(btnEliminar))
                .addGap(45, 45, 45))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try{
            int idlibro = Integer.parseInt(txtIdLibro.getText().trim());
            bibliotecario.eliminarLibro(idlibro);
            }catch(NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "El ID debe estar errado.");
                                              }
        Limpiar();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void brnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brnCancelarActionPerformed
        menuAnterior.setVisible(true);
        dispose();
    }//GEN-LAST:event_brnCancelarActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
     List<Libro> libros = bibliotecario.listarLibros();

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
    }//GEN-LAST:event_btnConsultarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton brnCancelar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtIdLibro;
    // End of variables declaration//GEN-END:variables
}
