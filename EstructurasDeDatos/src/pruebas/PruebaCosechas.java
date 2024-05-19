package pruebas;

import entradasalida.SalidaPorDefecto;
import estructuraslineales.ListaInfoEstatica;
import registros.cosechas.Campesino;
import registros.cosechas.Cosechas;

public class PruebaCosechas {
    public static void main(String[] args) {
        Cosechas cosecha = new Cosechas(4, 4, 5);

        Campesino campesino1 = new Campesino("JESA908976G94", "Jelipe", 20, 'H');
        Campesino campesino2 = new Campesino("REDS908976G93", "Juan", 29, 'H');
        Campesino campesino3 = new Campesino("ASDR208976G21", "Rito", 39, 'H');
        Campesino campesino4 = new Campesino("HGTF108976G27", "Antonio", 33, 'H');

        cosecha.agregarCampesino(campesino1);
        cosecha.agregarCampesino(campesino2);
        cosecha.agregarCampesino(campesino3);
        cosecha.agregarCampesino(campesino4);

        cosecha.agregarProducto("frijol");
        cosecha.agregarProducto("maiz");
        cosecha.agregarProducto("ajo");
        cosecha.agregarProducto("chile");

        cosecha.agregarAnio(2010);
        cosecha.agregarAnio(2003);
        cosecha.agregarAnio(2020);
        cosecha.agregarAnio(2023);
        cosecha.agregarAnio(2000);


        cosecha.agregarToneladas("JESA908976G94", "frijol", 2010, 40.4);
        cosecha.agregarToneladas("JESA908976G94", "maiz", 2003, 80.6);
        cosecha.agregarToneladas("ASDR208976G21", "maiz", 2003, 90.6);
        cosecha.agregarToneladas("ASDR208976G21", "maiz", 2000, 100.2);
        cosecha.agregarToneladas("HGTF108976G27", "ajo", 2023, 200.3);

        cosecha.mostrarCosechas();


        ListaInfoEstatica campesinosPedidos = new ListaInfoEstatica(3);
        campesinosPedidos.insertar(campesino1.getRfc());
        campesinosPedidos.insertar(campesino2.getRfc());
        campesinosPedidos.insertar(campesino4.getRfc());

        ListaInfoEstatica productosPedidos = new ListaInfoEstatica(3);
        productosPedidos.insertar("frijol");
        productosPedidos.insertar("maiz");
        productosPedidos.insertar("ajo");

        ListaInfoEstatica aniosPedidos = new ListaInfoEstatica(3);
        aniosPedidos.insertar(2000);
        aniosPedidos.insertar(2023);
        aniosPedidos.insertar(2003);



        SalidaPorDefecto.consola("\n Datos Consultados \n");
        campesinosPedidos.mostrar();
        SalidaPorDefecto.consola("\n");
        productosPedidos.mostrar();
        SalidaPorDefecto.consola("\n");
        aniosPedidos.mostrar();
        SalidaPorDefecto.consola("\n");
        SalidaPorDefecto.consola("Toneladas acumuladas: \n");
        ListaInfoEstatica toneladasTotales  = cosecha.toneladasCampesinos(campesinosPedidos, productosPedidos, aniosPedidos);
        toneladasTotales.mostrar();
        SalidaPorDefecto.consola("\n");

    }
}
