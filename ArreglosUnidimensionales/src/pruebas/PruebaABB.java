package pruebas;

import entradasalida.SalidaPorDefecto;
import estructurasnolineales.ArbolBinarioBusqueda;

public class PruebaABB {
    public static void main(String[] args) {
        ArbolBinarioBusqueda abb = new ArbolBinarioBusqueda();
        abb.insertar(9);
        abb.insertar(15);
        abb.insertar(25);
        abb.insertar(12);
        abb.insertar(13);
        abb.insertar(23);
        abb.insertar(7);
        abb.insertar(5);
        abb.insertar(6);
        abb.insertar(2);
        abb.insertar(8);

        SalidaPorDefecto.consola("\nInorden: ");
        abb.innorden();
        SalidaPorDefecto.consola("\nPreorden: ");
        abb.preorden();
        SalidaPorDefecto.consola("\nPostorden: ");
        abb.postorden();
        SalidaPorDefecto.consola("\n");
    }
}
