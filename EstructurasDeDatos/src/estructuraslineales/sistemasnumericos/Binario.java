package estructuraslineales.sistemasnumericos;

public final class Binario {

    public static boolean verificarNumeroBinario(String numero, int indice) {
        if (indice == numero.length()) {// Aqui es cuando ya revisamos todos los numeros
            return true;
        }
        char caracterActual = numero.charAt(indice);// Obtengo el caracter actual
        if (caracterActual != '0' && caracterActual != '1') {
            return false;// Con encontrar algo diferente de 1 o 0 ya no es binario
        }
        return verificarNumeroBinario(numero, indice + 1);// Incremento el indice para obtener el siguiente caracter
    }

    public static String convertirABinario(int numeroDecimal, String resultado) {
        if (numeroDecimal == 0) {
            if (resultado == "") {
                return "0";
            }else{
                return resultado;
            }
        }
        int digitoBinario = numeroDecimal % 2;//Calculamos el dijito binario dividiendo por dos y obteniendo su residuo
        return convertirABinario(numeroDecimal / 2, digitoBinario+resultado);
    }
}