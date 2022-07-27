package Clases;

public class Marca {
    private String codMarca;
    private String nomMarca;

    
    public Marca(){
        
    }

    public Marca(String codMarca, String nomMarca) {
        this.codMarca = codMarca;
        this.nomMarca = nomMarca;

    }

    public String getCodMarca() {
        return codMarca;
    }

    public void setCodMarca(String codMarca) {
        this.codMarca = codMarca;
    }

    public String getNomMarca() {
        return nomMarca;
    }

    public void setNomMarca(String nomMarca) {
        this.nomMarca = nomMarca;
    } 
    
    
}
