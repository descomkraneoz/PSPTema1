
public class Ejemplo1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
        {
            // Se lanza el ejecutable.
            Process p=Runtime.getRuntime().exec ("notepad.exe");
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
