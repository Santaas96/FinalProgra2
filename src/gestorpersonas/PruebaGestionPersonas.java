/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestorpersonas;

/**
 *
 * @author scortes
 */
public class PruebaGestionPersonas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // Instanciamos repositorio de txt
            Repositorio repositorioTxt = new RepositorioTXT();

            // Rutas de archivos txts
            String rutaLecturaEscritura = "persistencia_personas.txt";
            String rutaFiltrados = "personas_filtradas.txt";

            // Instanciamos el sistema de gestion de personas
            GestionPersonas manager = new GestionPersonas(repositorioTxt, rutaLecturaEscritura, rutaFiltrados);
            
            // Creamos personas
            Persona p1 = new Empleado(
                    2543,
                    25000,
                    4,
                    "Pablo",
                    "Ramirez",
                    34,
                    SituacionFiscal.MONOTRIBUTO
            );
            Persona p2 = new Estudiante(
                    1234,
                    450000,
                    5,
                    "Nora",
                    "Cardenas",
                    34,
                    SituacionFiscal.EXENTO
            );
            Persona p3 = new Vendedor(
                    "20534534534004",
                    8300000,
                    6,
                    "Ramiro",
                    "Gonzalez",
                    34,
                    SituacionFiscal.RESPONSABLE_INSCRIPTO
            );
            
            // Agregamos personas al manager
            manager.agregar(p1);
            manager.agregar(p2);
            manager.agregar(p3);
            
            // Eliminamos
            manager.eliminar(p2.getId());
            
            // Actualizamos
            Persona modificada = p3;
            modificada.setApellido("Galvan");
            manager.actualizar(modificada);
            
            // Guardamos en persistencia txt
            manager.guardarPersonas();
            
            // Exportamos Personas filtradas en txt
            manager.exportarFiltrado(p -> p instanceof Vendedor);
            
        } catch (Exception e) {
            System.out.println("Error en PruebaGestionPersonas: " + e);
        }
        
    }
}
