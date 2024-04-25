package pruebas.pruebasdemetodosrecursivos;

import entradasalida.SalidaPorDefecto;
import estructuraslineales.sistemasnumericos.Binario;
import estructuraslineales.sistemasnumericos.Hexadecimal;

public class PruebaSistemasNumericos {
    public static void main(String[] args) {
        
        //Binario
        //Ver si es binario
        SalidaPorDefecto.consola("Es el 1345 binario?\n");
        if (Binario.verificarNumeroBinario("1345", 0)) {
            SalidaPorDefecto.consola("SI es binario\n");
        }else{
            SalidaPorDefecto.consola("NO es binario\n");
        }
        SalidaPorDefecto.consola("\nEs el 0100110110101101011 binario?\n");
        if (Binario.verificarNumeroBinario("0100110110101101011", 0)) {
            SalidaPorDefecto.consola("SI es binario\n");
        }else{
            SalidaPorDefecto.consola("NO es binario\n");
        }
        //Convertir a binario
        SalidaPorDefecto.consola("\n\n\n\n\n\n\n\n\n\n\n\n--------------------------------------------------------------------");
        SalidaPorDefecto.consola("\nConvirtiendo numeros a binarios:\n");

        SalidaPorDefecto.consola("\n150 = " + Binario.convertirABinario(150, ""));
        SalidaPorDefecto.consola("\n3341 = "+Binario.convertirABinario(3341, ""));
        SalidaPorDefecto.consola("\n87298172 = "+Binario.convertirABinario(87298172, ""));
        
        SalidaPorDefecto.consola("\n\n\n\n\n\n\n\n\n\n\n\n--------------------------------------------------------------------");
        SalidaPorDefecto.consola("\nConvirtiendo numeros a hexadecimal:\n");
        SalidaPorDefecto.consola("\n65029 = " + Hexadecimal.convertirAHexadecimal(65029, ""));
        SalidaPorDefecto.consola("\n789 = " + Hexadecimal.convertirAHexadecimal(789, ""));
        SalidaPorDefecto.consola("\n89080 = " + Hexadecimal.convertirAHexadecimal(89080, ""));
    }
}
