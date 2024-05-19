package estructurasnolineales;

import entradasalida.EntradaPorDefecto;
import entradasalida.SalidaPorDefecto;
import estructuraslineales.ListaInfoDinamica;
import estructuraslineales.ListaInfoDinamicaClave;
import estructuraslineales.PilaInfoEstatica;
import estructuraslineales.auxiliar.NodoDoble;
import utilerias.matematicas.ExpresionesAritmeticas;

public class ArbolDeExpresionesA extends ArbolBinario {

    public boolean nuevoArbolPostfija(String postfija) {

        PilaInfoEstatica pila = new PilaInfoEstatica(postfija.length());
        for (int posToken = 0; posToken < postfija.length(); posToken++) {
            // 2.Tokenizar de iz a derecha
            char token = postfija.charAt(posToken);

            // 3.Si es operando crear nodo con el token y meterlo en la pila
            if (ExpresionesAritmeticas.esOperando(token + "") == true) {
                NodoDoble nodoOperando = new NodoDoble(token + "");
                pila.poner(nodoOperando);
            } else {
                // 4.Si es operador, crear nodo con el token, ligarlo con los dos hijos (sacando
                // elementos de la pila donde el primero es op2) despues meterlo en la pila
                NodoDoble nodoOperador = new NodoDoble(token + "");
                NodoDoble op2 = (NodoDoble) pila.quitar();
                NodoDoble op1 = (NodoDoble) pila.quitar();

                if (op2 != null && op1 != null) {
                    nodoOperador.setEnlaceIzq(op1);
                    nodoOperador.setEnlaceDer(op2);
                    pila.poner(nodoOperador);
                } else {
                    return false;
                }
            }
        }
        // 5. La raiz esta en la pila.
        raiz = (NodoDoble) pila.quitar();
        return true;
    }

    public boolean nuevoArbolInfija(String infija) {
        // Primero tendria que convertir a postfija o prefija y luego llamar a los otros
        // metodos
        return true;
    }

    public boolean nuevoArbolPrefija(String prefija) {
        return true;
    }

    /*
    * Practica 16
    */

    public ListaInfoDinamicaClave asignarValoresALasVariables(){
        ListaInfoDinamicaClave listaVariables = new ListaInfoDinamicaClave();
        asignarValoresALasVariables(this.raiz, listaVariables);
        return listaVariables;
    }

    private void asignarValoresALasVariables(NodoDoble nodoActual, ListaInfoDinamicaClave lista) {
        if (nodoActual == null) {
            return; 
        }
        if (esOperador(nodoActual.getDato().toString()) == false) {
            SalidaPorDefecto.consola("Inserta un valor para " + nodoActual.getDato() + " = ");
            Double valor = EntradaPorDefecto.consolaDouble();
            lista.insertar(nodoActual.getDato(), valor);
        }
        if (nodoActual.getEnlaceIzq() != null) {
            asignarValoresALasVariables(nodoActual.getEnlaceIzq(), lista);
        }
        if (nodoActual.getEnlaceDer() != null) {
            asignarValoresALasVariables(nodoActual.getEnlaceDer(), lista);
        }
    }

    public ListaInfoDinamica extraerOperadores(){
        ListaInfoDinamica listaOperadores = new ListaInfoDinamica();
        extraerOperadores(this.raiz, listaOperadores);
        return listaOperadores;
    }

    private void extraerOperadores(NodoDoble nodoActual, ListaInfoDinamica lista){
        if (nodoActual == null) {
            return;
        }
        if (esOperador(nodoActual.getDato().toString())) {//Ver si el dato es un operador
            lista.insertar(nodoActual.getDato());
        }
        extraerOperadores(nodoActual.getEnlaceIzq(), lista);
        extraerOperadores(nodoActual.getEnlaceDer() ,lista);
    }

    private boolean esOperador(String dato){
        //Este metodo sirve para ver si el dato es un operador o variable
        if (dato.equals("+") || dato.equals("-") || dato.equals("*") || dato.equals("/") || dato.equals("^")) {
            return true;
        }else{
            return false;
        }
    }
}