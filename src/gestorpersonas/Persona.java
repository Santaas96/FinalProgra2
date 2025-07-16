/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestorpersonas;

/**
 *
 * @author scortes
 */
public abstract class Persona implements Contribuyente {
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private SituacionFiscal situacionFiscal;

    public Persona(int id, String nombre, String apellido, int edad, SituacionFiscal situacionFiscal) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.situacionFiscal = situacionFiscal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public SituacionFiscal getSituacionFiscal() {
        return situacionFiscal;
    }

    public void setSituacionFiscal(SituacionFiscal situacionFiscal) {
        this.situacionFiscal = situacionFiscal;
    }

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", situacionFiscal=" + situacionFiscal + '}';
    }
    
    public abstract void mostrarInfo();
   
}
