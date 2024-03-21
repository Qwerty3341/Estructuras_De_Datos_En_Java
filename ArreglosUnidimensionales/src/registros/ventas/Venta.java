package registros.ventas;

import entradasalida.SalidaPorDefecto;
import estructuraslineales.ListaInfoEstatica;

public class Venta {
    
    protected String folio;
    protected String fecha;
    protected Vendedor cajero;
    protected Cliente cliente;

    protected ListaInfoEstatica articulos;//arreglo de productos
    protected ListaInfoEstatica cantidad;//cuantos de cada articulo
    
    protected double total;

    public Venta(String folio, String fecha, Vendedor cajero, Cliente cliente, int cantMaximaArticulos){

        this.folio=folio;
        this.fecha=fecha;
        this.cajero=cajero;
        this.cliente=cliente;
        articulos = new ListaInfoEstatica(cantMaximaArticulos);
        cantidad = new ListaInfoEstatica(cantMaximaArticulos);
    }

    public boolean agregarProducto(Producto articulo, int cant){
        /*int resultadoB = (Integer) articulos.encontrar(articulo);
        if(resultadoB>=0){//ya existe
        }else{//no existe
        }*/
        
        int retornoArt = (int) articulos.insertar(articulo);
        if (retornoArt<0) {//hubo error
            return false;
        }
        int retornoCant = (int) cantidad.insertar(cant);
        if (retornoCant<0) {//hubo error
            return false;
        }//si llega hasta aca quiere decir que no hubo error
        return true;
    }

    public void calcularTotal(){
        double totalTemp = 0.0;
        for (int consecutivoArticulo = 0; consecutivoArticulo < articulos.cantidad() ; consecutivoArticulo++) {
            //recorrer todos los productos
            Producto articuloTemp=(Producto)articulos.obtener(consecutivoArticulo);
            int cantidadTemp = (int) cantidad.obtener(consecutivoArticulo);
            double subTotal = articuloTemp.getPrecio()*cantidadTemp;
            totalTemp = totalTemp + subTotal;
        }
        total = totalTemp;//es el atributo de la clase
    }

    public void mostrarNota(){
        SalidaPorDefecto.consola("Nota de venta\n");

        SalidaPorDefecto.consola("\tFolio: "+folio+"\n");
        SalidaPorDefecto.consola("\tVendedor: "+cajero.nombre+"\n");
        SalidaPorDefecto.consola("\tCliente: "+cliente.nombre+"\n");
        SalidaPorDefecto.consola("\tFecha: "+fecha+"\n");
        SalidaPorDefecto.consola("\n");

        //detalle
        SalidaPorDefecto.consola("Cons.\tProducto\tPrecio\tCantidad\tSubtotal\n");
        for (int consecutivoArticulo = 0; consecutivoArticulo < articulos.cantidad(); consecutivoArticulo++) {
            Producto articuloTemp = (Producto) articulos.obtener(consecutivoArticulo);
            int cantidadTemp = (int) cantidad.obtener(consecutivoArticulo);
            SalidaPorDefecto.consola(""+consecutivoArticulo+1+"\t");
            SalidaPorDefecto.consola(articuloTemp.getDescripcion()+"\t");
            SalidaPorDefecto.consola("\t"+articuloTemp.getPrecio()+"\t");
            SalidaPorDefecto.consola(cantidadTemp+"\t");
            SalidaPorDefecto.consola("\t"+articuloTemp.getPrecio()*cantidadTemp+"\t");
            SalidaPorDefecto.consola("\n");
        }
        //Pie de p.
        SalidaPorDefecto.consola("\tTotal "+total+"\n");
    }

}