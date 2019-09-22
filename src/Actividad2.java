public class Actividad2 {
    public static void main(String[] args) {
        /*En Windows 10 la calculadora trabaja de manera especial y no he sido capaz de controlar
          el proceso, por lo que he hecho que ejecute el "notepad", con el que si que funciona
          correctamente*/
        try{
            ProcessBuilder pb= new ProcessBuilder();
            Process p;
            String sistema = System.getProperty("os.name");
            if (sistema.toLowerCase().contains("windows")){
                pb.command("notepad.exe");
            }else if(sistema.toLowerCase().contains("linux")){
                pb.command("gedit");
            }else{
                throw new Exception("Sistema desconocido");
            }
            p=pb.start();
            int salida = p.waitFor();
            System.out.println("El proceso ha acabado con el codigo de salida: " + salida);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
