package util;
import Clases.*;
import java.sql.*;
import javax.swing.JOptionPane;
public class MySQLConexion {
    
   
    private Statement st;
    public static Connection getConexion(){ 
		Connection con = null;
		try { Class.forName("com.mysql.jdbc.Driver"); 
		String url = "jdbc:mysql://localhost/bdfarmacia"; 
		String usr = "root";
		String psw = ""; 
		con = DriverManager.getConnection(url,usr,psw); 
		System.out.println("conexion ok");
		} catch (ClassNotFoundException ex)
		{ System.out.println("No hay Driver!!"); } 
		catch (SQLException ex) { System.out.println("Error con la BD "); }
		return con; 
    }
        
 public int logear(Empleado obj){
     
    int valor=0;  
    String xUsu=obj.getUsuario();
    String xCon=obj.getContraseña();
    try{
        Connection cn=MySQLConexion.getConexion();
        String sql="select * from empleado where usuario='"+xUsu+"' && contraseña='"+xCon+"' && estado='1'";
        PreparedStatement st=cn.prepareStatement(sql);
        ResultSet rs=st.executeQuery();
        while (rs.next()){
            valor=1; 
        }
     }catch (Exception ex){
            JOptionPane.showMessageDialog(null,"Acceso Denegado 1");
         }
     return valor;
    }
 
 
 public String ConUVend(String usu){
        String dato="";
        try{
    Connection cn=MySQLConexion.getConexion();
    String sql="SELECT cod_ven  FROM empleado WHERE  usuario=?";    
       PreparedStatement st=cn.prepareStatement(sql);
       st.setString(1, usu);
       ResultSet rs=st.executeQuery();
       while(rs.next()){
       dato=rs.getString(1);}
    }catch(Exception ex){
       ex.printStackTrace();
    }
        return dato;
    }
 
 public String ConUCargo(String usu){
        String dato="";
        try{
            Connection cn=MySQLConexion.getConexion();
            String sql="SELECT cargo FROM empleado WHERE  usuario=?";    
            PreparedStatement st=cn.prepareStatement(sql);
            st.setString(1, usu);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                dato=rs.getString(1);
                }
        }catch(Exception ex){
            ex.printStackTrace();
         }
        return dato;
    }
}

