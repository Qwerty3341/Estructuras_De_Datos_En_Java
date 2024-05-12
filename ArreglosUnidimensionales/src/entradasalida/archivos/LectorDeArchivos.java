package entradasalida.archivos;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import entradasalida.SalidaPorDefecto;
import estructuraslineales.ListaInfoEstatica;
import estructurasnolineales.ArbolBBIndices;
import utilerias.strings.StringManipulator;

public class LectorDeArchivos {
    public static void leer() throws IOException {
        boolean finArchivo = false;
        RandomAccessFile archivo = null;
        try {
            archivo = new RandomAccessFile("tabla.txt", "r");
            System.out.println("El tamaño es: " + archivo.length());
            String cad = "";
            while (true) {
                System.out.print("Pos: " + archivo.getFilePointer());
                cad = archivo.readLine();
                if (cad == null)
                    break;
                System.out.println(" - " + cad);
            }
        } catch (FileNotFoundException fe) {
            System.out.println("No se encontró el archivo");
        }
        System.out.println("\n");
        archivo.seek(9071);
        System.out.println(archivo.readLine());
        System.out.println("\n");
        archivo.close();
    }

    public static ArbolBBIndices guardarRegistros() throws IOException {
        ArbolBBIndices arbolDeIndices = new ArbolBBIndices();
        RandomAccessFile archivo = null;

        try {
            archivo = new RandomAccessFile("tabla.txt", "r");

            String linea = archivo.readLine();
            long direccionActual = archivo.getFilePointer();

            while ((linea = archivo.readLine()) != null) {

                ListaInfoEstatica datos = StringManipulator.dividir(linea, ',');
                String datoActual = (String) datos.obtenerElemento(0);
                int indiceActual = Integer.parseInt(StringManipulator.borrarEspaciosEnBlanco(datoActual));
                arbolDeIndices.insertar(indiceActual, direccionActual);
                direccionActual = archivo.getFilePointer();
            }
        } catch (FileNotFoundException fe) {
            SalidaPorDefecto.consola("Archivo no encontrado");
        } catch (Exception e) {
            SalidaPorDefecto.consola("Error al leer archivo" + e);
        } finally {
            if (archivo != null) {
                archivo.close();
            }
        }
        return arbolDeIndices;
    }
}