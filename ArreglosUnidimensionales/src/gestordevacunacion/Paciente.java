package gestordevacunacion;

public class Paciente {

    private int idDePrioridad;
    private int edad;
    private String nombre;
    private boolean estaVacunado;

    public Paciente(int edadArg, String nom){
        this.edad = edadArg;
        this.estaVacunado = false;
        this.nombre = nom;
        //Van a ser 5 prioridades
        if (edad >= 0 && edad <= 12) {
            this.idDePrioridad = 3; // Ninios
        }else if(edad >= 13 && edad <= 17){
            this.idDePrioridad = 2; // Adolesentes
        }else if (edad >= 18 && edad <= 50) {
            this.idDePrioridad = 1; // Adultos
        }else{
            this.idDePrioridad = 4; //Ancianos
        }
    }

    public int getIdDePrioridad() {
        return idDePrioridad;
    }

    public void setIdDePrioridad(byte idDePrioridad) {
        this.idDePrioridad = idDePrioridad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(short edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public boolean getEstaVacunado() {
        return estaVacunado;
    }

    public void setEstaVacunado(boolean estaVacunado) {
        this.estaVacunado = estaVacunado;
    }

    @Override
    public String toString() {
        StringBuilder clienteStr = new StringBuilder();
        clienteStr.append("\t|Nombre:").append(this.getNombre())
        .append("|Edad:").append(this.getEdad())
        .append("|Prioridad:").append(this.idDePrioridad)
        .append("|Esta vacuando:").append(estaVacunado)
        .append("|");
        return clienteStr.toString();
    }

}