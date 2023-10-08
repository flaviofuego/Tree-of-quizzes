
package Lab1_2new;
import java.util.ArrayList;
import java.util.stream.Collectors;
/**
 *
 * @author fcarroll
 */

public class Nodo {

    int dato;
    Nodo izquierdo;
    Nodo derecho;
    int alturaNodo;
    String nombrelugar;
    String descripcion;

    Acertijo acertijo;
    public Nodo(int dato) {
        this.dato = dato;
        this.izquierdo= null;
        this.derecho= null;
        this.alturaNodo=0;
        this.nombrelugar = "";
        this.descripcion = "";
        this.acertijo = null;

    }
    //set para el acertijo
    public void setAcertijo(Acertijo acertijo){
        this.acertijo = acertijo;
    }

    @Override
    public String toString(){//to string que al imprimir un nodo devuelve el nombre del lugar
        return this.nombrelugar;
    }
}
