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
public interface CRUD<T> {
    public void agregar(T objeto);
    public List<T> listar();
    public List<T> buscarPorCondicion(Predicate<T> filtro);
    public void actualizar(T objeto);
    public void eliminar(int id);
}
