package estructurasnolineales;

import entradasalida.SalidaPorDefecto;
import estructuraslineales.ColaInfoEstatica;
import estructuraslineales.ListaInfoEstatica;
import estructuraslineales.PilaInfoEstatica;
import estructurasnolineales.auxiliares.Vertice;
import utilerias.comunes.TipoDeOrdenamiento;

public class GrafoEstatico {

    protected ListaInfoEstatica vertices;
    protected MatrizInfo2 aristas;
    protected TipoDeOrdenamiento orden;

    public GrafoEstatico(int cantidadVertices) {
        vertices = new ListaInfoEstatica(cantidadVertices);
        aristas = new MatrizInfo2(cantidadVertices, cantidadVertices);
        aristas.rellenar(0.0);
    }

    public GrafoEstatico(int cantidadVertices, TipoDeOrdenamiento orden) {
        vertices = new ListaInfoEstatica(cantidadVertices);
        aristas = new MatrizInfo2(cantidadVertices, cantidadVertices);
        aristas.rellenar(definirInfinito(orden));
        this.orden = orden;
        aristas.matrizDiagonal(0.0);
    }

    private double definirInfinito(TipoDeOrdenamiento orden) {
        if (orden == TipoDeOrdenamiento.DEC) {// infinito positivo
            return Double.MAX_VALUE;
        } else {// incremental
            return Double.MIN_VALUE;// infinito negativo
        }
    }

    public boolean agregarVertice(Object valor) {
        int indiceVertice = (int) vertices.encontrar(valor);

        if (indiceVertice < 0) {// No existe, podemos agregar
            // Creamos el vertice
            Vertice verticeNuevo = new Vertice();
            verticeNuevo.setDato(valor);
            verticeNuevo.setIndice(vertices.cantidad());
            // lo ponemos en el arreglo de vertices
            int retorno = vertices.insertar(verticeNuevo);
            if (retorno < 0) {// error
                return false;
            } else {
                return true;
            }
        } else {// ya existe y no podemos agregar
            return false;
        }
    }

    public boolean agregarArista(Object origen, Object destino, double peso) {
        int indiceOrigen = (int) vertices.encontrar(origen);
        int indiceDestino = (int) vertices.encontrar(destino);
        if (indiceOrigen >= 0 && indiceDestino >= 0) {// existe
            return aristas.cambiar(indiceOrigen, indiceDestino, peso);
        } else {// no existe
            return false;
        }
    }

    public boolean agregarArista(Object origen, Object destino) {
        return agregarArista(origen, destino, 1.0);
    }

    public void mostrarGrafo() {
        // mostrar los vertices
        for (int cadaVertice = 0; cadaVertice < vertices.cantidad(); cadaVertice++) {
            // sacamos un vértice
            Vertice unVertice = (Vertice) vertices.obtener(cadaVertice);
            // mostramos sus datos
            SalidaPorDefecto.consola(unVertice.getDato() + "(" + unVertice.getIndice() + ")\n");
        }
        // mostrar las aristas
        aristas.imprimirXColumnas();
    }

    public ListaInfoEstatica ordenacionTopologica() {
        ListaInfoEstatica ordenacionT = new ListaInfoEstatica(vertices.cantidad());
        ListaInfoEstatica marcados = new ListaInfoEstatica(vertices.cantidad());
        ListaInfoEstatica incidencias = new ListaInfoEstatica(vertices.cantidad());
        ColaInfoEstatica cola = new ColaInfoEstatica(vertices.cantidad());

        // 0) Primero deberia verificarse la no existencia de ciclos

        // 1) Calcular incidencias
        incidenciasBase(incidencias);
        // 2) Marcar y encolar vertices con incidencias en 0
        marcados.rellenar(false, vertices.cantidad());
        marcarYEncolarVerticesEn0(marcados, cola, incidencias);
        while (cola.vacio() == false) {
            // 3) Mientras existan elementos en la cola, extraer uno y mandarlo a la OT
            int indiceVerticeActual = (int) cola.quitar();
            Vertice verticeActual = (Vertice) vertices.obtener(indiceVerticeActual);
            ordenacionT.insertar(verticeActual.getDato());
            // 4) Recalcular incidencias con base en el proceso extraido en el paso 3
            recalcularIncidencias(incidencias, indiceVerticeActual);
            // 5) Marcar y encolar vertices con incidencias en 0 y ni marcados
            marcarYEncolarVerticesEn0(marcados, cola, incidencias);
        }
        return ordenacionT;
    }

