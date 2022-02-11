/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inicio;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author ham
 */
public class Agregar extends javax.swing.JInternalFrame {
        
        Empleado empleado= new Empleado();
        
    
    public void validarControles() throws SQLException{
        String registro = (String) jcbEstadoActual.getSelectedItem();
        String Origen = (String) jcbOrigen.getSelectedItem();
          String nombre = txtNombre.getText();
          String  curp = txtCurp.getText();
          String  nss = txtNss.getText();//INT
          String  rfc = txtRfc.getText();
          String  alta =txtNuevonss.getText();//INT
          String  estudios = txtEstudios.getText();
          String  correo = txtCorreo.getText();
          String  telefono = txtTelefono.getText();
         String  cuenta = txtNumeroCuenta.getText();//INT
          String  otro = txtOtroBanco.getText();//INT
          String  direccion = txtDireccion.getText();
          String  emergencia = txtEmergencias.getText();
          String comentarios = txtComentarios.getText();
          String historial = txtHistorial.getText();
          String rutas = txtRutas.getText();
          String rutaFotos = txtRutaFoto.getText();
          
          //puro if 
          
          if(nombre.isEmpty()){
                JOptionPane.showMessageDialog(null, "introducir el nombre del empleado");
            txtNombre.requestFocus();
            return;
          }
           if(curp.isEmpty()){
                JOptionPane.showMessageDialog(null, "Favor de introducir el curp");
            txtCurp.requestFocus();
            return;
          }
            if(nss.isEmpty()){
                JOptionPane.showMessageDialog(null, "Favor de introducir el NSS");
            txtNss.requestFocus();
            return;
          }
             if(rfc.isEmpty()){
                   JOptionPane.showMessageDialog(null, "Favor de introducir el rfc");
            txtRfc.requestFocus();
            return;
              
          }
              if(alta.isEmpty()){
                JOptionPane.showMessageDialog(null, "Favor de introducir el nuevo numero nss");
            txtNuevonss.requestFocus();
            return;
          }
               if(estudios.isEmpty()){
                     JOptionPane.showMessageDialog(null, "Favor de introducir el grado maximo de estudios");
            txtEstudios.requestFocus();
            return;
              
          }
                if(correo.isEmpty()){
                JOptionPane.showMessageDialog(null, "Favor de introducir el correo electronico");
            txtCorreo.requestFocus();
            return;
          }
                 if(telefono.isEmpty()){
                JOptionPane.showMessageDialog(null, "Favor de introducir el telefono");
            txtTelefono.requestFocus();
            return;
          }
              
             
                    if(direccion.isEmpty()){
                JOptionPane.showMessageDialog(null, "Favor de introducir la direccion");
            txtDireccion.requestFocus();
            return;
          }
                     if(emergencia.isEmpty()){
                JOptionPane.showMessageDialog(null, "Favor de introducir el numero de emergencias");
            txtEmergencias.requestFocus();
            return;
          }
              
                       if(historial.isEmpty()){
                JOptionPane.showMessageDialog(null, "Favor de introducir el historial");
            txtHistorial.requestFocus();
            return;
                           
                           
                           
          } if(rutas.isEmpty()){
                JOptionPane.showMessageDialog(null, "Favor de introducir las rutas asignadas");
            txtRutas.requestFocus();
            return;
          }
          if(rutaFotos.isEmpty()){
               JOptionPane.showMessageDialog(null, "Favor de introducir la fotografia");
            btnFoto.requestFocus();
            return;
          }
          
          //Agregamos los datos al campo agregar
          Date obj = new Date();
          String fechar= obj.toString();
          empleado.setEstadoregistro(registro);
          empleado.setNombre(nombre);
           empleado.setCurp(curp);
           empleado.setNss(nss);
           empleado.setRfc(rfc);
           empleado.setNssnuevo(alta);
           empleado.setOrigen(Origen);
           empleado.setEstudios(estudios);
           empleado.setCorreo(correo);
           empleado.setTelefono(telefono);
           empleado.setCuenta(cuenta);
           empleado.setOtro(otro);
           empleado.setDireccion(direccion);
           empleado.setEmergencia(emergencia);
           empleado.setComentarios(comentarios+"");
           empleado.setHistorialLaboral(historial);
           empleado.setRutasAsignadas(rutas);
           empleado.setStatus("1");
           empleado.setRutaFoto(rutaFotos);
           empleado.setFechaRegistro(fechar);
           empleado.setNombre_carpeta(nombre);
       
        
        this.guardar();
    
    }
   
    
    public Agregar() {
        initComponents();
        btnNuevo.setEnabled(false); //Para que al iniciar el Form el boton este deshabilitado
        agregarEstados();
        otro(txtOtroBanco);
        cuenta(txtNumeroCuenta);
        nuevo(txtNuevonss);
        nss (txtNss);
        holder();
        
        
    }
    
