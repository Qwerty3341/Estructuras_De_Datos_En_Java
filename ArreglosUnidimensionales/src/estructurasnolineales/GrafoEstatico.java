package estructurasnolineales;

import estructuraslineales.ListaInfoEstatica;
import estructurasnolineales.auxiliares.Vertice;

public class GrafoEstatico {

    protected ListaInfoEstatica vertices;
    protected MatrizInfo2 aristas;

    public GrafoEstatico(int cantidadVertices){
        vertices = new ListaInfoEstatica(cantidadVertices);
        aristas = new MatrizInfo2(cantidadVertices, cantidadVertices);
        aristas.rellenar(0.0);
    }

    public boolean agregarVertice(Object valor){
        int indiceVertice = (int) vertices.encontrar(valor);

        if (indiceVertice < 0) {//No existe, podemos agregar
            //Creamos el vertice
            Vertice verticeNuevo = new Vertice();
            verticeNuevo.setDato(valor);
            verticeNuevo.setIndice(vertices.cantidad());
            //lo ponemos en el arreglo de vertices
            int retorno = vertices.insertar(verticeNuevo);
            if (retorno<0) {//error
                return false;
            }else{
                return true;
            }
        }else{//ya existe y no podemos agregar
            return false;
        }
    }

    public boolean agregarArista(Object origen, Object destino, double peso){
        int indiceOrigen = (int) vertices.encontrar(origen);
        int indiceDestino = (int) vertices.encontrar(destino);
        if (indiceOrigen>=0 && indiceDestino>=0) {//existe
            return aristas.cambiar(indiceOrigen, indiceDestino, peso);
        }else{//no existe
            return false;
        }
    }

    public boolean agregarArista(Object origen, Object destino){
        return agregarArista(origen, destino, 1.0);
    }
}