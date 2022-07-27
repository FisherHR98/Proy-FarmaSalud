package Clases;

public abstract class  Recibo {
    private String NumRecibo;
    private String Fecha;
    private String igv;
    private String CodigoEmp;
    private int Estado;
    private String codCli;
    private String tp;

    public Recibo() {
    }

    public Recibo(String Fecha, String igv, String CodigoEmp, int Estado, String codCli, String tp) {
        this.Fecha = Fecha;
        this.igv = igv;
        this.CodigoEmp = CodigoEmp;
        this.Estado = Estado;
        this.codCli = codCli;
        this.tp = tp;
    }

    public String getNumRecibo() {
        return NumRecibo;
    }

    public void setNumRecibo(String NumRecibo) {
        this.NumRecibo = NumRecibo;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getIgv() {
        return igv;
    }

    public void setIgv(String igv) {
        this.igv = igv;
    }

    public String getCodigoEmp() {
        return CodigoEmp;
    }

    public void setCodigoEmp(String CodigoEmp) {
        this.CodigoEmp = CodigoEmp;
    }

    public int getEstado() {
        return Estado;
    }

    public void setEstado(int Estado) {
        this.Estado = Estado;
    }

    public String getCodCli() {
        return codCli;
    }

    public void setCodCli(String codCli) {
        this.codCli = codCli;
    }

    public String getTp() {
        return tp;
    }

    public void setTp(String tp) {
        this.tp = tp;
    }
    
    

    
    
}

