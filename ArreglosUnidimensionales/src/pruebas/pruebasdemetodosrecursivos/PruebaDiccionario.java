package pruebas.pruebasdemetodosrecursivos;

import entradasalida.SalidaPorDefecto;
import estructuraslineales.ListaInfoDinamica;
import estructuraslineales.diccionario.Contenido;
import estructuraslineales.diccionario.Diccionario;

public class PruebaDiccionario {
    public static void main(String[] args) {
        Diccionario unDiccionario = new Diccionario();
        //Alta nuevos conceptos
        SalidaPorDefecto.consola("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        Contenido c1 = new Contenido("importante", "Que importa", "significativo, interesante, sustancial, notable, primordial, fundamental", null);
        unDiccionario.darAltaNuevosConceptosConDefinicion(c1.getConcepto(), c1.getComplementosDelConcepto());
        Contenido c2 = new Contenido("Educar", "Proceso de facilitar el aprendizaje", "Instruir, enseñar", null);
        unDiccionario.darAltaNuevosConceptosConDefinicion(c2.getConcepto(), c2.getComplementosDelConcepto());

        Contenido c3 = new Contenido("Valor", "Grado de utilidad o aptitud de las cosas", "Valía, mérito", null);
        unDiccionario.darAltaNuevosConceptosConDefinicion(c3.getConcepto(), c3.getComplementosDelConcepto());

        Contenido c4 = new Contenido("Democracia", "Forma de gobierno en la que el poder político es ejercido por los ciudadanos", "Gobierno del pueblo", null);
        unDiccionario.darAltaNuevosConceptosConDefinicion(c4.getConcepto(), c4.getComplementosDelConcepto());

        Contenido c5 = new Contenido("Justicia", "Principio moral que lleva a dar a cada uno lo que le corresponde", "Equidad, imparcialidad", null);
        unDiccionario.darAltaNuevosConceptosConDefinicion(c5.getConcepto(), c5.getComplementosDelConcepto());

        Contenido c6 = new Contenido("Libertad", "Capacidad de actuar según la propia voluntad", "Independencia, libre albedrío", null);
        unDiccionario.darAltaNuevosConceptosConDefinicion(c6.getConcepto(), c6.getComplementosDelConcepto());

        Contenido c7 = new Contenido("Amor", "Sentimiento de afecto universal que se tiene hacia una persona, animal o cosa", "Afecto, querer", null);
        unDiccionario.darAltaNuevosConceptosConDefinicion(c7.getConcepto(), c7.getComplementosDelConcepto());

        Contenido c8 = new Contenido("Paz", "Estado de tranquilidad o quietud, ausencia de perturbación o conflicto", "Calma, serenidad", null);
        unDiccionario.darAltaNuevosConceptosConDefinicion(c8.getConcepto(), c8.getComplementosDelConcepto());

        Contenido c9 = new Contenido("Cultura", "Conjunto de conocimientos que permite a alguien desarrollar su juicio crítico", "Educación, conocimientos", null);
        unDiccionario.darAltaNuevosConceptosConDefinicion(c9.getConcepto(), c9.getComplementosDelConcepto());

        Contenido c10 = new Contenido("Arte", "Actividad humana que crea obras principalmente estéticas", "Creatividad, expresión", null);
        unDiccionario.darAltaNuevosConceptosConDefinicion(c10.getConcepto(), c10.getComplementosDelConcepto());
        unDiccionario.imprimir();

        //Consultar conceptos
        SalidaPorDefecto.consola("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        SalidaPorDefecto.consola("Consultando amor y libertad:\n");
        SalidaPorDefecto.consola("\n"+unDiccionario.consultarConceptosYDefinicion("Amor", 0));
        SalidaPorDefecto.consola("\n"+unDiccionario.consultarConceptosYDefinicion("Libertad", 0));
        
        //Buscar palabras clave 
        SalidaPorDefecto.consola("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
}