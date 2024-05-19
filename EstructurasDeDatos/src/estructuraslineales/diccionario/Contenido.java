package estructuraslineales.diccionario;

public class Contenido {
    private String concepto;
    private String definicion;
    private String sinonimos;
    private String uso;

    public Contenido(String concepto, String definicion, String sinonimo, String uso) {
        this.concepto = concepto;
        this.definicion = definicion;
        this.sinonimos = sinonimo;
        this.uso = uso;
    }

    public String getConcepto() {
        return concepto;
    }

    public String getComplementosDelConcepto(){
        return " "+
        "\n\tDefinicion: "+definicion+". "+
        "\n\tSinonimos: "+sinonimos+". "+
        "\n\tUsos: "+uso+". ";
    }

}