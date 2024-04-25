package estructurasnolineales;

import estructuraslineales.auxiliar.NodoDoble;
import utilerias.comparador.ComparadorDeObjetos;

public class ArbolBinarioBusqueda extends ArbolBinario{

    public boolean insertar(Object valor){
        if (raiz == null) {
            NodoDoble nodoRaiz = new NodoDoble(valor);
            if (nodoRaiz == null) {
                return false;
            }
            raiz = nodoRaiz;
            return true;
        }else{//Ya hay elementos
            return insertar(raiz, valor);
        }
    }

    private boolean insertar(NodoDoble subraiz, Object valor){
        if (ComparadorDeObjetos.comparar(valor, subraiz.getDato()) > 0) {
            // valor es mas grande que subraiz
            if (subraiz.getEnlaceDer() == null) {
                //Encontre su lugar 
                NodoDoble nodoHijo = new NodoDoble(valor);
                if (nodoHijo == null) {
                    return false;
                }
                subraiz.setEnlaceDer(nodoHijo);
                return true;
            }else{
                //sigo buscando
                return insertar(subraiz.getEnlaceDer(), valor);
            }
        }else if (ComparadorDeObjetos.comparar(valor, subraiz.getDato()) < 0) {
            // valor es mas grande que subraiz
            if (subraiz.getEnlaceIzq() == null) {
                //Encontre su lugar 
                NodoDoble nodoHijo = new NodoDoble(valor);
                if (nodoHijo == null) {
                    return false;
                }
                subraiz.setEnlaceIzq(nodoHijo);
                return true;
            }else{
                //sigo buscando
                return insertar(subraiz.getEnlaceIzq(), valor);
            }
        
        }else{//Son iguales
            return false;
        }
    }


    public Object buscar(Object valor){
        return buscar(raiz, valor);
    }

    private Object buscar(NodoDoble subraiz, Object valor){
        if (subraiz == null) {
            return null;
        }else{
            if(ComparadorDeObjetos.comparar(valor, subraiz.getDato()) > 0){
                return buscar(subraiz.getEnlaceDer(), valor);
            }else if(ComparadorDeObjetos.comparar(valor, subraiz.getDato()) < 0){
                return buscar(subraiz.getEnlaceIzq(), valor);
            }else{//es igual
                return subraiz.getDato();
            }
        }
    }
}