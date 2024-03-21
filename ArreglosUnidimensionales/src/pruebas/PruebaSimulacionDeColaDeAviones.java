package pruebas;

import simulaciondecolasdeaviones.Avion;
import simulaciondecolasdeaviones.GestorDeAviones;

public class PruebaSimulacionDeColaDeAviones {
    public static void main(String[] args) {
        GestorDeAviones gestor = new GestorDeAviones(7);

        Avion avion1 = new Avion("jet");
        Avion avion2 = new Avion("comercial");
        Avion avion3 = new Avion("carga");
        Avion avion4 = new Avion("trasplante");
        Avion avion5 = new Avion("jet");
        Avion avion6 = new Avion("carga");
        Avion avion7 = new Avion("comercial");

        gestor.agregarAvion(avion1);
        gestor.agregarAvion(avion2);
        gestor.agregarAvion(avion3);
        gestor.agregarAvion(avion4);
        gestor.agregarAvion(avion5);
        gestor.agregarAvion(avion6);
        gestor.agregarAvion(avion7);

        gestor.imprimirInformacionDeLosAviones();        

    }
}
