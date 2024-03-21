package operaciones;

import entidades.*;

public class Gestor{
    // Esta clase sera la encargada de poner los aviones en el almacen de aviones

    public Gestor(){}

    public void darDeAltaAvion(Avion avion, Almacen almacen) {

        almacen.getAlmacenDeAviones().add(avion);
    }

    public void darDeAltaPiloto(Piloto piloto, Almacen almacen) {

        almacen.getAlmacenDePilotos().add(piloto);
    }
    
    public void darDeAltaAeropuerto(Aeropuerto aeropuerto, Almacen almacen) {
        almacen.getAlmacenDeAeropuertos().add(aeropuerto);
    }
    public void darDeAltaVuelo(Vuelo vuelo, Almacen almacen){
        almacen.getAlmacenDeVuelos().add(vuelo);
    }
}