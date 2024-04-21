package estructuraslineales;

import entradasalida.SalidaPorDefecto;
import estructuraslineales.auxiliar.NodoClaveValor;
import estructuraslineales.auxiliar.NodoClaveValorBuscado;
import estructurasnolineales.MatrizInfo2;

public class ListaInfoDinamicaClave implements ListaInfo {

    protected NodoClaveValor apuntadorInicial;
    protected NodoClaveValor apuntadorFinal;

    public ListaInfoDinamicaClave() {
        this.apuntadorInicial = null;
        this.apuntadorFinal = null;
    }

    public boolean insertar(Object clave, Object valor) {
        if (vacia()) {// Caso de que la lista está vacía
            NodoClaveValor nodoNuevo = new NodoClaveValor(clave, valor);
            apuntadorInicial = nodoNuevo;
            apuntadorFinal = nodoNuevo;
            return true;
        } else { // Recorremos la lista para ver si hay claves repetidas
            NodoClaveValor temp = apuntadorInicial;
            while (temp != null) {
                if (temp.getClave().equals(clave)) {
                    temp.setValor(valor);
                    return true;
                }
                temp = temp.getEnlaceDerecho();
            }
            // Si la clave no existe, crea un nuevo nodo al final
            NodoClaveValor nodoNuevo = new NodoClaveValor(clave, valor);
            apuntadorFinal.setEnlaceDerecho(nodoNuevo);
            apuntadorFinal = nodoNuevo;
            return true;
        }
    }

    public boolean vacia() {// Metodo necesario para hacer el de insertar
        return apuntadorInicial == null;
    }

    public void mostrar() {
        NodoClaveValor temp = apuntadorInicial;
        while (temp != null) {// Se imprime la clave con su respectivo valor
            SalidaPorDefecto.consola(temp.getClave() + ":" + temp.getValor() + " -> ");
            temp = temp.getEnlaceDerecho();
        }
        SalidaPorDefecto.consola("null");
    }

    @Override
    public Object borrar(Object clave) {
        NodoClaveValorBuscado busqueda = encontrarNodoCV(clave);
        if (busqueda.getBuscado() == null) {
            return null;// No está el elemento o la lista está vacía
        } else {
            Object respaldo = busqueda.getBuscado().getValor();
            if (apuntadorInicial == apuntadorFinal) {
                apuntadorInicial = null;
                apuntadorFinal = null;
            } else if (apuntadorInicial == busqueda.getBuscado()) {
                apuntadorInicial = apuntadorInicial.getEnlaceDerecho();
            } else if (apuntadorFinal == busqueda.getBuscado()) {
                apuntadorFinal = busqueda.getAnterior();
                apuntadorFinal.setEnlaceDerecho(null);
            } else {
                busqueda.getAnterior().setEnlaceDerecho(busqueda.getBuscado().getEnlaceDerecho());
            }
            return respaldo;
        }
    }

    private NodoClaveValorBuscado encontrarNodoCV(Object clave) {
        // Recorremos todo el arreglo y recorremos todos los nodos
        NodoClaveValor temp = apuntadorInicial;
        NodoClaveValor anterior = apuntadorInicial;
        while (temp != null && clave.toString().equalsIgnoreCase(temp.getClave().toString()) == false) {
            anterior = temp;
            temp = temp.getEnlaceDerecho();
        }
        NodoClaveValorBuscado busqueda = new NodoClaveValorBuscado();
        busqueda.setBuscado(temp);
        busqueda.setAnterior(anterior);
        return busqueda;
    }

    public Object borrarContenido(Object valor) {
        NodoClaveValor temp = apuntadorInicial;
        Object contenido;
        while (temp != null) {
            if (temp.getValor().equals(valor) && temp.getValor() != null) {
                contenido = temp.getValor();
                temp.setValor("null");
                return contenido;
            }
            temp = temp.getEnlaceDerecho();
        }
        return null;// Si no encontramos nada regresamos un null
    }

    @Override
    public Object encontrar(Object clave) {
        NodoClaveValor temp = apuntadorInicial;
        Object valorDeLaClave;
        while (temp != null) {
            if (temp.getClave().equals(clave)) {
                // Regresamos el valor de la clave
                valorDeLaClave = temp.getValor();
                return valorDeLaClave;
            }
            temp = temp.getEnlaceDerecho();
        }
        return null;// Null si no encontramos nada
    }

    public Object encontrarContenido(Object valor) {
        NodoClaveValor temp = apuntadorInicial;
        Object claveDelValor;
        while (temp != null) {
            if (temp.getValor().equals(valor)) {
                // Regresamos la llave del valor
                claveDelValor = temp.getClave();
                return claveDelValor;
            }
            temp = temp.getEnlaceDerecho();
        }
        return null;// Null si no encontramos nada
    }

