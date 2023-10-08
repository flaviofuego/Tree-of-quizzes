package Lab1_2new;

public class infonodo {
    String nombrelugar;
    String descripcion;
    public infonodo(String nombrelugar,String descripcion){
        this.nombrelugar=nombrelugar;
        this.descripcion=descripcion;
    }
    @Override
    public String toString(){
        return this.nombrelugar;
    }
}
