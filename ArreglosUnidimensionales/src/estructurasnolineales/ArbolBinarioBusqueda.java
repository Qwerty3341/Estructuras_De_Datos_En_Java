package estructurasnolineales;

import entradasalida.SalidaPorDefecto;
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

    public void eliminarNodo(Object numero){
        eliminarNodo(raiz, raiz, numero);
    }

    private void eliminarNodo(NodoDoble nodoActual, NodoDoble padre, Object info){
        if (nodoActual != null) { // Si el nodo actual no es nulo, significa que hay algo en el árbol
            if ((ComparadorDeObjetos.comparar(info, nodoActual.getDato())) == -1) {
                eliminarNodo(nodoActual.getEnlaceIzq(), nodoActual, info);
            }else{
                if((ComparadorDeObjetos.comparar(info, nodoActual.getDato())) == 1){
                    eliminarNodo(nodoActual.getEnlaceDer(), nodoActual, info);
                }else{
                    if (nodoActual.getEnlaceIzq() != null && nodoActual.getEnlaceDer() != null) {
                        NodoDoble aux = nodoActual.getEnlaceIzq();
                        NodoDoble aux1 = aux;
                        boolean bo = false;
                        while (aux.getEnlaceDer() != null) {
                            aux1 = aux;
                            aux = aux.getEnlaceDer();
                            bo = true;
                        }
                        nodoActual.setDato(aux.getDato());
                        if (bo == true) {
                            aux1.setEnlaceDer(aux.getEnlaceIzq());
                        }else{
                            nodoActual.setEnlaceIzq(aux.getEnlaceIzq());
                        }
                    }else{ // El nodo actual tiene solo un hijo o ninguno
                        NodoDoble otro = nodoActual;
                        if (otro.getEnlaceDer() == null) {
                            if (otro.getEnlaceIzq() != null) {
                                otro = nodoActual.getEnlaceIzq();
                                if (padre != null) {
                                    if ((ComparadorDeObjetos.comparar(info, padre.getDato())) == -1) {
                                        padre.setEnlaceIzq(otro);
                                    }else{
                                        padre.setEnlaceDer(otro);
                                    }
                                }else{
                                    raiz = otro;
                                }
                            }else{
                                if (padre == null) {
                                    raiz = null;
                                }else{
                                    if ((ComparadorDeObjetos.comparar(info, padre.getDato())) == -1) {
                                        padre.setEnlaceIzq(null);
                                    }else{
                                        padre.setEnlaceDer(null);
                                    }
                                }
                            }
                        }else{
                            if (otro.getEnlaceIzq() == null) {
                                otro = nodoActual.getEnlaceDer();
                                if (padre != null) {
                                    if ((ComparadorDeObjetos.comparar(info, padre.getDato())) == -1) {
                                        padre.setEnlaceIzq(otro);
                                    }else{
                                        padre.setEnlaceDer(otro);
                                    }
                                }else{
                                    raiz = otro;
                                }
                            }
                        }
                    }
                }
            }
        }else{ // Si no se encuentra el nodo, imprime un mensaje de error
            SalidaPorDefecto.consola("ERROR NODO NO EXISTENTE");
        }
    }
    
    

}