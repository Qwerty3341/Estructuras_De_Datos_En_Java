package gestordecampesinos;

import entradasalida.SalidaPorDefecto;
import estructuraslineales.ListaInfoEstatica;

public class Year {
    private ListaInfoEstatica listaDeArrozProducidoEnUnAnio; //Se da por hecho que las cantidades son toneladas
    private ListaInfoEstatica listaDeMeses;//Estas listas son para identificar los meses y los anios
    private ListaInfoEstatica listaDeAnios;
    private ListaInfoEstatica listaDeEstaciones;
    private String nombre;
    
    public Year(String nombre){
        this.nombre = nombre;
        this.listaDeArrozProducidoEnUnAnio = new ListaInfoEstatica(12);
        this.listaDeMeses = new ListaInfoEstatica(12);
        this.inicializarMeses();
        this.listaDeAnios = new ListaInfoEstatica(4);
        this.inicializarAnios();
        this.listaDeEstaciones = new ListaInfoEstatica(4);
        this.inicializarEstaciones();
    }

    private boolean ponerTonelada(double tonelada, int indice){
        if (indice < 0 || indice >= listaDeArrozProducidoEnUnAnio.capacidad()) {
            return false;
        }
        if(listaDeArrozProducidoEnUnAnio.obtenerElemento(indice) != null){
            SalidaPorDefecto.consola("Este indice ya esta ocupado");
            return false;
        }else{
            this.listaDeArrozProducidoEnUnAnio.insertar(tonelada);
            return true;
        }
    }

    public void ponerTodasLasToneladas(double tonelada1, double tonelada2, double tonelada3, double tonelada4, double tonelada5, double tonelada6, double tonelada7, double tonelada8, double tonelada9, double tonelada10, double tonelada11, double tonelada12){
        this.ponerTonelada(tonelada1, 0);
        this.ponerTonelada(tonelada2, 1);
        this.ponerTonelada(tonelada3, 2);
        this.ponerTonelada(tonelada4, 3);
        this.ponerTonelada(tonelada5, 4);
        this.ponerTonelada(tonelada6, 5);
        this.ponerTonelada(tonelada7, 6);
        this.ponerTonelada(tonelada8, 7);
        this.ponerTonelada(tonelada9, 8);
        this.ponerTonelada(tonelada10, 9);
        this.ponerTonelada(tonelada11, 10);
        this.ponerTonelada(tonelada12, 11);
    }

    private void inicializarMeses(){
        listaDeMeses.insertar("Enero");
        listaDeMeses.insertar("Febrero");
        listaDeMeses.insertar("Marzo");
        listaDeMeses.insertar("Abril");
        listaDeMeses.insertar("Mayo");
        listaDeMeses.insertar("Junio");
        listaDeMeses.insertar("Julio");
        listaDeMeses.insertar("Agosto");
        listaDeMeses.insertar("Septiembre");
        listaDeMeses.insertar("Octubre");
        listaDeMeses.insertar("Noviembre");
        listaDeMeses.insertar("Diciembre"); 
    }
    

    private void inicializarAnios(){
        listaDeAnios.insertar("Año 1");
        listaDeAnios.insertar("Año 2");
        listaDeAnios.insertar("Año 3");
        listaDeAnios.insertar("Año 4");
    }

    private void inicializarEstaciones(){
        listaDeEstaciones.insertar("Primavera");
        listaDeEstaciones.insertar("Verano");
        listaDeEstaciones.insertar("Otoño");
        listaDeEstaciones.insertar("Invierno");
    }

    public ListaInfoEstatica getListaDeMeses() {
        return listaDeMeses;
    }

    public void setListaDeMeses(ListaInfoEstatica listaDeMeses) {
        this.listaDeMeses = listaDeMeses;
    }

    public ListaInfoEstatica getListaDeAnios() {
        return listaDeAnios;
    }

    public void setListaDeAnios(ListaInfoEstatica listaDeAnios) {
        this.listaDeAnios = listaDeAnios;
    }

    public ListaInfoEstatica getListaDeEstaciones() {
        return listaDeEstaciones;
    }

    public void setListaDeEstaciones(ListaInfoEstatica listaDeEstaciones) {
        this.listaDeEstaciones = listaDeEstaciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ListaInfoEstatica getListaDeArrozProducidoEnUnAnio() {
        return listaDeArrozProducidoEnUnAnio;
    }

    public void setListaDeArrozProducidoEnUnAnio(ListaInfoEstatica listaDeArrozProducidoEnUnAnio) {
        this.listaDeArrozProducidoEnUnAnio = listaDeArrozProducidoEnUnAnio;
    } 

}
