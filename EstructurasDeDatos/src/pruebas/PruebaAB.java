package pruebas;

import entradasalida.SalidaPorDefecto;
import estructurasnolineales.ArbolBinario;

public class PruebaAB {
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        arbol.nuevoArbol();

        arbol.preorden();
        SalidaPorDefecto.consola("\n");

        arbol.postorden();
        SalidaPorDefecto.consola("\n");

        arbol.innorden();
        SalidaPorDefecto.consola("\n");
    }
}
