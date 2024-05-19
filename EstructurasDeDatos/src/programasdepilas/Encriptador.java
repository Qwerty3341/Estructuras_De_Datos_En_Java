package programasdepilas;

import entradasalida.EntradaPorDefecto;
import entradasalida.SalidaPorDefecto;
import estructuraslineales.PilaInfoEstatica;

public class Encriptador {
    
    public static String encriptar(String mensaje, int numDeAgrupaciones) {
        int[] indices = new int[numDeAgrupaciones];
        int[] tamaniosDeParentesis = new int[numDeAgrupaciones];
        StringBuilder mensajeEncriptado = new StringBuilder();
        char[] caracteres = mensaje.toCharArray();
        // Pedir los índices que vamos a cambiar
        for (int iter = 0; iter < numDeAgrupaciones; iter++) {
            SalidaPorDefecto.consola("Coloca el indice #" + (iter + 1) + " del mensaje: ");
            int indice = EntradaPorDefecto.consolaInt();
            indices[iter] = indice-1;
        }
        // Pedir el tamaño de los paréntesis
        for (int iter = 0; iter < numDeAgrupaciones; iter++) {
            SalidaPorDefecto.consola("Coloca el tamaño del #" + (iter + 1) + " paréntesis: ");
            int tam = EntradaPorDefecto.consolaInt();
            tamaniosDeParentesis[iter] = tam;
        }
        // Invertir y poner paréntesis
        int contador = 0;
        for (int carac = 0; carac < mensaje.length(); carac++) {
            if (contador < numDeAgrupaciones && carac == indices[contador]) {
                mensajeEncriptado.append("(");
                // Agregar caracteres al revés dentro del paréntesis
                for (int num = tamaniosDeParentesis[contador] - 1; num >= 0; num--) {
                    int indiceCaracter = carac + num;
                    if (indiceCaracter < caracteres.length) {
                        mensajeEncriptado.append(caracteres[indiceCaracter]);
                        caracteres[indiceCaracter] = '\0';
                    }
                }
                mensajeEncriptado.append(")");
                contador = contador + 1;
            } else {
                mensajeEncriptado.append(caracteres[carac]);// Agregar caracteres normales al mensaje encriptado
            }
        }
        return mensajeEncriptado.toString();
    }
}