    // 4) Recalcular incidencias con base en el proceso extraido en el paso 3
    private void recalcularIncidencias(ListaInfoEstatica incidencias, int indiceVerticeActual) {
        // Recorremos todas las columnas que son los destinos a los que el indice del
        // vertice actual les puede mandar flecha
        for (int cadaColumnaDestino = 0; cadaColumnaDestino < aristas.obtenerColumnas(); cadaColumnaDestino++) {
            if (existeAdyacencia(indiceVerticeActual, cadaColumnaDestino)) {
                int valorIncidencia = (int) incidencias.obtener(cadaColumnaDestino);
                valorIncidencia--;
                incidencias.cambiar(cadaColumnaDestino, valorIncidencia);
            }
        }
    }

    // 2) Marcar y encolar vertices con incidencias en 0
    private void marcarYEncolarVerticesEn0(ListaInfoEstatica marcados, ColaInfoEstatica cola,
            ListaInfoEstatica incidencias) {
        // Recorrer todos y cada uno de los vertices obteniendo su incidencia y solo
        // procesar los no marcados
        for (int cadaVertice = 0; cadaVertice < incidencias.cantidad(); cadaVertice++) {
            int valorIncidenciaVertice = (int) incidencias.obtener(cadaVertice);
            if (valorIncidenciaVertice == 0 && ((boolean) marcados.obtenerElemento(cadaVertice)) == false) {
                marcados.cambiar(cadaVertice, true);
                cola.poner(cadaVertice);
            }
        }
    }

    /*
     * 1) Calcular incidencias
     * Metodo que devuelve una celda de la matriz (adyacencia)
     */
    private Double adyacencia(int origen, int destino) {
        return (Double) aristas.obtener(origen, destino);
    }

    private boolean existeAdyacencia(int origen, int destino) {
        Double valorAdyacencia = adyacencia(origen, destino);
        if (valorAdyacencia != null && valorAdyacencia != 0) {
            return true;
        } else {
            return false;
        }
    }

    // Metodo que calcula las incidencias de un solo vertice
    private int incidenciasVertice(int indiceVertice) {
        int numIncidencia = 0;
        for (int cadaOrigenFila = 0; cadaOrigenFila < aristas.obtenerRenglones(); cadaOrigenFila++) {
            if (existeAdyacencia(cadaOrigenFila, indiceVertice)) {
                numIncidencia++;
            }
        }
        return numIncidencia;
    }

    // Metodo que calcula las incidencias de todos invocando al de arriba
    private void incidenciasBase(ListaInfoEstatica incidencias) {
        // Calculamos los valores de incidencias para cada uno de los vertices destinos
        // posibles
        for (int cadaColumnaDestino = 0; cadaColumnaDestino < aristas.obtenerColumnas(); cadaColumnaDestino++) {
            // Mandamos llamar al metodo que calcula las incidencias de cada destino
            incidencias.insertar(incidenciasVertice(cadaColumnaDestino));
        }
    }

