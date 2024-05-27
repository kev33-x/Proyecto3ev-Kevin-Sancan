import Ventana.Ventana;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Main  {
    public static void main(String[]args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        Ventana ventana_principal = new Ventana();
        ventana_principal.iniciarVentana();

        File archivo = new File("src/sonidos/spider_dance_ost.wav");
        AudioInputStream cancion = AudioSystem.getAudioInputStream(archivo);

        Clip spider_dance = AudioSystem.getClip();
        spider_dance.open(cancion);
        spider_dance.start();

    }
}
