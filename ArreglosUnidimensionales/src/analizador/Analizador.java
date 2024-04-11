package analizador;

import entradasalida.SalidaPorDefecto;
import estructuraslineales.ColaInfoEstatica;
import estructuraslineales.ListaInfoEstatica;
import estructuraslineales.PilaInfoEstatica;

public class Analizador {

    public static boolean validarExpresionAritmetica(String cadena) {
        PilaInfoEstatica pilaDeValidacion = new PilaInfoEstatica(cadena.length());
        PilaInfoEstatica pilaDeIndices = new PilaInfoEstatica(cadena.length());
        ColaInfoEstatica colaDeErrores = new ColaInfoEstatica(cadena.length());

        for (int caracter = 0; caracter < cadena.length(); caracter++) {
            if (cadena.charAt(caracter) == '(' || cadena.charAt(caracter) == '[' || cadena.charAt(caracter) == '{') {
                pilaDeValidacion.poner(cadena.charAt(caracter));
                pilaDeIndices.poner(caracter);
            } else {
                if (cadena.charAt(caracter) == ')') {
                    if ((char) pilaDeValidacion.quitar() != '(') {
                        return false;
                    } else {
                        pilaDeIndices.quitar();
                    }
                } else {
                    if (cadena.charAt(caracter) == ']') {
                        if ((char) pilaDeValidacion.quitar() != '[') {
                            return false;
                        } else {
                            pilaDeIndices.quitar();
                        }
                    } else {
                        if (cadena.charAt(caracter) == '}') {
                            if ((char) pilaDeValidacion.quitar() != '{') {
                                return false;
                            } else {
                                pilaDeIndices.quitar();
                            }
                        }
                    }
                }
            }
        }
        // Indicar posicion exacta de error mostrar errores en la cola
        ListaInfoEstatica indicesConErrores = new ListaInfoEstatica(cadena.length());
        for (int index = 0; index < cadena.length(); index++) {
            indicesConErrores.insertar(' ');
        }
        //Poner errores en la cola
        while (pilaDeIndices.vacio() != true) {
            Object indiceQuitado = pilaDeIndices.quitar();
            colaDeErrores.poner("Error en indice: " + indiceQuitado);
            indicesConErrores.cambiar((int) indiceQuitado, '!');
        }
        //Poner los indicadores
        for (int index = 0 ; index < indicesConErrores.cantidad() ; index++) {
            SalidaPorDefecto.consola("" + indicesConErrores.obtener(index));
        }

        //Mostrar los errores
        while (colaDeErrores.vacio() == false) {
            SalidaPorDefecto.consola("\n" + colaDeErrores.quitar());
        }
        SalidaPorDefecto.consola("\n");
        return pilaDeValidacion.vacio();
    }
}