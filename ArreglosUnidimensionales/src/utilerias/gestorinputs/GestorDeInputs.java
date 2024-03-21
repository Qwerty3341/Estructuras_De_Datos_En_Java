package utilerias.gestorinputs;

import entradasalida.EntradaPorDefecto;
import entradasalida.SalidaPorDefecto;

public class GestorDeInputs {

    public static String pedirString(){
        SalidaPorDefecto.consola("Coloca una expresion aritmetica:\n");
        var stringDelUsuario = EntradaPorDefecto.consolaCadenas();
        return stringDelUsuario;
    }
}
