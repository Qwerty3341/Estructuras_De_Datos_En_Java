// package gestordecampesinos;

// import entradasalida.SalidaPorDefecto;
// import estructuraslineales.ListaInfoEstatica;

// public class GestorDeCampesinos {
    
//     ListaInfoEstatica listaDeCampesinos;

//     public GestorDeCampesinos(){}

//     public GestorDeCampesinos(int cuantosCampesinos){
//         this.listaDeCampesinos = new ListaInfoEstatica(cuantosCampesinos);
//     }

//     public static void calcularPromedioAnual(Campesino unCampesino) {
//         double sumaDeToneladas = 0;
    
//         sumaDeToneladas += calcularPromedioPorAnio(unCampesino.getYear1());
//         sumaDeToneladas += calcularPromedioPorAnio(unCampesino.getYear2());
//         sumaDeToneladas += calcularPromedioPorAnio(unCampesino.getYear3());
//         sumaDeToneladas += calcularPromedioPorAnio(unCampesino.getYear4());
    
//         double promedioAnual = sumaDeToneladas / 4; //Cantidad de años
//         SalidaPorDefecto.consola(unCampesino.getNombre()+" ");
//         SalidaPorDefecto.consola("promedio anual= "+promedioAnual+"\n");
//     }
    
//     private static double calcularPromedioPorAnio(Year year) {
//         ListaInfoEstatica listaDeArroz = year.getListaDeArrozProducidoEnUnAnio();
//         int cantidadDeToneladas = listaDeArroz.cantidad();
//         double sumaDeToneladas = 0;
    
//         for (int kilo = 0; kilo < cantidadDeToneladas; kilo++) {
//             double toneladaActual = (double) listaDeArroz.obtener(kilo);
//             sumaDeToneladas += toneladaActual;
//         }
    
//         double promedioAnual = sumaDeToneladas / 12; // Cantidad de meses
//         ;
//         return promedioAnual;
//     }
    
//     public static void obtenerMesDeMenosToneladasPorCadaAnio(GestorDeCampesinos gestorDeCampesinos) {
//         int totalCampesinos = gestorDeCampesinos.listaDeCampesinos.cantidad();
    
//         for (int camp = 0; camp < totalCampesinos; camp++) {
//             Campesino campesino = (Campesino) gestorDeCampesinos.listaDeCampesinos.obtenerElemento(camp);
//             SalidaPorDefecto.consola(campesino.getNombre()+"\n");
//             SalidaPorDefecto.consola("Meses con menos toneladas por año:"+"\n");
//             SalidaPorDefecto.consola("Año 1: " + obtenerMesConMenosToneladas(campesino.getYear1())+"\n");
//             SalidaPorDefecto.consola("Año 2: " + obtenerMesConMenosToneladas(campesino.getYear2())+"\n");
//             SalidaPorDefecto.consola("Año 3: " + obtenerMesConMenosToneladas(campesino.getYear3())+"\n");
//             SalidaPorDefecto.consola("Año 4: " + obtenerMesConMenosToneladas(campesino.getYear4())+"\n");
//         }
//     }
    
//     private static String obtenerMesConMenosToneladas(Year year) {
//         ListaInfoEstatica listaDeArroz = year.getListaDeArrozProducidoEnUnAnio();
//         int cantidadDeMeses = listaDeArroz.cantidad();
//         double menorCantidadToneladas = Double.MAX_VALUE;
//         int mesMenosToneladas = -1;
    
//         for (int mes = 0; mes < cantidadDeMeses; mes++) {
//             double toneladasActual = (double) listaDeArroz.obtener(mes);
//             if (toneladasActual < menorCantidadToneladas) {
//                 menorCantidadToneladas = toneladasActual;
//                 mesMenosToneladas = mes;
//             }
//         }
    
//         String mesMenosToneladasStr = (String) year.getListaDeMeses().obtener(mesMenosToneladas);
//         return mesMenosToneladasStr;
//     }  

//     public static void obtenerToneladasDelUltimoMesDeCadaAnio(Campesino campesino) {
//         SalidaPorDefecto.consola("Toneladas del último mes de cada año de " + campesino.getNombre() + "\n");
//         SalidaPorDefecto.consola("Año 1: " + obtenerUltimaTonelada(campesino.getYear1()) + "\n");
//         SalidaPorDefecto.consola("Año 2: " + obtenerUltimaTonelada(campesino.getYear2()) + "\n");
//         SalidaPorDefecto.consola("Año 3: " + obtenerUltimaTonelada(campesino.getYear3()) + "\n");
//         SalidaPorDefecto.consola("Año 4: " + obtenerUltimaTonelada(campesino.getYear4()) + "\n");
//     }
    
//     private static double obtenerUltimaTonelada(Year year) {
//         ListaInfoEstatica listaDeArroz = year.getListaDeArrozProducidoEnUnAnio();
//         return (double) listaDeArroz.obtener(listaDeArroz.cantidad() - 1);
//     }

