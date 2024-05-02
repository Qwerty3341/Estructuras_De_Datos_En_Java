package pruebas;

import entradasalida.SalidaPorDefecto;
import estructurasnolineales.ArbolDeExpresionesA;

public class PruebaAEAMetodosRecursivos {
    public static void main(String[] args) {
        //Haciendo el arbol
        ArbolDeExpresionesA arbolEA = new ArbolDeExpresionesA();
        arbolEA.nuevoArbol();
        arbolEA.innorden();

        // Extrallendo variables y asignando valores
        SalidaPorDefecto.consola("\n_____________________________________\n");
        SalidaPorDefecto.consola("Asignando valores a las variables\n");
        var variables = arbolEA.asignarValoresALasVariables();
        variables.mostrar();
        //Extrallendo operadores
        SalidaPorDefecto.consola("\n_____________________________________\n");
        SalidaPorDefecto.consola("Extrallendo los operadores\n");
        var operadores = arbolEA.extraerOperadores();
        operadores.mostrar();

    }
}
