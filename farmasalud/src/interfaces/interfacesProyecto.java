
package interfaces;
import Clases.*;
import java.util.*;
public interface interfacesProyecto {
    List<Clientes> listadoCli();
    int adicionCli(Clientes ep);
    public List<Clientes> LisCliDNI(String id);
    public List<Clientes> LisCliRUC(String id);
    public List<Clientes> LisCliCod(String id);
    public List<Producto> LisProCod(String id);
}
