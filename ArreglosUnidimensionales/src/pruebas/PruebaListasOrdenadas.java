package pruebas;

import entradasalida.SalidaPorDefecto;
import estructuraslineales.ListaInfoEstatica;
import estructuraslineales.ListaInfoEstaticaOrdenada;
import utilerias.comparador.ComparadorDeObjetos;
import utilerias.comunes.TipoDeOrdenamiento;

public class PruebaListasOrdenadas {

    public static void main(String[] args) {
        // var lista1 = new ListaInfoEstaticaOrdenada(5, TipoDeOrdenamiento.INC);
        // var lista2 = new ListaInfoEstaticaOrdenada(3,TipoDeOrdenamiento.INC);
        var lista1 = new ListaInfoEstatica(3);
        var lista2 = new ListaInfoEstatica(3);
        
        lista1.insertar("Hola"); 
        lista1.insertar("A");
        lista1.insertar("1");
        SalidaPorDefecto.consola(lista1.borrar()+"");
        lista1.mostrar();
        
        
        //Prueba del comparador
        // lista1.insertar("Hola"); 
        // lista1.insertar("A");
        // lista1.insertar("1");

        // lista2.insertar(1);
        // lista2.insertar("B");
        // lista2.insertar("1");
        // SalidaPorDefecto.consola(""+ComparadorDeObjetos.comparar(lista1.obtener(1), lista2.obtener(1)));

        //Prueba del metodo insertar y recorrerelementos
        // lista1.insertar(99);
        // lista1.insertar(9);
        // lista1.insertar(12);
        // lista1.insertar(0);
        // lista1.mostrar();
        
        // lista1.insertar(2);
        // lista1.insertar(66);
        // lista1.insertar(1);
        
       
    }
    
}