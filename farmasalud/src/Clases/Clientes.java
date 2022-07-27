
package Clases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import util.MySQLConexion;


public class Clientes {
    
    private String codC;
    private String nom;
    private String direc;
    private String cod_dis;
    private int telefono;
    private String ruc;
    private String dni;
    private String Estado;
    
    public String numero(){
        int j;
        String cod="";
        String c="";
        String sql="select count(*) from Cliente";
        try{
            Connection cn=MySQLConexion.getConexion();
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            if(rs.next()){
                c=rs.getString(1);
            }
            j=Integer.parseInt(c)+1;
            
            if(j<10){
                cod="C000"+j;
            }else if(j>=10 && j<100){
                cod="C00"+j;
            }else if(j>=100 && j<1000){
                cod="C0"+j;
            }else if(j>=1000 && j<10000){
                cod="C"+j;
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return cod;
    }
    
    public Clientes(){
        
    }

    public Clientes( String nom, String direc, String cod_dis, int telefono, String ruc, String dni, String Estado) {
        this.codC = numero();
        this.nom = nom;
        this.direc = direc;
        this.cod_dis = cod_dis;
        this.telefono = telefono;
        this.ruc = ruc;
        this.dni = dni;
        this.Estado = Estado;
    }

    

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDirec() {
        return direc;
    }

    public void setDirec(String direc) {
        this.direc = direc;
    }

    public String getCodC() {
        return codC;
    }

    public void setCodC(String codC) {
        this.codC = codC;
    }

    public String getCod_dis() {
        return cod_dis;
    }

    public void setCod_dis(String cod_dis) {
        this.cod_dis = cod_dis;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    
}
