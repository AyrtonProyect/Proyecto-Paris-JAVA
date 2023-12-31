/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * clientes.java
 *
 * Created on 09-abr-2013, 18:07:11
 */
package Formularios;


import Formularios.conectar_db;
        
import java.awt.Color;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrador
 */
public class clientes_fact extends javax.swing.JInternalFrame {
    DefaultTableModel modelo;

    /** Creates new form clientes */
    public clientes_fact() {
        initComponents();
        mostrarclientes("");
    }
   
   void mostrarclientes(String valor)
    {
        String[]titulos={"Codigo","Nombre","Apellidos","C.I/RUC","Direccion","Telefono"} ;  
        String []Registros= new String[6];
        modelo=new DefaultTableModel(null,titulos);
        String Sql="SELECT * FROM cliente WHERE CONCAT(id_cliente,nombre_cliente,apellido_cliente,ci_cliente) LIKE '%"+valor+"%'";
       
        try {
             Statement st = cn.createStatement();
             ResultSet rs = st.executeQuery(Sql);
             while(rs.next())
             {
                 Registros[0]=rs.getString("id_cliente");  
                 Registros[1]=rs.getString("nombre_cliente");  
                 Registros[2]=rs.getString("apellido_cliente");  
                 Registros[3]=rs.getString("ci_cliente");  
                 Registros[4]=rs.getString("direc_cliente");  
                 Registros[5]=rs.getString("telefono_cliente");  
                 modelo.addRow(Registros);
             } 
             tbclientes.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(clientes_fact.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
        

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        mnenviar = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnbus = new javax.swing.JButton();
        txtbus = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbclientes = new javax.swing.JTable();
        Btnregistrar = new javax.swing.JButton();

        mnenviar.setText("Enviar Datos");
        mnenviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnenviarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(mnenviar);

        setBackground(new java.awt.Color(204, 204, 204));
        setClosable(true);
        setForeground(new java.awt.Color(255, 255, 255));
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("CLIENTES");
        setComponentPopupMenu(jPopupMenu1);
        setFrameIcon(null);
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        setVisible(true);

        jLabel1.setText("Buscar Cliente:");

        btnbus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/menu.png"))); // NOI18N
        btnbus.setText("Mostrar Todo");
        btnbus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbusActionPerformed(evt);
            }
        });

        txtbus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbusActionPerformed(evt);
            }
        });
        txtbus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbusKeyReleased(evt);
            }
        });

        tbclientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbclientes.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(tbclientes);

        Btnregistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/agregar.png"))); // NOI18N
        Btnregistrar.setText("Registrar Clientes");
        Btnregistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnregistrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtbus, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnbus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Btnregistrar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtbus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbus)
                    .addComponent(Btnregistrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnbusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbusActionPerformed
// TODO add your handling code here:
    mostrarclientes("");
}//GEN-LAST:event_btnbusActionPerformed

private void txtbusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbusActionPerformed
// TODO add your handling code here:
    
}//GEN-LAST:event_txtbusActionPerformed

private void txtbusKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbusKeyReleased
// TODO add your handling code here:
    mostrarclientes(txtbus.getText());
}//GEN-LAST:event_txtbusKeyReleased

private void mnenviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnenviarActionPerformed
// TODO add your handling code here:
            int fila = tbclientes.getSelectedRow();
        try {
            if(fila==-1)
            {
                JOptionPane.showMessageDialog(null, "No ha seleccionado ningun dato");

            }
            else
            {
             String   cod =  (String)tbclientes.getValueAt(fila, 0);
             String  nom =  (String)tbclientes.getValueAt(fila, 1);
             String    ape =  (String)tbclientes.getValueAt(fila, 2);
             String    ci =  (String)tbclientes.getValueAt(fila, 3);
            String     dir =  (String)tbclientes.getValueAt(fila, 4);
             String    tel =  (String)tbclientes.getValueAt(fila, 5);
             
                Factura.txtcod.setDisabledTextColor(Color.blue);
                Factura.txtcod.setText(cod);
                Factura.txtnomape.setDisabledTextColor(Color.blue);
                Factura.txtnomape.setText(nom+"   "+ape);
                 Factura.txtruc.setDisabledTextColor(Color.blue);
                Factura.txtruc.setText(ci);
                Factura.txtdir.setDisabledTextColor(Color.blue);
                Factura.txtdir.setText(dir);
                 Factura.txttel.setDisabledTextColor(Color.blue);
                Factura.txttel.setText(tel);
               
                this.dispose();

            }
        } catch (Exception e) {
        }
}//GEN-LAST:event_mnenviarActionPerformed

private void BtnregistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnregistrarActionPerformed
// TODO add your handling code here:
    try {
        FrmCliente ingcli= new FrmCliente();
       
        ingcli.toFront();
        ingcli.setVisible(true);
        this.dispose();
        
    } catch (Exception e) {
    }
    
        
    
    
    
}//GEN-LAST:event_BtnregistrarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btnregistrar;
    private javax.swing.JButton btnbus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem mnenviar;
    private javax.swing.JTable tbclientes;
    private javax.swing.JTextField txtbus;
    // End of variables declaration//GEN-END:variables
    conectar_db cc= new conectar_db();
Connection cn = cc.conectar_a_baseded();
}
