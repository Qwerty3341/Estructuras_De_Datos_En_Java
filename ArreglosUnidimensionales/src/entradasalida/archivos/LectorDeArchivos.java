package entradasalida.archivos;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import entradasalida.SalidaPorDefecto;
import estructuraslineales.ListaInfoEstatica;
import utilerias.strings.StringManipulator;

public class LectorDeArchivos {
    public static void leer() throws IOException{
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

    public static void buscarID(int id) throws IOException {
        String idStr = String.valueOf(id);
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

}