    public void guardar() throws SQLException{
        
        MySql db1 = new MySql();
        int consultaInsertar=0;
        
        try {
            db1.MySQLConnection("root","prestige", "prestige");
          
        }
        catch (Exception ex) {
            Logger.getLogger(Agregar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        consultaInsertar = db1.insertarRegistro(empleado.getEstadoregistro(),empleado.getNombre(),empleado.getCurp(),empleado.getNss(),empleado.getRfc(),empleado.getNssnuevo(),empleado.getOrigen(),empleado.getEstudios(),empleado.getCorreo(),empleado.getTelefono(),empleado.getCuenta(),empleado.getOtro(),empleado.getDireccion(),empleado.getEmergencia(),empleado.getComentarios(),empleado.getHistorialLaboral(),empleado.getRutasAsignadas(),empleado.getStatus(),empleado.getRutaFoto(),empleado.getFechaRegistro(),empleado.getNombre_carpeta());
        
        
        if(consultaInsertar == 0){
            JOptionPane.showMessageDialog(null, "Registro No Insertado");
        }
        else{
            JOptionPane.showMessageDialog(null, "REGISTRO INSERTADO EXITOSAMENTE");
            
            //Se bloque el botón Guardar y habilita el botón nuevo registro
            btnGuardar.setEnabled(false);
            btnNuevo.setEnabled(true);
            
            
            //Se bloquean las casillas
           txtNombre.setEnabled(false);
           txtCurp.setEnabled(false);
           txtNss.setEnabled(false);
           txtRfc.setEnabled(false);
           txtNuevonss.setEnabled(false);
           txtEstudios.setEnabled(false);
           txtCorreo.setEnabled(false);
           txtTelefono.setEnabled(false);
           txtNumeroCuenta.setEnabled(false);
           txtOtroBanco.setEnabled(false);
           txtDireccion.setEnabled(false);
           txtEmergencias.setEnabled(false);
            txtComentarios.setEnabled(false);
            txtHistorial.setEnabled(false);
            txtRutas.setEnabled(false);
            lblFoto.setText("");
            jcbEstadoActual.disable();
            jcbOrigen.disable();
            btnFoto.setVisible(false);
            btnContrato.setVisible(false);
            txtRutaFoto.setText("");
        lblFoto.setIcon(frameIcon);
       
            
        }
        
        db1.closeConnection();
        

    }
    
private void agregarEstados(){
       String arreglo[] ={"Aguascalientes","Baja California","Baja California Sur","Campeche","Chiapas","Chihuahua","Ciudad de México","Coahuila","Colima","Durango","Estado de México","Guanajuato","Guerrero","Hidalgo","Jalisco","Michoacán","Morelos","Nayarit","Nuevo León","Oaxaca","Puebla","Querétaro","Quintana Roo","San Luis Potosí","Sinaloa","Sonora","Tabasco","Tamaulipas","Tlaxcala","Veracruz","Yucatán","Zacatecas"};
       for(int i=0;i<32;i++){
           jcbOrigen.addItem(arreglo[i]);
       }
       
       String Actuales[]={"Cancun","Campeche","Chiapas","Cuernavaca","Puebla","Tabasco","Yucatan","Veracruz"};
       for(int i=0;i<8;i++){
           jcbEstadoActual.addItem(Actuales[i]);
       }
       
       
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btgSexo = new javax.swing.ButtonGroup();
        lblNombre = new javax.swing.JLabel();
        txtCurp = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        lblFoto = new javax.swing.JLabel();
        jcbEstadoActual = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblNombre1 = new javax.swing.JLabel();
        btnCurp = new javax.swing.JButton();
        lblNombre2 = new javax.swing.JLabel();
        txtNss = new javax.swing.JTextField();
        btnNss = new javax.swing.JButton();
        lblNombre3 = new javax.swing.JLabel();
        txtRfc = new javax.swing.JTextField();
        btnRfc = new javax.swing.JButton();
        btnNuevonss = new javax.swing.JButton();
        lblNombre4 = new javax.swing.JLabel();
        txtNuevonss = new javax.swing.JTextField();
        lblNombre5 = new javax.swing.JLabel();
        btnActa = new javax.swing.JButton();
        jcbOrigen = new javax.swing.JComboBox<>();
        lblNombre6 = new javax.swing.JLabel();
        txtEstudios = new javax.swing.JTextField();
        btnEstudios = new javax.swing.JButton();
        lblNombre7 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        lblNombre8 = new javax.swing.JLabel();
        lblNombre9 = new javax.swing.JLabel();
        txtNumeroCuenta = new javax.swing.JTextField();
        btnCuenta = new javax.swing.JButton();
        lblNombre10 = new javax.swing.JLabel();
        txtOtroBanco = new javax.swing.JTextField();
        btnOtro = new javax.swing.JButton();
        lblNombre11 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        btnDireccion = new javax.swing.JButton();
        lblNombre12 = new javax.swing.JLabel();
        txtEmergencias = new javax.swing.JTextField();
        lblNombre13 = new javax.swing.JLabel();
        btnIne = new javax.swing.JButton();
        lblNombre14 = new javax.swing.JLabel();
        txtComentarios = new javax.swing.JTextField();
        lblNombre15 = new javax.swing.JLabel();
        txtHistorial = new javax.swing.JTextField();
        txtRutas = new javax.swing.JTextField();
        lblNombre16 = new javax.swing.JLabel();
        btnFoto = new javax.swing.JButton();
        txtRutaFoto = new javax.swing.JTextField();
        btnContrato = new javax.swing.JButton();

        setIconifiable(true);
        setMaximizable(true);
        setTitle("Agregar Empleado");

        lblNombre.setText("Curp del empleado:");

        txtCurp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCurpActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnNuevo.setText("Limpiar");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        lblFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel1.setText("Estado de Registro:");

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        lblNombre1.setText("Nombre del empleado:");

        btnCurp.setText("Curp.");
        btnCurp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCurpActionPerformed(evt);
            }
        });

        lblNombre2.setText("Nss del empleado:");

