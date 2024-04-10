package compilador;

import entradasalida.SalidaPorDefecto;
import estructuraslineales.ColaInfoEstatica;
import estructuraslineales.PilaInfoEstatica;

public class Compilador {
    
    public static boolean validarExpresionAritmetica(String cadena) {
        PilaInfoEstatica pilaDeValidacion = new PilaInfoEstatica(cadena.length());
        PilaInfoEstatica pilaDeIndices = new PilaInfoEstatica(cadena.length());
        ColaInfoEstatica colaDeErrores = new ColaInfoEstatica(cadena.length());

        for (int caracter = 0; caracter < cadena.length(); caracter++) {
            if (cadena.charAt(caracter) == '(' || cadena.charAt(caracter) == '[' || cadena.charAt(caracter) == '{') {
                pilaDeValidacion.poner(cadena.charAt(caracter));
            } else {
                if (cadena.charAt(caracter) == ')') {
                    if ((char) pilaDeValidacion.quitar() != '(') {
                        return false;
                    }
                } else {
                    if (cadena.charAt(caracter) == ']') {
                        if ((char) pilaDeValidacion.quitar() != '[') {
                            return false;
                        }
                    } else {
                        if (cadena.charAt(caracter) == '}') {
                            if ((char) pilaDeValidacion.quitar() != '{') {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        //Mostrando los errores en la cola
        // while (pilaDeIndices.vacio() != true) {
        //     colaDeErrores.poner("Error en indice: "+pilaDeIndices.quitar().toString());
        // }
        // colaDeErrores.mostrar();
        // SalidaPorDefecto.consola("\n");
        return pilaDeValidacion.vacio();
    }
}