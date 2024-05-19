package pruebas;

import java.io.IOException;
import entradasalida.SalidaPorDefecto;
import entradasalida.archivos.LectorDeArchivos;
import estructurasnolineales.ArbolBBIndices;

public class PruebaLector {
    public static void main(String[] args) throws IOException {
        //Leer archivos
        LectorDeArchivos.leer();

        //Buscar un id
        // SalidaPorDefecto.consola("Buscando el id 2458 \n");
        // LectorDeArchivos.buscarID(2458);

        //Guardando registros
        SalidaPorDefecto.consola("\n______________________________________\n");
        SalidaPorDefecto.consola("Guardando registros en un arbol\n");
        ArbolBBIndices arbol_2 = LectorDeArchivos.guardarRegistros();
        arbol_2.inorden();

        //Buscando indices
        SalidaPorDefecto.consola("\n______________________________________\n");
        SalidaPorDefecto.consola("Buscando el registro 2437\n");
        arbol_2.buscarRegistro(2437);

        //Insertando
        SalidaPorDefecto.consola("\n______________________________________\n");

        arbol_2.insertarRegistro(33333,"10/10/08 23:59:44.678340000","direct",121,898,4,7777.4,555);
        arbol_2.inorden();
        SalidaPorDefecto.consola("\n\tViendo el nuevo registro\n");
        arbol_2.buscarRegistro(33333);

        //Eliminar
        SalidaPorDefecto.consola("\n______________________________________\n");
        arbol_2.eliminar(33333);
        arbol_2.eliminar(33333);
        arbol_2.inorden();
    }
}