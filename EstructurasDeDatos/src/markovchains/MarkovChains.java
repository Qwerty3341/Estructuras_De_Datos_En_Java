package markovchains;

import java.util.Random;
import entradasalida.SalidaPorDefecto;
import estructuraslineales.ListaInfoEstatica;
import estructuraslineales.ListaInfoEstaticaNumerica;
import estructurasnolineales.MatrizInfo2;

public final class MarkovChains {


    public static void RandomWalk(int n, int startState){
        int prevState = startState;
        //Aqui van los states
        ListaInfoEstatica state = new ListaInfoEstatica(4);
        state.insertar("Hamburguesa");
        state.insertar("Burrito");
        state.insertar("Nuggets");
        state.insertar("Pizza");

        //Esto veremos si lo manejamos como lista o matriz
        ListaInfoEstaticaNumerica pA = new ListaInfoEstaticaNumerica(4);
        
        //Probabilidades
        ListaInfoEstaticaNumerica p1 = new ListaInfoEstaticaNumerica(4);

        ListaInfoEstaticaNumerica p2 = new ListaInfoEstaticaNumerica(4);

        ListaInfoEstaticaNumerica p3 = new ListaInfoEstaticaNumerica(4);

        ListaInfoEstaticaNumerica p4 = new ListaInfoEstaticaNumerica(4);


        SalidaPorDefecto.consola(state.obtenerElemento(startState) + " ---> ");

        Random random = new Random();

        while (n > 1) {
            int currentState = randomChoice(state.cantidad(), (ListaInfoEstaticaNumerica) pA.obtener(prevState), random);
            SalidaPorDefecto.consola(state.obtenerElemento(currentState)+" ---> ");
            n--;
        }
        SalidaPorDefecto.consola("\nStop");
    }

    private static int randomChoice(int numStates, ListaInfoEstaticaNumerica probabilities, Random random){
        double rand = random.nextDouble();
        double cumulativeProbability = 0.0;
        for(int proba = 0; proba < numStates; proba++){
            cumulativeProbability += (Double) probabilities.obtenerElemento(proba);
            if (rand <= cumulativeProbability) {
                return proba;
            }
        }
        return numStates-1;
    }


    // private static MatrizInfo2 matrizAlCuadrado(MatrizInfo2 matrix) {
 
    // }




}