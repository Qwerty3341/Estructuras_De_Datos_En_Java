package estructuraslineales;

import entradasalida.SalidaPorDefecto;
import estructuraslineales.auxiliar.NodoIndiceObjecto;

public class ListaEnlazadaIndexada{

    protected NodoIndiceObjecto apuntadorInicial;
    protected NodoIndiceObjecto apuntadorFinal;
    protected int numDeElementos;

    public ListaEnlazadaIndexada(){
        this.apuntadorInicial = null;
        this.apuntadorFinal = null;
        this.numDeElementos = -1;
    }

    public int getNumDeElementos() {
        return numDeElementos;
    }

    // ----------------------Insertar con indice incremental-----------------------
    public void insertar(Object objeto) {
        apuntadorInicial = insertarRecursivo(apuntadorInicial, objeto, 0);
    }

    private NodoIndiceObjecto insertarRecursivo(NodoIndiceObjecto nodoActual, Object objeto, int indiceActual) {
        if (nodoActual == null) {
            NodoIndiceObjecto nuevoNodo = new NodoIndiceObjecto(indiceActual, objeto);
            if (indiceActual == 0) { 
                apuntadorFinal = nuevoNodo;
            }
            numDeElementos++;
            return nuevoNodo;
        } else if (nodoActual.getEnlaceDerecho() == null) {
            NodoIndiceObjecto nuevoNodo = new NodoIndiceObjecto(indiceActual + 1, objeto);
            nodoActual.setEnlaceDerecho(nuevoNodo);
            apuntadorFinal = nuevoNodo;
            numDeElementos++;
            return nodoActual;
        } else {
            nodoActual.setEnlaceDerecho(insertarRecursivo(nodoActual.getEnlaceDerecho(), objeto, indiceActual + 1));
            return nodoActual;
        }
    }

    //-----------------Insertar indice----------------------
    public void insertarIndice(int indice, Object objeto) {
        if (indice > this.numDeElementos) {
            indice = this.numDeElementos; // Ajustar el índice para mantener la continuidad
        }
        if (apuntadorInicial == null) { // Si la lista está vacía ponemos el nuevo nodo al principio
            NodoIndiceObjecto nuevoNodo = new NodoIndiceObjecto(indice, objeto);
            apuntadorInicial = nuevoNodo;
            apuntadorFinal = nuevoNodo;
            numDeElementos++;
        } else { // Insertar en la posición adecuada.
            apuntadorInicial = insertarIndiceRecursivo(apuntadorInicial, indice, objeto);
        }
    }

    private NodoIndiceObjecto insertarIndiceRecursivo(NodoIndiceObjecto actual, int indice, Object objeto) {
        if (actual == null) {
            numDeElementos++;
            return new NodoIndiceObjecto(indice, objeto);
        } else if (actual.getIndice() == indice) {
            actual.setObjeto(objeto);
            return actual;
        } else if (actual.getIndice() > indice) {
            NodoIndiceObjecto nuevoNodo = new NodoIndiceObjecto(indice, objeto);
            nuevoNodo.setEnlaceDerecho(actual);
            numDeElementos++;
            return nuevoNodo;
        } else {
            actual.setEnlaceDerecho(insertarIndiceRecursivo(actual.getEnlaceDerecho(), indice, objeto));
            return actual;
        }
    }

    //---------------Obtener por indice-------------------------
    public Object obtener(int indice) {
        return obtenerRecursivo(indice, apuntadorInicial);
    }
    
    private Object obtenerRecursivo(int indiceBuscado, NodoIndiceObjecto actual){
        if (actual == null) {//Llegamos al final
            return null;
        }
        if (actual.getIndice() == indiceBuscado) {//Seguimos buscando
            return actual.getObjeto();
        }
        return obtenerRecursivo(indiceBuscado, actual.getEnlaceDerecho());
        
    }

    //--------------------Borrar cosas------------------------

    public void borrarIndice(int indice) {
        apuntadorInicial = eliminarRecursivo(apuntadorInicial, indice, 0);
    }
    
    private NodoIndiceObjecto eliminarRecursivo(NodoIndiceObjecto actual, int indiceBuscado, int indiceActual) {
        if (actual == null) {
            return null;
        }
        if (actual.getIndice() == indiceBuscado) {
            numDeElementos--;
            actualizarIndicesRecursivo(actual.getEnlaceDerecho(), indiceActual);
            return actual.getEnlaceDerecho();
        }
        actual.setEnlaceDerecho(eliminarRecursivo(actual.getEnlaceDerecho(), indiceBuscado, indiceActual + 1));
        return actual;
    }

    //Al recorrer los elementos debemos actualizar los indices
    private void actualizarIndicesRecursivo(NodoIndiceObjecto nodo, int indiceNuevo) {
        if (nodo != null) {
            nodo.setIndice(indiceNuevo);
            actualizarIndicesRecursivo(nodo.getEnlaceDerecho(), indiceNuevo + 1);
        }
    }


    //Metodos para imprimir 
    public void imprimir() {
        imprimirRecursivo(apuntadorInicial);
        SalidaPorDefecto.consola("null");
    }

    private void imprimirRecursivo(NodoIndiceObjecto nodoActual){
        if (nodoActual != null) {
            SalidaPorDefecto.consola(nodoActual.getIndice()+":"+nodoActual.getObjeto()+" -> ");
            imprimirRecursivo(nodoActual.getEnlaceDerecho());
        }
    }
}