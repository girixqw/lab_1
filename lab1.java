import java.util.ArrayList;
import  java.util.List;
import java.util.Scanner;
import java.io.IOException;
class Main {
    void main() throws Exception {
        Scanner s = new Scanner(System.in);
        System.out.println("Введите имя процесса: ");
        String p1 = s.nextLine();
        System.out.println("Введите имя процесса: ");
        String p2 = s.nextLine();
        System.out.println("Введите имя процесса: ");
        String p3 = s.nextLine();




        ProcessBuilder pb1 = new ProcessBuilder(p1);
        ProcessBuilder pb2 = new ProcessBuilder(p2);
        ProcessBuilder pb3 = new ProcessBuilder( p3);

        List<Process> al = new ArrayList<>();
        try {
            Process process = pb1.start();
            al.add(process);
            Process process1 = pb2.start();
            al.add(process1);
            Process process2 = pb3.start();
            al.add(process2);
            for (Process process3 : al){
                System.out.println(process3.pid());
            }
            for (Process process3 : al){
                System.out.println(process3.info().command().get());
            }
            System.out.println("хотите завершить процессы?");
            String i = s.nextLine().trim();
            if (i.equalsIgnoreCase("да") || i.equalsIgnoreCase("da") || i.equalsIgnoreCase("yes")) {
                m(al);
            }

        }
        catch (IOException  e ){
            e.getMessage();
        }

    }
    static  void  m (List <Process> processes){
        for ( Process process : processes){
            if (process.isAlive()){
                System.out.println("Завершаем проложения ...");
                process.destroyForcibly();
            }
        }

    }
}