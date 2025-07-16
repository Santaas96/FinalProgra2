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
        // Instanciamos repositorio de txt
        Repositorio repositorioTxt = new RepositorioTXT();
        
        // Rutas de archivos txts
        String rutaLecturaEscritura = "persistencia_personas.txt";
        String rutaFiltrados = "personas_filtradas.txt";
        
        // Instanciamos el sistema de gestion de personas
        GestionPersonas manager = new GestionPersonas(repositorioTxt, rutaLecturaEscritura, rutaFiltrados);
    }
    
}
