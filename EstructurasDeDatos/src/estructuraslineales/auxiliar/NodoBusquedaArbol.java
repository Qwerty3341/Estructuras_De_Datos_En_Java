package estructuraslineales.auxiliar;

public class NodoBusquedaArbol {

    private NodoBusquedaArbol enlaceIzq;
    private NodoBusquedaArbol enlaceDer;
    private long direccion;
    private int indice;

    public NodoBusquedaArbol(int indice, long direccion) {
        this.enlaceDer = null;
        this.enlaceIzq = null;
        this.direccion = direccion;
        this.indice = indice;
    }

    /*
     * Getters y Setters
     */

    public NodoBusquedaArbol getEnlaceIzq() {
        return enlaceIzq;
    }

    public void setEnlaceIzq(NodoBusquedaArbol enlaceIzq) {
        this.enlaceIzq = enlaceIzq;
    }

    public NodoBusquedaArbol getEnlaceDer() {
        return enlaceDer;
    }

    public void setEnlaceDer(NodoBusquedaArbol enlaceDer) {
        this.enlaceDer = enlaceDer;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public long getDireccion() {
        return direccion;
    }

    public void setDireccion(long direccion) {
        this.direccion = direccion;
    }
}
