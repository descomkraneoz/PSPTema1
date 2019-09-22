import java.io.*;


public class Ej1 {

    /** Creates a new instance of PruebaRuntime */
    public Ej1()
    {
        try
        {
            // Se lanza el ejecutable.
            Process p=Runtime.getRuntime().exec ("cmd /c ipconfig");

            // Se obtiene el stream de salida del programa
            InputStream is = p.getInputStream();

            /* Se prepara un bufferedReader para poder leer la salida más comodamente. */
            BufferedReader br = new BufferedReader (new InputStreamReader (is));
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

        new Ej1();
    }
}
