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
public interface CRUD<T> {
    public boolean agregar(T objeto);
    public ArrayList<T> listar();
    public ArrayList<T> buscarPorCondicion(Predicate<T> filtro);
    public boolean actualizar(T objeto);
    public boolean eliminar(int id);
}
