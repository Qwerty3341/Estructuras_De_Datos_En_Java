package estructurasnolineales;

import entradasalida.EntradaPorDefecto;
import entradasalida.SalidaPorDefecto;
import estructuraslineales.ColaInfoDinamica;
import estructuraslineales.ListaInfoDinamica;
import estructuraslineales.PilaInfoDinamica;
import estructuraslineales.auxiliar.Nodo;
import estructuraslineales.auxiliar.NodoDoble;

// Esta clase crea un TDA ArbolBinario creado manualmente por el usuario

public class ArbolBinario {
    protected NodoDoble raiz; // por defecto ya es nulo

    public ArbolBinario() {
        raiz = null;
    }

    public void nuevoArbol() {
        SalidaPorDefecto.consola("Dame la raiz: ");
        String valorRaiz = EntradaPorDefecto.consolaCadenas();
        NodoDoble nodoRaiz = new NodoDoble(valorRaiz);
        raiz = nodoRaiz;
        if (nodoRaiz != null) { // no hubo error
            nuevoArbol(raiz);
        }
    }

    public void nuevoArbol(NodoDoble subRaiz) {
        if (subRaiz == null) {
            return; // Si el subRaíz es nulo, termina la ejecución para evitar NullPointerException.
        }

        SalidaPorDefecto.consola("¿El nodo " + subRaiz.getDato() + " tiene hijo izquierdo? [S/N]: ");
        String respuestaHI = EntradaPorDefecto.consolaCadenas();
        if ("S".equalsIgnoreCase(respuestaHI)) {
            SalidaPorDefecto.consola("Dame el valor del hijo izquierdo de " + subRaiz.getDato() + ": ");
            String valorHi = EntradaPorDefecto.consolaCadenas();
            NodoDoble hijoIzquierdo = new NodoDoble(valorHi);
            subRaiz.setEnlaceIzq(hijoIzquierdo);
            nuevoArbol(hijoIzquierdo); // Llama recursivamente para crear el subárbol izquierdo
        }

        SalidaPorDefecto.consola("¿El nodo " + subRaiz.getDato() + " tiene hijo derecho? [S/N]: ");
        String respuestaHD = EntradaPorDefecto.consolaCadenas();
        if ("S".equalsIgnoreCase(respuestaHD)) {
            SalidaPorDefecto.consola("Dame el valor del hijo derecho de " + subRaiz.getDato() + ": ");
            String valorHD = EntradaPorDefecto.consolaCadenas();
            NodoDoble hijoDerecho = new NodoDoble(valorHD);
            subRaiz.setEnlaceDer(hijoDerecho);
            nuevoArbol(hijoDerecho); // Llama recursivamente para crear el subárbol derecho
        }
    }

    public void preorden() {
        preorden(raiz);
    }

    private void preorden(NodoDoble subraiz) {
        // RID
        if (subraiz != null) {
            SalidaPorDefecto.consola(subraiz.getDato() + " ");
            preorden(subraiz.getEnlaceIzq());
            preorden(subraiz.getEnlaceDer());
        } // el caso base es cuando subraiz es null
    }

    public void postorden() {
        postorden(raiz);
    }

    private void postorden(NodoDoble subraiz) {
        // IDR
        if (subraiz != null) {
            postorden(subraiz.getEnlaceIzq());
            postorden(subraiz.getEnlaceDer());
            SalidaPorDefecto.consola(subraiz.getDato() + " ");
        } // el caso base es cuando subraiz es null
    }

    public void innorden() {
        innorden(raiz);
    }

    private void innorden(NodoDoble subraiz) {
        // IRD
        if (subraiz != null) {
            innorden(subraiz.getEnlaceIzq());
            SalidaPorDefecto.consola(subraiz.getDato() + " ");
            innorden(subraiz.getEnlaceDer());
        } // el caso base es cuando subraiz es null
    }

    /*
     * Metodos de la practica 16
     */

    public int obtenerAltura() {
        return calcularAltura(this.raiz);
    }

