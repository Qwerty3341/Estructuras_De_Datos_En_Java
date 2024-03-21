package utilerias.comparador;

public class ComparadorDeObjetos {
    
    public static int comparar(Object primerElemento, Object segundoElemento) {
        //Aqui se verifican las instancias de los objetos que se pasan al método
        if (primerElemento instanceof String && segundoElemento instanceof String) {
           return compararStrings(primerElemento, segundoElemento);
        }
        if(primerElemento instanceof Number && segundoElemento instanceof Number) {
            return compararNumeros(primerElemento, segundoElemento);
        }
        else{
            return compararNull(primerElemento, segundoElemento);
        }
    
    }

    private static int compararStrings(Object primerElemento, Object segundoElemento){
        String stringA = (String) primerElemento;//Aqui solamente nos aseguramos de que los elementos sean strings
        String stringB = (String) segundoElemento;
        return stringA.compareTo(stringB);    
    }

    private static int compararNumeros(Object primerElemento, Object segundoElemento){
        Number elementoA = (Number) primerElemento;
        Number elementoB = (Number) segundoElemento;
        if ( elementoA.doubleValue() > elementoB.doubleValue()){ //Usamos el double para asegurarnos de comparar todo tipo de numeros
            return 1;
        }else if(elementoA.doubleValue() < elementoB.doubleValue()){
            return -1;
        }else{//Este es el caso de que los numeros sean iguales devolvemos el que sea
            return 0;
        }
    }

    private static int compararNull(Object primerElemento, Object segundoElemento){
        if (primerElemento == null && segundoElemento == null) {//Como un null es igual a null devolvemos 0
            return 0;
        }else if (primerElemento == null) {//En caso de comparar un elemento null con otro, se entiende que el otro elemento es mas grande
            return -1;
        }else{
            return 1;
        }
    }
}