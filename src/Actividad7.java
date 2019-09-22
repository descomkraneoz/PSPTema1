import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Actividad7 {
    public static void main(String[] args) {
        try{
            Process p = Runtime.getRuntime().exec("ipconfig");
            String linea;
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(),"UTF-8"));
            while((linea=br.readLine())!=null) {
                if (linea.toLowerCase().contains("ipv4")) {
                    System.out.println(linea);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}