    private int calcularAltura(NodoDoble nodo) {
        if (nodo == null) {
            return 0;
        } else {
            int izq = calcularAltura(nodo.getEnlaceIzq());
            int der = calcularAltura(nodo.getEnlaceDer());
            int mayor;
            if (izq > der) {// Vemos cual es el mayor
                mayor = izq;
            } else {
                mayor = der;
            }
            return mayor + 1;
        }
    }

    public int buscarNivelDeNodo(Object valor) {
        return buscarNivelDeNodo(this.raiz, valor, 1);
    }

    private int buscarNivelDeNodo(NodoDoble nodo, Object valor, int nivelActual) {
        if (nodo == null) {
            return 0; // El nodo no existe en el árbol.
        } else if (nodo.getDato().equals(valor)) {
            return nivelActual;
        } else {
            int nivelIzquierdo = buscarNivelDeNodo(nodo.getEnlaceIzq(), valor, nivelActual + 1);
            if (nivelIzquierdo != 0) {
                return nivelIzquierdo;
            }
            return buscarNivelDeNodo(nodo.getEnlaceDer(), valor, nivelActual + 1);
        }
    }

    public void contarNodosPorNivel() {
        ListaInfoDinamica conteoPorNivel = new ListaInfoDinamica();
        contarNodosPorNivel(raiz, 0, conteoPorNivel);
        Nodo actual = conteoPorNivel.getApuntadorInicial();// Iterar sobre la lista para imprimir los resultados
        int nivel = 1;
        while (actual != null) {
            SalidaPorDefecto.consola("Nivel " + nivel + ": " + actual.getDato() + "\n");
            actual = actual.getEnlaceDerecho();
            nivel++;
        }
    }

    private void contarNodosPorNivel(NodoDoble nodo, int nivelActual, ListaInfoDinamica conteoPorNivel) {
        if (nodo == null) {
            return;
        }
        // Asegurar que la lista tenga suficiente tamaño
        while (nivelActual >= conteoPorNivel.obtenerCantidadDeElementos()) {
            conteoPorNivel.insertar(0);
        }
        // Obtener el valor actual en el nivel especificado y incrementarlo
        Nodo nodoActual = conteoPorNivel.obtenDatoEspecifico(nivelActual);
        Integer conteoActual = (Integer) nodoActual.getDato();
        conteoActual++;
        nodoActual.setDato(conteoActual); // Actualizamos el contador
        contarNodosPorNivel(nodo.getEnlaceIzq(), nivelActual + 1, conteoPorNivel);
        contarNodosPorNivel(nodo.getEnlaceDer(), nivelActual + 1, conteoPorNivel);
    }

    public String encontrarNodoConPadre(Object valor) {
        return encontrarNodoConPadre(this.raiz, null, valor);
    }

    private String encontrarNodoConPadre(NodoDoble nodoActual, NodoDoble padre, Object valor) {
        if (nodoActual == null) {
            return "ERROR NODO NO ENCONTRADO";
        }
        if (nodoActual.getDato().equals(valor)) {
            if (nodoActual == raiz) {
                return "nodo raíz, sin padre.";
            } else {
                String tipoNodo = "nodo hoja";
                if (nodoActual.getEnlaceIzq() != null || nodoActual.getEnlaceDer() != null) {
                    tipoNodo = "nodo intermedio";
                }
                return tipoNodo + ", su padre es " + padre.getDato().toString();
            }
        }
        String resultadoIzq = encontrarNodoConPadre(nodoActual.getEnlaceIzq(), nodoActual, valor);
        if (resultadoIzq.equals("ERROR NODO NO ENCONTRADO") == false) {
            return resultadoIzq;
        }
        return encontrarNodoConPadre(nodoActual.getEnlaceDer(), nodoActual, valor);
    }

    public String encontrarNodoYHermano(Object valor) {
        return encontrarNodoYHermano(this.raiz, null, valor);
    }

