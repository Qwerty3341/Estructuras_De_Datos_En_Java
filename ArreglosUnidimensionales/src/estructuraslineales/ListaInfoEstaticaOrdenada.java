package estructuraslineales;

import utilerias.comparador.ComparadorDeObjetos;
import utilerias.comunes.TipoDeOrdenamiento;

public class ListaInfoEstaticaOrdenada extends ListaInfoEstatica{
    
    private TipoDeOrdenamiento orden;

    public ListaInfoEstaticaOrdenada(int maximo, TipoDeOrdenamiento orden){
        super(maximo);
        this.orden = orden;
    }

    @Override
    public Object encontrar(Object valor){
        int posicionBusqueda = 0;
        if(this.orden == TipoDeOrdenamiento.INC){
            while((posicionBusqueda <= posFinal) && (ComparadorDeObjetos.comparar(valor, arreglo[posicionBusqueda]) > 0)){
                posicionBusqueda = posicionBusqueda + 1;
            }
            if((posicionBusqueda > posFinal) || (ComparadorDeObjetos.comparar(valor, arreglo[posicionBusqueda]) < 0)){
                return(posicionBusqueda + 1) * -1;
            }
            else{
                return posicionBusqueda + 1;
            }
        }else{ 
            while((posicionBusqueda <= posFinal) && (ComparadorDeObjetos.comparar(valor, arreglo[posicionBusqueda]) < 0)){
                posicionBusqueda = posicionBusqueda + 1;
            }
            if((posicionBusqueda > posFinal) || (ComparadorDeObjetos.comparar(valor, arreglo[posicionBusqueda]) > 0)){
                return(posicionBusqueda + 1) * -1;
            }
            else{
                return posicionBusqueda + 1;
            }
        }
    }
    
    @Override
    public Integer insertar(Object valor){
        int posicion = (Integer) encontrar(valor);
        if(posicion < 0 && this.estaLLeno() == false){//Si no lo encuentra y en incremental
            posFinal++;
            posicion = posicion * (-1);
            posicion = posicion - 1; // Desmapeo
            for(int indiceMov = posFinal; indiceMov > posicion; indiceMov--){
                arreglo[indiceMov] = arreglo [indiceMov - 1];
            }
            arreglo[posicion] = valor;
            return posicion + 1;
        }else{
            return -1;
        }
    }

    @Override
    public boolean cambiar(int indice, Object valor){
        Object original = arreglo[indice];
        int posicion;
        if((borrar(original) == null) == false){ // SI se pudo borrar
            posicion = insertar(valor);
        }else{
            return false;
        }
        if(posicion > 0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Object borrar(Object valor){
        int pos = (Integer) encontrar(valor);
        if (pos > 0) {
            pos--;
            posFinal--;
            Object respaldo = arreglo[pos];
            for (int i = 0; i <= posFinal; i++) {
                arreglo[i] = arreglo[i+1];
            }
            return respaldo;
        }else{
            return null;
        }
    }

    public Object obtener(int index){
        return this.arreglo[index];
    }
}
