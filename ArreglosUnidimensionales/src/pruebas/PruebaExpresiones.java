package pruebas;

import entradasalida.SalidaPorDefecto;
import utilerias.matematicas.ExpresionesAritmeticas;

public class PruebaExpresiones {
    public static void main(String[] args) {
        SalidaPorDefecto.consola("Evaluando: abcd-*zy^/+: " + ExpresionesAritmeticas.evaluarPostFija("2352-*12^/+")+"\n");
        SalidaPorDefecto.consola("Evaluando :" + ExpresionesAritmeticas.evaluarPrefija("+2/*3-52^12")+"\n");
    }
}
