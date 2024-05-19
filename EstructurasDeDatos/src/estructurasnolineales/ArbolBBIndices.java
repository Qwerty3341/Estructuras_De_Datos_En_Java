package estructurasnolineales;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import entradasalida.SalidaPorDefecto;
import estructuraslineales.ListaInfoEstatica;
import estructuraslineales.auxiliar.NodoBusquedaArbol;
import utilerias.strings.StringManipulator;

public class ArbolBBIndices {
    protected NodoBusquedaArbol raiz;

    public ArbolBBIndices() {
        this.raiz = null;
    }

    public boolean insertar(int indice, long direccion) {
        if (raiz == null) {
            raiz = new NodoBusquedaArbol(indice, direccion);
            return true;
        } else {
            return insertar(raiz, indice, direccion);
        }
    }

    private boolean insertar(NodoBusquedaArbol nodo, int indice, long direccion) {
        if (indice > nodo.getIndice()) {
            if (nodo.getEnlaceDer() == null) {
                nodo.setEnlaceDer(new NodoBusquedaArbol(indice, direccion));
                return true;
            } else {
                return insertar(nodo.getEnlaceDer(), indice, direccion);
            }
        } else if (indice < nodo.getIndice()) {
            if (nodo.getEnlaceIzq() == null) {
                nodo.setEnlaceIzq(new NodoBusquedaArbol(indice, direccion));
                return true;
            } else {
                return insertar(nodo.getEnlaceIzq(), indice, direccion);
            }
        } else {
            return false; // El indice ya existe, no se inserta
        }
    }

    public void buscarRegistro(int id) throws IOException {
        String idStr = String.valueOf(id);// Ponemos el id como str
        RandomAccessFile archivo = null;
        try {
            archivo = new RandomAccessFile("tabla.txt", "r");
            String linea;
            while ((linea = archivo.readLine()) != null) {

                ListaInfoEstatica columnas = StringManipulator.dividir(linea, ',');
                String cadenaActual = (String) columnas.obtener(0);
                if (columnas.cantidad() > 0 && StringManipulator.borrarEspaciosEnBlanco(cadenaActual).equals(idStr)) {
                    SalidaPorDefecto.consola("Registro: " + linea);
                    return;
                }
            }
            SalidaPorDefecto.consola("ID no encontrado.");
        } catch (FileNotFoundException fe) {
            SalidaPorDefecto.consola("Archivo no encontrado");
        } finally {
            if (archivo != null) {
                archivo.close();
            }
        }
    }

    public void insertarRegistro(int ORDER_ID, String ORDER_DATE , String ORDER_MODE, int CUSTOMER_ID,
        int ORDER_STATUS, int ORDER_TOTAL, double SALES_REP_ID, int PROMOTION_ID) throws IOException{
        //___________________________________________________________________________________________
        String nombreArchivo = "tabla.txt";
        RandomAccessFile archivo = new RandomAccessFile(nombreArchivo, "rw");
        archivo.seek(archivo.length());
        String registro = ORDER_ID + "," + ORDER_DATE + "," + ORDER_MODE + "," + CUSTOMER_ID + "," + 
        ORDER_STATUS + "," + ORDER_TOTAL + "," + SALES_REP_ID + "," + PROMOTION_ID + "\n";
        archivo.writeBytes(registro);
        long posicionRegistro = archivo.getFilePointer() - registro.length();
        archivo.close();
        this.insertar(ORDER_ID, posicionRegistro);
    }


    public NodoBusquedaArbol buscar(int indice) {
        return buscar(raiz, indice);
    }

    private NodoBusquedaArbol buscar(NodoBusquedaArbol nodo, int indice) {
        if (nodo == null) {
            return null;
        } else if (indice > nodo.getIndice()) {
            return buscar(nodo.getEnlaceDer(), indice);
        } else if (indice < nodo.getIndice()) {
            return buscar(nodo.getEnlaceIzq(), indice);
        } else {
            return nodo; // Nodo encontrado
        }
    }

    public void eliminar(int indice) {
        raiz = eliminar(raiz, indice);
    }

    private NodoBusquedaArbol eliminar(NodoBusquedaArbol nodo, int indice) {
        if (nodo == null) {
            return null;
        }
        if (indice < nodo.getIndice()) {
            nodo.setEnlaceIzq(eliminar(nodo.getEnlaceIzq(), indice));
        } else if (indice > nodo.getIndice()) {
            nodo.setEnlaceDer(eliminar(nodo.getEnlaceDer(), indice));
        } else {
            // Nodo con dos hijos
            if (nodo.getEnlaceIzq() != null && nodo.getEnlaceDer() != null) {
                NodoBusquedaArbol sucesor = obtenerSucesor(nodo.getEnlaceDer());
                nodo.setIndice(sucesor.getIndice());
                nodo.setDireccion(sucesor.getDireccion()); // Actualiza la dirección
                nodo.setEnlaceDer(eliminar(nodo.getEnlaceDer(), sucesor.getIndice()));
            } else if (nodo.getEnlaceIzq() != null) {
                return nodo.getEnlaceIzq();
            } else {
                return nodo.getEnlaceDer();
            }
        }
        return nodo;
    }

    private NodoBusquedaArbol obtenerSucesor(NodoBusquedaArbol nodo) {
        NodoBusquedaArbol actual = nodo;
        while (actual != null && actual.getEnlaceIzq() != null) {
            actual = actual.getEnlaceIzq();
        }
        return actual;
    }

    public void preorden() {
        preorden(raiz);
    }

    private void preorden(NodoBusquedaArbol nodo) {
        if (nodo != null) {
            SalidaPorDefecto.consola(nodo.getIndice() + " - " + nodo.getDireccion() + " ");
            preorden(nodo.getEnlaceIzq());
            preorden(nodo.getEnlaceDer());
        }
    }

    public void inorden() {
        inorden(raiz);
    }

    private void inorden(NodoBusquedaArbol nodo) {
        if (nodo != null) {
            inorden(nodo.getEnlaceIzq());
            SalidaPorDefecto.consola("["+nodo.getIndice() + " - " + nodo.getDireccion() + "] ");
            inorden(nodo.getEnlaceDer());
        }
    }

    public void postorden() {
        postorden(raiz);
    }

    private void postorden(NodoBusquedaArbol nodo) {
        if (nodo != null) {
            postorden(nodo.getEnlaceIzq());
            postorden(nodo.getEnlaceDer());
            SalidaPorDefecto.consola(nodo.getIndice() + " - " + nodo.getDireccion() + " ");
        }
    }

    /*
     * Metodos auxiliares (como getters )
     */

    public NodoBusquedaArbol getRaiz() {
        return raiz;
    }
}