    private String encontrarNodoYHermano(NodoDoble nodoActual, NodoDoble padre, Object valor) {
        if (nodoActual == null) {
            return "El nodo no existe en el árbol.";
        }

        if (nodoActual.getDato().toString().equals(valor)) {
            if (nodoActual == raiz) {
                return "El nodo es la raíz y no tiene hermanos.";
            } else {
                String hermano = "no tiene hermano.";
                if (padre.getEnlaceIzq() != null && padre.getEnlaceDer() != null) {
                    NodoDoble hermanoNodo = null;
                    if (padre.getEnlaceIzq() == nodoActual) {
                        hermanoNodo = padre.getEnlaceDer();
                    } else {
                        hermanoNodo = padre.getEnlaceIzq();
                    }
                    hermano = "tiene un hermano: " + hermanoNodo.getDato().toString();
                }
                return "El nodo " + nodoActual.getDato().toString() + " " + hermano;
            }
        }
        String resultadoIzq = encontrarNodoYHermano(nodoActual.getEnlaceIzq(), nodoActual, valor);
        if (resultadoIzq.equals("El nodo no existe en el árbol.") == false) {
            return resultadoIzq;
        }
        return encontrarNodoYHermano(nodoActual.getEnlaceDer(), nodoActual, valor);
    }

    // Metodos de la practica 17

    public void recorridoPostorden() {
        if (raiz == null) {
            SalidaPorDefecto.consola("Raiz nula");
            return;
        }
        // Hacemos dos pilas para almacenar los nodos
        PilaInfoDinamica pilaDeNodos = new PilaInfoDinamica();
        PilaInfoDinamica pilaDeNodosAlReverzo = new PilaInfoDinamica();
    
        pilaDeNodos.poner(raiz);
    
        while (pilaDeNodos.vacio() == false) { 
            // Actualizamos el nodo actual
            NodoDoble nodoActual = (NodoDoble) pilaDeNodos.quitar();
            pilaDeNodosAlReverzo.poner(nodoActual);
            if (nodoActual.getEnlaceIzq() != null) {
                pilaDeNodos.poner(nodoActual.getEnlaceIzq());
            }
            if (nodoActual.getEnlaceDer() != null) {
                pilaDeNodos.poner(nodoActual.getEnlaceDer());
            }
        }    
        while (pilaDeNodosAlReverzo.vacio() == false) { 
            NodoDoble unNodo = (NodoDoble) pilaDeNodosAlReverzo.quitar();
            SalidaPorDefecto.consola(unNodo.getDato() + " ");
        }
    }
    
    public void recorridoEnAmplitud(){
        if (raiz == null) {
            return;
        }

        ColaInfoDinamica colaDeNodosPorVisitar = new ColaInfoDinamica();
        colaDeNodosPorVisitar.poner(raiz);
        while (colaDeNodosPorVisitar.vacio() == false) {
            NodoDoble nodo = (NodoDoble) colaDeNodosPorVisitar.quitar();
            SalidaPorDefecto.consola(nodo.getDato() + " ");

            if (nodo.getEnlaceIzq() != null) {
                colaDeNodosPorVisitar.poner(nodo.getEnlaceIzq());
            }
            if (nodo.getEnlaceDer() != null) {
                colaDeNodosPorVisitar.poner(nodo.getEnlaceDer());
            }

        }
    }

    public void recorridoEnAmplitudConPilas(){
        if (raiz == null) {
            return;
        }
        PilaInfoDinamica pilaDeNodosPorVisitar = new PilaInfoDinamica();
        pilaDeNodosPorVisitar.poner(raiz);
        while (pilaDeNodosPorVisitar.vacio() == false) {
            NodoDoble nodo = (NodoDoble) pilaDeNodosPorVisitar.quitar();
            SalidaPorDefecto.consola(nodo.getDato() + " ");

            if (nodo.getEnlaceIzq() != null) {
                pilaDeNodosPorVisitar.poner(nodo.getEnlaceIzq());
            }
            if (nodo.getEnlaceDer() != null) {
                pilaDeNodosPorVisitar.poner(nodo.getEnlaceDer());
            }

        }
    }
}