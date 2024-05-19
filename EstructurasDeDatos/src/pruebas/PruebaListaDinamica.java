package pruebas;

import entradasalida.SalidaPorDefecto;
import estructuraslineales.ListaInfoDinamica;

public class PruebaListaDinamica {
    public static void main(String[] args) {
        ListaInfoDinamica lista = new ListaInfoDinamica();
        lista.insertar("B");
        lista.insertar("C");
        lista.insertar("H");
        lista.insertar("R");
        lista.mostrar();
        SalidaPorDefecto.consola("\n");

        lista.insertarInicio("A");
        lista.mostrar();
        SalidaPorDefecto.consola("\n");

        SalidaPorDefecto.consola("Eliminando al principio "+lista.borrarInicio()+"\n");
        lista.mostrar();

        SalidaPorDefecto.consola("\nBuscando z: "+ lista.encontrar("Z")+"\n");
        SalidaPorDefecto.consola("Buscando h: "+lista.encontrar("H")+"\n");
        SalidaPorDefecto.consola("Eliminando al final: "+lista.borrar()+"\n");
        lista.mostrar();
        SalidaPorDefecto.consola("\n");

        //==========================================================

        lista.insertar("Z");
        lista.insertar("G");
        lista.mostrar();
        SalidaPorDefecto.consola("\n");
        SalidaPorDefecto.consola("Eliminando C: "+lista.borrar("C")+"\n");
        lista.mostrar();
        SalidaPorDefecto.consola("\n");

    }
}
