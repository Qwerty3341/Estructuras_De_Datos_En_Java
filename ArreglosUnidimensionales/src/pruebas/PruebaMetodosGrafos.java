package pruebas;

import entradasalida.SalidaPorDefecto;
import estructurasnolineales.GrafoDinamico;

public class PruebaMetodosGrafos {
    public static void main(String[] args) {

        //Prueba para eliminar
        SalidaPorDefecto.consola("\n_____________________________________");
        SalidaPorDefecto.consola("\n\tEliminar\n");
        SalidaPorDefecto.consola("_____________________________________\n");
        SalidaPorDefecto.consola("Grafo original\n");
        GrafoDinamico grafo_e = new GrafoDinamico();
        grafo_e.agregarVertice("A");
        grafo_e.agregarVertice("B");
        grafo_e.agregarVertice("C");
        grafo_e.agregarVertice("D");
        grafo_e.agregarArista("A", "D");
        grafo_e.agregarArista("A", "B");
        grafo_e.agregarArista("B", "A");
        grafo_e.agregarArista("B", "C");
        grafo_e.agregarArista("C", "B");
        grafo_e.agregarArista("C", "D");
        grafo_e.agregarArista("D", "A");
        grafo_e.agregarArista("D", "C");
        grafo_e.mostrar();
        SalidaPorDefecto.consola("\nEliminando el vertice C\n");
        grafo_e.eliminarVertice("C");
        grafo_e.mostrar();
        
        //Es adyacente
        SalidaPorDefecto.consola("\n_____________________________________");
        SalidaPorDefecto.consola("\n\tEs adyacente\n");
        SalidaPorDefecto.consola("_____________________________________\n");
        SalidaPorDefecto.consola("Grafo original\n");
        GrafoDinamico grafo_a = new GrafoDinamico();
        grafo_a.agregarVertice("A");
        grafo_a.agregarVertice("B");
        grafo_a.agregarVertice("C");
        grafo_a.agregarVertice("D");
        grafo_a.agregarArista("A", "D");
        grafo_a.agregarArista("A", "B");
        grafo_a.agregarArista("B", "A");
        grafo_a.agregarArista("B", "C");
        grafo_a.agregarArista("C", "B");
        grafo_a.agregarArista("C", "D");
        grafo_a.agregarArista("D", "A");
        grafo_a.agregarArista("D", "C");
        grafo_a.mostrar();
        SalidaPorDefecto.consola("\nEs adyacente A con C? = " + grafo_a.esAdyacente("a", "c"));
        SalidaPorDefecto.consola("\nEs adyacente A con B? = " + grafo_a.esAdyacente("a", "b"));
        

        //Eliminar arista 
        SalidaPorDefecto.consola("\n_____________________________________");
        SalidaPorDefecto.consola("\n\tEliminar arista\n");
        SalidaPorDefecto.consola("_____________________________________\n");
        SalidaPorDefecto.consola("Grafo original\n");
        GrafoDinamico grafo_arista = new GrafoDinamico();
        grafo_arista.agregarVertice("A");
        grafo_arista.agregarVertice("B");
        grafo_arista.agregarVertice("C");
        grafo_arista.agregarVertice("D");
        grafo_arista.agregarArista("A", "D");
        grafo_arista.agregarArista("A", "B");
        grafo_arista.agregarArista("B", "A");
        grafo_arista.agregarArista("B", "C");
        grafo_arista.agregarArista("C", "B");
        grafo_arista.agregarArista("C", "D");
        grafo_arista.agregarArista("D", "A");
        grafo_arista.agregarArista("D", "C");
        grafo_arista.mostrar();       
        SalidaPorDefecto.consola("\nEliminando el arista de A a D:\n");
        grafo_arista.eliminarArista("A", "D");
        grafo_arista.mostrar();     
        SalidaPorDefecto.consola("\nEliminando el arista de C a B:\n");
        grafo_arista.eliminarArista("C", "D");
        grafo_arista.mostrar();

        //Buscar vertice
        SalidaPorDefecto.consola("\n_____________________________________");
        SalidaPorDefecto.consola("\n\tBuscar Vertice\n");
        SalidaPorDefecto.consola("_____________________________________\n");
        SalidaPorDefecto.consola("Grafo original\n");
        GrafoDinamico grafo_BV = new GrafoDinamico();
        grafo_BV.agregarVertice("A");
        grafo_BV.agregarVertice("B");
        grafo_BV.agregarVertice("C");
        grafo_BV.agregarVertice("D");
        grafo_BV.agregarArista("A", "D");
        grafo_BV.agregarArista("A", "B");
        grafo_BV.agregarArista("B", "A");
        grafo_BV.agregarArista("B", "C");
        grafo_BV.agregarArista("C", "B");
        grafo_BV.agregarArista("C", "D");
        grafo_BV.agregarArista("D", "A");
        grafo_BV.agregarArista("D", "C");
        grafo_BV.mostrar();
        SalidaPorDefecto.consola("\nBuscando el vertice A\n");
        SalidaPorDefecto.consola("Vertice = "+grafo_BV.buscarVertice("A"));
        SalidaPorDefecto.consola("\nBuscando el vertice C\n");
        SalidaPorDefecto.consola("Vertice = "+grafo_BV.buscarVertice("C"));

        //Es pseudografo

        //Es multigrafo

        //Grado vertice
        SalidaPorDefecto.consola("\n_____________________________________\n");
        SalidaPorDefecto.consola("\tGrado Vertice");
        SalidaPorDefecto.consola("\n_____________________________________\n");
        SalidaPorDefecto.consola("Grafo original\n");
        GrafoDinamico grafo_GV = new GrafoDinamico();
        grafo_GV.agregarVertice("A");
        grafo_GV.agregarVertice("B");
        grafo_GV.agregarVertice("C");
        grafo_GV.agregarVertice("D");
        grafo_GV.agregarArista("A", "D");
        grafo_GV.agregarArista("A", "B");
        grafo_GV.agregarArista("B", "A");
        grafo_GV.agregarArista("B", "C");
        grafo_GV.agregarArista("C", "B");
        grafo_GV.agregarArista("C", "D");
        grafo_GV.agregarArista("D", "A");
        grafo_GV.agregarArista("D", "C");
        grafo_GV.mostrar();
        SalidaPorDefecto.consola("Grado del A = "+grafo_GV.gradoVertice("A"));

        //
    }
}