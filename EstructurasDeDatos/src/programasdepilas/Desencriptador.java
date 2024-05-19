package programasdepilas;

public class Desencriptador {

    public static String desencriptar(String mensajeEncriptado) {
        StringBuilder mensajeDesencriptado = new StringBuilder();
        char[] caracteres = mensajeEncriptado.toCharArray();
        for (int index = 0; index < caracteres.length; index++) {
            if (caracteres[index] != '(') {
                mensajeDesencriptado.append(caracteres[index]);
            } else { // Buscamos el siguiente ')'
                int contador = index + 1;
                StringBuilder caracteresEncerradosTemp = new StringBuilder();
                while (contador < caracteres.length && caracteres[contador] != ')') {
                    caracteresEncerradosTemp.append(caracteres[contador]);
                    contador++;
                }
                char[] caracteresEncerradosArray = caracteresEncerradosTemp.toString().toCharArray();
                for (int i = caracteresEncerradosArray.length - 1; i >= 0; i--) {//Iteramos al reves
                    mensajeDesencriptado.append(caracteresEncerradosArray[i]);
                }
                index = contador;
            }
        }
        return mensajeDesencriptado.toString();
    }
    
    
}
