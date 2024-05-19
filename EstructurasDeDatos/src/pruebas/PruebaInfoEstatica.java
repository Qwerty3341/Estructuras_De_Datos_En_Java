package pruebas;

import entradasalida.SalidaPorDefecto;
import estructuraslineales.ListaInfoEstatica;

public class PruebaInfoEstatica {
    public static void main(String[] args) {
        ListaInfoEstatica lista1 = new ListaInfoEstatica(5);
        ListaInfoEstatica lista2 = new ListaInfoEstatica(5);

        lista1.insertar("A");
        lista1.insertar("B");
        lista1.insertar("C");
        lista1.insertar("D");
        lista1.insertar("E");
        lista1.redimensionar(7);
        lista1.mostrar();

        // SalidaPorDefecto.consola("Elemento borrado: " + lista1.borrar(3)+"\n" );

        // lista1.redimensionar(2);

        

        lista2.insertar("X");
        lista2.insertar("Y");
        lista2.insertar("Z");
        lista2.insertar("W");
        lista2.insertar("Q");
                

        // SalidaPorDefecto.consola("\nclonado "+lista1.clonar()+"\n\n");
        // SalidaPorDefecto.consola("\nSublista"+lista1.subLista(0, 2)+"\n\n");
        
        //lista3.rellenar("Q", 3);

        // lista2.borrarLista(lista1);
        // lista1.mostrar();
        // System.out.println();
        // lista1.invertir();
        // lista1.mostrar();

        // SalidaPorDefecto.consola("Agregando Lista "+lista1.agregarLista(lista2)+"\n");
        
        // lista1.vaciar();

        // System.out.println(lista1.borrar());

        //System.out.println("Elemento borrado "+lista1.borrar(3));
        // lista1.encontrarValores("A").mostrar();

        //lista1.insertar("F");
        // System.out.println(lista1.cambiar("A", "X", 3));

        // System.out.println(lista1.cambiarLista(lista1,lista2));

        // SalidaPorDefecto.consola("Buscando "+lista1.encontrar("S")+"\n");
        // SalidaPorDefecto.consola("Buscando "+lista1.encontrar("W")+"\n");
        // SalidaPorDefecto.consola("Eliminando "+lista1.borrar("A")+"\n");

        // lista3.insertar("X");
        // lista3.insertar("X");
        // lista3.insertar("X");
        // lista3.insertar("X");
        // lista3.insertar("X");

        // lista1.mostrar();
        // lista2.mostrar();
        // lista3.mostrar();

        // System.out.println(lista1.obtener(0));
        // System.out.println(lista2.obtener(5));
        // System.out.println(lista2.obtener(-2));

        // System.out.println(lista1.esIgual(lista2));
        // System.out.println(lista2.esIgual(lista1));
        // System.out.println(lista1.esIgual(lista3));

        // System.out.println(lista1.cambiar(0, "1"));
        

    }
}