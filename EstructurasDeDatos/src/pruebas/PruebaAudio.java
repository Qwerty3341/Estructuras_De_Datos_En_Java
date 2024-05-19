package pruebas;

import audio.AudioFileRecord;
import entradasalida.SalidaPorDefecto;

public class PruebaAudio {
    public static void main(String[] args) {

        //AudioFileRecord audio = new AudioFileRecord("record.wav");
        AudioFileRecord a = new AudioFileRecord("a.wav");
        AudioFileRecord e = new AudioFileRecord("e.wav");
        AudioFileRecord i = new AudioFileRecord("i.wav");
        AudioFileRecord o = new AudioFileRecord("o.wav");
        AudioFileRecord u = new AudioFileRecord("u.wav");
        a.leerAudio();
        e.leerAudio();
        i.leerAudio();
        o.leerAudio();
        u.leerAudio();
        //Cosas de modificadcion
        //audio.preEnfasis();
        //audio.subirVolumen(40);
        //audio.bajarVolumen(1);
        //audio.acelerar();
        //audio.retrasar();
        
        //audio.invertirEjeX();
        //audio.invertirEjeY();
        SalidaPorDefecto.consola(a.obtenerEnergia()+"\n");
        SalidaPorDefecto.consola(e.obtenerEnergia()+"\n");
        SalidaPorDefecto.consola(i.obtenerEnergia()+"\n");
        SalidaPorDefecto.consola(o.obtenerEnergia()+"\n");
        SalidaPorDefecto.consola(u.obtenerEnergia()+"\n");
        // audio.salvarModificaciones();
        // audio.EscribirAudio();
        // audio.ver();
    }
}