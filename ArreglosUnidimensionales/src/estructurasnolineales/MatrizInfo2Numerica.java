package estructurasnolineales;

import entradasalida.SalidaPorDefecto;
import estructuraslineales.ListaInfoEstaticaNumerica;
import utilerias.comunes.TipoLogaritmo;
import utilerias.validador.ValidadorDeObjetos;

public class MatrizInfo2Numerica extends MatrizInfo2{
    
    public MatrizInfo2Numerica(int filas, int columnas){
        super(filas, columnas);
        this.valor = null;
    }

    public MatrizInfo2Numerica(int filas, int columnas, Object valor){
        super(filas, columnas);
        if (ValidadorDeObjetos.validarNumeros(valor) == true) {
            this.valor = ((Number) valor).doubleValue();
            this.rellenar(valor);
        }else{
            SalidaPorDefecto.consola("Solo se aceptan Numbers");
        }
    }
    
    //Sobrescritura de algunos metodos
    
    public void cambiar(int fila, int col, Number valor) {
        this.arreglo[fila][col] = valor.doubleValue();
    }

    @Override
    public void rellenar(Object valor) {
        if (ValidadorDeObjetos.validarNumeros(valor) == true) {
            double valorDoble = ((Number) valor).doubleValue();
            super.rellenar(valorDoble);
        }else{
            SalidaPorDefecto.consola("El valor pasado como argumento no es un Number");
        }
    }

    public Double obtener(int fila, int col) {
        int filaMenosUno = fila -1;//Restamos el numero de filas ya que se cuentan desde 0
        int colMenosUno = col -1;
        if (filaMenosUno < this.filas && colMenosUno < this.columnas) {
            return (Double) this.arreglo[filaMenosUno][colMenosUno];  
        }else{
            throw new IndexOutOfBoundsException("Out of bounds");
        }
    }

    @Override
    public boolean vectorColumna(int filas, Object info) {
        if (ValidadorDeObjetos.validarNumeros(info) == true) {
            double infoDoble = (Double) info;
            return super.vectorColumna(filas, infoDoble);    
        }else{
            return false;//El objeto info no es Number
        }
    }

    @Override
    public boolean vectorRenglon(int columnas, Object info) {
        if (ValidadorDeObjetos.validarNumeros(info) == true) {
            double infoDoble = (Double) info;
            return super.vectorRenglon(columnas, infoDoble);
        }else{
            return false;
        }
    }

    //Metodos de la clase     

    public boolean porEscalar(Number escalar){
        for (int fil = 0; fil < this.filas; fil++) {
            for (int col = 0; col < this.columnas; col++) {
                double valorActual = (double) this.arreglo[fil][col];//Convertimos el elemento a double
                double resultado = valorActual * escalar.doubleValue();
                this.arreglo[fil][col] = resultado;
            }
        }
        return true;
    }    

    public boolean porEscalares(ListaInfoEstaticaNumerica escalares){
        if(escalares.capacidad() != this.columnas){
            return false;//Aqui es las dimensiones de los objetos no son compatibles
        }
        for (int fil = 0; fil < this.filas; fil++) {
            for (int col = 0; col < this.columnas; col++) {
                double operando1 = (Double) this.arreglo[fil][col];
                double operando2 = (Double) escalares.obtener(col);
                double operacion = (Double) operando1 * operando2;
                this.arreglo[fil][col] = operacion;
            }
        }
        return true;
    }

    public boolean sumarEscalar(Number escalar){
        for (int fil = 0; fil < this.filas; fil++) {//Hacemos el mismo procesimiento que en por escalar.
            for (int col = 0; col < this.columnas; col++) {
                double valorActual = (double) this.arreglo[fil][col];//Convertimos el elemento a double
                double resultado = valorActual + escalar.doubleValue();
                this.arreglo[fil][col] = resultado;
            }
        }
        return true;
    }

