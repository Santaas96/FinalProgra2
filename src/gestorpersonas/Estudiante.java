/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestorpersonas;

/**
 *
 * @author scortes
 */
public class Estudiante extends Persona {
    private int matricula;
    private double beca;

    public Estudiante(int matricula, double beca, int id, String nombre, String apellido, int edad, SituacionFiscal situacionFiscal) {
        super(id, nombre, apellido, edad, situacionFiscal);
        this.matricula = matricula;
        this.beca = beca;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public double getBeca() {
        return beca;
    }

    public void setBeca(double beca) {
        this.beca = beca;
    }

    @Override
    public String toString() {
        return super.toString() + " - " + "Estudiante{" + "matricula=" + matricula + ", beca=" + beca + '}';
    }
    
    public void mostrarInfo(){
        System.out.println(this.toString());
    };
    
    public SituacionFiscal getSituacionFiscal(){
        return super.getSituacionFiscal();
    };
    
    public double calcularImpuesto(){
        return this.beca * (this.getSituacionFiscal().getCoeficiente());
    };
}
