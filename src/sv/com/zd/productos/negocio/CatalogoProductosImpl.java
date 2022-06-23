/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sv.com.zd.productos.negocio;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sv.com.zd.productos.datos.AccesoDatosImpl;
import sv.com.zd.productos.datos.IAccesoDatos;
import sv.com.zd.productos.entidades.Producto;
import sv.com.zd.productos.excepciones.AccesoDatosEx;

/**
 *
 * @author jonat
 */
public class CatalogoProductosImpl implements ICatalogoProductos {

    private final IAccesoDatos iAccesoDatos;

    public CatalogoProductosImpl() {
        this.iAccesoDatos = new AccesoDatosImpl();
    }

    @Override
    public void agregarPruducto(String nombreProducto) {
        Producto producto = new Producto(nombreProducto);
        boolean anexar = false;
        try {
            anexar = iAccesoDatos.existe(NOMBRE_RECURSO);
            iAccesoDatos.escribir(producto, NOMBRE_RECURSO, anexar);
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso a datos");
            Logger.getLogger(CatalogoProductosImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void listarProductos() {
        try {
            var Productos = iAccesoDatos.listar(NOMBRE_RECURSO);
            Productos.forEach(producto
                    -> System.out.println("producto = " + producto));
        } catch (AccesoDatosEx ex) {
            Logger.getLogger(CatalogoProductosImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void buscarPelicula(String buscar) {
        try {
            var resultado = iAccesoDatos.buscar(NOMBRE_RECURSO, buscar);
            JOptionPane.showMessageDialog(null, "La pelicula que estas buscando es: " + resultado);
        } catch (AccesoDatosEx ex) {
            Logger.getLogger(CatalogoProductosImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void iniciarCatalogoProducto() {
        try {
            if (this.iAccesoDatos.existe(NOMBRE_RECURSO)) {
                iAccesoDatos.borrar(NOMBRE_RECURSO);
                iAccesoDatos.crear(NOMBRE_RECURSO);
            } else {
                iAccesoDatos.crear(NOMBRE_RECURSO);
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("Error al iniciar catalogo de peliculas");
            ex.printStackTrace(System.out);
        }
    }

}
