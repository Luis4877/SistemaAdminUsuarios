/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inicio;

import static Inicio.MySql.empleadoBuscar;

import java.awt.Component;
import static javafx.application.Platform.exit;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import Inicio.Mostrar.*;
import static Inicio.Mostrar.jcbOrigen;
import static Inicio.Mostrar.jcbRegistro;
/**
 *
 * @author ham
 */
public class Menu extends javax.swing.JFrame {
    
    
    public static Mostrar m=new Mostrar();//Crear el objeto Mostrar una sóla vez, debe ser public static para poderlo manipular desde otro método que no sea un menú.

    Component add;//Si el formulario Mostrar ya se ha agregado al escritorio, no lo vuelve a agregar.

    Buscar b=null;//Crear el objeto Buscar una sóla vez
    
    public static int bandera=0;

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
            this.setExtendedState(MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImageIcon icon = new ImageIcon(getClass().getResource("/Inicio/fondo.jpg"));
        Image image = icon.getImage();
        dskEscritorio = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }
        };
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuAgregar = new javax.swing.JMenu();
        mniAgregarEmpleado = new javax.swing.JMenuItem();
        mnuConsultar = new javax.swing.JMenu();
        mniBuscarEmpleado = new javax.swing.JMenuItem();
        mnuEditar = new javax.swing.JMenu();
        mniEditarEmpleado = new javax.swing.JMenuItem();
        mnuEliminar = new javax.swing.JMenu();
        mniEliminarEmpleado = new javax.swing.JMenuItem();
        mnuSalir = new javax.swing.JMenu();
        mniSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PRESTIGE");

        javax.swing.GroupLayout dskEscritorioLayout = new javax.swing.GroupLayout(dskEscritorio);
        dskEscritorio.setLayout(dskEscritorioLayout);
        dskEscritorioLayout.setHorizontalGroup(
            dskEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1059, Short.MAX_VALUE)
        );
        dskEscritorioLayout.setVerticalGroup(
            dskEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
        );

        jMenuBar1.setForeground(new java.awt.Color(0, 0, 102));

        mnuAgregar.setText("Agregar");

        mniAgregarEmpleado.setText("Empleado");
        mniAgregarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniAgregarEmpleadoActionPerformed(evt);
            }
        });
        mnuAgregar.add(mniAgregarEmpleado);

        jMenuBar1.add(mnuAgregar);

        mnuConsultar.setText("Buscar");

        mniBuscarEmpleado.setText("Empleado");
        mniBuscarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniBuscarEmpleadoActionPerformed(evt);
            }
        });
        mnuConsultar.add(mniBuscarEmpleado);

        jMenuBar1.add(mnuConsultar);

        mnuEditar.setText("Editar");

        mniEditarEmpleado.setText("Empleado");
        mniEditarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniEditarEmpleadoActionPerformed(evt);
            }
        });
        mnuEditar.add(mniEditarEmpleado);

        jMenuBar1.add(mnuEditar);

        mnuEliminar.setText("Eliminar");

        mniEliminarEmpleado.setText("Empleado");
        mniEliminarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniEliminarEmpleadoActionPerformed(evt);
            }
        });
        mnuEliminar.add(mniEliminarEmpleado);

        jMenuBar1.add(mnuEliminar);

        mnuSalir.setText("Nomina");
        mnuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSalirActionPerformed(evt);
            }
        });

        mniSalir.setText("Agregar");
        mniSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniSalirActionPerformed(evt);
            }
        });
        mnuSalir.add(mniSalir);

        jMenuBar1.add(mnuSalir);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dskEscritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(dskEscritorio)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mniAgregarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniAgregarEmpleadoActionPerformed




        Agregar a=new Agregar();
        dskEscritorio.add(a);
        a.show();
        
        
        

    }//GEN-LAST:event_mniAgregarEmpleadoActionPerformed

    private void mniBuscarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniBuscarEmpleadoActionPerformed
        bandera=1;
        //validar si ya fue agregado el formulario Mostrar
        if (add==null){
           add = dskEscritorio.add(m);  
        }

        //validar no ha sido creado el formulario Buscar una primera vez
        if (b==null){
            b=new Buscar();
            dskEscritorio.add(b);
            b.show();
        }
        else{//Si ya existe el formulario Buscar lo muestra
            b.setVisible(true);//Muestra en el escritorio el formulario Buscar cuando el usuario vuelve a seleccionar el submenú Empleado
            m.hide();//Oculta el formulario Mostrar cuando el usuario vuelve a seleccionar el submenú Empleado
        }
      
    }//GEN-LAST:event_mniBuscarEmpleadoActionPerformed

    private void mniEditarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniEditarEmpleadoActionPerformed
            
            bandera=2;
        
            //validar si ya fue agregado el objeto Mostrar
             if (add==null){
                add = dskEscritorio.add(m);
             }
            //validar no ha sido creado el objeto Buscar una primera vez
             if (b==null){
                b=new Buscar();
                dskEscritorio.add(b);
                b.show();
             }else{//Si ya existe el formulario Buscar lo muestra
                b.setVisible(true);//Muestra en el escritorio el formulario Buscar cuando el usuario vuelve a seleccionar el submenú Empleado
            m.hide();//Oculta el formulario Mostrar cuando el usuario vuelve a seleccionar el submenú Empleado
            }

    }//GEN-LAST:event_mniEditarEmpleadoActionPerformed

    private void mniEliminarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniEliminarEmpleadoActionPerformed
             bandera=3;
             //validar si ya fue agregado el objeto Mostrar
             if (add==null){
                add = dskEscritorio.add(m);
             }
             //validar no ha sido creado el objeto Buscar una primera vez
             if (b==null){
                b=new Buscar();
                dskEscritorio.add(b);
                b.show();
             }
             else{//Si ya existe el formulario Buscar lo muestra
                b.setVisible(true);//Muestra en el escritorio el formulario Buscar cuando el usuario vuelve a seleccionar el submenú Empleado
                m.hide();//Oculta el formulario Mostrar cuando el usuario vuelve a seleccionar el submenú Empleado
             }
    }//GEN-LAST:event_mniEliminarEmpleadoActionPerformed

    private void mnuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSalirActionPerformed
       
    }//GEN-LAST:event_mnuSalirActionPerformed

    private void mniSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniSalirActionPerformed
        //Nomina
        bandera = 4;
           if (add==null){
                add = dskEscritorio.add(m);
             }
             //validar no ha sido creado el objeto Buscar una primera vez
             if (b==null){
                b=new Buscar();
                dskEscritorio.add(b);
                b.show();
             }
             else{//Si ya existe el formulario Buscar lo muestra
                b.setVisible(true);//Muestra en el escritorio el formulario Buscar cuando el usuario vuelve a seleccionar el submenú Empleado
                m.hide();//Oculta el formulario Mostrar cuando el usuario vuelve a seleccionar el submenú Empleado
             }
        
        
        
        
        
        
        
    }//GEN-LAST:event_mniSalirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
                
             
              
               
            }
        });
        
        
    }
    
    public static void mostrarFormulario(){
        
        int sexo=0;
        
        m.show();
        
        
      
        
       switch (bandera){
            
            case 1:
                 Mostrar.btnEditar.setVisible(false);//el botón debe ser public y static
                 Mostrar.btnEliminar.setVisible(false);
                 Mostrar.btnReporte.setVisible(true);
                
                 //Parte para la generacion del reporte de los gafetes y su correcta implementacion
                 Mostrar.gafetesarea.setVisible(true);
                 Mostrar.lblPuesto.setVisible(true);
                 Mostrar.btnGafete.setVisible(true);
                 Mostrar.txtPuesto.setVisible(true);
                 
                 break;
                
            case 2:
                Mostrar.btnEliminar.setVisible(false);
                Mostrar.btnEditar.setVisible(true);
                     Mostrar.btnReporte.setVisible(false);
                     
                       Mostrar.gafetesarea.setVisible(false);
                 Mostrar.lblPuesto.setVisible(false);
                 Mostrar.btnGafete.setVisible(false);
                 Mostrar.txtPuesto.setVisible(false);
                     
                     
                     
                     
                     
                break;
                
            case 3:
                Mostrar.btnEditar.setVisible(false);
                Mostrar.btnEliminar.setVisible(true);
                     Mostrar.btnReporte.setVisible(false);
                          Mostrar.gafetesarea.setVisible(false);
                 Mostrar.lblPuesto.setVisible(false);
                 Mostrar.btnGafete.setVisible(false);
                 Mostrar.txtPuesto.setVisible(false);
                     
       break;
       
            case 4: Mostrar.btnEditar.setVisible(false);
            Mostrar.btnEliminar.setVisible(false);
            Mostrar.btnNomina.setVisible(true);
                 Mostrar.btnReporte.setVisible(false);
                  Mostrar.gafetesarea.setVisible(false);
                 Mostrar.lblPuesto.setVisible(false);
                 Mostrar.btnGafete.setVisible(false);
                 Mostrar.txtPuesto.setVisible(false);
                     
        }
       
       
        
  
        if (bandera==1){
            Mostrar.btnEditar.setVisible(false);//el botón debe ser public y static
            Mostrar.btnEliminar.setVisible(false);
            Mostrar.btnReporte.setVisible(true);
             Mostrar.btnNomina.setVisible(false);
                  Mostrar.btnReporte.setVisible(true);
                  Mostrar.gafetesarea.setVisible(true);
                 Mostrar.lblPuesto.setVisible(true);
                 Mostrar.btnGafete.setVisible(true);
                 Mostrar.txtPuesto.setVisible(true);
            }else if(bandera==2){
                Mostrar.btnEliminar.setVisible(false);
                Mostrar.btnEditar.setVisible(true);  
                    Mostrar.btnNomina.setVisible(false);
                         Mostrar.btnReporte.setVisible(false);
                        Mostrar.gafetesarea.setVisible(false);
                 Mostrar.lblPuesto.setVisible(false);
                 Mostrar.btnGafete.setVisible(false);
                 Mostrar.txtPuesto.setVisible(false);
                }else if(bandera==3){
                   Mostrar.btnEditar.setVisible(false);
                   Mostrar.btnEliminar.setVisible(true);
                       Mostrar.btnNomina.setVisible(false);
                            Mostrar.btnReporte.setVisible(false);
                              Mostrar.gafetesarea.setVisible(false);
                 Mostrar.lblPuesto.setVisible(false);
                 Mostrar.btnGafete.setVisible(false);
                 Mostrar.txtPuesto.setVisible(false);
       }else if(bandera==4){
            Mostrar.btnEliminar.setVisible(false);
                Mostrar.btnEditar.setVisible(false);       
                     Mostrar.btnReporte.setVisible(false);
                     Mostrar.btnNomina.setVisible(true);
              Mostrar.gafetesarea.setVisible(false);
                 Mostrar.lblPuesto.setVisible(false);
                 Mostrar.btnGafete.setVisible(false);
                 Mostrar.txtPuesto.setVisible(false);
                
       }

        
        String estado=null;
        
        estado = empleadoBuscar.getStatus();
        if(estado.equals("1")){
            estado = "ACTIVO";
        }else{
            estado="INACTIVO";
        }
        
        
        
        String origen = null;
        String registro = null;
        
        
        origen = (String) empleadoBuscar.getOrigen();
        registro = (String) empleadoBuscar.getEstadoregistro();
        
        agregarEstados(origen,registro);
        
       Mostrar.txtId.setText(empleadoBuscar.getId()+"");
     //  Mostrar.txtEstadoRegistro.setText(empleadoBuscar.getEstadoregistro());
       Mostrar.txtNombre.setText(empleadoBuscar.getNombre());
       Mostrar.txtCurp.setText(empleadoBuscar.getCurp());
       Mostrar.txtNss.setText(empleadoBuscar.getNss());
       Mostrar.txtRfc.setText(empleadoBuscar.getRfc());
       Mostrar.txtNuevonss.setText(empleadoBuscar.getNssnuevo());
      // Mostrar.txtEstadoOrigen.setText(empleadoBuscar.getOrigen());
       Mostrar.txtEstudios.setText(empleadoBuscar.getEstudios());
       Mostrar.txtCorreo.setText(empleadoBuscar.getCorreo());
       Mostrar.txtTelefono.setText(empleadoBuscar.getTelefono());
       Mostrar.txtCuenta.setText(empleadoBuscar.getCuenta());
       Mostrar.txtOtro.setText(empleadoBuscar.getOtro());
       Mostrar.txtDireccion.setText(empleadoBuscar.getDireccion());
       Mostrar.txtEmergencia.setText(empleadoBuscar.getEmergencia());
       Mostrar.txtComentarios.setText(empleadoBuscar.getComentarios());
       Mostrar.txtHistorial.setText(empleadoBuscar.getHistorialLaboral());
       Mostrar.txtRutas.setText(empleadoBuscar.getRutasAsignadas());
       Mostrar.txtStatus.setText(estado);
       Mostrar.txtRutaFoto1.setText(empleadoBuscar.getRutaFoto());
       Mostrar.txtCarpeta.setText(empleadoBuscar.getNombre_carpeta());
        
            
             
       
      
        
      
        
          
    }
