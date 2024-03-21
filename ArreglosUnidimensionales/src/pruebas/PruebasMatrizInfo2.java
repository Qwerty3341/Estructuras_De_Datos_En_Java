package pruebas;

import entradasalida.SalidaPorDefecto;
import estructuraslineales.ListaInfo;
import estructuraslineales.ListaInfoEstatica;
import estructurasnolineales.MatrizInfo2;
import estructurasnolineales.MatrizInfo3;
import utilerias.comunes.TipoColumna;
import utilerias.comunes.TipoRenglon;

public class PruebasMatrizInfo2 {
    public static void main(String[] args) {
        // MatrizInfo2 m1 = new MatrizInfo2(2, 2, '■');
        // MatrizInfo2 m2 = new MatrizInfo2(4, 6, '■');
        // MatrizInfo2 m3 = new MatrizInfo2(5, 5);

        /*Pruebas*/

        //m1.imprimir();
        //m2.imprimir();

        //SalidaPorDefecto.consola("Elemento 0,0 = "+m2.obtener(8, 5));

        //m2.cambiar(0, 0, "Hola");
        //m2.imprimir();

        // m1.cambiar(1, 0, "W");
        // m1.cambiar(4, 4, "G");
        // m1.imprimir();
        // SalidaPorDefecto.consola("Numero de elementos= "+m1.obtenerRenglones()+"\n");
        // SalidaPorDefecto.consola("Numero de elementos= "+m1.obtenerColumnas());
        
        //m2.imprimirXRenglones();
        //m2.imprimirXColumnas();

        // m1.imprimir();
        // m1.rellenar("$");
        // m1.imprimir();

        //SalidaPorDefecto.consola("Clon= "+m2.clonar());

        // SalidaPorDefecto.consola("Igualdad="+m1.esIgual(m3)+"\n");
        // SalidaPorDefecto.consola("Igualdad="+m1.esIgual(m2));

        // m2.vectorColumna(2, "C");
        // m2.imprimir();
        // SalidaPorDefecto.consola("\n");
        // m2.vectorRenglon(4, "R");
        // m2.imprimir();

        // m1.imprimir();
        // m1.redefinir(m3);
        // SalidaPorDefecto.consola("\n");
        // m1.imprimir();

        // MatrizInfo2 m1 = new MatrizInfo2(2, 2,'■');
        // ListaInfoEstatica lis = new ListaInfoEstatica(2);
        // lis.insertar("1");
        // lis.insertar("2");
        // m1.agregarRenglon(lis);
        // m1.imprimir();

        // MatrizInfo2 m1 = new MatrizInfo2(2, 2,'■');
        // ListaInfoEstatica lis = new ListaInfoEstatica(2);
        // lis.insertar("1");
        // lis.insertar("2");
        // m1.agregarColumna(lis);
        // m1.imprimir();

        // MatrizInfo2 m1 = new MatrizInfo2(2, 2);
        // m1.cambiar(0, 0, '5');
        // m1.cambiar(0, 1, "-2");
        // m1.cambiar(1, 0, '7');
        // m1.cambiar(1, 1, '1');
        // m1.imprimir();
        // SalidaPorDefecto.consola("Traspuesta\n");
        // m1.transpuesta();
        // m1.imprimir();

        // MatrizInfo2 m1 = new MatrizInfo2(2, 2, 'x');
        // MatrizInfo2 m2 = new MatrizInfo2(2, 2, 'o');
        // m1.agregarMatrizXColumna(m2);
        // m1.imprimir();

        // MatrizInfo2 m1 = new MatrizInfo2(2, 2, 'x');
        // MatrizInfo2 m2 = new MatrizInfo2(2, 2, 'o');
        // m1.agregarMatrizXRenglon(m2);
        // m1.imprimir();

        // MatrizInfo2 m1 = new MatrizInfo2(2, 2, 'x');
        // SalidaPorDefecto.consola("Matriz original:\n");
        // m1.imprimir();
        // MatrizInfo2 vectorFila = m1.aVectorColumna();
        // SalidaPorDefecto.consola("\nVector fila:\n");
        // vectorFila.imprimir();

        // MatrizInfo2 m1 = new MatrizInfo2(4, 4, 'o');
        // m1.cambiar(0, 0, 'P');
        // m1.cambiar(0, 3, 'U');
        // SalidaPorDefecto.consola("Matriz original\n");
        // m1.imprimir();
        // SalidaPorDefecto.consola("Matriz con eliminar por izquierda\n");
        // m1.quitarColumna(TipoColumna.IZQ);
        // m1.imprimir();
        // SalidaPorDefecto.consola("Matriz con eliminar por derecha\n");
        // m1.quitarColumna(TipoColumna.DER);
        // m1.imprimir();

        // MatrizInfo2 m3 = new MatrizInfo2(3, 3, '*');        
        // m3.cambiar(2,1 , '$');
        // m3.imprimir();
        // SalidaPorDefecto.consola("Eliminando la fila 1 \n\n");
        // m3.eliminarRenglon(1);
        // m3.imprimir();

        MatrizInfo2 m3 = new MatrizInfo2(3, 3, '*');
        SalidaPorDefecto.consola("Matriz\n");
        m3.imprimir();
        SalidaPorDefecto.consola("Eliminando la columna 0\n\n");
        m3.eliminarColumna(0);
        m3.imprimir();

    }   
}
