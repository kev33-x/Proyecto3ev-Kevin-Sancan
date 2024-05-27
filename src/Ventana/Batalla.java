package Ventana;
import Archivos.Archivo;
import Entidades.Araña;
import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import Utilidades.Util;
import java.util.Timer;
import java.util.TimerTask;

public class Batalla {
    private JFrame ventana;
    private JLabel corazon;
    private JPanel panel_accion;
    private ArrayList<Araña> lista_arañas;
    private ArrayList<Timer> lista_contadores;
    private String nombre_jugador;
    private int puntaje=0;
    private JLabel cuadro_de_puntaje;
    private Timer contador_de_puntaje;
    private boolean ha_perdido=false;

    /**
     * Constructor de la clase Batalla
     * @param ventana objeto de la clase Ventana el cual es un JFrame
     *                donde se realizarán todos los demás metodos
     */
    public Batalla(JFrame ventana)
    {
        this.ventana = ventana;
        this.lista_arañas = new ArrayList<Araña>();
        this.lista_contadores = new ArrayList<Timer>();
    }

    /**
     * Metodo que se encarga de añadir una imagen gif a la ventana como
     * pantalla de carga
     */
    public void iniciar_pantalla_de_carga() {
        JLabel cargando = new JLabel();
        cargando.setSize(800, 600);
        Util.escalarImagen(cargando, "src/imagenes/cargando.gif");

        ventana.setSize(cargando.getSize());
        ventana.add(cargando);
        ventana.setLocationRelativeTo(null);
    }

    /**
     * Metodo que se encarga de ajustar el tamaño de la ventana e implementar todos
     * los metodos que haran posible la visualizacion del juego
     */
    public void iniciar_pantalla_de_juego()
    {
        //En el timer, 1000 indica el tiempo expresado en milisegundos (lo que serían 4,7 segundos reales) y el segundo argumento es un actionListener
        // lo que hace es que despues de que pase ese tiempo, realiza todas las funciones que esten dentro de las llaves
        javax.swing.Timer timer = new javax.swing.Timer(1000, e -> {
            nombre_jugador=JOptionPane.showInputDialog("Ingresa tu nombre");

            ventana.setSize(1400,800); //Tamaño de la ventana
            ventana.setLocationRelativeTo(null); //Donde queremos que se despliegue la ventana, en mi caso null para que sea en el centro de la pantalla
            ventana.getContentPane().removeAll();
            añadir_paneles_e_imagenes();
            ataque1();
            corazon=getCorazon();
            ventana.revalidate();
            ventana.repaint();
        });
        timer.setRepeats(false);
        timer.start();
    }

