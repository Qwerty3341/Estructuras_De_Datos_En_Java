package polinomios;

public class Monomio {

    private int coeficiente;
    private int potenciaX;
    private int potenciaY;

    public Monomio(int coeficiente, int potenciaX, int potenciaY) {
        this.coeficiente = coeficiente;
        this.potenciaX = potenciaX;
        this.potenciaY = potenciaY;
    }

    public int getCoeficiente() {
        return coeficiente;
    }

    public int getPotenciaX() {
        return potenciaX;
    }

    public int getPotenciaY() {
        return potenciaY;
    }

    public double evaluar(double x, double y) {
        return coeficiente * elevar(x, potenciaX) * elevar(y, potenciaY);
    }

    public double elevar(double base, int exponente) {
        if (exponente == 0) {
            return 1;
        } else if (exponente == 1) {
            return base;
        } else {
            return base * elevar(base, exponente - 1);
        }
    }

    @Override
    public String toString() {
        return coeficiente + "x^" + potenciaX + "y^" + potenciaY;
    }
}
