package estructuraslineales;

import entradasalida.SalidaPorDefecto;
import utilerias.validador.ValidadorDeObjetos;

public class ListaInfoEstaticaNumerica extends ListaInfoEstatica{

    public ListaInfoEstaticaNumerica(int cuantos) {
        super(cuantos);
    }

    //Sobrescritura de metodos de clase padre
    @Override
    public Integer insertar(Object valor) {
        if(ValidadorDeObjetos.validarNumeros(valor) == true){
            posFinal = posFinal + 1;
            arreglo[posFinal] = ((Number) valor).doubleValue();
            return 1;
        }else{
            return -1;
        }
    }

    @Override
    public Object borrar(Object valor) {
        if (ValidadorDeObjetos.validarNumeros(valor) == true) {
            return super.borrar(valor);    
        }else{
            return false;
        }
    }

    @Override
    public Object encontrar(Object valor) {
        if(ValidadorDeObjetos.validarNumeros(valor) == true){
            return super.encontrar(valor);
        }else{
            return false;
        }
    }

    @Override
    public boolean cambiar(int indice, Object valor) {
        if(ValidadorDeObjetos.validarNumeros(valor) == true){
            return super.cambiar(indice, valor);
        }else{
            return false;
        }
    }

    @Override
    public ListaInfoEstatica subLista(ListaInfoEstaticaNumerica listaIndices) {
        ListaInfoEstatica arregloDeIndices = new ListaInfoEstatica(listaIndices.capacidad());//Se pone la cantidad al nuevo arreglo
        for (int indN = 0; indN < arregloDeIndices.cantidad(); indN++){
            if (ValidadorDeObjetos.validarNumeros(listaIndices.arreglo[indN])==true) {
                arregloDeIndices.insertar(listaIndices.arreglo[indN]);//Agregamos los indices al otro arreglo
            }
        }
        return arregloDeIndices;
    }

    //Metodos especificos para la clase 
    public boolean porEscalar(Number escalar) {
        if(this.estaVacia() == true){//validar que no este vacia
            return false;
        }else{
            for (int posicion = 0; posicion < this.capacidad(); posicion++) {
                this.arreglo[posicion] = (Double) arreglo[posicion] * escalar.doubleValue();
            }
            return true;
        }
    }
    
    public boolean sumarEscalar(Number escalar){
        if(this.estaVacia() == true){//validar que no este vacia
            return false;
        }else{
            for (int posicion = 0; posicion < this.capacidad(); posicion++) {
                this.arreglo[posicion] = (double) arreglo[posicion] + escalar.doubleValue();
            }
            return true;
        }
    }

    public boolean sumar(ListaInfoEstaticaNumerica lista2){
        if (this.cantidad() == lista2.cantidad()) {
            for(int indexListas = 0; indexListas < this.cantidad() ; indexListas++){
                double suma = (Double) this.arreglo[indexListas] + (Double) lista2.arreglo[indexListas];
                this.arreglo[indexListas] = suma;//se sobreescribe
            }
            return true;
        }else{
            return false;
        }
    }

    public boolean multiplicar(ListaInfoEstaticaNumerica lista2){
        if (this.cantidad() == lista2.cantidad()) {//Se hace lo mismo que en sumar
            for(int indexListas = 0; indexListas < this.cantidad() ; indexListas++){
                double mult = (double)this.arreglo[indexListas] * (double) lista2.arreglo[indexListas];
                this.arreglo[indexListas] = mult;
            }
            return true;
        }else{
            return false;
        }
    }

    public boolean aplicarPotencia(Number escalar){
        if(ValidadorDeObjetos.validarNumeros(escalar)==false){//Se hacen las validaciones
            return false;
        }
        else if(this.estaVacia()==true){
            return false;
        }
        else{//se aplica la potencia con math.pow
            int escalarEntero = (int)escalar;
            for(int elementoAPotenciar = 0; elementoAPotenciar < cantidad() ;elementoAPotenciar++){
                double elem = (Double) this.obtener(elementoAPotenciar);
                this.arreglo[elementoAPotenciar] = Math.pow(elem,escalarEntero);
            }
            return true;
        }
    }

    public double productoEscalar(ListaInfoEstaticaNumerica lista2){
        double mult = 0;
        double suma = 0; //Hacemos las variables para hacer sumas
        if(this.cantidad() == lista2.cantidad()){
            for (int index = 0; index < this.cantidad(); index++) {
                mult = (double) this.arreglo[index] * (double) lista2.arreglo[index];
                suma = suma + mult;
            }
        }    
        return (double) suma;
    }

