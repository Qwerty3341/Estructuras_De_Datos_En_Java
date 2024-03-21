package gestordecampesinos;

import entradasalida.SalidaPorDefecto;

public class Camp {

    private Year year1, year2, year3, year4;
    private String nombre;

    public Camp(String nombre) {
        this.nombre = nombre;
        year1 = new Year("Año 1");
        year2 = new Year("Año 2");
        year3 = new Year("Año 3");
        year4 = new Year("Año 4");
    }

    public void agregarArrozPorAnio(String numeroAnio, double tonelada1, double tonelada2, double tonelada3, double tonelada4, double tonelada5, double tonelada6, double tonelada7, double tonelada8, double tonelada9, double tonelada10, double tonelada11, double tonelada12) {
        switch (numeroAnio) {
            case "1":
                year1.ponerTodasLasToneladas(tonelada1, tonelada2, tonelada3, tonelada4, tonelada5, tonelada6, tonelada7, tonelada8, tonelada9, tonelada10, tonelada11, tonelada12);
                break;
            case "2":
                year2.ponerTodasLasToneladas(tonelada1, tonelada2, tonelada3, tonelada4, tonelada5, tonelada6, tonelada7, tonelada8, tonelada9, tonelada10, tonelada11, tonelada12);
                break;
            case "3":
                year3.ponerTodasLasToneladas(tonelada1, tonelada2, tonelada3, tonelada4, tonelada5, tonelada6, tonelada7, tonelada8, tonelada9, tonelada10, tonelada11, tonelada12);
                break;
            case "4":
                year4.ponerTodasLasToneladas(tonelada1, tonelada2, tonelada3, tonelada4, tonelada5, tonelada6, tonelada7, tonelada8, tonelada9, tonelada10, tonelada11, tonelada12);
                break;
            default:
                SalidaPorDefecto.consola("ERROR");
                break;
        }
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Year getYear1() {
        return year1;
    }

    public void setYear1(Year year1) {
        this.year1 = year1;
    }

    public Year getYear2() {
        return year2;
    }

    public void setYear2(Year year2) {
        this.year2 = year2;
    }

    public Year getYear3() {
        return year3;
    }

    public void setYear3(Year year3) {
        this.year3 = year3;
    }

    public Year getYear4() {
        return year4;
    }

    public void setYear4(Year year4) {
        this.year4 = year4;
    }

    public Year getYear(int numDeYear) {
        if (numDeYear == 1) {
            return getYear1();
        } else if (numDeYear == 2) {
            return getYear2();
        } else if (numDeYear == 3) {
            return getYear3();
        } else if (numDeYear == 4) {
            return getYear4();
        } else {
            return null;
        }
    }
}