package estructuraslineales;

import entradasalida.SalidaPorDefecto;

public class ColaInfoEstatica implements LoteInfo{
    protected int posInicial;
    protected int posFinal;
    protected Object datos[];
    protected int CAPACIDAD;

    public ColaInfoEstatica(int tamanio){
        CAPACIDAD = tamanio;
        datos = new Object[CAPACIDAD];
        posFinal = -1;
        posInicial = -1;
    }

    public Object obtener(int index){
        return this.datos[index];
    }

    @Override
    public boolean poner(Object valor) {
        if(lleno() == false){
            if(vacio() == true){ // C)
                posInicial = 0;
                posFinal = 0;
                //datos[posFinal] = valor;
            }else if(posFinal == (CAPACIDAD - 1)){ // B)
                posFinal = 0;
                //datos[posFinal] = valor;
            }else{ // A) y E)
                posFinal = posFinal + 1;
                //datos[posFinal] = valor;
            }
            datos[posFinal] = valor;
            return true;

        }else{
            // c, no hay espacio
            return false;
        }
    }

    @Override
    public Object quitar() {
        if(vacio() == false){
            Object respaldo = null;
            if(posInicial == posFinal){ // E) (unico elemento)
                respaldo = datos[posInicial];
                posFinal = -1;
                posInicial = -1;    
            }else if(posInicial == (CAPACIDAD - 1)){ // C)
                respaldo = datos[posInicial];
                posInicial = 0;
            }else{ // A) y D)
                respaldo = datos[posInicial];
                posInicial = posInicial + 1;
            }
            return respaldo;
        }else{  // B) no hay nada
            return null;
        }
    }

    @Override
    public boolean vacio() {
        if(posInicial == -1){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean lleno() {
        if( (posInicial == 0 && posFinal == (CAPACIDAD - 1)) || (posInicial == (posFinal + 1))){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Object verFinal() {
        if(vacio() == false){
            return datos[posFinal];
        }else{
            return null;
        }
    }

    @Override
    public void mostrar() {
        if(vacio() == false){
            if(posInicial <= posFinal){ // Comportamiento ordinario a,e
                for(int pos = posInicial; pos <= posFinal; pos++){
                    SalidaPorDefecto.consola(datos[pos] +" ");
                }
            }else{ // circular c,d
                for(int pos = posInicial; pos <= CAPACIDAD-1; pos++){
                    SalidaPorDefecto.consola(datos[pos] +" ");
                }
                for(int pos = 0; pos <= posFinal; pos++){
                    SalidaPorDefecto.consola(datos[pos] +" ");
                }
            }
        }// b, no hacemos nada
    }
    
    public int getPosFinal() {
        return posFinal;
    }
    public int getTamanio(){
        return posFinal+1;
    }
}