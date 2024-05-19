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
            \n__________________________________________________________________________________________________________
            Elige una opcion:
            1 -> Programa de java
            2 -> Expresion aritmetica
            3 -> Salir
                """);

        opcion = EntradaPorDefecto.consolaInt();
        switch (opcion) {
            case 1:
                SalidaPorDefecto.consola("Coloca el nombre del archivo: ");
                String nombreDeArchivo = EntradaPorDefecto.consolaCadenas();
                ListaInfoEstatica archivo = ArchivoTexto.leer(nombreDeArchivo);
                var resultado1 = Analizador.validarArchivoDeJava(archivo);
                SalidaPorDefecto.consola("\nEstado : ");
                if (resultado1) SalidaPorDefecto.consola("Archivo balanceado correctamente.");
                else SalidaPorDefecto.consola("El archivo está desbalanceado.");
                
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