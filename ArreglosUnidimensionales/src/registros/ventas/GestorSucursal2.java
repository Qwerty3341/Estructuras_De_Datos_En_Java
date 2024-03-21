package registros.ventas;


import entradasalida.SalidaPorDefecto;
import estructuraslineales.ListaInfoDinamica;

public class GestorSucursal2 {
    
    protected ListaInfoDinamica ventas;
    protected String nombre;

    public GestorSucursal2(String nombre){
        this.nombre=nombre;
        ventas = new ListaInfoDinamica();
    }

    public boolean agregarVenta(Venta2 ventaParam){
        int retornoVenta = (int) ventas.insertar(ventaParam);
        if(retornoVenta>=0){
            return true;
        }else{
            return false;
        }
    }

    public void mostrarVentas(){
        ventas.iniciaIterador();
        while (ventas.IteradorNulo() == false) {
            Venta2 ventaTemp = (Venta2) ventas.obtenDato();
            ventaTemp.mostrarNota();
            SalidaPorDefecto.consola("\n");
        }
    }
}
