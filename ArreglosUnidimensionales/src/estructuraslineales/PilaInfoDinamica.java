package estructuraslineales;

import estructuraslineales.auxiliar.Nodo;

public class PilaInfoDinamica implements LoteInfo{
    
    private ListaInfoDinamica listaPila;

    public PilaInfoDinamica(){
        this.listaPila = new ListaInfoDinamica();
    }

    //Metodos de Lote Info
    @Override
    public boolean poner(Object valor) {
        int retorno = listaPila.insertar(valor);
        if (retorno>=0) {
            return true;    
        }else{
            return false;
        }
    }

    @Override
    public Object quitar() {
        return listaPila.borrar();
    }

    @Override
    public boolean vacio() {
        return listaPila.estaVacia();
    }
    
    @Override
    public boolean lleno() {
        //Se entiende que al ser dinamica siempre esta llena, este metodo solo nos sirve para ver si a la pila ya le pusieron algun objeto
        Boolean verificacion = listaPila.estaVacia();
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
            Nodo iterador = listaPila.apuntadorInicial;
            while (iterador.getEnlaceDerecho() != null) {
                iterador = iterador.getEnlaceDerecho();
            }
            return iterador.getDato();
        }
    }

    @Override
    public void mostrar() {
        listaPila.mostrar();
    }


}