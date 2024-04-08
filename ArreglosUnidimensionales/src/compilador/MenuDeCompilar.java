package compilador;

import entradasalida.SalidaPorDefecto;

public class MenuDeCompilar {

    public static void mostrarOpciones(){
        SalidaPorDefecto.consola("""
                Entrada para el programa:
                1 -> Expresion aritmetica
                2 -> Programa de java
                """);
    }

}