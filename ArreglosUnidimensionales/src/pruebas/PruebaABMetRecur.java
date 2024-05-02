package pruebas;

import entradasalida.SalidaPorDefecto;
import estructurasnolineales.ArbolBinario;

public class PruebaABMetRecur {
    public static void main(String[] args) {
        //------------Calculando la altura del arbol ------------------------
        SalidaPorDefecto.consola("\n______________________________________________\n");
        ArbolBinario unArbol = new ArbolBinario();
        unArbol.nuevoArbol();
        unArbol.innorden();
        SalidaPorDefecto.consola("\n______________________________________________\n");
        SalidaPorDefecto.consola("\nAltura del arbol: "+unArbol.obtenerAltura());

        //------------Buscando niveles de elementos------------------------
        SalidaPorDefecto.consola("\n______________________________________________\n");
        SalidaPorDefecto.consola("\nNivel en el que se encuentra B: " + unArbol.buscarNivelDeNodo("B"));
        SalidaPorDefecto.consola("\nNivel en el que se encuentra H: " + unArbol.buscarNivelDeNodo("H"));
        SalidaPorDefecto.consola("\nNivel en el que se encuentra F: " + unArbol.buscarNivelDeNodo("F"));
        SalidaPorDefecto.consola("\nNivel en el que se encuentra A: " + unArbol.buscarNivelDeNodo("A"));

        //---------------Ver elementos existentes en cada nivel ----------------------
        SalidaPorDefecto.consola("\n______________________________________________\n");
        SalidaPorDefecto.consola("Obteniendo los elementos de cada nivel:\n");
        unArbol.contarNodosPorNivel();

        //--------------------------Ver si un nodo es raiz-----------------------------------
        SalidaPorDefecto.consola("\n______________________________________________\n");
        SalidaPorDefecto.consola("Viendo si B es raiz, interior u hoja: \n");
        SalidaPorDefecto.consola(unArbol.encontrarNodoConPadre("B"));

        //-------------Indicando si un nodo tiene hermano--------------------------------
        SalidaPorDefecto.consola("\n______________________________________________\n");
        SalidaPorDefecto.consola("El nodo D tiene hermano?\n");
        SalidaPorDefecto.consola(""+unArbol.encontrarNodoYHermano("D"));
    }
}
