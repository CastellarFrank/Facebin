/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Adornos;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author NIGHTMARE
 */
public class panelModificarInfo extends javax.swing.JPanel {
    public panelModificarInfo(){
        this.setSize(450,320);
    }
    
    @Override
    public void paint(Graphics g){
        Dimension tamanio = getSize();
        System.out.println(getClass().getResource("modificarInformacion.jpg"));
        ImageIcon imagenFondo = new ImageIcon(getClass().getResource("modificarInformacion.jpg"));        
        g.drawImage(imagenFondo.getImage(),0,0,tamanio.width, tamanio.height, null);      
        setOpaque(false);
        super.paintComponent(g);
    }  
    
}
