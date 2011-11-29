package ClasesVentanas;


import Adornos.mipanel;
import Adornos.panelFondoPrincipal;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

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
        this.setVisible(true);
        this.setTitle(t);
        this.setSize(1200,668);
        this.setLocation(((tamañoPantalla.width/2)-((1200)/2)), ((tamañoPantalla.height/2)-((668)/2)));
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1200, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 638, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
