package estructuraslineales;

import estructuraslineales.auxiliar.Nodo;

public class ColaInfoDinamica implements LoteInfo{

    private ListaInfoDinamica datos;

    public ColaInfoDinamica(){
        this.datos = new ListaInfoDinamica();
    }

    public Object obtener(int index) {
        if (vacio()) { 
            return null;
        } else {
            Nodo iterador = datos.apuntadorInicial;
            int contador = 0;
            while (iterador != null && contador < index) {
                iterador = iterador.getEnlaceDerecho();
                contador++;
            }
            if (iterador != null) {
                return iterador.getDato(); 
            } else {
                return null; 
            }
        }
    }

    @Override
    public boolean poner(Object valor) {
        this.datos.insertar(valor);
        return true;
    }

    @Override
    public Object quitar() {
        if (vacio()) { 
            return null;
        } else {
            Object dato = datos.apuntadorInicial.getDato(); 
            datos.apuntadorInicial = datos.apuntadorInicial.getEnlaceDerecho(); 
            return dato;
        }
    }
    
    @Override
    public boolean vacio() {
        return datos.estaVacia();
    }

    @Override
    public boolean lleno() {
        //Se entiende que al ser dinamica siempre esta llena, este metodo solo nos sirve para ver si a la cola ya le pusieron algun objeto
        Boolean verificacion = datos.estaVacia();
        if (verificacion == true) {
            return false;
        }else{
            return true; 
        }
    }

    @Override
    public Object verFinal() {
        if (vacio() == true) {
            return null;
        }else{
            Nodo iterador = datos.apuntadorInicial;
            while (iterador.getEnlaceDerecho() != null) {
                iterador = iterador.getEnlaceDerecho();
            }
            return iterador.getDato();
        }
    }

    @Override
    public void mostrar() {
        datos.mostrar();
    }
}
