package estructuraslineales;

import estructuraslineales.auxiliar.Nodo;
import estructurasnolineales.MatrizInfo2;
import utilerias.comparador.ComparadorDeObjetos;
import utilerias.comunes.TipoDeOrdenamiento;
import utilerias.comunes.TipoTabla;

public class ListaInfoDinamicaOrdenada extends ListaInfoDinamica {

    protected TipoDeOrdenamiento orden;

    public ListaInfoDinamicaOrdenada(TipoDeOrdenamiento orden) {
        super();
        this.orden = orden;
    }

    public int buscarOrdenada(Object elementoBuscado) {
        /* Este método devuelve el índice en el cual el elemento está ubicado */
        Nodo actual = apuntadorInicial;
        int indice = -1;
        while (actual != null) {
            indice++;
            if (actual.getDato().equals(elementoBuscado)) {
                break;
            }
            actual = actual.getEnlaceDerecho();
        }
        return indice;
    }
    
    public void imprimirNatural() {
        this.mostrar();//Mando llamar el metodo mostrar de la lista dinamica
    }

    public void imprimirReverso() {
        this.mostrarOI();//Mando llamar el metodo mostrarOI de la lista dinamica
    }

    @Override
    public Integer insertar(Object elemento) {
        /* Al momento de insertar también se recorren los elementos ya insertados */
        Nodo nuevoNodo = new Nodo(elemento);//Nuevo nodo que se va a poner en la lista
        Nodo actual = apuntadorInicial;
        Nodo anterior = null;
    
        if (this.orden == TipoDeOrdenamiento.INC) {
            while (actual != null && ComparadorDeObjetos.comparar(actual.getDato(), elemento) < 0) {
                anterior = actual;
                actual = actual.getEnlaceDerecho();
            }
        } else {// Ordenamiento decreciente
            while (actual != null && ComparadorDeObjetos.comparar(actual.getDato(), elemento) > 0) {
                anterior = actual;
                actual = actual.getEnlaceDerecho();
            }
        }
        if (anterior == null) {//Si el nodo anterior es null se inserta el nuevo nodo
            nuevoNodo.setEnlaceDerecho(apuntadorInicial);
            apuntadorInicial = nuevoNodo;
        } else { //Aqui es para insertarlo entre actual y anterior
            nuevoNodo.setEnlaceDerecho(anterior.getEnlaceDerecho());
            anterior.setEnlaceDerecho(nuevoNodo);
        }
        if (actual == null) {//Aqui es para actualizar el nodo final
            apuntadorFinal = nuevoNodo;
        }
        return 0;
    }

    public Object eliminar(Object elemento) {//Mando llamar el metodo Borrar de la lista dinamica 
        return this. borrarV(elemento);
    }

    public boolean insertarFinal(Object elemento) {
        //Con esta variable vemos el elemento final
        Object datoFinal = apuntadorFinal.getDato();
        if (datoFinal instanceof Number && elemento instanceof Number) {//En caso de que sean numeros
            Number numDatoFinal = (Double) datoFinal;
            Number elementoCastNumber = (Number) elemento;
            if (numDatoFinal.doubleValue() <= elementoCastNumber.doubleValue()) {
                this.insertar(elemento);
                return true;
            }else{
                return false;
            }
        }else if((datoFinal instanceof Character && elemento instanceof Character) || (datoFinal instanceof String && elemento instanceof String)){//En caso de que sean strings lo pasamos a char
            Character charFinal = (Character) datoFinal;
            Character elementoCastChar = (Character) elemento;
            if (charFinal <= elementoCastChar) {
                this.insertar(elemento);
                return true;
            }else{
                return false;
            }
        }else{//Caso de que algo este fuera de lo normal
            return false;
        }
    }
    
    @Override
    public Integer insertarInicio(Object elemento) {
        /*
        Como este metodo ya estaba implementado como integer hay 2 casos
        1 -> que nos devuelvan 0 (Significa true)
        2 -> que nos devuelvan -1 (Significa false)
        */
        Object datoInicial = apuntadorInicial.getDato();
        if (datoInicial instanceof Number && elemento instanceof Number) {//En caso de que sean numeros
            Number numDatoInicial = (Double) datoInicial;
            Number elementoCastNumber = (Number) elemento;
            if (numDatoInicial.doubleValue() <= elementoCastNumber.doubleValue()) {
                this.insertar(elemento);
                return 0;
            }else{
                return -1;
            }
        }else if((datoInicial instanceof Character && elemento instanceof Character) || (datoInicial instanceof String && elemento instanceof String)){//En caso de que sean strings lo pasamos a char
            Character charInicial = (Character) datoInicial;
            Character elementoCastChar = (Character) elemento;
            if (ComparadorDeObjetos.comparar(charInicial, elementoCastChar) > 0) {
                this.insertar(elemento);
                return 0;
            }else{
                return -1;
            }
        }else{//Caso de que algo este fuera de lo normal
            return -1;
        }
    }

