/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sv.com.zd.productos.negocio;

/**
 *
 * @author jonat
 */
public interface ICatalogoProductos {

    String NOMBRE_RECURSO = "productos.txt";

    void agregarPruducto(String nombreProducto);
    
    void listarProductos();
    
    void buscarPelicula(String buscar);
    
    void iniciarCatalogoProducto();

}
