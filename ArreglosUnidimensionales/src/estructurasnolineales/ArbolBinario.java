package estructurasnolineales;

import entradasalida.EntradaPorDefecto;
import entradasalida.SalidaPorDefecto;
import estructuraslineales.auxiliar.NodoDoble;


// Esta clase crea un TDA ArbolBinario creado manualmente por el usuario

public class ArbolBinario {
    protected NodoDoble raiz; // por defecto ya es nulo

    public ArbolBinario(){
        raiz = null;
    }

    public void nuevoArbol(){
        SalidaPorDefecto.consola("Dame la raiz: ");
        String valorRaiz = EntradaPorDefecto.consolaCadenas();
        NodoDoble nodoRaiz = new NodoDoble(valorRaiz);
        raiz = nodoRaiz;
        if(nodoRaiz != null){ // no hubo error
            nuevoArbol(raiz);
        }
    }

    private void nuevoArbol(NodoDoble subRaiz){
        // Preguntar si hay hijo izquierdo
        SalidaPorDefecto.consola("¿ El nodo " +subRaiz.getDato() + " tiene hijo izquierdo? [S/N]");
        String respuestaHI = EntradaPorDefecto.consolaCadenas();
        if(respuestaHI.equalsIgnoreCase("s")){
            //Creamos un hijo izquierdo
            SalidaPorDefecto.consola("Dame el valor del hijo izquierdo de "+ subRaiz.getDato());
            String valorHi = EntradaPorDefecto.consolaCadenas();
            NodoDoble hijoIzquierdo = new NodoDoble(valorHi);
            if(hijoIzquierdo != null){
                subRaiz.setEnlaceIzq(hijoIzquierdo);
                nuevoArbol(subRaiz.getEnlaceIzq()); // crearemos un arbol con esta subraiz como base
            }
        }

        
        // Preguntar si hay hijo derecho
        SalidaPorDefecto.consola("¿ El nodo " +subRaiz.getDato() + " tiene hijo derecho? [S/N]");
        String respuestaHD = EntradaPorDefecto.consolaCadenas();
        if(respuestaHD.equalsIgnoreCase("s")){
            //Creamos un hijo derecho
            SalidaPorDefecto.consola("Dame el valor del hijo derecho de "+ subRaiz.getDato());
            String valorHD = EntradaPorDefecto.consolaCadenas();
            NodoDoble hijoDerecho = new NodoDoble(valorHD);
            if(hijoDerecho != null){
                subRaiz.setEnlaceIzq(hijoDerecho);
                nuevoArbol(subRaiz.getEnlaceDer()); // crearemos un arbol con esta subraiz como base
            }
        }
        
    }


    public void preorden(){
        preorden(raiz);
    }

    private void preorden(NodoDoble subraiz){
        // RID
        if(subraiz != null){
            SalidaPorDefecto.consola(subraiz.getDato() + " ");
            preorden(subraiz.getEnlaceIzq());
            preorden(subraiz.getEnlaceDer());
        } // el caso base es cuando subraiz es null
    }

    public void postorden(){
        postorden(raiz);
    }

    private void postorden(NodoDoble subraiz){
        // IDR
        if(subraiz != null){
            postorden(subraiz.getEnlaceIzq());
            postorden(subraiz.getEnlaceDer());
            SalidaPorDefecto.consola(subraiz.getDato() + " ");
        } // el caso base es cuando subraiz es null
    }

    public void innorden(){
        innorden(raiz);
    }

    private void innorden(NodoDoble subraiz){
        //IRD
        if(subraiz != null){
            innorden(subraiz.getEnlaceIzq());
            SalidaPorDefecto.consola(subraiz.getDato() + " ");
            innorden(subraiz.getEnlaceDer());
        } // el caso base es cuando subraiz es null
    }


    
}