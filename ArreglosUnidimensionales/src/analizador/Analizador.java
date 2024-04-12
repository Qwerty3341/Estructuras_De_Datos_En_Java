package analizador;

import entradasalida.SalidaPorDefecto;
import estructuraslineales.ColaInfoEstatica;
import estructuraslineales.ListaInfoEstatica;
import estructuraslineales.PilaInfoEstatica;

public class Analizador {

    public static boolean validarExpresionAritmetica(String cadena) {
        int LONGITUD_DE_LA_CADENA = cadena.length();
        PilaInfoEstatica pilaDeValidacion = new PilaInfoEstatica(LONGITUD_DE_LA_CADENA);
        PilaInfoEstatica pilaDeIndices = new PilaInfoEstatica(LONGITUD_DE_LA_CADENA);
        ColaInfoEstatica colaDeErrores = new ColaInfoEstatica(LONGITUD_DE_LA_CADENA);

        for (int caracter = 0; caracter < LONGITUD_DE_LA_CADENA; caracter++) {
            switch (cadena.charAt(caracter)) {
                case '(', '[', '{':
                    pilaDeValidacion.poner(cadena.charAt(caracter));
                    pilaDeIndices.poner(caracter);
                    break;
                case ')':
                    if (pilaDeValidacion.vacio() || (char) pilaDeValidacion.quitar() != '(') {
                        return false;
                    } else {
                        pilaDeIndices.quitar();
                    }
                    break;
                case ']':
                    if (pilaDeValidacion.vacio() || (char) pilaDeValidacion.quitar() != '[') {
                        return false;
                    } else {
                        pilaDeIndices.quitar();
                    }
                    break;
                case '}':
                    if (pilaDeValidacion.vacio() || (char) pilaDeValidacion.quitar() != '{') {
                        return false;
                    } else {
                        pilaDeIndices.quitar();
                    }
                    break;
            }
        }
        // Indicar posicion exacta de error mostrar errores en la cola
        ListaInfoEstatica indicesConErrores = new ListaInfoEstatica(cadena.length());
        for (int index = 0; index < cadena.length(); index++) {
            indicesConErrores.insertar(' ');
        }
        // Poner errores en la cola
        while (pilaDeIndices.vacio() != true) {
            Object indiceQuitado = pilaDeIndices.quitar();
            colaDeErrores.poner("Error en indice: " + indiceQuitado);
            indicesConErrores.cambiar((int) indiceQuitado, '^');
        }
        // Poner los indicadores
        for (int index = 0; index < indicesConErrores.cantidad(); index++) {
            SalidaPorDefecto.consola("" + indicesConErrores.obtener(index));
        }
        // Mostrar los errores
        while (colaDeErrores.vacio() == false) {
            SalidaPorDefecto.consola("\n" + colaDeErrores.quitar());
        }
        SalidaPorDefecto.consola("\n");

        return pilaDeValidacion.vacio();
    }

    public static boolean validarArchivoDeJava(ListaInfoEstatica lineasDelArchivo) {
        PilaInfoEstatica pilaDeValidacion = new PilaInfoEstatica(lineasDelArchivo.cantidad());
        PilaInfoEstatica pilaDeIndices = new PilaInfoEstatica(lineasDelArchivo.cantidad());
        // Validar cadena

        for (int linea = 0; linea < lineasDelArchivo.cantidad(); linea++) {
            String lineaActual = (String) lineasDelArchivo.obtener(linea);
            if (lineaActual == null) {
                continue;
            }
            for (int caracter = 0; caracter < lineaActual.length(); caracter++) {
                char caracterActual = lineaActual.charAt(caracter);
                switch (caracterActual) {
                    case '(', '[', '{':
                        pilaDeValidacion.poner(caracterActual);
                        pilaDeIndices.poner(caracter);
                        break;
                    case ')':
                        if (pilaDeValidacion.vacio() || (char) pilaDeValidacion.quitar() != '(') {
                            return false;
                        } else {
                            pilaDeIndices.quitar();
                        }
                        break;
                    case ']':
                        if (pilaDeValidacion.vacio() || (char) pilaDeValidacion.quitar() != '[') {
                            return false;
                        } else {
                            pilaDeIndices.quitar();
                        }
                        break;
                    case '}':
                        if (pilaDeValidacion.vacio() || (char) pilaDeValidacion.quitar() != '{') {
                            return false;
                        } else {
                            pilaDeIndices.quitar();
                        }
                        break;
                }
            }
        }
        // Indicar errores
        if (pilaDeIndices.vacio() == false) {
            PilaInfoEstatica pilaDeErrores = new PilaInfoEstatica(lineasDelArchivo.cantidad());
            while(pilaDeIndices.vacio() == false){
                pilaDeErrores.poner((int)pilaDeIndices.quitar());
            }
            
            for ( int lin = 0; lin < lineasDelArchivo.capacidad() ; lin++){
                Object linea = lineasDelArchivo.obtener(lin);
                if (pilaDeErrores.vacio() == false) {
                    int indice = (int) pilaDeErrores.quitar();
                    char tipoLlave;
                    switch (((String) linea).charAt(indice)) {
                        case '(':
                            tipoLlave = '(';
                            break;
                        case '[':
                            tipoLlave = '[';
                            break;
                        case '{':
                            tipoLlave = '{';
                            break;
                        default:
                            tipoLlave = '?'; // Carácter desconocido
                            break;
                    }
                    SalidaPorDefecto.consola("\n" + linea + "\n");
                    SalidaPorDefecto.consola(indicarError(indice, tipoLlave));
                } else {
                    break;
                }
            }
        }
        return pilaDeValidacion.vacio();
    }

    private static String indicarError(int rango, char tipoLlave){
        String error = "";
        for (int index = 0; index < rango; index++) {
            error+=" ";
        }
        error+="^ Falta cerrar "+tipoLlave;
        return error;
    }
}