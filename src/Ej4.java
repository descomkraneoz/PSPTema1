import javax.swing.*;

public class Ej4 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try
        {
            String extension=".exe"; //para windows
            String programa= JOptionPane.showInputDialog("Introduce el nombre del programa: ");
            String ejecutable=programa+extension;
            // Se lanza el ejecutable.
            Process p=Runtime.getRuntime().exec (ejecutable);
            // Esperamos a que termine el ejecutable
            p.waitFor();
            // Mostramos por pantalla un mensaje
            System.out.println("El proceso ha terminado.");
        }
        catch (Exception e)
        {
            // Excepciones si hay algún problema al arrancar el ejecutable o al leer su salida.*/
            e.printStackTrace();
        }
    }

}
