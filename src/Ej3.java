import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ej3 {

    /** Creates a new instance of PruebaRuntime */
    public Ej3()
    {
        try
        {
            String rutaConsola="cmd /c";
            String comando= JOptionPane.showInputDialog("Introduce el comando: ");
            String ejecutable=rutaConsola+comando;
            // Se lanza el ejecutable.
            Process p=Runtime.getRuntime().exec (ejecutable);

            // Se obtiene el stream de salida del programa
            InputStream is = p.getInputStream();

            /* Se prepara un bufferedReader para poder leer la salida más comodamente. */
            BufferedReader br = new BufferedReader (new InputStreamReader(is));
            // Se lee la primera linea
            String aux = br.readLine();

            // Mientras se haya leido alguna linea
            while (aux!=null)
            {
                // Se escribe la linea en pantalla
                System.out.println (aux);

                // y se lee la siguiente.
                aux = br.readLine();
            }
        }
        catch (Exception e)
        {
            // Excepciones si hay algún problema al arrancar el ejecutable o al leer su salida.*/
            e.printStackTrace();
        }
    }

    /**
     * Crea la clase principal que ejecuta el comando dir y escribe en pantalla
     * lo que devuelve dicho comando.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        new Ej3();
    }
}