    public Object eliminarFinal() {
        if (this.estaVacia() == true) {
            return false;
        }//Puedo obtener el indice final con la cantidad de elementos totales de la lista
        int indiceFinal = this.obtenerCantidadDeElementos();
        Object copia = obtener(indiceFinal);
        this.borrar(indiceFinal);
        return copia;
    }

    public Object eliminarInicio() {
        return this.borrarInicio();//Solo devuelvo el metodo borrar incio de la clase ListaDinamica
    }
    
    public void insertarArreglo(ListaInfo lista) {
        //Manejo algunos casos que sean de tipo lista info (lista estatica, lista numerica y lista ordenada)
        if (lista instanceof ListaInfoEstatica) {
            ListaInfoEstatica listaCast = (ListaInfoEstatica) lista;
            for (int insercion = 0; insercion < listaCast.capacidad(); insercion++) {
                Object objetoActual = listaCast.obtenerElemento(insercion);
                this.insertar(objetoActual);
            }
        }else if(lista instanceof ListaInfoEstaticaNumerica){
            ListaInfoEstaticaNumerica listaCast = (ListaInfoEstaticaNumerica) lista;
            for (int insercion = 0; insercion < listaCast.capacidad(); insercion++) {
                Object objetoActual = listaCast.obtenerElemento(insercion);
                this.insertar(objetoActual);
            }    
        }else if(lista instanceof ListaInfoDinamicaOrdenada){
            ListaInfoEstaticaOrdenada listaCast = (ListaInfoEstaticaOrdenada) lista;
            for (int insercion = 0; insercion < listaCast.capacidad(); insercion++) {
                Object objetoActual = listaCast.obtenerElemento(insercion);
                this.insertar(objetoActual);
            }    
        }
    }

    public void insertarMatriz(MatrizInfo2 matriz) {
        //Ahora el elemento actual se obtiene con 
        for (int renglon = 0; renglon < matriz.obtenerRenglones(); renglon++) {
            for (int columna = 0; columna < matriz.obtenerColumnas(); columna++) {
                Object objetoActual = matriz.obtener(renglon, columna);
                this.insertar(objetoActual);
            }
        }
    }

    public void eliminarArreglo(ListaInfo lista) {
        //Es lo mismo que el de agregar pero ahora usamos el metodo borrar varios
        if (lista instanceof ListaInfoEstatica) {
            ListaInfoEstatica listaCast = (ListaInfoEstatica) lista;
            for (int insercion = 0; insercion < listaCast.capacidad(); insercion++) {
                Object objetoActual = listaCast.obtenerElemento(insercion);
                this.borrarV(objetoActual);
            }
        }else if(lista instanceof ListaInfoEstaticaNumerica){
            ListaInfoEstaticaNumerica listaCast = (ListaInfoEstaticaNumerica) lista;
            for (int insercion = 0; insercion < listaCast.capacidad(); insercion++) {
                Object objetoActual = listaCast.obtenerElemento(insercion);
                this. borrarV(objetoActual);
            }    
        }else if(lista instanceof ListaInfoDinamicaOrdenada){
            ListaInfoEstaticaOrdenada listaCast = (ListaInfoEstaticaOrdenada) lista;
            for (int insercion = 0; insercion < listaCast.capacidad(); insercion++) {
                Object objetoActual = listaCast.obtenerElemento(insercion);
                this. borrarV(objetoActual);
            }    
        }
    }

    public void eliminarMatriz(MatrizInfo2 matriz) {
        for (int renglon = 0; renglon < matriz.obtenerRenglones(); renglon++) {
            for (int columna = 0; columna < matriz.obtenerColumnas(); columna++) {//Usamos dos for
                Object objetoActual = matriz.obtener(renglon, columna);
                this.borrarV(objetoActual);
            }
        }
    }

    public void reacomodar(Object elementoViejo, Object elementoNuevo){
        Nodo temp = apuntadorInicial;
        while (temp != null) {//Si hay un elemento igual al viejo lo sustituimos por el nuevo
            if (temp.getDato().equals(elementoViejo)) {
                this.borrar(temp.getDato());
                this.insertar(elementoNuevo);
            }
            temp = temp.getEnlaceDerecho();
        }
        
    }

    //Otros metodos...
    @Override
    public boolean iteradorNulo() {
        return super.iteradorNulo();
    }

