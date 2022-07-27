
package Clases;

public class Factura extends Recibo{
    String gremi;

    public Factura() {
    }
    
    

    public Factura(String Fecha, String igv, String CodigoEmp, int Estado, String codCli, String tp, String gremi) {
        super(Fecha, igv, CodigoEmp, Estado, codCli, tp);
        this.gremi = gremi;
    }

    public String getGremi() {
        return gremi;
    }

    public void setGremi(String gremi) {
        this.gremi = gremi;
    }
    
    
    
}