        txtNss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNssActionPerformed(evt);
            }
        });
        txtNss.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNssKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNssKeyTyped(evt);
            }
        });

        btnNss.setText("NSS");
        btnNss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNssActionPerformed(evt);
            }
        });

        lblNombre3.setText("Rfc del empleado");

        txtRfc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRfcActionPerformed(evt);
            }
        });

        btnRfc.setText("RFC");
        btnRfc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRfcActionPerformed(evt);
            }
        });

        btnNuevonss.setText("Nuevo Nss");
        btnNuevonss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevonssActionPerformed(evt);
            }
        });

        lblNombre4.setText("Alta Imss");

        txtNuevonss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNuevonssActionPerformed(evt);
            }
        });
        txtNuevonss.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNuevonssKeyTyped(evt);
            }
        });

        lblNombre5.setText("Estado de Origen.");

        btnActa.setText("Acta ");
        btnActa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActaActionPerformed(evt);
            }
        });

        lblNombre6.setText("Ultimo Grado de estudios:");

        txtEstudios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEstudiosActionPerformed(evt);
            }
        });

        btnEstudios.setText("Estudios");
        btnEstudios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstudiosActionPerformed(evt);
            }
        });

        lblNombre7.setText("Correo Electronico:");

        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });

        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });

        lblNombre8.setText("Numero Telefonico:");

        lblNombre9.setText("Numero de cuenta:");

        txtNumeroCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroCuentaActionPerformed(evt);
            }
        });

        btnCuenta.setText("Cuenta");
        btnCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCuentaActionPerformed(evt);
            }
        });

        lblNombre10.setText("Otro Banco:");

        txtOtroBanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOtroBancoActionPerformed(evt);
            }
        });

        btnOtro.setText("Otro");
        btnOtro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOtroActionPerformed(evt);
            }
        });

        lblNombre11.setText("Direccion:");

        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });

        btnDireccion.setText("Direccion");
        btnDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDireccionActionPerformed(evt);
            }
        });

        lblNombre12.setText("Numero de Emergencias:");

        txtEmergencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmergenciasActionPerformed(evt);
            }
        });
        txtEmergencias.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEmergenciasKeyReleased(evt);
            }
        });

        lblNombre13.setText("INE");

        btnIne.setText("INE");
        btnIne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIneActionPerformed(evt);
            }
        });

        lblNombre14.setText("Comentarios/Salud:");

        txtComentarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtComentariosActionPerformed(evt);
            }
        });

        lblNombre15.setText("Historial Laboral:");

        txtHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHistorialActionPerformed(evt);
            }
        });

        txtRutas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRutasActionPerformed(evt);
            }
        });

        lblNombre16.setText("Rutas Asignadas:");

        btnFoto.setText("Fotografia.");
        btnFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFotoActionPerformed(evt);
            }
        });

        txtRutaFoto.setEditable(false);
        txtRutaFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRutaFotoActionPerformed(evt);
            }
        });

        btnContrato.setText("Guardar Contrato");
        btnContrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContratoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombre12)
                            .addComponent(lblNombre13)
                            .addComponent(lblNombre14)
                            .addComponent(lblNombre15)
                            .addComponent(lblNombre16))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnNuevo)
                                .addGap(18, 18, 18)
                                .addComponent(btnGuardar)
                                .addGap(62, 62, 62))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnContrato)
                                .addGap(81, 81, 81))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblNombre5)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(27, 27, 27)
                                .addComponent(jcbEstadoActual, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jcbOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(lblNombre4)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtNuevonss, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(lblNombre3)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtRfc, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(lblNombre2)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtNss, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(lblNombre)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtCurp, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(lblNombre1)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btnRfc, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnNuevonss, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnNss, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnActa, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnCurp, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnIne, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtEmergencias, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtComentarios, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtRutas, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(lblNombre7)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(lblNombre6)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtEstudios, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(lblNombre8)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(lblNombre9)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtNumeroCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(lblNombre10)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtOtroBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(lblNombre11)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnEstudios, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnCuenta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnOtro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnDireccion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtRutaFoto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblFoto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(72, 72, 72)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcbEstadoActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre1)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre)
                            .addComponent(txtCurp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCurp, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNss, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombre2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre3)
                            .addComponent(txtRfc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRfc, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre4)
                            .addComponent(txtNuevonss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNuevonss, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnActa, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombre5)
                            .addComponent(jcbOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre6)
                            .addComponent(txtEstudios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEstudios, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre7)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre8)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblFoto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre9)
                    .addComponent(txtNumeroCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtRutaFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(btnContrato)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardar)
                            .addComponent(btnNuevo))
                        .addGap(32, 32, 32))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnOtro, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtOtroBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombre10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombre11))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre12)
                            .addComponent(txtEmergencias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnIne, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombre13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre14)
                            .addComponent(txtComentarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre15)
                            .addComponent(txtHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre16)
                            .addComponent(txtRutas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(43, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCurpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCurpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCurpActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
   
        
            try {
                validarControles();
            } catch (SQLException ex) {
                Logger.getLogger(Agregar.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
        
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_btnGuardarActionPerformed

     private void holder(){
         TextPrompt placeholder = new TextPrompt("Solo Numeros", txtNss);
         placeholder.changeAlpha(0.75f);
         placeholder.changeStyle(Font.ITALIC);
           TextPrompt placeholder1 = new TextPrompt("Solo Numeros",txtNuevonss);
          placeholder1.changeAlpha(0.75f);
         placeholder1.changeStyle(Font.ITALIC);
        TextPrompt placeholder2 = new TextPrompt("Solo Numeros",txtNumeroCuenta);
          placeholder2.changeAlpha(0.75f);
         placeholder2.changeStyle(Font.ITALIC);
        TextPrompt placeholder3 = new TextPrompt("Solo Numeros",txtOtroBanco);
          placeholder3.changeAlpha(0.75f);
         placeholder3.changeStyle(Font.ITALIC);
        
         
        
    }
    
    
    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
    //Aqui debemos limpiar todos los controles.
   
    txtNombre.setText("");
       txtCurp.setText("");
       txtNss.setText("");
       txtRfc.setText("");
        txtNuevonss.setText("");
        txtEstudios.setText("");
        txtCorreo.setText("");
        txtTelefono.setText("");
        txtNumeroCuenta.setText("");
        txtOtroBanco.setText("");
        txtDireccion.setText("");
        txtEmergencias.setText("");
        txtComentarios.setText("");
        txtHistorial.setText("");
        txtRutas.setText("");
        lblFoto.setBackground(Color.gray);
        btnFoto.setEnabled(true);
        jcbOrigen.setEnabled(true);
        jcbEstadoActual.setEnabled(true);
      
        btnContrato.setVisible(true);
        txtRutaFoto.setText("");
        lblFoto.setIcon(frameIcon);
      
        

            btnCurp.setVisible(true);
                           txtCurp.setEnabled(true);



            btnNss.setVisible(true);
                           txtNss.setEnabled(true);



             btnRfc.setVisible(true);
                           txtRfc.setEnabled(true);


             btnNuevonss.setVisible(true);
                           txtNuevonss.setEnabled(true);



            btnActa.setVisible(true);
                           jcbOrigen.setEnabled(true);



           btnEstudios.setVisible(true);
                           txtEstudios.setEnabled(true);




           btnCuenta.setVisible(true);
                           btnOtro.setVisible(true);

                            txtOtroBanco.setEnabled(true);
                           txtNumeroCuenta.setEnabled(true);





           btnDireccion.setEnabled(true);
                           txtDireccion.setEnabled(true);




            btnIne.setEnabled(true);





               btnFoto.setEnabled(true);



             btnContrato.setVisible(true);


        
        
        
        
        
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtNssActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNssActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNssActionPerformed

    private void txtRfcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRfcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRfcActionPerformed

    private void txtNuevonssActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNuevonssActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNuevonssActionPerformed

    private void txtEstudiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEstudiosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEstudiosActionPerformed

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtNumeroCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroCuentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroCuentaActionPerformed

    private void txtOtroBancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOtroBancoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOtroBancoActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void txtEmergenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmergenciasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmergenciasActionPerformed

    private void txtComentariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtComentariosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtComentariosActionPerformed

    private void txtHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHistorialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHistorialActionPerformed

    private void txtRutasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRutasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRutasActionPerformed

    private void btnCurpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCurpActionPerformed
         //AQUI SE CREA LA CARPETA DE LOS ARCHIVOS
      JFileChooser file = new JFileChooser();//Aqui se crea el seleccionador de archivos
       file.showOpenDialog(this);//Se pone la opcion para agregar
       String Actual = (String) jcbEstadoActual.getSelectedItem();//Aqui se ve donde se registrara
       String Nombre = txtNombre.getText();//Aqui se tiene el nombre conforme lo agregado
        File archivo = file.getSelectedFile(); // Se crea la variable para poder manipular el archivo
           File directory = new File("C:\\BASEDATOS\\"+Actual+"\\"+Nombre+"\\");//Aqui se crea la carpeta del estado o usuario conforme no exista
         
           //Se mira que no sea null el archivo
           try{
               
           
           if(archivo !=null){
               
                 FileUtils.forceMkdir(directory);//Fuerza a que se creen los 2 directorios
             JOptionPane.showMessageDialog(null,"Archivo Copiado Correctamente");
             
             if(directory.exists()){
                  String Dest = "C:\\BASEDATOS\\"+Actual+"\\"+Nombre+"\\"+archivo.getName();
                Path Destino = Paths.get(Dest);
                String Orig = archivo.getPath();
                Path Origen = Paths.get(Orig);
                Files.copy(Origen,Destino,REPLACE_EXISTING);
                btnCurp.setVisible(false);
                txtCurp.setEnabled(false);
             }
             
               
               
               
           }
           }catch (Exception e){
               
           }
        
        
        
        
        
        
        
    }//GEN-LAST:event_btnCurpActionPerformed

    private void btnNssActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNssActionPerformed
         //NSS
        
          //AQUI SE CREA LA CARPETA DE LOS ARCHIVOS
      JFileChooser file = new JFileChooser();//Aqui se crea el seleccionador de archivos
       file.showOpenDialog(this);//Se pone la opcion para agregar
       String Actual = (String) jcbEstadoActual.getSelectedItem();//Aqui se ve donde se registrara
       String Nombre = txtNombre.getText();//Aqui se tiene el nombre conforme lo agregado
        File archivo = file.getSelectedFile(); // Se crea la variable para poder manipular el archivo
           File directory = new File("C:\\BASEDATOS\\"+Actual+"\\"+Nombre+"\\");//Aqui se crea la carpeta del estado o usuario conforme no exista
         
           //Se mira que no sea null el archivo
           try{
               
           
           if(archivo !=null){
               
                 FileUtils.forceMkdir(directory);//Fuerza a que se creen los 2 directorios
             JOptionPane.showMessageDialog(null,"Archivo Copiado Correctamente");
             
             if(directory.exists()){
                  String Dest = "C:\\BASEDATOS\\"+Actual+"\\"+Nombre+"\\"+archivo.getName();
                 
                Path Destino = Paths.get(Dest);
                String Orig = archivo.getPath();
                Path Origen = Paths.get(Orig);
                Files.copy(Origen,Destino,REPLACE_EXISTING);
                btnNss.setVisible(false);
                txtNss.setEnabled(false);
                
             }
             
               
               
               
           }
           }catch (Exception e){
               
           }
        
        
        
    }//GEN-LAST:event_btnNssActionPerformed

    private void btnRfcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRfcActionPerformed
       //RFC
           //AQUI SE CREA LA CARPETA DE LOS ARCHIVOS
      JFileChooser file = new JFileChooser();//Aqui se crea el seleccionador de archivos
       file.showOpenDialog(this);//Se pone la opcion para agregar
       String Actual = (String) jcbEstadoActual.getSelectedItem();//Aqui se ve donde se registrara
       String Nombre = txtNombre.getText();//Aqui se tiene el nombre conforme lo agregado
        File archivo = file.getSelectedFile(); // Se crea la variable para poder manipular el archivo
           File directory = new File("C:\\BASEDATOS\\"+Actual+"\\"+Nombre+"\\");//Aqui se crea la carpeta del estado o usuario conforme no exista
         
           //Se mira que no sea null el archivo
           try{
               
           
           if(archivo !=null){
               
                 FileUtils.forceMkdir(directory);//Fuerza a que se creen los 2 directorios
           //  JOptionPane.showMessageDialog(null,"Carpeta creada correctamente");
             
             if(directory.exists()){
                  String Dest = "C:\\BASEDATOS\\"+Actual+"\\"+Nombre+"\\"+archivo.getName();
                 
                Path Destino = Paths.get(Dest);
                String Orig = archivo.getPath();
                Path Origen = Paths.get(Orig);
                Files.copy(Origen,Destino,REPLACE_EXISTING);
                btnRfc.setVisible(false);
                txtRfc.setEnabled(false);
                 JOptionPane.showMessageDialog(null,"Archivo Copiado Correctamente");
             }
             
               
               
               
           }
           }catch (Exception e){
               
           }
          
        
        
        
        
        
    }//GEN-LAST:event_btnRfcActionPerformed

    private void btnNuevonssActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevonssActionPerformed
       
//NSSNuevo        

//AQUI SE CREA LA CARPETA DE LOS ARCHIVOS
     
     
        
        JFileChooser file = new JFileChooser();//Aqui se crea el seleccionador de archivos
       file.showOpenDialog(this);//Se pone la opcion para agregar
       String Actual = (String) jcbEstadoActual.getSelectedItem();//Aqui se ve donde se registrara
       String Nombre = txtNombre.getText();//Aqui se tiene el nombre conforme lo agregado
        File archivo = file.getSelectedFile(); // Se crea la variable para poder manipular el archivo
           File directory = new File("C:\\BASEDATOS\\"+Actual+"\\"+Nombre+"\\");//Aqui se crea la carpeta del estado o usuario conforme no exista
         
           //Se mira que no sea null el archivo
           try{
               
           
           if(archivo !=null){
               
                 FileUtils.forceMkdir(directory);//Fuerza a que se creen los 2 directorios
          
             
             if(directory.exists()){
                  String Dest = "C:\\BASEDATOS\\"+Actual+"\\"+Nombre+"\\"+archivo.getName();
                 
                Path Destino = Paths.get(Dest);
                String Orig = archivo.getPath();
                Path Origen = Paths.get(Orig);
                Files.copy(Origen,Destino,REPLACE_EXISTING);
                btnNuevonss.setVisible(false);
                txtNuevonss.setEnabled(false);
                 JOptionPane.showMessageDialog(null,"Archivo Copiado Correctamente");
             }
             
               
               
               
           }
           }catch (Exception e){
               
           }
          
    }//GEN-LAST:event_btnNuevonssActionPerformed

    private void btnActaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActaActionPerformed
 //Acta Nacimiento
           //AQUI SE CREA LA CARPETA DE LOS ARCHIVOS
      JFileChooser file = new JFileChooser();//Aqui se crea el seleccionador de archivos
       file.showOpenDialog(this);//Se pone la opcion para agregar
       String Actual = (String) jcbEstadoActual.getSelectedItem();//Aqui se ve donde se registrara
       String Nombre = txtNombre.getText();//Aqui se tiene el nombre conforme lo agregado
        File archivo = file.getSelectedFile(); // Se crea la variable para poder manipular el archivo
           File directory = new File("C:\\BASEDATOS\\"+Actual+"\\"+Nombre+"\\");//Aqui se crea la carpeta del estado o usuario conforme no exista
         
           //Se mira que no sea null el archivo
           try{
               
           
           if(archivo !=null){
               
                 FileUtils.forceMkdir(directory);//Fuerza a que se creen los 2 directorios
            
             
             if(directory.exists()){
                  String Dest = "C:\\BASEDATOS\\"+Actual+"\\"+Nombre+"\\"+archivo.getName();
                 
                Path Destino = Paths.get(Dest);
                String Orig = archivo.getPath();
                Path Origen = Paths.get(Orig);
                Files.copy(Origen,Destino,REPLACE_EXISTING);
                btnActa.setVisible(false);
                jcbOrigen.setEnabled(false);
                 JOptionPane.showMessageDialog(null,"Archivo Copiado Correctamente");
             }
             
               
               
               
           }
           }catch (Exception e){
               
           }
                  // TODO add your handling code here:
    }//GEN-LAST:event_btnActaActionPerformed

    private void btnEstudiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstudiosActionPerformed
        //Ultimo Grado
            //AQUI SE CREA LA CARPETA DE LOS ARCHIVOS
      JFileChooser file = new JFileChooser();//Aqui se crea el seleccionador de archivos
       file.showOpenDialog(this);//Se pone la opcion para agregar
       String Actual = (String) jcbEstadoActual.getSelectedItem();//Aqui se ve donde se registrara
       String Nombre = txtNombre.getText();//Aqui se tiene el nombre conforme lo agregado
        File archivo = file.getSelectedFile(); // Se crea la variable para poder manipular el archivo
           File directory = new File("C:\\BASEDATOS\\"+Actual+"\\"+Nombre+"\\");//Aqui se crea la carpeta del estado o usuario conforme no exista
         
           //Se mira que no sea null el archivo
           try{
               
           
           if(archivo !=null){
               
                 FileUtils.forceMkdir(directory);//Fuerza a que se creen los 2 directorios
          
             
             if(directory.exists()){
                  String Dest = "C:\\BASEDATOS\\"+Actual+"\\"+Nombre+"\\"+archivo.getName();
                 
                Path Destino = Paths.get(Dest);
                String Orig = archivo.getPath();
                Path Origen = Paths.get(Orig);
                Files.copy(Origen,Destino,REPLACE_EXISTING);
                btnEstudios.setVisible(false);
                txtEstudios.setEnabled(false);
                 JOptionPane.showMessageDialog(null,"Archivo Copiado Correctamente");
             }
             
               
               
               
           }
           }catch (Exception e){
               
           }
          
    }//GEN-LAST:event_btnEstudiosActionPerformed

    private void btnCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCuentaActionPerformed
       //Cuenta 
          //AQUI SE CREA LA CARPETA DE LOS ARCHIVOS
      JFileChooser file = new JFileChooser();//Aqui se crea el seleccionador de archivos
       file.showOpenDialog(this);//Se pone la opcion para agregar
       String Actual = (String) jcbEstadoActual.getSelectedItem();//Aqui se ve donde se registrara
       String Nombre = txtNombre.getText();//Aqui se tiene el nombre conforme lo agregado
        File archivo = file.getSelectedFile(); // Se crea la variable para poder manipular el archivo
           File directory = new File("C:\\BASEDATOS\\"+Actual+"\\"+Nombre+"\\");//Aqui se crea la carpeta del estado o usuario conforme no exista
         
           //Se mira que no sea null el archivo
           try{
               
           
           if(archivo !=null){
               
                 FileUtils.forceMkdir(directory);//Fuerza a que se creen los 2 directorios
     
             
             if(directory.exists()){
                  String Dest = "C:\\BASEDATOS\\"+Actual+"\\"+Nombre+"\\"+archivo.getName();
                 
                Path Destino = Paths.get(Dest);
                String Orig = archivo.getPath();
                Path Origen = Paths.get(Orig);
                Files.copy(Origen,Destino,REPLACE_EXISTING);
                btnCuenta.setVisible(false);
                btnOtro.setVisible(false);
                
                 txtOtroBanco.setEnabled(false);
                txtNumeroCuenta.setEnabled(false);
                
                
                 JOptionPane.showMessageDialog(null,"Archivo Copiado Correctamente");
             }
             
               
               
               
           }
           }catch (Exception e){
               
           }
          
    }//GEN-LAST:event_btnCuentaActionPerformed

    private void btnOtroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOtroActionPerformed
