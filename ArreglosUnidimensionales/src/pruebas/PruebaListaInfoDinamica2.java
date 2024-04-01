package pruebas;

import entradasalida.SalidaPorDefecto;
import estructuraslineales.ListaInfoDinamica;
import estructuraslineales.ListaInfoEstatica;
import estructurasnolineales.MatrizInfo2;

public class PruebaListaInfoDinamica2 {
    public static void main(String[] args) {
        ListaInfoDinamica lista = new ListaInfoDinamica();
        ListaInfoEstatica listaPrueba = new ListaInfoEstatica(3);

        listaPrueba.insertar(2);
        listaPrueba.insertar(1);
        listaPrueba.insertar(3);

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
            lista.insertar('a');
            lista.insertar('b');
            lista.insertar('c');
            lista.mostrar();
            lista.invertir();
            SalidaPorDefecto.consola("\nLista invertida:\n");
            lista.mostrar();
            
    }
}