
package Formularios;

import Atxy2k.CustomTextField.RestrictedTextField;
import Formularios.conectar_db;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.sql.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PedidoBebida extends javax.swing.JFrame {
    DefaultTableModel model;
    Connection conn;
    Statement sent;
    boolean m;
 
    public PedidoBebida() {
        initComponents();
         this.setLocationRelativeTo(null); 
        limitarPrecio();
        
         //----------------
        cmboBebidaC.setEnabled(false);
        cmboBebidaD.setEnabled(false);
        txtPrecioBebida.setEnabled(false);
        //----------------
        this.setLocationRelativeTo(null);
        btnGuardar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnModificar.setEnabled(false);
    
        txtSearch.setVisible(false);
        conn=conectar_db.conectar_a_baseded();
        llenartabla("");
   
        
    }
    void posicion(){
    this.setSize(650,441);
        this.setMinimumSize(new Dimension(650,441));
        this.setLocationRelativeTo(null); 
         }

  
  
  
    void limpiar(){
    cmboBebidaC.setSelectedItem("SELECCIONE UNA OPCION");
    cmboBebidaC.setSelectedItem("");
    txtPrecioBebida.setText(null);
}
    void limitarPrecio(){
        RestrictedTextField r = new RestrictedTextField(txtPrecioBebida);
        r.setLimit(5);
        r.setOnlyNums(true);
    }

    public String[] obtenerDescripcionBebida (String clasificacion){
       String[] descripcion = new String[5];
       
          if(clasificacion.equalsIgnoreCase("LICUADOS"))
        {
            descripcion[0] = "CHOCOLATE";
            descripcion[1] = "VAINILLA";
            descripcion[2] = "FRESA";
 
        }
       
             if(clasificacion.equalsIgnoreCase("REFRESCOS"))
        {
            descripcion[0] = "MIRINDA";
            descripcion[1] = "COCA-COLA";
            descripcion[2] = "MANZANITA";
        }
               if(clasificacion.equalsIgnoreCase("JUGOS"))
        {
            descripcion[0] = "NARANJA";
            descripcion[1] = "NARANJA/FRESA";
            descripcion[2] = "NARANJA/ZARZAMORA";
            
        }
return descripcion;   
   }
    void llenartabla(String valor){
    try {
        conn=conectar_db.conectar_a_baseded();
        String[]titulos={"CODIGO_BEBIDA","CLASIFICACION","DESCRIPCION","PRECIO"};
        String sql = "SELECT * FROM bebidas WHERE CONCAT (clasificacion,' ', descripcion) LIKE '%" + valor + "%'";
        model=new DefaultTableModel(null,titulos);
        sent=conn.createStatement();
        ResultSet rs= sent.executeQuery(sql);
        String fila [] = new String [5];
        while(rs.next()){
            fila[0]=rs.getString("codigo_bebida");
            fila[1]=rs.getString("clasificacion");
            fila[2]=rs.getString("descripcion");
            fila[3]=rs.getString("precio");
            model.addRow(fila);
        }        
        tablaBebida.setModel(model);
    } catch (Exception e) {
        e.printStackTrace();
    }
}
  
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmboBebidaC = new javax.swing.JComboBox();
        txtPrecioBebida = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cmboBebidaD = new javax.swing.JComboBox();
        btnNuevaBebida = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaBebida = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnRegresar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnRegresar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("BEBIDAS_RESTAURANTE PARIS");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("CLASIFICACION");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("PRECIO");

        cmboBebidaC.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cmboBebidaC.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECCIONE UNA OPCION", "LICUADOS", "JUGOS", "REFRESCOS" }));
        cmboBebidaC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmboBebidaC.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmboBebidaCItemStateChanged(evt);
            }
        });
        cmboBebidaC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmboBebidaCActionPerformed(evt);
            }
        });

        txtPrecioBebida.setFont(new java.awt.Font("BatangChe", 1, 24)); // NOI18N
        txtPrecioBebida.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPrecioBebida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioBebidaKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("DESCRIPCION");

        cmboBebidaD.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmboBebidaDItemStateChanged(evt);
            }
        });
        cmboBebidaD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmboBebidaDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmboBebidaC, 0, 212, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtPrecioBebida)
                            .addComponent(cmboBebidaD, 0, 111, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmboBebidaC, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmboBebidaD, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecioBebida, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 210));

        btnNuevaBebida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/insertar.png"))); // NOI18N
        btnNuevaBebida.setText("NUEVO");
        btnNuevaBebida.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnNuevaBebida.setBorderPainted(false);
        btnNuevaBebida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaBebidaActionPerformed(evt);
            }
        });
        getContentPane().add(btnNuevaBebida, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 80, 120, 50));

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/save.png"))); // NOI18N
        btnGuardar.setText("GUARDAR");
        btnGuardar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnGuardar.setBorderPainted(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, 120, 50));

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/delete.png"))); // NOI18N
        btnCancelar.setText("CANCELAR");
        btnCancelar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCancelar.setBorderPainted(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 140, 120, 50));

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/elimina.png"))); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEliminar.setBorderPainted(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, 120, 50));

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/edit.png"))); // NOI18N
        btnModificar.setText("MODIFICAR");
        btnModificar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnModificar.setBorderPainted(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        getContentPane().add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 200, 120, 50));

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
        getContentPane().add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 260, 170, 31));

        tablaBebida.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaBebida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaBebidaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaBebida);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 620, 120));

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/preview_search.png"))); // NOI18N
        btnBuscar.setText("BUSCAR");
        btnBuscar.setMaximumSize(new java.awt.Dimension(99, 37));
        btnBuscar.setMinimumSize(new java.awt.Dimension(99, 37));
        btnBuscar.setPreferredSize(new java.awt.Dimension(99, 37));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 200, 120, 50));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("REGISTRO DE BEBIDAS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, 40));

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/regresar.png"))); // NOI18N
        btnRegresar.setText("REGRESAR");
        btnRegresar.setBorder(null);
        btnRegresar.setBorderPainted(false);
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(507, Short.MAX_VALUE)
                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 80));

        jPanel3.setBackground(new java.awt.Color(70, 126, 133));

        btnRegresar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/regresar.png"))); // NOI18N
        btnRegresar1.setText("REGRESAR");
        btnRegresar1.setBorder(null);
        btnRegresar1.setBorderPainted(false);
        btnRegresar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(507, Short.MAX_VALUE)
                .addComponent(btnRegresar1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnRegresar1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 80));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmboBebidaCItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmboBebidaCItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED)
        {
            if(this.cmboBebidaC.getSelectedIndex()>0)
            {
                this.cmboBebidaD.setModel(new DefaultComboBoxModel(this.obtenerDescripcionBebida(this.cmboBebidaC.getSelectedItem().toString())));
            }
        }
    }//GEN-LAST:event_cmboBebidaCItemStateChanged

    private void txtPrecioBebidaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioBebidaKeyTyped
        char c = evt.getKeyChar();
        if((c<'0' || c>'9') ) evt.consume();
    }//GEN-LAST:event_txtPrecioBebidaKeyTyped

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        btnNuevaBebida.setEnabled(true);
        limpiar();
           btnGuardar.setEnabled(false);
        btnEliminar.setEnabled(false);
        txtSearch.setVisible(false);
    
   btnModificar.setEnabled(false);
    
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnNuevaBebidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaBebidaActionPerformed
         cmboBebidaC.setEnabled(true);
        cmboBebidaD.setEnabled(true);
        txtPrecioBebida.setEnabled(true); 
        m = true;
        limpiar();
        btnGuardar.setVisible(true);
        btnCancelar.setVisible(true);
        btnCancelar.setEnabled(true);
        btnGuardar.setEnabled(true);
    }//GEN-LAST:event_btnNuevaBebidaActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try {
            int fila = tablaBebida.getSelectedRow();
            String sql = "DELETE FROM bebidas WHERE codigo_bebida = "+tablaBebida.getValueAt(fila,0);
            sent=conn.createStatement();
            int n = sent.executeUpdate(sql);
            if(n>0){
                llenartabla("");
                JOptionPane.showMessageDialog(null,"DATOS ELIMINADOS");
                limpiar();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ERROR"+e.getMessage());
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        try {
             int fila = tablaBebida.getSelectedRow();
            String sql = "UPDATE bebidas set clasificacion=?,descripcion=?,precio=? WHERE codigo_bebida = "+tablaBebida.getValueAt(fila,0);
           
           
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1,cmboBebidaC.getSelectedItem().toString());
            ps.setString(2,cmboBebidaD.getSelectedItem().toString());
            ps.setString(3,txtPrecioBebida.getText());
            
       
            int n = ps.executeUpdate();
            if (n>0){
                limpiar();
                llenartabla("");
                JOptionPane.showMessageDialog(null,"Datos modificados");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
       try {
            String sql = "INSERT INTO bebidas(clasificacion,descripcion,precio)"+"VALUES(?,?,?)";
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1,this.cmboBebidaC.getSelectedItem().toString());
            ps.setString(2,this.cmboBebidaD.getSelectedItem().toString());
            ps.setString(3,txtPrecioBebida.getText());
            int n=ps.executeUpdate();
            if(n>0){
                JOptionPane.showMessageDialog(null,"DATOS GUARDADOS");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ERROR AL GUARDAR"+ e.getMessage());
        }
        llenartabla("");
        limpiar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        btnModificar.setEnabled(true);
  
        txtSearch.setVisible(true);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void tablaBebidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaBebidaMouseClicked
     
        
                
        if (evt.getButton()==1){
            try {
                 btnModificar.setEnabled(true);
        btnModificar.setVisible(true);
        btnCancelar.setEnabled(true);
        btnEliminar.setVisible(true);
        btnEliminar.setEnabled(true);
        btnNuevaBebida.setEnabled(false);
        btnGuardar.setEnabled(false);
                int fila = tablaBebida.getSelectedRow();
                String sql = "SELECT * FROM bebidas WHERE codigo_bebida="+tablaBebida.getValueAt(fila,0);
                sent=conn.createStatement();
                ResultSet rs = sent.executeQuery(sql);
                rs.next();
                cmboBebidaC.setSelectedItem(rs.getString("clasificacion"));
                cmboBebidaD.setSelectedItem(rs.getString("descripcion"));
                txtPrecioBebida.setText(rs.getString("precio"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_tablaBebidaMouseClicked

    private void cmboBebidaDItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmboBebidaDItemStateChanged
        if (m==false){
        btnModificar.setVisible(true);
        btnModificar.setEnabled(true);
        btnEliminar.setVisible(true);
        btnEliminar.setEnabled(true);
        }
    }//GEN-LAST:event_cmboBebidaDItemStateChanged

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        llenartabla(txtSearch.getText());
    }//GEN-LAST:event_txtSearchKeyReleased

    private void cmboBebidaDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmboBebidaDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmboBebidaDActionPerformed

    private void btnRegresar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegresar1ActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        MenuPrinc obj = new MenuPrinc();
        obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void cmboBebidaCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmboBebidaCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmboBebidaCActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

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
            java.util.logging.Logger.getLogger(PedidoBebida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PedidoBebida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PedidoBebida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PedidoBebida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PedidoBebida().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevaBebida;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnRegresar1;
    private javax.swing.JComboBox cmboBebidaC;
    private javax.swing.JComboBox cmboBebidaD;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaBebida;
    private javax.swing.JTextField txtPrecioBebida;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
