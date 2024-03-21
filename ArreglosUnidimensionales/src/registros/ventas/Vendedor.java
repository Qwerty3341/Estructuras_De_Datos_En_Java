package registros.ventas;

public class Vendedor {

    protected int numVendedor;
    protected String nombre;
    protected String fechaNacimiento;
    protected char sexo;

    public Vendedor(int numVendedor, String nombre, String fechaNacimiento, char sexo) {
        this.numVendedor = numVendedor;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
    }

    public int getNumVendedor() {
        return numVendedor;
    }

    public void setNumVendedor(int numVendedor) {
        this.numVendedor = numVendedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    @Override 
    public String toString(){
        return ""+numVendedor;
    }
}