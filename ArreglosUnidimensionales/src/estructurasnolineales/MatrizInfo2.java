package estructurasnolineales;

import entradasalida.SalidaPorDefecto;
import estructuraslineales.ListaInfoEstatica;
import utilerias.comunes.TipoColumna;
import utilerias.comunes.TipoRenglon;

public class MatrizInfo2 {
    
    protected int filas;
    protected int columnas;
    protected Object valor;
    protected Object[][] arreglo;

    public MatrizInfo2(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.valor = null;//Pongo el valor como null para indicar que no se uso el segundo constructor
        this.arreglo = new Object[filas][columnas];
    }

    public MatrizInfo2(int filas, int columnas, Object valor) {
        this.filas = filas;
        this.columnas = columnas;
        this.valor = valor;
        this.arreglo = new Object[filas][columnas];
        
        for (int fil = 0; fil < this.filas; fil++) {
            for (int col = 0; col < this.columnas; col++) {
                this.arreglo[fil][col] = valor;
            }
        }
    }

    public void imprimir() {
        for (int fil = 0; fil < arreglo.length; fil++) {
            for (int col = 0; col < arreglo[0].length; col++) {
                SalidaPorDefecto.consola(this.arreglo[fil][col] + " ");
            }
            SalidaPorDefecto.consola("\n");
        }
    }
    
    public Object obtener(int fila, int col){
        int filaMenosUno = fila -1;//Restamos el numero de filas ya que se cuentan desde 0
        int colMenosUno = col -1;
        if (filaMenosUno < this.filas && colMenosUno < this.columnas) {
            return this.arreglo[filaMenosUno][colMenosUno];  
        }else{
            throw new IndexOutOfBoundsException("Out of bounds");
        }
    }

    public boolean cambiar(int fila, int col, Object valor){
        if (fila < this.filas && col < this.columnas) {
            this.arreglo[fila][col] = valor;
            return true;
        }else{//Aqui es que el elemento no existe
            return false;
        }
    }

    public int obtenerRenglones(){
        int numDeElementos = 0;
        for(int fil = 0; fil < this.filas; fil++){
            for(int col = 0; col < this.columnas; col++){
                if (this.arreglo[fil][col] != null) {
                    numDeElementos = numDeElementos + 1;
                }
            }
        }
        return numDeElementos;
    }

    public int obtenerColumnas(){
        int numDeElementos = 0;
        for (int col = 0; col < this.columnas; col++) {
            for (int fil = 0; fil < this.filas; fil++) {
                if (this.arreglo[fil][col] != null) {
                    numDeElementos++;
                }
            }
        }
        return numDeElementos;        
    }

    public void imprimirXRenglones(){
        for(int fil = 0; fil < this.filas; fil++){
            SalidaPorDefecto.consola(fil+" ");
            for(int col = 0; col < this.columnas; col++){
               SalidaPorDefecto.consola(this.arreglo[fil][col]+" ");//Se imprime el elemento 
            }
            SalidaPorDefecto.consola(" ");
        }
    }

    public void imprimirXColumnas() {
        for (int col = 0; col < this.columnas; col++) {
            SalidaPorDefecto.consola("\t" + col);//Aqui pongo el numero de columnas
        }
        for (int fil = 0; fil < this.filas; fil++) { //Y aqui son las columnas
            SalidaPorDefecto.consola("\n");
            for (int col = 0; col < this.columnas; col++) {
                SalidaPorDefecto.consola("\t" + this.arreglo[fil][col]);
            }
        }
    }
    
    public void transpuesta() {
        MatrizInfo2 matrizTranspuesta = new MatrizInfo2(this.columnas, this.filas);//Defino una nueva matriz para evitar errores de dimensiones 
        for (int fila = 0; fila < this.filas; fila++) {
            for (int columna = 0; columna < this.columnas; columna++) {
                matrizTranspuesta.arreglo[columna][fila] = this.arreglo[fila][columna];//Aqui se agregan los elementos de las filas en los de las columnas 
            }
        }
        this.redefinir(matrizTranspuesta);
    }
    
    public void rellenar(Object valor){
        this.valor = valor;
        for (int fil = 0; fil < this.filas; fil++) {//Uso los dos for para recorrer cada casilla
            for (int col = 0; col < this.columnas; col++) {
                this.arreglo[fil][col] = valor;
            }
        }
    }

    public MatrizInfo2 clonar(){
        //Hacemos una variable copia con los valores de la matriz actual
        MatrizInfo2 copia = new MatrizInfo2(this.filas, this.columnas, this.valor);
        return copia;
    }

