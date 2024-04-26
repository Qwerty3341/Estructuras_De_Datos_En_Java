package estructuraslineales.auxiliar;

public class NodoIndiceObjecto {

    private NodoIndiceObjecto enlaceDerecho;
    private int indice;
    private Object objeto;
    
    public NodoIndiceObjecto(int indice, Object objeto){
        this.indice = indice;
        this.objeto = objeto;
        this.enlaceDerecho = null;
    }

    public NodoIndiceObjecto getEnlaceDerecho() {
        return enlaceDerecho;
    }

    public void setEnlaceDerecho(NodoIndiceObjecto enlaceDerecho) {
        this.enlaceDerecho = enlaceDerecho;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public Object getObjeto() {
        return objeto;
    }

    public void setObjeto(Object objeto) {
        this.objeto = objeto;
    }

    

}
