package pruebas;

import entradasalida.SalidaPorDefecto;
import estructuraslineales.ListaInfoDinamica;
import estructuraslineales.ListaInfoEstatica;
import estructurasnolineales.MatrizInfo2;

public class PruebaListaInfoDinamica2 {
    public static void main(String[] args) {
        ListaInfoDinamica lista = new ListaInfoDinamica();
        ListaInfoDinamica lista2 = new ListaInfoDinamica();
        ListaInfoEstatica listaEstatica = new ListaInfoEstatica(3);

        //Mostrar oi
            // lista.mostrarOI();
        //encontrar lista 
            // SalidaPorDefecto.consola("\nEncontrando lista del 2\n");
            // ListaInfoDinamica lista2 = lista.encontrarLista(2);
            // lista2.mostrar();
            // SalidaPorDefecto.consola("\n");
        //Pasar a info estatica
            // var listaestatica = lista.aListaEstatica();
            // lista.mostrar();
            // SalidaPorDefecto.consola("\nClase = "+listaestatica.getClass()+"\n");
            // listaestatica.mostrar();

        //Pasar a info estatica con argumentos
            // ListaInfoEstatica listaEstatica = lista.aListaEstatica(listaPrueba);
            // listaEstatica.mostrar();

        //A MATRIZ 
            // MatrizInfo2 m1 = lista.aMatrizInfo2(5,5);
            // m1.imprimir();

        //AgregarLista
            // lista.agregarLista(listaPrueba);
            // lista.mostrar();
        
        //Clonar
            // var listaClon =lista.clonar();
            // SalidaPorDefecto.consola("Clase="+listaClon.getClass()+"\n");
            // listaClon.mostrar();
        //Vaciar
            // lista.vaciar();
            // lista.mostrar();
        //Rellenar
            // ListaInfoDinamica listaVacia = new ListaInfoDinamica();
            // listaVacia.rellenar('Q', 5);       
            // listaVacia.mostrar();
        //Contar
            // lista.insertar(1);
            // lista.insertar(1);
            // lista.insertar(1);
            // lista.insertar(0);
            // lista.insertar(0);
            // lista.mostrar();
            // SalidaPorDefecto.consola("\n");
            // SalidaPorDefecto.consola("El 1 aparece "+lista.contar(1)+" veces\n");
            // SalidaPorDefecto.consola("El 0 aparece "+lista.contar(0)+" veces\n");
        
        //Invertir
            // lista.insertar('a');
            // lista.insertar('b');
            // lista.insertar('c');
            // lista.mostrar();
            // lista.invertir();
            // SalidaPorDefecto.consola("\nLista invertida:\n");
            // lista.mostrar();
        
        //Cambiar
            // lista.insertar(1);
            // lista.insertar(1);
            // lista.insertar(1);
            // lista.insertar(0);
            // lista.mostrar();
            // lista.cambiar(1, '@', 2);
            // SalidaPorDefecto.consola("\nCambiando el 1 por '@' 2 veces\n");
            // lista.mostrar();

        //Cambiar indice en especifico
            // lista.insertar('A');
            // lista.insertar('B');
            // lista.insertar('C');
            // lista.insertar('D');
            // lista.insertar('E');
            // lista.mostrar();
            // SalidaPorDefecto.consola("\nCambiando el indice 2 por 999\n");
            // lista.cambiar(2, 999);
            // lista.mostrar();
        //Obtener
            // lista.insertar('H');
            // lista.insertar('O');
            // lista.insertar('L');
            // lista.insertar('A');
            // lista.mostrar();
            // SalidaPorDefecto.consola("\nElemento en indice 2: "+lista.obtener(2));;

        //Es igual
            lista.insertar(1);
            lista.insertar(2);
            lista.insertar(3);
            lista2.insertar(2);
            lista2.insertar(1);
            lista2.insertar(3);
            lista.mostrar();
            SalidaPorDefecto.consola("\n");
            lista2.mostrar();
            SalidaPorDefecto.consola("\nSon iguales?: " + lista.esIgual(lista2));

        //Redimensionar
            // lista.insertar(1);
            // lista.insertar(2);
            // lista.insertar(3);
            // lista.insertar(4);
            // lista.insertar(5);
            // lista.mostrar();
            // SalidaPorDefecto.consola("\nLista redimensionada a 10:\n");
            // lista.redimensionar(10);
            // lista.mostrar();
            // lista.vaciar();
            // lista.insertar(1);
            // lista.insertar(2);
            // lista.insertar(3);
            // lista.insertar(4);
            // lista.insertar(5);;
            // lista.redimensionar(2);
            // SalidaPorDefecto.consola("\nLista redimensionada a 2:\n");
            // lista.mostrar();

        //Borrar
            // lista.insertar('A');
            // lista.insertar('B');
            // lista.insertar('C');
            // lista.mostrar();
            // SalidaPorDefecto.consola("\nEliminando el indice 1\n");
            // lista.borrar(1);
            // lista.mostrar();
        
        //Borrar varios elementos (Object valor)
            // lista.insertar('1');
            // lista.insertar('1');
            // lista.insertar('0');
            // lista.insertar('0');
            // lista.insertar('0');
            // lista.insertar('1');
            // lista.mostrar();
            // SalidaPorDefecto.consola("\nBorrando el 0:\n");
            // var borrados = lista.borrarVariosElementos('0');
            // lista.mostrar();
            // SalidaPorDefecto.consola("\nElementos borrados:\n");
            // borrados.mostrar();
    }
}