package Ventana;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Ventana extends JFrame implements KeyListener {

    private Batalla batalla;
    private JFrame ventana;
    private JLabel corazon;

    /**
     * Metodo inicia un JFrame y mediante metodos de la clase Batalla, configura lo que se
     * mostrará en pantalla al iniciar el juego
     */
    public void iniciarVentana()
    {
        //Iniciamos la ventana
        this.ventana = new JFrame();
        ventana.setTitle("Undertale"); //titulo del juego
        ventana.setVisible(true); //Hacer que se pueda ver la ventana
        ventana.setLayout(new BorderLayout()); //para poder añadir los bordes, o sea los Jpanel
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Cerrar por defecto al presionar la X
        ventana.setResizable(false); //No permite redimensionar la ventana

        this.batalla = new Batalla(ventana);

        batalla.iniciar_pantalla_de_carga();
        batalla.iniciar_pantalla_de_juego();

        ventana.addKeyListener(this);
    }

    /**
     * Metodo sobreescrito de Keylistener, sirve para mover la imagen del corazon
     * cambiando la posicion x e y donde se encuentra
     * @param e the event to be processed
     */
    @Override
    public void keyTyped(KeyEvent e)
    {
        corazon=batalla.getCorazon();
        switch (e.getKeyChar())
        {
            case 'a':
                if(corazon.getX()!=215)
                {
                    corazon.setLocation(corazon.getX()-20, corazon.getY());
                }
                break;
            case 'w':
                if(corazon.getY()!=45)
                {
                    corazon.setLocation(corazon.getX(), corazon.getY()-65);
                }
                break;
            case 's':
                if(corazon.getY()!=175)
                {
                    corazon.setLocation(corazon.getX(), corazon.getY()+65);
                }
                break;
            case 'd':
                if(corazon.getX()!=655)
                {
                    corazon.setLocation(corazon.getX()+20, corazon.getY());
                }
                break;
        }
    }

    /**
     * Metodo sobreescrito obligado a implementarse
     * @param e the event to be processed
     */
    @Override
    public void keyReleased(KeyEvent e) {
    }

    /**
     * Metodo sobreescrito obligado a implementarse
     * @param e the event to be processed
     */
    @Override
    public void keyPressed(KeyEvent e) {
    }
}
