package utilerias.ordenador;

import entradasalida.SalidaPorDefecto;
import estructuraslineales.ListaInfoEstaticaNumerica;

public final class Ordenador {

    public static void BogoSort(ListaInfoEstaticaNumerica lista) {
        int iteraciones = 0;
        SalidaPorDefecto.consola("Lista original:\n");
        lista.mostrarNumerico();

        //
        while (estaOrdenado(lista) == false) {
            shuffle(lista);
            iteraciones++;
        }
        //

        SalidaPorDefecto.consola("\n\nLista ordenada:\n");
        lista.mostrarNumerico();
        SalidaPorDefecto.consola("\n\nNúmero de iteraciones = " + iteraciones + "\n");
    }

    private static void shuffle(ListaInfoEstaticaNumerica lista) {
        for (int elemento = 0; elemento < lista.cantidad(); elemento++) {
            int indice_aleatorio_1 = (int) (Math.random() * lista.cantidad());
            int indice_aleatorio_2 = (int) (Math.random() * lista.cantidad());
            Double almacen = (Double) lista.obtenerElemento(indice_aleatorio_1);
            lista.cambiar(indice_aleatorio_1, lista.obtenerElemento(indice_aleatorio_2));
            lista.cambiar(indice_aleatorio_2, almacen);
        }
    }

    private static boolean estaOrdenado(ListaInfoEstaticaNumerica lista) {
        for (int elemento = 0; elemento < lista.cantidad() - 1; elemento++) {
            if ((Double) lista.obtenerElemento(elemento) > (Double) lista.obtenerElemento(elemento + 1)) {
                return false;
            }
        }
        return true;
    }
}
