package estructurasnolineales;

import entradasalida.SalidaPorDefecto;
import estructuraslineales.ListaInfoDinamica;
import estructurasnolineales.auxiliares.Vertice;

public class GrafoDinamico {

    protected ListaInfoDinamica listaAdyacencia;

    public GrafoDinamico() {
        listaAdyacencia = new ListaInfoDinamica();
    }

    private ListaInfoDinamica encontrarSubListaVertice(Object valor) {
        // Recorremos la lista roja (las listas de adyacencia)
        listaAdyacencia.iniciaIterador();
        while (listaAdyacencia.iteradorNulo() == false) {
            // Sacamos la lista de cada nodo
            ListaInfoDinamica subListaVertice = (ListaInfoDinamica) listaAdyacencia.obtenDato();
            // Obtenemos el primer elemento de la sublista
            Vertice verticeInicial = (Vertice) subListaVertice.verInicial();
            // Comparar este elemento inicial con el parametro
            if (valor.toString().equalsIgnoreCase(verticeInicial.getDato().toString()) == true) {
                return subListaVertice;
            } // Si encontro el vertice se va a salir con el return
        }
        return null;// Nunca lo encuentra
    }

    public boolean agregarVertice(Object valor) {
        ListaInfoDinamica subListaVerticeNuevo = encontrarSubListaVertice(valor);
        if (subListaVerticeNuevo != null) {// Ya existe
            return false;
        } else {// No existe
                // Creamos nuevo vertice
            Vertice verticeNuevo = new Vertice();
            verticeNuevo.setDato(valor);
            // Creamos una nueva lista
            ListaInfoDinamica nuevaListaVertice = new ListaInfoDinamica();
            // Agregamos el vertice a la lista nueva
            nuevaListaVertice.insertar(verticeNuevo);
            // Agregamos la lista nueva a la lista de adyacencia
            int retorno = listaAdyacencia.insertar(nuevaListaVertice);
            if (retorno == -1) {
                return false;
            } else {
                return true;
            }
        }
    }

    public boolean agregarArista(Object origen, Object destino) {
        ListaInfoDinamica subListaOrigen = encontrarSubListaVertice(origen);
        ListaInfoDinamica subListaDestino = encontrarSubListaVertice(destino);

        if (subListaOrigen != null && subListaDestino != null) {
            // Los dos existen
            // Sacar la direccion de memoria del destino
            // del primer elemento de su lista
            Vertice verticeDestino = (Vertice) subListaDestino.verInicial();
            // En la lista del origen, agregamos este vertice
            int retorno = subListaOrigen.insertar(verticeDestino);
            if (retorno == -1) {
                return false;
            } else {
                return true;
            }

        } else {// uno o los dos no existen
            return false;
        }
    }

    public void mostrar() {
        // Recorremos la lista roja (lista de adyacencia)
        listaAdyacencia.iniciaIterador();
        while (listaAdyacencia.iteradorNulo() == false) {
            // Sacamos la lista de cada verticce en cada nodo
            ListaInfoDinamica subListaVertice = (ListaInfoDinamica) listaAdyacencia.obtenDato();
            subListaVertice.mostrar();
            SalidaPorDefecto.consola("\n");
        }
    }

}
