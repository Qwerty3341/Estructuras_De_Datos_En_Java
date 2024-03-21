package entidades;

import java.util.ArrayList;

public class Almacen {
    
    //Esta clase es la encargada de almacenar los aviones, pilotos y vuelos

    public ArrayList<Avion> almacenDeAviones;
    public ArrayList<Piloto> almacenDePilotos;
    public ArrayList<Vuelo> almacenDeVuelos;
    public ArrayList<Aeropuerto> almacenAeropuertos;


    public Almacen(){
        this.almacenDeAviones = new ArrayList<>();
        this.almacenDePilotos = new ArrayList<>();
        this.almacenDeVuelos = new ArrayList<>();
        this.almacenAeropuertos = new ArrayList<>();
    }

    public ArrayList<Avion> getAlmacenDeAviones(){
        return this.almacenDeAviones;
    }

    public ArrayList<Piloto> getAlmacenDePilotos() {
        return almacenDePilotos;
    }

    public ArrayList<Vuelo> getAlmacenDeVuelos() {
        return almacenDeVuelos;
    }

    public ArrayList<Aeropuerto> getAlmacenDeAeropuertos(){
        return almacenAeropuertos;
    }

}