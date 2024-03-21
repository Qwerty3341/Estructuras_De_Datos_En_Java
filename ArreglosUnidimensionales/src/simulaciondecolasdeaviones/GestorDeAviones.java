package simulaciondecolasdeaviones;

import entradasalida.SalidaPorDefecto;
import estructuraslineales.ColaInfoEstatica;
import estructuraslineales.ListaInfoEstatica;

public class GestorDeAviones {

    private ColaInfoEstatica pista;//Esta es la cola donde se ordenan los aviones
    private ListaInfoEstatica listaTemp;

    public GestorDeAviones(int tamanio){
        this.pista = new ColaInfoEstatica(tamanio);
        this.listaTemp = new ListaInfoEstatica(tamanio);
    }

    public void agregarAvion(Avion unAvion){
        listaTemp.insertar(unAvion);
        if (listaTemp.estaLLeno() == true) {
            ordenar(listaTemp);//Cuando se ordenan se autoriza el vuelo
            autorizarDespegue();
            despegarAviones();
        }
    }

    private void ordenar(ListaInfoEstatica aviones){
        //Uso el mismo metodo para ordenar que en el programa anterior
        for (int index = 0; index < listaTemp.cantidad(); index++) {//Esta es para los aviones de prioridad uno ya que son los mas importantes 
            Avion avionActual = (Avion) listaTemp.obtener(index);
            if (avionActual.getPrioridadDeVuelo() == 1) {
                pista.poner(listaTemp.obtener(index));
            }
        }
        for (int index = 0; index < listaTemp.cantidad(); index++) {
            Avion avionActual = (Avion) listaTemp.obtener(index);
            if (avionActual.getPrioridadDeVuelo() == 0) {
                pista.poner(listaTemp.obtener(index));
            }
        }
    }

    private void autorizarDespegue(){
        //Aqui se le indica al avion que ya puede despegar
        for(int avion=0; avion < pista.getTamanio();avion++){
            Avion unAvion = (Avion) pista.obtener(avion);
            unAvion.setPermisoParaDespegar(true);
        }
    }

    public void imprimirInformacionDeLosAviones(){
        for(int avion=0; avion < pista.getTamanio();avion++){
            Avion unAvion = (Avion) pista.obtener(avion);
            SalidaPorDefecto.consola(unAvion.toString());
            SalidaPorDefecto.consola("\n");
        }
    }

    private void despegarAviones(){
        for(int avion=0; avion < pista.getTamanio();avion++){
            Avion unAvion = (Avion) pista.obtener(avion);
            unAvion.despegar();
            SalidaPorDefecto.consola("\n");
        }
    }
}