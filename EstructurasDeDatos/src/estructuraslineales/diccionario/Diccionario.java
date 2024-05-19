package estructuraslineales.diccionario;

import entradasalida.SalidaPorDefecto;
import estructuraslineales.ListaInfoDinamica;
import estructuraslineales.ListaInfoDinamicaClave;

public class Diccionario {
    
    protected ListaInfoDinamica listaDeConceptos;
    
    public Diccionario(){
        this.listaDeConceptos = new ListaInfoDinamica();
    }

    public void darAltaNuevosConceptosConDefinicion(String concepto, String complementos){
        ListaInfoDinamicaClave conceptoConDefinicion = new ListaInfoDinamicaClave();
        conceptoConDefinicion.insertar(concepto, complementos);
        listaDeConceptos.insertar(conceptoConDefinicion);
    } 

    public String consultarConceptosYDefinicion(String concepto, int indice) {
        if (indice >= listaDeConceptos.obtenerCantidadDeElementos()) {
            return "Concepto " + concepto + " no encontrado."; // Retorna mensaje si no se encuentra el concepto.
        }
        ListaInfoDinamicaClave conceptoEnDiccionario = (ListaInfoDinamicaClave) listaDeConceptos.obtener(indice);
        if (conceptoEnDiccionario.encontrar(concepto) != null) { // Comprueba si el concepto existe en el nodo actual.
            return concepto + ": " + conceptoEnDiccionario.encontrar(concepto); // Retorna la definición si encuentra el concepto.
        }
        // Llamada recursiva para continuar buscando en el próximo índice.
        return consultarConceptosYDefinicion(concepto, indice + 1);
    }

    public void buscarPalabraClave(String palabraClave){

    }

    public void imprimir(){
        SalidaPorDefecto.consola("Conceptos en diccionario: "+this+"\n");
        for(int concepto = 0; concepto < listaDeConceptos.obtenerCantidadDeElementos(); concepto++){
            SalidaPorDefecto.consola("\n");
            ListaInfoDinamicaClave unConcepto = (ListaInfoDinamicaClave) listaDeConceptos.obtener(concepto);
            unConcepto.mostrar();
            SalidaPorDefecto.consola("\n");
        }
    }
}
