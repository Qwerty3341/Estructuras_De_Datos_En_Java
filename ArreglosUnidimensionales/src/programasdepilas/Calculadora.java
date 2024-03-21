package programasdepilas;

import estructuraslineales.PilaInfoEstatica;

public class Calculadora {
    
    public static void calcular(String expresion){
        
    }

    public static String pasarAPostfija(String infija) {
        //Aqui defino el tamanio de la pila
        int lon = 0;
        for(char unCaracter : infija.toCharArray()){
            lon = lon + 1;
        }
        PilaInfoEstatica pilaDeOperadores = new PilaInfoEstatica(lon);//almacen de operadores
        String postfija = "";
        //Aqui hago la iteracion de los elementos para acomodarlos
        for (int iteracion = 0; iteracion < lon; iteracion++) {
            if (infija.charAt(iteracion) >= '0' && infija.charAt(iteracion) <= '9') {//Ver si es un numero
                postfija = postfija + infija.charAt(iteracion);
            }
            if (infija.charAt(iteracion) >= 'a' && infija.charAt(iteracion) <= 'z') {
                postfija = postfija + infija.charAt(iteracion);
            }
            if (infija.charAt(iteracion) >= '*' & (infija.charAt(iteracion) <= '/')) { 
                pilaDeOperadores.poner(infija.charAt(iteracion));
            }
            if (infija.charAt(iteracion) == ')') {
                postfija = postfija + pilaDeOperadores.quitar();
            }
        }        
        while (pilaDeOperadores.vacio() == false) {
            postfija = postfija + pilaDeOperadores.quitar();
        }
        return postfija;
    }

    public static int gerarquia(Character caracter) {
        switch (caracter) {
            case '*':
                return 1;
            case '/':
                return 1;
            case '+':
                return 0;
            case '-':
                return 0;
            default:
                return -1;
        }
    }
}