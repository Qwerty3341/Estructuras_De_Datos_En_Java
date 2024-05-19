package gestordevacunacion;

import entradasalida.SalidaPorDefecto;
import estructuraslineales.ColaInfoEstatica;
import estructuraslineales.ListaInfoEstatica;

public class CentroDeVacunacion {

    private ColaInfoEstatica pacientesOrdenados;//Esta es para agregar a los pacientes en orden
    private ListaInfoEstatica listaTemp;//Esta es para agregar a los pacientes

    public CentroDeVacunacion(int tamanio){
        this.pacientesOrdenados = new ColaInfoEstatica(tamanio);
        this.listaTemp = new ListaInfoEstatica(tamanio);
    }

    public void agregarPaciente(int edad, String nombre){
        Paciente nuevoPaciente = new Paciente(edad, nombre);
        listaTemp.insertar(nuevoPaciente);
        if (listaTemp.estaLLeno() == true) {
            ordenar(listaTemp);    
        }
    }

    private void ordenar(ListaInfoEstatica pacientes){//Se itera 4 veces para agregar en orden de prioridad a todos los pacientes
        for (int iterList = 0; iterList < listaTemp.cantidad(); iterList++) {
            Paciente pacAct = (Paciente) listaTemp.obtener(iterList);
            if (pacAct.getIdDePrioridad() == 4) {
                pacientesOrdenados.poner(listaTemp.obtener(iterList));
            }
        }
        for (int iterList = 0; iterList < listaTemp.cantidad(); iterList++) {
            Paciente pacAct = (Paciente) listaTemp.obtener(iterList);
            if (pacAct.getIdDePrioridad() == 3) {
                pacientesOrdenados.poner(listaTemp.obtener(iterList));
            }
        }
        for (int iterList = 0; iterList < listaTemp.cantidad(); iterList++) {
            Paciente pacAct = (Paciente) listaTemp.obtener(iterList);
            if (pacAct.getIdDePrioridad() == 2) {
                pacientesOrdenados.poner(listaTemp.obtener(iterList));
            }
        }
        for (int iterList = 0; iterList < listaTemp.cantidad(); iterList++) {
            Paciente pacAct = (Paciente) listaTemp.obtener(iterList);
            if (pacAct.getIdDePrioridad() == 1) {
                pacientesOrdenados.poner(listaTemp.obtener(iterList));
            }
        }
    }
    
    public void imprimirEstadoDeLosPacientes(){
        for(int paciente=0; paciente<this.pacientesOrdenados.getPosFinal()+1 ;paciente++){//Se imprimen todos los atributos de los pacientes
            Paciente unPaciente = (Paciente) pacientesOrdenados.obtener(paciente);
            SalidaPorDefecto.consola(unPaciente.toString());
            SalidaPorDefecto.consola("\n");
        }
    }

    public ColaInfoEstatica getPacientesOrdenados() {
        return pacientesOrdenados;
    }
}