//Otro banco
        //AQUI SE CREA LA CARPETA DE LOS ARCHIVOS
      JFileChooser file = new JFileChooser();//Aqui se crea el seleccionador de archivos
       file.showOpenDialog(this);//Se pone la opcion para agregar
       String Actual = (String) jcbEstadoActual.getSelectedItem();//Aqui se ve donde se registrara
       String Nombre = txtNombre.getText();//Aqui se tiene el nombre conforme lo agregado
        File archivo = file.getSelectedFile(); // Se crea la variable para poder manipular el archivo
           File directory = new File("C:\\BASEDATOS\\"+Actual+"\\"+Nombre+"\\");//Aqui se crea la carpeta del estado o usuario conforme no exista
         
           //Se mira que no sea null el archivo
           try{
               
           
           if(archivo !=null){
               
                 FileUtils.forceMkdir(directory);//Fuerza a que se creen los 2 directorios
       
             
             if(directory.exists()){
                  String Dest = "C:\\BASEDATOS\\"+Actual+"\\"+Nombre+"\\"+archivo.getName();
                 
                Path Destino = Paths.get(Dest);
                String Orig = archivo.getPath();
                Path Origen = Paths.get(Orig);
                Files.copy(Origen,Destino,REPLACE_EXISTING);
                btnOtro.setVisible(false);
                btnCuenta.setVisible(false);
                txtOtroBanco.setEnabled(false);
                txtNumeroCuenta.setEnabled(false);
                
                 JOptionPane.showMessageDialog(null,"Archivo Copiado Correctamente");
             }
             
               
               
               
           }
           }catch (Exception e){
               
           }        // TODO add your handling code here:
    }//GEN-LAST:event_btnOtroActionPerformed

    private void btnDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDireccionActionPerformed
      
          // Comprobante de domicilio
           //AQUI SE CREA LA CARPETA DE LOS ARCHIVOS
      JFileChooser file = new JFileChooser();//Aqui se crea el seleccionador de archivos
       file.showOpenDialog(this);//Se pone la opcion para agregar
       String Actual = (String) jcbEstadoActual.getSelectedItem();//Aqui se ve donde se registrara
       String Nombre = txtNombre.getText();//Aqui se tiene el nombre conforme lo agregado
        File archivo = file.getSelectedFile(); // Se crea la variable para poder manipular el archivo
           File directory = new File("C:\\BASEDATOS\\"+Actual+"\\"+Nombre+"\\");//Aqui se crea la carpeta del estado o usuario conforme no exista
         
           //Se mira que no sea null el archivo
           try{
               
           
           if(archivo !=null){
               
                 FileUtils.forceMkdir(directory);//Fuerza a que se creen los 2 directorios
           
             
             if(directory.exists()){
                  String Dest = "C:\\BASEDATOS\\"+Actual+"\\"+Nombre+"\\"+archivo.getName();
                 
                Path Destino = Paths.get(Dest);
                String Orig = archivo.getPath();
                Path Origen = Paths.get(Orig);
                Files.copy(Origen,Destino,REPLACE_EXISTING);
                btnDireccion.setEnabled(false);
                txtDireccion.setEnabled(false);
                 JOptionPane.showMessageDialog(null,"Archivo Copiado Correctamente");
             }
             
               
               
               
           }
           }catch (Exception e){
               
           }
        
    }//GEN-LAST:event_btnDireccionActionPerformed

    private void btnIneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIneActionPerformed
 //INE
       
       
           //AQUI SE CREA LA CARPETA DE LOS ARCHIVOS
      JFileChooser file = new JFileChooser();//Aqui se crea el seleccionador de archivos
       file.showOpenDialog(this);//Se pone la opcion para agregar
       String Actual = (String) jcbEstadoActual.getSelectedItem();//Aqui se ve donde se registrara
       String Nombre = txtNombre.getText();//Aqui se tiene el nombre conforme lo agregado
        File archivo = file.getSelectedFile(); // Se crea la variable para poder manipular el archivo
           File directory = new File("C:\\BASEDATOS\\"+Actual+"\\"+Nombre+"\\");//Aqui se crea la carpeta del estado o usuario conforme no exista
         
           //Se mira que no sea null el archivo
           try{
               
           
           if(archivo !=null){
               
                 FileUtils.forceMkdir(directory);//Fuerza a que se creen los 2 directorios
        
             
             if(directory.exists()){
                  String Dest = "C:\\BASEDATOS\\"+Actual+"\\"+Nombre+"\\"+archivo.getName();
                 
                Path Destino = Paths.get(Dest);
                String Orig = archivo.getPath();
                Path Origen = Paths.get(Orig);
                Files.copy(Origen,Destino,REPLACE_EXISTING);
                btnIne.setEnabled(false);
                 JOptionPane.showMessageDialog(null,"Archivo Copiado Correctamente");
             }
             
               
               
               
           }
           }catch (Exception e){
               
           }
                  // TODO add your handling code here:
    }//GEN-LAST:event_btnIneActionPerformed

    private void btnFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFotoActionPerformed
