package analizador;

import entradasalida.EntradaPorDefecto;
import entradasalida.SalidaPorDefecto;
import entradasalida.archivos.ArchivoTexto;
import estructuraslineales.ListaInfoEstatica;

public class MenuDeAnalizar {

    private static int opcion;

    public static void ejecutarMenu() {
        while (opcion != 3) {
            Menu();
        }
    }

    private static void Menu() {
        SalidaPorDefecto.consola("""
                \n\nEntrada para el programa:
                1 -> Programa de java
                2 -> Expresion aritmetica
                3 -> Salir
                """);

        opcion = EntradaPorDefecto.consolaInt();
        switch (opcion) {
            case 1:
                String nombreDeArchivo = EntradaPorDefecto.consolaCadenas();
                ListaInfoEstatica archivo = ArchivoTexto.leer(nombreDeArchivo);
                SalidaPorDefecto.consola("Código:\n");
                var cadena = Analizador.validarArchivoDeJava(archivo);
                if (cadena == true) SalidaPorDefecto.consola("Balanceado");
                else SalidaPorDefecto.consola("Desbalanceado");
                break;
            case 2:
                SalidaPorDefecto.consola("Coloca una expresión aritmética:\n");
                String expresion = EntradaPorDefecto.consolaCadenas();
                var resultado = Analizador.validarExpresionAritmetica(expresion);
                if (resultado) SalidaPorDefecto.consola("Balanceada");
                else SalidaPorDefecto.consola("Desbalanceada");
                break;
            case 3:
                break;
            default:
                SalidaPorDefecto.consola("Opción no válida");
                break;
        }
    }
}