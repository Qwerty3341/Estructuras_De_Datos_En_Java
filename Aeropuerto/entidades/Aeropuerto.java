package entidades;

public class Aeropuerto {

    // Esta clase se va a usar para describir a los aeropuertos

    private String ciudad;
    private String pais;

    public Aeropuerto(){}

    public Aeropuerto(String ciudad, String pais){
        this.ciudad = ciudad;
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}

