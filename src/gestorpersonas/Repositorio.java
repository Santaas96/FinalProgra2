/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gestorpersonas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @author scortes
 */
public interface Repositorio<T> {
    public void guardar(ArrayList<T> lista, String ruta);
    public ArrayList<T> cargar(String ruta);
    public void exportarFiltrado(ArrayList<T> lista, Predicate<T> filtro, String ruta);
}
