package Clases;

public class Distrito {
 private String codigoDis;
 private String nombreDis;
 private String estado;

    public Distrito() {
    }

    public Distrito(String codigoDis, String nombreDis, String estado) {
        this.codigoDis = codigoDis;
        this.nombreDis = nombreDis;
        this.estado = estado;
    }
    
    

    public String getCodigoDis() {
        return codigoDis;
    }

    public void setCodigoDis(String codigoDis) {
        this.codigoDis = codigoDis;
    }

    public String getNombreDis() {
        return nombreDis;
    }

    public void setNombreDis(String nombreDis) {
        this.nombreDis = nombreDis;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    } 
}
