package registros.cosechas;

import entradasalida.SalidaPorDefecto;
import estructuraslineales.ListaInfoEstatica;
import estructurasnolineales.MatrizInfo3;

public class Cosechas {
    protected MatrizInfo3 toneladas;
    protected ListaInfoEstatica campesinos;
    protected ListaInfoEstatica productos;
    protected ListaInfoEstatica anios;


    public Cosechas(int numDeCampesinos, int numProductos, int numDeAnios) {
        toneladas = new MatrizInfo3(numDeCampesinos, numProductos, numDeAnios);
        campesinos = new ListaInfoEstatica(numDeCampesinos);
        productos = new ListaInfoEstatica(numProductos);
        anios = new ListaInfoEstatica(numDeAnios);
        toneladas.rellenar(0.0);
    }

    public boolean agregarCampesino(Campesino camp){
        int indiceCampesino = (int) campesinos.encontrar(camp);
        if(indiceCampesino>=0){//Ya existe
            return false;
        }else{
            int retornoAgregado = (int) campesinos.insertar(camp);
            if (retornoAgregado >= 0) {
                return true;
            }
            else{
                return false;
            }
        }
    }

    public boolean agregarProducto(String producto){
        int indiceProducto = (int) productos.encontrar(producto);
        if(indiceProducto >= 0){//Ya existe
            return false;
        }else{
            int retornoAgregado = (int) productos.insertar(producto);
            if (retornoAgregado >= 0) {
                return true;
            }
            else{
                return false;
            }
        }
    }

    public boolean agregarAnio(int anio){
        int indiceAnio = (int) anios.encontrar(anio);
        if(indiceAnio >= 0){//Ya existe
            return false;
        }else{
            int retornoAgregado = (int) anios.insertar(anio);
            if (retornoAgregado >= 0) {
                return true;
            }
            else{
                return false;
            }
        }
    }

    public boolean agregarToneladas(String rfc, String producto, int anio, double tonProd){
        ListaInfoEstatica indices = indicesCelda(rfc, producto, anio);
        if (indices != null) {//Son validos
            return toneladas.cambiar(
                (int) indices.obtener(0), 
                (int) indices.obtener(1),
                (int) indices.obtener(2), 
                tonProd
            );
        }else{
            return false;
        }
    }

    private ListaInfoEstatica indicesCelda(String rfc, String producto, int anio){
        int indiceCampesino = (int) campesinos.encontrar(rfc);
        int indiceProducto = (int) productos.encontrar(producto);
        int indiceAnio = (int) anios.encontrar(anio);

        if (indiceCampesino>=0 && indiceProducto >= 0 && indiceAnio >=0) {
            ListaInfoEstatica indices = new ListaInfoEstatica(3);
            indices.insertar(indiceCampesino);
            indices.insertar(indiceProducto);
            indices.insertar(indiceAnio);
            return indices;

        }else{
            return null;
        }

    }

    public void mostrarCosechas(){

        SalidaPorDefecto.consola("Datos de cosechas\n\n");
        SalidaPorDefecto.consola("rfcs de campesinos:\n");
        campesinos.mostrar();
        SalidaPorDefecto.consola("\nProductos:\n");
        productos.mostrar();
        SalidaPorDefecto.consola("\nAnios:\n");
        anios.mostrar();
        SalidaPorDefecto.consola("Toneladas producidas:\n");
        toneladas.mostrarXColumna();
    }
    /*
    Se desea obtener la cantidad de toneladas que Jelipe, Juan, Antonio
    obtuvieron de frijol, maiz y ajo durante 2000, 2023 y 2003
    */

    public ListaInfoEstatica toneladasCampesinos(ListaInfoEstatica campesinosPedidos, ListaInfoEstatica productosPedidos, ListaInfoEstatica aniosPedidos){
        //recorrer cada posicion del arreglo de campesinos pedidos y calcular su produccion de manera individual
        ListaInfoEstatica listaToneladasCampesinos = new ListaInfoEstatica(campesinosPedidos.cantidad());
        for (int cadaCampesino = 0; cadaCampesino < campesinosPedidos.cantidad(); cadaCampesino++) {
            String rfcTemporal = (String) campesinosPedidos.obtener(cadaCampesino);
            Double toneladasDelCampesinoTemporal = toneladasXCampesino(rfcTemporal, productosPedidos, aniosPedidos);
            listaToneladasCampesinos.insertar(toneladasDelCampesinoTemporal);
        }
        return listaToneladasCampesinos;
    }

    public Double toneladasXCampesino(String rfc, ListaInfoEstatica productosPedidos, ListaInfoEstatica aniosPedidos){
       //Tengo que recorres el arreglo de productos que fueron pedidos 
       double toneladasAcumuladas = 0.0;
        for (int cadaProducto = 0; cadaProducto < productosPedidos.cantidad(); cadaProducto++) {
            String productoTemporal = (String) productosPedidos.obtener(cadaProducto);
            //Voy a suponer que solo tengo que sacar los datos de toneladas de un solo producto por ejemplo frijol

            for (int cadaAnio = 0; cadaAnio < aniosPedidos.cantidad(); cadaAnio++) {
                int anioTemporal = (int) aniosPedidos.obtener(cadaAnio);
                //Ahora tengo que obtener la cantidad de toneladas de un anio nadamas de un producto nada mas, del rfc que se me pidio
                //primero obtenemos los indices del cubo para podee sacar del cubo las toneladas 
                ListaInfoEstatica indicesCeldaPedida = indicesCelda(rfc, productoTemporal, anioTemporal);
                if (indicesCeldaPedida != null) {
                    Double toneladasCelda = (Double) toneladas.obtener((int) indicesCeldaPedida.obtener(0), (int) indicesCeldaPedida.obtener(1), (int) indicesCeldaPedida.obtener(2));
                    if (toneladasCelda != null) {
                        toneladasAcumuladas = toneladasAcumuladas + toneladasCelda;
                    }
                }
            }
        }   
        return toneladasAcumuladas;
    }
}