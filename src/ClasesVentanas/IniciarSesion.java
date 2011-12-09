package ClasesVentanas;


import Adornos.mipanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * IniciarSesion.java
 *
 * Created on 11-21-2011, 01:54:46 PM
 */
/**
 *
 * @author NIGHTMARE
 */
public class IniciarSesion extends javax.swing.JFrame {
    String email;
    static java.awt.Dimension tamañoPantalla=Toolkit.getDefaultToolkit().getScreenSize();
    /** Creates new form IniciarSesion */
    
    public IniciarSesion(String correo){
        initComponents();
        this.setTitle("FACEBIN");
        this.setResizable(false);
        this.setVisible(true);
        this.setSize(500, 400);
        definirPosicionCentral();
        formWindowOpened(null);
        this.txtCorreo.setText(correo);
        this.txtContraseña.requestFocus();
        
    }
    public IniciarSesion(){
        initComponents();
        this.setTitle("FACEBIN");
        this.setResizable(false);
        this.setVisible(true);
        this.setSize(500, 400);
        definirPosicionCentral();
        formWindowOpened(null);       
    }
    
    private void formWindowOpened(WindowEvent evt) {
        mipanel p = new mipanel();
        this.add( p , BorderLayout.CENTER);
        p.repaint();
    }
    
    public void definirPosicionCentral(){
        this.setLocation(((tamañoPantalla.width/2)-(250)),((tamañoPantalla.height/2)-200));
    }
    public boolean buscarRegistro(){
        String contra;
        try{
            ControlVentanas.configArchivoGerencia();
            ControlVentanas.crearRandom();
            ControlVentanas.registros.seek(0);
            while(ControlVentanas.registros.getFilePointer()<ControlVentanas.registros.length()){
                email=ControlVentanas.registros.readUTF();
                contra=ControlVentanas.registros.readUTF();
                boolean b=ControlVentanas.registros.readBoolean();
                if(email.equals(this.txtCorreo.getText()) && contra.equals(this.txtContraseña.getText()) && b){
                    ControlVentanas.registros.close();
                    return true;
                }
            }
            ControlVentanas.registros.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        
        return false;
    }
    public void setCorreo(String Correo){
        this.txtCorreo.setText(Correo);
        this.txtContraseña.requestFocus();
    }
    public void regresarRegistro(){
        this.setEnabled(true);
        definirPosicionCentral();
        this.toFront();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnEntrar = new javax.swing.JButton();
        txtContraseña = new javax.swing.JPasswordField();
        txtCorreo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
        });
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
                formWindowLostFocus(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowDeactivated(java.awt.event.WindowEvent evt) {
                formWindowDeactivated(evt);
            }
        });
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Cuenta de Correo: ");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel1.setFocusable(false);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Contraseña: ");

        btnEntrar.setText("Entrar");
        btnEntrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEntrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEntrarMouseEntered(evt);
            }
        });
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });
        btnEntrar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btnEntrarFocusGained(evt);
            }
        });
        btnEntrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnEntrarKeyPressed(evt);
            }
        });

        txtContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContraseñaActionPerformed(evt);
            }
        });
        txtContraseña.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtContraseñaFocusGained(evt);
            }
        });
        txtContraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtContraseñaKeyPressed(evt);
            }
        });

        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });
        txtCorreo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCorreoFocusGained(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel3.setForeground(new java.awt.Color(0, 51, 255));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel3MouseEntered(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(264, 264, 264)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtContraseña, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)))
                .addGap(143, 143, 143))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel1))
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(46, 46, 46)
                .addComponent(btnEntrar)
                .addGap(82, 82, 82)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-500)/2, (screenSize.height-400)/2, 500, 400);
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void btnEntrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntrarMouseClicked
        
        if(this.buscarRegistro()){
            ControlVentanas.crearFace(email);
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(null, "EL correo o la contraseña ingresadas son incorrectos","Datos Incorrectos",
                    JOptionPane.INFORMATION_MESSAGE);
            this.txtCorreo.requestFocus();
            this.txtCorreo.selectAll();
        }
        
    }//GEN-LAST:event_btnEntrarMouseClicked

private void txtContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContraseñaActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_txtContraseñaActionPerformed

private void btnEntrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnEntrarKeyPressed
    if(evt.getKeyCode()==KeyEvent.VK_ENTER){
        
     this.btnEntrarMouseClicked(null);            
    }
}//GEN-LAST:event_btnEntrarKeyPressed

private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
   
}//GEN-LAST:event_formKeyPressed

private void txtContraseñaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContraseñaKeyPressed
 if(evt.getKeyCode()==KeyEvent.VK_ENTER){
        
     this.btnEntrarMouseClicked(null);            
    }
}//GEN-LAST:event_txtContraseñaKeyPressed

private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        this.setLocation(((tamañoPantalla.width/2)-450),((tamañoPantalla.height/2)-200));
        ControlVentanas.crearRegistro();        
        ControlVentanas.registro.abrir();
        this.txtContraseña.setText("");
        this.setEnabled(false);
        ControlVentanas.registro.toFront();
    
}//GEN-LAST:event_jLabel3MouseClicked

private void btnEntrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntrarMouseEntered
    this.setCursor(Cursor.HAND_CURSOR);
    this.btnEntrar.setForeground(Color.red);
}//GEN-LAST:event_btnEntrarMouseEntered

private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
    this.setCursor(Cursor.DEFAULT_CURSOR);
    this.btnEntrar.setForeground(null);
}//GEN-LAST:event_formMouseEntered

private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
    this.setCursor(Cursor.HAND_CURSOR);
}//GEN-LAST:event_jLabel3MouseEntered

private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained

}//GEN-LAST:event_formFocusGained

private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus

}//GEN-LAST:event_formWindowGainedFocus

private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_txtCorreoActionPerformed

private void txtCorreoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCorreoFocusGained

}//GEN-LAST:event_txtCorreoFocusGained

private void txtContraseñaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtContraseñaFocusGained
    this.txtContraseña.selectAll();
}//GEN-LAST:event_txtContraseñaFocusGained

private void btnEntrarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnEntrarFocusGained
    
}//GEN-LAST:event_btnEntrarFocusGained

private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

}//GEN-LAST:event_formWindowActivated

private void formWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowLostFocus
}//GEN-LAST:event_formWindowLostFocus

private void formWindowDeactivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowDeactivated
}//GEN-LAST:event_formWindowDeactivated

private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_btnEntrarActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtCorreo;
    // End of variables declaration//GEN-END:variables
    

}
