package utilerias.matematicas;

import estructuraslineales.PilaInfoEstatica;

public class ExpresionesAritmeticas {
    
    public static Double evaluarInfija(String infija){
        //Este metodo llamaria primero a uno que convierta de infija a postfija o prefija posteriormente llamaria al metodo evaluarPostfija o evaluarPrefija

        return null;
    }

    public static Double evaluarPostFija(String postfija){
        PilaInfoEstatica pila = new PilaInfoEstatica(postfija.length());

        for (int posToken = 0; posToken < postfija.length() ; posToken++) {
            // 1 Tokenizar la expos de izq a der
            char token = postfija.charAt(posToken);
            // 2 si el token es operando meterlo en la pila 
            if (esOperando(token+"")==true) {
                if (pila.poner(token+"")==false) {
                    return null;
                }
            }else{//Es operador
                // 3 si el token es operador, sacar dos operandos de la pila (el primero extraido es op2) operacion finalmente meter el resultado parcial en la pila    
                String operando2 = (String) pila.quitar();
                String operando1 = (String) pila.quitar();

                if (operando1 != null && operando2 != null) {

                    Double resultadoParcial = operacion(Double.parseDouble(operando1), Double.parseDouble(operando2), token);

                    if (resultadoParcial != null) {
                        if (pila.poner(resultadoParcial+"") == false) {
                            return null;
                        }    
                        
                    }else{
                        return null;
                    }
                }else{//error
                    return null;
                }
            }
        }
        // 4 el resultado final esta en la pila 
        String resultado = (String) pila.quitar();
        if (resultado != null) {
            return Double.parseDouble(resultado) ;
        }
        else{
            return null;
        }
    }

    public static Double evaluarPrefija(String prefija){
        /*
         * 1. Tokenizar la expPos de derecha a izquierda.
         * 2. Si el token es operando, meterlo en la pila.
         * 3. Si el token es operador, sacar dos operandos de la pila
         * (el primero extraido es op1), aplicar la operacion;
         * finalmente meter el resultado parcial en la pila
         * 4. El resultado final esta en la pila
         */

         PilaInfoEstatica pila = new PilaInfoEstatica(prefija.length());

         for (int posToken = prefija.length() - 1; posToken >= 0 ; posToken--) {
             char token = prefija.charAt(posToken);
             if (esOperando(token+"")==true) {
                 if (pila.poner(token+"")==false) {
                     return null;
                 }
             }else{
                 String operando1 = (String) pila.quitar();
                 String operando2 = (String) pila.quitar();
                 
 
                 if (operando1 != null && operando2 != null) {
 
                     Double resultadoParcial = operacion(Double.parseDouble(operando1), Double.parseDouble(operando2), token);
 
                     if (resultadoParcial != null) {
                         if (pila.poner(resultadoParcial+"") == false) {
                             return null;
                         }    
                         
                     }else{
                         return null;
                     }
                 }else{//error
                     return null;
                 }
             }
         }
         // 4 el resultado final esta en la pila 
         String resultado = (String) pila.quitar();
         if (resultado != null) {
             return Double.parseDouble(resultado) ;
         }
         else{
             return null;
         }
    }

    public static String infijaPostfija (String infija){
        return "";
    }

    public static String infijaPrefija (String infija){
        return "";
    }

    public static boolean esOperando(String token){
        if(token.equals("+")==true){
            return false;
        }else if(token.equals("-")==true){
            return false;
        }else if(token.equals("*")==true){
            return false;
        }else if(token.equals("/")==true){
            return false;
        }else if(token.equals("^")==true){
            return false;
        }else if(token.equals("%")==true){
            return false;
        }else if(token.equals("(")==true){
            return false;
        }else if(token.equals(")")==true){
            return false;
        }else{
            return true;
        }
    }

    public static Double operacion(double operando1, double operando2, char operador){
        if (operador=='+') {
            return operando1+operando2;
        }else if (operador=='-') {
            return operando1-operando2;
        }else if (operador=='*') {
            return operando1*operando2;
        }else if (operador=='/') {
            if (operando2 == 0) {
                return null;
            }else{
                return operando1/operando2;
            }
        }else if (operador=='%') {
            return operando1%operando2;
        }else if (operador=='^') {
            return Math.pow(operando1 ,operando2);
        }else{
            return null;
        }
    }
}