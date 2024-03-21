package estructuraslineales.auxiliar;

public class Nodo {

    protected Object dato;
    protected Nodo enlaceDerecho;

    public Nodo(Object valor){
        dato=valor;
        enlaceDerecho=null;
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public Nodo getEnlaceDerecho() {
        return enlaceDerecho;
    }

    public void setEnlaceDerecho(Nodo enlaceDerecho) {
        this.enlaceDerecho = enlaceDerecho;
    }

    @Override
    public String toString() {
        return dato.toString();
    }
}
