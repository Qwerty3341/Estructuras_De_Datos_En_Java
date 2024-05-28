package pruebas;

import entradasalida.SalidaPorDefecto;
import estructuraslineales.ColaInfoDinamica;

public class PruebaColaInfoDinamica {
    public static void main(String[] args) {
        ColaInfoDinamica c1 = new ColaInfoDinamica();
        c1.poner('a');
        c1.poner('b');
        c1.poner('c');
        c1.poner('d');
        c1.poner('f');
        c1.mostrar();
        SalidaPorDefecto.consola("\nFinal de la cola 1 = "+c1.verFinal());
        SalidaPorDefecto.consola("\nIndice 3 = "+c1.obtener(3));
        SalidaPorDefecto.consola("\nUsando el metodo quitar:\n");
        c1.quitar();
        c1.mostrar();
    }
}