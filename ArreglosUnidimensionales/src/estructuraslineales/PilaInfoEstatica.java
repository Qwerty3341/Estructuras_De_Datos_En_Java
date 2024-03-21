package estructuraslineales;

public class PilaInfoEstatica implements LoteInfo{

    protected ListaInfoEstatica arregloPila;
    
    public PilaInfoEstatica(int tamanio){
        arregloPila = new ListaInfoEstatica(tamanio);
    }

    public boolean poner(Object valor){
        int retorno = arregloPila.insertar(valor);
        if (retorno >= 0) {//Me da la posicion de insercion
            return true;    
        }else{//un -1
            return false;
        }
    }

    public Object quitar(){
        return arregloPila.borrar();
    }

    public boolean vacio(){
        return arregloPila.estaVacia();
    }

    public boolean lleno(){
        return arregloPila.estaLLeno();
    }

    public Object verFinal(){
        return arregloPila.verFinal();
    }

    public void mostrar(){
        arregloPila.mostrar();
    }

}
