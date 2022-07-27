package Clases;
import java.sql.*;

import java.text.DecimalFormat;
import util.MySQLConexion;


public final class Empleado {
 private String codigoEmp;
 private String nombreEmpleado;
 private String apellidoEmp;
 private String cargoEmp;
 private String usuario;
 private String contraseña;
 private String estado;
 

    public Empleado() {
    }
    
    public String numero(){
        int j;
        String cod="";
        String c="";
        String sql="select count(*) from empleado";
        try{
            Connection cn=MySQLConexion.getConexion();
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            if(rs.next()){
                c=rs.getString(1);
            }
            j=Integer.parseInt(c)+1;
            
            if(j<10){
                cod="E000"+j;
            }else if(j>=10 && j<100){
                cod="E00"+j;
            }else if(j>=100 && j<1000){
                cod="E0"+j;
            }else if(j>=1000 && j<10000){
                cod="E"+j;
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return cod;
    }

    public Empleado(String nombreEmpleado, String apellidoEmp, String cargoEmp, String usuario, String contraseña, String estado) {
        this.codigoEmp = numero();
        this.nombreEmpleado = nombreEmpleado;
        this.apellidoEmp = apellidoEmp;
        this.cargoEmp = cargoEmp;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.estado = estado;
        
    }

    public String getCodigoEmp() {
        return codigoEmp;
    }

    public void setCodigoEmp(String codigoEmp) {
        this.codigoEmp = codigoEmp;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getApellidoEmp() {
        return apellidoEmp;
    }

    public void setApellidoEmp(String apellidoEmp) {
        this.apellidoEmp = apellidoEmp;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCargoEmp() {
        return cargoEmp;
    }

    public void setCargoEmp(String cargoEmp) {
        this.cargoEmp = cargoEmp;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }    

    
}