//AQUI SE CREA LA CARPETA DE LOS ARCHIVOS
      JFileChooser file = new JFileChooser();//Aqui se crea el seleccionador de archivos
       file.showOpenDialog(this);//Se pone la opcion para agregar
       String Actual = (String) jcbEstadoActual.getSelectedItem();//Aqui se ve donde se registrara
       String Nombre = txtNombre.getText();//Aqui se tiene el nombre conforme lo agregado
        File archivo = file.getSelectedFile(); // Se crea la variable para poder manipular el archivo
           File directory = new File("C:\\BASEDATOS\\"+Actual+"\\"+Nombre+"\\");//Aqui se crea la carpeta del estado o usuario conforme no exista
         String rutaFoto;
        
           //Se mira que no sea null el archivo
           try{
               
           
           if(archivo !=null){
               
                 FileUtils.forceMkdir(directory);//Fuerza a que se creen los 2 directorios
           
             
             if(directory.exists()){
                  String Dest = "C:\\BASEDATOS\\"+Actual+"\\"+Nombre+"\\"+archivo.getName();
                  rutaFoto = archivo.getName();
                  //Dest debemos guardarlo en la base de datos
               
                  
                  //Probando Linea
                  txtRutaFoto.setText(rutaFoto);
                  System.out.println(rutaFoto);
               
               
                Path Destino = Paths.get(Dest);
                String Orig = archivo.getPath();
                Path Origen = Paths.get(Orig);
                Files.copy(Origen,Destino,REPLACE_EXISTING);    
                
                
                
             rsscalelabel.RSScaleLabel.setScaleLabel(lblFoto,file.getSelectedFile().toString());//Aqui se selecciona la imagen
                btnFoto.setEnabled(false);
                 JOptionPane.showMessageDialog(null,"Archivo Copiado Correctamente");
             }
             
               
               
               
           }
           }catch (Exception e){
               
           }        // TODO add your handling code here:
    }//GEN-LAST:event_btnFotoActionPerformed

    private void txtEmergenciasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmergenciasKeyReleased
     //Evento para activar esta madre xd
     
     
     
    }//GEN-LAST:event_txtEmergenciasKeyReleased

    private void otro(JTextField a){
        //Poner solo numeros
        a.addKeyListener(new KeyAdapter() {
       
            public void keyTyped(KeyEvent e ){
            
                char c = e.getKeyChar();
                
                if(!Character.isDigit(c)){
                    e.consume();
                }
                
                if(c == '.' && txtOtroBanco.getText().contains(".")){
                    e.consume();
                }
            
        
        
        }});
        
        
        
        
    }
    private void cuenta(JTextField a){
        //Poner solo numeros
        a.addKeyListener(new KeyAdapter() {
       
            public void keyTyped(KeyEvent e ){
            
                char c = e.getKeyChar();
                
                if(!Character.isDigit(c)){
                    e.consume();
                }
                
                if(c == '.' && txtNumeroCuenta.getText().contains(".")){
                    e.consume();
                }
            
        
        
        }});
        
        
        
        
    }
    private void nuevo(JTextField a){
        //Poner solo numeros
        a.addKeyListener(new KeyAdapter() {
       
            public void keyTyped(KeyEvent e ){
            
                char c = e.getKeyChar();
                
                if(!Character.isDigit(c)){
                    e.consume();
                }
                
                if(c == '.' && txtNuevonss.getText().contains(".")){
                    e.consume();
                }
            
        
        
        }});
        
        
        
        
    }
    private void nss(JTextField a){
        //Poner solo numeros
        a.addKeyListener(new KeyAdapter() {
       
            public void keyTyped(KeyEvent e ){
            
                char c = e.getKeyChar();
                
                if(!Character.isDigit(c)){
                    e.consume();
                }
                
                if(c == '.' && txtNss.getText().contains(".")){
                    e.consume();
                }
            
        
        
        }});
        
        
        
        
    }
    
    
    private void txtNssKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNssKeyReleased
        
        
        
        
        
    }//GEN-LAST:event_txtNssKeyReleased

    private void txtNssKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNssKeyTyped
  
        int limite = 11;
        
        
        if(txtNss.getText().length() == limite ){
            evt.consume();
        }
        
        
        
    }//GEN-LAST:event_txtNssKeyTyped

    private void txtNuevonssKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNuevonssKeyTyped
    int limite = 11;
    
    if(txtNuevonss.getText().length() == limite){
        evt.consume();
    }
    }//GEN-LAST:event_txtNuevonssKeyTyped

    private void txtRutaFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRutaFotoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRutaFotoActionPerformed

    private void btnContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContratoActionPerformed
