package estructurasnolineales;

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

}