    public boolean cambiar(Object clave, Object valor) {
        NodoClaveValor temp = apuntadorInicial;
        while (temp != null) {
            if (temp.getClave().equals(clave)) {
                temp.setValor(valor);// Sustituimos la clase
                return true;// Esto quiere decir que lo encontro
            }
            temp = temp.getEnlaceDerecho();
        }
        return false;
    }

    public boolean cambiarValor(Object valorViejo, Object valorNuevo) {
        NodoClaveValor temp = apuntadorInicial;
        while (temp != null) {
            if (temp.getValor().equals(valorViejo)) {
                temp.setValor(valorNuevo);// Cambiamos los valores
                return true;
            }
            temp = temp.getEnlaceDerecho();
        }
        return false;// Valor no encontrado
    }

    public void mostrarClaves() {
        NodoClaveValor temp = apuntadorInicial;
        while (temp != null) {// Solo obtenemos la clave
            SalidaPorDefecto.consola(temp.getClave() + " -> ");
            temp = temp.getEnlaceDerecho();
        }
        SalidaPorDefecto.consola("null");
    }

    public void mostrarValores() {
        NodoClaveValor temp = apuntadorInicial;
        while (temp != null) {// Solo obtenemos el valor
            SalidaPorDefecto.consola(temp.getValor() + " -> ");
            temp = temp.getEnlaceDerecho();
        }
        SalidaPorDefecto.consola("null");
    }

    private int calcularTamanio() {
        // Metodo para ahorrar codigo en otros metodos
        NodoClaveValor temp = apuntadorInicial;
        int contador = 0;
        while (temp != null) {
            temp = temp.getEnlaceDerecho();
            contador += 1;
        }
        return contador;
    }

    public ListaInfoEstatica aListasEstaticas() {
        ListaInfoEstatica listas = new ListaInfoEstatica(2);// Tamanio 2 ya que es para la lista de claves y la de valores
        ListaInfoEstatica listaDeClaves = new ListaInfoEstatica(this.calcularTamanio());
        ListaInfoEstatica listaDeValores = new ListaInfoEstatica(this.calcularTamanio());
        // Obteniendo las claves
        NodoClaveValor temp = apuntadorInicial;
        while (temp != null) {
            listaDeClaves.insertar(temp.getClave());
            temp = temp.getEnlaceDerecho();
        }
        // Obteniendo los valores
        NodoClaveValor temp2 = apuntadorInicial;
        while (temp2 != null) {
            listaDeValores.insertar(temp2.getValor());
            temp2 = temp2.getEnlaceDerecho();
        }
        // Colocando los valores en la listas
        listas.insertar(listaDeClaves);
        listas.insertar(listaDeValores);
        return listas;
    }

    public ListaInfoDinamica aListasDinamicas() {
        ListaInfoDinamica listas = new ListaInfoDinamica();// Tamanio 2 ya que es para la lista de claves y la de valores
        ListaInfoDinamica listaDeClaves = new ListaInfoDinamica();
        ListaInfoDinamica listaDeValores = new ListaInfoDinamica();
        // Obteniendo las claves
        NodoClaveValor temp = apuntadorInicial;
        while (temp != null) {
            listaDeClaves.insertar(temp.getClave());
            temp = temp.getEnlaceDerecho();
        }
        // Obteniendo los valores
        NodoClaveValor temp2 = apuntadorInicial;
        while (temp2 != null) {
            listaDeValores.insertar(temp2.getValor());
            temp2 = temp2.getEnlaceDerecho();
        }
        // Colocando los valores en la listas
        listas.insertar(listaDeClaves);
        listas.insertar(listaDeValores);
        return listas;
    }

    public MatrizInfo2 aMatriz2() {
        int renglones = this.calcularTamanio();
        MatrizInfo2 matriz = new MatrizInfo2(renglones, 2);// Solo son dos columnas ya que son solo para clave y valor
        NodoClaveValor actual = apuntadorInicial;
        int fila = 0;
        while (actual != null && fila < renglones) {
            matriz.cambiar(fila, 0, actual.getClave()); // Clave en la columna 0
            matriz.cambiar(fila, 1, actual.getValor()); // Valor en la columna 1
            actual = actual.getEnlaceDerecho();
            fila++;
        }
        return matriz;
    }

    @Override
    public void vaciar() {
        this.apuntadorInicial = null;
    }

    public Object obtener(Object clave) {
        NodoClaveValor temp = apuntadorInicial;
        Object valorDeLaClave;
        while (temp != null) {
            if (temp.getClave().equals(clave)) {
                // Regresamos el valor de la clave
                valorDeLaClave = temp.getValor();
                return valorDeLaClave;
            }
            temp = temp.getEnlaceDerecho();
        }
        return null;// Null si no encontramos nada
    }

    public boolean agregarLista(ListaInfoDinamicaClave lista2) {
        // Itera sobre cada nodo en lista2 y lo inserta en la lista actual
        NodoClaveValor actual = lista2.apuntadorInicial;
        while (actual != null) {
            this.insertar(actual.getClave(), actual.getValor()); // Inserta la clave y el valor en la lista actual
            actual = actual.getEnlaceDerecho(); // Mueve al siguiente nodo en lista2
        }
        return true;
    }

