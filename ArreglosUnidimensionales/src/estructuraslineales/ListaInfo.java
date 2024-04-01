package estructuraslineales;

public interface ListaInfo {
    
    public boolean estaVacia();

    public boolean estaLLeno();

    public Object insertar(Object valor);

    public Integer insertarInicio(Object valor);

    public Object encontrar(Object valor);

    public Object borrar(Object valor);

    public Object borrarInicio();

    public void mostrar();

    public boolean esIgual(Object lista2);

    public boolean cambiar(Object valorViejo, Object valorNuevo, int numVeces);
    
    public ListaInfoEstatica encontrarValores(Object valor);

    public Object borrar();

    public void vaciar();

    public boolean agregarLista(Object lista2);

    public void invertir();

    public int contar(Object valor);

    public boolean borrarLista(Object lista2);

    public void rellenar(Object valor, int cantidad);

    public ListaInfo clonar();

    public ListaInfoEstatica subLista(int indiceInicial, int indiceFinal);

    public boolean redimensionar(int maximo);

    public void rellenar(Object valor);

    public ListaInfo arregloDesordenado();

    public boolean esSublista(ListaInfoEstatica lista2);

    public boolean cambiarLista(ListaInfoEstatica lista2, ListaInfoEstatica lista2Nuevos);

    public boolean retenerLista(ListaInfoEstatica lista2);

    public boolean insertar(int indice, Object info);

    public boolean copiarLista(ListaInfoEstatica lista2);

    public Object verFinal();

    public void mostrarOI();
}