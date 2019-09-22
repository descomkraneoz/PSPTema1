import java.io.*;

/* Comandos válidos para Windows, para Linux poner otros */

public class Actividad3 {
    public static void main(String[] args) {
        args= new String[]{"ipconfig","systeminfo","netstat"};
        try{
            if(args.length!=1){
                throw new Exception("Numero de argumentos incorrecto.");
            }
            Process p = Runtime.getRuntime().exec(args[0]);
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String linea;
            while((linea=br.readLine())!=null){
                System.out.println(linea);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