    public ListaInfoEstatica recorridoProfundidad(Object origen) {
        ListaInfoEstatica marcados = new ListaInfoEstatica(vertices.cantidad());
        PilaInfoEstatica pila = new PilaInfoEstatica(vertices.cantidad());
        ListaInfoEstatica salida = new ListaInfoEstatica(vertices.cantidad());

        int indiceVerticeOrigen = (int) vertices.encontrar(origen);

        if (indiceVerticeOrigen >= 0) {// existe
            // 1.Partir de un vertice origen, marcarlo y empilarlo
            marcados.rellenar(false, vertices.cantidad());
            marcados.cambiar(indiceVerticeOrigen, true);
            pila.poner(indiceVerticeOrigen);

            while (pila.vacio() == false) {
                // 2 Mientras existan elementos en la pila sacar uno y mandarlo a la pila, sacar
                // uno y mandarlo a la salida (este vertice es el vertice actual)
                int indiceVerticeActual = (int) pila.quitar();
                Vertice verticeActual = (Vertice) vertices.obtener(indiceVerticeActual);
                salida.insertar(verticeActual.getDato());

                // 3. Los vertices adyacentes al vertice actual (y que no esten marcados) se
                // empilan y marcan
                marcarYEmpilarAdyacentes(indiceVerticeActual, marcados, pila);
            }

        } else {// no existe
            return null;
        }
        return salida;
    }

    // 3. Los vertices adyacentes al vertice actual (y que no esten marcados) se
    // empilan y marcan
    private void marcarYEmpilarAdyacentes(int indiceVerticeActual, ListaInfoEstatica marcados, PilaInfoEstatica pila) {
        for (int cadaDestino = 0; cadaDestino < aristas.columnas; cadaDestino++) {
            if (existeAdyacencia(indiceVerticeActual, cadaDestino) == true
                    && (Boolean) marcados.obtener(cadaDestino) == false) {
                marcados.cambiar(cadaDestino, true);
                pila.poner(cadaDestino);
            }
        }
    }

    // Recorrido en anchura
    public ListaInfoEstatica recorridoAnchura(Object origen) {
        ListaInfoEstatica marcados = new ListaInfoEstatica(vertices.cantidad());
        ColaInfoEstatica cola = new ColaInfoEstatica(vertices.cantidad());
        ListaInfoEstatica salida = new ListaInfoEstatica(vertices.cantidad());

        int indiceVerticeOrigen = (int) vertices.encontrar(origen);

        if (indiceVerticeOrigen >= 0) {// existe
            // 1.Partir de un vertice origen, marcarlo y emcolarlo
            marcados.rellenar(false, vertices.cantidad());
            marcados.cambiar(indiceVerticeOrigen, true);
            cola.poner(indiceVerticeOrigen);

            while (cola.vacio() == false) {
                // 2 Mientras existan elementos en la cola sacar uno y mandarlo a la cola, sacar
                // uno y mandarlo a la salida (este vertice es el vertice actual)
                int indiceVerticeActual = (int) cola.quitar();
                Vertice verticeActual = (Vertice) vertices.obtener(indiceVerticeActual);
                salida.insertar(verticeActual.getDato());

                // 3. Los vertices adyacentes al vertice actual (y que no esten marcados) se
                // emcolan y marcan
                marcarYEncolarAdyacentes(indiceVerticeActual, marcados, cola);
            }

        } else {// no existe
            return null;
        }
        return salida;
    }

    // 3. Los vertices adyacentes al vertice actual (y que no esten marcados) se
    // emcolan y marcan
    private void marcarYEncolarAdyacentes(int indiceVerticeActual, ListaInfoEstatica marcados, ColaInfoEstatica cola) {
        for (int cadaDestino = 0; cadaDestino < aristas.columnas; cadaDestino++) {
            if (existeAdyacencia(indiceVerticeActual, cadaDestino) == true && (Boolean) marcados.obtener(cadaDestino) == false) {
                marcados.cambiar(cadaDestino, true);
                cola.poner(cadaDestino);
            }
        }
    }

    //Generar etiquetas, algoritmo de Dijkstra
    public ListaInfoEstatica dijkstra(Object origen){
        return null;
    }

    //metrica optima 
    public Double metricaOptima(Object origen, Object destino){
        return 0.0;
    }

    //ruta optima
    public ListaInfoEstatica rutaOptima(Object origen, Object destino){
        return null;
    }
}