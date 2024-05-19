package estructuraslineales.auxiliar;

public class NodoDoble {
    protected Object dato;
    protected NodoDoble enlaceDer;
    protected NodoDoble enlaceIzq;


    public NodoDoble(Object valor){
        dato = valor;
        enlaceDer = null;
        enlaceIzq = null;
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public NodoDoble getEnlaceDer() {
        return enlaceDer;
    }

    public void setEnlaceDer(NodoDoble enlaceDer) {
        this.enlaceDer = enlaceDer;
    }

    public NodoDoble getEnlaceIzq() {
        return enlaceIzq;
    }

    public void setEnlaceIzq(NodoDoble enlaceIzq) {
        this.enlaceIzq = enlaceIzq;
    }

    @Override
    public String toString(){
        return dato.toString();

    }
    
}