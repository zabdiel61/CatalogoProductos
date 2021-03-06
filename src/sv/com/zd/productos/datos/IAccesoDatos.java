/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sv.com.zd.productos.datos;

import java.util.List;
import sv.com.zd.productos.entidades.Producto;
import sv.com.zd.productos.excepciones.AccesoDatosEx;

/**
 *
 * @author jonat
 */
public interface IAccesoDatos {
    boolean existe(String nombreRecurso) throws AccesoDatosEx;
    
    List<Producto> listar(String nombreRecurso) throws AccesoDatosEx;
    
    void escribir(Producto producto, String nombreRecurso, boolean anexar) throws AccesoDatosEx;
    
    String buscar(String nombreRecurso, String buscar) throws AccesoDatosEx ; 
    
    void crear(String nombreRecurso) throws AccesoDatosEx;
    
    void borrar(String nombreRecurso) throws AccesoDatosEx;
}
