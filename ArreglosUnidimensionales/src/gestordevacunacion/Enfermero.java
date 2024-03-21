package gestordevacunacion;

import estructuraslineales.ColaInfoEstatica;

public class Enfermero {

    private String nombre;

    public Enfermero(String nombre){
        this.nombre = nombre;
    }

    public void vacunar(ColaInfoEstatica colaDePacientes){
        for (int vacuna = 0; vacuna < colaDePacientes.getPosFinal(); vacuna++) {
            Paciente unPaciente = (Paciente) colaDePacientes.obtener(vacuna);
            unPaciente.setEstaVacunado(true);
        }
    }
    
    public String getNombre() {
        return nombre;
    }
}