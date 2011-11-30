package ClasesVentanas;



import Adornos.panelFondoPrincipal;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.Border;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FaceMain.java
 *
 * Created on 11-21-2011, 02:10:03 PM
 */
/**
 *
 * @author NIGHTMARE
 */
public class FaceMain extends javax.swing.JFrame {
    java.awt.Dimension tamañoPantalla=Toolkit.getDefaultToolkit().getScreenSize();
    /** Creates new form FaceMain */
    public FaceMain(String t) {
        
        initComponents();
        
        Container panel=new Container();
        panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
          
          
        JLabel lb=new JLabel("Hola");
          
        JLabel lb1=new JLabel ("Hola feos");
        panel.add(lb,BorderLayout.CENTER);
        panel.add(lb1,BorderLayout.CENTER);
        panel.setBounds(0, 100, 120, 150);
        
        this.add(panel);
        this.setVisible(true);
        this.setTitle(t);
        this.setResizable(false);
        this.setSize(1200,668);
        this.setLocation(((tamañoPantalla.width/2)-((1200)/2)), ((tamañoPantalla.height/2)-((668)/2))-20);
        configurarElementos();
        formWindowOpened(null);
        
    }
    
   private void formWindowOpened(WindowEvent evt) {
        panelFondoPrincipal p = new panelFondoPrincipal();
        this.add( p , BorderLayout.CENTER);
        p.repaint();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtImagenPerfil = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        txtImagenPerfil.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(txtImagenPerfil);
        txtImagenPerfil.setBounds(70, 64, 150, 150);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel txtImagenPerfil;
    // End of variables declaration//GEN-END:variables

    private void configurarElementos() {        
        ImageIcon imagen=new ImageIcon("src/Adornos/user.png");
        ImageIcon foto=new ImageIcon(imagen.getImage().getScaledInstance(this.txtImagenPerfil.getWidth(), this.txtImagenPerfil.getHeight(), Image.SCALE_DEFAULT));
        this.txtImagenPerfil.setIcon(foto);
        
    }
}
