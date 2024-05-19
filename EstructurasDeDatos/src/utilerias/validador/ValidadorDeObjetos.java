package utilerias.validador;

public class ValidadorDeObjetos {
 
    public static Boolean validarNumeros(Object unObjeto){
        if(unObjeto instanceof Number){
            return true;
        }else{
            return false;
        }
    }

    public static Boolean validarNumeros(Object unObjeto, Object otroObjeto){
        if(unObjeto instanceof Number && otroObjeto instanceof Number){
            return true;
        }else{
            return false;
        }
    }
}
