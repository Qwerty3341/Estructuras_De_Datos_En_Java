// package gestordecampesinos;

// import entradasalida.EntradaPorDefecto;
// import entradasalida.SalidaPorDefecto;

// public class GestorDeMenu{
    
//     GestorDeCampesinos gestorDeCampesinos = new GestorDeCampesinos(3);
//     Campesino campesino1;
//     Campesino campesino2;
//     Campesino campesino3;
//     Boolean ciclado;
   
//     public GestorDeMenu() {
//         ciclado = true;
//         gestorDeCampesinos = new GestorDeCampesinos(3);
//         campesino1 = new Campesino("Juan");
//         campesino2 = new Campesino("Aron");
//         campesino3 = new Campesino("Gary");

//         gestorDeCampesinos.agregarCampesino(campesino1);
//         gestorDeCampesinos.agregarCampesino(campesino2);
//         gestorDeCampesinos.agregarCampesino(campesino3);
    
//         campesino1.agregarArrozPorAnio("1",4.5, 0.6, 0.5, 3.5, 5.4, 6.7, 4.0, 3.9, 5.7, 9.2, 3.0, 2.1);
//         campesino1.agregarArrozPorAnio("2", 1.2, 2.3, 3.4, 4.5, 5.6, 6.7, 7.8, 8.9, 9.0, 1.1, 2.2, 3.3);
//         campesino1.agregarArrozPorAnio("3", 0.5, 1.5, 2.5, 3.5, 4.5, 5.5, 6.5, 7.5, 8.5, 9.5, 1.0, 2.0);
//         campesino1.agregarArrozPorAnio("4", 2.0, 4.0, 6.0, 8.0, 10.0, 12.0, 14.0, 16.0, 18.0, 20.0, 22.0, 24.0);
    
//         campesino2.agregarArrozPorAnio("1", 4.4, 0.6, 0.5, 3.5, 5.4, 6.7, 4.0, 3.9, 5.7, 9.2, 3.0, 2.1);
//         campesino2.agregarArrozPorAnio("2", 1.1, 2.3, 3.4, 4.5, 5.6, 6.7, 7.8, 8.9, 9.0, 1.1, 2.2, 3.3);
//         campesino2.agregarArrozPorAnio("3", 0.4, 1.5, 2.5, 3.5, 4.5, 5.5, 6.5, 7.5, 8.5, 9.5, 1.0, 2.0);
//         campesino2.agregarArrozPorAnio("4", 2.0, 4.0, 6.0, 8.0, 10.0, 12.0, 14.0, 16.0, 17.9, 20.0, 22.0, 24.0);
    
//         campesino3.agregarArrozPorAnio("1", 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0, 13.0, 14.0, 15.0, 16.0);
//         campesino3.agregarArrozPorAnio("2", 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0);
//         campesino3.agregarArrozPorAnio("3", 0.5, 1.5, 2.5, 3.5, 4.5, 5.5, 6.5, 7.5, 8.5, 9.5, 10.5, 11.5);
//         campesino3.agregarArrozPorAnio("4", 2.5, 4.5, 6.5, 8.5, 10.5, 12.5, 14.5, 16.5, 18.5, 20.5, 22.5, 24.5);

//     }

//     public void pedirOpcion() {
//         SalidaPorDefecto.consola("Opcion: ");
//         String opcion = EntradaPorDefecto.consolaCadenas();
//         gestionarRespuestas(opcion);
//     }

//     private void gestionarRespuestas(String opcion) {
//         switch (opcion) {
//             case "1":
//                 GestorDeCampesinos.calcularPromedioAnual(campesino1);
//                 GestorDeCampesinos.calcularPromedioAnual(campesino2);
//                 GestorDeCampesinos.calcularPromedioAnual(campesino3);
//                 SalidaPorDefecto.consola("");
//                 break;
//             case "2":
//                GestorDeCampesinos.obtenerMesDeMenosToneladasPorCadaAnio(gestorDeCampesinos);
//                 break;
//             case "3":
//                 GestorDeCampesinos.obtenerToneladasDelUltimoMesDeCadaAnio(campesino1);
//                 GestorDeCampesinos.obtenerToneladasDelUltimoMesDeCadaAnio(campesino2);
//                 GestorDeCampesinos.obtenerToneladasDelUltimoMesDeCadaAnio(campesino3);
//                 break;
//             case "4":
//                 GestorDeCampesinos.obtenerToneladasDelSegundoTrimestreDeCadaAnio(campesino1);
//                 GestorDeCampesinos.obtenerToneladasDelSegundoTrimestreDeCadaAnio(campesino2);
//                 GestorDeCampesinos.obtenerToneladasDelSegundoTrimestreDeCadaAnio(campesino3);
//                 break;
//             case "5":
//                 SalidaPorDefecto.consola("Metodo no agregado");
//                 break;
//             case "6":
//                 SalidaPorDefecto.consola("Metodo no agregado");
//                 break;
//             case "7":
//                 GestorDeCampesinos.obtenerEpocaDelAnioConMayorGanancia(campesino1);
//                 GestorDeCampesinos.obtenerEpocaDelAnioConMayorGanancia(campesino2);
//                 GestorDeCampesinos.obtenerEpocaDelAnioConMayorGanancia(campesino3);
//                 break;
//             case "8":
//                 SalidaPorDefecto.consola("Proceso Finalizado");
//                 ciclado = false;
//                 break;
//             default:
//                 SalidaPorDefecto.consola("ERROR\n");
//                 break;
//         }
//     }

//     public Boolean getCiclado() {
//         return ciclado;
//     }
// }
