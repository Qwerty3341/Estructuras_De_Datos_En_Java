package pruebas;

import entradasalida.SalidaPorDefecto;
import estructurasnolineales.GrafoEstatico;
import utilerias.comunes.TipoDeOrdenamiento;

public class PruebaGrafoRutaOptima {
    public static void main(String[] args) {
        GrafoEstatico grafo = new GrafoEstatico(9, TipoDeOrdenamiento.DEC);
        
        grafo.agregarVertice("A");
        grafo.agregarVertice("B");
        grafo.agregarVertice("C");
        grafo.agregarVertice("D");
        grafo.agregarVertice("E");
        grafo.agregarVertice("H");
        grafo.agregarVertice("M");
        grafo.agregarVertice("R");
        grafo.agregarVertice("T");

        grafo.agregarArista("A", "B", 5.0);
        grafo.agregarArista("A", "C", 3.0);
        grafo.agregarArista("A", "D", 8.0);
        grafo.agregarArista("A", "E", 2.0);
        
        grafo.agregarArista("B", "A", 5.0);
        grafo.agregarArista("B", "C", 4.0);
        grafo.agregarArista("B", "H", 9.0);

        grafo.agregarArista("C", "A", 3.0);
        grafo.agregarArista("C", "B", 4.0);
        grafo.agregarArista("C", "D", 9.0);
        grafo.agregarArista("C", "H", 7.0);

        grafo.agregarArista("D", "A", 8.0);
        grafo.agregarArista("D", "C", 9.0);
        grafo.agregarArista("D", "E", 1.0);
        grafo.agregarArista("D", "H", 11.0);
        grafo.agregarArista("D", "M", 8.0);
        grafo.agregarArista("D", "R", 3.0);
        grafo.agregarArista("D", "T", 7.0);

        grafo.agregarArista("E", "A", 2.0);
        grafo.agregarArista("E", "D", 1.0);
        grafo.agregarArista("E", "R", 6.0);

        grafo.agregarArista("H", "B", 9.0);
        grafo.agregarArista("H", "C", 7.0);
        grafo.agregarArista("H", "D", 11.0);
        grafo.agregarArista("H", "M", 7.0);

        grafo.agregarArista("M", "D", 8.0);
        grafo.agregarArista("M", "H", 7.0);
        grafo.agregarArista("M", "T", 11.0);

        grafo.agregarArista("R", "D", 3.0);
        grafo.agregarArista("R", "E", 6.0);
        grafo.agregarArista("R", "T", 2.0);

        grafo.agregarArista("T", "D", 7.0);
        grafo.agregarArista("T", "M", 11.0);
        grafo.agregarArista("T", "R", 2.0);

        grafo.mostrarGrafo();

        SalidaPorDefecto.consola("\n________________________________________\n");
        SalidaPorDefecto.consola("La distancia más óptima de " + "A hacia T es: " + grafo.metricaOptima("A", "T"));
        SalidaPorDefecto.consola("\n________________________________________\n");
        SalidaPorDefecto.consola("\nLa ruta más óptima de " + "A hacia T es: ");
        grafo.rutaOptima("A", "T").mostrar();
    }
}