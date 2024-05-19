package polinomios;

import estructuraslineales.ListaInfoDinamica;

public class Polinomio {
    private ListaInfoDinamica monomios;
    private int terminoIndependiente;

    public Polinomio(int terminoIndependiente) {
        this.monomios = new ListaInfoDinamica();
        this.terminoIndependiente = terminoIndependiente;
    }

    public void aniadirMonomio(Monomio unMonomio){
        monomios.insertar(unMonomio);
    }

    public double evaluar(double x, double y) {
        return evaluarRecursivo(x, y, 0) + terminoIndependiente;
    }

    private double evaluarRecursivo(double x, double y, int indice) {
        if (indice >= monomios.obtenerCantidadDeElementos()) {
            return 0;  // Caso base: si el índice es igual al tamaño de la lista, retorna 0
        } else {
            Monomio monomio = (Monomio) monomios.obtener(indice);  // Obtiene el monomio 
            double resultMonomio = monomio.getCoeficiente() * monomio.elevar(x, monomio.getPotenciaX()) * monomio.elevar(y, monomio.getPotenciaY());
            return resultMonomio + evaluarRecursivo(x, y, indice + 1);  // Sumamos el resultado del monomio actual y los siguientes
        }
    }

    @Override
    public String toString() {
        String polinomioStr = "p(x)=";
        boolean primerTermino = true;
        monomios.iniciaIterador();
        Monomio monomio;

        while ((monomio = (Monomio) monomios.obtenDato()) != null) {
            if (primerTermino) {
                primerTermino = false;
            } else {
                if (monomio.getCoeficiente() >= 0) {
                    polinomioStr += " +";
                } else {
                    polinomioStr += " ";
                }
            }
            polinomioStr += monomio.toString();
        }

        if (terminoIndependiente >= 0 && primerTermino == false) {
            polinomioStr += " +";
        } else if (primerTermino == false) {
            polinomioStr += " ";
        }
        polinomioStr += terminoIndependiente;
        
        return polinomioStr;
    }
}

