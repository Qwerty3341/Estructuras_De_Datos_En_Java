package pruebas;

import entradasalida.SalidaPorDefecto;
import estructurasnolineales.ArbolDeExpresionesA;

public class PruebaAEA {
    public static void main(String[] args) {
        ArbolDeExpresionesA arbol = new ArbolDeExpresionesA();
        arbol.nuevoArbolPostfija("ab+nc*4/8^3*-");

        arbol.innorden();
        SalidaPorDefecto.consola("\n");
    }
}
