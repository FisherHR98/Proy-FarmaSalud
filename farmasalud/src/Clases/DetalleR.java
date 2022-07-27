
package Clases;


public class DetalleR extends Producto{
    private String numf;
    private int cant;
    private String codp;
    private int est;

    public DetalleR() {
    }
    
    public DetalleR(String numf, int cant, String codp, int est) {
        this.numf = numf;
        this.cant = cant;
        this.codp = codp;
        this.est = est;
    }
    
    public double PrecioV(){
        return cant*precio;
    }

    public int getEst() {
        return est;
    }

    public void setEst(int est) {
        this.est = est;
    }

    public String getNumf() {
        return numf;
    }

    public void setNumf(String numf) {
        this.numf = numf;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public String getCodp() {
        return codp;
    }

    public void setCodp(String codp) {
        this.codp = codp;
    }
    
    
}