//Parte del contrato

    // Comprobante de domicilio
           //AQUI SE CREA LA CARPETA DE LOS ARCHIVOS
      JFileChooser file = new JFileChooser();//Aqui se crea el seleccionador de archivos
       file.showOpenDialog(this);//Se pone la opcion para agregar
       String Actual = (String) jcbEstadoActual.getSelectedItem();//Aqui se ve donde se registrara
       String Nombre = txtNombre.getText();//Aqui se tiene el nombre conforme lo agregado
        File archivo = file.getSelectedFile(); // Se crea la variable para poder manipular el archivo
           File directory = new File("C:\\BASEDATOS\\"+Actual+"\\"+Nombre+"\\Contrato\\");//Aqui se crea la carpeta del estado o usuario conforme no exista
         
           //Se mira que no sea null el archivo
           try{
               
           
           if(archivo !=null){
               
                 FileUtils.forceMkdir(directory);//Fuerza a que se creen los 2 directorios
          
             
             if(directory.exists()){
                  String Dest = "C:\\BASEDATOS\\"+Actual+"\\"+Nombre+"\\Contrato\\"+archivo.getName();
                 
                Path Destino = Paths.get(Dest);
                String Orig = archivo.getPath();
                Path Origen = Paths.get(Orig);
                Files.copy(Origen,Destino,REPLACE_EXISTING);
                
                
                btnContrato.setVisible(false);
                 JOptionPane.showMessageDialog(null,"Archivo Copiado Correctamente");
             }
             
               
               
               
           }
           }catch (Exception e){
               JOptionPane.showMessageDialog(null,"Error al generar la carpeta "+e);
           }
        
        
        
        
        
        
    }//GEN-LAST:event_btnContratoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btgSexo;
    private javax.swing.JButton btnActa;
    public static javax.swing.JButton btnContrato;
    private javax.swing.JButton btnCuenta;
    private javax.swing.JButton btnCurp;
    private javax.swing.JButton btnDireccion;
    private javax.swing.JButton btnEstudios;
    private javax.swing.JButton btnFoto;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnIne;
    private javax.swing.JButton btnNss;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnNuevonss;
    private javax.swing.JButton btnOtro;
    private javax.swing.JButton btnRfc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox<String> jcbEstadoActual;
    private javax.swing.JComboBox<String> jcbOrigen;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombre1;
    private javax.swing.JLabel lblNombre10;
    private javax.swing.JLabel lblNombre11;
    private javax.swing.JLabel lblNombre12;
    private javax.swing.JLabel lblNombre13;
    private javax.swing.JLabel lblNombre14;
    private javax.swing.JLabel lblNombre15;
    private javax.swing.JLabel lblNombre16;
    private javax.swing.JLabel lblNombre2;
    private javax.swing.JLabel lblNombre3;
    private javax.swing.JLabel lblNombre4;
    private javax.swing.JLabel lblNombre5;
    private javax.swing.JLabel lblNombre6;
    private javax.swing.JLabel lblNombre7;
    private javax.swing.JLabel lblNombre8;
    private javax.swing.JLabel lblNombre9;
    private javax.swing.JTextField txtComentarios;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtCurp;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEmergencias;
    private javax.swing.JTextField txtEstudios;
    private javax.swing.JTextField txtHistorial;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNss;
    private javax.swing.JTextField txtNuevonss;
    private javax.swing.JTextField txtNumeroCuenta;
    private javax.swing.JTextField txtOtroBanco;
    private javax.swing.JTextField txtRfc;
    public static javax.swing.JTextField txtRutaFoto;
    private javax.swing.JTextField txtRutas;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}

