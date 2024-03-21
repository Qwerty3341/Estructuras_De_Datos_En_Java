package operaciones;

import java.util.ArrayList;
import entidades.*;

public class Consultador {

    public Consultador(){}

    public void consultarAviones(Almacen unAlmacen){
    
        ArrayList<Avion> aviones = unAlmacen.getAlmacenDeAviones();
        for(Avion avion : aviones){
            System.out.println(avion);
                        System.out.println("Tipo de avión: " + avion.getTipoDeAvion());
            System.out.println("Matrícula: " + avion.getMatricula());
            System.out.println("Fabricante: " + avion.getFabricante());
            System.out.println("Modelo: " + avion.getModelo());
            System.out.println("Capacidad: " + avion.getCapacidad());
            System.out.println("Autonomía de vuelo: " + avion.getAutonomiaDeVuelo());
            System.out.println();
        }
    }

    public void consultarVuelos(Almacen unAlmacen){

        ArrayList<Vuelo> vuelos = unAlmacen.getAlmacenDeVuelos();
        for(Vuelo vuelo : vuelos){
            System.out.println(vuelo);
            System.out.println("Aeropuerto de origen: " + vuelo.getAeropuertoDeOrigen());
            System.out.println("Aeropuerto de destino: " + vuelo.getAeropuertoDeDestino());
            System.out.println("Avión asignado: " + vuelo.getAvionAsignado());
            System.out.println("Hora de salida: " + vuelo.getHoraDeSalida());
            System.out.println("Hora de llegada: " + vuelo.getHoraDeLLegada());
            System.out.println();
        }
    }

    public void consultarAeropuertos(Almacen unAlmacen){
        ArrayList<Aeropuerto> aeropuertos = unAlmacen.getAlmacenDeAeropuertos();
        for(Aeropuerto aeropuerto : aeropuertos){
            System.out.println(aeropuerto);
            System.out.println("Nombre de la ciudad: " + aeropuerto.getCiudad());
            System.out.println("Nombre del país: " + aeropuerto.getPais());
            System.out.println();
        }
    }
}