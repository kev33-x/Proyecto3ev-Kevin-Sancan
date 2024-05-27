package Utilidades;
import javax.swing.*;
import java.awt.*;

public class Util {

    /**
     * Metodo que ayuda a escalar una imagen a una cierta medida
     * @param label recibe un Jlabel que es el espacio que ocupará la imagen
     * @param ruta ruta donde esta guardada la imagen
     */
    public static void escalarImagen(JLabel label, String ruta)
    {
        ImageIcon imagen1 = new ImageIcon(ruta);
        Icon icono = new ImageIcon(imagen1.getImage().getScaledInstance(
                label.getWidth(), // obtiene el ancho de el label donde estara la imagen
                label.getHeight(), // obtiene el alto de el label donde estara la imagen
                Image.SCALE_DEFAULT)); //escala la imagen
        label.setIcon(icono);
    }
}