    public double norma(){
        double sumaDeNorma=0;//Aqui sumamos los elementos al cuadrado
        for (int objeto = 0; objeto < this.cantidad(); objeto++) {
            double objetoCuadrado = Math.pow((double)arreglo[objeto], 2);
            sumaDeNorma = sumaDeNorma+objetoCuadrado;
        }
        //Le sacamos la raiz cuadrada
        return Math.sqrt(sumaDeNorma);
    }

    public double normaEuclidiana(ListaInfoEstaticaNumerica arreglo2){
        double sumaDeRestasAlCuadrado = 0;//hacemos una variable que contenga las sumas de todas las restas
        for(int numero=0; numero < this.cantidad(); numero++){
            double b = (double) arreglo2.arreglo[numero];//convertimos los elementos a dobles
            double a = (double) this.arreglo[numero];
            double restaAlCuadrado = Math.pow( b - a, 2);//hacemos las restas
            sumaDeRestasAlCuadrado = sumaDeRestasAlCuadrado + restaAlCuadrado;//sobrescribimos la suma de restas
        }
        double normaEuclidiana = Math.sqrt(sumaDeRestasAlCuadrado);
        return normaEuclidiana;
    }

    public boolean sumarListaEstatica(ListaInfoEstatica listas){
        for (int listaN = 0; listaN < listas.capacidad(); listaN++) {
            ListaInfoEstaticaNumerica listaParaSumar = (ListaInfoEstaticaNumerica) listas.arreglo[listaN];
            if (listaParaSumar != null) {
                for (int valor = 0; valor < this.capacidad(); valor++) {
                    double suma = (double) this.arreglo[valor] + (double) listaParaSumar.arreglo[valor];
                    this.arreglo[valor] = suma;
                }
            }
        }  
        return true;
    }
    
    public boolean sumarEscalares(ListaInfoEstaticaNumerica escalares){
        if (escalares.cantidad() == this.cantidad()) {
            for(int escN=0; escN < this.cantidad() ;escN++){
                escalares.arreglo[escN] = (double) this.arreglo[escN] + (double) escalares.arreglo[escN];
            }
            escalares.mostrar();
            return true;
        }else{
            return false;
        }
    }

    public double sumarIndices(ListaInfoEstaticaNumerica listaIndices){
        double sumaDeIndices = 0;//Hago una variable para almacenar los indices del arreglo actual
        for(int indN=0; indN < listaIndices.capacidad(); indN++){
            int indice = listaIndices.posFinal;
            sumaDeIndices += (double) this.arreglo[indice];
        }
        return sumaDeIndices;
    }

    public boolean sonLinealmenteDependientes(ListaInfoEstatica listaVectores){
        throw new UnsupportedOperationException("ERROR");
    }

    public boolean sonLinealmenteIndependientes(ListaInfoEstatica listaVectores){
        throw new UnsupportedOperationException("ERROR");
    }

    public boolean esOrtogonal(ListaInfoEstaticaNumerica lista2){
        if (productoEscalar(lista2) == 0){ //se usa la funcion de producto escalar
            return true;
        }else{
            return false;
        }
    }

    public boolean esParalelo(ListaInfoEstaticaNumerica lista2){
        ListaInfoEstatica escalares = new ListaInfoEstatica(lista2.CAPACIDAD);
        for (int indN = 0; indN < this.capacidad(); indN++) {//Sacamos todos los escalares
            double unEscalar = (double) this.arreglo[indN] / (double) lista2.arreglo[indN];
            escalares.insertar(unEscalar);
        }
        //Hacemos la comprobacion
        int contadorDeIguales = 0;
        for (int esc = 0; esc < this.posFinal; esc++) {
            if (escalares.arreglo[esc].equals(escalares.arreglo[esc+1])) {
                contadorDeIguales = contadorDeIguales + 1;
            }
        }
        if (contadorDeIguales == this.posFinal) {
            return true;
        }else{
            return false;
        }
    }

    //practica6
    public void hacerArreglo(double[] arr) {
        redimensionar(arr.length);
        for (int lug = 0; lug < arr.length; lug++) {
            insertar(arr[lug]);
        }
    }
    
    @Override
    public Double[] leerArreglo() {
        Double[] copia = new Double[CAPACIDAD];
        for (int lug = 0; lug < CAPACIDAD; lug++) {
            copia[lug] = (Double) arreglo[lug];
        }
        return copia;
    }

    public void mostrarNumerico(){
        for(int posIndice = 0; posIndice < this.cantidad(); posIndice++ ){
            SalidaPorDefecto.consola("|"+arreglo[posIndice]);
        }
        SalidaPorDefecto.consola("|");
    }
        
}
