/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestorpersonas;

/**
 *
 * @author scortes
 */
public class Vendedor extends Persona {
    private String cuit;
    private double facturacion;

    public Vendedor(String cuit, double facturacion, int id, String nombre, String apellido, int edad, SituacionFiscal situacionFiscal) {
        super(id, nombre, apellido, edad, situacionFiscal);
        this.cuit = cuit;
        this.facturacion = facturacion;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public double getFacturacion() {
        return facturacion;
    }

    public void setFacturacion(double facturacion) {
        this.facturacion = facturacion;
    }

    @Override
    public String toString() {
        return super.toString() + " - " + "Vendedor{" + "cuit=" + cuit + ", facturacion=" + facturacion + '}';
    }
    
    public void mostrarInfo(){
        System.out.println(this.toString());
    };
    
    public SituacionFiscal getSituacionFiscal(){
        return super.getSituacionFiscal();
    };
    
    public double calcularImpuesto(){
        return this.facturacion * (this.getSituacionFiscal().getCoeficiente());
    };
}
