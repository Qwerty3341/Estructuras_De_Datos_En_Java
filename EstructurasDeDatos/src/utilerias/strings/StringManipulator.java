package utilerias.strings;

import estructuraslineales.ListaInfoEstatica;

public final class StringManipulator {

    public static String borrarEspaciosEnBlanco(String unaString) {
        String cadenaSinEspaciosEnBlanco = "";
        for (int caracter = 0; caracter < unaString.length(); caracter++) {
            char caracterActual = unaString.charAt(caracter);
            if (caracterActual != ' ') {
                cadenaSinEspaciosEnBlanco += caracterActual;
            }
        }
        return cadenaSinEspaciosEnBlanco;
    }

    /*Este metodo tiene como objetivo hacer lo mismo que el metodo .split de java
     * (al no poder usar directamente el metodo .split hago el mio)*/
    public static ListaInfoEstatica dividir(String unaString, char charDivisor) {
        ListaInfoEstatica cadenaDividida = new ListaInfoEstatica(unaString.length());
        String palabraActual = "";

        for (int caracter = 0; caracter < unaString.length(); caracter++) {
            char caracterActual = unaString.charAt(caracter);

            if (caracterActual == charDivisor) {
                if (palabraActual.length() > 0) {
                    cadenaDividida.insertar(palabraActual);
                    palabraActual = ""; // Reiniciamos la palabra actual
                }
            } else {
                palabraActual += caracterActual;
            }
        }

        // Añadir la última palabra
        if (palabraActual.length() > 0) {
            cadenaDividida.insertar(palabraActual);
        }

        return cadenaDividida;
    }
}