//     public static void obtenerToneladasDelSegundoTrimestreDeCadaAnio(Campesino campesino) {
//         SalidaPorDefecto.consola("Toneladas del 2do trimestre de cada año de " + campesino.getNombre() + "\n");
//         sumarSegundoTrimestre(campesino);
//     }
    
//     private static void sumarSegundoTrimestre(Campesino unCamp) {
//         double sumaYear1Trimestre = sumarTrimestre(unCamp.getYear1(), 3, 5);
//         double sumaYear2Trimestre = sumarTrimestre(unCamp.getYear2(), 3, 5);
//         double sumaYear3Trimestre = sumarTrimestre(unCamp.getYear3(), 3, 5);
//         double sumaYear4Trimestre = sumarTrimestre(unCamp.getYear4(), 3, 5);
    
//         SalidaPorDefecto.consola("Año 1: " + sumaYear1Trimestre + "\n");
//         SalidaPorDefecto.consola("Año 2: " + sumaYear2Trimestre + "\n");
//         SalidaPorDefecto.consola("Año 3: " + sumaYear3Trimestre + "\n");
//         SalidaPorDefecto.consola("Año 4: " + sumaYear4Trimestre + "\n");
//     }
    
//     private static double sumarTrimestre(Year year, int inicio, int fin) {
//         double suma = 0;
//         ListaInfoEstatica listaDeArroz = year.getListaDeArrozProducidoEnUnAnio();
//         for (int indiceInicial = inicio; indiceInicial <= fin; indiceInicial++) {
//             double tonelada = (double) listaDeArroz.obtener(indiceInicial);
//             suma += tonelada;
//         }
//         return suma;
//     }

//     // public static void obtenerCampesinoConPeorTrabajoPorYear(GestorDeCampesinos gestorDeCampesinos) {
        
//     // }
    
    
//     // private static double sumarProduccionAnual(Year year) {
//     // }
    
    

//     public static void obtenerMesConMayorProduccion(Campesino campesino) {
//         //Anio 1
//         SalidaPorDefecto.consola(campesino.getNombre()+"\n");
//         double mayorProduccion = 0;
//         String mesConMayorProduccion = "";
//         for (int mes = 0; mes < campesino.getYear1().getListaDeArrozProducidoEnUnAnio().cantidad(); mes++) {
//             double produccionMesActual =  (double) campesino.getYear1().getListaDeArrozProducidoEnUnAnio().obtener(mes);
//             if (produccionMesActual > mayorProduccion) {
//                 mayorProduccion = produccionMesActual;
//                 mesConMayorProduccion = (String) campesino.getYear1().getListaDeMeses().obtener(mes);
//             }
//         }
//         SalidaPorDefecto.consola("La mejor produccion del año 1 fue en: " + mesConMayorProduccion + "(" + mayorProduccion + " toneladas)\n");

//         //anio 2
//         double mayorProduccion2 = 0;
//         String mesConMayorProduccion2 = "";
//         for (int mes = 0; mes < campesino.getYear2().getListaDeArrozProducidoEnUnAnio().cantidad(); mes++) {
//             double produccionMesActual = (double) campesino.getYear2().getListaDeArrozProducidoEnUnAnio().obtener(mes);
//             if (produccionMesActual > mayorProduccion2) {
//                 mayorProduccion2 = produccionMesActual;
//                 mesConMayorProduccion2 = (String) campesino.getYear2().getListaDeMeses().obtener(mes);
//             }
//         }
//         SalidaPorDefecto.consola("La mejor produccion del año 2 fue en: " + mesConMayorProduccion2 + "(" + mayorProduccion2 + " toneladas)\n");
//         //Anio 3
//         double mayorProduccion3 = 0;
//         String mesConMayorProduccion3 = "";
//         for (int mes = 0; mes < campesino.getYear3().getListaDeArrozProducidoEnUnAnio().cantidad(); mes++) {
//             double produccionMesActual = (double) campesino.getYear3().getListaDeArrozProducidoEnUnAnio().obtener(mes);
//             if (produccionMesActual > mayorProduccion3) {
//                 mayorProduccion3 = produccionMesActual;
//                 mesConMayorProduccion3 = (String) campesino.getYear3().getListaDeMeses().obtener(mes);
//             }
//         }
//         SalidaPorDefecto.consola("La mejor produccion del año 3 fue en: " + mesConMayorProduccion3 + "(" + mayorProduccion3 + " toneladas)\n");
        
