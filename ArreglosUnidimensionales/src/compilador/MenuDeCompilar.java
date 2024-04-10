package compilador;

import entradasalida.EntradaPorDefecto;
import entradasalida.SalidaPorDefecto;
import entradasalida.archivos.ArchivoTexto;
import estructuraslineales.ListaInfoEstatica;

public class MenuDeCompilar {

    private static int opcion;

    public static void ejecutarMenu(){
        while (opcion != 3) {
            Menu();
        }
    }

    private static void Menu(){
        opcion = EntradaPorDefecto.consolaInt();
            SalidaPorDefecto.consola("""
                Entrada para el programa:
                1 -> Programa de java
                2 -> Expresion aritmetica
                3 -> Salir
                """);
        switch (opcion) {
            case 1:
                ListaInfoEstatica archivo = ArchivoTexto.leer("Ejemplo.txt");
                SalidaPorDefecto.consola("Código:\n");
                archivo.mostrar();
                break;
            case 2:
                SalidaPorDefecto.consola("Coloca una expresión aritmética:\n");
                String expresion = EntradaPorDefecto.consolaCadenas();
                var resultado = Compilador.validarExpresionAritmetica(expresion);
                if (resultado) SalidaPorDefecto.consola("Balanceada");
                else SalidaPorDefecto.consola("Desbalanceada");
                break;
            default:
                SalidaPorDefecto.consola("Opción no válida");
                break;
        }   
    }
    
}