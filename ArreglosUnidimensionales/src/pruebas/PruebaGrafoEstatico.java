package pruebas;

import estructurasnolineales.GrafoEstatico;

public class PruebaGrafoEstatico {
    public static void main(String[] args) {
        GrafoEstatico grafo = new GrafoEstatico(4);

        grafo.agregarVertice("A");
        grafo.agregarVertice("B");
        grafo.agregarVertice("C");
        grafo.agregarVertice("D");

        grafo.agregarArista("A", "B");
        grafo.agregarArista("A", "D");
        grafo.agregarArista("B", "C");
        grafo.agregarArista("C", "A");
        grafo.agregarArista("D", "B");
        grafo.agregarArista("D", "C");

        grafo.mostrarGrafo();
    }
}
