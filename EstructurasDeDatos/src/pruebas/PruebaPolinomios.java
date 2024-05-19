package pruebas;

import entradasalida.SalidaPorDefecto;
import polinomios.Monomio;
import polinomios.Polinomio;

public class PruebaPolinomios {
    public static void main(String[] args) {
        Polinomio polinomio = new Polinomio(3); 
        polinomio.aniadirMonomio(new Monomio(10, 2, 3));
        polinomio.aniadirMonomio(new Monomio(3, 3, 4));
        polinomio.aniadirMonomio(new Monomio(1, 1, 2));
        SalidaPorDefecto.consola("Evaluando polinomio:\n");
        SalidaPorDefecto.consola(polinomio.toString()+"\n");

        double x = 1.0; 
        double y = 1.0; 
        double resultado = polinomio.evaluar(x, y);
        SalidaPorDefecto.consola("x=" + x + ", y=" + y+"\n");
        SalidaPorDefecto.consola("resultado = "+resultado);
    }
}
