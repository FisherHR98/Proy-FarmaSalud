
package Clases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import util.MySQLConexion;


public class Producto {
    private String codPro;
    private String desc;
    private String codMarca;
    private int stock;
    public double precio;
    private String estado;

    public Producto() {
    }

    public String numero(){
        int j;
        String cod="";
        String c="";
        String sql="select count(*) from producto";
        try{
            Connection cn=MySQLConexion.getConexion();
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            if(rs.next()){
                c=rs.getString(1);
            }
            j=Integer.parseInt(c)+1;
            
            if(j<10){
                cod="PR00"+j;
            }else if(j>=10 && j<100){
                cod="PR0"+j;
            }else if(j>=100 && j<1000){
                cod="PR"+j;
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return cod;
    }

    public Producto(String desc, String codMarca, int stock, double precio, String estado) {
        this.codPro = numero();
        this.desc = desc;
        this.codMarca = codMarca;
        this.precio = precio;
        this.estado = estado;
        this.stock=stock;
    }

    

    public String getCodPro() {
        return codPro;
    }

    public void setCodPro(String codPro) {
        this.codPro = codPro;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCodMarca() {
        return codMarca;
    }

    public void setCodMarca(String codMarca) {
        this.codMarca = codMarca;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    
}
