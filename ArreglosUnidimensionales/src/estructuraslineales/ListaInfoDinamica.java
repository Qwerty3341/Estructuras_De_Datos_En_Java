package estructuraslineales;

import utilerias.comunes.TipoTabla;
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
        }else{ //Si hay el elemento buscado
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

    public int obtenerCantidadDeElementos(){
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
        //Metodo para obtener un nodo en especifico
        Nodo temporal = apuntadorInicial;
        int contador = 0;
        while (temporal != null && contador < indice) {
            temporal = temporal.getEnlaceDerecho();
            contador += 1;
        } 
        return temporal;
    }

    public void mostrarOI(){
        PilaInfoDinamica pila = new PilaInfoDinamica();//Pila para almacenar los datos de los nodos
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

    public ListaInfoEstatica aListaEstatica(ListaInfoEstatica elementosADescartar){
        for (int lugar = 0; lugar < elementosADescartar.CAPACIDAD; lugar++) {//Ciclo para eliminar los elementos de la lista actual
            this.borrar(elementosADescartar.obtenerElemento(lugar));
        }//Nueva lista para pasar la lista actual a estatica
        ListaInfoEstatica listEst = new ListaInfoEstatica(this.obtenerCantidadDeElementos());
        for (int index = 0; index < listEst.CAPACIDAD; index++) {//Ciclo para llenar la lista estatica con los elementos de la actual
            listEst.insertar(this.obtenDatoEspecifico(index));
        }
        return listEst;
    }
    
    public MatrizInfo2 aMatrizInfo2(int filas, int columnas){
        MatrizInfo2 matriz = new MatrizInfo2(filas, columnas);
        int tamanio = this.obtenerCantidadDeElementos();
        //Estas variables las uso para saber la posicion en la que se debe insertar las cosas de las listas
        int posicionDeFila = 0;
        int posicionDeColumna = 0;
        int posicionDeLista = 0;
        //Recorrer toda la matriz
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
        //Solamente se recorre la lista para obtener el elemento actual y despues ponerlos en la lista actual
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
        }else{//Se paso otro tipo de dato por argumento
            return false;
        }        
    }

    @Override
    public ListaInfo clonar(){
        ListaInfoDinamica copia = new ListaInfoDinamica();//Se hace la nueva lista
        Nodo temp = this.apuntadorInicial; 
        while (temp != null) {//Recorremos toda la lista para agregar los nodos a la nueva listaS
            copia.insertar(temp);
            temp = temp.getEnlaceDerecho();
        }
        return copia;
    }

    public boolean agregarMatriz(MatrizInfo2 tabla, TipoTabla enumTipoTabla){
        if (enumTipoTabla == TipoTabla.POR_RENGLON) {//Se recorre la matriz completa para poner cada elemento en la lista
            for (int fil = 0; fil < tabla.obtenerRenglones(); fil++) {
                for (int col = 0; col < tabla.obtenerColumnas(); col++) {
                    this.insertar(tabla.obtener(fil, col));
                }
            }
            return true;
        }else if(enumTipoTabla == TipoTabla.POR_COLUMNA){//Se hace lo mismo que el renglon
            for (int fil = 0; fil < tabla.obtenerRenglones(); fil++) {
                for (int col = 0; col < tabla.obtenerColumnas(); col++) {
                    this.insertar(tabla.obtener(col, fil));//Invirtiendo la fila por la columna y viceversa
                }
            }
            return true;
        }else{//Hubo algun error
            return false;
        }
    }
    
    @Override
    public void vaciar(){
        this.apuntadorInicial = null;//Solo se pone el inicio como null
    }

    @Override
    public void rellenar(Object valor, int cantidad){
        for (int cuenta = 0; cuenta < cantidad; cuenta++) {//Usamos el metodo insertar varias veces
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
            this.insertar(pilaDeRespaldo.quitar());
        }
    }    

    @Override
    public boolean cambiar(Object valorViejo, Object valorNuevo, int numVeces) {
        Nodo temp = apuntadorInicial;
        int contadorDeIteraciones = 0;
        while(temp != null){
            //Revisamos cada dato de la lista 
            if(temp.getDato().equals(valorViejo)){
                temp.setDato(valorNuevo);
            }
            temp = temp.getEnlaceDerecho();
            contadorDeIteraciones++;
            //Cuando ya se hayan cambiado los elementos el numero de veces que 
            if (contadorDeIteraciones == numVeces) {
                break;
            }
        }
        return true;
    }

    public boolean cambiar(int indice, Object valor){   
        if(this.obtenerCantidadDeElementos() < indice){
            return false;
        }
        Nodo temp = apuntadorInicial;
        int contadorDeIteraciones = 0;
        while(temp != null){
            //Cuando ya se hayan cambiado los elementos el numero de veces que 
            if (contadorDeIteraciones == indice){
                temp.setDato(valor);
                break;
            }
            contadorDeIteraciones += 1;
            temp = temp.getEnlaceDerecho();
        }
        return true;
    }

    public Object obtener(int indice){
        //Se verifica que nos den un indice valido
        if(this.obtenerCantidadDeElementos() < indice){
            return false;
        }
        Nodo temp = apuntadorInicial;
        int contadorDeIteraciones = 0;
        Object elementoEncontrado = null;
        //Recorremos toda la lista para obtener el elemento indicado
        while(temp != null){
            if (contadorDeIteraciones == indice){
                elementoEncontrado = temp.getDato();
                break;
            }
            contadorDeIteraciones += 1;
            temp = temp.getEnlaceDerecho();
        }
        return elementoEncontrado;
    }

    public boolean esIgual(ListaInfo listaDatos2){
        //Verificamos las instancias del argumento
        if(listaDatos2 instanceof ListaInfoEstatica){
            ListaInfoEstatica list = (ListaInfoEstatica) listaDatos2;
            if(list.capacidad() != this.obtenerCantidadDeElementos()) return false;//Si las listas no son del mismo tamanio entonces no son iguales
            int contadorDeIgualdades = 0;
            int totalDeIgualdades = this.obtenerCantidadDeElementos();
            // Se itera sobre las listas 
            Nodo temp = apuntadorInicial;
            for (int lugar=0; lugar < this.obtenerCantidadDeElementos(); lugar++){
                if (temp.getDato().equals(list.obtenerElemento(lugar))) contadorDeIgualdades+=1;
                temp = temp.getEnlaceDerecho();
            }
            //Se verifica si son iguales
            if (contadorDeIgualdades == totalDeIgualdades) return true;
            else return false;

        }else if(listaDatos2 instanceof ListaInfoDinamica){

            ListaInfoDinamica list = (ListaInfoDinamica) listaDatos2;
            if (list.obtenerCantidadDeElementos() != this.obtenerCantidadDeElementos()) return false;
            int contadorDeIgualdades = 0;
            int totalDeIgualdades = this.obtenerCantidadDeElementos();
            //Se itera sobre las listas
            Nodo temp = apuntadorInicial;
            Nodo temp2 = list.apuntadorInicial;
            while (temp != null && temp2 != null){
                if (temp.getDato().equals(temp2.getDato())) contadorDeIgualdades+=1;
                temp = temp.getEnlaceDerecho();
                temp2 = temp2.getEnlaceDerecho();
            }
            //Se verifica si son iguales
            if (contadorDeIgualdades == totalDeIgualdades) return true;
            else return false;

        }else if(listaDatos2 instanceof ListaInfoEstaticaNumerica){
            ListaInfoEstaticaNumerica list = (ListaInfoEstaticaNumerica) listaDatos2;
            if (list.capacidad() != this.obtenerCantidadDeElementos()) return false;
            int contadorDeIgualdades = 0;
            int totalDeIgualdades = this.obtenerCantidadDeElementos();
            //Se itera sobre las listas
            Nodo temp = apuntadorInicial;
            for (int lugar=0; lugar < this.obtenerCantidadDeElementos(); lugar++){
                if (temp.getDato().equals(list.obtenerElemento(lugar))) contadorDeIgualdades+=1;
                temp = temp.getEnlaceDerecho();
            }
            //Verificamos si son iguales
            if (contadorDeIgualdades == totalDeIgualdades) return true;
            else return false;
        }else{//No es una lista info
            return false;
        }
    }

    @Override
    public boolean redimensionar(int maximo) {
        /*Tenemos 3 casos para este metodo
        1 -> que el maximo sea mayor que el tamanio actual (se reyena de nulls)
        2 -> que el maximo sea menor que el tamanio actual (se borrar los elementos sobrantes)
        3 -> que el maximo sea igual que el tamanio actual (en este caso no se hace nada)
        */
        if (maximo > this.obtenerCantidadDeElementos()) {
            int cantidadDeElementosNuevos = maximo - this.obtenerCantidadDeElementos();
            for (int insercion = 0; insercion < cantidadDeElementosNuevos; insercion++) {
                this.insertar(null);
            }
            return true;

        }else if(maximo < this.obtenerCantidadDeElementos()){
            Nodo temp = apuntadorInicial;
            ColaInfoDinamica colaDeAlmacen = new ColaInfoDinamica();
            for (int insercion = 0; insercion < maximo; insercion++) {
                colaDeAlmacen.poner(temp.getDato());
                temp = temp.getEnlaceDerecho();
            }
            this.vaciar();
            for (int insercion = 0; insercion < maximo; insercion++) {
                this.insertar(colaDeAlmacen.quitar());
            }
            return true;
        }
        else{//Es el mismo tamanio
            return false;
        }
    }

    public Object borrar(int indice){
        Object elementoEnElIndice = this.obtener(indice);//Obtenemos el indice antes de eliminarlo
        int cantidadDeElementos = this.obtenerCantidadDeElementos();
        int nuevaCantidadDeElementos = cantidadDeElementos - 1;//Como borramos un elemento el nuevo tamanio va a ser el mismo menos uno
        Nodo temp = apuntadorInicial;
        ColaInfoDinamica colaDeAlmacen = new ColaInfoDinamica();
        //Ponemos todos los elementos de la lista actual en la cola exepto el que se va a borrar
        for (int insercion = 0; insercion < cantidadDeElementos; insercion++) {
            if (temp.getDato() != elementoEnElIndice) {
                colaDeAlmacen.poner(temp.getDato());    
            }
            temp = temp.getEnlaceDerecho();
        }
        //Vaciamos y rellenamos la lista con todos los elementos que estan en la cola
        this.vaciar();
        for (int insercion = 0; insercion < nuevaCantidadDeElementos; insercion++) {
            this.insertar(colaDeAlmacen.quitar());
        }
        return elementoEnElIndice;
    }

    public ListaInfoDinamica borrarV(Object valor){
        ListaInfoDinamica elementosBorrados = new ListaInfoDinamica();
        ColaInfoDinamica colaDeAlmacen = new ColaInfoDinamica();//Esta cola es para poner los elementos eliminados
        int tamanioOriginal = this.obtenerCantidadDeElementos();//Esta variable me ayuda a saber el tamanio que va a tener la lista despues de eliminar los elementos
        Nodo temp = apuntadorInicial;
        for(int index = 0; index < tamanioOriginal; index++){//Recorro toda la lista
            if (temp.getDato() != valor) {//Aniado los elementos que voy a mantener a la cola
                colaDeAlmacen.poner(temp.getDato());
            }
            if(temp.getDato().equals(valor)){//Aniado los elementos que se borrar a la lista de elementos borrados
                elementosBorrados.insertar(temp.getDato());
            }
            temp = temp.getEnlaceDerecho();
        }
        //Se vacia y se rellena la lista actualizada
        this.vaciar();
        int tamanioNuevo = tamanioOriginal - elementosBorrados.obtenerCantidadDeElementos();
        for(int lugar=0; lugar < tamanioNuevo; lugar++){
            this.insertar(colaDeAlmacen.quitar());
        }
        return elementosBorrados;        
    }

    public Nodo getApuntadorInicial() {
        return apuntadorInicial;
    }
    
}