    /**
     * Metodo que se encarga de crear todas las imagenes necesarias para
     * luego crear paneles que contendran a estas imagenes
     */
    public void añadir_paneles_e_imagenes() {

        //Creamos la imagen del boss y la reescalamos
        JLabel muffet = new JLabel();
        muffet.setSize(400,400);
        Util.escalarImagen(muffet,"src/imagenes/muffet1.gif");

        //Cuadro blanco que contrendrá al corazon
        JLabel cuadro_blanco = new JLabel();
        cuadro_blanco.setSize(500,250);
        Util.escalarImagen(cuadro_blanco,"src/imagenes/cuadro_de_dialogo.jpg");

        //Imagen del corazon, la añado como atributo
        JLabel corazon = new JLabel();
        corazon.setSize(30,30);
        Util.escalarImagen(corazon,"src/imagenes/corazon.png");
        this.corazon =corazon;

        //Imagen de temmie (gato)
        JLabel temmie = new JLabel();
        temmie.setSize(200,200);
        Util.escalarImagen(temmie,"src/imagenes/temmie.gif");

        //Imagen inferior de botones
        JLabel acciones = new JLabel();
        acciones.setSize(800,100);
        Util.escalarImagen(acciones,"src/imagenes/botones.png");

        cuadro_de_puntaje = new JLabel("El puntaje actual es: "+puntaje);

        lista_arañas=Araña.agregar_arañas_a_un_array();


        //Creamos los paneles o cuadrados para delimitar las imagenes
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();
        panel_accion= new JPanel(); //cuadro de dialogo


        //Se añaden los colores de los cuadros o paneles
        panel1.setBackground(Color.black);
        panel2.setBackground(Color.black);
        panel3.setBackground(Color.black);
        panel4.setBackground(Color.black);
        panel5.setBackground(Color.black);
        panel_accion.setBackground(Color.black);


        //El tamaño de los paneles
        panel1.setPreferredSize(new Dimension(20,20));
        panel2.setPreferredSize(new Dimension(240,100));
        panel3.setPreferredSize(new Dimension(100,100));
        panel4.setPreferredSize(new Dimension(240,100));
        panel5.setPreferredSize(new Dimension(100,100));
        panel_accion.setPreferredSize(new Dimension(100,250)); //cuadro de dialogo



        //Añadimos un layout al 3er panel para que pueda contener subpaneles y añadimos la imagen del jefe, tambien el panel de accion
        panel3.setLayout(new BorderLayout());
        panel3.add(muffet);
        muffet.setVerticalAlignment(JLabel.CENTER);
        muffet.setHorizontalAlignment(JLabel.CENTER);
        panel3.add(panel_accion,BorderLayout.SOUTH);

        //Añadimos la imagen de los botones al panel5
        panel5.setLayout(null);
        panel5.add(acciones);
        acciones.setLocation(290,0);

        //Añado la imagen del cuadro de dialogo, el corazon y todas las arañas al panel de accion
        panel_accion.setLayout(null);
        panel_accion.add(corazon);
        for ( int i=0; i<lista_arañas.size(); i++)
        {
            Araña actual = lista_arañas.get(i);
            panel_accion.add(actual);
        }
        panel_accion.add(cuadro_blanco);


        //Posición de las imagenes
        corazon.setLocation(435,110);
        temmie.setLocation(1200,565);
        cuadro_blanco.setLocation(200,0);


        //Añadimos el contado al panel 2
        panel2.setLayout(null);
        panel2.add(cuadro_de_puntaje);
        cuadro_de_puntaje.setLocation(0,0);
        cuadro_de_puntaje.setSize(200,100);
        cuadro_de_puntaje.setForeground(Color.WHITE);
        cuadro_de_puntaje.setFont(new Font("Arial",Font.BOLD,24));
        aumentar_puntaje();


        //Añadimos los componentes que van directamene sobre la ventana
        ventana.add(temmie);
        ventana.add(panel1,BorderLayout.NORTH);
        ventana.add(panel2,BorderLayout.WEST);
        ventana.add(panel3,BorderLayout.CENTER);
        ventana.add(panel4,BorderLayout.EAST);
        ventana.add(panel5,BorderLayout.SOUTH);
    }

    /**
     * Mueve una imagen de una araña segun una posicion inicial y la velocidad que se quiera
     * @param araña objeto de la clase araña al que se modifica su posicion
     * @param inicialX variable entera que indica la posicion inicial en el eje x
     * @param inicialY variable entera que indica la posicion inicial en el eje y
     * @param mover_en_x indica cuantas posiciones debe moverse en el eje x
     * @param mover_en_y indica cuantas posiciones debe moverse en el eje y
     * @param delay el tiempo en milisegundos que tarda en iniciarse el movimiento
     * @param periodo_actualizacion tiempo en milisegundos de cada cuanto se realiza el movimiento
     */
    public void mover_araña(Araña araña,int inicialX, int inicialY, int mover_en_x, int mover_en_y, int delay, int periodo_actualizacion)
    {
        araña.setLocation(inicialX,inicialY);
        Timer contador = new Timer();
        lista_contadores.add(contador);
        TimerTask tarea = new TimerTask() {
            @Override
            public void run()
            {
                int nuevaX = araña.getX()+mover_en_x;
                int nuevaY = araña.getY()+mover_en_y;

                if(nuevaX <-200 || nuevaX > 1200 )
                {
                    contador.cancel();
                }
                else
                {
                    araña.setLocation(nuevaX,nuevaY);

                    // Verificar colision con el corazon
                    if (corazon.getBounds().intersects(araña.getBounds()))
                    {
                        ha_perdido=true;

                        detener_todos_los_contadores();
                        contador_de_puntaje.cancel();
                        calcular_puntaje_final();
                        JOptionPane.showMessageDialog(ventana, "Has perdido, click en el boton para salir");
                        System.exit(0);
                    }
                }
            }
        };
        contador.schedule(tarea,delay,periodo_actualizacion);
    }

