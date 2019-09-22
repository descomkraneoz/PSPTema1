import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Actividad6 {

    public static void listarPID(){
        try{
            String linea;
            String sistema = System.getProperty("os.name");
            ProcessBuilder pb = new ProcessBuilder();
            Process p;
            if(sistema.toLowerCase().contains("windows")){
                System.out.println("Estoy en windows");
                pb.command("tasklist");
            }else if(sistema.toLowerCase().contains("linux")){
                System.out.println("Estoy en linux");
                pb.command("ps aux");
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
        args= new String[]{"notepad.exe", "mspaint.exe"};

        try{
            if (args.length==0){
                throw new Exception("No hay argumentos");
            }
            List<Process> procesos = new ArrayList<>();
            for (String s : args){
                Process p = Runtime.getRuntime().exec(s);
                procesos.add(p);
            }
            List<Process> procesosDestruidos = new ArrayList<>();
            Scanner sc = new Scanner(System.in);
            long respuesta;
            System.out.println("\nTienes abiertos: ");
            listarPID();
            while(procesos.size()>0){

                System.out.println("\nEscribe el PID del que quieres cerrar: (0) para salir");
                respuesta = sc.nextLong();

                if (respuesta==0){
                    System.out.println("\nTodos los procesos finalizados con exito");
                    procesos.removeAll(procesosDestruidos);
                    procesosDestruidos.clear();
                    procesos.clear();

                }else{
                    String cmd = "taskkill /F /PID " + respuesta;
                    Runtime.getRuntime().exec(cmd);
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
