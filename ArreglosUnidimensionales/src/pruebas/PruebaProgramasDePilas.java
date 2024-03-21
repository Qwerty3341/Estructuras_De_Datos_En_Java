package pruebas;

import java.nio.channels.SeekableByteChannel;

import javax.management.Descriptor;

import entradasalida.EntradaPorDefecto;
import entradasalida.SalidaPorDefecto;
import programasdepilas.Calculadora;
import programasdepilas.Desencriptador;
import programasdepilas.Encriptador;

public class PruebaProgramasDePilas {

    public static void main(String[] args) {
        //Calculadora
            // SalidaPorDefecto.consola("Coloca una expresion infija:\n");
            // var expresion = EntradaPorDefecto.consolaCadenas();
            // String a = Calculadora.pasarAPostfija(expresion);
            // SalidaPorDefecto.consola(a);

        //Encriptador
            // SalidaPorDefecto.consola("Mensaje:\n");
            // var men = EntradaPorDefecto.consolaCadenas();
            // SalidaPorDefecto.consola("Coloca las agrupaciones\n");
            // var agrupaciones = EntradaPorDefecto.consolaInt();
            // SalidaPorDefecto.consola(Encriptador.encriptar(men,agrupaciones));
        //Desencriptador
            SalidaPorDefecto.consola("Mensaje:\n");
            var men = EntradaPorDefecto.consolaCadenas();
            SalidaPorDefecto.consola("Coloca las agrupaciones\n");
            var agrupaciones = EntradaPorDefecto.consolaInt();
            var mensajeEncriptado = Encriptador.encriptar(men,agrupaciones);
            SalidaPorDefecto.consola("Mensaje="+mensajeEncriptado+"\n");
            SalidaPorDefecto.consola(Desencriptador.desencriptar(mensajeEncriptado));

    }
    
}