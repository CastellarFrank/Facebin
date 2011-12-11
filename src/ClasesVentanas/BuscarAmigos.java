/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * BuscarAmigos.java
 *
 * Created on 12-04-2011, 01:58:06 AM
 */
package ClasesVentanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author NIGHTMARE
 */
public class BuscarAmigos extends javax.swing.JFrame {
    java.awt.Dimension tamañoPantalla=Toolkit.getDefaultToolkit().getScreenSize();
    String userEncontrado="";
    String usuarioLogueado="";

    /** Creates new form BuscarAmigos */
    public BuscarAmigos(String correo) {
        initComponents();
        usuarioLogueado=correo;
        this.setSize(450,350);
        this.setVisible(true);
        this.setLocation((tamañoPantalla.width/2)-(this.getWidth()/2),(tamañoPantalla.height/2)-(this.getHeight()/2));
        ocultarElementos();
        panelLabels();
    }
    private void amigoEncontrado(){
        this.lblImagenPerfil.setVisible(true);
        this.btnEnviarSolicitud.setVisible(true);
        this.lblFecha.setVisible(true);
        this.lblGenero.setVisible(true);
        this.lblNombre.setVisible(true);
        this.elementosPosicionAnormal();
    }
    private void ocultarElementos(){
        this.lblImagenPerfil.setVisible(false);
        this.btnEnviarSolicitud.setVisible(false);
        this.lblFecha.setVisible(false);
        this.lblGenero.setVisible(false);
        this.lblNombre.setVisible(false);
    }
    private boolean buscarCorreo(String correo){
            try {
                ControlVentanas.configArchivoPerfil(correo);
                if(!ControlVentanas.file.exists())
                    return false;
                ControlVentanas.crearRandom();
                String n=ControlVentanas.registros.readUTF();
                char g=ControlVentanas.registros.readChar();
                ControlVentanas.registros.readLong();
                ControlVentanas.registros.readUTF();
                long f=ControlVentanas.registros.readLong(); 
                ControlVentanas.registros.readInt();
                String p=ControlVentanas.registros.readUTF();
                ControlVentanas.registros.close();
                setDatos(p,n,g,f);
                this.userEncontrado=correo;
                return true;                
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            
        try {
            ControlVentanas.registros.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        lblImagenPerfil = new javax.swing.JLabel();
        lblGenero = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        btnEnviarSolicitud = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Celtic Garamond the 2nd", 1, 18));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Busqueda de Amigos");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(90, 20, 230, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel2.setText("Ingrese el correo: ");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(90, 120, 120, 15);

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
        txtCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCorreoKeyPressed(evt);
            }
        });
        getContentPane().add(txtCorreo);
        txtCorreo.setBounds(90, 140, 230, 20);

        lblImagenPerfil.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(lblImagenPerfil);
        lblImagenPerfil.setBounds(40, 130, 70, 80);

        lblGenero.setText("Genero");
        getContentPane().add(lblGenero);
        lblGenero.setBounds(290, 210, 50, 14);

        lblNombre.setText("Nombre");
        getContentPane().add(lblNombre);
        lblNombre.setBounds(290, 180, 50, 14);

        lblFecha.setText("Fecha");
        getContentPane().add(lblFecha);
        lblFecha.setBounds(290, 240, 50, 14);