private static void agregarEstados(String origen,String registro){
       String arreglo[] ={"Aguascalientes","Baja California","Baja California Sur","Campeche","Chiapas","Chihuahua","Ciudad de México","Coahuila","Colima","Durango","Estado de México","Guanajuato","Guerrero","Hidalgo","Jalisco","Michoacán","Morelos","Nayarit","Nuevo León","Oaxaca","Puebla","Querétaro","Quintana Roo","San Luis Potosí","Sinaloa","Sonora","Tabasco","Tamaulipas","Tlaxcala","Veracruz","Yucatán","Zacatecas"};
       for(int i=0;i<32;i++){
           
          
           jcbOrigen.addItem(arreglo[i]);
       }
       
       String Actuales[]={"Cancun","Campeche","Chiapas","Cuernavaca","Puebla","Tabasco","Yucatan","Veracruz"};
       for(int i=0;i<8;i++){
           jcbRegistro.addItem(Actuales[i]);
       }
       
       int indice=0;
       int in=0;
       //registro
       for(int i=0;i<8;i++){
           if(Actuales[i].equals(registro)){
               //Aqui si son iguales 
               jcbRegistro.setSelectedIndex(i);
             }
       }
       
       for(int i=0;i<32;i++){
           if(arreglo[i].equals(origen)){
               jcbOrigen.setSelectedIndex(i);
           }
       }
      
       
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane dskEscritorio;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem mniAgregarEmpleado;
    public static javax.swing.JMenuItem mniBuscarEmpleado;
    private javax.swing.JMenuItem mniEditarEmpleado;
    private javax.swing.JMenuItem mniEliminarEmpleado;
    private javax.swing.JMenuItem mniSalir;
    private javax.swing.JMenu mnuAgregar;
    private javax.swing.JMenu mnuConsultar;
    private javax.swing.JMenu mnuEditar;
    private javax.swing.JMenu mnuEliminar;
    private javax.swing.JMenu mnuSalir;
    // End of variables declaration//GEN-END:variables
}