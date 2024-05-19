package pruebas;

import registros.ventas.Cliente;
import registros.ventas.GestorSucursal2;
import registros.ventas.Producto;
import registros.ventas.Vendedor;
import registros.ventas.Venta2;

public class PruebaVentas2 {
    public static void main(String[] args) {
        GestorSucursal2 sucursal1 = new GestorSucursal2("EMP SA");
        Vendedor vendedor1 = new Vendedor(1, "Jelipe", "01/01/00", 'M');
        Cliente cliente1 = new Cliente("BEDF01010100F87", "Pedro", 34);
        Venta2 venta1 = new Venta2("001", "06/02/2024", vendedor1, cliente1);
        Producto producto1 = new Producto("111","Lapiz",200,15.0);
        Producto producto2 = new Producto("112","Libreta",200,20.0);
        Producto producto3 = new Producto("113","Goma",200,40.0);

        venta1.agregarProducto(producto1,2);
        venta1.agregarProducto(producto2,5);
        venta1.agregarProducto(producto3,4);

        sucursal1.agregarVenta(venta1);
        sucursal1.mostrarVentas();
    }
}