package pruebas;

import entradasalida.SalidaPorDefecto;
import estructuraslineales.ListaInfoEstatica;
import estructuraslineales.ListaInfoEstaticaNumerica;

public class PruebaListaInfoEstaticaNumerada {
    
    public static void main(String[] args) {
        ListaInfoEstaticaNumerica l1 = new ListaInfoEstaticaNumerica(2);
        ListaInfoEstaticaNumerica l2 = new ListaInfoEstaticaNumerica(2);
        //ListaInfoEstaticaNumerica l3 = new ListaInfoEstaticaNumerica(2);
        //ListaInfoEstatica l4 = new `ListaInfoEstatica(2);

        // l1.insertar(-3);
        // l1.insertar(5);
     
        // SalidaPorDefecto.consola("Producto= "+l1.productoEscalar(l2)); 
        // l1.insertar(1);
        // l1.insertar(2);
        // l1.insertar(3);
        // l2.insertar(4);
        // l2.insertar(5);
        // l2.insertar(6);

        //Pruebas

        //l1.sumar(l2);
        // l1.multiplicar(l2);
        
        //l1.sumarEscalar(2);
        //l1.porEscalar(5);

        //l1.aplicarPotencia(2);
        // l1.insertar(3);
        // l1.insertar(4);
        // SalidaPorDefecto.consola("Norma=" + l1.norma());
        //SalidaPorDefecto.consola("Norma euclidiana= "+ l1.normaEuclidiana(l2));

        // l1.insertar(0);
        // l1.insertar(0);
        // l2.insertar(1);
        // l2.insertar(1);
        // l3.insertar(1);
        // l3.insertar(1);
        // l4.insertar(l2);
        // l4.insertar(l3);
        // l1.sumarListaEstatica(l4);
        // l1.mostrar();
        
        // l1.insertar(9);
        // l1.insertar(9);
        // l2.insertar(0);
        // l2.insertar(1);
        // SalidaPorDefecto.consola("suma de indices= "+l1.sumarIndices(l2));

        // l1.insertar(1);
        // l1.insertar(5);
        // l1.insertar(-2);
        // l2.insertar(2);
        // l2.insertar(0);
        // l2.insertar(1);
        // SalidaPorDefecto.consola("Es ortogonal? "+l1.esOrtogonal(l2));

        l1.insertar(3);
        l1.insertar(-1);
        l2.insertar(-9);
        l2.insertar(3);
        SalidaPorDefecto.consola("Son paralelos?= "+l1.esParalelo(l2));
    }

}
