/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sv.com.zd.productos.datos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sv.com.zd.productos.entidades.Producto;
import sv.com.zd.productos.excepciones.AccesoDatosEx;

/**
 *
 * @author jonat
 */
public class AccesoDatosImpl implements IAccesoDatos {

    @Override
    public boolean existe(String nombreRecurso) throws AccesoDatosEx {
        var archivo = new File(nombreRecurso);
        return archivo.exists();
    }

    @Override
    public List<Producto> listar(String nombreRecurso) throws AccesoDatosEx {
        var archivo = new File(nombreRecurso);
        List<Producto> productos = new ArrayList<>();

        try {
            var entrada = new BufferedReader(new FileReader(archivo));
            String linea = entrada.readLine();
            while (linea != null) {
                Producto producto = new Producto(linea);
                productos.add(producto);
                linea = entrada.readLine();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AccesoDatosImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new AccesoDatosEx("Error al acceder a datos en listar: " + ex.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(AccesoDatosImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new AccesoDatosEx("Error al listar producto: " + ex.getMessage());
        }
        return productos;
    }

    @Override
    public void escribir(Producto producto, String nombreRecurso, boolean anexar) throws AccesoDatosEx {
        var archivo = new File(nombreRecurso);

        try {
            var salida = new PrintWriter(new FileWriter(archivo, anexar));
            salida.println(producto.getNombre());
            salida.close();
            System.out.println("Se ha a??adido el nombre de producto correctamente");
        } catch (IOException ex) {
            Logger.getLogger(AccesoDatosImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new AccesoDatosEx("Error al ingresar producto: " + ex.getMessage());
        }
    }

    @Override
    public String buscar(String nombreRecurso, String buscar) throws AccesoDatosEx {
        var archivo = new File(nombreRecurso);
        String resultado = null;

        try {
            var entrada = new BufferedReader(new FileReader(archivo));
            var linea = entrada.readLine();

            var indice = 1;

            while (linea != null) {
                if (buscar != null && linea.equalsIgnoreCase(buscar)) {
                    resultado = buscar;
                    break;
                }
                linea = entrada.readLine();
                indice++;
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AccesoDatosImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new AccesoDatosEx("Error al buscar producto: " + ex.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(AccesoDatosImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new AccesoDatosEx("Error al buscar producto: " + ex.getMessage());
        }

        return resultado;
    }

    @Override
    public void crear(String nombreRecurso) throws AccesoDatosEx {
        var archivo = new File(nombreRecurso);
        try {
            var salida = new PrintWriter(archivo);
            salida.close();
            JOptionPane.showMessageDialog(null, "El Catalogo con nombre\n" + nombreRecurso + "\nse ha creado con exito");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AccesoDatosImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void borrar(String nombreRecurso) throws AccesoDatosEx {
        var archivo = new File(nombreRecurso);
        if (archivo.exists()) {
            archivo.delete();
            System.out.println("se ha borrado el archivo: " + nombreRecurso);
        }
    }

}
