package ClasesVentanas;


import Adornos.panelRegistro;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Registrar.java
 *
 * Created on 11-21-2011, 03:33:39 PM
 */
/**
 *
 * 
 * @author NIGHTMARE
 */
public class Registrar extends javax.swing.JFrame {
    
    java.awt.Dimension pantallaTamaño=Toolkit.getDefaultToolkit().getScreenSize();
    Date fechaActual=new Date();
    SimpleDateFormat formato=new SimpleDateFormat("dd/MM/yyyy");
    String fechaReg;
    
    public Registrar(String t){
        initComponents();
        this.setTitle(t);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                cerrarVentana();
            }
        });
    }
    public void abrir(){        
        formWindowsOpened(null);
        this.setSize(400, 570);
        configItems();
        this.txtTelefono.setValue(new Integer(0));
        definirPosicionDerecha();
        this.setResizable(false);
        fechaReg=formato.format(fechaActual);
        this.txtCreacion.setText(fechaReg);
        this.setVisible(true);
    }    
    public void formWindowsOpened(WindowEvent ev){
        panelRegistro p=new panelRegistro();
        this.add( p , BorderLayout.CENTER);
        p.repaint();
    }
    public void cerrarVentana(){
        this.dispose();
        ControlVentanas.inicio.regresarRegistro();
        ControlVentanas.inicio.toFront();
    }
        
    public void definirPosicionCentral(){
        this.setLocation((pantallaTamaño.width/2)-((this.getSize().width)/2),((pantallaTamaño.height/2)-(this.getSize().height)/2));
    }
    public void definirPosicionDerecha() {
        this.setLocation(((pantallaTamaño.width/2)+100),((pantallaTamaño.height/2)-300));
    }
    
    private void configItems(){        
        this.cmbAño.removeAllItems();
        this.cmbMes.removeAllItems();
        for(int i=1900;i<2012;i++){
            this.cmbAño.addItem(i);
        }
        this.cmbMes.addItem("Enero");
        this.cmbMes.addItem("Febrero");
        this.cmbMes.addItem("Marzo");
        this.cmbMes.addItem("Abril");
        this.cmbMes.addItem("Mayo");
        this.cmbMes.addItem("Junio");
        this.cmbMes.addItem("Julio");
        this.cmbMes.addItem("Agosto");
        this.cmbMes.addItem("Septiembre");
        this.cmbMes.addItem("Octubre");
        this.cmbMes.addItem("Noviembre");
        this.cmbMes.addItem("Diciembre");
        configDias();
    }
    private void configDias(){
        int maximo=0;
     if(cmbMes.getSelectedIndex()==0 || cmbMes.getSelectedIndex()==2 || cmbMes.getSelectedIndex()==4 || cmbMes.getSelectedIndex()==6 || cmbMes.getSelectedIndex()==7 || 
             cmbMes.getSelectedIndex()==9 || cmbMes.getSelectedIndex()==11){
        maximo=31;
     }else if(cmbMes.getSelectedIndex()==1){ 
         if ((((Integer)cmbAño.getSelectedItem()) % 4 == 0) && ((((Integer)cmbAño.getSelectedItem()) % 100 != 0) || (((Integer)cmbAño.getSelectedItem()) % 400 == 0)))
             maximo=29;
         else
            maximo=28;
     }else if(cmbMes.getSelectedIndex()==3 || cmbMes.getSelectedIndex()==5 || cmbMes.getSelectedIndex()==8 || cmbMes.getSelectedIndex()==10){
         maximo=30;
     }
     cmbDia.removeAllItems();
     for(int i=1;i<maximo+1;i++){
         cmbDia.addItem(i);
     }
    }    
    
    public boolean validarEntradaRegistro(){
        if(this.txtNombre.getText().equals("") || this.txtEmail.getText().equals("") ||
            this.txtContraseña.getText().equals("") || this.txtRepetirContraseña.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Debe completar todos los campos llave (*)", "Campos Incompletos", JOptionPane.INFORMATION_MESSAGE);
                return false;
        }else if(!txtContraseña.getText().equals(this.txtRepetirContraseña.getText())){
            JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden", "Error Contraseña", JOptionPane.INFORMATION_MESSAGE);
            txtContraseña.requestFocus();
            txtContraseña.selectAll();
            txtRepetirContraseña.setText("");
            return false;
        }else if(!this.jCheckBox1.isSelected()){
            JOptionPane.showMessageDialog(null, "Debe Aceptar los terminos y condiciones", "Terminos y Condiciones", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }else if(this.txtTelefono.getText().length()>10){
            JOptionPane.showMessageDialog(null, "El número telefónico no puede tener más de 10 números", "Número inválido", JOptionPane.INFORMATION_MESSAGE);
            this.txtTelefono.requestFocus();
        }
        return crearEntradaRegistro();
    }
    public boolean crearEntradaRegistro(){
        if(correoExiste(this.txtEmail.getText())){
            JOptionPane.showMessageDialog(null, "Ya existe una cuenta con ese correo, que mal si olvidaste la contraseña","Correo ya existe",JOptionPane.INFORMATION_MESSAGE);
            this.txtContraseña.setText("");
            this.txtRepetirContraseña.setText("");
            this.txtEmail.requestFocus();
            this.txtEmail.selectAll();
            return false;
        } 
        try{
            String correo=this.txtEmail.getText();
            ControlVentanas.crearFolderUser(correo);
            crearNuevoPerfil(correo);
            agregarRegistroGerencia(correo);          
            return true;
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return false;
    }
    
    private void agregarRegistroGerencia(String correo) throws Exception{
        ControlVentanas.configArchivoGerencia();
        ControlVentanas.crearRandom();
        ControlVentanas.registros.seek(ControlVentanas.registros.length());
        ControlVentanas.registros.writeUTF(correo);
        ControlVentanas.registros.writeUTF(this.txtContraseña.getText());
        ControlVentanas.registros.writeBoolean(true);
        ControlVentanas.registros.close();
    }
    private void crearNuevoPerfil(String correo) throws Exception{
        ControlVentanas.crearArchivoManageFriends(correo);
        ControlVentanas.configArchivoPerfil(correo);
        ControlVentanas.crearFile();
        ControlVentanas.crearRandom();
        ControlVentanas.registros.writeUTF(this.txtNombre.getText());
        ControlVentanas.registros.writeChar(((String)this.cmbGenero.getSelectedItem()).charAt(0));
        Calendar fechaNacimiento=Calendar.getInstance();
        fechaNacimiento.set((Integer)this.cmbAño.getSelectedItem(), this.cmbMes.getSelectedIndex(), (Integer)this.cmbDia.getSelectedItem());
        ControlVentanas.registros.writeLong(fechaNacimiento.getTimeInMillis());
        ControlVentanas.registros.writeUTF(this.txtEmail.getText());
        ControlVentanas.registros.writeLong(fechaActual.getTime());
        ControlVentanas.registros.writeInt(Integer.valueOf(this.txtTelefono.getText()));
        ControlVentanas.registros.writeUTF("src/Adornos/user.png");
        ControlVentanas.registros.close();
        if(!this.txtEstatus.getText().equals(""))
            agregarStatus(txtEstatus.getText(),this.txtEmail.getText(),this.txtNombre.getText());
    }
    public boolean correoExiste(String correo){
        ControlVentanas.configFile("Cuentas/"+correo);
        return ControlVentanas.file.exists();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCreacion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cmbGenero = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        txtEstatus = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        cmbDia = new javax.swing.JComboBox();
        cmbMes = new javax.swing.JComboBox();
        cmbAño = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        txtContraseña = new javax.swing.JPasswordField();
        txtRepetirContraseña = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JFormattedTextField();

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
            }
        });

        jLabel2.setText("* Nombre de usuario: ");

        jLabel3.setText("Genero M o F: ");

        jLabel4.setText(" Fecha de Nacimiento:");

        jLabel5.setText("* Email: ");

        txtNombre.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        txtEmail.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jLabel6.setText("Fecha de Creación: ");

        txtCreacion.setEditable(false);
        txtCreacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCreacion.setFocusable(false);

        jLabel7.setText("Teléfono: ");

        cmbGenero.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "M (Masculino)", "F (Femenino)" }));
        cmbGenero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cmbGeneroMouseEntered(evt);
            }
        });

        jLabel8.setText("Estatus: ");

        txtEstatus.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtEstatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEstatusActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setEditable(false);
        jTextArea1.setRows(5);
        jTextArea1.setText("Al aceptar los terminos y condiciones estoy\nautorizando el uso exclusivo de toda la\ninformación, o medios que sean publicados\nen mi cuenta de FACEBIN. Así también estoy\nformalmente concediendo cualquier patente o\nderecho sobre mi alma.");
        jTextArea1.setFocusable(false);
        jScrollPane1.setViewportView(jTextArea1);

        jCheckBox1.setText("Acepto los terminos y condiciones");
        jCheckBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jCheckBox1MouseEntered(evt);
            }
        });
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jCheckBox1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCheckBox1KeyPressed(evt);
            }
        });

        jButton1.setText("Crear Cuenta");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1KeyPressed(evt);
            }
        });

        cmbDia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbMes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbMes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbMesItemStateChanged(evt);
            }
        });
        cmbMes.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                cmbMesInputMethodTextChanged(evt);
            }
        });

        cmbAño.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbAñoItemStateChanged(evt);
            }
        });

        jLabel1.setText("*Contraseña:");

        jLabel9.setText("*Repetir contraseña: ");

        txtTelefono.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtTelefono.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTelefonoFocusGained(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(14, 14, 14))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cmbGenero, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(88, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(102, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                            .addComponent(txtContraseña, 0, 0, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(53, 53, 53))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox1))
                        .addGap(2, 2, 2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel6))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtRepetirContraseña, 0, 0, Short.MAX_VALUE)
                            .addComponent(txtCreacion, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(71, 71, 71))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbMes, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbAño, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbDia, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(162, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(cmbAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRepetirContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtCreacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox1)
                .addGap(7, 7, 7)
                .addComponent(jButton1)
                .addGap(30, 30, 30))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-416)/2, (screenSize.height-638)/2, 416, 638);
    }// </editor-fold>//GEN-END:initComponents

    private void txtEstatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEstatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEstatusActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void cmbGeneroMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbGeneroMouseEntered
        this.setCursor(Cursor.HAND_CURSOR);
    }//GEN-LAST:event_cmbGeneroMouseEntered

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        this.setCursor(null);
        this.jButton1.setForeground(null);
    }//GEN-LAST:event_formMouseEntered

    private void jCheckBox1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBox1MouseEntered
        this.setCursor(Cursor.HAND_CURSOR);
    }//GEN-LAST:event_jCheckBox1MouseEntered

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        this.setCursor(Cursor.HAND_CURSOR);
        this.jButton1.setForeground(Color.red);
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        if(this.validarEntradaRegistro()){
            JOptionPane.showMessageDialog(null,"¡Bienvenido a la red más grande de esta computadora!", "Registro completado", JOptionPane.INFORMATION_MESSAGE);
            ControlVentanas.inicio.setCorreo(this.txtEmail.getText());
            this.cerrarVentana();
        }
            
        
    }//GEN-LAST:event_jButton1MouseClicked

    private void cmbMesInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_cmbMesInputMethodTextChanged

    }//GEN-LAST:event_cmbMesInputMethodTextChanged

    private void cmbMesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbMesItemStateChanged
        configDias();
    }//GEN-LAST:event_cmbMesItemStateChanged

    private void cmbAñoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbAñoItemStateChanged
        configDias();
    }//GEN-LAST:event_cmbAñoItemStateChanged

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus

    }//GEN-LAST:event_formWindowGainedFocus

    private void txtTelefonoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTelefonoFocusGained
        this.txtTelefono.selectAll();
    }//GEN-LAST:event_txtTelefonoFocusGained

    private void jCheckBox1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCheckBox1KeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if(this.jCheckBox1.isSelected()){
                this.jCheckBox1.setSelected(false);
            }else{
                this.jCheckBox1.setSelected(true);
            }
        }
    }//GEN-LAST:event_jCheckBox1KeyPressed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            this.jButton1MouseClicked(null);
        }
    }//GEN-LAST:event_jButton1KeyPressed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbAño;
    private javax.swing.JComboBox cmbDia;
    private javax.swing.JComboBox cmbGenero;
    private javax.swing.JComboBox cmbMes;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
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
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtCreacion;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEstatus;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JPasswordField txtRepetirContraseña;
    private javax.swing.JFormattedTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

    public void agregarStatus(String Estatus,String correo,String nombre){
        try {
            SimpleDateFormat formato=new SimpleDateFormat();
            ControlVentanas.configArchivoEstados();
            ControlVentanas.crearRandom();
            ControlVentanas.registros.seek(ControlVentanas.registros.length());
            Date fechaAhorita=new Date();
            ControlVentanas.registros.writeUTF(correo);
            ControlVentanas.registros.writeUTF(nombre);
            ControlVentanas.registros.writeUTF(Estatus);
            ControlVentanas.registros.writeUTF(formato.format(fechaAhorita));
            ControlVentanas.registros.writeBoolean(true);
            ControlVentanas.registros.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public String getPathImagen(String correo){
        ControlVentanas.configArchivoPerfil(correo);
        ControlVentanas.crearRandom();
       try {
            ControlVentanas.registros.seek(0);
            ControlVentanas.registros.readUTF();
            ControlVentanas.registros.readChar();
            ControlVentanas.registros.readLong();
            String c=ControlVentanas.registros.readUTF();
            ControlVentanas.registros.readLong();
            ControlVentanas.registros.readInt();
            String p=ControlVentanas.registros.readUTF();
            ControlVentanas.registros.close();
            return p;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            ControlVentanas.registros.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return "";
    }
    public int contarAmigos(String correo){
        ControlVentanas.configArchivoAmigos(correo);
        ControlVentanas.crearRandom();
        int cont=0;
        try {            
            long puntero=0;
            ControlVentanas.registros.seek(puntero);
            while(ControlVentanas.registros.getFilePointer()<ControlVentanas.registros.length()){
                ControlVentanas.registros.seek(puntero);
                String c=ControlVentanas.registros.readUTF();
                ControlVentanas.registros.readBoolean();
                ControlVentanas.registros.readBoolean();
                puntero=ControlVentanas.registros.getFilePointer();
                if(ControlVentanas.verificarCuentaActiva(c))
                    cont++;
            }
            ControlVentanas.registros.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        
        return cont;
    }
}
