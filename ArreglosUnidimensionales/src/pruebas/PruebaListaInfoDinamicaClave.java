package pruebas;

import entradasalida.SalidaPorDefecto;
import estructuraslineales.ListaInfoDinamica;
import estructuraslineales.ListaInfoDinamicaClave;
import estructuraslineales.ListaInfoEstatica;
import estructurasnolineales.MatrizInfo2;

public class PruebaListaInfoDinamicaClave {

    public static void main(String[] args) {
        ListaInfoDinamicaClave listaCV = new ListaInfoDinamicaClave();
        //Insertar
            // listaCV.insertar("A", 32);
            // listaCV.insertar("B", 45);
            // listaCV.insertar("F", 67);
            // listaCV.mostrar();
            // SalidaPorDefecto.consola("\nInsertando un valor con una clave existente\n");
            // listaCV.insertar("F",99);
            // listaCV.mostrar();

        //Ver si esta vacio
            // listaCV.insertar("A", -22);
            // listaCV.insertar("B", 67);
            // listaCV.insertar("F", 2);
            // listaCV.mostrar();
            // SalidaPorDefecto.consola("\nEsta lista esta vacia? = "+listaCV.vacia());

        //Borrar
            // listaCV.insertar("A", 1);
            // listaCV.insertar("B", 2);
            // listaCV.insertar("C", 3);
            // listaCV.mostrar();
            // SalidaPorDefecto.consola("\nBorrando la clave B\n");
            // listaCV.borrar("B");
            // listaCV.mostrar();

        //BorrarContenido
            // listaCV.insertar("A", 1);
            // listaCV.insertar("B", 2);
            // listaCV.insertar("C", 3);
            // listaCV.mostrar();
            // SalidaPorDefecto.consola("\nBorrando el contenido 2 " + listaCV.borrarContenido(2)+"\n");
            // listaCV.mostrar();
            // SalidaPorDefecto.consola("\nBorrando el contenido 5 " + listaCV.borrarContenido(5)+"\n");
            // listaCV.mostrar();

        //Encontrar
            // listaCV.insertar("A", 1);
            // listaCV.insertar("B", 2);
            // listaCV.insertar("C", 3);
            // listaCV.mostrar();
            // SalidaPorDefecto.consola("\nValor de B = "+listaCV.encontrar("B"));

        //Encontrar contenido
            // listaCV.insertar("A", 1);
            // listaCV.insertar("B", 2);
            // listaCV.insertar("C", 3);
            // listaCV.mostrar();
            // SalidaPorDefecto.consola("\nClave de 3 = "+listaCV.encontrarContenido(3));
    
        //Cambiar
            // listaCV.insertar("A", 1);
            // listaCV.insertar("B", 2);
            // listaCV.insertar("C", 3);
            // listaCV.mostrar();
            // SalidaPorDefecto.consola("\nCambiando el valor de B = "+listaCV.cambiar("B", 999)+"\n");
            // listaCV.mostrar();

        //Cambiar valor
            // listaCV.insertar("A", 1);
            // listaCV.insertar("B", 2);
            // listaCV.insertar("C", 3);
            // listaCV.mostrar();
            // SalidaPorDefecto.consola("\nCambiando el valor 1 por 0 = "+listaCV.cambiarValor(1, 0)+"\n");
            // listaCV.mostrar();

        //Mostrar clave y valores
            // listaCV.insertar("A", 1);
            // listaCV.insertar("B", 2);
            // listaCV.insertar("C", 3);
            // listaCV.mostrarClaves();
            // SalidaPorDefecto.consola("\n");
            // listaCV.mostrarValores();

        //A lista estatica
            // SalidaPorDefecto.consola("Lista original\n");
            // listaCV.insertar("A", 1);
            // listaCV.insertar("B", 2);
            // listaCV.insertar("C", 3);
            // listaCV.mostrar();
            // SalidaPorDefecto.consola("\n\nConvirtiendola a lista estatica\n");
            // var l = listaCV.aListasEstaticas();
            // SalidaPorDefecto.consola("\nClase de la lista = "+l.getClass()+"\n");
            // l.mostrar();
            // SalidaPorDefecto.consola("\nLista de claves\n");
            // var l_1 = (ListaInfoEstatica) l.obtener(0);
            // l_1.mostrar();
            // SalidaPorDefecto.consola("\nLista de valores\n");
            // var l_2 = (ListaInfoEstatica) l.obtener(1);
            // l_2.mostrar();
            
        //A lista dinamica;
            // SalidaPorDefecto.consola("Lista original\n");
            // listaCV.insertar("A", 1);
            // listaCV.insertar("B", 2);
            // listaCV.insertar("C", 3);
            // listaCV.mostrar();
            // SalidaPorDefecto.consola("\nConvirtiendola a lista dinamica\n");
            // var l = listaCV.aListasDinamicas();
            // SalidaPorDefecto.consola("Clase de la lista = "+l.getClass()+"\n");
            // l.mostrar();
            // SalidaPorDefecto.consola("\nLista de claves\n");
            // var l_1 = (ListaInfoDinamica) l.obtener(0);
            // l_1.mostrar();
            // SalidaPorDefecto.consola("\nLista de valores\n");
            // var l_2 = (ListaInfoDinamica) l.obtener(1);
            // l_2.mostrar();

        //A matriz
            // listaCV.insertar("X",-1);
            // listaCV.insertar("Y",0);
            // listaCV.insertar("Z",1);
            // listaCV.mostrar();
            // SalidaPorDefecto.consola("\nConvirtiendola a matriz 2d:\n");
            // var m = listaCV.aMatriz2();
            // SalidaPorDefecto.consola("Clase = "+m.getClass()+"\n");
            // m.imprimir();

        //vaciar
            // listaCV.insertar("X",-1);
            // listaCV.insertar("Y",0);
            // listaCV.insertar("Z",1);
            // listaCV.mostrar();
            // SalidaPorDefecto.consola("\nVaciandola:\n");
            // listaCV.vaciar();
            // listaCV.mostrar();

        //Obtener
            // listaCV.insertar("X",-1);
            // listaCV.insertar("Y",0);
            // listaCV.insertar("Z",1);
            // listaCV.mostrar();
            // SalidaPorDefecto.consola("\nObteniendo la X = "+listaCV.obtener("X"));

        //AgregarLista
            // ListaInfoDinamicaClave l = new ListaInfoDinamicaClave();
            // l.insertar("W",3.14);
            // l.insertar("V","\\(°~°)/");
            // listaCV.insertar("X",0);
            // listaCV.insertar("Y",1);
            // SalidaPorDefecto.consola("Insertando:\n ");
            // l.mostrar();
            // SalidaPorDefecto.consola("\na la lista:\n");
            // listaCV.mostrar();
            // listaCV.agregarLista(l);
            // SalidaPorDefecto.consola("\nResultado:\n");
            // listaCV.mostrar();

        //AgregarListas estaticas
            // ListaInfoEstatica cla = new ListaInfoEstatica(2);
            // SalidaPorDefecto.consola("Claves\n");
            // cla.insertar("Q");
            // cla.insertar("K");
            // cla.mostrar();
            // ListaInfoEstatica val = new ListaInfoEstatica(2);
            // SalidaPorDefecto.consola("\nValores\n");
            // val.insertar(12);
            // val.insertar(4);
            // val.mostrar();
            // SalidaPorDefecto.consola("Resultado\n");
            // listaCV.agregarListasEstaticas(cla, val);
            // listaCV.mostrar();

            //Cantidad
                // listaCV.insertar("90",1);
                // listaCV.insertar("32",5);
                // listaCV.insertar("567",1.45e9);
                // listaCV.mostrar();
                // SalidaPorDefecto.consola("\nTamanio de la lista = "+listaCV.cantidad());

            //AgregarListas dinamicas
                // ListaInfoDinamica cla = new ListaInfoDinamica();
                // SalidaPorDefecto.consola("Claves\n");
                // cla.insertar("@");
                // cla.insertar("*");
                // cla.mostrar();
                // ListaInfoDinamica val = new ListaInfoDinamica();
                // SalidaPorDefecto.consola("\nValores\n");
                // val.insertar('^');
                // val.insertar(0.1);
                // val.mostrar();
                // SalidaPorDefecto.consola("Resultado\n");
                // listaCV.agregarListasDinamicas(cla, val);
                // listaCV.mostrar();

            //Agregar matriz
                // MatrizInfo2 m = new MatrizInfo2(2, 2);
                // m.cambiar(0, 0, "t");
                // m.cambiar(0, 1, "Hola");
                // m.cambiar(1, 0, "g");
                // m.cambiar(1, 1, "Adios");
                // m.imprimir();
                // listaCV.agregarMatriz2(m);
                // SalidaPorDefecto.consola("\nAgregando la matriz:\n");
                // listaCV.mostrar();
    }
}