package estructurasnolineales;

import java.util.ArrayList;

import entradasalida.SalidaPorDefecto;
import estructuraslineales.ListaInfoDinamica;
import estructuraslineales.ListaInfoEstatica;
import estructuraslineales.PilaInfoDinamica;
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

    public ListaInfoDinamica recorridoAnchura(Object origen) {
        ListaInfoDinamica marcados = new ListaInfoDinamica();
        PilaInfoDinamica pila = new PilaInfoDinamica();
        ListaInfoDinamica salida = new ListaInfoDinamica();

        ListaInfoDinamica subListaVerticeOrigen = encontrarSubListaVertice(origen);

        if (subListaVerticeOrigen != null) { // existe
            // 1. Partir de un vértice origen, marcarlo y encolarlo.
            Vertice verticeOrigen = (Vertice) subListaVerticeOrigen.verInicial();
            marcados.insertar(verticeOrigen);
            pila.poner(verticeOrigen);

            while (pila.vacio() == false) {
                // 2. Mientras existan elementos en la cola,
                // sacar uno y mandarlo a la salida (este vértice es
                // el vértice actual).
                Vertice verticeActual = (Vertice) pila.quitar();
                salida.insertar(verticeActual.getDato());

                // 3. Los vértices adyacentes al vértice actual (y que
                // no estén marcados) se encolar y marcan.
                marcarYEmpilarAdyacentes(verticeActual, marcados, pila);
            }
        } else { // no existe
            return null;
        }
        return salida;
    }

    private void marcarYEmpilarAdyacentes(Vertice verticeActual, ListaInfoDinamica marcados, PilaInfoDinamica pila) {

        ListaInfoDinamica subListaVerticeActual = encontrarSubListaVertice(verticeActual.getDato());
        // Recorrer las aristas de la sublista
        // A partir del segundo elemento
        subListaVerticeActual.iniciaIterador();
        subListaVerticeActual.obtenDato(); // Me brinco el primero

        while (subListaVerticeActual.iteradorNulo() == false) {
            // Todos a partir del segundo
            Vertice verticeDestino = (Vertice) subListaVerticeActual.obtenDato();
            if (marcados.encontrar(verticeDestino.getDato()) == null) {
                // Si no esta en los marcados no esta marcado
                marcados.insertar(verticeDestino);
                pila.poner(verticeDestino);
            }
        }
    }

    /*
     * Metodos de la practica 12
     */

    public void eliminarVertice(Object vertice) {
        ListaInfoDinamica subListaEliminar = encontrarSubListaVertice(vertice);
        if (subListaEliminar != null) {
            listaAdyacencia.iniciaIterador();
            while (listaAdyacencia.iteradorNulo() == false) {
                ListaInfoDinamica subListaVertice = (ListaInfoDinamica) listaAdyacencia.obtenDato();
                subListaVertice.iniciaIterador();
                subListaVertice.obtenDato();

                while (subListaVertice.iteradorNulo() == false) {
                    Vertice verticeDestino = (Vertice) subListaVertice.obtenDato();
                    if (vertice.toString().equalsIgnoreCase(verticeDestino.getDato().toString())) {
                        subListaVertice.borrar(verticeDestino);
                    }
                }
            }
            listaAdyacencia.borrar(subListaEliminar);
        }
    }

    public boolean esAdyacente(Object origen, Object destino) {
        ListaInfoDinamica subListaOrigen = encontrarSubListaVertice(origen);
        ListaInfoDinamica subListaDestino = encontrarSubListaVertice(destino);

        if (subListaOrigen != null && subListaDestino != null) {// Asegurarnos que existan las listas
            subListaOrigen.iniciaIterador();
            while (subListaOrigen.iteradorNulo() == false) {
                Vertice verticeDestino = (Vertice) subListaOrigen.obtenDato();
                if (destino.toString().equalsIgnoreCase(verticeDestino.getDato().toString())) {
                    return true;
                }
            }
        }
        return false;
    }

    public void eliminarArista(Object origen, Object destino) {
        ListaInfoDinamica subListaOrigen = encontrarSubListaVertice(origen);
        if (subListaOrigen != null) {
            subListaOrigen.iniciaIterador();
            while (subListaOrigen.iteradorNulo() == false) {
                Vertice verticeDestino = (Vertice) subListaOrigen.obtenDato();
                if (destino.toString().equalsIgnoreCase(verticeDestino.getDato().toString())) {
                    subListaOrigen.borrar(verticeDestino);
                    break;
                }
            }
        }
    }

    public Vertice buscarVertice(Object vertice) {
        listaAdyacencia.iniciaIterador();
        while (listaAdyacencia.iteradorNulo() == false) {
            ListaInfoDinamica subListaVertice = (ListaInfoDinamica) listaAdyacencia.obtenDato();
            subListaVertice.iniciaIterador();
            while (subListaVertice.iteradorNulo() == false) {
                Vertice verticeActual = (Vertice) subListaVertice.obtenDato();
                if (verticeActual.getDato().toString().equalsIgnoreCase(vertice.toString())) {
                    return verticeActual;
                }
            }
        }
        return null;
    }

    public boolean esPseudografo() {
        listaAdyacencia.iniciaIterador();
        while (listaAdyacencia.iteradorNulo() == false) {
            ListaInfoDinamica subListaVertice = (ListaInfoDinamica) listaAdyacencia.obtenDato();
            Vertice vertice = (Vertice) subListaVertice.verInicial();
            subListaVertice.iniciaIterador();
            subListaVertice.obtenDato(); 
            while (subListaVertice.iteradorNulo() == false) {
                Vertice adyacente = (Vertice) subListaVertice.obtenDato();
                if (vertice.getDato().equals(adyacente.getDato())) {
                    return true;
                }
            }  
        }
        return false;
    }
    
    public boolean esMultigrafo() {
        listaAdyacencia.iniciaIterador();
        while (listaAdyacencia.iteradorNulo() == false) {
            ListaInfoDinamica subListaVertice = (ListaInfoDinamica) listaAdyacencia.obtenDato();
            ListaInfoDinamica destinos = new ListaInfoDinamica();
            subListaVertice.iniciaIterador();
            subListaVertice.obtenDato();
            while (subListaVertice.iteradorNulo() == false) {
                Vertice verticeDestino = (Vertice) subListaVertice.obtenDato();
                if (destinos.encontrar(verticeDestino.getDato()) != null) {
                    return true;
                } else {
                    destinos.insertar(verticeDestino.getDato());
                }
            }
        }
        return false;
    }
    
    public int gradoVertice(Object vertice) {
        ListaInfoDinamica subListaVertice = encontrarSubListaVertice(vertice);
        if (subListaVertice != null) {
            return subListaVertice.obtenerCantidadDeElementos() - 1;
        } else {
            return 0;
        }
    }

    public boolean hayRuta(Object origen, Object destino) {
        ListaInfoDinamica visitados = new ListaInfoDinamica();
        ListaInfoDinamica subListaOrigen = encontrarSubListaVertice(origen);
        if (subListaOrigen != null) {
            return hayRutaAux(destino, visitados, subListaOrigen);
        } else {
            return false;
        }
    }

    private boolean hayRutaAux(Object destino, ListaInfoDinamica visitados, ListaInfoDinamica subListaActual) {
        visitados.insertar(((Vertice) subListaActual.verInicial()).getDato());
        if (((Vertice) subListaActual.verInicial()).getDato().equals(destino)) {
            return true;
        }
        subListaActual.iniciaIterador();
        subListaActual.obtenDato();
        while (subListaActual.iteradorNulo() == false) {
            Vertice verticeAdyacente = (Vertice) subListaActual.obtenDato();
            if (visitados.contiene(verticeAdyacente.getDato()) == false) {
                ListaInfoDinamica subListaAdyacente = encontrarSubListaVertice(verticeAdyacente.getDato());
                if (hayRutaAux(destino, visitados, subListaAdyacente)) {
                    return true;
                }
            }
        }
        visitados.borrar(((Vertice) subListaActual.verInicial()).getDato());
        return false;
    }

    public boolean esConexo() {
        if (listaAdyacencia.estaVacia()) {
            return false;
        }
        ListaInfoDinamica subListaPrimero = (ListaInfoDinamica) listaAdyacencia.verInicial();
        Vertice verticePrimero = (Vertice) subListaPrimero.verInicial();
        ListaInfoDinamica recorrido = recorridoProfundidad(verticePrimero.getDato());
        return recorrido.obtenerCantidadDeElementos() == listaAdyacencia.obtenerCantidadDeElementos();
    }

    public ListaInfoDinamica recorridoProfundidad(Object origen) {
        ListaInfoDinamica marcados = new ListaInfoDinamica();
        PilaInfoDinamica pila = new PilaInfoDinamica();
        ListaInfoDinamica salida = new ListaInfoDinamica();
        ListaInfoDinamica subListaVerticeOrigen = encontrarSubListaVertice(origen);
        if (subListaVerticeOrigen != null) {
            marcados.insertar(origen);
            pila.poner(origen);
            while (pila.vacio() == false) {
                Object verticeActual = pila.quitar();
                salida.insertar(verticeActual);
                marcarYEmpilarAdyacentes(verticeActual, marcados, pila);
            }
        } else {
            return null;
        }
        return salida;
    }

    private void marcarYEmpilarAdyacentes(Object verticeActual, ListaInfoDinamica marcados, PilaInfoDinamica pila) {
        ListaInfoDinamica subListaVerticeActual = encontrarSubListaVertice(verticeActual);
        if (subListaVerticeActual != null) {
            subListaVerticeActual.iniciaIterador();
            subListaVerticeActual.obtenDato();
            while (subListaVerticeActual.iteradorNulo() == false) {
                Vertice verticeDestino = (Vertice) subListaVerticeActual.obtenDato();
                if (marcados.contiene(verticeDestino.getDato()) == false) {
                    marcados.insertar(verticeDestino.getDato());
                    pila.poner(verticeDestino.getDato());
                }
            }
        }
    }

    public boolean hayCaminoCerrado(Object origen) {
        ListaInfoDinamica visitados = new ListaInfoDinamica();
        return hayCaminoCerradoAux(origen, origen, visitados);
    }

    private boolean hayCaminoCerradoAux(Object verticeActual, Object origen, ListaInfoDinamica visitados) {
        visitados.insertar(verticeActual);
        ListaInfoDinamica subListaVerticeActual = encontrarSubListaVertice(verticeActual);
        if (subListaVerticeActual != null) {
            subListaVerticeActual.iniciaIterador();
            subListaVerticeActual.obtenDato();
            while (subListaVerticeActual.iteradorNulo() == false) {
                Vertice verticeAdyacente = (Vertice) subListaVerticeActual.obtenDato();
                if (verticeAdyacente.getDato().equals(origen) && visitados.obtenerCantidadDeElementos() > 1) {
                    return true;
                }
                if (visitados.contiene(verticeAdyacente.getDato()) == false) {
                    if (hayCaminoCerradoAux(verticeAdyacente.getDato(), origen, visitados)) {
                        return true;
                    }
                }
            }
        }
        visitados.borrar(verticeActual);
        return false;
    }

    public boolean esCaminoSimple(Object origen, Object destino) {
        ListaInfoDinamica marcados = new ListaInfoDinamica();
        return esCaminoSimpleAux(origen, destino, marcados);
    }

    private boolean esCaminoSimpleAux(Object origen, Object destino, ListaInfoDinamica marcados) {
        marcados.insertar(origen);
        ListaInfoDinamica subListaOrigen = encontrarSubListaVertice(origen);

        if (subListaOrigen != null) {
            subListaOrigen.iniciaIterador();
            while (subListaOrigen.iteradorNulo() == false) {
                Vertice verticeDestino = (Vertice) subListaOrigen.obtenDato();
                if (verticeDestino.getDato().equals(destino)) {
                    if (marcados.obtenerCantidadDeElementos() == marcados.obtenerCantidadDeElementosDistintos()) {
                        return true;
                    } else {
                        return false;
                    }
                }
                if (marcados.contiene(verticeDestino.getDato()) == false) {
                    if (esCaminoSimpleAux(verticeDestino.getDato(), destino, marcados)) {
                        return true;
                    }
                }
            }
        }
        marcados.borrar(origen);
        return false;
    }

    public boolean esDirigido() {
        listaAdyacencia.iniciaIterador();
        while (listaAdyacencia.iteradorNulo() == false) {
            ListaInfoDinamica subListaVertice = (ListaInfoDinamica) listaAdyacencia.obtenDato();
            subListaVertice.iniciaIterador();
            while (subListaVertice.iteradorNulo() == false) {
                Vertice verticeAdyacente = (Vertice) subListaVertice.obtenDato();
                if (!esAdyacente(verticeAdyacente.getDato(), ((Vertice) subListaVertice.verInicial()).getDato())) {
                    return true;
                }
            }
            listaAdyacencia.avanzarIterador();
        }
        return false;
    }

    public boolean esArbol() {
        if (esConexo() == false || tieneCiclos() == true) {
            return false;
        }
        ListaInfoDinamica vertices = listaAdyacencia;
        vertices.iniciaIterador();
        while (vertices.iteradorNulo() == false) {
            ListaInfoDinamica subListaVertice = (ListaInfoDinamica) vertices.obtenDato();
            int contadorPadres = 0;
            subListaVertice.iniciaIterador();
            while (subListaVertice.iteradorNulo() == false) {
                Vertice vertice = (Vertice) subListaVertice.obtenDato();
                if (gradoVertice(vertice.getDato()) > 1) {
                    contadorPadres++;
                    if (contadorPadres > 1) {
                        return false;
                    }
                }
            }
            vertices.avanzarIterador();
        }
        return true;
    }

    private boolean tieneCiclos() {
        ListaInfoDinamica visitados = new ListaInfoDinamica();
        ListaInfoDinamica padres = new ListaInfoDinamica();
        listaAdyacencia.iniciaIterador();
        while (listaAdyacencia.iteradorNulo()==false) {
            ListaInfoDinamica subListaVertice = (ListaInfoDinamica) listaAdyacencia.obtenDato();
            subListaVertice.iniciaIterador();
            while (subListaVertice.iteradorNulo() == false) {
                Vertice vertice = (Vertice) subListaVertice.obtenDato();
                if (visitados.contiene(vertice.getDato()) == false) {
                    if (tieneCiclosAux(vertice.getDato(), visitados, padres)) {
                        return true;
                    }
                }
            }
            listaAdyacencia.avanzarIterador();
        }
        return false;
    }
    
    private boolean tieneCiclosAux(Object vertice, ListaInfoDinamica visitados, ListaInfoDinamica padres) {
        visitados.insertar(vertice);
        padres.insertar(vertice);
        ListaInfoDinamica subListaVertice = encontrarSubListaVertice(vertice);
        subListaVertice.iniciaIterador();
        while (subListaVertice.iteradorNulo() == false) {
            Vertice verticeAdyacente = (Vertice) subListaVertice.obtenDato();
            if (visitados.contiene(verticeAdyacente.getDato()) == false) {
                if (tieneCiclosAux(verticeAdyacente.getDato(), visitados, padres)) {
                    return true;
                }
            } else if (padres.contiene(verticeAdyacente.getDato())) {
                return true;
            }
        }
        padres.borrar(vertice);
        return false;
    }
    
    public ListaInfoDinamica listarAristas() {
        ListaInfoDinamica aristas = new ListaInfoDinamica();
        listaAdyacencia.iniciaIterador();
        while (listaAdyacencia.iteradorNulo() == false) {
            ListaInfoDinamica subListaVertice = (ListaInfoDinamica) listaAdyacencia.obtenDato();
            Vertice origen = (Vertice) subListaVertice.verInicial();
            subListaVertice.iniciaIterador();
            subListaVertice.obtenDato();
            while (subListaVertice.iteradorNulo() == false) {
                Vertice destino = (Vertice) subListaVertice.obtenDato();
                String arista = "(" + origen.getDato().toString() + ", " + destino.getDato().toString() + ")";
                aristas.insertar(arista);
            }
        }
        return aristas;
    }
    public ListaInfoEstatica listarAristas(Object vertice) {
        ListaInfoDinamica subListaVertice = encontrarSubListaVertice(vertice);
        if (subListaVertice != null) {
            int cantidadAristas = subListaVertice.obtenerCantidadDeElementos() - 1;
            ListaInfoEstatica aristas = new ListaInfoEstatica(cantidadAristas);
            subListaVertice.iniciaIterador();
            subListaVertice.obtenDato();
            while (subListaVertice.iteradorNulo() == false) {
                Vertice destino = (Vertice) subListaVertice.obtenDato();
                aristas.insertar("(" + vertice + "," + destino.getDato() + ")");
            }
            return aristas;
        } else {
            return new ListaInfoEstatica(0);
        }
    }
    
    public ListaInfoEstatica listarVertices() {
        int cantidadVertices = listaAdyacencia.obtenerCantidadDeElementos();
        ListaInfoEstatica vertices = new ListaInfoEstatica(cantidadVertices);
        listaAdyacencia.iniciaIterador();
        while (listaAdyacencia.iteradorNulo() == false) {
            ListaInfoDinamica subListaVertice = (ListaInfoDinamica) listaAdyacencia.obtenDato();
            Vertice vertice = (Vertice) subListaVertice.verInicial();
            vertices.insertar(vertice.getDato());
        }    
        return vertices;
    }
}