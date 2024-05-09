package pruebas;

import entradasalida.SalidaPorDefecto;
import estructurasnolineales.Monticulo;
import utilerias.comunes.TipoDeOrdenamiento;

public class PruebaMonticulo {
    public static void main(String[] args) {
        Monticulo monticuloDEC = new Monticulo(TipoDeOrdenamiento.DEC);
        Monticulo monticuloINC = new Monticulo(TipoDeOrdenamiento.INC);

        //Insertando en los DEC
        SalidaPorDefecto.consola("\n---------------------------------------\n");
        SalidaPorDefecto.consola("Insertando en los monticulos decrementales\n");
        monticuloDEC.insertar(20);
        monticuloDEC.insertar(18);
        monticuloDEC.insertar(9);
        monticuloDEC.insertar(8);
        monticuloDEC.insertar(10);
        monticuloDEC.insertar(12);
        monticuloDEC.innorden();
        SalidaPorDefecto.consola("\nEliminando monticulo\n");
        monticuloDEC.eliminar();
        monticuloDEC.innorden();

        //Insertando en los INC
        SalidaPorDefecto.consola("\n---------------------------------------\n");
        SalidaPorDefecto.consola("Insertando en los monticulos incrementales\n");
        monticuloINC.insertar(20);
        monticuloINC.insertar(18);
        monticuloINC.insertar(8);
        monticuloINC.insertar(10);
        monticuloINC.insertar(12);
        monticuloINC.insertar(9);
        monticuloINC.innorden();
        SalidaPorDefecto.consola("\nEliminando monticulo\n");
        monticuloINC.eliminar();
        monticuloINC.innorden();
    }
}
