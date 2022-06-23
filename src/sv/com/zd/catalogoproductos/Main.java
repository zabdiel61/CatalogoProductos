/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sv.com.zd.catalogoproductos;

import java.util.Scanner;
import javax.swing.JOptionPane;
import sv.com.zd.productos.negocio.CatalogoProductosImpl;
import sv.com.zd.productos.negocio.ICatalogoProductos;

/**
 *
 * @author jonat
 */
public class Main {

    public static void main(String[] args) {
        var opcion = -1;
        Scanner entrada = new Scanner(System.in);
        ICatalogoProductos catalogoProductosImpl = new CatalogoProductosImpl();

        while (opcion != 0) {
            JOptionPane.showMessageDialog(null, "Bienvenido");
            JOptionPane.showMessageDialog(null, "Elige una opcion\n"
                    + "1. Iniciar Catalogo de peliculas\n"
                    + "2. Agregar Pelicula\n"
                    + "3. Listar Peliculas\n"
                    + "0. Salir");

            opcion = Integer.parseInt(JOptionPane.showInputDialog("Ingresa una de la opciones anteriores"));

            switch (opcion) {
                case 1:
                    System.out.println("");
                    break;
                case 2:
                    System.out.println("");
                    break;
                case 3:
                    System.out.println("");
                    break;
                default:
                    
            }
        }
    }
}
