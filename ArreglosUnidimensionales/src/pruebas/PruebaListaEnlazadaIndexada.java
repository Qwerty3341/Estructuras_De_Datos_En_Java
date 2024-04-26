package pruebas;

import entradasalida.SalidaPorDefecto;
import estructuraslineales.ListaEnlazadaIndexada;

public class PruebaListaEnlazadaIndexada {
    public static void main(String[] args) {
        //Insertando y mostrando
        SalidaPorDefecto.consola("\n--------------Insertamos por indice automatico y por indice manual-----------------\n");
        ListaEnlazadaIndexada l = new ListaEnlazadaIndexada();

        l.insertar('A');
        l.insertar('B');
        l.insertar('C');
        l.insertar('D');
        l.insertar('E');
        l.insertar('F');
        l.insertarIndice(4,'#');
        l.insertarIndice(5,'#');
        l.insertarIndice(12,'K');
        l.imprimir();


        //Metodo obtener
        
        SalidaPorDefecto.consola("\n\n\n\n------------------Obteniendo por indices--------------------------\n\n");
        l.imprimir();
        SalidaPorDefecto.consola("\nObteniendo el indice 6 = " + l.obtener(6)+"\n");
        SalidaPorDefecto.consola("\nObteniendo el indice 0 = " + l.obtener(0)+"\n");
        SalidaPorDefecto.consola("\nObteniendo el indice 4 = " + l.obtener(4)+"\n");

        //Cantidad de elementos
        SalidaPorDefecto.consola("\n\n\n\n-----------------Viendo cantidad de elementos---------------------------\n\n");
        l.imprimir();
        SalidaPorDefecto.consola("\nLongitud = " +l.getNumDeElementos());

        //Borrando
        SalidaPorDefecto.consola("\n\n\n\n-----------------Borrando indices---------------------------\n\n");
        l.imprimir();
        SalidaPorDefecto.consola("\nBorrando el indice 4:\n");
        l.borrarIndice(4);
        l.imprimir();
        SalidaPorDefecto.consola("\nBorrando el indice 0:\n");
        l.borrarIndice(0);
        l.imprimir();
        SalidaPorDefecto.consola("\nBorrando el indice 4:\n");
        l.borrarIndice(4);
        l.imprimir();
    }
}
