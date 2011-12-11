/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SolicitudesAmigos.java
 *
 * Created on 12-09-2011, 05:49:52 PM
 */
package ClasesVentanas;

import Adornos.panelSolicitudAmistad;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

/**
 *
 * @author NIGHTMARE
 */
public class SolicitudesAmigos extends javax.swing.JFrame {
    Object objetos[][];
    int tamaño;
    Container contenedores[][];
    Container PanelPrincipal=new Container();
    JScrollPane scroll=new JScrollPane();

    /** Creates new form SolicitudesAmigos */
    public SolicitudesAmigos() {
        initComponents();
        this.setTitle("Solicitudes de Amistad");
        this.setSize(400, 570);
        this.setVisible(true);
        inicio();
        formWindowOpened(null);
    }
    private void formWindowOpened(WindowEvent evt) {
        panelSolicitudAmistad p = new panelSolicitudAmistad();
        this.add( p , BorderLayout.CENTER);
        p.repaint();
    }
    public void inicio(){
        tamaño=ControlVentanas.face.solicitudesAmigos.length;
        objetos=new Object[tamaño][5];
        contenedores=new Container[tamaño][4];
        crearElementos();
        addListeners();
    }
    public void crearElementos(){
        for(int i=0;i<objetos.length;i++){
            objetos[i][0]=new JLabel();
            objetos[i][1]=new JLabel();
            objetos[i][2]=new JLabel();
            objetos[i][3]=new JButton();
            objetos[i][4]=new JButton();
            configContenedores();
            ObtenerInfo(i);
        }
    }
    public void crearContenedores(){
        for(int i=0;i<contenedores.length;i++){
            contenedores[i][0]=new Container();
            contenedores[i][1]=new Container();
            contenedores[i][2]=new Container();
            contenedores[i][3]=new Container();
        }
    }
    public void configContenedores(){
        scroll.setBounds(20,20,350,500);
        this.PanelPrincipal.setLayout(new BoxLayout(PanelPrincipal,BoxLayout.PAGE_AXIS));
        crearContenedores();
        for(int i=0;i<contenedores.length;i++){
            contenedores[i][0].setLayout(new FlowLayout(FlowLayout.LEFT));
            contenedores[i][0].setSize(350, 100);
            contenedores[i][1].setLayout(new BoxLayout(contenedores[i][1],BoxLayout.PAGE_AXIS));
            contenedores[i][1].setSize(280, 100);
            contenedores[i][2].setLayout(new BoxLayout(contenedores[i][2],BoxLayout.X_AXIS));
            contenedores[i][2].setSize(280, 30);
            contenedores[i][3].setLayout(new BoxLayout(contenedores[i][3],BoxLayout.X_AXIS));
            contenedores[i][3].setSize(280, 30);        
        }
    }
    public void ObtenerInfo(int index){
        String correo=ControlVentanas.face.solicitudesAmigos[index];
        if(correo!=null){
            ControlVentanas.configArchivoPerfil(correo);
            ControlVentanas.crearRandom();
            try {
                ControlVentanas.registros.seek(0);
                String n=ControlVentanas.registros.readUTF();
                String g=(ControlVentanas.registros.readChar()=='M'?"Masculino":"Femenino");
                ControlVentanas.registros.readLong();
                ControlVentanas.registros.readUTF();
                ControlVentanas.registros.readLong();
                ControlVentanas.registros.readInt();
                String p=ControlVentanas.registros.readUTF();
                ControlVentanas.registros.close();
                configElementos(correo,n,g,p,index);            
            } catch (IOException ex) {
                ex.printStackTrace();
            }  
        }              
    }
    public void configElementos( String correo,String n,String g,String p,int i){
        ((JLabel)objetos[i][0]).setSize(70,80);
        ImageIcon imagen=new ImageIcon(p);
        ImageIcon foto=new ImageIcon(imagen.getImage().getScaledInstance(80,90,Image.SCALE_DEFAULT));        
        ((JLabel)objetos[i][0]).setIcon(foto);
        ((JLabel)objetos[i][0]).setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ((JLabel)objetos[i][1]).setText(n);
        ((JLabel)objetos[i][2]).setText(g);        
        ((JButton)objetos[i][3]).setText("Aceptar");        
        String nombre = new Integer(i).toString();
        nombre += new Integer(3).toString();
        ((JButton)objetos[i][3]).setActionCommand(nombre);
        ((JButton)objetos[i][4]).setText("Rechazar");
        String nombre1 = new Integer(i).toString();
        nombre += new Integer(4).toString();
        ((JButton)objetos[i][4]).setActionCommand(nombre1);
        colocarElementos(i);
    }
    public void colocarElementos(int i){
        this.PanelPrincipal.add(contenedores[i][0]);
        this.PanelPrincipal.add(Box.createRigidArea(new Dimension(0,20)));
        contenedores[i][0].add(Box.createRigidArea(new Dimension(20,0)));
        contenedores[i][0].add((JLabel)objetos[i][0]);
        contenedores[i][0].add(Box.createRigidArea(new Dimension(20,0)));
        contenedores[i][2].add((JLabel)objetos[i][1]);
        contenedores[i][2].add(Box.createRigidArea(new Dimension(20,0)));
        contenedores[i][2].add((JLabel)objetos[i][2]);
        contenedores[i][3].add((JButton)objetos[i][3]);
        contenedores[i][3].add(Box.createRigidArea(new Dimension(10,0)));
        contenedores[i][3].add((JButton)objetos[i][4]);
        contenedores[i][1].add(contenedores[i][2]);
        contenedores[i][1].add(Box.createRigidArea(new Dimension(0,20)));
        contenedores[i][1].add(contenedores[i][3]);
        contenedores[i][0].add(contenedores[i][1]);
        scroll.setBorder(null);
        scroll.setOpaque(false);
        scroll.getViewport().setOpaque(false);
        scroll.setViewportView(PanelPrincipal);
        this.add(scroll);
    }
    
   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-416)/2, (screenSize.height-608)/2, 416, 608);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables


    private void addListeners(){
        for(int i=0;i<contenedores.length;i++){
            final int num=i;
            ((JButton)objetos[i][3]).addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt){
                        if(cambiosSolicitud(num,true)){
                            JOptionPane.showMessageDialog(null,"Has agregado a un nuevo amigo","Solicitud confirmada",JOptionPane.INFORMATION_MESSAGE);
                        }
                        actualizar();
                    }
                });
            ((JButton)objetos[i][4]).addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt){
                        if(!cambiosSolicitud(num,false)){
                            JOptionPane.showMessageDialog(null,"Has rechazado la solicitud","Solicitud Rechazada",JOptionPane.INFORMATION_MESSAGE);
                        }
                        actualizar();
                    }
                });
                    
        }
    }
    public boolean cambiosSolicitud(int num,boolean b){
        String correo=ControlVentanas.face.solicitudesAmigos[num];
        ControlVentanas.configArchivoAmigos(ControlVentanas.face.usuarioLogueado);
        ControlVentanas.crearRandom();
        try {
            ControlVentanas.registros.seek(0);
            while(ControlVentanas.registros.getFilePointer()<ControlVentanas.registros.length()){
                String c=ControlVentanas.registros.readUTF();
                long puntero=ControlVentanas.registros.getFilePointer();
                ControlVentanas.registros.readBoolean();
                ControlVentanas.registros.readBoolean();
                if(c.equals(correo)){
                    ControlVentanas.registros.seek(puntero);
                    ControlVentanas.registros.writeBoolean(b);
                    ControlVentanas.registros.writeBoolean(true);
                }
            }
            ControlVentanas.registros.close();
            
        }catch(IOException ex){
            ex.printStackTrace();
        }
        if(b){
            escribirArchivoAmigoAceptado(correo);
            return true;
        }else{
            return false;
        }
    }
    public void escribirArchivoAmigoAceptado(String correo){
        ControlVentanas.configArchivoAmigos(correo);
        ControlVentanas.crearRandom();
        try {
            ControlVentanas.registros.seek(ControlVentanas.registros.length());
            ControlVentanas.registros.writeUTF(ControlVentanas.face.usuarioLogueado);
            ControlVentanas.registros.writeBoolean(true);
            ControlVentanas.registros.writeBoolean(true);
            ControlVentanas.registros.close();
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
    public void actualizar(){
        ControlVentanas.face.configArrayFriends(ControlVentanas.face.usuarioLogueado);
        ControlVentanas.face.clickVerPerfil();
        this.dispose();
        if(ControlVentanas.face.solicitudesAmigos[0]!=null){
            ControlVentanas.crearSolicitudAmigos();
        }
        
        
    }
}
