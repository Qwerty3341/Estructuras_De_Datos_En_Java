package simulaciondecolasdeaviones;

import entradasalida.SalidaPorDefecto;

public class Avion {

    private int prioridadDeVuelo;
    private boolean permisoParaDespegar;
    private String tipo;

    public Avion(String tipo) {
        this.tipo = tipo;
        if (tipo.equalsIgnoreCase("jet") || tipo.equalsIgnoreCase("comercial")) {
            this.prioridadDeVuelo = 0;
        }else if (tipo.equalsIgnoreCase("carga") || tipo.equalsIgnoreCase("trasplante")) {
            this.prioridadDeVuelo = 1;
        }
        this.permisoParaDespegar = false;
    }

    public void despegar(){
        //Esto es para indicar que ya estan ordenados
        if(permisoParaDespegar == true){
            SalidaPorDefecto.consola("\tEl avion "+this.getClass()+" a despegado");
        }
    }

    @Override
    public String toString(){
        StringBuilder info = new StringBuilder();
        info.append("\t| Tipo: ").append(tipo)
        .append(" | Prioridad: ").append(prioridadDeVuelo)
        .append(" | Permiso de despegue: ").append(permisoParaDespegar)
        .append(" |");
        return info.toString();
    }

    public int getPrioridadDeVuelo() {
        return prioridadDeVuelo;
    }

    public void setPrioridadDeVuelo(int prioridadDeVuelo) {
        this.prioridadDeVuelo = prioridadDeVuelo;
    }

    public boolean getPermisoParaDespegar() {
        return permisoParaDespegar;
    }

    public void setPermisoParaDespegar(boolean permisoParaDespegar) {
        this.permisoParaDespegar = permisoParaDespegar;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
