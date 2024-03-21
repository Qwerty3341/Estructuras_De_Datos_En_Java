package creadores;

import java.util.Scanner;
import entidades.*;

public class CreadorDeAeropuertos implements Crear {
    /*
     * Esta clase es la encargada de crear los Aeropuertos para despues almacenarlos en el almacen
    */

    public CreadorDeAeropuertos(){}

    @Override
    public Aeropuerto crearObjeto() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Coloca el nombre de la ciudad del aeropuerto:\n");
        String nombreDeCiudad = scanner.nextLine();
        System.out.print("Coloca el nombre del pais:\n");
        String nombreDePais = scanner.nextLine();

        return new Aeropuerto(nombreDeCiudad, nombreDePais);

    }
}