    /**
     * Mueve todas las arañas segun los parametros especificados, tiene un contador
     * que inicia el metodo ataque2 y detiene todos los contadores anteriores
     */
    public void ataque1()
    {

        //<-----
        mover_araña(lista_arañas.get(0),900,45, -15, 0, 0,15);
        mover_araña(lista_arañas.get(1),1000,45,-15, 0, 0,15);
        //<-----
        mover_araña(lista_arañas.get(2), 1000,175,-15, 0, 1000,15);
        mover_araña(lista_arañas.get(3),1100,175, -15, 0, 1000,15);

        //----->
        mover_araña(lista_arañas.get(4),-40, 110, 15, 0, 1500,15);

        //----->
        mover_araña(lista_arañas.get(6), -100,45,15, 0, 2000,15);
        mover_araña(lista_arañas.get(7), -100,175,15, 0, 2000,15);

        //----->
        mover_araña(lista_arañas.get(5),-40,110, 15, 0, 2500,15);

        Timer timer = new Timer();
        lista_contadores.add(timer);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                detener_todos_los_contadores();
                ataque2();
            }
        }, 4000);
    }

    /**
     * Mueve todas las arañas segun los parametros especificados, tiene un contador
     * que inicia el metodo ataque3 y detiene todos los contadores anteriores
     */
    public void ataque2()
    {
        //<-----
        mover_araña(lista_arañas.get(5),1000,110,-15,0,0,15);
        //<-----
        mover_araña(lista_arañas.get(6),1000,45,-15,0,200,15);
        mover_araña(lista_arañas.get(7),1000,175,-15,0,200,15);
        //<-----
        mover_araña(lista_arañas.get(4),1000,110,-15,0,400,15);

        //----->
        mover_araña(lista_arañas.get(2), -100,175,15, 0, 900,15);
        mover_araña(lista_arañas.get(3), -100,175,15, 0, 1200,15);

        //----->
        mover_araña(lista_arañas.get(0),-100,45, 15, 0, 1500,15);
        mover_araña(lista_arañas.get(1),-100,45, 15, 0, 1700,15);

        Timer timer = new Timer();
        lista_contadores.add(timer);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                detener_todos_los_contadores();
                ataque3();
            }
        }, 4000);
    }

    /**
     * Mueve todas las arañas segun los parametros especificados, tiene un contador
     * que inicia el metodo ataque4 y detiene todos los contadores anteriores
     */
    public void ataque3()
    {
        mover_araña(lista_arañas.get(0),-100,45, 15, 0, 400,15);
        mover_araña(lista_arañas.get(1),-100,110, 15, 0, 0,15);
        mover_araña(lista_arañas.get(2), -100,175,15, 0, 400,15);

        mover_araña(lista_arañas.get(3), -100,45,15, 0, 1000,15);
        mover_araña(lista_arañas.get(4),-100,110,15,0,600,15);
        mover_araña(lista_arañas.get(5),-100,175,15,0,1000,15);

        mover_araña(lista_arañas.get(6),-100,45,15,0,1300,15);
        mover_araña(lista_arañas.get(7),-100,175,15,0,1300,15);

        Timer timer = new Timer();
        lista_contadores.add(timer);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                detener_todos_los_contadores();
                ataque4();
            }
        }, 4000);
    }

    /**
     * Mueve todas las arañas segun los parametros especificados, tiene un contador
     * que realiza otra serie de movimientos y se encarga de poner fin al juego
     */
    public void ataque4()
    {
        mover_araña(lista_arañas.get(0),1000,175, -15, 0, 0,15);
        mover_araña(lista_arañas.get(1),1000,110, -15, 0, 300,15);
        mover_araña(lista_arañas.get(2), 1000,45,-15, 0, 300,15);

        mover_araña(lista_arañas.get(3), 1000,45,-15, 0, 500,15);
        mover_araña(lista_arañas.get(4),1000,110,-15,0,750,15);
        mover_araña(lista_arañas.get(5),1000,175,-15,0,750,15);

        mover_araña(lista_arañas.get(6),1000,175,-15,0,950,15);
        mover_araña(lista_arañas.get(7),1000,45,15,0,1150,15);

        Timer timer = new Timer();
        lista_contadores.add(timer);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                detener_todos_los_contadores();
                mover_araña(lista_arañas.get(0),1000,175, -15, 0, 0,15);
                mover_araña(lista_arañas.get(1),1000,110, -15, 0, 300,15);
                mover_araña(lista_arañas.get(2), 1000,45,-15, 0, 300,15);

                mover_araña(lista_arañas.get(3), 1000,45,-15, 0, 500,15);
                mover_araña(lista_arañas.get(4),1000,110,-15,0,750,15);
                mover_araña(lista_arañas.get(5),1000,175,-15,0,750,15);

                mover_araña(lista_arañas.get(6),1000,175,-15,0,950,15);
                mover_araña(lista_arañas.get(7),1000,45,15,0,1150,15);
            }
        }, 2500);

        Timer timer2 = new Timer();
        timer2.schedule(new TimerTask() {
            @Override
            public void run() {
                if(!ha_perdido)
                {
                    calcular_puntaje_final();
                    terminar_juego();
                }
            }
        }, 4500);


    }

    /**
     * Inicia un contador que actualiza un variable puntaje sumandole 10, cada 100 milisegundos
     */
    public void aumentar_puntaje() {
        contador_de_puntaje = new Timer();
        contador_de_puntaje.schedule(new TimerTask() {
            @Override
            public void run() {
                puntaje = puntaje+10;
                cuadro_de_puntaje.setText("Puntaje: " + puntaje);
            }
        }, 0, 100);  // Actualiza el puntaje cada segundo
    }

    /**
     * Muestra una ventana emergente con datos sobre los nombres de jugadores, puntajes obtenidos
     * y fecha en la que se consiguieron
     */
    public void calcular_puntaje_final()
    {
        LocalDate fecha_actual = LocalDate.now();
        LocalTime hora_actual = LocalTime.now();

        int hora = hora_actual.getHour();
        int minutos = hora_actual.getMinute();
        int segundos = hora_actual.getSecond();
        String cadena_hora = hora+":"+minutos+":"+segundos;

        Archivo archivo = new Archivo();
        archivo.escribir_archivo(nombre_jugador+" hizo "+puntaje+" puntos en la fecha "+fecha_actual+" a las "+cadena_hora);
        JOptionPane.showMessageDialog(null,archivo.leer_archivo());
    }

    /**
     * Detiene todos los contadores agregados a la lista de contadores
     */
    public void detener_todos_los_contadores()
    {
        for (Timer timer : lista_contadores)
        {
            timer.cancel();
        }
    }

    /**
     * Una vez han finalizado todos los metodos anteriores, se muestra una ventana emergente con un mensaje final
     * y pasa a cerrarse el programa
     */
    public void terminar_juego()
    {
         contador_de_puntaje.cancel();
         JOptionPane.showMessageDialog(ventana,"Felicidades! Has terminado la demo\n haz click en ok para salir");
         System.exit(0);
    }

    public JLabel getCorazon()
    {
        return corazon;
    }


}
