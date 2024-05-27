package Archivos;
import java.io.*; //libreria necesaria para el manejo de archivos y excepciones
public class Archivo {

    private File archivo_de_puntajes = new File("src/archivos/datos.txt");

    /**
     * Recibe un nombre como parametro y lo escribe en un fichero
     * @param nombre_de_jugador el nombre que recibe
     */
    public void escribir_archivo(String nombre_de_jugador)
    {
        try
        {
            FileWriter escritura = new FileWriter(archivo_de_puntajes,true);
            escritura.write("*-"+nombre_de_jugador+"\n");
            escritura.close();
        }
        catch (IOException ioe)
        {
            System.out.println("Error, no se han podido escribir los datos en el fichero de texto");
        }
    }

    /**
     * Lee linea por linea un archivo
     * @return mensajes, una cadena formada por los datos leidos
     */
    public String leer_archivo()
    {
        String contenido;
        String mensajes="Todos los puntajes: ";
        boolean hay_datos=true;

        try
        {
            FileReader lectura = new FileReader(archivo_de_puntajes);
            BufferedReader lector_de_filas = new BufferedReader(lectura);

            do
            {
                contenido = lector_de_filas.readLine();
                if(contenido !=null)
                {
                    mensajes= mensajes+"\n"+contenido;
                }
                else
                {
                    hay_datos=false;
                }
            }
            while (hay_datos);
        }
        catch (IOException ioe)
        {
            System.out.println("Error, no se han podido leer los datos del fichero de texto");
        }

        return mensajes;
    }
}
