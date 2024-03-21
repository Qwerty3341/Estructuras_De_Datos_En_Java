package pruebas;

import entradasalida.SalidaPorDefecto;
import estructuraslineales.ListaInfoEstaticaNumerica;
import estructurasnolineales.MatrizInfo2Numerica;
import utilerias.comunes.TipoLogaritmo;

public class PruebaMatrizInfo2Numerica {
    public static void main(String[] args) {
        MatrizInfo2Numerica m1 = new MatrizInfo2Numerica(4, 4);
        MatrizInfo2Numerica m2 = new MatrizInfo2Numerica(3, 3, 3);
        MatrizInfo2Numerica m3 = new MatrizInfo2Numerica(2, 2);
        MatrizInfo2Numerica m4 = new MatrizInfo2Numerica(2, 2);
        ListaInfoEstaticaNumerica lista = new ListaInfoEstaticaNumerica(3);

        //Pruebas

        // Crear una instancia de MatrizInfo2Numerica con 3 filas y 3 columnas
        MatrizInfo2Numerica matriz = new MatrizInfo2Numerica(3, 3);
        matriz.cambiar(0, 0, 5);
        matriz.cambiar(0, 1, 0);
        matriz.cambiar(0, 2, 0);
        matriz.cambiar(1, 0, 4);
        matriz.cambiar(1, 1, 2);
        matriz.cambiar(1, 2, 0);
        matriz.cambiar(2, 0, 2);
        matriz.cambiar(2, 1, 3);
        matriz.cambiar(2, 2, 1);

        SalidaPorDefecto.consola("Matriz:\n");
        matriz.imprimir();
        SalidaPorDefecto.consola("Es matriz triangular inferior: "+matriz.esDiagonalInferior());
        

        // MatrizInfo2Numerica matriz = new MatrizInfo2Numerica(3, 3);
        // matriz.cambiar(0, 0, 4);
        // matriz.cambiar(0, 1, 3);
        // matriz.cambiar(0, 2, 1);
        // matriz.cambiar(1, 0, 0);
        // matriz.cambiar(1, 1, 2);
        // matriz.cambiar(1, 2, 5);
        // matriz.cambiar(2, 0, 0);
        // matriz.cambiar(2, 1, 0);
        // matriz.cambiar(2, 2, 1);
        // SalidaPorDefecto.consola("Matriz:\n");
        // matriz.imprimir();
        // SalidaPorDefecto.consola("Es diagonal superior: "+matriz.esDiagonalSuperior());

        // SalidaPorDefecto.consola("Matriz:\n");
        // m1.imprimir();
        // SalidaPorDefecto.consola("Matriz diagonalizada con 3:\n");
        // m1.matrizDiagonal(3);
        // m1.imprimir();

        // m3.cambiar(0, 0, 2);
        // m3.cambiar(0, 1, 3);
        // m3.cambiar(1, 0, -1);
        // m3.cambiar(1, 1, 0);

        // SalidaPorDefecto.consola("Matriz:\n");
        // m3.imprimir();
        // SalidaPorDefecto.consola("Matriz con potencia 5\n");
        // m3.potencia(5);
        // m3.imprimir();

        // m1.cambiar(0, 0, 4);
        // m1.cambiar(0, 1, 6);
        // m1.cambiar(0, 2, 4);
        // m1.cambiar(0, 3, 3);
        // m1.cambiar(1, 0, 1);
        // m1.cambiar(1, 1, 2);
        // m1.cambiar(1, 2, 2);
        // m1.cambiar(1, 3, 4);
        // m1.cambiar(2, 0, 5);
        // m1.cambiar(2, 1, 3);
        // m1.cambiar(2, 2, 2);
        // m1.cambiar(2, 3, 1);
        // m1.cambiar(3, 0, 0);
        // m1.cambiar(3, 1, 8);
        // m1.cambiar(3, 2, 7);
        // m1.cambiar(3, 3, 3);
        // SalidaPorDefecto.consola("Matriz original:\n");
        // m1.imprimir();
        // SalidaPorDefecto.consola("Matriz doblada:\n");
        // m1.doblarColumnas();
        // m1.imprimir();

        // m1.cambiar(0, 0, 4);
        // m1.cambiar(0, 1, 6);
        // m1.cambiar(0, 2, 4);
        // m1.cambiar(0, 3, 3);

        // m1.cambiar(1, 0, 1);
        // m1.cambiar(1, 1, 2);
        // m1.cambiar(1, 2, 2);
        // m1.cambiar(1, 3, 4);

        // m1.cambiar(2, 0, 5);
        // m1.cambiar(2, 1, 3);
        // m1.cambiar(2, 2, 2);
        // m1.cambiar(2, 3, 1);

        // m1.cambiar(3, 0, 0);
        // m1.cambiar(3, 1, 8);
        // m1.cambiar(3, 2, 7);
        // m1.cambiar(3, 3, 3);

        // SalidaPorDefecto.consola("Matriz original:\n");
        // m1.imprimir();
        // SalidaPorDefecto.consola("Matriz doblada:\n");
        // m1.doblarRenglones();
        // m1.imprimir();
        
        // m3.cambiar(0, 0, 1);
        // m3.cambiar(0, 1, 2);
        // m3.cambiar(1, 0, 3);
        // m3.cambiar(1, 1, 4);
        // SalidaPorDefecto.consola("Matriz original\n");
        // m3.imprimir();
        // SalidaPorDefecto.consola("Matriz con log base 10\n");
        // m3.aplicarLogaritmo(TipoLogaritmo.BASE10);
        // m3.imprimir();
        // SalidaPorDefecto.consola("Matriz con log base 2\n");
        // m3.aplicarLogaritmo(TipoLogaritmo.BASE2);
        // m3.imprimir();
        // SalidaPorDefecto.consola("Matriz con log natural\n");
        // m3.aplicarLogaritmo(TipoLogaritmo.NATURAL);
        // m3.imprimir();

        // m3.cambiar(0, 0, 3);
        // m3.cambiar(0, 1, 2);
        // m3.cambiar(1, 0, 1);
        // m3.cambiar(1, 1, -5);
        // SalidaPorDefecto.consola("Matriz original\n");
        // m3.imprimir();
        // SalidaPorDefecto.consola("Matriz con potencia 3 elemento por elemento\n");
        // m3.aplicarPotencia(3);
        // m3.imprimir();

        // SalidaPorDefecto.consola("Matriz A\n");
        // m3.cambiar(0, 0, 2);
        // m3.cambiar(0, 1, -3);
        // m3.cambiar(1, 0, -3);
        // m3.cambiar(1, 1, 4);
        // m3.imprimir();
        // SalidaPorDefecto.consola("Matriz B\n");
        // m4.cambiar(0, 0, 3);
        // m4.cambiar(0, 1, 2);
        // m4.cambiar(1, 0, 1);
        // m4.cambiar(1, 1, 3);
        // m4.imprimir();
        // SalidaPorDefecto.consola("Matriz A+B\n");
        // m3.sumar(m4);
        // m3.imprimir();

        // SalidaPorDefecto.consola("Matriz A\n");
        // m3.cambiar(0, 0, -5);
        // m3.cambiar(0, 1, 3);
        // m3.cambiar(1, 0, 4);
        // m3.cambiar(1, 1, 7);
        // m3.imprimir();
        // SalidaPorDefecto.consola("Matriz B\n");
        // m4.cambiar(0, 0, 9);
        // m4.cambiar(0, 1, 0);
        // m4.cambiar(1, 0, 2);
        // m4.cambiar(1, 1, -5);
        // m4.imprimir();
        // SalidaPorDefecto.consola("Matriz A*B\n");
        // m3.multiplicar(m4);
        // m3.imprimir();

        // lista.insertar(80);
        // lista.insertar(1000);
        // lista.insertar(99999);
        // SalidaPorDefecto.consola("Lista:\n");
        // lista.mostrar();
        // SalidaPorDefecto.consola("Matriz:\n");
        // m1.imprimir();
        // SalidaPorDefecto.consola("Sumando escalares:\n");
        // m1.sumarEscalares(lista);
        // m1.imprimir();
        
        // SalidaPorDefecto.consola("Matriz original: \n");
        // m1.imprimir();
        // SalidaPorDefecto.consola("Sumando escalar 5: \n");
        // m1.sumarEscalar(5);
        // m1.imprimir();
        

        // SalidaPorDefecto.consola("Matriz original\n");
        // m1.imprimir();
        // SalidaPorDefecto.consola("Matriz multiplicada por 3\n");
        // m1.porEscalar(3);
        // m1.imprimir();

        // lista.insertar(5);
        // lista.insertar(10);
        // lista.insertar(20);
        // SalidaPorDefecto.consola("Lista:\n");
        // lista.mostrar();
        // SalidaPorDefecto.consola("Matriz:\n");
        // m2.imprimir();
        // SalidaPorDefecto.consola("Matriz por escalares:\n");
        // m2.porEscalares(lista);
        // m2.imprimir();

    }
}