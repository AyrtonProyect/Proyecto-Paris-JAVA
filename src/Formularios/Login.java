/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import java.awt.Dimension;
import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {
static String nombreA;
 private static Connection conn;
 private static Statement st;

            
    public Login() {
        initComponents();
        this.setLocationRelativeTo(null);
       
      
    }
    void posicion(){
    this.setSize(638,339);
          this.setMinimumSize(new Dimension(638,339));
    
       
        this.setLocationRelativeTo(null); 
}

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_prin = new javax.swing.JPanel();
        txt_usuario = new javax.swing.JTextField();
        txt_contra = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btn_iniciar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LOGIN - RESTAURANTE PARIS");
        setPreferredSize(new java.awt.Dimension(649, 356));
        setResizable(false);

        panel_prin.setBackground(new java.awt.Color(255, 255, 255));
        panel_prin.setForeground(new java.awt.Color(51, 51, 51));
        panel_prin.setLayout(null);
        panel_prin.add(txt_usuario);
        txt_usuario.setBounds(280, 70, 180, 30);

        txt_contra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_contraActionPerformed(evt);
            }
        });
        panel_prin.add(txt_contra);
        txt_contra.setBounds(280, 120, 180, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("USUARIO");
        panel_prin.add(jLabel2);
        jLabel2.setBounds(180, 70, 110, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("CONTRASEÑA");
        panel_prin.add(jLabel3);
        jLabel3.setBounds(170, 110, 110, 50);

        btn_iniciar.setBackground(new java.awt.Color(255, 255, 255));
        btn_iniciar.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        btn_iniciar.setForeground(new java.awt.Color(255, 255, 255));
        btn_iniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Botones/open.png"))); // NOI18N
        btn_iniciar.setText("INGRESAR");
        btn_iniciar.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        btn_iniciar.setContentAreaFilled(false);
        btn_iniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_iniciarActionPerformed(evt);
            }
        });
        panel_prin.add(btn_iniciar);
        btn_iniciar.setBounds(490, 90, 120, 37);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/usuarioingreso.png"))); // NOI18N
        jLabel5.setText("jLabel5");
        panel_prin.add(jLabel5);
        jLabel5.setBounds(50, 50, 130, 120);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Captura de pantalla (4).png"))); // NOI18N
        panel_prin.add(jLabel1);
        jLabel1.setBounds(0, 0, 650, 358);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_prin, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_prin, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_iniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_iniciarActionPerformed
  String nom = txt_usuario.getText();
        String pas = txt_contra.getText();

        if ((nom.equals("Administrador")) && (pas.equals("admin"))) {
            nombreA = "Administrador";
            MenuPrinc op = new MenuPrinc();
            op.setVisible(true);
            op.setLocationRelativeTo(null);
            this.dispose();
             JOptionPane.showMessageDialog(null, "Bievenido Administrador!!");
        

        } else if ((nom.equals("Cajero")) && (pas.equals("12345"))) {
            nombreA = "Cajero";
            MenuPrinc op = new MenuPrinc();
            op.setVisible(true);
            op.setLocationRelativeTo(null);
            this.dispose();
            txt_contra.requestFocus();
             op.REGISTRAR.setEnabled(false);
            op.CATEGORIA.setEnabled(false);
            
         
            JOptionPane.showMessageDialog(null, "Bievenido al Sistema!!");
        
            } else {
                JOptionPane.showMessageDialog(null, "Datos incorrectos, Verifique nuevamente.");
            }

 
    }//GEN-LAST:event_btn_iniciarActionPerformed

    private void txt_contraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_contraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_contraActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_iniciar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel panel_prin;
    private javax.swing.JPasswordField txt_contra;
    private javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables

}

