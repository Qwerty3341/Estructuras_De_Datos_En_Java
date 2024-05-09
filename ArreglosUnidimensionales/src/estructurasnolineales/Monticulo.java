package estructurasnolineales;

import utilerias.comparador.ComparadorDeObjetos;
import utilerias.comunes.TipoDeOrdenamiento;
import estructuraslineales.ColaInfoDinamica;
import estructuraslineales.auxiliar.NodoDoble;

public class Monticulo extends ArbolBinario {

    protected TipoDeOrdenamiento orden;

    public Monticulo(TipoDeOrdenamiento ordenamiento) {
        super();
        this.orden = ordenamiento;
    }

    public boolean insertar(Object valor) {
        NodoDoble nuevoNodo = new NodoDoble(valor);
        if (raiz == null) {
            raiz = nuevoNodo;
            return true;
        }
        ColaInfoDinamica cola = new ColaInfoDinamica();
        cola.poner(raiz);
    
        while (cola.vacio() == false) {
            NodoDoble actual = (NodoDoble) cola.quitar();
    
            if (actual.getEnlaceIzq() == null) {
                actual.setEnlaceIzq(nuevoNodo);
                acomodarEnInsercion(nuevoNodo);
                return true;
            } else {
                cola.poner(actual.getEnlaceIzq());
            }
    
            if (actual.getEnlaceDer() == null) {
                actual.setEnlaceDer(nuevoNodo);
                acomodarEnInsercion(nuevoNodo);
                return true;
            } else {
                cola.poner(actual.getEnlaceDer());
            }
        }
        return false;
    }
    
    private void acomodarEnInsercion(NodoDoble nodo) {
        while (nodo != raiz) {
            NodoDoble padre = obtenerPadre(nodo);
            if (padre == null) {
                break;
            }

            boolean necesitaIntercambio = 
                (this.orden == TipoDeOrdenamiento.INC && 
                ComparadorDeObjetos.comparar(nodo.getDato(), padre.getDato()) < 0) ||
                (this.orden == TipoDeOrdenamiento.DEC && 
                ComparadorDeObjetos.comparar(nodo.getDato(), padre.getDato()) > 0);

            if (necesitaIntercambio) {
                Object temp = padre.getDato();
                padre.setDato(nodo.getDato());
                nodo.setDato(temp);
                nodo = padre;
            } else {
                break;
            }
        }
    }

    private NodoDoble obtenerPadre(NodoDoble nodo) {
        ColaInfoDinamica cola = new ColaInfoDinamica();
        cola.poner(raiz);

        while (cola.vacio() == false) {
            NodoDoble actual = (NodoDoble) cola.quitar();

            if (actual.getEnlaceIzq() == nodo || actual.getEnlaceDer() == nodo) {
                return actual;
            }

            if (actual.getEnlaceIzq() != null) {
                cola.poner(actual.getEnlaceIzq());
            }

            if (actual.getEnlaceDer() != null) {
                cola.poner(actual.getEnlaceDer());
            }
        }
        return null;
    }

    public Object eliminar() {
        if (raiz == null) {
            return null;
        }
        Object valorEliminado = raiz.getDato();
        NodoDoble ultimoNodo = obtenerUltimoNodo();

        if (ultimoNodo == raiz) {
            raiz = null; 
            return valorEliminado;
        }
        raiz.setDato(ultimoNodo.getDato());
        eliminarUltimoNodo(ultimoNodo);
        acomodarEnEliminacion(raiz);
        return valorEliminado;
    }

    private void acomodarEnEliminacion(NodoDoble nodo) {
        if (nodo == null)
            return;

        while (nodo.getEnlaceIzq() != null || nodo.getEnlaceDer() != null) {
            NodoDoble hijoMenorOMayor = nodo.getEnlaceIzq();

            if (nodo.getEnlaceDer() != null && 
                ((orden == TipoDeOrdenamiento.INC && 
                ComparadorDeObjetos.comparar(nodo.getEnlaceDer().getDato(), nodo.getEnlaceIzq().getDato()) < 0) ||
                (orden == TipoDeOrdenamiento.DEC && ComparadorDeObjetos.comparar(nodo.getEnlaceDer().getDato(),
                nodo.getEnlaceIzq().getDato()) > 0))) {
                hijoMenorOMayor = nodo.getEnlaceDer();
            }

            if ((
                orden == TipoDeOrdenamiento.INC &&
                ComparadorDeObjetos.comparar(hijoMenorOMayor.getDato(), nodo.getDato()) >= 0) ||
                (orden == TipoDeOrdenamiento.DEC && 
                ComparadorDeObjetos.comparar(hijoMenorOMayor.getDato(), nodo.getDato()) <= 0)) {
                break;
            }
            // Intercambiar los valores de nodo y hijo menor/mayor
            Object temp = nodo.getDato();
            nodo.setDato(hijoMenorOMayor.getDato());
            hijoMenorOMayor.setDato(temp);
            nodo = hijoMenorOMayor;
        }
    }

    private NodoDoble obtenerUltimoNodo() {
        ColaInfoDinamica cola = new ColaInfoDinamica();
        cola.poner(raiz);
        NodoDoble ultimoNodo = null;

        while (cola.vacio() == false) {
            ultimoNodo = (NodoDoble) cola.quitar();
            if (ultimoNodo.getEnlaceIzq() != null) {
                cola.poner(ultimoNodo.getEnlaceIzq());
            }
            if (ultimoNodo.getEnlaceDer() != null) {
                cola.poner(ultimoNodo.getEnlaceDer());
            }
        }

        return ultimoNodo;
    }

    private void eliminarUltimoNodo(NodoDoble ultimoNodo) {
        ColaInfoDinamica cola = new ColaInfoDinamica();
        cola.poner(raiz);
        while (!cola.vacio()) {
            NodoDoble actual = (NodoDoble) cola.quitar();

            if (actual.getEnlaceIzq() == ultimoNodo) {
                actual.setEnlaceIzq(null);
                return;
            } else if (actual.getEnlaceDer() == ultimoNodo) {
                actual.setEnlaceDer(null);
                return;
            }

            if (actual.getEnlaceIzq() != null) {
                cola.poner(actual.getEnlaceIzq());
            }
            if (actual.getEnlaceDer() != null) {
                cola.poner(actual.getEnlaceDer());
            }
        }
    }

    public Object obtenerRaiz() {
        if (raiz != null) {
            return raiz.getDato();
        }
        return null;
    }

    public TipoDeOrdenamiento getOrden() {
        return orden;
    }

}