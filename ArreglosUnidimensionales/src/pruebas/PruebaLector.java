package pruebas;

import java.io.IOException;
import entradasalida.SalidaPorDefecto;
import entradasalida.archivos.LectorDeArchivos;

public class PruebaLector {
    public static void main(String[] args) throws IOException {
        LectorDeArchivos.leer();
        SalidaPorDefecto.consola("\n\n\n");
        LectorDeArchivos.buscarID(2440);
    }
}