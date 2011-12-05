package ClasesVentanas;



import Adornos.panelFondoPrincipal;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

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
    String usuarioLogueado="";
    String estados="";
    String nombreUser="";
    boolean limite=false;
    /** Creates new form FaceMain */
    public FaceMain(String t,String correo){
        initComponents();
        usuarioLogueado=correo;
        nombreUser=this.getNombre(correo);
        configurarImagen();
        this.setTitle(t);        
        configurarFormPrincipal();
        configurarPrincipal();
        formWindowOpened(null);
    }
    public FaceMain(String t,String correo,String user){
        initComponents();
        usuarioLogueado=correo;
        nombreUser=user;
        configurarImagen();
        limite=true;
        this.setTitle(t);
        this.configurarFormFace();
        configurarVentanaEstados();
        publicarEstadosPrincipales(limite);
        this.configurarLabelsProfile();
        formWindowOpened(null);
        
    }
    private void configurarFormFace(){
        this.setVisible(true);
        this.setResizable(false);
        this.setSize(1200,668);
        this.setLocation(((tamañoPantalla.width/2)-((1200)/2)), ((tamañoPantalla.height/2)-((668)/2))-20);        
    }
    private void configurarFormPrincipal(){
        this.setVisible(true);
        this.setResizable(false);
        this.setSize(950,668);
        this.setLocation(((tamañoPantalla.width/2)-((950)/2)), ((tamañoPantalla.height/2)-((668)/2))-20);        
    }
    
   private void formWindowOpened(WindowEvent evt) {
        panelFondoPrincipal p = new panelFondoPrincipal();
        this.add( p , BorderLayout.CENTER);
        p.repaint();
    }
   private void configurarPanelIzquierdoPrincipal(){
       Container panel=new Container();
       this.lblTitulo.setLocation(600-(this.lblTitulo.getWidth()/2), 72);
       panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
       panel.add(this.jLabel2,BorderLayout.CENTER) ;
       panel.add(Box.createRigidArea(new Dimension(10,25)));
       panel.add(this.jLabel3,BorderLayout.CENTER) ;
       panel.add(Box.createRigidArea(new Dimension(10,25)));
       panel.add(this.jLabel4,BorderLayout.CENTER) ;
       panel.add(Box.createRigidArea(new Dimension(10,25)));
       panel.setBounds((250/2)-(120/2),200,130,200);
       this.add(panel);
       this.jLabel5.setVisible(false);
       this.jLabel6.setVisible(false);
       this.jLabel7.setVisible(false);
       this.jLabel8.setVisible(false);
   }
   private void configurarLabelsProfile(){
       Container panel=new Container();
       panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
       panel.add(this.jLabel5,BorderLayout.CENTER);
       panel.add(Box.createRigidArea(new Dimension(10,25)));
       panel.add(this.jLabel6,BorderLayout.CENTER);
       panel.add(Box.createRigidArea(new Dimension(10,25)));
       panel.add(this.jLabel7,BorderLayout.CENTER);
       panel.add(Box.createRigidArea(new Dimension(10,25)));
       panel.add(this.jLabel3,BorderLayout.CENTER);
       panel.add(Box.createRigidArea(new Dimension(10,25)));
       panel.add(this.jLabel4,BorderLayout.CENTER);
       panel.add(Box.createRigidArea(new Dimension(10,25)));
       panel.add(this.jLabel8,BorderLayout.CENTER);
       panel.setBounds((250/2)-(120/2),200,200,200);
       this.add(panel);
       this.lblTitulo.setText(nombreUser);     
       this.jLabel2.setVisible(false);
       this.lblTitulo.setLocation(600-(this.lblTitulo.getWidth()/2), 72);
   }
   private void configurarPrincipal(){
       configurarVentanaEstados();
       publicarEstadosPrincipales(limite);
       configurarPanelIzquierdoPrincipal();
   }
  
       
   
   private void configurarVentanaEstados(){
       this.jScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
       this.txtIngresarEstado.setBounds(400,170,315,20);
       btnInsertarEstado.setBounds(720, 169, 80, 23);
       this.jScrollPane1.setBounds((600)-(200),200,400,350);          
       this.txtEstados.setEditable(false);
   }
   public void agregarEstado(String estado){
       ControlVentanas.registro.agregarStatus(estado,usuarioLogueado,nombreUser);
   }
   public String getNombre(String correo){
        String n="";
        try {
            ControlVentanas.configArchivoPerfil(correo);
            ControlVentanas.crearRandom();
            ControlVentanas.registros.seek(0);
            n=ControlVentanas.registros.readUTF();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return n;
    }
   

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblImagenPerfil = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtEstados = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        txtIngresarEstado = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnInsertarEstado = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
        });
        getContentPane().setLayout(null);

        lblImagenPerfil.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblImagenPerfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblImagenPerfilMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblImagenPerfilMouseEntered(evt);
            }
        });
        getContentPane().add(lblImagenPerfil);
        lblImagenPerfil.setBounds(130, 60, 110, 120);

        txtEstados.setColumns(20);
        txtEstados.setEditable(false);
        txtEstados.setLineWrap(true);
        txtEstados.setRows(5);
        txtEstados.setWrapStyleWord(true);
        txtEstados.setFocusable(false);
        txtEstados.setRequestFocusEnabled(false);
        txtEstados.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                txtEstadosCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtEstadosInputMethodTextChanged(evt);
            }
        });
        jScrollPane1.setViewportView(txtEstados);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(430, 200, 440, 360);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel1.setText("Actualizar su estado: ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(400, 140, 190, 20);

        txtIngresarEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIngresarEstadoActionPerformed(evt);
            }
        });
        txtIngresarEstado.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtIngresarEstadoFocusGained(evt);
            }
        });
        getContentPane().add(txtIngresarEstado);
        txtIngresarEstado.setBounds(430, 170, 360, 20);

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 12));
        jLabel4.setText("Salir");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel4MouseEntered(evt);
            }
        });
        getContentPane().add(jLabel4);
        jLabel4.setBounds(130, 280, 80, 16);

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 12));
        jLabel3.setText("Cerrar Sesión");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel3MouseEntered(evt);
            }
        });
        getContentPane().add(jLabel3);
        jLabel3.setBounds(130, 250, 120, 16);

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 12));
        jLabel2.setText("Ver mi perfíl");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel2MouseEntered(evt);
            }
        });
        getContentPane().add(jLabel2);
        jLabel2.setBounds(130, 220, 110, 16);

        btnInsertarEstado.setText("Postear");
        btnInsertarEstado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInsertarEstadoMouseClicked(evt);
            }
        });
        getContentPane().add(btnInsertarEstado);
        btnInsertarEstado.setBounds(780, 170, 80, 23);

        lblTitulo.setFont(new java.awt.Font("Celtic Garamond the 2nd", 1, 36)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("HOME FEED");
        getContentPane().add(lblTitulo);
        lblTitulo.setBounds(430, 70, 450, 40);

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel5.setText("Home Feed");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel5MouseEntered(evt);
            }
        });
        getContentPane().add(jLabel5);
        jLabel5.setBounds(130, 310, 74, 16);

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel6.setText("Ver Solicitudes");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel6MouseEntered(evt);
            }
        });
        getContentPane().add(jLabel6);
        jLabel6.setBounds(130, 330, 160, 16);

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 12));
        jLabel7.setText("Buscar Amigos");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel7MouseEntered(evt);
            }
        });
        getContentPane().add(jLabel7);
        jLabel7.setBounds(130, 350, 160, 16);

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 12));
        jLabel8.setText("Mofificar Perfil");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel8MouseEntered(evt);
            }
        });
        getContentPane().add(jLabel8);
        jLabel8.setBounds(130, 370, 170, 16);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIngresarEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIngresarEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIngresarEstadoActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        this.dispose();
        ControlVentanas.crearFacePerfil(this.usuarioLogueado,this.nombreUser);
        
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
        this.setCursor(Cursor.HAND_CURSOR);
        this.jLabel2.setForeground(Color.red);
    }//GEN-LAST:event_jLabel2MouseEntered

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        this.setCursor(null);
        this.jLabel2.setForeground(Color.BLACK);
        this.jLabel3.setForeground(Color.BLACK);
        this.jLabel4.setForeground(Color.BLACK);
        this.jLabel5.setForeground(Color.BLACK);
        this.jLabel6.setForeground(Color.BLACK);
        this.jLabel7.setForeground(Color.BLACK);
        this.jLabel8.setForeground(Color.BLACK);
        
        
        
        
    }//GEN-LAST:event_formMouseEntered

    private void btnInsertarEstadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertarEstadoMouseClicked
        if(!this.txtIngresarEstado.getText().trim().equals("")){
            this.agregarEstado(this.txtIngresarEstado.getText());
            this.publicarEstadosPrincipales(limite);
            this.txtIngresarEstado.setText("");
            this.txtIngresarEstado.requestFocus();
        }else{
            JOptionPane.showMessageDialog(null, "Primero debe ingresar un texto","Sin texto",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnInsertarEstadoMouseClicked

    private void txtEstadosInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtEstadosInputMethodTextChanged
        
    }//GEN-LAST:event_txtEstadosInputMethodTextChanged

    private void txtEstadosCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtEstadosCaretPositionChanged

    }//GEN-LAST:event_txtEstadosCaretPositionChanged

    private void txtIngresarEstadoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIngresarEstadoFocusGained
        this.jScrollPane1.getViewport().setViewPosition(new Point(0,0));
    }//GEN-LAST:event_txtIngresarEstadoFocusGained

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
        this.setCursor(Cursor.HAND_CURSOR);
        this.jLabel3.setForeground(Color.red);
    }//GEN-LAST:event_jLabel3MouseEntered

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
        this.setCursor(Cursor.HAND_CURSOR);
        this.jLabel4.setForeground(Color.red);
    }//GEN-LAST:event_jLabel4MouseEntered

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        ControlVentanas.crearInicio(this.usuarioLogueado);
        this.dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void lblImagenPerfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImagenPerfilMouseClicked
            JFileChooser chooser= new JFileChooser();
            chooser.setDialogTitle("Foto Perfil");
            chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int opcion=chooser.showOpenDialog(this);
            String path="";
            if(opcion==0){
                path=chooser.getSelectedFile().getAbsolutePath();
                colocarImagenPerfil(path);
            }else{
                path="src/Adornos/user.png";
                colocarImagenPerfil(path);
            }
            guardarPathImagenPerfil(path);
            
    }//GEN-LAST:event_lblImagenPerfilMouseClicked

    private void lblImagenPerfilMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImagenPerfilMouseEntered
        this.setCursor(Cursor.HAND_CURSOR);
    }//GEN-LAST:event_lblImagenPerfilMouseEntered

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        ControlVentanas.crearFace(this.usuarioLogueado);
        this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked

    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseEntered
        this.setCursor(Cursor.HAND_CURSOR);
        this.jLabel7.setForeground(Color.red);
    }//GEN-LAST:event_jLabel7MouseEntered

    private void jLabel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseEntered
        this.setCursor(Cursor.HAND_CURSOR);
        this.jLabel6.setForeground(Color.red);
    }//GEN-LAST:event_jLabel6MouseEntered

    private void jLabel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseEntered
        this.setCursor(Cursor.HAND_CURSOR);
        this.jLabel8.setForeground(Color.red);
    }//GEN-LAST:event_jLabel8MouseEntered

    private void jLabel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseEntered
        this.setCursor(Cursor.HAND_CURSOR);
        this.jLabel5.setForeground(Color.red);
    }//GEN-LAST:event_jLabel5MouseEntered

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        ControlVentanas.abrirBusqueda();
    }//GEN-LAST:event_jLabel7MouseClicked

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInsertarEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblImagenPerfil;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextArea txtEstados;
    private javax.swing.JTextField txtIngresarEstado;
    // End of variables declaration//GEN-END:variables
    
    private String getImagenPerfil(){
        return ControlVentanas.registro.getPathImagen(this.usuarioLogueado);
    }
    private void configurarImagen() {
        this.lblImagenPerfil.setSize(110, 120);
        this.lblImagenPerfil.setLocation((256/2)-(110/2),38); 
        colocarImagenPerfil(getImagenPerfil());
    }
    private void colocarImagenPerfil(String path){
        ImageIcon imagen=new ImageIcon(path);
        ImageIcon foto=new ImageIcon(imagen.getImage().getScaledInstance(this.lblImagenPerfil.getWidth(), this.lblImagenPerfil.getHeight(), Image.SCALE_DEFAULT));        
        this.lblImagenPerfil.setIcon(foto);
    }
    public void publicarEstadosPrincipales(boolean lim){
        try {
            ControlVentanas.configArchivoEstados();
            ControlVentanas.crearRandom();
            if(ControlVentanas.registros.length()>0){
                ControlVentanas.registros.seek(0);
                estados="----------------------------------------------------------------------------------------------\n";
                imprimirEstadosPrincipales(lim);
                this.txtEstados.setText(estados);
            }            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void imprimirEstadosPrincipales(boolean lim)throws IOException{
        String c="",n="",e="",f="";
        
        if(ControlVentanas.registros.getFilePointer()<ControlVentanas.registros.length()){
            c=ControlVentanas.registros.readUTF();
            n=ControlVentanas.registros.readUTF();
            e=ControlVentanas.registros.readUTF();
            f=ControlVentanas.registros.readUTF();
            this.imprimirEstadosPrincipales(lim);
        }
        if(lim){
            if(c.equals(this.usuarioLogueado)){
                estados+="("+f+")"+" "+n+" publicó: \n"+e+"\n----------------------------------------------------------------------------------------------\n";
            }
        }else{
            if(c.equals(this.usuarioLogueado)){
                estados+="("+f+")"+" "+n+" publicó: \n"+e+"\n----------------------------------------------------------------------------------------------\n";
            }
        }            
    }

    private void guardarPathImagenPerfil(String path) {
        ControlVentanas.configArchivoPerfil(this.usuarioLogueado);
        ControlVentanas.crearRandom();
       try {
            ControlVentanas.registros.seek(0);
            ControlVentanas.registros.readUTF();
            ControlVentanas.registros.readChar();
            ControlVentanas.registros.readLong();
            ControlVentanas.registros.readUTF();
            ControlVentanas.registros.readLong();
            ControlVentanas.registros.readInt();
            ControlVentanas.registros.writeUTF(path);                             
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
