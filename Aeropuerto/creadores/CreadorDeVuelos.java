package creadores;

import java.util.Scanner;
import entidades.Vuelo;

public class CreadorDeVuelos implements Crear{

    public CreadorDeVuelos(){}

    @Override
    public Vuelo crearObjeto() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del aeropuerto de origen: ");
        String nombreAeropuertoOrigen = scanner.nextLine();
        System.out.println("Ingrese el nombre del aeropuerto de destino: ");
        String nombreAeropuertoDestino = scanner.nextLine();
        System.out.println("Ingrese el tipo de avión asignado: ");
        String tipoAvionAsignado = scanner.nextLine();
        System.out.println("Ingrese la fecha de salida (Año/Mes/Dia/Hora:Minuto): ");
        String horaSalida = scanner.nextLine();
        System.out.println("Ingrese la fecha de llegada (Año/Mes/Dia/Hora:Minuto): ");
        String horaLlegada = scanner.nextLine();

        return new Vuelo(nombreAeropuertoOrigen, nombreAeropuertoDestino, tipoAvionAsignado, horaSalida, horaLlegada);
    }
}
