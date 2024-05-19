package pruebas;

import entradasalida.SalidaPorDefecto;
import gestordevacunacion.CentroDeVacunacion;
import gestordevacunacion.Enfermero;

public class PruebaVacunas {
    public static void main(String[] args) {
        CentroDeVacunacion centroDeVacunas = new CentroDeVacunacion(10);
        Enfermero uEnfermero = new Enfermero("Josebas");        
        centroDeVacunas.agregarPaciente(13,"Daniel");
        centroDeVacunas.agregarPaciente(78,"Tux");
        centroDeVacunas.agregarPaciente(45,"Jose");
        centroDeVacunas.agregarPaciente(5,"Mauricio");
        centroDeVacunas.agregarPaciente(35,"Duke");
        centroDeVacunas.agregarPaciente(67, "Debian");
        centroDeVacunas.agregarPaciente(1,"Ubuntu");
        centroDeVacunas.agregarPaciente(23,"JR");
        centroDeVacunas.agregarPaciente(44,"Martin");
        centroDeVacunas.agregarPaciente(18,"Pablo");
        centroDeVacunas.imprimirEstadoDeLosPacientes();
        SalidaPorDefecto.consola("\n");
        SalidaPorDefecto.consola("Enfermero que va a vacunar: "+uEnfermero.getNombre()+"\n");
        uEnfermero.vacunar(centroDeVacunas.getPacientesOrdenados());
        centroDeVacunas.imprimirEstadoDeLosPacientes();
    }
}