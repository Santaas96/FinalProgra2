/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gestorpersonas;

import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @author scortes
 */
public interface Repositorio<T> {
    public void guardar(List<T> lista);
    public List<T> cargar(String ruta);
    public void exportarFiltrado(List<T> lista, Predicate<T> filtro, String ruta);
}
