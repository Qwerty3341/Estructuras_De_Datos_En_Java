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
        SalidaPorDefecto.consola("\n_____________________________________\n");
        SalidaPorDefecto.consola("\tEs pseudografo");
        SalidaPorDefecto.consola("\n_____________________________________\n");
        SalidaPorDefecto.consola("Grafo original\n");
        GrafoDinamico grafo_EPG = new GrafoDinamico();
        grafo_EPG.agregarVertice("A");
        grafo_EPG.agregarVertice("B");
        grafo_EPG.agregarVertice("C");
        grafo_EPG.agregarVertice("D");
        grafo_EPG.agregarArista("A", "D");
        grafo_EPG.agregarArista("A", "B");
        grafo_EPG.agregarArista("B", "A");
        grafo_EPG.agregarArista("B", "C");
        grafo_EPG.agregarArista("C", "B");
        grafo_EPG.agregarArista("C", "D");
        grafo_EPG.agregarArista("D", "A");
        grafo_EPG.agregarArista("D", "C");
        grafo_EPG.mostrar();
        SalidaPorDefecto.consola("Es pseudografo? = "+grafo_EPG.esPseudografo());

        //Es multigrafo
        SalidaPorDefecto.consola("\n_____________________________________\n");
        SalidaPorDefecto.consola("\tEs multigrafo");
        SalidaPorDefecto.consola("\n_____________________________________\n");
        SalidaPorDefecto.consola("Grafo original\n");
        GrafoDinamico grafo_EM = new GrafoDinamico();
        grafo_EM.agregarVertice("A");
        grafo_EM.agregarVertice("B");
        grafo_EM.agregarVertice("C");
        grafo_EM.agregarVertice("D");
        grafo_EM.agregarArista("A", "D");
        grafo_EM.agregarArista("A", "B");
        grafo_EM.agregarArista("B", "A");
        grafo_EM.agregarArista("B", "C");
        grafo_EM.agregarArista("C", "B");
        grafo_EM.agregarArista("C", "D");
        grafo_EM.agregarArista("D", "A");
        grafo_EM.agregarArista("D", "C");
        grafo_EM.mostrar();
        SalidaPorDefecto.consola("Es multigrafo? = " + grafo_EM.esMultigrafo());

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

        //hay ruta 
        SalidaPorDefecto.consola("\n_____________________________________\n");
        SalidaPorDefecto.consola("\tHay ruta");
        SalidaPorDefecto.consola("\n_____________________________________\n");
        SalidaPorDefecto.consola("Grafo original\n");
        GrafoDinamico grafo_AR = new GrafoDinamico();
        grafo_AR.agregarVertice("A");
        grafo_AR.agregarVertice("B");
        grafo_AR.agregarVertice("C");
        grafo_AR.agregarVertice("D");
        grafo_AR.agregarArista("A", "D");
        grafo_AR.agregarArista("A", "B");
        grafo_AR.agregarArista("B", "A");
        grafo_AR.agregarArista("B", "C");
        grafo_AR.agregarArista("C", "B");
        grafo_AR.agregarArista("C", "D");
        grafo_AR.agregarArista("D", "A");
        grafo_AR.agregarArista("D", "C");
        grafo_AR.mostrar();

        SalidaPorDefecto.consola("Hay ruta de A a D? = "+grafo_AR.hayRuta("A", "D"));

        //Es conexo
        SalidaPorDefecto.consola("\n_____________________________________\n");
        SalidaPorDefecto.consola("\tEs conexo");
        SalidaPorDefecto.consola("\n_____________________________________\n");
        SalidaPorDefecto.consola("Grafo original\n");
        GrafoDinamico grafo_EC = new GrafoDinamico();
        grafo_EC.agregarVertice("A");
        grafo_EC.agregarVertice("B");
        grafo_EC.agregarVertice("C");
        grafo_EC.agregarVertice("D");
        grafo_EC.agregarArista("A", "D");
        grafo_EC.agregarArista("A", "B");
        grafo_EC.agregarArista("B", "A");
        grafo_EC.agregarArista("B", "C");
        grafo_EC.agregarArista("C", "B");
        grafo_EC.agregarArista("C", "D");
        grafo_EC.agregarArista("D", "A");
        grafo_EC.agregarArista("D", "C");
        grafo_EC.mostrar();
        SalidaPorDefecto.consola("Es conexo ? = "+grafo_EC.esConexo());

        //Hay camino cerrado
        SalidaPorDefecto.consola("\n_____________________________________\n");
        SalidaPorDefecto.consola("\tHay camino cerrado");
        SalidaPorDefecto.consola("\n_____________________________________\n");
        SalidaPorDefecto.consola("Grafo original\n");
        GrafoDinamico grafo_ACC = new GrafoDinamico();
        grafo_ACC.agregarVertice("A");
        grafo_ACC.agregarVertice("B");
        grafo_ACC.agregarVertice("C");
        grafo_ACC.agregarVertice("D");
        grafo_ACC.agregarArista("A", "D");
        grafo_ACC.agregarArista("A", "B");
        grafo_ACC.agregarArista("B", "A");
        grafo_ACC.agregarArista("B", "C");
        grafo_ACC.agregarArista("C", "B");
        grafo_ACC.agregarArista("C", "D");
        grafo_ACC.agregarArista("D", "A");
        grafo_ACC.agregarArista("D", "C");
        grafo_ACC.mostrar();
        SalidaPorDefecto.consola("Hay camino cerrado desde A?="+grafo_ACC.hayCaminoCerrado("A"));

        //Es camino simple
        SalidaPorDefecto.consola("\n_____________________________________\n");
        SalidaPorDefecto.consola("\tEs camino simple");
        SalidaPorDefecto.consola("\n_____________________________________\n");
        SalidaPorDefecto.consola("Grafo original\n");
        GrafoDinamico grafo_ECS = new GrafoDinamico();
        grafo_ECS.agregarVertice("A");
        grafo_ECS.agregarVertice("B");
        grafo_ECS.agregarVertice("C");
        grafo_ECS.agregarVertice("D");
        grafo_ECS.agregarArista("A", "D");
        grafo_ECS.agregarArista("A", "B");
        grafo_ECS.agregarArista("B", "A");
        grafo_ECS.agregarArista("B", "C");
        grafo_ECS.agregarArista("C", "B");
        grafo_ECS.agregarArista("C", "D");
        grafo_ECS.agregarArista("D", "A");
        grafo_ECS.agregarArista("D", "C");
        grafo_ECS.mostrar();
        SalidaPorDefecto.consola("Es camino simple de A a D? = "+grafo_ECS.esCaminoSimple("A", "D"));

        //Es dirigido
        SalidaPorDefecto.consola("\n_____________________________________\n");
        SalidaPorDefecto.consola("\tEs dirigido");
        SalidaPorDefecto.consola("\n_____________________________________\n");
        SalidaPorDefecto.consola("Grafo original\n");
        GrafoDinamico grafo_ED = new GrafoDinamico();
        grafo_ED.agregarVertice("A");
        grafo_ED.agregarVertice("B");
        grafo_ED.agregarVertice("C");
        grafo_ED.agregarVertice("D");
        grafo_ED.agregarArista("A", "D");
        grafo_ED.agregarArista("A", "B");
        grafo_ED.agregarArista("B", "A");
        grafo_ED.agregarArista("B", "C");
        grafo_ED.agregarArista("C", "B");
        grafo_ED.agregarArista("C", "D");
        grafo_ED.agregarArista("D", "A");
        grafo_ED.agregarArista("D", "C");
        grafo_ED.mostrar();
        SalidaPorDefecto.consola("Es dirigido? = " + grafo_ED.esDirigido());

        //Es arbol
        SalidaPorDefecto.consola("\n_____________________________________\n");
        SalidaPorDefecto.consola("\tEs arbol");
        SalidaPorDefecto.consola("\n_____________________________________\n");
        SalidaPorDefecto.consola("Grafo original\n");
        GrafoDinamico grafo_EAr = new GrafoDinamico();
        grafo_EAr.agregarVertice("A");
        grafo_EAr.agregarVertice("B");
        grafo_EAr.agregarVertice("C");
        grafo_EAr.agregarVertice("D");
        grafo_EAr.agregarArista("A", "D");
        grafo_EAr.agregarArista("A", "B");
        grafo_EAr.agregarArista("B", "A");
        grafo_EAr.agregarArista("B", "C");
        grafo_EAr.agregarArista("C", "B");
        grafo_EAr.agregarArista("C", "D");
        grafo_EAr.agregarArista("D", "A");
        grafo_EAr.agregarArista("D", "C");
        grafo_EAr.mostrar();
        SalidaPorDefecto.consola("Es arbol? = "+grafo_EAr.esArbol());

        //Listar aristas
        SalidaPorDefecto.consola("\n_____________________________________\n");
        SalidaPorDefecto.consola("\tListar aristas");
        SalidaPorDefecto.consola("\n_____________________________________\n");
        SalidaPorDefecto.consola("Grafo original\n");
        GrafoDinamico grafo_LA = new GrafoDinamico();
        grafo_LA.agregarVertice("A");
        grafo_LA.agregarVertice("B");
        grafo_LA.agregarVertice("C");
        grafo_LA.agregarVertice("D");
        grafo_LA.agregarArista("A", "D");
        grafo_LA.agregarArista("A", "B");
        grafo_LA.agregarArista("B", "A");
        grafo_LA.agregarArista("B", "C");
        grafo_LA.agregarArista("C", "B");
        grafo_LA.agregarArista("C", "D");
        grafo_LA.agregarArista("D", "A");
        grafo_LA.agregarArista("D", "C");
        grafo_LA.mostrar();
        var le = grafo_LA.listarAristas();
        SalidaPorDefecto.consola("\nAristas:");
        le.mostrar();

        //Listar aristas de vertice
        SalidaPorDefecto.consola("\n_____________________________________\n");
        SalidaPorDefecto.consola("\tListar aristas de vertice");
        SalidaPorDefecto.consola("\n_____________________________________\n");
        SalidaPorDefecto.consola("Grafo original\n");
        GrafoDinamico grafo_LAV = new GrafoDinamico();
        grafo_LAV.agregarVertice("A");
        grafo_LAV.agregarVertice("B");
        grafo_LAV.agregarVertice("C");
        grafo_LAV.agregarVertice("D");
        grafo_LAV.agregarArista("A", "D");
        grafo_LAV.agregarArista("A", "B");
        grafo_LAV.agregarArista("B", "A");
        grafo_LAV.agregarArista("B", "C");
        grafo_LAV.agregarArista("C", "B");
        grafo_LAV.agregarArista("C", "D");
        grafo_LAV.agregarArista("D", "A");
        grafo_LAV.agregarArista("D", "C");
        grafo_LAV.mostrar();
        SalidaPorDefecto.consola("\nAristas del vertice C:\n");
        grafo_LAV.listarAristas("C").mostrar();

        //Listar vertices
        SalidaPorDefecto.consola("\n_____________________________________\n");
        SalidaPorDefecto.consola("\tListar vertices");
        SalidaPorDefecto.consola("\n_____________________________________\n");
        SalidaPorDefecto.consola("Grafo original\n");
        GrafoDinamico grafo_LV = new GrafoDinamico();
        grafo_LV.agregarVertice("A");
        grafo_LV.agregarVertice("B");
        grafo_LV.agregarVertice("C");
        grafo_LV.agregarVertice("D");
        grafo_LV.agregarArista("A", "D");
        grafo_LV.agregarArista("A", "B");
        grafo_LV.agregarArista("B", "A");
        grafo_LV.agregarArista("B", "C");
        grafo_LV.agregarArista("C", "B");
        grafo_LV.agregarArista("C", "D");
        grafo_LV.agregarArista("D", "A");
        grafo_LV.agregarArista("D", "C");
        grafo_LV.mostrar();
        SalidaPorDefecto.consola("Vertices:\n");
        grafo_LV.listarVertices().mostrar();
    }
}