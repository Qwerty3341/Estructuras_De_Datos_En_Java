package pruebas;

import entradasalida.SalidaPorDefecto;
import estructurasnolineales.GrafoDinamico;

public class PruebaGrafoDinamico {
    public static void main(String[] shshshshshshshsshsh) {
       GrafoDinamico grafo = new GrafoDinamico();
       
       grafo.agregarVertice("A");
       grafo.agregarVertice("B");
       grafo.agregarVertice("C");
       grafo.agregarVertice("D");
       grafo.agregarVertice("E");

       grafo.agregarArista("A", "B");
       grafo.agregarArista("A", "E");
       grafo.agregarArista("B", "C");
       grafo.agregarArista("B", "E");
       grafo.agregarArista("C", "E");
       grafo.agregarArista("C", "D");
       grafo.agregarArista("D", "C");
       grafo.agregarArista("D", "E");
       grafo.agregarArista("E", "C");

       grafo.mostrar();

       SalidaPorDefecto.consola("\n__________________________________________________\n");
       grafo.recorridoAnchura("A").mostrar();;
    }
}
