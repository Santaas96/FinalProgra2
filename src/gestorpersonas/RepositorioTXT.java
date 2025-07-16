/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestorpersonas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.function.Predicate;

/**
 *
 * @author scortes
 */
public class RepositorioTXT implements Repositorio<Persona> {
    
    public void guardar(ArrayList<Persona> lista, String ruta) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(ruta))) {
            for (Persona v : lista) {
                String nuevaLinea = "";
                
                if (v instanceof Empleado emp) {
                    nuevaLinea = String.format("Empleado/%d/%s/%s/%d/%s/%d/%.2f",
                        emp.getId(), 
                        emp.getNombre(), 
                        emp.getApellido(), 
                        emp.getEdad(), 
                        emp.getSituacionFiscal(), 
                        emp.getLegajo(),
                        emp.getSalario());
                    
                } else if (v instanceof Estudiante est) {
                    nuevaLinea = String.format("Estudiante/%d/%s/%s/%d/%s/%d/%.2f",
                        est.getId(), 
                        est.getNombre(), 
                        est.getApellido(), 
                        est.getEdad(),
                        est.getSituacionFiscal(), 
                        est.getMatricula(),
                        est.getBeca());
                    
                } else if (v instanceof Vendedor vend) {
                    nuevaLinea = String.format("Vendedor/%d/%s/%s/%d/%s/%s/%.2f",
                        vend.getId(), 
                        vend.getNombre(), 
                        vend.getApellido(), 
                        vend.getEdad(), 
                        vend.getSituacionFiscal(), 
                        vend.getCuit(),
                        vend.getFacturacion());
                }
                
                writer.println(nuevaLinea);
            }
             
            System.out.println("Se guardo la informacion correctamente en la ruta: " + ruta);
            
        } catch (IOException e) {
            System.out.println("Error al guardar archivo txt en la ruta " + ruta + ": " + e);
        }
    };
    
    public ArrayList<Persona> cargar(String ruta){
        ArrayList<Persona> listaACargar = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split("/");
                if(datos.length < 1) break;
                
                String tipo = datos[0];
                int id = Integer.parseInt(datos[1]);
                String nombre = datos[2];
                String apellido = datos[3];
                int edad = Integer.parseInt(datos[4]);
                SituacionFiscal situacionFiscal = SituacionFiscal.valueOf(datos[5]);
                
                switch (tipo) {
                    case "Empleado":
                        int legajo = Integer.parseInt(datos[6]);
                        double salario = Double.parseDouble(datos[7].replace(",", "."));
                        
                        listaACargar.add(
                                new Empleado(
                                        legajo, 
                                        salario, 
                                        id, 
                                        nombre, 
                                        apellido, 
                                        edad,
                                        situacionFiscal
                                )
                        );
                        
                        break;
                        
                    case "Estudiante":
                        int matricula = Integer.parseInt(datos[6]);
                        double beca = Double.parseDouble(datos[7].replace(",", "."));
                        
                        listaACargar.add(
                                new Estudiante(
                                        matricula, 
                                        beca, 
                                        id, 
                                        nombre, 
                                        apellido, 
                                        edad,
                                        situacionFiscal
                                )
                        );
                        
                        break;
                        
                    case "Vendedor":
                        String cuit = datos[6];
                        double facturacion = Double.parseDouble(datos[7].replace(",", "."));
                        
                        listaACargar.add(
                                new Vendedor(
                                        cuit, 
                                        facturacion, 
                                        id, 
                                        nombre, 
                                        apellido, 
                                        edad,
                                        situacionFiscal
                                )
                        );
                        
                        break;
                    default:
                        // Fallback
                        System.out.println("Error: No conocemos el tipo de persona: " + tipo);
                }
            }

            System.out.println("Se cargo la informacion correctamente desde la ruta: " + ruta);
            
        } catch (IOException | IllegalArgumentException e) {
            System.out.println("Error al cargar archivo txt desde la ruta " + ruta + ": " + e);
        }

        return listaACargar;
    };
    
    public void exportarFiltrado(ArrayList<Persona> lista, Predicate<Persona> filtro, String ruta) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(ruta))) {
            writer.println("EXPORTADO DE PERSONAS FILTRADAS");
            writer.println(" ");
            
            lista
                .stream()
                .filter(filtro)
                .forEach(p -> writer.println(p.toString()));

            System.out.println("Se exportaron los datos filtrados correctamente en la ruta: " + ruta);
            
        } catch (IOException e) {
            System.out.println("Error al exportar archivo en la ruta " + ruta + ": " + e);
        }
    };
}
