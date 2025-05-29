package Ventanas.SubVentanas;

import Clases.ArchivoClientes;
import Clases.Cliente;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ViewEditClientes extends javax.swing.JInternalFrame {
    private ArchivoClientes ACInstance;
    String datos[][];
    String Headers[]=new String[]{"Nombre del Cliente","Numero de telefono", "Email", "Nombre Mascota", "Genero" ,"Especie", "Raza", "Color", "Edad", "Detalles Medicos", "Observaciones"};
    private DefaultTableModel modeloTabla;
    
    public ViewEditClientes() {
        ACInstance = new ArchivoClientes();
        initComponents();
        llenarTabla();
    }
    
    public void llenarTabla(){
            LinkedList lista = ACInstance.LeerArchivo();
            Object[] x = lista.toArray();
            datos = new String[x.length][11];
            for(int i = 0 ; i < x.length ; i++){
                Cliente C = (Cliente) x[i];
                datos[i][0] = C.NombreCliente;
                datos[i][1] = C.NumeroCliente;
                datos[i][2] = C.Email;
                datos[i][3] = C.NombreMascota;
                datos[i][4] = C.GeneroMascota;
                datos[i][5] = C.Especie;
                datos[i][6] = C.Raza;
                datos[i][7] = C.Color;
                datos[i][8] = "" + C.Edad;
                datos[i][9] = C.DetallesMedicos;
                datos[i][10] = C.Observaciones;
            }
            modeloTabla = new DefaultTableModel(datos,Headers);
            TablaClientes.setModel(modeloTabla);
            jScrollPane1.setViewportView(TablaClientes);
    }
    
    public void EliminarRegistro(){
        int filaSeleccionada = TablaClientes.getSelectedRow();
        DefaultTableModel modelo = (DefaultTableModel) TablaClientes.getModel();
        modelo.removeRow(filaSeleccionada);
        }
    
    public void GuardarCambios(){
        String nombreArchivo = "Clientes.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo, false))) { 
            for (int i = 0; i < TablaClientes.getRowCount(); i++) {
                for (int j = 0; j < TablaClientes.getColumnCount(); j++) {
                    Object valorCelda = TablaClientes.getValueAt(i, j);
                    writer.write(valorCelda != null ? valorCelda.toString() : "");
                    if (j < TablaClientes.getColumnCount() - 1) {
                        writer.write(";");
                    }
                }
                writer.newLine();
            }
            } catch (Exception a) {
            JOptionPane.showMessageDialog(this, "Error al guardar los datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaClientes = new javax.swing.JTable();
        DeleteButton = new javax.swing.JLabel();
        SaveButton = new javax.swing.JLabel();

        jLabel1.setBackground(new java.awt.Color(196, 223, 230));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(43, 45, 66));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gestionar lista de Clientes");
        jLabel1.setOpaque(true);

        TablaClientes.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        TablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre del Cliente", "Número de telefono", "Correo electronico", "Nombre de la Mascota", "Especie", "Raza", "Edad", "Color", "Sexo", "Condiciones Medicas", "Notas Adicionales"
            }
        ));
        jScrollPane1.setViewportView(TablaClientes);

        DeleteButton.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        DeleteButton.setForeground(new java.awt.Color(204, 0, 0));
        DeleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/DeleteIco.png"))); // NOI18N
        DeleteButton.setText("Eliminar Registro Seleccionado");
        DeleteButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DeleteButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeleteButtonMouseClicked(evt);
            }
        });

        SaveButton.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        SaveButton.setForeground(new java.awt.Color(0, 102, 204));
        SaveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/SaveIcon.png"))); // NOI18N
        SaveButton.setText("Guardar Cambios");
        SaveButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SaveButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SaveButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 995, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(DeleteButton)
                        .addGap(161, 161, 161)
                        .addComponent(SaveButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DeleteButton)
                    .addComponent(SaveButton))
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DeleteButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteButtonMouseClicked
        EliminarRegistro();
        GuardarCambios();
    }//GEN-LAST:event_DeleteButtonMouseClicked

    private void SaveButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveButtonMouseClicked
        GuardarCambios();
        JOptionPane.showMessageDialog(null, "Se han guardado todos los cambios","Guardar",JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_SaveButtonMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DeleteButton;
    private javax.swing.JLabel SaveButton;
    private javax.swing.JTable TablaClientes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
