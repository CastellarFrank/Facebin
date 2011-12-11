package ClasesVentanas;



import Adornos.panelFondoPrincipal;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
    int cantAmigos=0;
    String correoAmigos[];
    String amigosAceptados[];
    String solicitudesAmigos[];
    Object objetos[][];
    int tamaño;
    Container contenedores[][];
    Container PanelPrincipal=new Container();
    JScrollPane scroll=new JScrollPane();
    boolean visita=false;
    
    
    /** Creates new form FaceMain */
    public FaceMain(String t,String correo){
        initComponents();
        usuarioLogueado=correo;
        nombreUser=this.getNombre(correo);
        configArrayFriends(correo);
        configurarImagen(correo);
        this.setTitle(t);        
        configurarFormPrincipal();
        configurarPrincipal();
        formWindowOpened(null);
    }
    
    public FaceMain(String t,String correo,String user){
        initComponents();
        usuarioLogueado=correo;
        nombreUser=user;
        configArrayFriends(correo);
        configurarImagen(correo);
        limite=true;       
        this.setTitle(t);
        this.configurarFormFace();
        configurarVentanaEstados();
        publicarEstadosPrincipales(limite,correo);
        this.configurarLabelsProfile();
        this.configurarLabelsInformacion(user);
        this.ObtenerDatosLogueado(correo);
        inicio();
        addListeners();
        formWindowOpened(null);  
    }
    public FaceMain(String correo,String user,String visitante,String nombreV){
        initComponents();
        usuarioLogueado=correo;
        nombreUser=user;
        configurarImagen(visitante);
        limite=true;
        visita=true;
        configArrayFriends(visitante);
        this.setTitle("Perfil Amigo, "+visitante);
        this.configurarFormFace();
        configurarVentanaEstados();
        publicarEstadosPrincipales(limite,visitante);
        configurarPanelIzquierdoPrincipal(true);
        this.configurarLabelsInformacion(nombreV);
        this.ObtenerDatosLogueado(visitante);
        inicio();  
        formWindowOpened(null);  
    }
    public void inicio(){
        tamaño=this.amigosAceptados.length;
        objetos=new Object[tamaño][3];
        contenedores=new Container[tamaño][2];
        crearElementos();
    }
    public void crearElementos(){
        for(int i=0;i<objetos.length;i++){
            objetos[i][0]=new JLabel();
            objetos[i][1]=new JLabel();
            objetos[i][2]=new JLabel();
            configurarContenedores();
            obtenerInfo(i);
        }
    }
    public void configurarContenedores(){
        this.PanelPrincipal.setLayout(new BoxLayout(PanelPrincipal,BoxLayout.Y_AXIS));
        scroll.setViewportView(PanelPrincipal);
        crearContenedores();
        for(int i=0;i<contenedores.length;i++){
            contenedores[i][0].setLayout(new FlowLayout(FlowLayout.LEFT));
            contenedores[i][0].setSize(350, 100);
            contenedores[i][1].setLayout(new BoxLayout(contenedores[i][1],BoxLayout.PAGE_AXIS));
            contenedores[i][1].setSize(280, 100);
        }
    }
    public void crearContenedores(){
        for(int i=0;i<contenedores.length;i++){
            contenedores[i][0]=new Container();
            contenedores[i][1]=new Container();
        }
    }
    public void obtenerInfo(int i){
        String correo=this.amigosAceptados[i];
        if(correo!=null){
            ControlVentanas.configArchivoPerfil(correo);
            ControlVentanas.crearRandom();
            try {
                ControlVentanas.registros.seek(0);
                String n=ControlVentanas.registros.readUTF();
                ControlVentanas.registros.readChar();
                ControlVentanas.registros.readLong();
                ControlVentanas.registros.readUTF();
                ControlVentanas.registros.readLong();
                ControlVentanas.registros.readInt();
                String p=ControlVentanas.registros.readUTF();
                ControlVentanas.registros.close();
                configElementos(correo,n,p,i);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    public int contarAmigosAceptados(){
        int cont=0;
        for(String c:amigosAceptados){
            if(c!=null)
                cont++;
            else
                break;
        }
        return cont;            
    }
    public int contarSolicitudesAmigos(){
        int cont=0;
        for(String c:solicitudesAmigos){
            if(c!=null)
                cont++;
            else
                break;
        }
        return cont;
    }
    public void configElementos(String correo,String n,String p,int i){
        ((JLabel)objetos[i][0]).setSize(70,80);
        ImageIcon imagen=new ImageIcon(p);
        ImageIcon foto=new ImageIcon(imagen.getImage().getScaledInstance(80,90,Image.SCALE_DEFAULT));
        ((JLabel)objetos[i][0]).setIcon(foto);
        ((JLabel)objetos[i][0]).setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ((JLabel)objetos[i][1]).setText(n);
        ((JLabel)objetos[i][2]).setText(correo);
        colocarElementos(i);
    }
    public void colocarElementos(int i){
        this.PanelPrincipal.add(contenedores[i][0]);
        this.PanelPrincipal.add(Box.createRigidArea(new Dimension(0,20)));
        contenedores[i][0].add((JLabel)objetos[i][0]);
        contenedores[i][0].add(Box.createRigidArea(new Dimension(10,0)));
        contenedores[i][1].add((JLabel)objetos[i][1]);
        contenedores[i][1].add(Box.createRigidArea(new Dimension(0,20)));
        contenedores[i][1].add((JLabel)objetos[i][2]);
        contenedores[i][0].add(contenedores[i][1]);
        scroll.setBorder(null);
        scroll.setBounds(910,100,260, 500);
        scroll.getViewport().setOpaque(false);
        scroll.setOpaque(false);
        this.add(scroll);        
    }
    private void addListeners(){
        for(int i=0;i<contenedores.length;i++){
            final int num=i;
            ((JLabel)objetos[i][0]).addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
            public void mouseClicked(java.awt.event.MouseEvent evt){
                visitarPerfil(num);
            }
                @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cambiarCursor();
            }
        });
        }
        scroll.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cursorNormal();
            }
        });
    }
    public void cursorNormal(){
        this.setCursor(null);
    }
    public void visitarPerfil(int num){
        String c=this.amigosAceptados[num];
        String nombre=this.getNombre(c);
        this.dispose();
        ControlVentanas.crearFaceVisitante(this.usuarioLogueado,this.nombreUser, c, nombre);
        
    }
    public void cambiarCursor(){
        this.setCursor(Cursor.HAND_CURSOR);
    }
    
    public void configArrayFriends(String correo){
        ControlVentanas.agregarCuentasActivas();
        cantAmigos=ControlVentanas.registro.contarAmigos(correo);
        correoAmigos= new String[cantAmigos];
        amigosAceptados=new String[cantAmigos];
        solicitudesAmigos=new String[cantAmigos];
        this.agregarCorreoAmigos(correo);
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
   private void configurarPanelIzquierdoPrincipal(boolean b){
       Container panel=new Container();
       this.lblTitulo.setLocation(594-(this.lblTitulo.getWidth()/2), 52);
       panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
       if(b){
           this.jLabel2.setText("Regresar Mi Perfil");
           this.jLabel1.setVisible(false);
           this.txtIngresarEstado.setVisible(false);
           this.btnInsertarEstado.setVisible(false);
       }
       panel.add(this.jLabel2,BorderLayout.CENTER) ;
       panel.add(Box.createRigidArea(new Dimension(10,25)));
       panel.add(this.jLabel3,BorderLayout.CENTER) ;
       panel.add(Box.createRigidArea(new Dimension(10,25)));
       panel.add(this.jLabel4,BorderLayout.CENTER) ;
       panel.add(Box.createRigidArea(new Dimension(10,25)));
       if(!b){
           panel.setBounds((320/2)-(120/2),190,130,200);
       }else{
           panel.setBounds((320/2)-(120/2),260,130,200);
       }
       
       this.jLabel2.setVisible(true);
       this.add(panel);
       this.jLabel5.setVisible(false);
       this.jLabel6.setVisible(false);
       this.jLabel7.setVisible(false);
       this.jLabel8.setVisible(false);
       this.jLabel9.setVisible(false);
       if(!b){
           this.lblNombre.setVisible(false);
           this.lblGenero.setVisible(false);
           this.lblNacimiento.setVisible(false);
           this.lblTelefono.setVisible(false);
       }
       
   }
   private void configurarLabelsProfile(){
       Container panel=new Container();
       panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
       panel.add(this.jLabel5,BorderLayout.CENTER);
       panel.add(Box.createRigidArea(new Dimension(10,20)));
       panel.add(this.jLabel6,BorderLayout.CENTER);
       panel.add(Box.createRigidArea(new Dimension(10,20)));
       panel.add(this.jLabel7,BorderLayout.CENTER);
       panel.add(Box.createRigidArea(new Dimension(10,20)));
       panel.add(this.jLabel8,BorderLayout.CENTER);
       panel.add(Box.createRigidArea(new Dimension(10,20)));
       panel.add(this.jLabel3,BorderLayout.CENTER);
       panel.add(Box.createRigidArea(new Dimension(10,20)));
       panel.add(this.jLabel4,BorderLayout.CENTER);
       panel.setBounds((320/2)-(120/2),260,200,200);
       this.add(panel);
       this.lblTitulo.setText(nombreUser); 
       int tamAA=this.contarAmigosAceptados();
       this.jLabel9.setText("Amigos ("+(tamAA==0?"foreverAlone":tamAA)+")");
       this.jLabel9.setVisible(true);
       int tamSA=this.contarSolicitudesAmigos();
       this.jLabel2.setVisible(false);
       if(tamSA>0){
           this.jLabel6.setText("Ver Solicitudes ("+tamSA+")");
       }
       this.lblTitulo.setLocation(600-(this.lblTitulo.getWidth()/2), 52);
   }
   private void configurarLabelsInformacion(String nombre){
       Container panel=new Container();
       panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
       panel.add(this.lblNombre,BorderLayout.CENTER);
       panel.add(Box.createRigidArea(new Dimension(10,5)));
       panel.add(this.lblGenero,BorderLayout.CENTER);
       panel.add(Box.createRigidArea(new Dimension(10,5)));
       panel.add(this.lblNacimiento,BorderLayout.CENTER);
       panel.add(Box.createRigidArea(new Dimension(10,5)));
       panel.add(this.lblTelefono,BorderLayout.CENTER);
       panel.setBounds((320/2)-(120/2),160,200,200);
       this.add(panel);
       this.lblTitulo.setText(nombre);     
       if(!visita)
           this.jLabel2.setVisible(false);
       this.lblTitulo.setLocation(600-(this.lblTitulo.getWidth()/2), 52);
   }
   private void configurarPrincipal(){
       configurarVentanaEstados();
       publicarEstadosPrincipales(limite,this.usuarioLogueado);
       configurarPanelIzquierdoPrincipal(false);
   }
  
       
   
   private void configurarVentanaEstados(){
       this.jScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
       this.txtIngresarEstado.setBounds(394,170,315,20);
       btnInsertarEstado.setBounds(714, 169, 80, 23);
       this.jScrollPane1.setBounds((594)-(200),200,400,350);  
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
            ControlVentanas.registros.close();
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
        lblNombre = new javax.swing.JLabel();
        lblGenero = new javax.swing.JLabel();
        lblNacimiento = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

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
        txtIngresarEstado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIngresarEstadoKeyPressed(evt);
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

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
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
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnInsertarEstadoMouseEntered(evt);
            }
        });
        btnInsertarEstado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnInsertarEstadoKeyPressed(evt);
            }
        });
        getContentPane().add(btnInsertarEstado);
        btnInsertarEstado.setBounds(780, 170, 80, 23);

        lblTitulo.setFont(new java.awt.Font("Celtic Garamond the 2nd", 1, 36));
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
        jLabel8.setText("Modificar Perfil");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel8MouseEntered(evt);
            }
        });
        getContentPane().add(jLabel8);
        jLabel8.setBounds(130, 370, 170, 16);

        lblNombre.setFont(new java.awt.Font("Tahoma", 2, 11));
        lblNombre.setText("jLabel9");
        getContentPane().add(lblNombre);
        lblNombre.setBounds(260, 220, 140, 14);

        lblGenero.setFont(new java.awt.Font("Tahoma", 2, 11));
        lblGenero.setText("jLabel9");
        getContentPane().add(lblGenero);
        lblGenero.setBounds(260, 250, 140, 14);

        lblNacimiento.setFont(new java.awt.Font("Tahoma", 2, 11));
        lblNacimiento.setText("jLabel9");
        getContentPane().add(lblNacimiento);
        lblNacimiento.setBounds(260, 280, 130, 14);

        lblTelefono.setFont(new java.awt.Font("Tahoma", 2, 11));
        lblTelefono.setText("jLabel9");
        getContentPane().add(lblTelefono);
        lblTelefono.setBounds(260, 310, 130, 14);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("jLabel9");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(930, 40, 230, 22);

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
        this.btnInsertarEstado.setForeground(null);
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
            this.publicarEstadosPrincipales(limite,this.usuarioLogueado);
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
            if(!visita){
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
            }
            
            
    }//GEN-LAST:event_lblImagenPerfilMouseClicked

    private void lblImagenPerfilMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImagenPerfilMouseEntered
        if(!visita)
            this.setCursor(Cursor.HAND_CURSOR);
    }//GEN-LAST:event_lblImagenPerfilMouseEntered

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        ControlVentanas.crearFace(this.usuarioLogueado);
        this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        if(solicitudesAmigos.length==0 || solicitudesAmigos[0]==null){
            JOptionPane.showMessageDialog(null, "No tienes ninguna solicitud pendiente a confirmar","No hay solicitudes",JOptionPane.INFORMATION_MESSAGE);
        }else{
            ControlVentanas.crearSolicitudAmigos();
        }
        
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
        ControlVentanas.abrirBusqueda(this.usuarioLogueado);
    }//GEN-LAST:event_jLabel7MouseClicked

    private void btnInsertarEstadoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertarEstadoMouseEntered
        this.setCursor(Cursor.HAND_CURSOR);
        this.btnInsertarEstado.setForeground(Color.red);
    }//GEN-LAST:event_btnInsertarEstadoMouseEntered

    private void txtIngresarEstadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIngresarEstadoKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            this.btnInsertarEstadoMouseClicked(null);
        }
    }//GEN-LAST:event_txtIngresarEstadoKeyPressed

    private void btnInsertarEstadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnInsertarEstadoKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            this.btnInsertarEstadoMouseClicked(null);
        }
    }//GEN-LAST:event_btnInsertarEstadoKeyPressed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        ControlVentanas.crearModificarInfo(this.usuarioLogueado);
    }//GEN-LAST:event_jLabel8MouseClicked

    
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
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblGenero;
    private javax.swing.JLabel lblImagenPerfil;
    private javax.swing.JLabel lblNacimiento;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextArea txtEstados;
    private javax.swing.JTextField txtIngresarEstado;
    // End of variables declaration//GEN-END:variables
    public void clickVerPerfil(){
        jLabel2MouseClicked(null);
    }
    private String getImagenPerfil(String correo){
        return ControlVentanas.registro.getPathImagen(correo);
    }
    private void configurarImagen(String correo){
        this.lblImagenPerfil.setSize(110, 120);
        this.lblImagenPerfil.setLocation((326/2)-(110/2),28); 
        colocarImagenPerfil(getImagenPerfil(correo));
    }
    private void colocarImagenPerfil(String path){
        ImageIcon imagen=new ImageIcon(path);
        ImageIcon foto=new ImageIcon(imagen.getImage().getScaledInstance(this.lblImagenPerfil.getWidth(), this.lblImagenPerfil.getHeight(), Image.SCALE_DEFAULT));        
        this.lblImagenPerfil.setIcon(foto);
    }
    public void publicarEstadosPrincipales(boolean lim,String correo){
        try {
            ControlVentanas.configArchivoEstados();
            ControlVentanas.crearRandom();
            if(ControlVentanas.registros.length()>0){
                ControlVentanas.registros.seek(0);
                estados="----------------------------------------------------------------------------------------------\n";
                imprimirEstadosPrincipales(lim,correo);
                this.txtEstados.setText(estados);
                ControlVentanas.registros.close();
            }            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void imprimirEstadosPrincipales(boolean lim,String correo)throws IOException{
        String c="",n="",e="",f="";
        boolean b=false;
        
        if(ControlVentanas.registros.getFilePointer()<ControlVentanas.registros.length()){
            c=ControlVentanas.registros.readUTF();
            n=ControlVentanas.registros.readUTF();
            e=ControlVentanas.registros.readUTF();
            f=ControlVentanas.registros.readUTF();
            b=ControlVentanas.registros.readBoolean();
            this.imprimirEstadosPrincipales(lim,correo);
        }
        if(b){
            if(lim){
                if(c.equals(correo)){
                    estados+="("+f+")"+" "+n+" publicó: \n"+e+"\n----------------------------------------------------------------------------------------------\n";
                }
            }else{
                if(c.equals(correo) || this.buscarEnLosAmigos(c,1)){
                    estados+="("+f+")"+" "+n+" publicó: \n"+e+"\n----------------------------------------------------------------------------------------------\n";
                }
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
            ControlVentanas.registros.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public boolean buscarEnLosAmigos(String correo,int a){
        if(a==0){
            return this.validarAmigo(correo, correoAmigos);
        }else if(a==1){
            return this.validarAmigo(correo,this.amigosAceptados);            
        }else{
            return this.validarAmigo(correo, this.solicitudesAmigos);
        }
    }
    private boolean validarAmigo(String correo,String arreglo[]){
        for(String c: arreglo){
            if(c!=null){
                if(c.equals(correo))
                return true;
            }else{
                break;
            }      
        }
        return false;
    }
    public void agregarCorreoAmigos(String correo){
        ControlVentanas.configArchivoAmigos(correo);
        ControlVentanas.crearRandom();
        try {
            long puntero=0;
            int contador=0,contadorA=0,contadorS=0;
            ControlVentanas.registros.seek(puntero);
            while(ControlVentanas.registros.getFilePointer()<ControlVentanas.registros.length()){
                ControlVentanas.registros.seek(puntero);
                String c=ControlVentanas.registros.readUTF();
                boolean b=ControlVentanas.registros.readBoolean();
                boolean s=ControlVentanas.registros.readBoolean();
                puntero=ControlVentanas.registros.getFilePointer();
                if(ControlVentanas.verificarCuentaActiva(c)){
                    if(b){
                        this.amigosAceptados[contadorA]=c;
                        contadorA++;
                    }else if(!s){
                        this.solicitudesAmigos[contadorS]=c;
                        contadorS++;
                    }                    
                    correoAmigos[contador]=c;
                    contador++;
                }                                           
            }
            ControlVentanas.registros.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }        
    }
    public boolean miCorreoExisteEnEsteUsuario(String correo){
        ControlVentanas.configArchivoAmigos(correo);
        ControlVentanas.crearRandom();
        try {
            ControlVentanas.registros.seek(0);
            while(ControlVentanas.registros.getFilePointer()<ControlVentanas.registros.length()){
                String c=ControlVentanas.registros.readUTF();
                ControlVentanas.registros.readBoolean();
                ControlVentanas.registros.readBoolean();
                if(c.equals(this.usuarioLogueado)){
                    ControlVentanas.registros.close();
                    return true;
                }
                    
            }
            ControlVentanas.registros.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        return false;        
    }
    private void ObtenerDatosLogueado(String correo){
        try {
            ControlVentanas.configArchivoPerfil(correo);
            ControlVentanas.crearRandom();
            String n=ControlVentanas.registros.readUTF();
            char g=ControlVentanas.registros.readChar();
            long nacimiento=ControlVentanas.registros.readLong();
            ControlVentanas.registros.readUTF();
            ControlVentanas.registros.readLong();
            int telefono=ControlVentanas.registros.readInt();
            ControlVentanas.registros.readUTF();
            ControlVentanas.registros.close();
            this.setDatosPerfil(n, g, nacimiento, telefono);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public void setDatosPerfil(String n,char genero,long nac,int tel){
        this.lblNombre.setText("Nombre: "+n);
        this.lblGenero.setText("Genero: "+(genero=='M'?"Masculino":"Femenino"));
        Date fecha=new Date(nac);
        SimpleDateFormat formato=new SimpleDateFormat("dd/MM/yyyy");
        String fechaF=formato.format(fecha);
        this.lblNacimiento.setText("Fecha N: "+fechaF);
        this.lblTelefono.setText("Telefono: "+(tel==0?"N/D":tel));
    }
    public void cerrarSesion(){
        this.jLabel3MouseClicked(null);
    }
}
