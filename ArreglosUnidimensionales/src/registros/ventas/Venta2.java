package registros.ventas;

import entradasalida.SalidaPorDefecto;
import estructuraslineales.ListaInfoDinamica;

public class Venta2 {
    protected String folio;
    protected String fecha;
    protected Vendedor cajero;
    protected Cliente cliente;

    protected ListaInfoDinamica articulos; // Lista de productos
    protected ListaInfoDinamica cantidad; // Cuantos de cada artículo

    protected double total;

    public Venta2(String folio, String fecha, Vendedor cajero, Cliente cliente){
        this.folio = folio;
        this.fecha = fecha;
        this.cajero = cajero;
        this.cliente = cliente;
        articulos = new ListaInfoDinamica();
        cantidad = new ListaInfoDinamica();
    }

    public boolean agregarProducto(Producto articulo, int cant){
        // int resultadoB = (Integer) articulos.encontrar(articulo);
        // if( resultadoB >= 0){

        // }else{

        // }


        int retornoArt = articulos.insertar(articulo);
        if(retornoArt<0){//hubo error
            return false;
        }
        int retornoCant = cantidad.insertar(cant);
        if(retornoCant<0){//hubo error
            return false;
        }

        // si llega hasta aca, quiere decir que no hubo error
        return true;

    }

    public void calcularTotal(){
        double totalTemp = 0.0;

        articulos.iniciaIterador();
        cantidad.iniciaIterador();

        while(articulos.IteradorNulo() == false){
            Producto articuloTemp = (Producto) articulos.obtenDato();
            int cantidadTemp = (int) cantidad.obtenDato();
            double subTotal = articuloTemp.getPrecio()*cantidadTemp;
            totalTemp = totalTemp + subTotal;
        }

        total=totalTemp; //Es el atributo de la clase
    }

    public void mostrarNota(){
        SalidaPorDefecto.consola("Nota de venta: \n");

        //ENCABEZADO
        SalidaPorDefecto.consola("\tFolio: "+folio+"\n");
        SalidaPorDefecto.consola("Vendedor: "+cajero.nombre+"\n");
        SalidaPorDefecto.consola("Cliente: "+ cliente.nombre+"\n");
        SalidaPorDefecto.consola("Fecha: "+ fecha +"\n");
        SalidaPorDefecto.consola("\n");

        //Detalle
        SalidaPorDefecto.consola("Cons.\t Producto \t Precio \t Cantidad \t Subtotal\n");

        articulos.iniciaIterador();
        cantidad.iniciaIterador();
        int consecutivoArticulo = 1;
        while(articulos.IteradorNulo() == false){
            Producto articuloTemp = (Producto)articulos.obtenDato();
            int cantidadTemp = (int) cantidad.obtenDato();
        
            SalidaPorDefecto.consola(""+consecutivoArticulo+++ "\t");
            SalidaPorDefecto.consola("\t"+articuloTemp.getDescripcion()+ "\t");
            SalidaPorDefecto.consola("\t"+articuloTemp.getPrecio()+ "\t");
            SalidaPorDefecto.consola("\t"+cantidadTemp + "\t");
            SalidaPorDefecto.consola("\t"+cantidadTemp * articuloTemp.getPrecio() + "\t");
            SalidaPorDefecto.consola("\n");
        }






            

        calcularTotal();
        //Pie de pagina
        SalidaPorDefecto.consola("Total: "+ total +"\n");

    }
}