/*
 
 */
package Formularios;
import Atxy2k.CustomTextField.RestrictedTextField;
import Formularios.conectar_db;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.event.ItemEvent;
import java.sql.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PedidoPostre extends javax.swing.JFrame {

    DefaultTableModel model;
    Connection conn;
    Statement st;
    
    public PedidoPostre() {
        initComponents();
     limitarPrecio();
           
        conn=conectar_db.conectar_a_baseded();
        //----------------
        cmboPostreC.setEnabled(false);
        cmboPostreD.setEnabled(false);
        txtPrecioPostre.setEnabled(false);
        //----------------
        this.setLocationRelativeTo(null);
       
    
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
      btnGuardar.setEnabled(false);
        txtSearch.setVisible(false);
        btnCancelar.setVisible(true);
        btnCancelar.setEnabled(true);
        llenartabla("");
      
    }
      void posicion(){
    this.setSize(650,441);
        this.setMinimumSize(new Dimension(650,441));
        this.setLocationRelativeTo(null); 
         }

   public String[] obtener(String clasificacion)
    {
        String[] descripcion = new String[5];
        if(clasificacion.equalsIgnoreCase("POSTRES CASEROS"))
        {
            descripcion[0] = "PUDING CASERO";
            descripcion[1] = "FLAN DE LA CASA";
            descripcion[2] = "TARTA BROWNIE CASERO";
     
        }
        
        if(clasificacion.equalsIgnoreCase("HELADOS"))
        {
            descripcion[0] = "H.DE VAINILLA";
            descripcion[1] = "H.DE CHOCOLATE";
            descripcion[2] = "H.DE DULCE DE LECHE";
            
        }if(clasificacion.equalsIgnoreCase("CAFÉ"))
        {
            descripcion[0] = "ESPRESSO";
            descripcion[1] = "CAPUCHINO";//LIGHT
            descripcion[2] = "CAFÉ CON LECHE";//AMERICANO
            descripcion[3] = "NEGRO";
            
        } if(clasificacion.equalsIgnoreCase("PORCIONES DE TORTA"))
        {
            descripcion[0] = "COOKIES CHOCOLATE";
            descripcion[1] = "COOKIES VAINILLA";
            descripcion[2] = "PANQUEQUES CREPS";
    
        }
         
         /*
          if(clasificacion.equalsIgnoreCase(""))
        {
            descripcion[0] = "";
            descripcion[1] = "";
            descripcion[2] = "";
            descripcion[3] = "";
            descripcion[4] = "";
        }*/
        return descripcion;
    }
  
   
 
void limpiarPostre(){
    cmboPostreC.setSelectedItem("SELECCIONE UNA OPCION");
    cmboPostreC.setSelectedItem("");
    txtPrecioPostre.setText(null);
}
    void limitarPrecio(){
        RestrictedTextField r = new RestrictedTextField(txtPrecioPostre);
        r.setLimit(5);
        r.setOnlyNums(true);
    }
void llenartabla(String valor){
    try {
         conn=conectar_db.conectar_a_baseded();
        String[]titulos={"CODIGO_POSTRE","CLASIFICACION","DESCRIPCION","PRECIO"};
        String sql = "SELECT * FROM postre WHERE CONCAT (clasificacion,' ', descripcion) LIKE '%" + valor + "%'";
        model=new DefaultTableModel(null,titulos);
        st=conn.createStatement();
        ResultSet rs= st.executeQuery(sql);
        String fila [] = new String [5];
        while(rs.next()){
            fila[0]=rs.getString("CODIGO_POSTRE");
            fila[1]=rs.getString("CLASIFICACION");
            fila[2]=rs.getString("DESCRIPCION");
            fila[3]=rs.getString("PRECIO");
            model.addRow(fila);
        }        
        tablaPostres.setModel(model);
    } catch (Exception e) {
        e.printStackTrace();
    }
}

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtPrecioPostre = new javax.swing.JTextField();
        cmboPostreC = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        cmboPostreD = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPostres = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnRegresar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("PRECIO");

        txtPrecioPostre.setFont(new java.awt.Font("BatangChe", 1, 24)); // NOI18N
        txtPrecioPostre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPrecioPostre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioPostreActionPerformed(evt);
            }
        });
        txtPrecioPostre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioPostreKeyTyped(evt);
            }
        });

        cmboPostreC.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        cmboPostreC.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECCIONE UNA OPCION", "POSTRES CASEROS", "HELADOS", "CAFÉ", "PORCIONES DE TORTA", " " }));
        cmboPostreC.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmboPostreCItemStateChanged(evt);
            }
        });
        cmboPostreC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmboPostreCActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("DESCRIPCION");

        cmboPostreD.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        cmboPostreD.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmboPostreDItemStateChanged(evt);
            }
        });
        cmboPostreD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmboPostreDActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("CLASIFICACION");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmboPostreC, 0, 180, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmboPostreD, 0, 128, Short.MAX_VALUE)
                            .addComponent(txtPrecioPostre))
                        .addGap(10, 10, 10)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmboPostreC, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmboPostreD, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecioPostre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 84, 340, 220));

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/insertar.png"))); // NOI18N
        btnNuevo.setText("NUEVO");
        btnNuevo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnNuevo.setBorderPainted(false);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        getContentPane().add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, 120, 50));

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/save.png"))); // NOI18N
        btnGuardar.setText("GUARDAR");
        btnGuardar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnGuardar.setBorderPainted(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, 120, 50));

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/edit.png"))); // NOI18N
        btnModificar.setText("MODIFICAR");
        btnModificar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnModificar.setBorderPainted(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        getContentPane().add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 210, 120, 50));

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/elimina.png"))); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEliminar.setBorderPainted(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, 120, 50));

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/delete.png"))); // NOI18N
        btnCancelar.setText("CANCELAR");
        btnCancelar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCancelar.setBorderPainted(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 150, 120, 50));

        txtSearch.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        txtSearch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        getContentPane().add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 270, 167, 31));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/preview_search.png"))); // NOI18N
        jButton1.setText("BUSCAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(486, 210, 120, 50));

        tablaPostres.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaPostres.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPostresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaPostres);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 610, 130));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("REGISTRO DE POSTRES");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 260, 40));

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        btnRegresar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/regresar.png"))); // NOI18N
        btnRegresar1.setText("REGRESAR");
        btnRegresar1.setBorder(null);
        btnRegresar1.setBorderPainted(false);
        btnRegresar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(507, Short.MAX_VALUE)
                .addComponent(btnRegresar1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnRegresar1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 80));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPrecioPostreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioPostreKeyTyped
        char c = evt.getKeyChar();
        if((c<'0' || c>'9') ) evt.consume();
    }//GEN-LAST:event_txtPrecioPostreKeyTyped

    private void cmboPostreCItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmboPostreCItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED)
        {
            if(this.cmboPostreC.getSelectedIndex()>0)
            {
                this.cmboPostreD.setModel(new DefaultComboBoxModel(this.obtener(this.cmboPostreC.getSelectedItem().toString())));
            }
        }
    }//GEN-LAST:event_cmboPostreCItemStateChanged

    private void cmboPostreDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmboPostreDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmboPostreDActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
         cmboPostreC.setEnabled(true);
        cmboPostreD.setEnabled(true);
        txtPrecioPostre.setEnabled(true);
        limpiarPostre();
        btnGuardar.setVisible(true);
        btnCancelar.setEnabled(true);
        btnCancelar.setVisible(true);
        btnGuardar.setEnabled(true);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        try {
            int fila = tablaPostres.getSelectedRow();
            String sql = "UPDATE postre SET clasificacion=?,descripcion=?,precio=? WHERE codigo_postre = "+tablaPostres.getValueAt(fila,0);
            
           
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1,cmboPostreC.getSelectedItem().toString());
            ps.setString(2,cmboPostreD.getSelectedItem().toString());
            ps.setString(3,txtPrecioPostre.getText());
      
            int n = ps.executeUpdate();
            if(n>0 ){
                limpiarPostre();
                llenartabla("");
                JOptionPane.showMessageDialog(null,"DATOS MODIFICADOS");
                
            }
            
        } catch (Exception e) {
        JOptionPane.showMessageDialog(null,"error"+e.getMessage());
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
          try {
            int fila = tablaPostres.getSelectedRow();
            String sql = "DELETE FROM postre WHERE codigo_postre = "+tablaPostres.getValueAt(fila,0);
            st=conn.createStatement();
            int n = st.executeUpdate(sql);
            if(n>0){
                llenartabla("");
                JOptionPane.showMessageDialog(null,"DATOS ELIMINADOS");
                limpiarPostre();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ERROR"+e.getMessage());
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
   
        limpiarPostre();
        btnGuardar.setEnabled(false);
        btnEliminar.setEnabled(false);
        txtSearch.setVisible(false);
        btnNuevo.setEnabled(true);
   btnModificar.setEnabled(false);
        
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        btnModificar.setEnabled(true);
        btnEliminar.setEnabled(true);
    
        txtSearch.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        try {
            String sql = "INSERT INTO postre(clasificacion,descripcion,precio)"+"VALUES(?,?,?)";
            PreparedStatement ps = conn.prepareCall(sql);
            //STRING VARIABLE = NOMBRECOMBO.GETSELECTEDITEM().TOSTRING();
           // String combo1 = this.cmboPlatoC.getSelectedItem().toString();
            //String combo2=this.cmboPlatoD.getSelectedItem().toString();
           // ps.setString(1,txtnombre.getText());
            ps.setString(1,this.cmboPostreC.getSelectedItem().toString());
            ps.setString(2,this.cmboPostreD.getSelectedItem().toString());
            ps.setString(3,txtPrecioPostre.getText());
            int n=ps.executeUpdate();
            if(n>0){
                JOptionPane.showMessageDialog(null,"DATOS GUARDADOS");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ERROR AL GUARDAR"+ e.getMessage());
        }
        llenartabla("");
        limpiarPostre();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void tablaPostresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPostresMouseClicked
        if (evt.getButton()==1){
            btnModificar.setEnabled(true);
            btnNuevo.setEnabled(false);
            btnGuardar.setEnabled(false);
            btnModificar.setVisible(true);
          btnEliminar.setEnabled(true);
          btnEliminar.setVisible(true);
            btnCancelar.setEnabled(true);
            try{
            
            int fila=tablaPostres.getSelectedRow();
            String sql = "SELECT * FROM postre WHERE codigo_postre="+tablaPostres.getValueAt(fila,0);
            st=conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            cmboPostreC.setSelectedItem(rs.getString("clasificacion"));
            cmboPostreD.setSelectedItem(rs.getString("descripcion"));
            txtPrecioPostre.setText(rs.getString("precio"));
            }catch(Exception e ){
              e.printStackTrace();  
            }
            
        }
    }//GEN-LAST:event_tablaPostresMouseClicked

    private void cmboPostreDItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmboPostreDItemStateChanged
        btnModificar.setVisible(true);
        btnModificar.setEnabled(true);
        btnEliminar.setVisible(true);
        btnEliminar.setEnabled(true);
   
    }//GEN-LAST:event_cmboPostreDItemStateChanged

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
           try{
           String sql = "SELECT * FROM postre WHERE clasificacion= " + txtSearch.getText();
            PreparedStatement ps = conn.prepareCall(sql);
            ps.executeQuery();
       } catch(Exception e){
           
       }
    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        llenartabla(txtSearch.getText());
    }//GEN-LAST:event_txtSearchKeyReleased

    private void txtPrecioPostreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioPostreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioPostreActionPerformed

    private void cmboPostreCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmboPostreCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmboPostreCActionPerformed

    private void btnRegresar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresar1ActionPerformed
        MenuPrinc obj = new MenuPrinc();
        obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresar1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PedidoPostre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PedidoPostre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PedidoPostre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PedidoPostre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PedidoPostre().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnRegresar1;
    private javax.swing.JComboBox cmboPostreC;
    private javax.swing.JComboBox cmboPostreD;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaPostres;
    private javax.swing.JTextField txtPrecioPostre;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
