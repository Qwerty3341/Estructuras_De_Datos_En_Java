package creadores;

import java.util.Scanner;
import entidades.*;

public class CreadorDeAviones implements Crear {
    /*
     * Esta clase es la encargada de crear los aviones para despues almacenarlos en el almacen
    */

    public CreadorDeAviones(){}

    @Override
    public Avion crearObjeto() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el tipo de avión:\n");
        String tipoDeAvion = scanner.nextLine();
        System.out.print("Ingrese la matrícula del avión:\n");
        int matricula = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese el fabricante del avión:\n");
        String fabricante = scanner.nextLine();
        System.out.print("Ingrese el modelo del avión:\n");
        String modelo = scanner.nextLine();
        System.out.print("Ingrese la capacidad del avión:\n");
        int capacidad = scanner.nextInt();
        System.out.print("Ingrese la autonomía de vuelo del avión:\n");
        int autonomiaDeVuelo = scanner.nextInt();

        return new Avion(tipoDeAvion, matricula, fabricante, modelo, capacidad, autonomiaDeVuelo);
    }
}
