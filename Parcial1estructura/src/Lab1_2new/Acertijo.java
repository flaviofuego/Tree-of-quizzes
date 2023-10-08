package Lab1_2new;

public class Acertijo {
    String pregunta;
    String respuesta;
    public Acertijo(String pregunta, String respuesta){
        this.pregunta = pregunta;
        this.respuesta = respuesta;
    }
    public String getPregunta(){
        return this.pregunta;
    }


    @Override
    public String toString(){
        return this.pregunta;
    }
}
