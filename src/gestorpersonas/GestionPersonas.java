/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestorpersonas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author scortes
 */
public class GestionPersonas implements CRUD<Persona> {
    private ArrayList<Persona> lista;
    private Repositorio<Persona> repositorioPersonas;
    private String rutaTxtGenerica;
    private String rutaTxtFiltro;

    public GestionPersonas(Repositorio<Persona> repositorioPersonas, String rutaTxtGenerica, String rutaTxtFiltro) {
        this.lista = repositorioPersonas.cargar(rutaTxtGenerica);
        this.repositorioPersonas = repositorioPersonas;
        this.rutaTxtGenerica = rutaTxtGenerica;
        this.rutaTxtFiltro = rutaTxtFiltro;
    }
    
    public boolean agregar(Persona persona){
        boolean yaExiste = false;
        
        for(Persona p : lista){
            if (p.getId() == persona.getId()){
                System.out.println("Ya existe persona con id: " + persona.getId());
                yaExiste = true;
            }
            if (p.getNombre().toLowerCase().equals(persona.getNombre().toLowerCase()) 
                    && p.getApellido().toLowerCase().equals(persona.getApellido().toLowerCase())
            ){
                System.out.println("Ya existe persona con ese nombre y apellido: " + persona.getNombre() + " " + persona.getApellido());
                yaExiste = true;
            }
        }
        
        if(!yaExiste) {
            lista.add(persona);
            System.out.println("Persona agregada con exito: " + persona.toString());
            return true;
        }
        
        return false;
    };
    
    public ArrayList<Persona> listar(){
        return lista;
    };
    
    public ArrayList<Persona> buscarPorCondicion(Predicate<Persona> filtro){
        return lista
                .stream()
                .filter(filtro)
                .collect(Collectors.toCollection(ArrayList::new));
    };
    
    public boolean actualizar(Persona persona){
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == persona.getId()){
                lista.set(i, persona);
                System.out.println("Persona actualizada correctamente: " + persona.toString());
                return true;
            }
        }
        
        System.out.println("No encontramos a la persona con ID:  " + persona.getId());
        return false;
    };
    
    public boolean eliminar(int id){
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == id){
                lista.remove(i);
                System.out.println("Persona eliminada correctamente: ID " + id);
                return true;
            }
        }
        
        System.out.println("No encontramos a la persona con ID:  " + id);
        return false;
    };
    
    public void guardarPersonas(ArrayList<Persona> lista){
        repositorioPersonas.guardar(lista, rutaTxtGenerica);
    };
    
    public void exportarFiltrado(Predicate<Persona> filtro){
        repositorioPersonas.exportarFiltrado(lista, filtro, rutaTxtFiltro);
    };
}
