package estructuraslineales;

import entradasalida.SalidaPorDefecto;

public class ListaInfoEstatica implements VectorListaInfo{

    protected Object arreglo[];
    protected int CAPACIDAD;
    protected int posFinal;

    public ListaInfoEstatica(int cuantos){
        CAPACIDAD = cuantos;
        arreglo = new Object[cuantos];
        posFinal = -1;
    }

    //Determina si un TDA Arreglo no contiene nada.
    public boolean estaVacia(){
        if (posFinal == -1){
            return true;
        }else {
            return false;
        }
    }

    public boolean estaLLeno(){
        if (posFinal ==(CAPACIDAD -1)){
            return true;
        }else {
            return false;
        }
    }

    public Integer insertar(Object valor){
            if(estaLLeno()==false){ //si hay espacio
                posFinal = posFinal + 1;
                arreglo[posFinal]=valor;
                return posFinal;
            }else { //no hay espacio
                return -1;
            }
    }

    @Override
    public Integer insertarInicio(Object valor) {
        return 0;
    }

    public Object encontrar(Object valor){
        int posicionBusqueda = 0;
        while (posicionBusqueda<=posFinal && valor.toString().equalsIgnoreCase(arreglo[posicionBusqueda].toString())==false){
            posicionBusqueda = posicionBusqueda+1;
        }
        if(posicionBusqueda>posFinal){
            return -1;
        }else {
            return posicionBusqueda;
        }
    }

    public Object borrar(Object valor) {
        int posicion = (Integer) encontrar(valor);
        if (posicion>=0){ //lo encontramos
            Object respaldo=arreglo[posicion];
            posFinal = posFinal - 1;
            for(int posMod=posicion; posMod<= posFinal;posMod++){
                arreglo[posMod] = arreglo[posMod + 1];
            }
            return respaldo;
        }else{
            //no lo encontramos
            return null;
        }
    }
    
    public void mostrar(){
        for(int posIndice=posFinal; posIndice>=0; posIndice-- ){
            SalidaPorDefecto.consola(arreglo[posIndice]+"\n");
        }
    }

    @Override
    public boolean esIgual(Object lista2) {
        /*
        Este método indica si la lista actual es igual a la lista2
        */
        ListaInfoEstatica listaActual = (ListaInfoEstatica) lista2;
        if (this.cantidad() != listaActual.cantidad()) {
            return false; // Si las listas tienen diferente cantidad de elementos, no son iguales
        }
        for (int elemento = 0; elemento < this.cantidad(); elemento++) {   
            Object elementoListaActual = this.arreglo[elemento];
            Object elementoOtraLista = listaActual.arreglo[elemento];
            if (elementoListaActual.toString().equalsIgnoreCase(elementoOtraLista.toString()) == false) {
                return false; // Si hay algún elemento diferente, las listas no son iguales
            }
        }
        return true;
    }
    
    public int capacidad(){
        return CAPACIDAD;
    }

    public int cantidad(){
        return posFinal+1;
    }

    @Override
    public Object obtener(int indice) {
        if ( indice > posFinal || indice <= -1  ) { //revisa que el indice sea válido
            return null;
        }
        return arreglo[indice];
    }