    public boolean sumarEscalares(ListaInfoEstaticaNumerica escalares){
        if(escalares.capacidad() != this.columnas){
            return false;//Aqui es las dimensiones de los objetos no son compatibles
        }
        for (int fil = 0; fil < this.filas; fil++) {
            for (int col = 0; col < this.columnas; col++) {
                double operando1 = (Double) this.arreglo[fil][col];
                double operando2 = (Double) escalares.obtener(col);
                double operacion = (Double) operando1 + operando2;
                this.arreglo[fil][col] = operacion;
            }
        }
        return true;
    }

    public boolean multiplicar( MatrizInfo2Numerica matriz2){
        if (this.columnas != matriz2.filas) {
            return false;//No se pueden multiplicar
        }
        //Esta es la matriz que nos debe de salir si es que se pueden multiplicar
        MatrizInfo2Numerica matrizResultante = new MatrizInfo2Numerica(this.filas, matriz2.columnas);//Defino el tamanio de la matriz que nos va a dar la multiplicacion
        for (int fil = 0; fil < this.filas; fil++) {
            for (int col = 0; col < matriz2.columnas; col++) {
                double operacion = 0;//Aqui vamos a calcular los resultados de cada elmento para la matriz resultante
                for (int extra = 0; extra < this.columnas; extra++) {
                    operacion += ((Double) this.arreglo[col][extra]).doubleValue() * ((Double) matriz2.arreglo[extra][fil]).doubleValue();
                }
                matrizResultante.arreglo[col][fil] = operacion;
            }
        }
        this.arreglo = matrizResultante.arreglo;//Sobrescribimos el arreglo con los resultados que no salieron
        return true;
    }

    public boolean sumar(MatrizInfo2Numerica matriz2){
        if (this.columnas != matriz2.columnas && this.filas != matriz2.filas) {
            return false;//No se pueden sumar
        }
        for (int fil = 0; fil < this.filas; fil++) {
            for (int col = 0; col < this.columnas; col++) {
                double valorActual = (double) this.arreglo[fil][col];//Convertimos el elemento a double
                double resultado = valorActual + (double) matriz2.arreglo[fil][col];
                this.arreglo[fil][col] = resultado;
            }
        }
        return true;
    }

    public boolean aplicarPotencia(Number escalar){
        for (int fil = 0; fil < this.filas; fil++) {//Lo hacemos elemento por elemento y no a la matriz completa
            for (int col = 0; col < this.columnas; col++) {
                double valorActual = (double) this.arreglo[fil][col];//Convertimos el elemento a double
                double resultado = Math.pow(valorActual, escalar.doubleValue());
                this.arreglo[fil][col] = resultado;
            }
        }
        return true;
    }

    public boolean aplicarLogaritmo(TipoLogaritmo tipoLogaritmo){
        if (tipoLogaritmo == tipoLogaritmo.NATURAL) {
            for (int fil = 0; fil < this.filas; fil++) {//Lo hacemos elemento por elemento y no a la matriz completa
                for (int col = 0; col < this.columnas; col++) {
                    if ((double) this.arreglo[fil][col] <= 0) {
                        return false;
                    }else{
                        double valorActual = (double) this.arreglo[fil][col];//Convertimos el elemento a double
                        double resultado = Math.log(valorActual);
                        this.arreglo[fil][col] = resultado;
                    }
                }
            }
            return true;
        }
        else if (tipoLogaritmo == tipoLogaritmo.BASE10) {
            for (int fil = 0; fil < this.filas; fil++) {//Lo hacemos elemento por elemento y no a la matriz completa
                for (int col = 0; col < this.columnas; col++) {
                    if ((double) this.arreglo[fil][col] <= 0) {
                        return false;
                    }else{
                        double valorActual = (double) this.arreglo[fil][col];//Convertimos el elemento a double
                        double resultado = Math.log10(valorActual);
                        this.arreglo[fil][col] = resultado;
                    }
                }
            }
            return true;
        }
        else if (tipoLogaritmo == tipoLogaritmo.BASE2) {
            for (int fil = 0; fil < this.filas; fil++) {//Lo hacemos elemento por elemento y no a la matriz completa
                for (int col = 0; col < this.columnas; col++) {
                    if ((double) this.arreglo[fil][col] <= 0) {
                        return false;
                    }else{
                        double valorActual = (double) this.arreglo[fil][col];//Convertimos el elemento a double
                        double resultado = Math.log(valorActual)/Math.log(2);
                        this.arreglo[fil][col] = resultado;
                    }

                }
            }
            return true;
        }
        else {
            return false;
        }
    }

