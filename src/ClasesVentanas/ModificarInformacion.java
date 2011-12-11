/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ModificarInformacion.java
 *
 * Created on 12-07-2011, 08:31:01 PM
 */
package ClasesVentanas;

import Adornos.panelModificarInfo;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author NIGHTMARE
 */
public class ModificarInformacion extends javax.swing.JFrame {
    java.awt.Dimension tamañoPantalla=Toolkit.getDefaultToolkit().getScreenSize();
    String usuarioLogueado;
    public ModificarInformacion(String correo) {
        usuarioLogueado=correo;
        initComponents();
        this.setTitle("Modificar Información Personal");
        this.configItems();
        this.actualizarInformacion(correo);
        this.setSize(450,350);
        this.setVisible(true);
        this.setLocation((tamañoPantalla.width/2)-(this.getWidth()/2),(tamañoPantalla.height/2)-(this.getHeight()/2));
        formWindowOpened(null);
    }
    private void formWindowOpened(WindowEvent evt) {
        panelModificarInfo p = new panelModificarInfo();
        this.add( p , BorderLayout.CENTER);
        p.repaint();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbDia = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblGenero = new javax.swing.JLabel();
        cmbAño = new javax.swing.JComboBox();
        cmbMes = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox();
        btnActualizar = new javax.swing.JButton();
        cmbGenero = new javax.swing.JComboBox();
        txtTelefono = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        cmbDia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Fecha Nacimiento: ");

        jLabel2.setText("Telefono: ");

        lblGenero.setText("Genero: ");

        cmbAño.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbAño.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbAñoItemStateChanged(evt);
            }
        });

        cmbMes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbMes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbMesItemStateChanged(evt);
            }
        });

        jLabel3.setText("Estado: ");

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Activada", "Desactivada" }));

        btnActualizar.setText("Actualizar");
        btnActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnActualizarMouseClicked(evt);
            }
        });

        cmbGenero.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Masculino", "Femenino" }));

        txtTelefono.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(lblGenero)
                        .addGap(8, 8, 8)
                        .addComponent(cmbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(9, 9, 9)
                        .addComponent(cmbMes, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(cmbAño, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(cmbDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(btnActualizar)))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(cmbMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(btnActualizar)
                .addContainerGap(103, Short.MAX_VALUE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-466)/2, (screenSize.height-388)/2, 466, 388);
    }// </editor-fold>//GEN-END:initComponents

    private void cmbMesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbMesItemStateChanged
        configDias();
}//GEN-LAST:event_cmbMesItemStateChanged

    private void cmbAñoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbAñoItemStateChanged
        configDias();
    }//GEN-LAST:event_cmbAñoItemStateChanged

    private void btnActualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarMouseClicked
        if(this.cmbEstado.getSelectedIndex()==1){
            if(JOptionPane.showConfirmDialog(null, "¿Realmente desea desactivar su cuenta?, Su información será borrada","Desactivar Cuenta", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE)==0){
                this.modificarInfo(usuarioLogueado);
                ControlVentanas.agregarCuentasActivas();
                this.dispose();
                desactivarEstados(usuarioLogueado);
                ControlVentanas.borrarUsuario(usuarioLogueado);
                ControlVentanas.face.cerrarSesion();
            }else{
                this.cmbEstado.requestFocus();
            }
        }else{
            modificarInfo(this.usuarioLogueado);
            JOptionPane.showMessageDialog(null, "Información actualizada con éxito", "Actualizado", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        }
        
    }//GEN-LAST:event_btnActualizarMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JComboBox cmbAño;
    private javax.swing.JComboBox cmbDia;
    private javax.swing.JComboBox cmbEstado;
    private javax.swing.JComboBox cmbGenero;
    private javax.swing.JComboBox cmbMes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblGenero;
    private javax.swing.JFormattedTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

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
    private void actualizarInformacion(String correo){
        ControlVentanas.configArchivoPerfil(correo);
        ControlVentanas.crearRandom();
        try {
            ControlVentanas.registros.readUTF();
            char c=ControlVentanas.registros.readChar();
            long fn=ControlVentanas.registros.readLong();
            ControlVentanas.registros.readUTF();
            ControlVentanas.registros.readLong();
            int tel=ControlVentanas.registros.readInt();
            ControlVentanas.registros.readUTF();
            ControlVentanas.registros.close();
            setDatos(c,fn,tel);            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    private void setDatos(char c, long fn, int tel) {
        int dia,mes,año;
        this.cmbGenero.setSelectedIndex((c=='M'?0:1));
        Date fecha=new Date(fn);
        dia=fecha.getDate();
        mes=fecha.getMonth();
        año=fecha.getYear();
        this.cmbMes.setSelectedIndex(mes);
        this.cmbAño.setSelectedIndex(año);
        this.cmbDia.setSelectedIndex(dia-1);        
        this.txtTelefono.setValue(tel);        
        
    }
    private void modificarInfo(String correo){
        ControlVentanas.configArchivoPerfil(correo);
        ControlVentanas.crearRandom();
        try {
            ControlVentanas.registros.seek(0);
            String n=ControlVentanas.registros.readUTF();
            char c=(this.cmbGenero.getSelectedIndex()==0?'M':'F');
            ControlVentanas.registros.writeChar(c);
            Calendar cal=Calendar.getInstance();
            cal.set((Integer)this.cmbAño.getSelectedItem(),this.cmbMes.getSelectedIndex(), (Integer)this.cmbDia.getSelectedItem());
            ControlVentanas.registros.writeLong(cal.getTimeInMillis());
            ControlVentanas.registros.readUTF();
            ControlVentanas.registros.readLong();
            int tel=Integer.valueOf(this.txtTelefono.getText());
            ControlVentanas.registros.writeInt(tel);
            ControlVentanas.registros.close();
            boolean b=desactivarCuenta(correo);
            if(b){
                ControlVentanas.face.setDatosPerfil(n, c, cal.getTimeInMillis(), tel);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private boolean desactivarCuenta(String correo) {
        ControlVentanas.configArchivoGerencia();
        ControlVentanas.crearRandom();
        boolean b=true;
        try{
            ControlVentanas.registros.seek(0);
            while(ControlVentanas.registros.getFilePointer()<ControlVentanas.registros.length()){
                String c=ControlVentanas.registros.readUTF();
                ControlVentanas.registros.readUTF();
                if(c.equals(correo)){
                    b=(this.cmbEstado.getSelectedIndex()==0?true:false);
                    ControlVentanas.registros.writeBoolean(b);
                    break;
                }else{
                    ControlVentanas.registros.readBoolean();
                }         
            }
            ControlVentanas.registros.close();
        }catch(IOException io){
            System.out.println(io.getMessage());
            io.printStackTrace();
        }
        return b;
    }
    private void desactivarEstados(String correo){
        ControlVentanas.configArchivoEstados();
        ControlVentanas.crearRandom();
        try {
            ControlVentanas.registros.seek(0);
            while(ControlVentanas.registros.getFilePointer()<ControlVentanas.registros.length()){
                String c=ControlVentanas.registros.readUTF();
                ControlVentanas.registros.readUTF();
                ControlVentanas.registros.readUTF();
                ControlVentanas.registros.readUTF();
                if(c.equals(correo)){
                    ControlVentanas.registros.writeBoolean(false);
                }else{
                    ControlVentanas.registros.readBoolean();
                }
            }
            ControlVentanas.registros.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }

}


