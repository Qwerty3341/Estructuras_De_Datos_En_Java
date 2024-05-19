package estructuraslineales;

public interface VectorListaInfo extends ListaInfo {

    public boolean estaLLeno();
    
    public int capacidad();

    public int cantidad();

    public Object obtener(int indice);

    public boolean cambiar(int indice, Object valor);

    public boolean cambiarLista(ListaInfoEstatica indicesBusqueda, ListaInfoEstatica valoresNuevos);

    public Object borrar(int indice);
}