    public boolean matrizDiagonal(Number contenido){
        //Inicializar la matriz con 0
        this.rellenar(0);
        int col = -1;//Aqui las variables estan desde menos uno para evitar errores con los indices
        for (int fil = -1; fil < this.columnas-1; fil++) {
            this.arreglo[fil+1][col+1] = (Double) contenido.doubleValue();
            col = col+1;
        }
        return true;
    }

    public boolean esDiagonalSuperior() {
        for (int fil = 0; fil < this.filas; fil++) {//Recorremos toda la matriz
            for (int col = 0; col < this.columnas; col++) {
                if (col < fil && (Double)this.arreglo[fil][col] != 0.0) {
                    return false; 
                }
            }
        }
        return true; 
    }

    public boolean esDiagonalInferior() {
        //hacemos lo mismo que en diagonal superior, solamente cambiamos la logica de los ciclos
        for (int fil = 0; fil < this.filas; fil++) {
            for (int col = 0; col < this.columnas; col++) {
                if (col > fil && (Double)this.arreglo[fil][col] != 0.0) {
                    return false; 
                }
            }
        }
        return true; 
    }

    public boolean potencia(int exponente) {
        if (exponente < 0) {
            return false;
        }
        if (exponente == 0) {
            for (int fil = 0; fil < this.filas; fil++) {
                for (int col = 0; col < this.columnas; col++) {
                    if (fil == col) {
                        this.arreglo[fil][col] = 1.0;
                    } else {
                        this.arreglo[fil][col] = 0.0;
                    }
                }
            }
            return true;
        }
        MatrizInfo2Numerica matrizOriginal = new MatrizInfo2Numerica(this.filas, this.columnas);
        for (int fil = 0; fil < this.filas; fil++) {
            for (int col = 0; col < this.columnas; col++) {
                matrizOriginal.arreglo[fil][col] = (Double) this.arreglo[fil][col];
            }
        }
        for (int iteracion = 1; iteracion < exponente; iteracion++) { 
            MatrizInfo2Numerica resultado = new MatrizInfo2Numerica(this.filas, this.columnas, 0.0); // Inicializa todos los elementos a 0.0
            for (int fil = 0; fil < this.filas; fil++) {
                for (int col = 0; col < this.columnas; col++) {
                    for (int extra = 0; extra < this.columnas; extra++) {
                        double valorActual = (Double) this.arreglo[fil][extra];
                        double valorOriginal = (Double) matrizOriginal.arreglo[extra][col];
                        resultado.arreglo[fil][col] = (Double) resultado.arreglo[fil][col] + (valorActual * valorOriginal);
                    }
                }
            }
            this.arreglo = resultado.arreglo;
        }
        return true;
    }    

