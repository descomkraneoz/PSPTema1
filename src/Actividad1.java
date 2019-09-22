import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Actividad1 {

    public Actividad1(){
        try{
            String linea;
            String sistema = System.getProperty("os.name");
            ProcessBuilder pb = new ProcessBuilder();
            Process p;
            if(sistema.toLowerCase().contains("windows")){
                System.out.println("Estoy en windows");
                pb.command("ipconfig");
            }else if(sistema.toLowerCase().contains("linux")){
                System.out.println("Estoy en linux");
                pb.command("ifconfig");
            }else{
                throw new Exception("Sistema desconocido");
            }
            p=pb.start();
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(),"UTF-8"));
            while ((linea=br.readLine())!=null){
                System.out.println(linea);
            }
        } catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {

        new Actividad1();
    }
}
