package vista;

import creadores.CreadorDeAeropuertos;
import creadores.CreadorDeAviones;
import creadores.CreadorDePilotos;
import creadores.CreadorDeVuelos;
import entidades.Almacen;
import operaciones.Consultador;
import operaciones.Gestor;

import java.util.Scanner;

public class Menu {

    public CreadorDeAeropuertos hacerAeropuerto;
    public CreadorDeAviones hacerAvion;
    public CreadorDePilotos hacerPiloto;
    public CreadorDeVuelos hacerVuelo;
    public Consultador consultador;
    public Almacen almacen;
    public Gestor gestor;
    public Menu(){
        this.hacerAeropuerto = new CreadorDeAeropuertos();
        this.hacerAvion = new CreadorDeAviones();
        this.hacerPiloto = new CreadorDePilotos();
        this.hacerVuelo = new CreadorDeVuelos();
        this.consultador = new Consultador();
        this.almacen = new Almacen();
        this.gestor = new Gestor();
    }

    private void mostrarMenuPrincipal(){
        System.out.println("""
        1) Dar de alta avion.
        2) Dar de alta piloto.
        3) Registrar vuelo.
        4) Dar de alta aeropuerto.
        5) Consultar avion.
        6) Consultar vuelo.
        7) Consultar aeropuerto.
        8) Salir
                """);
    }
    private void recibirRespuesta() {
        Scanner scanner = new Scanner(System.in);
        int operacionDelUsuario = scanner.nextInt();

        switch (operacionDelUsuario) {
            case 1:
                gestor.darDeAltaAvion(hacerAvion.crearObjeto(),almacen);
                break;
            case 2:
                gestor.darDeAltaPiloto(hacerPiloto.crearObjeto(),almacen);
                break;
            case 3:
                gestor.darDeAltaVuelo(hacerVuelo.crearObjeto(),almacen);
                break;
            case 4:
                gestor.darDeAltaAeropuerto(hacerAeropuerto.crearObjeto(),almacen);
                break;
            case 5:
                consultador.consultarAviones(almacen);
                break;
            case 6:
                consultador.consultarVuelos(almacen);
                break;
            case 7:
                consultador.consultarAeropuertos(almacen);
                break;
            case 8:
                System.exit(0);
                break;
            default:
                System.out.println("ERROR");
        }
    }
    public void ciclar(){

        while(true){
            mostrarMenuPrincipal();
            recibirRespuesta();
        }
    }
}