    public boolean esIgual(MatrizInfo2 matriz2){
        if(this.filas == matriz2.filas && this.columnas == matriz2.columnas){
            int igualdadesDefinidas = this.filas * this.columnas;//Esto es la cantidad de elementos que hay
            int igualdades = 0;
            for (int fil = 0; fil < this.filas; fil++) {
                for (int col = 0; col < this.columnas; col++) {
                    if(this.arreglo[fil][col] == null && matriz2.arreglo[fil][col] == null){//Verificamos primero si es null para evitar errores
                        igualdades = igualdades + 1;
                    }
                    else if (this.arreglo[fil][col].equals(matriz2.arreglo[fil][col])) {
                        igualdades = igualdades + 1;
                    }
                }
            }
            if (igualdades == igualdadesDefinidas) {
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    public boolean vectorColumna(int filas, Object info) {
        if (filas <= 0) {
            return false;//Comprobamos las filas 
        }
        Object[] nuevoVectorColumna = new Object[filas];
        for (int fil = 0; fil < filas; fil++) {//
            nuevoVectorColumna[fil] = info;
        }
        this.arreglo = new Object[filas][1];//Redimensionamos el arreglo con los nuevos valores
        for (int fil = 0; fil < filas; fil++) {
            this.arreglo[fil][0] = nuevoVectorColumna[fil];
        }
        this.filas = filas;
        this.columnas = 1; 
        return true;
    }
    
    public boolean vectorRenglon(int columnas, Object info) {
        if (columnas <= 0) {
            return false;
        }
        Object[] nuevoVectorRenglon = new Object[columnas];//hacemos el nuevo arreglo
        for (int col = 0; col < columnas; col++) {
            nuevoVectorRenglon[col] = info;
        }
        this.arreglo = new Object[1][columnas]; //Ponemos una sola fila 
        for (int col = 0; col < columnas; col++) {
            this.arreglo[0][col] = nuevoVectorRenglon[col];
        }
        this.filas = 1; 
        this.columnas = columnas;
        return true;
    }

    public void redefinir(MatrizInfo2 nuevaMatriz) {
        this.filas = nuevaMatriz.filas;
        this.columnas = nuevaMatriz.columnas;
        this.arreglo = nuevaMatriz.arreglo;
    }    

    public boolean agregarRenglon(ListaInfoEstatica lista){
        if(lista.capacidad() == this.filas){
            MatrizInfo2 matrizRedimensionadora = new MatrizInfo2(this.filas+1, columnas);//Uso esta matriz para reddefinir los nuevos espacios de la matriz
            this.redefinir(matrizRedimensionadora);
            int contador = 0;

            for (int fil = this.filas-1; fil == this.filas-1 ;fil++) {//Hacemos un ciclo para solo iterar en la ultima fila
                for (int col = 0; col < this.columnas ; col++) {
                    if (this.arreglo[fil][col] == null) {
                        this.arreglo[fil][col] = lista.obtener(contador);
                        contador = contador+1;
                    }
                }                
            }
            return true;
        }else{
            return false;
        }
    }

    public boolean agregarColumna(ListaInfoEstatica lista){
        if(lista.capacidad() == this.filas){
            MatrizInfo2 matrizRedimensionadora = new MatrizInfo2(filas, columnas+1);//Uso esta matriz para reddefinir los nuevos espacios de la matriz
            this.redefinir(matrizRedimensionadora);
            int contador = 0;

            for (int fil = 0; fil < this.filas ;fil++) {//Hacemos un ciclo para solo iterar en la ultima columna agregada
                for (int col = this.columnas-1; col == this.columnas-1 ; col++) {
                    if (this.arreglo[fil][col] == null) {
                        this.arreglo[fil][col] = lista.obtener(contador);
                        contador = contador+1;
                    }
                }                
            }
            return true;
        }else{
            return false;
        }
    }

    public boolean agregarMatrizXColumna(MatrizInfo2 matriz2) {
        if (matriz2.filas != this.filas) {
            return false;
        }
        MatrizInfo2 matrizRedimensionadora = new MatrizInfo2(this.filas, this.columnas + matriz2.columnas);
        for (int fila = 0; fila < this.filas; fila++) {
            for (int columna = 0; columna < this.columnas; columna++) {
                matrizRedimensionadora.arreglo[fila][columna] = this.arreglo[fila][columna];
            }
        }
        for (int fila = 0; fila < this.filas; fila++) {
            for (int columna = 0; columna < matriz2.columnas; columna++) {
                matrizRedimensionadora.arreglo[fila][this.columnas + columna] = matriz2.arreglo[fila][columna];
            }
        }
        this.redefinir(matrizRedimensionadora);
        return true;
    }
    
    public boolean agregarMatrizXRenglon(MatrizInfo2 matriz2) {
        if (matriz2.columnas != this.columnas) {
            return false;
        }
        MatrizInfo2 matrizRedimensionadora = new MatrizInfo2(this.filas + matriz2.filas, this.columnas);
        for (int fila = 0; fila < this.filas; fila++) {
            for (int columna = 0; columna < this.columnas; columna++) {
                matrizRedimensionadora.arreglo[fila][columna] = this.arreglo[fila][columna];
            }
        }
        for (int fila = 0; fila < matriz2.filas; fila++) {
            for (int columna = 0; columna < this.columnas; columna++) {
                matrizRedimensionadora.arreglo[this.filas + fila][columna] = matriz2.arreglo[fila][columna];
            }
        }
        this.redefinir(matrizRedimensionadora);
        return true;
    }
    
    // public MatrizInfo3 aMatriz3(ListaInfoEstatica matrices) {

    //     return matriz3D;
    // }

    public MatrizInfo2 aVectorColumna() {
        int totalElementos = this.filas * this.columnas;//cantidad total de elementos de la matriz
        Object[] vectorColumna = new Object[totalElementos];//definimos el vector
        int indice = 0;
        for (int col = 0; col < this.columnas; col++) {
            for (int fil = 0; fil < this.filas; fil++) {
                vectorColumna[indice++] = this.arreglo[fil][col];
            }
        }
        MatrizInfo2 vectorColumnaMatriz = new MatrizInfo2(totalElementos, 1);
        vectorColumnaMatriz.arreglo = new Object[totalElementos][1];
        for (int can = 0; can < totalElementos; can++) {//ponemos las cosas en el vector
            vectorColumnaMatriz.arreglo[can][0] = vectorColumna[can];
        }
        return vectorColumnaMatriz;
    }
    
    public MatrizInfo2 aVectorRenglon() {
        int totalElementos = this.filas * this.columnas;//Hacemos la misma logica que el de aVectorColumna
        Object[] vectorRenglon = new Object[totalElementos];
        int indice = 0;
        for (int fil = 0; fil < this.filas; fil++) {
            for (int col = 0; col < this.columnas; col++) {
                vectorRenglon[indice++] = this.arreglo[fil][col];
            }
        }
        MatrizInfo2 vectorRenglonMatriz = new MatrizInfo2(1, totalElementos);
        vectorRenglonMatriz.arreglo = new Object[1][totalElementos];
        for (int iter = 0; iter < totalElementos; iter++) {
            vectorRenglonMatriz.arreglo[0][iter] = vectorRenglon[iter];
        }
        return vectorRenglonMatriz;
    }
    
    public boolean quitarRenglon(TipoRenglon tipoRenglon){
        if(tipoRenglon.equals(tipoRenglon.ARRIBA)){
            var primeraFila = 0;
            this.eliminarRenglon(primeraFila);
            return true;
        }
        else if(tipoRenglon.equals(tipoRenglon.ABAJO)){
            var ultimaFila = this.filas-1;
            this.eliminarRenglon(ultimaFila);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean quitarColumna(TipoColumna tipoCol){
        if(tipoCol.equals(tipoCol.IZQ)){//Hacemos lo mismo que en quitar renglones
            var primeraColumna = 0;
            this.eliminarColumna(primeraColumna);
            return true;
        }
        else if(tipoCol.equals(tipoCol.DER)){
            var ultimaColumna = this.columnas-1;
            this.eliminarColumna(ultimaColumna);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean eliminarRenglon(int fila) {
        if (fila < 0 || fila >= this.filas) {
            return false; 
        }
        MatrizInfo2 matrizRedimensionadora = new MatrizInfo2(this.filas - 1, this.columnas);
        for (int fil = 0; fil < fila; fil++) {
            for (int col = 0; col < this.columnas; col++) {
                matrizRedimensionadora.arreglo[fil][col] = this.arreglo[fil][col];
            }
        }
        for (int fil = fila + 1; fil < this.filas; fil++) {
            for (int col = 0; col < this.columnas; col++) {
                matrizRedimensionadora.arreglo[fil - 1][col] = this.arreglo[fil][col];
            }
        }
        this.redefinir(matrizRedimensionadora);
        return true;
    }
    
    public boolean eliminarColumna(int columna) {
        if (columna < 0 || columna >= this.columnas) {
            return false; 
        }
        MatrizInfo2 matrizRedimensionadora = new MatrizInfo2(this.filas, this.columnas - 1);
        for (int fil = 0; fil < this.filas; fil++) {
            for (int col = 0; col < columna; col++) {
                matrizRedimensionadora.arreglo[fil][col] = this.arreglo[fil][col];
            }
        }
        for (int fil = 0; fil < this.filas; fil++) {
            for (int col = columna + 1; col < this.columnas; col++) {
                matrizRedimensionadora.arreglo[fil][col - 1] = this.arreglo[fil][col];
            }
        }
        this.redefinir(matrizRedimensionadora);
        return true;
    }
    
}