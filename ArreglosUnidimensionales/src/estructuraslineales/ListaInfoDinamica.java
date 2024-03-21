package estructuraslineales;

import entradasalida.SalidaPorDefecto;
import estructuraslineales.auxiliar.Nodo;
import estructuraslineales.auxiliar.NodoBuscado;

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
    public void vaciar() {
        
        throw new UnsupportedOperationException("Unimplemented method 'vaciar'");
    }

    @Override
    public boolean agregarLista(Object lista2) {
        
        throw new UnsupportedOperationException("Unimplemented method 'agregarLista'");
    }

    @Override
    public void invertir() {
        
        throw new UnsupportedOperationException("Unimplemented method 'invertir'");
    }

    @Override
    public int contar(Object valor) {
        
        throw new UnsupportedOperationException("Unimplemented method 'contar'");
    }

    @Override
    public boolean borrarLista(Object lista2) {
        
        throw new UnsupportedOperationException("Unimplemented method 'borrarLista'");
    }

    @Override
    public void rellenar(Object valor, int cantidad) {
        
        throw new UnsupportedOperationException("Unimplemented method 'rellenar'");
    }

    @Override
    public ListaInfoEstatica clonar() {
        
        throw new UnsupportedOperationException("Unimplemented method 'clonar'");
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

}
