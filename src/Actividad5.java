import java.util.ArrayList;
import java.util.List;

public class Actividad5 {
    public static void main(String[] args) {
        args= new String[]{"calc.exe", "notepad.exe", "mspaint.exe"};
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
            while(procesos.size()>0){
                for (Process p : procesos){
                    if (!p.isAlive()){
                        p.destroy();
                        procesosDestruidos.add(p);
                    }
                }
                procesos.removeAll(procesosDestruidos);
                procesosDestruidos.clear();
                Thread.sleep(100);
            }
            System.out.println("Todos los procesos finalizados con exito.");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
