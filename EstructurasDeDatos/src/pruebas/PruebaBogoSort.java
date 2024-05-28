package pruebas;

import entradasalida.SalidaPorDefecto;
import estructuraslineales.ListaInfoEstaticaNumerica;
import utilerias.ordenador.Ordenador;

public class PruebaBogoSort {
    
    public static void main(String[] args) {
        ListaInfoEstaticaNumerica lista_chica = new ListaInfoEstaticaNumerica(5);
        lista_chica.insertar(12);
        lista_chica.insertar(0);
        lista_chica.insertar(4);
        lista_chica.insertar(15);
        lista_chica.insertar(6);

        ListaInfoEstaticaNumerica lista_mediana = new ListaInfoEstaticaNumerica(10);
        lista_mediana.insertar(5);
        lista_mediana.insertar(3);
        lista_mediana.insertar(600);
        lista_mediana.insertar(8);
        lista_mediana.insertar(1);
        lista_mediana.insertar(9);
        lista_mediana.insertar(4);
        lista_mediana.insertar(6);
        lista_mediana.insertar(7);
        lista_mediana.insertar(2);

        ListaInfoEstaticaNumerica lista_grande = new ListaInfoEstaticaNumerica(15);
        for (int insercion = 0; insercion < 15; insercion++) {
            lista_grande.insertar((int) (Math.random() * 100));
        }


        SalidaPorDefecto.consola("\n__________________________________\n");
        Ordenador.BogoSort(lista_chica);

        SalidaPorDefecto.consola("\n__________________________________\n");
        Ordenador.BogoSort(lista_mediana);

        SalidaPorDefecto.consola("\n__________________________________\n");
        Ordenador.BogoSort(lista_grande);

    }
}