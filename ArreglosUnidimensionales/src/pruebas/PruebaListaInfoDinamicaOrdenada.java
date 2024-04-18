package pruebas;

import entradasalida.SalidaPorDefecto;
import estructuraslineales.ListaInfoDinamicaOrdenada;
import estructuraslineales.ListaInfoEstatica;
import estructurasnolineales.MatrizInfo2;
import utilerias.comunes.TipoDeOrdenamiento;

public class PruebaListaInfoDinamicaOrdenada {

    public static void main(String[] args) {
        ListaInfoDinamicaOrdenada lista1 = new ListaInfoDinamicaOrdenada(TipoDeOrdenamiento.INC);
        ListaInfoDinamicaOrdenada lista2 = new ListaInfoDinamicaOrdenada(TipoDeOrdenamiento.DEC);
        // Insertar
            // SalidaPorDefecto.consola("""
            // Insertando 1, 55, 10, 4 y 414""");
            // lista1.insertar(-1);
            // lista1.insertar(55);
            // lista1.insertar(10);
            // lista1.insertar(4);
            // lista1.insertar(414);
            // SalidaPorDefecto.consola("\nMetodo imprimir natural: \n");
            // lista1.imprimirNatural();
            // SalidaPorDefecto.consola("\nMetodo imprimir reverso\n");
            // lista1.imprimirReverso();

        //Insertando de forma decresiente 
            // SalidaPorDefecto.consola("Insertando letras de forma decresiente\n");
            // lista2.insertar('W');
            // lista2.insertar('X');
            // lista2.insertar('A');
            // lista2.insertar('B');
            // lista2.imprimirNatural();

        //Buscar
            // lista1.insertar(1);
            // lista1.insertar(55);
            // lista1.insertar(10);
            // lista1.insertar(4);
            // lista1.insertar(414);
            // SalidaPorDefecto.consola("\nBuscando el 10 asendente\n");
            // SalidaPorDefecto.consola("Esta en el indice: "+lista1.buscarOrdenada(10));

        // Eliminar
            // lista1.insertar(1);
            // lista1.insertar(55);
            // lista1.insertar(10);
            // lista1.insertar(4);
            // lista1.insertar(414);
            // lista1.mostrar();
            // SalidaPorDefecto.consola("\nEliminando el elemento "+ lista1.eliminar(55)+"\n");
            // lista1.mostrar();

        // Insertar final
            // SalidaPorDefecto.consola("\nInsertando final\n");
            // lista1.insertar(3);
            // lista1.insertar(4);
            // lista1.insertar(1);
            // SalidaPorDefecto.consola("Se puede insertar el 2? "+lista1.insertarFinal(lista2)+"\n");
            // lista1.imprimirNatural();

        // Insertar inicio
            // SalidaPorDefecto.consola("\nInsertando inicio\n");
            // lista1.insertar('B');
            // lista1.insertar('C');
            // lista1.insertar('D');
            // SalidaPorDefecto.consola("Se puede insertar la A? "+lista1.insertarInicio('A')+"\n");
            // lista1.imprimirNatural();
            
        // Eliminar al final
            // lista2.insertar('A');
            // lista2.insertar('B');
            // lista2.insertar('C');
            // SalidaPorDefecto.consola("Lista original:\n");
            // lista2.imprimirNatural();
            // SalidaPorDefecto.consola("\nEliminando el final = "+lista2.eliminarFinal() + "\n");
            // lista2.imprimirNatural();

        // Eliminar al inicio
            // lista2.insertar('A');
            // lista2.insertar('B');
            // lista2.insertar('C');
            // SalidaPorDefecto.consola("Lista original:\n");
            // lista2.imprimirNatural();
            // SalidaPorDefecto.consola("\nEliminando el inicio = "+lista2.eliminarInicio() + "\n");
            // lista2.imprimirNatural();

        // Insertar lista
            // ListaInfoEstatica listaEstatica = new ListaInfoEstatica(2);
            // listaEstatica.insertar(0);
            // listaEstatica.insertar(1);
            // SalidaPorDefecto.consola("\nLista pasada como argumento:\n");
            // listaEstatica.mostrar();
            // SalidaPorDefecto.consola("\nLista dinamica ordenada:\n");
            // lista1.insertar('A');
            // lista1.imprimirNatural();
            // SalidaPorDefecto.consola("\nAgregando la lista pasada como argumento:\n");
            // lista1.insertarArreglo(listaEstatica);
            // lista1.imprimirNatural();

        // Insertar matriz 2D
            // MatrizInfo2 matrix = new MatrizInfo2(2, 2);
            // matrix.cambiar(0, 0, 1);
            // matrix.cambiar(0, 1, 2);
            // matrix.cambiar(1, 0, 3);
            // matrix.cambiar(1, 1, 4);
            // SalidaPorDefecto.consola("Matriz que vamos a agregar:\n");
            // matrix.imprimir();
            // SalidaPorDefecto.consola("\nLista:\n");
            // lista2.insertar(5);
            // lista2.insertar(6);
            // lista2.insertar(7);
            // lista2.imprimirNatural();
            // SalidaPorDefecto.consola("\nAgregando la matriz a la lista\n");
            // lista2.insertarMatriz(matrix);
            // lista2.imprimirNatural();

        // Eliminar lista
            // SalidaPorDefecto.consola("Lista a eliminar\n");
            // ListaInfoEstatica lista = new ListaInfoEstatica(2);
            // lista.insertar(1);
            // lista.insertar(0);
            // lista.mostrar();
            // SalidaPorDefecto.consola("Lista ordenada:\n");
            // lista1.insertar(-2);
            // lista1.insertar(-1);
            // lista1.insertar(0);
            // lista1.insertar(1);
            // lista1.insertar(2);
            // lista1.imprimirNatural();
            // SalidaPorDefecto.consola("\nEliminando la lista\n");
            // lista1.eliminarArreglo(lista);
            // lista1.imprimirNatural();
        // Eliminar matriz 2D
            // MatrizInfo2 matrix = new MatrizInfo2(2, 2);
            // matrix.cambiar(0, 0, 1);
            // matrix.cambiar(0, 1, 2);
            // matrix.cambiar(1, 0, 3);
            // matrix.cambiar(1, 1, 4);
            // SalidaPorDefecto.consola("Matriz que vamos a eliminar:\n");
            // matrix.imprimir();
            // SalidaPorDefecto.consola("\nLista:\n");
            // lista2.insertar(0);
            // lista2.insertar(1);
            // lista2.insertar(2);
            // lista2.insertar(3);
            // lista2.insertar(4);
            // lista2.insertar(5);
            // lista2.imprimirNatural();
            // SalidaPorDefecto.consola("\nEliminando la matriz a la lista\n");
            // lista2.eliminarMatriz(matrix);
            // lista2.imprimirNatural();
        // Reacomodar
            SalidaPorDefecto.consola("Lista a reacomodar:\n");
            lista1.insertar(-1);
            lista1.insertar(0);
            lista1.insertar(1);
            lista1.insertar(2);
            lista1.insertar(3);
            lista1.imprimirNatural();
            SalidaPorDefecto.consola("\nEliminando el 1 y colocando el 1.5\n");
            lista1.reacomodar(1, 1.5);
            lista1.imprimirNatural();


    }

}
