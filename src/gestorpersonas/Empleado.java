/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestorpersonas;

/**
 *
 * @author scortes
 */
public class Empleado extends Persona {
    private int legajo;
    private double salario;

    public Empleado(int legajo, double salario, int id, String nombre, String apellido, int edad, SituacionFiscal situacionFiscal) {
        super(id, nombre, apellido, edad, situacionFiscal);
        this.legajo = legajo;
        this.salario = salario;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return super.toString() + " - " + "Empleado{" + "legajo=" + legajo + ", salario=" + salario + '}';
    }
    
    public void mostrarInfo(){
        System.out.println(this.toString());
    };
    
    public SituacionFiscal getSituacionFiscal(){
        return super.getSituacionFiscal();
    };
    
    public double calcularImpuesto(){
        return this.salario * (this.getSituacionFiscal().getCoeficiente());
    };
    
}
