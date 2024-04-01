package estructuraslineales;

import java.beans.Transient;
import java.util.LongSummaryStatistics;

import entradasalida.SalidaPorDefecto;
import estructuraslineales.auxiliar.Nodo;
import estructuraslineales.auxiliar.NodoBuscado;
import estructurasnolineales.MatrizInfo2;

public class ListaInfoDinamica implements ListaInfo{

    protected Nodo apuntadorInicial;
    protected Nodo apuntadorFinal;
    protected Nodo iterador;

    public ListaInfoDinamica(){
        this.apuntadorInicial = null;
        this.apuntadorFinal = null;
        this.iterador = null;
    }

    @Override
    public boolean estaVacia() {
        if (apuntadorInicial == null) {
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean estaLLeno() {
        throw new UnsupportedOperationException("Unimplemented method 'estaLLeno'");
    }

    @Override
    public Integer insertar(Object valor) {
        Nodo nodoNuevo=new Nodo(valor); //Paso 1
        if (nodoNuevo != null) { //me prestaron memoria
            if (estaVacia()==true) { //a)
                //Paso 2
                apuntadorInicial=nodoNuevo;
                apuntadorFinal=nodoNuevo;
            }else{ //b) , c)
                //paso 2
                apuntadorFinal.setEnlaceDerecho(nodoNuevo);
                //paso 3
                apuntadorFinal=nodoNuevo;
            }   
            return 0;
        }else{ //no prestaron
            return -1;
        }
    }

    @Override
    public Integer insertarInicio(Object valor) {
        Nodo nodoNuevo = new Nodo(valor);//paso 1
        if (nodoNuevo != null) {//Se pudo
            if (estaVacia() == true) {//a
                apuntadorFinal = nodoNuevo;
                apuntadorFinal = nodoNuevo;
            }else{//b , c
                //paso 2
                nodoNuevo.setEnlaceDerecho(apuntadorInicial);
                //paso 3
                apuntadorInicial = nodoNuevo;
            }
            return 0;
        }else{//No hay error o equivalete a lleno
            return -1;
        }
    }

    private NodoBuscado encontrarNodo(Object valor){
        Nodo temporal = apuntadorInicial;
        Nodo anterior = apuntadorInicial;

        //Mientras existan elementos donde buscar y mientras no sea igual a lo que busco
        while (temporal != null && valor.toString().equalsIgnoreCase(temporal.getDato().toString()) == false) {
            anterior=temporal;
            temporal=temporal.getEnlaceDerecho();//i = i + 1
        }
        NodoBuscado busqueda = new NodoBuscado();
        busqueda.setBuscado(temporal);
        busqueda.setAnterior(anterior);
        return busqueda;
    }

    public Object encontrar(Object valor) {
        NodoBuscado busqueda = encontrarNodo(valor);

        if(busqueda.getBuscado() != null){//Hay algo 
            return busqueda.getBuscado().getDato();
        }else{//No hay nada o no esta 
            return null;
        }
    }

    @Override
    public Object borrar(Object valor) {
        NodoBuscado busqueda = encontrarNodo(valor);
        if (busqueda.getBuscado()==null) {//a) , d) no esta, ya sea por vacia o por que no existe el elemento
            return null;
        }else{ //Si hay el eelemento buscado
            //paso 1
            Object respaldo = busqueda.getBuscado().getDato();
            if (apuntadorInicial == apuntadorFinal) { //b) unico
                //paso2
                apuntadorInicial = null;
                apuntadorFinal = null;
            }else if (apuntadorInicial == busqueda.getBuscado()){//primero , c)
                //paso 2
                apuntadorInicial = apuntadorInicial.getEnlaceDerecho();
            }else if (apuntadorFinal == busqueda.getBuscado()) { //e), ultimo
                //paso 2
                Nodo anterior = busqueda.getAnterior();
                apuntadorFinal = anterior;
                //paso 3
                apuntadorFinal.setEnlaceDerecho(null);
            }else{//f), cuando hay varios y esta en medio
                //paso 2
                Nodo anterior = busqueda.getAnterior();
                Nodo temporal = busqueda.getBuscado();
                anterior.setEnlaceDerecho(temporal.getEnlaceDerecho());
            }
            return respaldo;
        }
    }

    public Object borrar(){
        NodoBuscado busqueda = encontrarNodo(apuntadorFinal.getDato());
        if (busqueda.getBuscado() != null) { //si hay algo
            //Paso 1
            Object respaldo = apuntadorFinal.getDato();
            if (apuntadorInicial == apuntadorFinal) {//unico elemento , b)
                //paso 2
                apuntadorInicial=null;
                apuntadorInicial=null;
            }else{//c), hay varios
                //paso 2
                Nodo anterior = busqueda.getAnterior();
                anterior.setEnlaceDerecho(null);
                //paso 3
                apuntadorFinal=anterior;
            }
            return respaldo;
        }else{//No hat nada , a)
            return null;
        }
    }

    @Override
    public void mostrar() {
        Nodo temporal = apuntadorInicial;
        while (temporal != null) {
            SalidaPorDefecto.consola(temporal.getDato()+" -> ");
            temporal = temporal.getEnlaceDerecho();
        }
        SalidaPorDefecto.consola("null");
    }

    @Override
    public boolean esIgual(Object lista2) {
        
        throw new UnsupportedOperationException("Unimplemented method 'esIgual'");
    }

    @Override
    public boolean cambiar(Object valorViejo, Object valorNuevo, int numVeces) {
        
        throw new UnsupportedOperationException("Unimplemented method 'cambiar'");
    }

    @Override
    public ListaInfoEstatica encontrarValores(Object valor) {   
        throw new UnsupportedOperationException("Unimplemented method 'encontrarValores'");
    }
    @Override
    public boolean agregarLista(Object lista2) {   
        throw new UnsupportedOperationException("Unimplemented method 'agregarLista'");
    }
    @Override
    public boolean borrarLista(Object lista2) {
        throw new UnsupportedOperationException("Unimplemented method 'borrarLista'");
    }
    @Override
    public ListaInfoEstatica subLista(int indiceInicial, int indiceFinal) {
        throw new UnsupportedOperationException("Unimplemented method 'subLista'");
    }

    @Override
    public boolean redimensionar(int maximo) {
        throw new UnsupportedOperationException("Unimplemented method 'redimensionar'");
    }

    @Override
    public void rellenar(Object valor) {   
        throw new UnsupportedOperationException("Unimplemented method 'rellenar'");
    }

    @Override
    public ListaInfo arregloDesordenado() {
        throw new UnsupportedOperationException("Unimplemented method 'arregloDesordenado'");
    }

    @Override
    public boolean esSublista(ListaInfoEstatica lista2) {
        throw new UnsupportedOperationException("Unimplemented method 'esSublista'");
    }

    @Override
    public boolean cambiarLista(ListaInfoEstatica lista2, ListaInfoEstatica lista2Nuevos) {
        throw new UnsupportedOperationException("Unimplemented method 'cambiarLista'");
    }

    @Override
    public boolean retenerLista(ListaInfoEstatica lista2) {
        throw new UnsupportedOperationException("Unimplemented method 'retenerLista'");
    }

    @Override
    public boolean insertar(int indice, Object info) {
        throw new UnsupportedOperationException("Unimplemented method 'insertar'");
    }

    @Override
    public boolean copiarLista(ListaInfoEstatica lista2) {   
        throw new UnsupportedOperationException("Unimplemented method 'copiarLista'");
    }

    @Override
    public Object verFinal() {
        throw new UnsupportedOperationException("Unimplemented method 'verFinal'");
    }

    @Override
    public Object borrarInicio() {
        if (estaVacia()==false) {//a
            Object respaldo=apuntadorInicial.getDato();//paso 1
            if (apuntadorInicial==apuntadorFinal) {//b
                apuntadorInicial = null;//paso 2
                apuntadorFinal = null;
            }else{//paso 1
                apuntadorInicial=apuntadorInicial.getEnlaceDerecho();
            }
            return respaldo;
        }else{//a,  no hay nada
            return null;
        }
    }

    public void iniciaIterador(){
        iterador = this.apuntadorInicial;
    }

    public boolean IteradorNulo(){
        if (iterador == null) {
            return true;
        }else{
            return false;
        }
    }

    public Object obtenDato(){
        if (IteradorNulo()==false) {
            Object dato = iterador.getDato();
            iterador = iterador.getEnlaceDerecho();
            return dato;
        }else{
            return null;
        }
    }

    //Metodos de la practica 12

    private int obtenerCantidadDeElementos(){
        //Metodo para usarlo en tamanios de las listas estaticas
        int cantidad = 0;
        Nodo temp = this.apuntadorInicial;
        while(temp != null){
            temp = temp.getEnlaceDerecho();
            cantidad+=1;
        }
        return cantidad;
    }

    private Nodo obtenDatoEspecifico(int indice){
        Nodo temporal = apuntadorInicial;
        int contador = 0;
        while (temporal != null && contador < indice) {
            temporal = temporal.getEnlaceDerecho();
            contador += 1;
        } 
        return temporal;
    }

    public void mostrarOI(){
        PilaInfoDinamica pila = new PilaInfoDinamica();
        Nodo temporal = apuntadorInicial;
        while (temporal!=null) {
            pila.poner(temporal.getDato());
            temporal = temporal.getEnlaceDerecho();
        }
        SalidaPorDefecto.consola("null");//Cuando se vacia la pila por completo no hay un apuntador null asi que se imprime al inicio
        while(pila.vacio() == false){
            SalidaPorDefecto.consola(" -> "+pila.quitar());
        }
    }

    public ListaInfoDinamica encontrarLista(Object valor){
        ListaInfoDinamica ocurrencia = new ListaInfoDinamica();
        Nodo temp = apuntadorInicial;//Hacemos un nodo temporal para obtener cada dato que sea igual al valor
        while(temp != null){
            if(temp.getDato().equals(valor)){
                ocurrencia.insertar(temp.getDato());
            }
            temp = temp.getEnlaceDerecho();
        }
        return ocurrencia;
    }

    public ListaInfoEstatica aListaEstatica(){
        //Primero recorro toda la lista para saber cuantos elementos hay 
        int contador = obtenerCantidadDeElementos();
        ListaInfoEstatica nuevaLista = new ListaInfoEstatica(contador);
        //Recorremos de nuevo la lista para sacar todos los elementos y ponerlos en la lista nueva
        Nodo temp2 = this.apuntadorInicial;
        while(temp2 != null){
            nuevaLista.insertar(temp2.getDato());
            temp2 = temp2.getEnlaceDerecho();
        }
        return nuevaLista;
    }

    // public ListaInfoEstatica aListaEstatica(ListaInfoEstatica elementosADescartar){

    // }
    
    public MatrizInfo2 aMatrizInfo2(int filas, int columnas){
        MatrizInfo2 matriz = new MatrizInfo2(filas, columnas);
        int tamanio = this.obtenerCantidadDeElementos();
        //Estas variables las uso para saber la posicion en la que se debe insertar las cosas de las listas
        int posicionDeFila = 0;
        int posicionDeColumna = 0;
        int posicionDeLista = 0;
    
        for (int index = 0; index < tamanio; index++) {
            for (int index2 = 0; index2 < columnas; index2++) {
                if (posicionDeLista < tamanio) {
                    Nodo dato = this.obtenDatoEspecifico(posicionDeLista);
                    matriz.cambiar(posicionDeFila, posicionDeColumna, dato.getDato());
                    posicionDeLista = posicionDeLista+1;
                    posicionDeColumna = posicionDeColumna+1;
                    if (posicionDeColumna >= columnas) {
                        posicionDeColumna = 0;
                        posicionDeFila=posicionDeFila+1;
                    }
                } else {
                    matriz.cambiar(posicionDeFila, posicionDeColumna, null);
                    posicionDeColumna++;
                    if (posicionDeColumna >= columnas) {
                        posicionDeColumna = 0;
                        posicionDeFila = posicionDeFila + 1;
                    }
                }
            }
        }    
        return matriz;
    }
    
    public boolean agregarLista(ListaInfo listaDatos2){
        //Solamente se recorre la lista para obtener el elemento actual 
        //y despues ponerlos en la lista actual
        if(listaDatos2 instanceof ListaInfoDinamica){
            ListaInfoDinamica list = (ListaInfoDinamica) listaDatos2;
            for(int index=0; index < list.obtenerCantidadDeElementos(); index++){
                Object objetoActual = list.obtenDatoEspecifico(index);
                this.insertar(objetoActual);
            }
            return true;

        }else if (listaDatos2 instanceof ListaInfoEstatica){
            ListaInfoEstatica list = (ListaInfoEstatica) listaDatos2;
            for(int index=0; index < list.capacidad(); index++){
                Object objetoActual = list.obtener(index);
                this.insertar(objetoActual);
            }
            return true;

        }else{
            return false;
        }        
    }

    @Override
    public ListaInfo clonar(){
        //Se llama clonar2 para evitar 
        ListaInfoDinamica copia = new ListaInfoDinamica();
        Nodo temp = this.apuntadorInicial;
        while (temp != null) {
            copia.insertar(temp);
            temp = temp.getEnlaceDerecho();
        }
        return copia;
    }

    // public boolean agregarMatriz(MatrizInfo2 tabla, TipoTabla enumTipoTabla){
    //     if (enumTipoTabla == TipoTabla.POR_COLUMNA) {
            
    //     }else if(enumTipoTabla == TipoTabla.POR_RENGLON){

    //     }else{
    //         return false;
    //     }
    // }
    
    @Override
    public void vaciar(){
        this.apuntadorInicial = null;//Solo se pone el inicio como null
    }

    @Override
    public void rellenar(Object valor, int cantidad){
        for (int cuenta = 0; cuenta < cantidad; cuenta++) {
            this.insertar(valor);
        }
    }
    
    @Override
    public int contar(Object valor){
        int contador = 0;
        Nodo temp = this.apuntadorInicial;
        while(temp != null){
            if (temp.getDato().equals(valor)) {//Obtenemos el dato del nodo
                contador+=1;    
            }
            temp = temp.getEnlaceDerecho();
        }
        return contador;
    }

    @Override
    public void invertir() {
        //Esta sirve para poner los datos de la lista que se va a invertir
        PilaInfoDinamica pilaDeRespaldo = new PilaInfoDinamica();
        Nodo temp = this.apuntadorInicial;
        while(temp != null){
            pilaDeRespaldo.poner(temp.getDato());
            temp = temp.getEnlaceDerecho();
        }
        int iteraciones = this.obtenerCantidadDeElementos();
        this.vaciar();
        //Coloco los elementos de la pila en la lista actual
        for (int posicion = 0; posicion < iteraciones ; posicion++) {
            Object elementoTemporal = pilaDeRespaldo.quitar();
            this.insertar(elementoTemporal);
        }
    }    

    
}
