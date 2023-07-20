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

public class PedidoPlato extends javax.swing.JFrame {

    DefaultTableModel model;
    Connection conn;
     Statement st;
    
    public PedidoPlato() {
        initComponents();
        limitarPrecio();
     
           
        conn=conectar_db.conectar_a_baseded();
        //----------------
        cmboPlatoC.setEnabled(false);
        cmboPlatoD.setEnabled(false);
        txtPrecioPlato.setEnabled(false);
        //----------------
        this.setLocationRelativeTo(null);
        btnGuardar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnModificar.setEnabled(false);
          btnEliminar.setEnabled(false);
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

   public String[] obtenerDescripcion(String clasificacion)
    {
        String[] descripcion = new String[5];
        if(clasificacion.equalsIgnoreCase("CHILAQUILES"))
        {
            descripcion[0] = "SENCILLOS";
            descripcion[1] = "CON POLLO";
            descripcion[2] = "CON HUEVO";
     
        }
        
        if(clasificacion.equalsIgnoreCase("ENFRIJOLADAS"))
        {
            descripcion[0] = "SENCILLAS";
            descripcion[1] = "DE LA CASA";
            descripcion[2] = "CAMPESINAS";
            
        }if(clasificacion.equalsIgnoreCase("HAMBURGUESAS"))
        {
            descripcion[0] = "SENCILLA";
            descripcion[1] = "HAWAIANA";
            descripcion[2] = "DOBLE CARNE";
            
        } if(clasificacion.equalsIgnoreCase("ENSALADAS"))
        {
            descripcion[0] = "ENSALADA DE POLLO";
            descripcion[1] = "ENSALADA DE ATUN";
            descripcion[2] = "ENSALADA DE LA CASA";
    
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
  
   
 
void limpiarPlato(){
    cmboPlatoC.setSelectedItem("SELECCIONE UNA OPCION");
    cmboPlatoC.setSelectedItem("");
    txtPrecioPlato.setText(null);
}
    void limitarPrecio(){
        RestrictedTextField r = new RestrictedTextField(txtPrecioPlato);
        r.setLimit(5);
        r.setOnlyNums(true);
    }
void llenartabla(String valor){
    try {
         conn=conectar_db.conectar_a_baseded();
        String[]titulos={"CODIGO_PLATO","CLASIFICACION","DESCRIPCION","PRECIO"};
        String sql = "SELECT * FROM plato WHERE CONCAT (clasificacion,' ', descripcion) LIKE '%" + valor + "%'";
        model=new DefaultTableModel(null,titulos);
        st=conn.createStatement();
        ResultSet rs= st.executeQuery(sql);
        String fila [] = new String [4];
        while(rs.next()){
            fila[0]=rs.getString("CODIGO_PLATO");
            fila[1]=rs.getString("CLASIFICACION");
            fila[2]=rs.getString("DESCRIPCION");
            fila[3]=rs.getString("PRECIO");
            model.addRow(fila);
        }        
        tablaPlatos.setModel(model);
    } catch (Exception e) {
        e.printStackTrace();
    }
}

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtPrecioPlato = new javax.swing.JTextField();
        cmboPlatoC = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        cmboPlatoD = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPlatos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnRegresar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PLATOS_RESTAURANTE PARIS");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("PRECIO");

        txtPrecioPlato.setFont(new java.awt.Font("BatangChe", 1, 24)); // NOI18N
        txtPrecioPlato.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPrecioPlato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioPlatoActionPerformed(evt);
            }
        });
        txtPrecioPlato.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioPlatoKeyTyped(evt);
            }
        });

        cmboPlatoC.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cmboPlatoC.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECCIONE UNA OPCION", "Chilaquiles", "Enfrijoladas", "Hamburguesas", "Ensaladas", " " }));
        cmboPlatoC.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmboPlatoCItemStateChanged(evt);
            }
        });
        cmboPlatoC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmboPlatoCActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("DESCRIPCION");

        cmboPlatoD.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        cmboPlatoD.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmboPlatoDItemStateChanged(evt);
            }
        });
        cmboPlatoD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmboPlatoDActionPerformed(evt);
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cmboPlatoD, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrecioPlato, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmboPlatoC, 0, 182, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmboPlatoC, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmboPlatoD, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecioPlato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 210));

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/insertar.png"))); // NOI18N
        btnNuevo.setText("NUEVO");
        btnNuevo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnNuevo.setBorderPainted(false);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        getContentPane().add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, 120, 50));

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/save.png"))); // NOI18N
        btnGuardar.setText("GUARDAR");
        btnGuardar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnGuardar.setBorderPainted(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, 120, 50));

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/edit.png"))); // NOI18N
        btnModificar.setText("MODIFICAR");
        btnModificar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnModificar.setBorderPainted(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        getContentPane().add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 200, 120, 50));

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
        getContentPane().add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 260, 167, 31));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/preview_search.png"))); // NOI18N
        jButton1.setText("BUSCAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 200, 120, 50));

        tablaPlatos.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaPlatos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tablaPlatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPlatosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaPlatos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 620, 120));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("REGISTRO DE PLATOS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 250, 30));

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

    private void txtPrecioPlatoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioPlatoKeyTyped
        char c = evt.getKeyChar();
        if((c<'0' || c>'9') ) evt.consume();
    }//GEN-LAST:event_txtPrecioPlatoKeyTyped

    private void cmboPlatoCItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmboPlatoCItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED)
        {
            if(this.cmboPlatoC.getSelectedIndex()>0)
            {
                this.cmboPlatoD.setModel(new DefaultComboBoxModel(this.obtenerDescripcion(this.cmboPlatoC.getSelectedItem().toString())));
            }
        }
    }//GEN-LAST:event_cmboPlatoCItemStateChanged

    private void cmboPlatoDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmboPlatoDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmboPlatoDActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
         cmboPlatoC.setEnabled(true);
        cmboPlatoD.setEnabled(true);
        txtPrecioPlato.setEnabled(true);
        limpiarPlato();
        btnGuardar.setVisible(true);
        btnCancelar.setEnabled(true);
        btnCancelar.setVisible(true);
        btnGuardar.setEnabled(true);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        try {
            int fila = tablaPlatos.getSelectedRow();
            String sql = "UPDATE plato SET clasificacion=?,descripcion=?,precio=?WHERE codigo_plato = "+tablaPlatos.getValueAt(fila,0);
            
            
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1,cmboPlatoC.getSelectedItem().toString());
            ps.setString(2,cmboPlatoD.getSelectedItem().toString());
            ps.setString(3,txtPrecioPlato.getText());
         
            int n = ps.executeUpdate();
            if(n>0 ){
                limpiarPlato();
                llenartabla("");
                JOptionPane.showMessageDialog(null,"DATOS MODIFICADOS");
                
            }
            
        } catch (Exception e) {
        JOptionPane.showMessageDialog(null,"error"+e.getMessage());
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
          try {
            int fila = tablaPlatos.getSelectedRow();
            String sql = "DELETE FROM plato WHERE codigo_plato = "+tablaPlatos.getValueAt(fila,0);
            st=conn.createStatement();
            int n = st.executeUpdate(sql);
            if(n>0){
                llenartabla("");
                JOptionPane.showMessageDialog(null,"DATOS ELIMINADOS");
                limpiarPlato();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ERROR"+e.getMessage());
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
    
        limpiarPlato();
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
            String sql = "INSERT INTO plato(clasificacion,descripcion,precio)"+"VALUES(?,?,?)";
            PreparedStatement ps = conn.prepareCall(sql);
            //STRING VARIABLE = NOMBRECOMBO.GETSELECTEDITEM().TOSTRING();
           // String combo1 = this.cmboPlatoC.getSelectedItem().toString();
            //String combo2=this.cmboPlatoD.getSelectedItem().toString();
           // ps.setString(1,txtnombre.getText());
            ps.setString(1,this.cmboPlatoC.getSelectedItem().toString());
            ps.setString(2,this.cmboPlatoD.getSelectedItem().toString());
            ps.setString(3,txtPrecioPlato.getText());
            int n=ps.executeUpdate();
            if(n>0){
                JOptionPane.showMessageDialog(null,"DATOS GUARDADOS");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ERROR AL GUARDAR"+ e.getMessage());
        }
        llenartabla("");
        limpiarPlato();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void tablaPlatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPlatosMouseClicked
        if (evt.getButton()==1){
            btnModificar.setEnabled(true);
            btnEliminar.setEnabled(true);
            btnCancelar.setEnabled(true);
            btnNuevo.setEnabled(false);
            try{
            
            int fila=tablaPlatos.getSelectedRow();
            String sql = "SELECT * FROM plato WHERE codigo_plato="+tablaPlatos.getValueAt(fila,0);
            st=conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            cmboPlatoC.setSelectedItem(rs.getString("clasificacion"));
            cmboPlatoD.setSelectedItem(rs.getString("descripcion"));
            txtPrecioPlato.setText(rs.getString("precio"));
            }catch(Exception e ){
              e.printStackTrace();  
            }
            
        }
    }//GEN-LAST:event_tablaPlatosMouseClicked

    private void cmboPlatoDItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmboPlatoDItemStateChanged
        btnModificar.setVisible(true);
        btnModificar.setEnabled(true);
        btnEliminar.setVisible(true);
        btnEliminar.setEnabled(true);
   
    }//GEN-LAST:event_cmboPlatoDItemStateChanged

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
           try{
           String sql = "SELECT * FROM plato WHERE clasificacion= " + txtSearch.getText();
            PreparedStatement ps = conn.prepareCall(sql);
            ps.executeQuery();
       } catch(Exception e){
           
       }
    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        llenartabla(txtSearch.getText());
    }//GEN-LAST:event_txtSearchKeyReleased

    private void txtPrecioPlatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioPlatoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioPlatoActionPerformed

    private void cmboPlatoCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmboPlatoCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmboPlatoCActionPerformed

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
            java.util.logging.Logger.getLogger(PedidoPlato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PedidoPlato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PedidoPlato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PedidoPlato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PedidoPlato().setVisible(true);
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
    private javax.swing.JComboBox cmboPlatoC;
    private javax.swing.JComboBox cmboPlatoD;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaPlatos;
    private javax.swing.JTextField txtPrecioPlato;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