    public boolean doblarRenglones(){
        if (this.columnas % 2 == 0) {
            MatrizInfo2Numerica matrizIzq = new MatrizInfo2Numerica(this.filas, this.columnas / 2);
            MatrizInfo2Numerica matrizDer = new MatrizInfo2Numerica(this.filas, this.columnas / 2);
            MatrizInfo2Numerica matrizResultante = new MatrizInfo2Numerica(this.filas, this.columnas / 2);
            for (int fil = 0; fil < matrizIzq.filas; fil++) {
                for (int col = 0; col < matrizIzq.columnas; col++) {
                    matrizIzq.cambiar(fil, col, this.arreglo[fil][col]);//Poner valores en la matriz de la izq
                }
            }
            for (int fil = 0; fil < matrizDer.filas; fil++) {
                for (int col = 0; col < matrizDer.columnas; col++) {
                    matrizDer.cambiar(fil, col, this.arreglo[fil][col + this.columnas / 2]);//Poner valores en la matriz de la der 
                }
            }
            for (int fil = 0; fil < matrizIzq.filas; fil++) {//Aqui hago la suma de los elementos de la matriz izq
                for (int col = 0; col < matrizIzq.columnas - 1; col++) {
                    double valorActual = ((Double) matrizIzq.arreglo[fil][col]).doubleValue();
                    double valorSiguiente = ((Double) matrizIzq.arreglo[fil][col + 1]).doubleValue();
                    double resultado = valorActual + valorSiguiente;
                    matrizResultante.arreglo[fil][col] = resultado;
                }
            }
            for (int fil = 0; fil < matrizDer.filas; fil++) {//Y aqui los de la derecha
                for (int col = 1; col < matrizDer.columnas; col++) {
                    double valorActual = ((Double) matrizDer.arreglo[fil][col]).doubleValue();
                    double valorAnterior = ((Double) matrizDer.arreglo[fil][col - 1]).doubleValue();
                    double resultado = valorActual + valorAnterior;
                    matrizResultante.arreglo[fil][col] = resultado;
                }
            }
            this.redefinir(matrizResultante);
            this.arreglo = matrizResultante.arreglo;
            return true;
        }else{
            MatrizInfo2Numerica matrizIzq = new MatrizInfo2Numerica(this.filas, (this.columnas - 1) / 2);
            MatrizInfo2Numerica matrizDer = new MatrizInfo2Numerica(this.filas, (this.columnas - 1) / 2);
            MatrizInfo2Numerica matrizMedio = new MatrizInfo2Numerica(this.filas, 1);
            MatrizInfo2Numerica matrizResultante = new MatrizInfo2Numerica(this.filas, (this.columnas - 1) / 2);

            
            for (int fil = 0; fil < matrizIzq.filas; fil++) {
                for (int col = 0; col < matrizIzq.columnas; col++) {
                    matrizIzq.cambiar(fil, col, this.arreglo[fil][col]);
                }
            }
            for (int fil = 0; fil < matrizDer.filas; fil++) {
                for (int col = 0; col < matrizDer.columnas; col++) {
                    matrizDer.cambiar(fil, col, this.arreglo[fil][col + this.columnas / 2]);
                }
            }
            for (int fil = 0; fil < matrizIzq.filas; fil++) {
                for (int col = 0; col < matrizIzq.columnas - 1; col++) {
                    double valorActual = ((Double) matrizIzq.arreglo[fil][col]).doubleValue();
                    double valorSiguiente = ((Double) matrizIzq.arreglo[fil][col + 1]).doubleValue();
                    double resultado = valorActual + valorSiguiente;
                    matrizResultante.arreglo[fil][col] = resultado;
                }
            }
            for (int fil = 0; fil < matrizDer.filas; fil++) {
                for (int col = 1; col < matrizDer.columnas; col++) {
                    double valorActual = ((Double) matrizDer.arreglo[fil][col]).doubleValue();
                    double valorAnterior = ((Double) matrizDer.arreglo[fil][col - 1]).doubleValue();
                    double resultado = valorActual + valorAnterior;
                    matrizResultante.arreglo[fil][col] = resultado;
                }
            }

            this.redefinir(matrizResultante);
            this.arreglo = matrizResultante.arreglo;
            return true;
        }
    }

    public boolean doblarColumnas(){
        int nuevosRenglones = (this.filas + 1) / 2;
        MatrizInfo2Numerica matrizResultante = new MatrizInfo2Numerica(nuevosRenglones, this.columnas);
        for (int fil = 0; fil < nuevosRenglones; fil++) {
            for (int col = 0; col < this.columnas; col++) {
                if (2*fil < this.filas - 1) {
                    double valorArriba = ((Double) this.arreglo[2*fil][col]).doubleValue();
                    double valorAbajo = ((Double) this.arreglo[2*fil + 1][col]).doubleValue();
                    double resultado = valorArriba + valorAbajo;
                    matrizResultante.arreglo[fil][col] = resultado;
                } else {
                    matrizResultante.arreglo[fil][col] = this.arreglo[2*fil][col];
                }
            }
        }
        this.redefinir(matrizResultante);
        this.arreglo = matrizResultante.arreglo;
        return true;
    }    
}