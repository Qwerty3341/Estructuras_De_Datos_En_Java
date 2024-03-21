package creadores;

import entidades.Piloto;

import java.util.Scanner;

public class CreadorDePilotos implements Crear {

    /*
    Esta clase es la encargada de crear los Pilotos para despues almacenarlos en el almacen
    */

    public CreadorDePilotos(){}

    @Override
    public Piloto crearObjeto() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del piloto:\n");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el tipo de licencia del piloto:\n");
        String tipoDeLicencia = scanner.nextLine();

        return new Piloto(nombre, tipoDeLicencia);
    }
}
