/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package gestorpersonas;

/**
 *
 * @author scortes
 */
public enum SituacionFiscal {
    MONOTRIBUTO(0.05),
    RESPONSABLE_INSCRIPTO(0.21),
    EXENTO(0.0);
    
    private final double coeficiente;

    SituacionFiscal(double coeficiente) {
        this.coeficiente = coeficiente;
    }

    public double getCoeficiente() {
        return coeficiente;
    }
}
