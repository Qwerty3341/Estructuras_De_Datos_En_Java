package estructurasnolineales;

import entradasalida.SalidaPorDefecto;
import estructuraslineales.ColaInfoEstatica;
import estructuraslineales.ListaInfoEstatica;
import estructurasnolineales.auxiliares.Vertice;

public class GrafoEstatico {

    protected ListaInfoEstatica vertices;
    protected MatrizInfo2 aristas;

    public GrafoEstatico(int cantidadVertices) {
        vertices = new ListaInfoEstatica(cantidadVertices);
        aristas = new MatrizInfo2(cantidadVertices, cantidadVertices);
        aristas.rellenar(0.0);
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
        marcados.rellenar(false);
        marcarYEncolarVerticesEn0(marcados, cola, incidencias);
        while (cola.vacio() == false) {
            // 3) Mientras existan elementos en la cola, extraer uno y mandarlo a la OT
            int indiceVerticeActual = (int) cola.quitar();
            Vertice verticeActual = (Vertice) vertices.obtener(indiceVerticeActual);
            ordenacionT.insertar(verticeActual.getDato());
            // 4) Recalcular incidencias con base en el proceso extraido en el paso 3

            // 5) Marcar y encolar vertices con incidencias en 0 y ni marcados    
        }

        
        return ordenacionT;
    }
    
    // 2) Marcar y encolar vertices con incidencias en 0
    private void marcarYEncolarVerticesEn0(ListaInfoEstatica marcados, ColaInfoEstatica cola, ListaInfoEstatica incidencias){
        //Recorrer todos y cada uno de los vertices obteniendo su incidencia y solo procesar los no marcados
        for(int cadaVertice = 0; cadaVertice < incidencias.cantidad() ;cadaVertice++){
            int valorIncidenciaVertice = (int) incidencias.obtener(cadaVertice);
            if (valorIncidenciaVertice == 0 && ((boolean) marcados.obtener(cadaVertice)) == false ) {
                marcados.cambiar(cadaVertice, true);
                cola.poner(cadaVertice);
            }
        }
    }


    /*  1) Calcular incidencias
    Metodo que devuelve una celda de la matriz (adyacencia)*/
    private Double adyacencia(int origen, int destino) {
        return (Double) aristas.obtener(origen, destino);
    }

    private boolean existeAdyacencia(int origen, int destino){
        Double valorAdyacencia = adyacencia(origen, destino);
        if (valorAdyacencia != null && valorAdyacencia != 0) {
                return true;
        }else{
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
        //Calculamos los valores de incidencias para cada uno de los vertices destinos posibles
        for (int cadaColumnaDestino = 0; cadaColumnaDestino < aristas.obtenerColumnas(); cadaColumnaDestino++) {
            //Mandamos llamar al metodo que calcula las incidencias de cada destino
            incidencias.insertar(incidenciasVertice(cadaColumnaDestino));
        }
    }

}