    @Override
    public boolean cambiar(Object valorViejo, Object valorNuevo, int numVeces) {
        int modificacionesRealizadas = 0;
    
        for (int indice = 0; indice <= posFinal; indice++) {
            if (arreglo[indice] != null && arreglo[indice].equals(valorViejo)) {//revisa que el valor no sea nulo y que el objeto en la posicion indice sea igual al valor viejo
                arreglo[indice] = valorNuevo;
                modificacionesRealizadas = modificacionesRealizadas + 1;
    
                if (modificacionesRealizadas == numVeces) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean cambiar(int indice, Object valor) {
        // Verificar si el índice está dentro del rango válido y verificar que no sea null
        if (indice >= 0 && indice <= posFinal && arreglo[indice] != null) {
            arreglo[indice] = valor;
            return true; 
        } else {
            return false;
        }
    }

    @Override
    public boolean cambiarLista(ListaInfoEstatica indicesBusqueda, ListaInfoEstatica valoresNuevos) {
        if ( valoresNuevos.posFinal <= indicesBusqueda.posFinal ) {//se valoran los indices
            for (int indices = 0; indices < indicesBusqueda.CAPACIDAD; indices++) {

                arreglo[indices] = valoresNuevos.obtener(indices);
            }       
            return true;         
        }
        return false;
    }

    @Override
    public ListaInfoEstatica encontrarValores(Object valor) {
        ListaInfoEstatica nuevaListaInfoEstatica = new ListaInfoEstatica(this.capacidad());
        
        for (int elementoBuscado = 0; elementoBuscado < this.cantidad(); elementoBuscado++) {
            if (valor.toString().equalsIgnoreCase(this.arreglo[elementoBuscado].toString())) {//se ignora si el elemento esta en mayúscula o minúscula
                nuevaListaInfoEstatica.insertar(elementoBuscado);
            }
        }
        return nuevaListaInfoEstatica;
    }
    
    @Override
    public Object borrar(int indice){
        Object respaldo;
        int contador = 0;
        for (int elemento = 0; elemento <= indice; elemento++) {
            contador+=1;
        }   
        respaldo = arreglo[contador];
        return respaldo;
    }

    @Override
    public Object borrar() {
        if (estaVacia() == false) {
            Object respaldo = arreglo[posFinal];
            posFinal = posFinal - 1;
            return respaldo;
        }else{
            return null;
        }
    }

    @Override
    public void vaciar() {
        for (int indice = 0; indice < arreglo.length; indice++) {
            this.arreglo[indice] = null;//Se dejan todos los elementos como null
        }
    }

    @Override
    public boolean agregarLista(Object lista2) {
        if (lista2 instanceof ListaInfoEstatica == false) {//primero se comprueba de que sea una instancia de ListaInfoEstatica
            return false;
        } else {
            ListaInfoEstatica nuevaLista = (ListaInfoEstatica) lista2;
            int nuevaCapacidad = this.capacidad() + nuevaLista.cantidad();
            this.CAPACIDAD = nuevaCapacidad;
            //En este ciclo se agregan los nuevos elementos
            for (int indice = 0; indice < nuevaLista.cantidad(); indice++) {
                this.arreglo[this.posFinal + indice + 1] = nuevaLista.obtener(indice);
            }
            this.posFinal = this.posFinal + nuevaLista.cantidad(); // actualiza la posFinal
            return true;
        }
    }

    @Override
    public void invertir() {
        //Estas variables se usan para determinar el rango o el tamaño del arreglo y reducirlo para invertir los elementos
        int indiceInicial = 0;
        int indiceFinal = this.cantidad() - 1;
        while (indiceInicial < indiceFinal) {
            Object condenedor = this.arreglo[indiceInicial];
            this.arreglo[indiceInicial] = this.arreglo[indiceFinal];
            this.arreglo[indiceFinal] = condenedor;
            indiceInicial = indiceInicial + 1;
            indiceFinal = indiceFinal - 1;
        }
    }

    @Override
    public int contar(Object valor) {
        int contadorDeElementos = 0;
        for (int indice = 0; indice < this.capacidad() ; indice++) {
            if ( valor.toString().equalsIgnoreCase((this.arreglo[indice]).toString())) {
                //En este if se compara cada elemento del arreglo
                contadorDeElementos = contadorDeElementos + 1;
            }
        }
        return contadorDeElementos;
    }

    @Override
    public boolean borrarLista(Object lista2) {
        if (lista2 instanceof ListaInfoEstatica == false) {
            return false;
        } else {
            ListaInfoEstatica nuevaLista = (ListaInfoEstatica) lista2;
            //Los dos for son para que uno tenga una variable que solo cambia cuando el otro for se acaba de iterar
            for (int iteradorActual = 0; iteradorActual <= this.posFinal; iteradorActual++) {
                for (int elementoActual = 0; elementoActual < nuevaLista.cantidad(); elementoActual++) {
                    if (this.arreglo[iteradorActual] != null && this.arreglo[iteradorActual].equals(nuevaLista.obtener(elementoActual))) {
                        this.arreglo[iteradorActual] = null; 
                        break; 
                    }
                }
            }
            return true;
        }
    }

    @Override
    public void rellenar(Object valor, int cantidad) {
        if (this instanceof ListaInfoEstatica) {
            if (cantidad > this.capacidad()) {
                cantidad = this.capacidad();
            }
        }
        for (int indice = 0; indice < cantidad; indice++) {
            this.insertar(valor);
        }
    }

    @Override
    public ListaInfoEstatica clonar() {
        ListaInfoEstatica nuevaLista = new ListaInfoEstatica(this.capacidad());
        //Se hace una nueva y se itera para insertar los elementos de la lista actual
        for (int elemento = 0; elemento < arreglo.length; elemento++) {
            nuevaLista.insertar(this.arreglo[elemento]);
        }
        return nuevaLista;
        
    }

    @Override
    public ListaInfoEstatica subLista(int indiceInicial, int indiceFinal) {
        if (indiceInicial < 0 || indiceFinal >= capacidad() || indiceInicial > indiceFinal) {
            return null;//Se valida que esten bien los indices
        }       
        ListaInfoEstatica subLista = new ListaInfoEstatica(indiceFinal - indiceInicial + 1);
        for (int indiceActual = indiceInicial; indiceActual <= indiceFinal; indiceActual++) {
            subLista.insertar(arreglo[indiceActual]);
        }
        return subLista;
    }

    @Override
    public boolean redimensionar(int maximo) {
        if(maximo < this.capacidad()) {   
            var nuevaLista = subLista(0,maximo);//Se hace una sublista desde el 0 hasta el maximo
            this.CAPACIDAD = maximo;
            for(int elemento=0; elemento < maximo ;elemento++){//Se agregan los elementos a la nueva lista
                this.arreglo[elemento] = nuevaLista.arreglo[elemento];
            }
            this.posFinal = maximo -1;//Actualizamos la pos final para evitar errores
            return true;
    
        } else if (maximo > this.capacidad()) {
            ListaInfoEstatica elementosFaltantes = new ListaInfoEstatica(maximo - this.CAPACIDAD);//Esta lista van a ser los espacios nuevos que se le agregaron 
            ListaInfoEstatica almacen = this.clonar();//Se hace un clon de los elementos que ya estaban
            ListaInfoEstatica listaRedimensionada = new ListaInfoEstatica(maximo);
            listaRedimensionada.agregarLista(almacen);//Se agrega el almacen y los elementos faltantes
            listaRedimensionada.agregarLista(elementosFaltantes);
            elementosFaltantes.rellenar(null, maximo);
            // Se sobre escriben los parametros de la lista actual para evitar errores
            this.arreglo = listaRedimensionada.arreglo;
            this.CAPACIDAD = maximo;
            this.posFinal = maximo -1;
            return true;
        } else {
            return false;
        }
    }
    //Metodos agregados p3
    public Object[] getArreglo() {
        return arreglo;
    }

    public void setArreglo(Object[] arreglo) {
        this.arreglo = arreglo;
    }
    
    public Object obtenerElemento(int indice){
        if (indice>=0 && indice < arreglo.length) {
            return arreglo[indice];
        } else {
            return null;            
        }
    }

    public boolean ordenar() {//Voy a usar bubble sort para ordenar la lista de mayor a menor en caso de que los objetos sean enteros o flotantes
        //Aqui validamos que los elementos sean diferentes de strings ya que las strings no se ordenan de esta manera
        if (this.estaVacia()) {
            return false;
        }
        if (this.obtener(0) instanceof String) {
            return false;
        } else {
            int n = this.cantidad();
            for (int indice = 0; indice < n; indice++) {
                for (int subindice = 1; subindice < (n - indice); subindice++) {
                    if (this.obtener(indice) instanceof Integer || this.obtener(indice) instanceof Float) {
                        if ((float) this.obtenerElemento(subindice - 1) > (float) this.obtenerElemento(subindice)) {
                            float temp = (float) this.obtenerElemento(subindice - 1);
                            this.cambiar(subindice - 1, this.obtenerElemento(subindice));
                            this.cambiar(subindice, temp);
                        }
                    }
                }
            }
    
            return true;
        }
    }

    @Override
    public boolean insertar(int indice, Object info) {
        for (int index = 0; index < arreglo.length; index++) {
            if (index == indice) {
                arreglo[index] = info;
                break;
            }
        }
        return true;
    }

    public ListaInfoEstatica subLista(ListaInfoEstaticaNumerica listaIndices){
        ListaInfoEstatica arregloDeIndices = new ListaInfoEstatica(listaIndices.capacidad());//Se pone la cantidad al nuevo arreglo
        for (int indN = 0; indN < arregloDeIndices.cantidad(); indN++){
            arregloDeIndices.insertar(listaIndices.arreglo[indN]);//Agregamos los indices al otro arreglo
        }
        return arregloDeIndices;
    }

    //Metodos que no se usan en esta clase
    @Override
    public boolean copiarLista(ListaInfoEstatica lista2) {
        throw new UnsupportedOperationException("Unimplemented method 'copiarLista'");
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
    public boolean retenerLista(ListaInfoEstatica lista2) {
        throw new UnsupportedOperationException("Unimplemented method 'retenerLista'");
    }

    /*
    /Methods from practice 6 
    */
    public void hacerArreglo(Object[] arr){
        redimensionar(arr.length);
        for (int lug = 0; lug < arr.length; lug++) {
            insertar(arr[lug]);
        }   
    }

    public Object[] leerArreglo(){
        Object[] clon = new Object[CAPACIDAD];
        for (int lug = 0; lug < CAPACIDAD; lug++) {
            clon[lug] = arreglo[lug];
        }
        return clon;
    }

    @Override
    public Object verFinal() {
        if (estaVacia() == false) {
            return arreglo[posFinal];
        }else{
            return null;
        }
    }

    @Override
    public Object borrarInicio() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'borrarInicio'");
    }

}      
