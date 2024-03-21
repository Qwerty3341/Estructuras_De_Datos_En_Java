package estructuraslineales.auxiliar;

public class NodoDoble {

    protected Object dato;
    protected NodoDoble enlaceIzquierdo;
    protected NodoDoble enlaceDerecho;

    public NodoDoble(Object valor){
        this.dato = valor;
        this.enlaceDerecho = null;
        this.enlaceDerecho = null;
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public NodoDoble getEnlaceIzquierdo() {
        return enlaceIzquierdo;
    }

    public void setEnlaceIzquierdo(NodoDoble enlaceIzquierdo) {
        this.enlaceIzquierdo = enlaceIzquierdo;
    }

    public NodoDoble getEnlaceDerecho() {
        return enlaceDerecho;
    }

    public void setEnlaceDerecho(NodoDoble enlaceDerecho) {
        this.enlaceDerecho = enlaceDerecho;
    }

    @Override
    public String toString() {
        return dato.toString();
    }
}
