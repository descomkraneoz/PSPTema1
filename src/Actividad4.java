public class Actividad4 {
    public static void main(String[] args) {
        args= new String[]{"notepad.exe"};
        try {
            if(args.length!=1){
                throw new Exception("Numero de argumentos incorrecto.");
            }
            Process p = new ProcessBuilder(args[0]).start();
            int salida = p.waitFor();
            System.out.println("El proceso ha acabado con el codigo de salida " + salida);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
