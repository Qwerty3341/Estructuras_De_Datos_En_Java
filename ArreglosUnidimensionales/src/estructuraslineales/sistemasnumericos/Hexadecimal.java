package estructuraslineales.sistemasnumericos;

public final class Hexadecimal {

    public static String convertirAHexadecimal(int numeroDecimal, String resultado) {
        if (numeroDecimal == 0) {
            if (resultado == "") {
                return "0";
            }else{
                return resultado;
            }
        }

        int digitoHexadecimal = numeroDecimal % 16;//Calculamos el hexadecimal obteniendo el residuo
        String caracterHexadecimal; 

        switch (digitoHexadecimal) {//Dependiendo del hexadecimal obtenido le asignamos el valor correspondiente
            case 10:
                caracterHexadecimal = "A";
                break;
            case 11:
                caracterHexadecimal = "B";
                break;
            case 12:
                caracterHexadecimal = "C";
                break;
            case 13:
                caracterHexadecimal = "D";
                break;
            case 14:
                caracterHexadecimal = "E";
                break;
            case 15:
                caracterHexadecimal = "F";
                break;
            default:
                caracterHexadecimal = digitoHexadecimal + "";
                break;
        }
        return convertirAHexadecimal(numeroDecimal / 16, caracterHexadecimal + resultado);
    }
}