package entidades;

public class Avion {

    // Esta clase describe a los aviones

    private String tipoDeAvion;
    private int matricula;
    private String fabricante;
    private String modelo;
    private int capacidad;
    private int autonomiaDeVuelo; // Lo que le dura el combustible

    public Avion() {
    }

    public Avion(String tipoDeAvion, int matricula, String fabricante, String modelo, int capacidad, int autonomiaDeVuelo) {
        this.tipoDeAvion = tipoDeAvion;
        this.matricula = matricula;
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.capacidad = capacidad;
        this.autonomiaDeVuelo = autonomiaDeVuelo;
    }

    public String getTipoDeAvion() {
        return tipoDeAvion;
    }

    public int getMatricula() {
        return matricula;
    }

    public String getFabricante() {
        return fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public int getAutonomiaDeVuelo() {
        return autonomiaDeVuelo;
    }
}
