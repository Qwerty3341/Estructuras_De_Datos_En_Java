package pruebas;

import entradasalida.SalidaPorDefecto;
import estructurasnolineales.ArbolBinarioBusqueda;

public class PruebaABBRecorridos {
    public static void main(String[] args) {
                SalidaPorDefecto.consola("\n_____________________________________\n");
        ArbolBinarioBusqueda arbol = new ArbolBinarioBusqueda();
        arbol.nuevoArbol();
        SalidaPorDefecto.consola("\nPostorden con recursividad\n");
        arbol.postorden();
        SalidaPorDefecto.consola("\nPostorden con ciclos\n");
        arbol.recorridoPostorden();

        SalidaPorDefecto.consola("\n_____________________________________\n");
        SalidaPorDefecto.consola("\nRecorriendo el arbol por amplitud\n");
        arbol.recorridoEnAmplitud();

        SalidaPorDefecto.consola("\n_____________________________________\n");
        SalidaPorDefecto.consola("\nRecorriendo el arbol por amplitud con pilas\n");
        arbol.recorridoEnAmplitudConPilas();
    }
}
