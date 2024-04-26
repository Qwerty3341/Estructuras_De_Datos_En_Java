package polinomios;

import estructuraslineales.ListaInfoDinamicaClave;
import estructuraslineales.auxiliar.NodoClaveValor;

public class ParteLiteral {
    private ListaInfoDinamicaClave variableConCoeficiente;

    public ParteLiteral(){
        this.variableConCoeficiente = new ListaInfoDinamicaClave();
        
    }

    public void insertarUnaParteLiteral(String variable, int potencia){
        this.variableConCoeficiente.insertar(variable, potencia);
    }

    public ListaInfoDinamicaClave getVariableConCoeficiente() {
        return variableConCoeficiente;
    }

    public void setVariableConCoeficiente(ListaInfoDinamicaClave variableConCoeficiente) {
        this.variableConCoeficiente = variableConCoeficiente;
    }

    @Override
    public String toString() {
        String cadena = "";
        for (int iteracion = 0; iteracion < variableConCoeficiente.cantidad(); iteracion++) {
            NodoClaveValor nodoActual = (NodoClaveValor) variableConCoeficiente.obtener(iteracion);
            String variableActual = (String) nodoActual.getClave();
            int potenciaCorrespondiente = (Integer) nodoActual.getValor();
            cadena += variableActual;
            if (potenciaCorrespondiente != 1) { 
                cadena += "^" + potenciaCorrespondiente;
            }
        }
        return cadena;
    }

}