    @Override
    public ListaInfoEstatica aListaEstatica() {
        return super.aListaEstatica();
    }

    @Override
    public ListaInfoEstatica aListaEstatica(ListaInfoEstatica elementosADescartar) {
        return super.aListaEstatica(elementosADescartar);
    }

    @Override
    public MatrizInfo2 aMatrizInfo2(int filas, int columnas) {
        return super.aMatrizInfo2(filas, columnas);
    }

    @Override
    public boolean agregarLista(Object lista2) {
        return super.agregarLista(lista2);
    }

    @Override
    public boolean agregarLista(ListaInfo listaDatos2) {
        return super.agregarLista(listaDatos2);
    }

    @Override
    public boolean agregarMatriz(MatrizInfo2 tabla, TipoTabla enumTipoTabla) {
        return super.agregarMatriz(tabla, enumTipoTabla);
    }

    @Override
    public ListaInfo arregloDesordenado() {
        return super.arregloDesordenado();
    }

    @Override
    public Object borrar(Object valor) {
        return super.borrar(valor);
    }

    @Override
    public Object borrar() {
        return super.borrar();
    }

    @Override
    public Object borrar(int indice) {
        return super.borrar(indice);
    }

    @Override
    public Object borrarInicio() {
        return super.borrarInicio();
    }

    @Override
    public boolean borrarLista(Object lista2) {
        return super.borrarLista(lista2);
    }

    @Override
    public ListaInfoDinamica borrarV(Object valor) {
        return super.borrarV(valor);
    }

    @Override
    public boolean cambiar(Object valorViejo, Object valorNuevo, int numVeces) {
        return super.cambiar(valorViejo, valorNuevo, numVeces);
    }

    @Override
    public boolean cambiar(int indice, Object valor) {
        return super.cambiar(indice, valor);
    }

    @Override
    public boolean cambiarLista(ListaInfoEstatica lista2, ListaInfoEstatica lista2Nuevos) {
        return super.cambiarLista(lista2, lista2Nuevos);
    }

    @Override
    public ListaInfo clonar() {
        return super.clonar();
    }

    @Override
    public int contar(Object valor) {
        return super.contar(valor);
    }

    @Override
    public boolean copiarLista(ListaInfoEstatica lista2) {
        return super.copiarLista(lista2);
    }

    @Override
    public Object encontrar(Object valor) {
        return super.encontrar(valor);
    }

    @Override
    public ListaInfoDinamica encontrarLista(Object valor) {
        return super.encontrarLista(valor);
    }

    @Override
    public ListaInfoEstatica encontrarValores(Object valor) {
        return super.encontrarValores(valor);
    }

    @Override
    public boolean esIgual(Object lista2) {
        return super.esIgual(lista2);
    }

    @Override
    public boolean esIgual(ListaInfo listaDatos2) {
        return super.esIgual(listaDatos2);
    }

    @Override
    public boolean esSublista(ListaInfoEstatica lista2) {
        return super.esSublista(lista2);
    }

    @Override
    public boolean estaLLeno() {
        return super.estaLLeno();
    }

    @Override
    public boolean estaVacia() {
        return super.estaVacia();
    }

    @Override
    public void iniciaIterador() {
        super.iniciaIterador();
    }

    @Override
    public boolean insertar(int indice, Object info) {
        return super.insertar(indice, info);
    }

    @Override
    public void invertir() {
        super.invertir();
    }

    @Override
    public void mostrar() {
        super.mostrar();
    }

    @Override
    public void mostrarOI() {
        super.mostrarOI();
    }

    @Override
    public Object obtenDato() {
        return super.obtenDato();
    }

    @Override
    public Object obtener(int indice) {
        return super.obtener(indice);
    }

    @Override
    public int obtenerCantidadDeElementos() {
        return super.obtenerCantidadDeElementos();
    }

    @Override
    public boolean redimensionar(int maximo) {
        return super.redimensionar(maximo);
    }

    @Override
    public void rellenar(Object valor) {
        super.rellenar(valor);
    }

    @Override
    public void rellenar(Object valor, int cantidad) {
        super.rellenar(valor, cantidad);
    }

    @Override
    public boolean retenerLista(ListaInfoEstatica lista2) {
        return super.retenerLista(lista2);
    }

    @Override
    public ListaInfoEstatica subLista(int indiceInicial, int indiceFinal) {
        return super.subLista(indiceInicial, indiceFinal);
    }

    @Override
    public void vaciar() {
        super.vaciar();
    }

    @Override
    public Object verFinal() {
        return super.verFinal();
    }

}