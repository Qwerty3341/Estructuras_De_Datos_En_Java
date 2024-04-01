package pruebas;

import entradasalida.SalidaPorDefecto;
import estructuraslineales.PilaInfoDinamica;

public class PruebaPilaInfoDinamica {
    public static void main(String[] args) {
        PilaInfoDinamica p1 = new PilaInfoDinamica();
        PilaInfoDinamica p2 = new PilaInfoDinamica();
        p1.poner(1);
        p1.poner(2);
        p1.poner(3);
        p1.poner(4);
        p1.poner(5);
        p1.quitar();
        SalidaPorDefecto.consola("Pila 1: ");
        p1.mostrar();
        SalidaPorDefecto.consola("\nPila 2: ");
        p2.mostrar();
        SalidaPorDefecto.consola("\nPila 1 vacia? = "+p1.vacio()+"\n");
        SalidaPorDefecto.consola("Pila 2 vacia? = "+p2.vacio()+"\n");
        SalidaPorDefecto.consola("Pila 1 llena? = "+p1.lleno()+"\n");
        SalidaPorDefecto.consola("Pila 2 llena? = "+p2.lleno()+"\n");
        SalidaPorDefecto.consola("Final de Pila 1 = "+p1.verFinal()+"\n");
        SalidaPorDefecto.consola("Final de Pila 2 = "+p2.verFinal()+"\n");
    }
}
