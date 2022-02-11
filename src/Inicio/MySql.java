
package Inicio;

import java.sql.Connection;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;



public class MySql {
    private static Connection Conexion;
    
    public static Empleado empleadoBuscar = new Empleado();
    
    public void MySQLConnection(String user, String pass, String db_name) throws Exception {
        try {
            
            String url="jdbc:mysql://localhost:3306/"+db_name+"?serverTimezone=UTC";
            
            Class.forName("com.mysql.cj.jdbc.Driver");
             
            Conexion = (Connection) DriverManager.getConnection( url,user, pass);
          
           
        } catch (ClassNotFoundException | SQLException ex) {
           
            JOptionPane.showMessageDialog(null,"Error al acceder a la base de datos"+ex);
              Logger.getLogger(MySql.class.getName()).log(Level.SEVERE, null, ex);
              
 }
        
        
        
 }
    
     public void closeConnection() throws SQLException {
         Conexion.close();
     }
 
     
     public static String getValues() {
       String consultaUser = null;

        try {
            String q = "select max(id) from trabajadores" ;
            Statement st = Conexion.createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(q);

           while (resultSet.next()) {
             consultaUser = resultSet.getString("id");
               System.out.println("ID MAXIMO"+consultaUser);
             //JOptionPane.showMessageDialog(null, "hola " + consultaUser);
           }
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
 }
 return consultaUser;
 }


     
     public int updateRegistro(){
         
           String consulta = null;
           int res=0;

           try {
           consulta = "UPDATE trabajadores SET estadoregistro= '"+empleadoBuscar.getEstadoregistro()+"',nombre='"+empleadoBuscar.getNombre() +"',curp='"+empleadoBuscar.getCurp()+"',nss='"+empleadoBuscar.getNss()+"',rfc='"+empleadoBuscar.getRfc()+"',nssnuevo='"+empleadoBuscar.getNssnuevo()+"',origen='"+empleadoBuscar.getOrigen()+"',estudios='"+empleadoBuscar.getEstudios()+"',correo='"+empleadoBuscar.getCorreo()+"',telefono='"+empleadoBuscar.getTelefono()+"',cuenta='"+empleadoBuscar.getCuenta()+"',otro='"+empleadoBuscar.getOtro()+"',direccion='"+empleadoBuscar.getDireccion()+"',emergencia='"+empleadoBuscar.getEmergencia()+"',comentarios='"+empleadoBuscar.getComentarios()+"',historialLaboral='"+empleadoBuscar.getHistorialLaboral()+"',rutasAsignadas='"+empleadoBuscar.getRutasAsignadas()+"',rutaFoto='"+empleadoBuscar.getRutaFoto()+"'WHERE id="+empleadoBuscar.getId()+"";

           //El método createStatement() crear un objeto de la clase Statement que provee la infraestructura para ejecutar sentencias SQL sobre una conexión con una basede datos
            Statement st = Conexion.createStatement();

           //el métodos executeUpdate() se usa para sentencias SQL que impliquen modificaciones en la base de datos (INSERT, UPDATE, DELETE, etc).
            st.executeUpdate(consulta);

            res=1;
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar los datos"+ex);
            }

            return res;
        }
        
     
     public int insertarRegistro(String estadoregistro, String nombre, String curp,String nss,String rfc,String nssnuevo,String origen, String estudios, String correo,String telefono,String cuenta,String otro,String direccion,String emergencia,String comentarios,String historialLaboral, String rutasAsignadas,String estatus,String rutaFoto,String fecharegistro,String nombre_carpeta) {
         String consulta = null;
         int res=0;
         
         try {
     String sql="INSERT INTO trabajadores(estadoregistro,nombre,curp,nss,rfc,nssnuevo,origen,estudios,correo,telefono,cuenta,otro,direccion,emergencia,comentarios,historialLaboral,rutasAsignadas,status,rutaFoto,fecha_registro,nombre_carpeta) VALUES ('"+estadoregistro+"','"+nombre+"','"+curp+"','"+nss+"','"+rfc+"','"+nssnuevo+"','"+origen+"','"+estudios+"','"+correo+"','"+telefono+"','"+cuenta+"','"+otro+"','"+direccion+"','"+emergencia+"','"+comentarios+"','"+historialLaboral+"','"+rutasAsignadas+"','"+estatus+"','"+rutaFoto+"','"+fecharegistro+"','"+nombre_carpeta+"')";
             System.out.println("Ruta Foto"+rutaFoto);
             
             
             Statement st = Conexion.createStatement();
            
            st.executeUpdate(sql);
         
            res=1;

            
            
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "No se ha podido agregar a la base de datos"+ex);
          
        }      
       
