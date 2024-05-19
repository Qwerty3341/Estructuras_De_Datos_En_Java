package gestordecampesinos;

import entradasalida.SalidaPorDefecto;

public class Menu {
    
    protected static String opciones ="""
    
    Promedio anual de toneladas por campesino = 1
    Mes de menos toneladas por año de los campesinos = 2
    Toneladas del último mes de cada año de los campesinos = 3
    Toneladas del segundo trimestre de cada año de los campesinos = 4
    Qué campesino ha realizado peor su trabajo en cada año = 5
    Mes con mayores dividendos a los campesinos = 6
    Época del año con mayor ganancia en producción = 7
    Salir = 8\n
    """;

    public static void mostrarse(){
        SalidaPorDefecto.consola(opciones);
    }
}
