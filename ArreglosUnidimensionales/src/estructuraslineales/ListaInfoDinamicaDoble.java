package estructuraslineales;

import estructuraslineales.auxiliar.NodoDoble;

public class ListaInfoDinamicaDoble  {

    protected NodoDoble apuntadorInicial;
    protected NodoDoble apuntadorFinal;

    public ListaInfoDinamicaDoble(){
        this.apuntadorInicial=null;
        this.apuntadorFinal=null;
    }

    public Integer insertar(Object valor){
        //paso 1
        NodoDoble nodoNuevo = new NodoDoble(valor);
        if (nodoNuevo != null) {
            if (apuntadorInicial == null) { //a) ,vacia
                //paso2
                apuntadorInicial=nodoNuevo;
                apuntadorFinal=nodoNuevo;
            }else{//hay uno o varios
                //paso 2
                nodoNuevo.setEnlaceIzquierdo(apuntadorFinal);
                //paso 3
                apuntadorFinal.setEnlaceDerecho(nodoNuevo);
                //paso 4
                apuntadorFinal=nodoNuevo;
            }
            return 0;
        }else{//error o lleno
            return -1;
        }
    }
}
