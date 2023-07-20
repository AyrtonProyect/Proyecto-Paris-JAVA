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
public class postre_fact extends javax.swing.JInternalFrame {
    DefaultTableModel modelo;

    /** Creates new form clientes */
    public postre_fact() {
        initComponents();
        mostrarpostre("");
    }
    String comparar(String cod)
    {
        String cant="";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM postre WHERE codigo_postre='"+cod+"'");
            while(rs.next())
            {
                cant=rs.getString(4);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(postre_fact.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cant;
        
    }
   void mostrarpostre(String valor)
    {
        String[]titulos={"Codigo","Clasificacion","Descripcion","Precio"} ;  
        String []Registros= new String[4];
        modelo=new DefaultTableModel(null,titulos);
        String Sql="SELECT * FROM postre WHERE CONCAT(codigo_postre,clasificacion,descripcion) LIKE '%"+valor+"%'";
       
        try {
             Statement st = cn.createStatement();
             ResultSet rs = st.executeQuery(Sql);
             while(rs.next())
             {
                 Registros[0]=rs.getString("codigo_postre");  
                 Registros[1]=rs.getString("clasificacion");  
                 Registros[2]=rs.getString("descripcion");  
                 Registros[3]=rs.getString("precio");  
           
                 modelo.addRow(Registros);
             } 
             tbpostre.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(postre_fact.class.getName()).log(Level.SEVERE, null, ex);
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
        tbpostre = new javax.swing.JTable();

        mnenviar.setText("Enviar Datos");
        mnenviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnenviarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(mnenviar);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("POSTRES");

        jLabel1.setText("Buscar postre:");

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

        tbpostre.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbpostre.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(tbpostre);

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
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtbus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
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
    mostrarpostre("");
}//GEN-LAST:event_btnbusActionPerformed

private void txtbusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbusActionPerformed
// TODO add your handling code here:
    
}//GEN-LAST:event_txtbusActionPerformed

private void txtbusKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbusKeyReleased
// TODO add your handling code here:
    mostrarpostre(txtbus.getText());
}//GEN-LAST:event_txtbusKeyReleased

private void mnenviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnenviarActionPerformed
// TODO add your handling code here:
      try {
         DefaultTableModel tabladet = (DefaultTableModel)     Factura.tbdet.getModel();
    String[]  dato=new String[5];
   
    int  fila = tbpostre.getSelectedRow();
    
    
    if(fila==-1)
    {
        JOptionPane.showMessageDialog(null, "No  ha seleccionado ningun registro");
    }
    else
    {
        String codins=tbpostre.getValueAt(fila, 0).toString();
        String clains=tbpostre.getValueAt(fila, 1).toString();
        String desins=tbpostre.getValueAt(fila, 2).toString();
        String preins=tbpostre.getValueAt(fila, 3).toString();
        int c=0;
        int j=0;
         String  cant=JOptionPane.showInputDialog("Ingrese Cantidad");
        if((cant.equals("")) || (cant.equals("0")))
        {
            JOptionPane.showMessageDialog(this, "Debe ingresar algun valor mayor que 0");
        }
        else
        {
      
                   for(int i=0;i<Factura.tbdet.getRowCount();i++)
        {
            Object com=Factura.tbdet.getValueAt(i,0);
            if(codins.equals(com))
            {
                j=i;
                Factura.tbdet.setValueAt(cant, i, 3);
                c=c+1;
       
            }
   
        }
        if(c==0)
        {
           
      
            dato[0]=codins;
            dato[1]=clains;
            dato[2]=desins;
            dato[3]=preins;
            dato[4]=cant;
            
            
            tabladet.addRow(dato);
        
            Factura.tbdet.setModel(tabladet);
            
            
        }
             
  
        }
        
    
        
        
        
    }
    } catch (Exception e) {
    }
}//GEN-LAST:event_mnenviarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem mnenviar;
    private javax.swing.JTable tbpostre;
    private javax.swing.JTextField txtbus;
    // End of variables declaration//GEN-END:variables
    conectar_db cc= new conectar_db();
Connection cn = cc.conectar_a_baseded();
}