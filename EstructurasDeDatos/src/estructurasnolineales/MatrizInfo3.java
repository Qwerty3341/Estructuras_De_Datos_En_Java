package estructurasnolineales;

import entradasalida.SalidaPorDefecto;

public class MatrizInfo3 {
    
    protected Object arreglo[][][];
    protected int renglones;
    protected int columnas;
    protected int profundidades;

    public MatrizInfo3(int rengs, int cols, int profs) {
        renglones = rengs;
        columnas = cols;
        profundidades = profs;
        arreglo = new Object[renglones][columnas][profundidades];
    }

    public Object[][][] getArreglo() {
        return arreglo;
    }

    public int getRenglones() {
        return renglones;
    }

    public int getColumnas() {
        return columnas;
    }

    public int getProfundidades() {
        return profundidades;
    }

    private boolean validarIndices(int indice, int dimensionMax){
        if (indice >=0 && indice < dimensionMax) {
            return true;
        }else{
            return false;
        }
    }

    public void rellenar(Object valor){
        for (int cadaRenglon = 0; cadaRenglon < renglones ; cadaRenglon++) {
            //Para mi solo existe un renglon 
            for (int cadaColumna = 0; cadaColumna < columnas; cadaColumna++) {                
                //Para mi solo existe una columna
                for (int cadaProf = 0; cadaProf < profundidades; cadaProf++) {
                    arreglo[cadaRenglon][cadaColumna][cadaProf] = valor;
                }
            }
        }
    }

    public void mostrarXColumna(){
        for (int cadaRebanada = 0; cadaRebanada < columnas ; cadaRebanada++) {
            //Voy a procesar una rebanada
            for(int cadaRenglon = 0; cadaRenglon < renglones ; cadaRenglon++){
                //Un renglon tiene varias columnas
                for(int cadaColumna = 0 ; cadaColumna < profundidades ; cadaColumna++){
                    SalidaPorDefecto.consola(arreglo[cadaRenglon][cadaRebanada][cadaColumna]+" ");
                }
                SalidaPorDefecto.consola("\n");
            }
            SalidaPorDefecto.consola("\n");
        }
    }

    public Object obtener(int reng, int col, int prof){
        if(validarIndices(reng, renglones) == true && validarIndices(prof, columnas) == true && validarIndices(prof, profundidades) == true){
            return arreglo[reng][col][prof];
        }else{//No es un indice valido
            return null;
        }
    }

    public boolean cambiar(int reng, int col, int prof, Object valor){
        if(validarIndices(reng, renglones) == true && validarIndices(prof, columnas) == true && validarIndices(prof, profundidades) == true){
            arreglo[reng][col][prof] = valor;
            return true;
        }else{//No es un indice valido
            return false;
        }
    }


}