        btnEnviarSolicitud.setText("Enviar Solicitud");
        btnEnviarSolicitud.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEnviarSolicitudMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEnviarSolicitudMouseEntered(evt);
            }
        });
        btnEnviarSolicitud.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnEnviarSolicitudKeyPressed(evt);
            }
        });
        getContentPane().add(btnEnviarSolicitud);
        btnEnviarSolicitud.setBounds(150, 240, 140, 23);

        btnBuscar.setText("Buscar");
        btnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBuscarMouseEntered(evt);
            }
        });
        btnBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnBuscarKeyPressed(evt);
            }
        });
        getContentPane().add(btnBuscar);
        btnBuscar.setBounds(170, 200, 80, 23);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-416)/2, (screenSize.height-338)/2, 416, 338);
    }// </editor-fold>//GEN-END:initComponents

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void btnBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseClicked
        if(!this.buscarCorreo(this.txtCorreo.getText())){
            JOptionPane.showMessageDialog(null, "No existe un usuario con ese correo","Correo inválido",JOptionPane.INFORMATION_MESSAGE);
            this.txtCorreo.requestFocus();
            this.txtCorreo.selectAll();
        }else{
            this.amigoEncontrado();
        }
    }//GEN-LAST:event_btnBuscarMouseClicked

    private void txtCorreoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreoKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if(this.lblImagenPerfil.isVisible()){
                this.btnEnviarSolicitudMouseClicked(null);
            }else{
                this.btnBuscarMouseClicked(null);
            }
        }
    }//GEN-LAST:event_txtCorreoKeyPressed

    private void btnEnviarSolicitudMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnviarSolicitudMouseClicked
        ControlVentanas.agregarCuentasActivas();
        if(!ControlVentanas.face.miCorreoExisteEnEsteUsuario(this.userEncontrado)){
            if(!ControlVentanas.face.buscarEnLosAmigos(userEncontrado, 0)){
                if(!userEncontrado.equals(this.usuarioLogueado)){
                    if(this.enviarSolicitud(userEncontrado)){                    
                        JOptionPane.showMessageDialog(null, "Su solicitud ha sido enviada con exito", "Solicitud enviada", JOptionPane.INFORMATION_MESSAGE);
                        ControlVentanas.face.configArrayFriends(this.usuarioLogueado);
                    }else{
                        JOptionPane.showMessageDialog(null, "Error al enviar la solicitud", "Error", JOptionPane.INFORMATION_MESSAGE);
                    }   
                }else{
                    JOptionPane.showMessageDialog(null, "No puedes agregarte a ti mismo como amigo", "Eres tú mismo (ForeverAlone)", JOptionPane.INFORMATION_MESSAGE);
                }            
            }else{
                JOptionPane.showMessageDialog(null, "El usuario ya es uno de tus amigos o ya has recibido una invitación de este usuario", "El amigo ya existe", JOptionPane.INFORMATION_MESSAGE);
            }        
        }else{
            JOptionPane.showMessageDialog(null, "El usuario ya es uno de tus amigos o ya has enviado una solicitud a este usuario", "Si no es tu amigo, te está ignorando", JOptionPane.INFORMATION_MESSAGE);
        }
        this.txtCorreo.requestFocus();
        this.txtCorreo.selectAll();
    }//GEN-LAST:event_btnEnviarSolicitudMouseClicked

    private void btnBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnBuscarKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            this.btnBuscarMouseClicked(null);
        }
    }//GEN-LAST:event_btnBuscarKeyPressed

    private void btnEnviarSolicitudKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnEnviarSolicitudKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            this.btnEnviarSolicitudMouseClicked(null);
        }
    }//GEN-LAST:event_btnEnviarSolicitudKeyPressed

    private void btnBuscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseEntered
        this.btnBuscar.setForeground(Color.red);
        this.setCursor(Cursor.HAND_CURSOR);
    }//GEN-LAST:event_btnBuscarMouseEntered

    private void btnEnviarSolicitudMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnviarSolicitudMouseEntered
        this.btnEnviarSolicitud.setForeground(Color.red);
        this.setCursor(Cursor.HAND_CURSOR);
    }//GEN-LAST:event_btnEnviarSolicitudMouseEntered

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        this.btnBuscar.setForeground(null);
        this.btnEnviarSolicitud.setForeground(null);
        this.setCursor(null);
    }//GEN-LAST:event_formMouseEntered

    private void txtCorreoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCorreoFocusGained
        this.txtCorreo.selectAll();
    }//GEN-LAST:event_txtCorreoFocusGained

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEnviarSolicitud;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblGenero;
    private javax.swing.JLabel lblImagenPerfil;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JTextField txtCorreo;
    // End of variables declaration//GEN-END:variables

    private void setDatos(String p, String n, char g, long f) {
        this.cambiarImagen(p);
        Date fecha=new Date(f);
        SimpleDateFormat formato=new SimpleDateFormat("dd/MM/yyyy");
        String fechaF=formato.format(fecha);
        this.lblNombre.setText("Nombre: "+n);
        this.lblGenero.setText("Genero: "+(g=='M'?"Masculino":"Femenino"));
        this.lblFecha.setText("Fecha Ingreso: "+fechaF);
        
    }
    private void cambiarImagen(String path){
        ImageIcon imagen=new ImageIcon(path);
        this.lblImagenPerfil.setSize(110, 120);
        this.lblImagenPerfil.setLocation(65,130);
        ImageIcon foto=new ImageIcon(imagen.getImage().getScaledInstance(this.lblImagenPerfil.getWidth(), this.lblImagenPerfil.getHeight(), Image.SCALE_DEFAULT));        
        this.lblImagenPerfil.setIcon(foto);  
    }
    private void elementosPosicionNormal(){
        this.jLabel1.setLocation((this.getWidth()/2)-(this.jLabel1.getWidth()/2), 20);
        this.jLabel2.setLocation((this.getWidth()/2)-(this.txtCorreo.getWidth()/2), 110);
        this.txtCorreo.setLocation((this.getWidth()/2)-(this.txtCorreo.getWidth()/2),130);
        this.btnBuscar.setLocation((this.getWidth()/2)-(this.btnBuscar.getWidth()/2), 210);
    }
    private void elementosPosicionAnormal(){
        this.jLabel2.setLocation((this.getWidth()/2)-(this.txtCorreo.getWidth()/2)-45, 60);
        this.txtCorreo.setLocation((this.getWidth()/2)-(this.txtCorreo.getWidth()/2)-45,80);
        this.btnBuscar.setLocation((this.getWidth()/2)-(this.btnBuscar.getWidth()/2)+115, 77);
    }
    private void panelLabels(){
         elementosPosicionNormal();
         Container panel=new Container();
         panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
         panel.add(this.lblNombre, BorderLayout.CENTER);
         panel.add(Box.createRigidArea(new Dimension(10,10)));
         panel.add(this.lblGenero, BorderLayout.CENTER);
         panel.add(Box.createRigidArea(new Dimension(10,10)));
         panel.add(this.lblFecha, BorderLayout.CENTER);
         this.btnEnviarSolicitud.setLocation(220,220);
         this.add(panel);
         panel.setBounds(210,130,200,200);
    }
    private boolean enviarSolicitud(String correo){
        ControlVentanas.configArchivoAmigos(correo);
        ControlVentanas.crearRandom();
        try {
            ControlVentanas.registros.seek(ControlVentanas.registros.length());
            ControlVentanas.registros.writeUTF(this.usuarioLogueado);
            ControlVentanas.registros.writeBoolean(false);
            ControlVentanas.registros.writeBoolean(false);
            ControlVentanas.registros.close();
            return true;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        try {
            ControlVentanas.registros.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