//         //Anio 4
//         double mayorProduccion4 = 0;
//         String mesConMayorProduccion4 = "";
//         for (int mes = 0; mes < campesino.getYear4().getListaDeArrozProducidoEnUnAnio().cantidad(); mes++) {
//             double produccionMesActual = (double) campesino.getYear4().getListaDeArrozProducidoEnUnAnio().obtener(mes);
//             if (produccionMesActual > mayorProduccion4) {
//                 mayorProduccion4 = produccionMesActual;
//                 mesConMayorProduccion4 = (String) campesino.getYear4().getListaDeMeses().obtener(mes);
//             }
//         }
//         SalidaPorDefecto.consola("La mejor produccion del año 4 fue en: " + mesConMayorProduccion4 + "(" + mayorProduccion4 + " toneladas)\n");
//     }
    
    
//     public static void obtenerEpocaDelAnioConMayorGanancia(Campesino camp) {
//         //Year 1
//         double gananciaPrimavera1 = sumarGananciaDeEstacion(camp.getYear1(), 0, 1, 2);
//         double gananciaVerano1 = sumarGananciaDeEstacion(camp.getYear1(), 3, 4, 5);
//         double gananciaOtonio1 = sumarGananciaDeEstacion(camp.getYear1(), 6, 7, 8);
//         double gananciaInvierno1 = sumarGananciaDeEstacion(camp.getYear1(), 9, 10, 11);
//         String epocaConMayorGanancia1 = determinarEpocaConMayorGanancia(gananciaPrimavera1, gananciaVerano1, gananciaOtonio1, gananciaInvierno1);
//         SalidaPorDefecto.consola("Época del año1 con mayor ganancia: " + epocaConMayorGanancia1 + "\n");
//         //Year 2
//         double gananciaPrimavera2 = sumarGananciaDeEstacion(camp.getYear2(), 0, 1, 2);
//         double gananciaVerano2 = sumarGananciaDeEstacion(camp.getYear2(), 3, 4, 5);
//         double gananciaOtonio2 = sumarGananciaDeEstacion(camp.getYear2(), 6, 7, 8);
//         double gananciaInvierno2 = sumarGananciaDeEstacion(camp.getYear2(), 9, 10, 11);
//         String epocaConMayorGanancia2 = determinarEpocaConMayorGanancia(gananciaPrimavera2, gananciaVerano2, gananciaOtonio2, gananciaInvierno2);
//         SalidaPorDefecto.consola("Época del año2 con mayor ganancia: " + epocaConMayorGanancia2 + "\n");
//         // Year 3
//         double gananciaPrimavera3 = sumarGananciaDeEstacion(camp.getYear3(), 0, 1, 2);
//         double gananciaVerano3 = sumarGananciaDeEstacion(camp.getYear3(), 3, 4, 5);
//         double gananciaOtonio3 = sumarGananciaDeEstacion(camp.getYear3(), 6, 7, 8);
//         double gananciaInvierno3 = sumarGananciaDeEstacion(camp.getYear3(), 9, 10, 11);
//         String epocaConMayorGanancia3 = determinarEpocaConMayorGanancia(gananciaPrimavera3, gananciaVerano3, gananciaOtonio3, gananciaInvierno3);
//         SalidaPorDefecto.consola("Época del año3 con mayor ganancia: " + epocaConMayorGanancia3 + "\n");
//         // Year 4
//         double gananciaPrimavera4 = sumarGananciaDeEstacion(camp.getYear4(), 0, 1, 2);
//         double gananciaVerano4 = sumarGananciaDeEstacion(camp.getYear4(), 3, 4, 5);
//         double gananciaOtonio4 = sumarGananciaDeEstacion(camp.getYear4(), 6, 7, 8);
//         double gananciaInvierno4 = sumarGananciaDeEstacion(camp.getYear4(), 9, 10, 11);
//         String epocaConMayorGanancia4 = determinarEpocaConMayorGanancia(gananciaPrimavera4, gananciaVerano4, gananciaOtonio4, gananciaInvierno4);
//         SalidaPorDefecto.consola("Época del año4 con mayor ganancia: " + epocaConMayorGanancia4 + "\n");

//     }
    
//     private static double sumarGananciaDeEstacion(Year year, int mesInicio, int mesMedio, int mesFin) {
//         //Se suman los meses a los que estan asociados las estaciones que son 3 para cada estacion
//         ListaInfoEstatica listaDeArroz = year.getListaDeArrozProducidoEnUnAnio();
//         double gananciaMesInicio = (double) listaDeArroz.obtener(mesInicio);
//         double gananciaMesMedio = (double) listaDeArroz.obtener(mesMedio);
//         double gananciaMesFin = (double) listaDeArroz.obtener(mesFin);
//         return gananciaMesInicio + gananciaMesMedio + gananciaMesFin;
//     }
    
//     private static String determinarEpocaConMayorGanancia(double gananciaPrimavera, double gananciaVerano, double gananciaOtonio, double gananciaInvierno) {
//         double mayorGanancia = Math.max(gananciaPrimavera, Math.max(gananciaVerano, Math.max(gananciaOtonio, gananciaInvierno)));
//         if (mayorGanancia == gananciaPrimavera) {
//             return "Primavera";
//         } else if (mayorGanancia == gananciaVerano) {
//             return "Verano";
//         } else if (mayorGanancia == gananciaOtonio) {
//             return "Otoño";
//         } else {
//             return "Invierno";
//         }
//     }
    
//     public void agregarCampesino(Campesino unCampesino){
//         listaDeCampesinos.insertar(unCampesino);
//     }

//     public ListaInfoEstatica getListaDeCampesinos() {
//         return listaDeCampesinos;
//     }

//     public void setListaDeCampesinos(ListaInfoEstatica listaDeCampesinos) {
//         this.listaDeCampesinos = listaDeCampesinos;
//     }

    

// }
