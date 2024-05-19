package pruebas;

import entradasalida.SalidaPorDefecto;
import estructuraslineales.ListaInfoDinamica;
import estructuraslineales.ListaInfoEstatica;
import estructurasnolineales.MatrizInfo2;
import utilerias.comunes.TipoTabla;

public class PruebaListaInfoDinamica2 {
    public static void main(String[] args) {
        ListaInfoDinamica lista = new ListaInfoDinamica();
        ListaInfoDinamica lista2 = new ListaInfoDinamica();

        //Mostrar oi
            // SalidaPorDefecto.consola("lista original\n");
            // lista.insertar('A');
            // lista.insertar('B');
            // lista.insertar('C');
            // lista.insertar('D');
            // lista.mostrar();
            // SalidaPorDefecto.consola("\nlista en orden inverso\n");
            // lista.mostrarOI();
        //encontrar lista 
            // SalidaPorDefecto.consola("lista:\n");
            // lista.insertar(1);
            // lista.insertar(0);
            // lista.insertar(1);
            // lista.insertar(0);
            // lista.insertar(0);
            // lista.mostrar();
            // SalidaPorDefecto.consola("\nEncontrando el 1\n");
            // lista2 = lista.encontrarLista(1);
            // lista2.mostrar();
        //Pasar a info estatica
            // lista.insertar('X');
            // lista.insertar('Y');
            // lista.insertar('Z');
            // lista.insertar('W');
            // lista.mostrar();
            // var listaestatica = lista.aListaEstatica();
            // SalidaPorDefecto.consola("\nClase = "+listaestatica.getClass()+"\n");
            // listaestatica.mostrar();

        //Pasar a info estatica con argumentos
            // ListaInfoEstatica listaEstatica = new ListaInfoEstatica(3);
            // SalidaPorDefecto.consola("Elementos a eliminar: \n");
            // listaEstatica.insertar(2);
            // listaEstatica.insertar(4);
            // listaEstatica.insertar(6);
            // listaEstatica.mostrar();
            // SalidaPorDefecto.consola("Lista dinamica:\n");
            // lista.insertar(1);
            // lista.insertar(2);
            // lista.insertar(3);
            // lista.insertar(4);
            // lista.insertar(5);
            // lista.insertar(6);
            // lista.mostrar();
            // SalidaPorDefecto.consola("\nA lista estatica:\n");
            // var nuevaLista = lista.aListaEstatica(listaEstatica);
            // nuevaLista.mostrar();

        //A matriz 
            // lista.insertar('A');
            // lista.insertar('B');
            // lista.insertar('C');
            // lista.insertar('D');
            // lista.mostrar();
            // SalidaPorDefecto.consola("\nPasandola a una matriz 4x4\n");
            // MatrizInfo2 m = lista.aMatrizInfo2(4, 4);
            // m.imprimir();

        //A MATRIZ por columna y fila
            // MatrizInfo2 matriz = lista.aMatrizInfo2(3,3);
            // matriz.cambiar(0, 0, 1);
            // matriz.cambiar(0, 1, 2);
            // matriz.cambiar(0, 2, 3);
            // matriz.cambiar(1, 0, 4);
            // matriz.cambiar(1, 1, 5);
            // matriz.cambiar(1, 2, 6);
            // matriz.cambiar(2, 0, 7);
            // matriz.cambiar(2, 1, 8);
            // matriz.cambiar(2, 2, 9);
            // SalidaPorDefecto.consola("Matriz\n");
            // matriz.imprimir();
            // SalidaPorDefecto.consola("\nlista dinamica con renglones de la matriz:\n");
            // lista.agregarMatriz(matriz, TipoTabla.POR_RENGLON);
            // lista.mostrar();
            // SalidaPorDefecto.consola("\nlista dinamica con columnas de la matriz:\n");
            // lista.vaciar();
            // lista.agregarMatriz(matriz, TipoTabla.POR_COLUMNA);
            // lista.mostrar();

        //AgregarLista
            // lista.insertar(23);
            // lista.insertar(67);
            // lista.insertar(91);
            // lista.insertar(88);
            // SalidaPorDefecto.consola("Lista 1:\n");
            // lista.mostrar();
            // SalidaPorDefecto.consola("\nLista 2:\n");
            // lista2.insertar('A');
            // lista2.insertar('F');
            // lista2.insertar('H');
            // lista2.insertar('P');
            // lista2.mostrar();
            // SalidaPorDefecto.consola("\nAgregando la lista 2 a la lista 1:\n");
            // lista.agregarLista(lista2);
            // lista.mostrar();
        
        //Clonar
            // lista.insertar(12.3);
            // lista.insertar(-9);
            // lista.insertar(90);
            // SalidaPorDefecto.consola("Lista original:\n");
            // lista.mostrar();
            // var listaClon = lista.clonar();
            // SalidaPorDefecto.consola("\nClase de la lista clonada = "+listaClon.getClass()+"\n");
            // listaClon.mostrar();
            // SalidaPorDefecto.consola("\nLista 1 = "+lista+"\nLista 2 = "+lista2);

        //Vaciar
            // lista.insertar(-33);
            // lista.insertar(12);
            // lista.insertar(999);
            // lista.insertar(918);
            // lista.insertar(5632);
            // SalidaPorDefecto.consola("Lista:\n");
            // lista.mostrar();
            // SalidaPorDefecto.consola("\nVaciando la lista:\n");
            // lista.vaciar();
            // lista.mostrar();

        //Rellenar
            // ListaInfoDinamica listaVacia = new ListaInfoDinamica();
            // SalidaPorDefecto.consola("Lista vacia:\n");
            // listaVacia.mostrar();
            // SalidaPorDefecto.consola("\nRellenando la lista con 5 Q:\n");
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
            // lista.insertar('A');
            // lista.insertar('B');
            // lista.insertar('C');
            // lista.insertar('D');
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
            // SalidaPorDefecto.consola("\nCambiando el indice 2 por 8\n");
            // lista.cambiar(2, 8);
            // lista.mostrar();
        //Obtener
            // lista.insertar('H');
            // lista.insertar('O');
            // lista.insertar('L');
            // lista.insertar('A');
            // lista.mostrar();
            // SalidaPorDefecto.consola("\nElemento en indice 2: "+lista.obtener(2));;

        //Es igual
            // lista.insertar(1);
            // lista.insertar(2);
            // lista.insertar(3);
            // lista2.insertar(2);
            // lista2.insertar(1);
            // lista2.insertar(3);
            // lista.mostrar();
            // SalidaPorDefecto.consola("\n");
            // lista2.mostrar();
            // SalidaPorDefecto.consola("\nSon iguales?: " + lista.esIgual(lista2));

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
            // lista.insertar('D');
            // lista.insertar('E');
            // lista.mostrar();
            // SalidaPorDefecto.consola("\nEliminando el indice 2\n");
            // lista.borrar(2);
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