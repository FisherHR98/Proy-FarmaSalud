
package Util;

import Clases.*;

import interfaces.*;
import java.sql.*;

import java.util.*;
import util.MySQLConexion;

public class Controlador implements interfacesProyecto{
    
    public int adicionEMP(Empleado ep){
        int respuesta=0;
        try{
            Connection cn=MySQLConexion.getConexion();
            String sql="insert into empleado(cod_ven, nom_ven, ape_ven, usuario, contraseña, cod_cargo, estado) values(?,?,?,?,?,?,?)";
            PreparedStatement st=cn.prepareStatement(sql);
            
            st.setString(1, ep.getCodigoEmp());
            st.setString(2, ep.getNombreEmpleado());
            st.setString(3, ep.getApellidoEmp());
            st.setString(4, ep.getUsuario());
            st.setString(5, ep.getContraseña());
            st.setString(6, ep.getCargoEmp());
            st.setString(7, ep.getEstado());
            
            
            respuesta=st.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return respuesta;
    } 
    
    public int actualizaEMP(Empleado ep){
        int respuesta=0;
        try{
            Connection cn=MySQLConexion.getConexion();
            String sql="update empleado set nom_ven=?, ape_ven=?, usuario=?, contraseña=?, cargo=?, estado=? where cod_ven=?";
            PreparedStatement st=cn.prepareStatement(sql);
            
            
            st.setString(1, ep.getNombreEmpleado());
            st.setString(2, ep.getApellidoEmp());
            st.setString(3, ep.getUsuario());
            st.setString(4, ep.getContraseña());
            st.setString(5, ep.getCargoEmp());
            st.setString(6, ep.getEstado());
            st.setString(7, ep.getCodigoEmp());
            
            respuesta=st.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return respuesta;
    }
    
    public int eliminaEMP(Empleado ep){
        int respuesta=0;
        try{
            Connection cn=MySQLConexion.getConexion();
            String sql="update empleado set estado=? where cod_ven=?";
            PreparedStatement st=cn.prepareStatement(sql);

            st.setString(1, ep.getEstado());
            st.setString(2, ep.getCodigoEmp());
            
            respuesta=st.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return respuesta;
    }
    
    public List<Empleado> listadoEMP(){
       List<Empleado> lista=new ArrayList();
       try{
           Connection cn=MySQLConexion.getConexion();
           String sql="select cod_ven, nom_ven, ape_ven, usuario, contraseña, cargo, estado from empleado";
           PreparedStatement st=cn.prepareStatement(sql);
           ResultSet rs=st.executeQuery();
           while(rs.next()){
               Empleado ep = new Empleado();
               ep.setCodigoEmp(rs.getString(1));
               ep.setNombreEmpleado(rs.getString(2));
               ep.setApellidoEmp(rs.getString(3));
               ep.setUsuario(rs.getString(4));
               ep.setContraseña(rs.getString(5));
               ep.setCargoEmp(rs.getString(6));
               ep.setEstado(rs.getString(7));
               lista.add(ep);               
           }
           
       }catch(Exception ex){
            ex.printStackTrace();
        }
     return lista;         
    }
    
    public Empleado ConsultaEMP(String cod){
       Empleado ep=null;
       try{
           Connection cn=MySQLConexion.getConexion();
           String sql="select cod_ven, nom_ven, ape_ven, usuario, contraseña, cargo, estado from empleado where cod_ven=?";
           PreparedStatement st=cn.prepareStatement(sql);
           st.setString(0, cod);
           ResultSet rs=st.executeQuery();
           while(rs.next()){
               ep = new Empleado();
               ep.setCodigoEmp(rs.getString(1));
               ep.setNombreEmpleado(rs.getString(2));
               ep.setApellidoEmp(rs.getString(3));
               ep.setUsuario(rs.getString(4));
               ep.setContraseña(rs.getString(5));
               ep.setCargoEmp(rs.getString(6));
               ep.setEstado(rs.getString(7));                   
           }    
       }catch(Exception ex){
            ex.printStackTrace();
        }
     return ep;         
    }
    
//Avance 3    
    
    
    public List<Producto> listadoPRO(){
       List<Producto> lista=new ArrayList();
       try{
           Connection cn=MySQLConexion.getConexion();
           String sql="SELECT p.cod_pro, p.des_pro, p.precio, m.nom_marca, "
                   + "p.estado, p.stock FROM producto p JOIN marca m on m.cod_marca=p.cod_marca ORDER BY p.cod_pro asc";
           PreparedStatement st=cn.prepareStatement(sql);
           ResultSet rs=st.executeQuery();
           while(rs.next()){
               Producto ep = new Producto();
               ep.setCodPro(rs.getString(1));
               ep.setDesc(rs.getString(2));
               ep.setPrecio(rs.getDouble(3));
               ep.setCodMarca(rs.getString(4));
               ep.setEstado(rs.getString(5)); 
               ep.setStock(rs.getInt(6));
               lista.add(ep);               
           }
           
       }catch(Exception ex){
            ex.printStackTrace();
        }
     return lista;         
    }
    
    public List<Producto> LisProNom(String id){
    List<Producto> lista=new ArrayList();  
    try{
    Connection cn=MySQLConexion.getConexion();
    String sql="SELECT p.cod_pro, p.des_pro, p.precio, m.nom_marca, p.estado, p.stock "
            + "FROM producto p JOIN marca m on m.cod_marca=p.cod_marca WHERE p.des_pro like ? ORDER BY p.cod_pro asc ";    
       PreparedStatement st=cn.prepareStatement(sql);
       st.setString(1, id+"%");
       ResultSet rs=st.executeQuery();
       while(rs.next()){
        Producto  p=new Producto();
        p.setCodPro(rs.getString(1));
        p.setDesc(rs.getString(2));
        p.setPrecio(rs.getDouble(3));
        p.setCodMarca(rs.getString(4));
        p.setEstado(rs.getString(5));
        p.setStock(rs.getInt(6));
        lista.add(p);
       }
    }catch(Exception ex){
       ex.printStackTrace();
    }   
    return lista;   
  }
    
    @Override
    public List<Producto> LisProCod(String id){
    List<Producto> lista=new ArrayList();  
    try{
    Connection cn=MySQLConexion.getConexion();
    String sql="SELECT cod_pro, des_pro, precio, cod_marca, estado, stock FROM Producto WHERE cod_pro=?";    
       PreparedStatement st=cn.prepareStatement(sql);
       st.setString(1, id);
       ResultSet rs=st.executeQuery();
       while(rs.next()){
        Producto  p=new Producto();
        p.setCodPro(rs.getString(1));
        p.setDesc(rs.getString(2));
        p.setPrecio(rs.getDouble(3));
        p.setCodMarca(rs.getString(4));
        p.setEstado(rs.getString(5));
        p.setStock(rs.getInt(6));
        lista.add(p);
       }
    }catch(Exception ex){
       ex.printStackTrace();
    }   
    return lista;   
  }
    

    @Override
    public List<Clientes> listadoCli() {
        List<Clientes> lista=new ArrayList();  
    try{
    Connection cn=MySQLConexion.getConexion();
    String sql="SELECT cod_cli, nom_cli, dni, ruc, telefono, cod_dis, direccion, estado  FROM cliente ";    
       PreparedStatement st=cn.prepareStatement(sql);
       ResultSet rs=st.executeQuery();
       while(rs.next()){
       Clientes  p=new Clientes();
        p.setCodC(rs.getString(1));
        p.setNom(rs.getString(2));
        p.setDni(rs.getString(3));
        p.setRuc(rs.getString(4));
        p.setTelefono(rs.getInt(5));
        p.setCod_dis(rs.getString(6));
        p.setDirec(rs.getString(7));
        p.setEstado(rs.getString(8));
        lista.add(p);
           
       }
    }catch(Exception ex){
       ex.printStackTrace();
    }   
    return lista;
    }

    @Override
    public int adicionCli(Clientes cl) {
        int respuesta=0;
        try{
            Connection cn=MySQLConexion.getConexion();
            String sql="INSERT INTO cliente(cod_cli, nom_cli, dni, cod_dis, telefono, estado,ruc, direccion) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement st=cn.prepareStatement(sql);
            
            st.setString(1, cl.getCodC());
            st.setString(2, cl.getNom());
            st.setString(3, cl.getDni());
            st.setString(4, cl.getCod_dis());
            st.setInt(5, cl.getTelefono());
            st.setString(6, cl.getEstado());
            st.setString(7, cl.getRuc());
            st.setString(8, cl.getDirec());
            
            
            respuesta=st.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return respuesta;
    }

    @Override
    public List<Clientes> LisCliDNI(String id) {
        List<Clientes> lista=new ArrayList();  
    try{
    Connection cn=MySQLConexion.getConexion();
    String sql="SELECT cod_cli, nom_cli, dni, ruc, telefono, cod_dis, direccion, estado  FROM cliente WHERE ruc is null and dni like ?";    
       PreparedStatement st=cn.prepareStatement(sql);
       st.setString(1, id+"%");
       ResultSet rs=st.executeQuery();
       while(rs.next()){
        Clientes  p=new Clientes();
        p.setCodC(rs.getString(1));
        p.setNom(rs.getString(2));
        p.setDni(rs.getString(3));
        p.setRuc(rs.getString(4));
        p.setTelefono(rs.getInt(5));
        p.setCod_dis(rs.getString(6));
        p.setDirec(rs.getString(7));
        p.setEstado(rs.getString(8));
        lista.add(p);
       }
    }catch(Exception ex){
       ex.printStackTrace();
    }   
    return lista;   
    }

    @Override
    public List<Clientes> LisCliRUC(String id) {
        List<Clientes> lista=new ArrayList();  
    try{
    Connection cn=MySQLConexion.getConexion();
    String sql="SELECT cod_cli, nom_cli, dni, ruc, telefono, cod_dis, direccion, estado  FROM cliente WHERE dni is null and ruc like ?";    
       PreparedStatement st=cn.prepareStatement(sql);
       st.setString(1, id+"%");
       ResultSet rs=st.executeQuery();
       while(rs.next()){
        Clientes  p=new Clientes();
        p.setCodC(rs.getString(1));
        p.setNom(rs.getString(2));
        p.setDni(rs.getString(3));
        p.setRuc(rs.getString(4));
        p.setTelefono(rs.getInt(5));
        p.setCod_dis(rs.getString(6));
        p.setDirec(rs.getString(7));
        p.setEstado(rs.getString(8));
        lista.add(p);
       }
    }catch(Exception ex){
       ex.printStackTrace();
    }   
    return lista;   
    }

    @Override
    public List<Clientes> LisCliCod(String id) {
        List<Clientes> lista=new ArrayList();  
    try{
    Connection cn=MySQLConexion.getConexion();
    String sql="SELECT cod_cli, nom_cli, dni, ruc, telefono, cod_dis, direccion, estado  FROM cliente WHERE cod_cli=?";    
       PreparedStatement st=cn.prepareStatement(sql);
       st.setString(1, id);
       ResultSet rs=st.executeQuery();
       while(rs.next()){
        Clientes  p=new Clientes();
        p.setCodC(rs.getString(1));
        p.setNom(rs.getString(2));
        p.setDni(rs.getString(3));
        p.setRuc(rs.getString(4));
        p.setTelefono(rs.getInt(5));
        p.setCod_dis(rs.getString(6));
        p.setDirec(rs.getString(7));
        p.setEstado(rs.getString(8));
        lista.add(p);
       }
    }catch(Exception ex){
       ex.printStackTrace();
    }   
    return lista;   }
    
    
    public int actualizaCli(Clientes cl){
        int respuesta=0;
        try{
            Connection cn=MySQLConexion.getConexion();
            String sql="update cliente set nom_cli=?, dni=?, cod_dis=?, telefono=?, estado=?, ruc=?, direccion=? where cod_cli=?";
            PreparedStatement st=cn.prepareStatement(sql);

            st.setString(1, cl.getNom());
            st.setString(2, cl.getDni());
            st.setString(3, cl.getCod_dis());
            st.setInt(4, cl.getTelefono());
            st.setString(5, cl.getEstado());
            st.setString(6, cl.getRuc());
            st.setString(7, cl.getDirec());
            st.setString(8, cl.getCodC());
            
            respuesta=st.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return respuesta;
    }
    
    public int eliminaCli(Clientes ep){
        int respuesta=0;
        try{
            Connection cn=MySQLConexion.getConexion();
            String sql="update cliente set estado=? where cod_cli=?";
            PreparedStatement st=cn.prepareStatement(sql);

            st.setString(1, ep.getEstado());
            st.setString(2, ep.getCodC());
            
            respuesta=st.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return respuesta;
    }
    
    public String ConDis(String id){
        String dato="";
        try{
    Connection cn=MySQLConexion.getConexion();
    String sql="SELECT cod_dis  FROM distrito WHERE nom_dis=?";    
       PreparedStatement st=cn.prepareStatement(sql);
       st.setString(1, id);
       ResultSet rs=st.executeQuery();
       while(rs.next()){
       dato=rs.getString(1);}
    }catch(Exception ex){
       ex.printStackTrace();
    }
        return dato;
    }
    
    public String CodANom(String id){
        String dato="";
        try{
    Connection cn=MySQLConexion.getConexion();
    String sql="SELECT nom_dis  FROM distrito WHERE cod_dis=?";    
       PreparedStatement st=cn.prepareStatement(sql);
       st.setString(1, id);
       ResultSet rs=st.executeQuery();
       while(rs.next()){
       dato=rs.getString(1);}
    }catch(Exception ex){
       ex.printStackTrace();
    }
        return dato;
    }
    
    public List<Distrito> LisDis() {
        List<Distrito> lista=new ArrayList();  
    try{
    Connection cn=MySQLConexion.getConexion();
    String sql="SELECT * FROM distrito";    
       PreparedStatement st=cn.prepareStatement(sql);
       ResultSet rs=st.executeQuery();
       while(rs.next()){
        Distrito  p=new Distrito();
        p.setCodigoDis(rs.getString(1));
        p.setNombreDis(rs.getString(2));
        p.setEstado(rs.getString(3));
        lista.add(p);
       }
    }catch(Exception ex){
       ex.printStackTrace();
    }   
    return lista;   }
    
////////////Agrega fac///////////////    
    public int AgregaFac(Factura f) {
        int respuesta=0;
        try{
        Connection cn=MySQLConexion.getConexion();
        String sql="{call SP_ADIFACT(?,?,?,?,?,?)}";    
        CallableStatement st = cn.prepareCall(sql);
        
            st.setString(1, f.getFecha());
            st.setString(2, f.getIgv());
            st.setString(3, f.getCodigoEmp());
            st.setString(4, f.getCodCli());
            st.setInt(5, f.getEstado());
            st.setString(6, f.getTp());
            respuesta=st.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return respuesta;
    }
    
    public int AgregaB(Factura f) {
        int respuesta=0;
        try{
        Connection cn=MySQLConexion.getConexion();
        String sql="{call SP_ADIREC(?,?,?,?,?,?)}";    
        CallableStatement st = cn.prepareCall(sql);
        
            st.setString(1, f.getFecha());
            st.setString(2, f.getIgv());
            st.setString(3, f.getCodigoEmp());
            st.setString(4, f.getCodCli());
            st.setInt(5, f.getEstado());
            st.setString(6, f.getTp());
            respuesta=st.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return respuesta;
    }
    
    public int AgregaDET(DetalleR d) {
        int respuesta=0;
        try{
        Connection cn=MySQLConexion.getConexion();
        String sql="{call SP_ADIDETA(?,?,?,?)}";    
        CallableStatement st = cn.prepareCall(sql);
            st.setString(1, d.getNumf());
            st.setString(2, d.getCodp());
            st.setInt(3, d.getCant());
            st.setInt(4, d.getEst());
            respuesta=st.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return respuesta;
    }
    
    public String NroFac(){
        String dato="";
        try{
    Connection cn=MySQLConexion.getConexion();
    String sql="SELECT COALESCE(MAX(NUM_FAC),0) FROM FACTURAC";    
       PreparedStatement st=cn.prepareStatement(sql);
       ResultSet rs=st.executeQuery();
       while(rs.next()){
       dato=rs.getString(1);}
    }catch(Exception ex){
       ex.printStackTrace();
    }
        return dato;
    }
    
    public List<Factura> listadoR(String id){
    List<Factura> lista=new ArrayList();  
    try{
    Connection cn=MySQLConexion.getConexion();
    String sql="SELECT num_fac, fecha_fac, igv_rec, cod_ven, estado, cod_cli, tipo, guia_remi FROM facturac where cod_cli=?";    
       PreparedStatement st=cn.prepareStatement(sql);
       st.setString(1, id);
       ResultSet rs=st.executeQuery();
       while(rs.next()){
       Factura p=new Factura();
        p.setNumRecibo(rs.getString(1));
        p.setFecha(rs.getString(2));
        p.setIgv(rs.getString(3));
        p.setCodigoEmp(rs.getString(4));
        p.setEstado((rs.getInt(5)));
        p.setCodCli(rs.getString(6));
        p.setTp(rs.getString(7));
        p.setGremi(rs.getString(8));
        lista.add(p);
           
       }
    }catch(Exception ex){
       ex.printStackTrace();
    }   
    return lista;
    }
    
    
    public List<DetalleR> listadoD(String id){
    List<DetalleR> lista=new ArrayList();  
    try{
    Connection cn=MySQLConexion.getConexion();
    String sql="SELECT d.num_fac, p.cod_marca, p.cod_pro, d.cant_pro, p.precio, d.estado "
            + "FROM detalle_recibo d join producto p ON p.cod_pro=d.cod_pro where d.num_fac=?";    
       PreparedStatement st=cn.prepareStatement(sql);
       st.setString(1, id);
       ResultSet rs=st.executeQuery();
       while(rs.next()){
       DetalleR p=new DetalleR();
        p.setNumf(rs.getString(1));
        p.setCodMarca(rs.getString(2));
        p.setCodp(rs.getString(3));
        p.setCant(rs.getInt(4));
        p.setPrecio(rs.getDouble(5));
        p.setEst(rs.getInt(6));
        lista.add(p);
           
       }
    }catch(Exception ex){
       ex.printStackTrace();
    }   
    return lista;
    }
    
    
    public List<ReciboGraf> LisRecibo(int an){
        List<ReciboGraf> lista=new ArrayList();  
        try{
        Connection cn=MySQLConexion.getConexion();
        String sql="{call sp_RegistroVentas(?)}";    
           CallableStatement st= cn.prepareCall(sql);
            st.setInt(1, an);
           ResultSet rs=st.executeQuery();
           while(rs.next()){
            ReciboGraf p=new ReciboGraf();
            p.setFecha(rs.getString(1));
            p.setCod_ven(rs.getString(2));
            p.setNom_ven(rs.getString(3));
            p.setMonto(rs.getDouble(4));
            lista.add(p);
           }
        }catch(Exception ex){
           ex.printStackTrace();
        }   
        return lista;
        }

    public List<FacturaD> CantVendida(){
        List<FacturaD> lista=new ArrayList();  
        try{
        Connection cn=MySQLConexion.getConexion();
        String sql="SELECT SUM(d.cant_pro), p.cod_pro, p.precio, p.des_pro from detalle_recibo d join producto p on(p.cod_pro=d.cod_pro) GROUP by p.cod_pro;";    
           PreparedStatement st=cn.prepareStatement(sql);
           ResultSet rs=st.executeQuery();
           while(rs.next()){
            FacturaD p=new FacturaD();
            p.setCant_pro(rs.getInt(1));
            p.setCod_pro(rs.getString(2));
            p.setDesc_pro(rs.getString(3));
            lista.add(p);
           }
        }catch(Exception ex){
           ex.printStackTrace();
        }   
        return lista;
        }
    
    public int AdicionDis(Distrito di){
        int respuesta=0;
        try{
            Connection cn=MySQLConexion.getConexion();
            String sql="insert into distrito(cod_dis, nom_dis, estado) values(?,?,?)";
            PreparedStatement st=cn.prepareStatement(sql);
            
            st.setString(1, di.getCodigoDis());
            st.setString(2, di.getNombreDis());
            st.setString(3, di.getEstado());
            
            respuesta=st.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return respuesta;
    }
    
    public int AdicionMar(Marca m){
        int respuesta = 0;
        try{
            Connection cn=MySQLConexion.getConexion();
            String sql="insert into Marca(cod_marca, nom_marca) values(?,?)";
            PreparedStatement st=cn.prepareStatement(sql);
            
            st.setString(1, m.getCodMarca());
            st.setString(2, m.getNomMarca());
            
            respuesta=st.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
    }
        return respuesta;
    }
    
    public int eliminarDis(Distrito di){
        int respuesta =0;
        try{
            Connection cn=MySQLConexion.getConexion();
            String sql="update distrito set estado=? where cod_dis=?";
            PreparedStatement st=cn.prepareStatement(sql);
            
            st.setString(1, di.getEstado());
            st.setString(2, di.getCodigoDis());
            
            respuesta=st.executeUpdate();
            
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return respuesta;
    }
    
    public int eliminaM(Marca m){
        int respuesta =0;
        try{
            Connection cn=MySQLConexion.getConexion();
            String sql="DELETE FROM Marca WHERE cod_Marca=?";
            PreparedStatement st=cn.prepareStatement(sql);
            
            st.setString(1, m.getCodMarca());
            st.setString(2, m.getNomMarca());
            
            respuesta=st.executeUpdate();
            
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return respuesta;
    }
    
    public int actualizaDi(Distrito di){
        int respuesta=0;
        try{
            Connection cn=MySQLConexion.getConexion();
            String sql="update distrito set cod_dis=?, nom_dis=?,estado=? where cod_dis=?";
            PreparedStatement st=cn.prepareStatement(sql);
            
            st.setString(1, di.getCodigoDis());
            st.setString(2, di.getNombreDis());
            st.setString(3, di.getEstado());
            
            respuesta=st.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return respuesta;
    }
    
    public int actualizaM(Marca m){
        int respuesta=0;
        try{
            Connection cn=MySQLConexion.getConexion();
            String sql="update Marca set cod_marca=?, nom_marca=? where cod_marca=?";
            PreparedStatement st=cn.prepareStatement(sql);
            
            st.setString(1, m.getCodMarca());
            st.setString(2, m.getNomMarca());
            respuesta=st.executeUpdate();
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return respuesta;
    }
    
      
    public List<Marca> LisMar(){
        List<Marca> lista=new ArrayList();
        try{
            Connection cn = MySQLConexion.getConexion();
            String sql = "Select * From Marca";
            PreparedStatement st=cn.prepareCall(sql);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                Marca m = new Marca();
                m.setCodMarca(rs.getString(1));
                m.setNomMarca(rs.getString(2));
                lista.add(m);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return lista;
    }
    
    public int agregaStock(String cod, int cant){
        int respuesta=0;
        try{
            Connection cn=MySQLConexion.getConexion();
            String sql="update producto set stock=(select stock from producto where cod_pro=?)+? where cod_pro=?";
            PreparedStatement st=cn.prepareStatement(sql);
            st.setString(1, cod);
            st.setInt(2, cant);
            st.setString(3, cod);
            respuesta=st.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return respuesta;
    }
    
    public int restaStock(String cod, int cant){
        int respuesta=0;
        try{
            Connection cn=MySQLConexion.getConexion();
            String sql="update producto set stock=(select stock from producto where cod_pro=?)-? where cod_pro=?";
            PreparedStatement st=cn.prepareStatement(sql);
            st.setString(1, cod);
            st.setInt(2, cant);
            st.setString(3, cod);
            respuesta=st.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return respuesta;
    }
    
    public int adicionPRO(Producto p){
        int respuesta=0;
        try{
            Connection cn=MySQLConexion.getConexion();
            String sql="insert into producto(cod_pro, des_pro, precio, stock, cod_marca, estado) values(?,?,?,?,?,?)";
            PreparedStatement st=cn.prepareStatement(sql);
            
            st.setString(1, p.getCodPro());
            st.setString(2, p.getDesc());
            st.setDouble(3, p.getPrecio());
            st.setInt(4, p.getStock());
            st.setString(5, p.getCodMarca());
            st.setString(6, p.getEstado());
            
            
            respuesta=st.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return respuesta;
    }
    
    public int eliminaPRO(Producto p){
        int respuesta=0;
        try{
            Connection cn=MySQLConexion.getConexion();
            String sql="update producto set estado=? where cod_pro=?";
            PreparedStatement st=cn.prepareStatement(sql);

            st.setString(1, p.getEstado());
            st.setString(2, p.getCodPro());
            
            respuesta=st.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return respuesta;
    }
    
    public int actualizaPRO(Producto p){
        int respuesta=0;
        try{
            Connection cn=MySQLConexion.getConexion();
            String sql="update empleado set des_pro=?, precio=?, stock=?, cod_marca=?, estado=? where cod_pro=?";
            PreparedStatement st=cn.prepareStatement(sql);
            
            
            st.setString(1, p.getDesc());
            st.setDouble(2, p.getPrecio());
            st.setInt(3, p.getStock());
            st.setString(4, p.getCodMarca());
            st.setString(5, p.getEstado());
            st.setString(6, p.getCodPro());
            
            respuesta=st.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return respuesta;
    }
    
    public String ConMarc(String id){
        String dato="";
        try{
    Connection cn=MySQLConexion.getConexion();
    String sql="SELECT cod_marca FROM `marca` WHERE nom_marca=?";    
       PreparedStatement st=cn.prepareStatement(sql);
       st.setString(1, id);
       ResultSet rs=st.executeQuery();
       while(rs.next()){
       dato=rs.getString(1);}
    }catch(Exception ex){
       ex.printStackTrace();
    }
        return dato;
    }
    
    public int obStock(String id){
        int dato=0;
        try{
    Connection cn=MySQLConexion.getConexion();
    String sql="SELECT stock FROM producto WHERE cod_pro=?";    
       PreparedStatement st=cn.prepareStatement(sql);
       st.setString(1, id);
       ResultSet rs=st.executeQuery();
       while(rs.next()){
       dato=rs.getInt(1);}
    }catch(Exception ex){
       ex.printStackTrace();
    }
        return dato;
    }
    
    public String obEmp(String id){
        String dato="";
        try{
    Connection cn=MySQLConexion.getConexion();
    String sql="SELECT nom_ven, ape_ven FROM empleado WHERE cod_ven=?";    
       PreparedStatement st=cn.prepareStatement(sql);
       st.setString(1, id);
       ResultSet rs=st.executeQuery();
       while(rs.next()){
       dato=rs.getString(1)+" "+rs.getString(2);}
    }catch(Exception ex){
       ex.printStackTrace();
    }
        return dato;
    }
    
}
