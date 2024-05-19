package estructuraslineales.auxiliar;

public class NodoClaveValor {

    private Object clave;
    private Object valor;
    private NodoClaveValor enlaceDerecho;

    public NodoClaveValor(Object clave, Object valor) {
        this.clave = clave;
        this.valor = valor;
        this.enlaceDerecho = null;
    }

    public Object getClave() {
        return clave;
    }

    public void setClave(Object clave) {
        this.clave = clave;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public NodoClaveValor getEnlaceDerecho() {
        return enlaceDerecho;
    }

    public void setEnlaceDerecho(NodoClaveValor enlace) {
        this.enlaceDerecho = enlace;
    }
}