    public int cantidad() {
        NodoClaveValor temp = apuntadorInicial;
        int contador = 0;
        while (temp != null) {
            temp = temp.getEnlaceDerecho();
            contador += 1;
        }
        // Devolvemos el contador
        return contador;
    }

    public boolean agregarListasEstaticas(ListaInfoEstatica arregloClaves, ListaInfoEstatica arregloValores) {
        if (arregloClaves.cantidad() != arregloValores.cantidad()) {
            return false; // Retorna falso si las listas no tienen el mismo tamanio
        }
        // Iterar sobre cada elemento de las listas
        for (int posicion = 0; posicion < arregloClaves.cantidad(); posicion++) {
            Object clave = arregloClaves.obtener(posicion);
            Object valor = arregloValores.obtener(posicion);
            if (clave != null && valor != null) {
                this.insertar(clave, valor);
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean agregarListasDinamicas(ListaInfoDinamica listaClaves, ListaInfoDinamica listaValores) {
        // Iterar sobre cada elemento de las listas
        if (listaClaves.obtenerCantidadDeElementos() != listaValores.obtenerCantidadDeElementos()) {
            return false;
        }
        for (int posicion = 0; posicion < listaClaves.obtenerCantidadDeElementos(); posicion++) {
            Object clave = listaClaves.obtener(posicion);
            Object valor = listaValores.obtener(posicion);
            if (clave != null && valor != null) {
                this.insertar(clave, valor);
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean agregarMatriz2(MatrizInfo2 matriz) {
        if (matriz.obtenerColumnas() != 2) {// Validar que la matriz tenga exactamente dos columnas
            return false;
        }
        // Pasamos la matriz a lista dinamica
        ListaInfoDinamica elementosDeLaMatriz = new ListaInfoDinamica();
        for (int fil = 0; fil < matriz.obtenerRenglones(); fil++) {
            for (int col = 0; col < matriz.obtenerColumnas(); col++) {
                elementosDeLaMatriz.insertar(matriz.obtener(fil, col));
            }
        }
        // Recorremos de dos en dos para obtener de dos en dos los elementos de la matriz
        for (int contador = 0; contador < elementosDeLaMatriz.obtenerCantidadDeElementos(); contador += 2) {
            Object claveActual = elementosDeLaMatriz.obtener(contador);
            Object valorActual = elementosDeLaMatriz.obtener(contador + 1);
            if (claveActual == null || valorActual == null) {
                continue;
            }
            if (this.insertar(claveActual, valorActual) == false) {
                return false;
            }
        }
        return true;
    }

    /*___________________________________________________________________________________-
     * Metodos de lista info
     */
    @Override
    public boolean estaLLeno() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'estaLLeno'");
    }

    @Override
    public Object insertar(Object valor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertar'");
    }

    @Override
    public Integer insertarInicio(Object valor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertarInicio'");
    }

    @Override
    public Object borrarInicio() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'borrarInicio'");
    }

    @Override
    public boolean esIgual(Object lista2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'esIgual'");
    }

    @Override
    public ListaInfoEstatica encontrarValores(Object valor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'encontrarValores'");
    }

    @Override
    public Object borrar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'borrar'");
    }

    @Override
    public boolean agregarLista(Object lista2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'agregarLista'");
    }

    @Override
    public void invertir() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'invertir'");
    }

    @Override
    public int contar(Object valor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'contar'");
    }

    @Override
    public boolean borrarLista(Object lista2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'borrarLista'");
    }

    @Override
    public void rellenar(Object valor, int cantidad) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'rellenar'");
    }

    @Override
    public ListaInfo clonar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clonar'");
    }

    @Override
    public ListaInfoEstatica subLista(int indiceInicial, int indiceFinal) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'subLista'");
    }

    @Override
    public boolean redimensionar(int maximo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'redimensionar'");
    }

    @Override
    public void rellenar(Object valor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'rellenar'");
    }

    @Override
    public ListaInfo arregloDesordenado() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'arregloDesordenado'");
    }

    @Override
    public boolean esSublista(ListaInfoEstatica lista2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'esSublista'");
    }

    @Override
    public boolean cambiarLista(ListaInfoEstatica lista2, ListaInfoEstatica lista2Nuevos) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cambiarLista'");
    }

    @Override
    public boolean retenerLista(ListaInfoEstatica lista2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'retenerLista'");
    }

    @Override
    public boolean insertar(int indice, Object info) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertar'");
    }

    @Override
    public boolean copiarLista(ListaInfoEstatica lista2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'copiarLista'");
    }

    @Override
    public Object verFinal() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'verFinal'");
    }

    @Override
    public void mostrarOI() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mostrarOI'");
    }

    @Override
    public boolean cambiar(Object valorViejo, Object valorNuevo, int numVeces) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cambiar'");
    }

    @Override
    public boolean estaVacia() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'estaVacia'");
    }
}
