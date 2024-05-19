package audio;

import java.io.*;

import audio.wavfile.WavFile;
import entradasalida.SalidaPorDefecto;
import estructuraslineales.ListaInfoEstaticaNumerica;

public class AudioFileRecord {
    private long numFrames;  //numero de tramas, número de muestras totales del archivo por canal
    private long sampleRate; //numero de muestras por segundo a la que se discretiza la señal
    private int numChannels; //número de canales
    private double[] buffer; //audio original
    private double[] buffer2; //audio modificado
    private String archivo;   //nombre de archivo dado por el usuario
    private WavFile wavFileR; //apuntador de archivo leido
    private WavFile wavFileW;  //apuntador de archivo a escribir
    private String nomArchivo; //nombre archivo (uno.wav)
    private String nomRuta;    //ruta donde esta guardado el archivo (/home)
    private int validBits;     //bits usados para la discretización

    ListaInfoEstaticaNumerica listaTemp;

    public AudioFileRecord(String archivo) {
        this.archivo = archivo;
        // Abre el archivo wav y asigna parámetros a las variables
        try {
            File file = new File(archivo);
            wavFileR = WavFile.openWavFile(file);
            nomArchivo = file.getName();
            nomRuta = file.getParent();
        } catch (Exception e) {

        }
        numChannels = wavFileR.getNumChannels();
        numFrames = wavFileR.getNumFrames();
        sampleRate = wavFileR.getSampleRate();
        validBits=wavFileR.getValidBits();
        SalidaPorDefecto.consola(archivo);
    }

    public void leerAudio() {
        try {
            // Muestra datos del archivo
            wavFileR.display();
            // Crea buffer de origen y de temporal
            buffer = new double[(int) numFrames * numChannels];
            buffer2 = new double[buffer.length];
            //tramas leidas
            int framesRead;
            // Lee tramas totales
            framesRead = wavFileR.readFrames(buffer, (int) numFrames);
            // Recorrer todas las tramas del archivo y guardarlas en el arreglo.
            for (int s = 0; s < framesRead * numChannels; s++) {
                buffer2[s] = buffer[s];
            }

            listaTemp = new ListaInfoEstaticaNumerica(buffer.length);
            listaTemp.hacerArreglo(buffer);

            // Cierra archivo
            wavFileR.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void EscribirAudio() {
        try {
            //Crear el apuntador al archivo para guardar datos del temporal
            File file = new File("2" + nomArchivo);
            // Creamos un nuevo archivo de audio con los mismos datos que el original
            wavFileW = WavFile.newWavFile(file, numChannels, numFrames, validBits, sampleRate);
            // Escribimos los frames o muestras totales del temporal
            wavFileW.writeFrames(buffer2, (int) numFrames);
            // Cerramos el archivo
            wavFileW.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    //Practica6
    public void ver(){
        listaTemp.mostrar();
    }
    
    private double[] conversionDouble(Double[] arr){//Convertimos los Dobles a dobles para evitar errores
        double[] arrdouble = new double[arr.length];
        for (int espacio = 0; espacio < arr.length; espacio++) {
            if (arr[espacio] != null) {
                arrdouble[espacio] = (double) arr[espacio].doubleValue();
            }else{
                arrdouble[espacio] = 0.0;
            }
        }
        return arrdouble;
    }

    public void salvarModificaciones(){
        this.buffer2 = conversionDouble(listaTemp.leerArreglo());
    }

    public void preEnfasis() {
        double a = 0.95;
        for (int num = 1; num < listaTemp.cantidad(); num++) {
            Double yn = (Double) listaTemp.obtener(num);
            Double xn = (Double) listaTemp.obtener(num-1);
            Double cambio =  yn + a * xn;
            listaTemp.cambiar(num, cambio);
        }
    }

    public void subirVolumen(int intensidad){
        listaTemp.porEscalar(intensidad);
    }

    public void bajarVolumen(int intensidad){
        double intensidadNegativa = (double) intensidad * 0.1;
        listaTemp.porEscalar(intensidadNegativa);
        
    }

    public void acelerar() {
        //Hacemos el audio el doble de rapido
        ListaInfoEstaticaNumerica audioAcelerado = new ListaInfoEstaticaNumerica(listaTemp.capacidad() / 2);
        int velocidad = 2; //Definimos la aceleracion del audio
        for (int index = 0; index < listaTemp.cantidad(); index += velocidad) {
            double acumulacion = 0;
            int elementosRecorridos = 0;
            for (int val = 0; val < velocidad; val++) {
                if (index + val < listaTemp.cantidad()) {
                    acumulacion += (double) listaTemp.obtener(index + val);
                    elementosRecorridos = elementosRecorridos+1;
                }
            }
            double promedio = acumulacion / elementosRecorridos;//Se calcula el promedio
            audioAcelerado.insertar(promedio);//Se inserta el promedio a la nueva lista
        }
        this.numFrames = audioAcelerado.cantidad();//Ponemos los nuevos frames
        listaTemp = audioAcelerado;
    }
    
    public void retrasar() {
        int frames = listaTemp.capacidad() * 2; // Duplicamos el número de frames
        ListaInfoEstaticaNumerica nuevoAudioRetrasado = new ListaInfoEstaticaNumerica(frames);
        for (int index = listaTemp.cantidad() - 1; index >= 0; index--) {
            double elemento = (double) listaTemp.obtener(index);
            nuevoAudioRetrasado.insertar(elemento);// Insertamos cada elemento dos veces en el nuevo arreglo para duplicar la duración
            nuevoAudioRetrasado.insertar(elemento);
        }
        this.numFrames = frames;
        listaTemp = nuevoAudioRetrasado; 
        listaTemp.invertir();//Se vuelve a invertir para que se escuche bien
    }

    // public void quitarSilencios() {
    // }

    public void invertirEjeX(){
        listaTemp.invertir();//Solo se invierte la lista
    }

    public void invertirEjeY(){
        for(int intensidad=0; intensidad < listaTemp.capacidad() ;intensidad++){
            double valor = (double) listaTemp.obtener(intensidad);//Obtenemos el valor
            double valorNegativo = valor * -1 ;//Invertimos el valor haciendolo negativo
            listaTemp.cambiar(intensidad, valorNegativo);
        }
    }

    public double obtenerEnergia() {
        double energia = 0.0;//Esta es la variable que vamos a regresar
        for (int elemPot = 0; elemPot < listaTemp.cantidad(); elemPot++) {
            double muestra = (double) listaTemp.obtener(elemPot);
            double energiaDeMuestra = Math.pow(muestra, 2);//Elevamos al cuadrado
            energia = energia + energiaDeMuestra;
        }
        return energia;
    }
    
}