         return res;
     
     }
     
     
     
  //método para buscar al empleado
     
     
     
     
  public int buscarEmpleado(String nombre,String estadoregistro) throws SQLException {
       int consulta = 0;
       String status="1";
      
   int id=0;
       
       try {
           
    String sql="SELECT * FROM trabajadores where(nombre='"+nombre+"' && estadoregistro= '"+estadoregistro+"')";
 
            Statement st = Conexion.createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(sql);
            String datos[] = new String[20];
            String reconstruir;
        while (resultSet.next()){
            consulta=1;
            id = resultSet.getInt("id");
            empleadoBuscar.setId(id);
            
         datos[0] = resultSet.getString("estadoregistro");
         empleadoBuscar.setEstadoregistro(datos[0]);
         datos[1] = resultSet.getString("nombre");
         empleadoBuscar.setNombre(datos[1]);
            datos[2] = resultSet.getString("curp");
            empleadoBuscar.setCurp(datos[2]);
               datos[3] = resultSet.getString("nss");
               empleadoBuscar.setNss(datos[3]);
                  datos[4] = resultSet.getString("rfc");
                  empleadoBuscar.setRfc(datos[4]);
                     datos[5] = resultSet.getString("nssnuevo");
                     empleadoBuscar.setNssnuevo(datos[5]);
                     datos[6] =resultSet.getString("origen");
                     empleadoBuscar.setOrigen(datos[6]);
                     datos[7] =resultSet.getString("estudios");
                     empleadoBuscar.setEstudios(datos[7]);
                        datos[8] = resultSet.getString("correo");
                        empleadoBuscar.setCorreo(datos[8]);
                           datos[9] = resultSet.getString("telefono");
                           empleadoBuscar.setTelefono(datos[9]);
                              datos[10] = resultSet.getString("cuenta");
                              empleadoBuscar.setCuenta(datos[10]);
                                 datos[11] = resultSet.getString("otro");
                                 empleadoBuscar.setOtro(datos[11]);
                                   datos[12] = resultSet.getString("direccion");
                                   empleadoBuscar.setDireccion(datos[12]);
                                     datos[13] = resultSet.getString("emergencia");
                                     empleadoBuscar.setEmergencia(datos[13]);
                                       datos[14] = resultSet.getString("comentarios");
                                       empleadoBuscar.setComentarios(datos[14]);
                                         datos[15] = resultSet.getString("historialLaboral");
                                         empleadoBuscar.setHistorialLaboral(datos[15]);
                                         datos[16] =resultSet.getString("rutasAsignadas");
                                         empleadoBuscar.setRutasAsignadas(datos[16]);
                                         datos[17] = resultSet.getString("status");
                                         empleadoBuscar.setStatus(datos[17]);
                                         
                                         datos[18] = resultSet.getString("rutaFoto");
              //Procesar la imagen para volver a construir la ruta anterior                            
                                         datos[19] = resultSet.getString("nombre_carpeta");
                                         empleadoBuscar.setNombre_carpeta(datos[19]);
                                         
                                  reconstruir = "C:\\BASEDATOS\\"+datos[0]+"\\"+datos[19]+"\\"+datos[18];       
                                         
                                try {
                   rsscalelabel.RSScaleLabel.setScaleLabel(Mostrar.lblFoto2,reconstruir);
                                         empleadoBuscar.setRutaFoto(datos[18]);
                                    System.out.println("Ruta DE PRUEBA"+reconstruir);
                                    
                                    
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Error"+e);
            }
                                       
                                         
                   
        }
       }
       catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la adquisición de datos"+ex);
       }
       

       return consulta;
        }
  
  
  
  
  
  
    public int eliminarRegistro(){
        String consulta = null;
        int res=0;

        try {
            //UPDATE trabajadores set status=0 where id=3
       consulta = "UPDATE trabajadores SET status="+ 0 +" WHERE id="+ empleadoBuscar.getId()+"";
        Statement st = Conexion.createStatement();

        st.executeUpdate(consulta);

        res=1;
        }
        catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al actualizar los datos"+ex);
        }
        return res;
    }
public int agregarNomina(String id,String fecha,String archivo){
    int respuesta=0;
    String consulta = "INSERT INTO nominatrabajadores(id,fecha, archivo) VALUES ('"+id+"','"+fecha+"','"+archivo+"')";
    
    try {
         Statement st = Conexion.createStatement();
            
            st.executeUpdate(consulta);
         
            respuesta=1;

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null,"Error al registrar la nomina"+e);

    }
    
    
     
    
    
    return respuesta;
}


}

