package Entidades;
import Utilidades.Util;
import javax.swing.*;
import java.util.ArrayList;
public class Araña extends JLabel {

    /**
     * Constructor del objeto Araña
     * @param ruta ruta donde esta ubicada la imagen
     * @param ancho establece la medida del ancho de la imagen
     * @param alto establece la medida del alto de la imagen
     */
    public Araña(String ruta, int ancho, int alto)
    {
        this.setSize(ancho, alto);
        Util.escalarImagen(this,ruta);
    }

    /**
     * Crea un ArrayList y lo llena con objetos de araña
     * @return lista_arañas, el ArrayList con los objetos ya añadidos
     */
    public static ArrayList<Araña> agregar_arañas_a_un_array()
    {
        ArrayList<Araña> lista_arañas = new ArrayList<Araña>();

        Araña araña1 = new Araña("src/imagenes/araña.png",35,35);
        Araña araña2 = new Araña("src/imagenes/araña.png",35,35);
        Araña araña3 = new Araña("src/imagenes/araña.png",35,35);
        Araña araña4 = new Araña("src/imagenes/araña.png",35,35);
        Araña araña5 = new Araña("src/imagenes/araña.png",35,35);
        Araña araña6 = new Araña("src/imagenes/araña.png",35,35);
        Araña araña7 = new Araña("src/imagenes/araña.png",35,35);
        Araña araña8 = new Araña("src/imagenes/araña.png",35,35);

        lista_arañas.add(araña1);
        lista_arañas.add(araña2);
        lista_arañas.add(araña3);
        lista_arañas.add(araña4);
        lista_arañas.add(araña5);
        lista_arañas.add(araña6);
        lista_arañas.add(araña7);
        lista_arañas.add(araña8);

        return lista_arañas;
    }

}
