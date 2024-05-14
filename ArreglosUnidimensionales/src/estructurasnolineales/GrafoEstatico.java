package estructurasnolineales;

import entradasalida.SalidaPorDefecto;
import estructuraslineales.ColaInfoEstatica;
import estructuraslineales.ListaInfoDinamica;
import estructuraslineales.ListaInfoEstatica;
import estructuraslineales.PilaInfoEstatica;
import estructurasnolineales.auxiliares.EtiquetaVertice;
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
        // aristas.rellenar(-100);
        this.orden = orden;
        aristas.matrizDiagonal(0.0);
    }

    private double definirInfinito(TipoDeOrdenamiento orden) {
        if (orden == TipoDeOrdenamiento.DEC) {
            return Double.MAX_VALUE; // infinito positivo
        } else { // incremental
            return Double.MIN_VALUE; // infinito negativo
        }
    }

    public boolean agregarVertice(Object valor) {
        int indiceVertice = (int) vertices.encontrar(valor);

        if (indiceVertice < 0) { // no existe, podemos agregarlos
            // creamos el vertice
            Vertice verticeNuevo = new Vertice();
            verticeNuevo.setDato(valor);
            verticeNuevo.setIndice(vertices.cantidad());
            // lo metemos en el arreglo de vertices
            int retorno = vertices.insertar(verticeNuevo);

            if (retorno < 0) { // error
                return false;
            } else {
                return true;
            }
        } else { // ya existe y no podemos agregarlo
            return false;
        }
    }

    public boolean agregarArista(Object origen, Object destino,
            double peso) {
        int indiceOrigen = (int) vertices.encontrar(origen);
        int indiceDestino = (int) vertices.encontrar(destino);

        if (indiceOrigen >= 0 && indiceDestino >= 0) { // existen
            return aristas.cambiar(indiceOrigen, indiceDestino, peso);
        } else { // no existen
            return false;
        }
    }

    public boolean agregarArista(Object origen, Object destino) {
        return agregarArista(origen, destino, 1.0);
    }

    public void mostrarGrafo() {
        // mostrar los vértices
        for (int cadaVertice = 0; cadaVertice < vertices.cantidad(); cadaVertice++) {
            // sacamos un vértice
            Vertice unVertice = (Vertice) vertices.obtener(cadaVertice);
            // mostramos sus datos
            SalidaPorDefecto.consola(unVertice.getDato() +
                    "(" + unVertice.getIndice() + ")\n");
        }

        // mostrar las aristas
        aristas.imprimirXColumnas();
    }

    // Ordenación topológica
    public ListaInfoEstatica ordenacionTopologica() {
        ListaInfoEstatica ordenacionT = new ListaInfoEstatica(vertices.cantidad());

        ListaInfoEstatica marcados = new ListaInfoEstatica(vertices.cantidad());

        ListaInfoEstatica incidencias = new ListaInfoEstatica(vertices.cantidad());

        ColaInfoEstatica cola = new ColaInfoEstatica(vertices.cantidad());

        // 0) Primero debería verificarse la no existencia de ciclos

        // 1) Calcular incidencias.
        incidenciasBase(incidencias);

        // 2) Marcar y encolar vértices con incidencias en 0.
        marcados.rellenar(false, vertices.cantidad());
        marcarYEncolarVerticesEn0(marcados, cola, incidencias);

        while (cola.vacio() == false) {
            // 3) Mientras existan elementos en la cola, extraer uno
            // y mandarlo a las OT.
            int indiceVerticeActual = (int) cola.quitar();
            Vertice verticeActual = (Vertice) vertices.obtener(indiceVerticeActual);
            ordenacionT.insertar(verticeActual.getDato());

            // 4) Recalcular incidencias con base en el proceso extraído en
            // el paso 3.
            recalcularIncidencias(incidencias, indiceVerticeActual);

            // 5) Marcar y encolar vértices con incidencias en 0 y no
            // marcados.
            marcarYEncolarVerticesEn0(marcados, cola, incidencias);
        }
        return ordenacionT; // salida
    }

    // 4) Recalcular incidencias con base en el proceso extraído en
    // el paso 3.
    private void recalcularIncidencias(ListaInfoEstatica incidencias,
            int indiceVerticeActual) {

        // Recorremos todas las columnas, que son los destinos
        // a los que el indice del vertice actual (origen)
        // les puede mandar flecha
        for (int cadaColumnaDestino = 0; cadaColumnaDestino < aristas.columnas; cadaColumnaDestino++) {
            if (existeAdyacencia(indiceVerticeActual,
                    cadaColumnaDestino)) {
                int valorIncidencia = (int) incidencias.obtener(cadaColumnaDestino);
                valorIncidencia--;
                incidencias.cambiar(cadaColumnaDestino, valorIncidencia);
            }
        }
    }

    // 2) Marcar y encolar vértices con incidencias en 0.
    private void marcarYEncolarVerticesEn0(ListaInfoEstatica marcados,
            ColaInfoEstatica cola,
            ListaInfoEstatica incidencias) {
        // Recorrer todos y cada uno de los vértices,
        // obteniendo su incidencia, y ssolo procesar los
        // no marcados.

        for (int cadaVertice = 0; cadaVertice < incidencias.cantidad(); cadaVertice++) {
            int valorIncidenciaVertice = (int) incidencias.obtener(cadaVertice);
            if (valorIncidenciaVertice == 0 &&
                    ((boolean) marcados.obtener(cadaVertice)) == false) {
                marcados.cambiar(cadaVertice, true);
                cola.poner(cadaVertice);
            }
        }
    }

    // 1) Calcular incidencias

    // Método que me devuelve una celda de la matriz
    // (adyacencia)
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

    private boolean existeAdyacencia(Double peso) {
        if (peso != null && peso != 0 && peso != definirInfinito(orden)) {
            return true;
        } else {
            return false;
        }
    }

    // Método que calcula las incidencias de un solo vértice
    private int incidenciasVertice(int indiceVertice) {
        int numIncidencia = 0;

        for (int cadaOrigenFila = 0; cadaOrigenFila < aristas.filas; cadaOrigenFila++) {
            if (existeAdyacencia(cadaOrigenFila, indiceVertice)) {
                numIncidencia++;
            }
        }
        return numIncidencia;
    }

    // Método que calcula las incidencias de todos,
    // invocando al de arriba
    private void incidenciasBase(ListaInfoEstatica incidencias) {

        // Calculamos los valores de incidencias para cada uno de los
        // vértices destinos posibles
        for (int cadaColumnaDestino = 0; cadaColumnaDestino < aristas.columnas; cadaColumnaDestino++) {
            // mandamos llamar al método que calcula
            // las incidencias de una sola columna
            incidencias.insertar(incidenciasVertice(cadaColumnaDestino));
        }
    }

    // Recorrido en profundidad
    public ListaInfoEstatica recorridoProfundidad(Object origen) {
        ListaInfoEstatica marcados = new ListaInfoEstatica(vertices.cantidad());
        PilaInfoEstatica pila = new PilaInfoEstatica(vertices.cantidad());
        ListaInfoEstatica salida = new ListaInfoEstatica(vertices.cantidad());

        int indiceVerticeOrigen = (int) vertices.encontrar(origen);

        if (indiceVerticeOrigen >= 0) { // existe
            // 1. Partir de un vértice origen, marcarlo y enpilarlo.
            marcados.rellenar(false, vertices.cantidad());
            marcados.cambiar(indiceVerticeOrigen, true);
            pila.poner(indiceVerticeOrigen);

            while (pila.vacio() == false) {
                // 2. Mientras existan elementos en la pila,
                // sacar uno y mandarlo a la salida (este vértice es
                // el vértice actual).
                int indiceVerticeActual = (int) pila.quitar();
                Vertice verticeActual = (Vertice) vertices.obtener(indiceVerticeActual);
                salida.insertar(verticeActual.getDato());

                // 3. Los vértices adycaentes al vértice actual (y que
                // no estén marcados) se enpilan y marcan.
                marcarYEnpilarAdyacentes(indiceVerticeActual, marcados, pila);
            }
        } else { // no existe
            return null;
        }
        return salida;
    }

    // 3. Los vértices adycaentes al vértice actual (y que
    // no estén marcados) se enpilan y marcan.
    private void marcarYEnpilarAdyacentes(int indiceVerticeActual,
            ListaInfoEstatica marcados, PilaInfoEstatica pila) {
        for (int cadaDestino = 0; cadaDestino < aristas.columnas; cadaDestino++) {
            if (existeAdyacencia(indiceVerticeActual, cadaDestino) == true
                    && ((boolean) marcados.obtener(cadaDestino)) == false) {
                marcados.cambiar(cadaDestino, true);
                pila.poner(cadaDestino);
            }
        }
    }

    // Recorrido en profundidad
    public ListaInfoEstatica recorridoAnchura(Object origen) {
        ListaInfoEstatica marcados = new ListaInfoEstatica(vertices.cantidad());
        ColaInfoEstatica cola = new ColaInfoEstatica(vertices.cantidad());
        ListaInfoEstatica salida = new ListaInfoEstatica(vertices.cantidad());

        int indiceVerticeOrigen = (int) vertices.encontrar(origen);

        if (indiceVerticeOrigen >= 0) { // existe
            // 1. Partir de un vértice origen, marcarlo y encolarlo.
            marcados.rellenar(false, vertices.cantidad());
            marcados.cambiar(indiceVerticeOrigen, true);
            cola.poner(indiceVerticeOrigen);

            while (cola.vacio() == false) {
                // 2. Mientras existan elementos en la cola,
                // sacar uno y mandarlo a la salida (este vértice es
                // el vértice actual).
                int indiceVerticeActual = (int) cola.quitar();
                Vertice verticeActual = (Vertice) vertices.obtener(indiceVerticeActual);
                salida.insertar(verticeActual.getDato());

                // 3. Los vértices adyacentes al vértice actual (y que
                // no estén marcados) se encolar y marcan.
                marcarYEncolarAdyacentes(indiceVerticeActual, marcados, cola);
            }
        } else { // no existe
            return null;
        }
        return salida;
    }

    // 3. Los vértices adycaentes al vértice actual (y que
    // no estén marcados) se enpilan y marcan.
    private void marcarYEncolarAdyacentes(int indiceVerticeActual,
            ListaInfoEstatica marcados, ColaInfoEstatica cola) {
        for (int cadaDestino = 0; cadaDestino < aristas.columnas; cadaDestino++) {
            if (existeAdyacencia(indiceVerticeActual, cadaDestino) == true
                    && ((boolean) marcados.obtener(cadaDestino)) == false) {
                marcados.cambiar(cadaDestino, true);
                cola.poner(cadaDestino);
            }
        }
    }

    // Generar etiquetas, algoritmo de Dijkstra
    public ListaInfoEstatica dijkstra(Object origen) {
        ListaInfoEstatica etiquetasOptimas = new ListaInfoEstatica(vertices.cantidad());
        ListaInfoEstatica marcados = new ListaInfoEstatica(vertices.cantidad());

        int indiceOrigen = (int) vertices.encontrar(origen);
        if (indiceOrigen >= 0) {
            // 1. Definir etiquetas iniciales partiendo de un
            // vértice origen, el cual deberá marcarse.
            inicializarEtiquetas(indiceOrigen,
                    etiquetasOptimas, definirInfinito(orden),
                    -1, 0,
                    0);
            marcados.rellenar(false, vertices.cantidad());
            marcados.cambiar(indiceOrigen, true);
            int indiceVerticeActual = indiceOrigen;

            for (int iteracion = 1; iteracion < vertices.cantidad(); iteracion++) {
                // 2. Calcular las métricas acumuladas del vértice
                // origen (vértice actual) hacia los vecinos no marcados.
                // Si es mejor la métrica acumulada que la de la etiqueta,
                // se sobreescribe.
                calcularMetricasAcumuladasVecinos(indiceVerticeActual,
                        etiquetasOptimas, marcados,
                        iteracion);

                // 3. Actualizar el nuevo vértice actual tomando como base
                // un vértice no marcado con el valor mejor en métrica.
                indiceVerticeActual = actualizarVerticeActual(marcados, etiquetasOptimas);
                marcados.cambiar(indiceVerticeActual, true);
            }
            return etiquetasOptimas;
        } else {
            return null;
        }
    }

    // 3. Actualizar el nuevo vértice actual tomando como base
    // un vértice no marcado con el valor mejor en métrica.
    // Es decir, encuentra el valor más chico o más grande de un arreglo
    private int actualizarVerticeActual(ListaInfoEstatica marcados,
            ListaInfoEstatica etiquetas) {
        double pesoMejor = definirInfinito(orden);
        int indiceVerticeMejor = -1;
        for (int cadaVertice = 0; cadaVertice < vertices.cantidad(); cadaVertice++) {

            if (((boolean) marcados.obtener(cadaVertice) == false)) {
                EtiquetaVertice etiquetaVertice = (EtiquetaVertice) etiquetas.obtener(cadaVertice);
                if (orden == TipoDeOrdenamiento.DEC) { // más chico mejor
                    if (etiquetaVertice.getMetricaAcumulada() < pesoMejor) {
                        pesoMejor = etiquetaVertice.getMetricaAcumulada();
                        indiceVerticeMejor = cadaVertice;
                    }
                } else { // más grande es mejor
                    if (etiquetaVertice.getMetricaAcumulada() > pesoMejor) {
                        pesoMejor = etiquetaVertice.getMetricaAcumulada();
                        indiceVerticeMejor = cadaVertice;
                    }
                }
            }
        }
        return indiceVerticeMejor;
    }

    // 2. Calcular las métricas acumuladas del vértice
    // origen (vértice actual) hacia los vecinos no marcados.
    // Si es mejor la métrica acumulada que la de la etiqueta,
    // se sobreescribe.
    private void calcularMetricasAcumuladasVecinos(int indiceActual,
            ListaInfoEstatica etiquetas,
            ListaInfoEstatica marcados,
            int iteracionActual) {
        // Recorrer todas las columnas(destinos), partiendo
        // del vértice actual (origen)
        for (int cadaDestino = 0; cadaDestino < aristas.columnas; cadaDestino++) {

            Double pesoVActualAVecino = adyacencia(indiceActual, cadaDestino);

            if (existeAdyacencia(pesoVActualAVecino) == true &&
                    ((boolean) marcados.obtener(cadaDestino) == false)) {
                EtiquetaVertice etiquetaVActual = (EtiquetaVertice) etiquetas.obtener(indiceActual);
                double metricaAcumuladaVactual = etiquetaVActual.getMetricaAcumulada();
                double metricaNuevaAcumulada = metricaAcumuladaVactual +
                        pesoVActualAVecino;
                // Ya tenemos el cálculo de la métrica del índice actual
                // hacia el vecino, ahora checar si es mejor que la que
                // tiene el propio vecino
                EtiquetaVertice etiquetaVecino = (EtiquetaVertice) etiquetas.obtener(cadaDestino);

                boolean cambiarMetrica = false;
                if (orden == TipoDeOrdenamiento.DEC) { // más chico es mejor, como distancia o tiempo
                    if (metricaNuevaAcumulada < etiquetaVecino.getMetricaAcumulada()) {
                        cambiarMetrica = true;
                    }
                } else { // INC, más grande es mejor, por ejemplo velocidad
                    if (metricaNuevaAcumulada > etiquetaVecino.getMetricaAcumulada()) {
                        cambiarMetrica = true;
                    }
                }

                if (cambiarMetrica == true) {
                    // hacer el cambio
                    etiquetaVecino.setMetricaAcumulada(metricaNuevaAcumulada);
                    etiquetaVecino.setIndiceProcedencia(indiceActual);
                    etiquetaVecino.setIteracion(iteracionActual);
                }
            }
        }
    }

    // 1. Definir etiquetas iniciales partiendo de un
    // vértice origen,....
    private void inicializarEtiquetas(int indiceOrigen, ListaInfoEstatica etiquetas,
            double metricaAcumulada,
            int indiceProcedencia,
            int iteracion,
            int metricaAcumuladaOrigen) {

        for (int cadaVertice = 0; cadaVertice < vertices.cantidad(); cadaVertice++) {
            // Crearemos uan etiqueta para cada vértice
            EtiquetaVertice etiquetaNueva = new EtiquetaVertice();
            etiquetaNueva.setMetricaAcumulada(metricaAcumulada);
            etiquetaNueva.setIndiceProcedencia(indiceProcedencia);
            etiquetaNueva.setIteracion(iteracion);
            etiquetas.insertar(etiquetaNueva);
        }
        // la etiqueta origen, le cambiamos el valor de metrica
        EtiquetaVertice etiquetaOrigen = (EtiquetaVertice) etiquetas.obtener(indiceOrigen);
        etiquetaOrigen.setMetricaAcumulada(metricaAcumuladaOrigen);
    }

    // metrica óptima
    public Double metricaOptima(Object origen, Object destino) {
        int indiceOrigen = (int) vertices.encontrar(origen);
        int indiceDestino = (int) vertices.encontrar(destino);

        if (indiceOrigen >= 0 && indiceDestino >= 0) { // existen
            ListaInfoEstatica etiquetasOptimasCalculadas = dijkstra(origen);
            EtiquetaVertice etiquetaDestino = (EtiquetaVertice) etiquetasOptimasCalculadas.obtener(indiceDestino);
            double metricOptimaDestino = etiquetaDestino.getMetricaAcumulada();
            return metricOptimaDestino;
        } else { // no existen
            return null;
        }
    }

    // ruta óptima, backtrace
    public ListaInfoDinamica rutaOptima(Object origen, Object destino) {

        ListaInfoDinamica ruta = new ListaInfoDinamica();

        int indiceOrigen = (int) vertices.encontrar(origen);
        int indiceDestino = (int) vertices.encontrar(destino);

        if (indiceOrigen >= 0 && indiceDestino >= 0) { // existen
            ListaInfoEstatica etiquetasOptimas = dijkstra(origen);
            int indiceActual = indiceDestino; // empezamos con el último
            do {
                // realizamos el backtrace, A -> T
                Vertice verticeActual = (Vertice) vertices.obtener(indiceActual);
                //System.out.println(verticeActual.getDato());
                ruta.insertarInicio(verticeActual.getDato()); // a la ruta
                EtiquetaVertice etiquetaActual = (EtiquetaVertice) etiquetasOptimas.obtener(indiceActual);
                
                int indiceVerticeAnterior = etiquetaActual.getIndiceProcedencia();
                
                indiceActual = indiceVerticeAnterior;
                // proceso repetitivo hacia atrás
            } while (indiceActual != -1);
            return ruta;
        } else { // no existen
            return null;
        }
    }
}