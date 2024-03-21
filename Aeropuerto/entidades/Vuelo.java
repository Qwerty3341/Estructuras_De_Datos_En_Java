package entidades;

public class Vuelo {

    // La clase vuelo contiene atributos de tipo aeropuerto y avion

    private String aeropuertoDeOrigen;
    private String aeropuertoDeDestino;
    private String avionAsignado;
    private String horaDeSalida;
    private String horaDeLLegada;

    public Vuelo(){}

    public Vuelo(String aeropuertoDeOrigen, String aeropuertoDeDestino, String avionAsignado, String horaDeSalida, String horaDeLLegada){
        this.aeropuertoDeOrigen = aeropuertoDeOrigen;
        this.aeropuertoDeDestino = aeropuertoDeDestino;
        this.avionAsignado = avionAsignado;
        this.horaDeSalida = horaDeSalida;
        this.horaDeLLegada = horaDeLLegada;
    }

    // Getters

    public String getAeropuertoDeOrigen() {
        return aeropuertoDeOrigen;
    }

    public String getAeropuertoDeDestino() {
        return aeropuertoDeDestino;
    }

    public String getAvionAsignado() {
        return avionAsignado;
    }

    public String getHoraDeSalida() {
        return horaDeSalida;
    }

    public String getHoraDeLLegada() {
        return horaDeLLegada;
    }
}
