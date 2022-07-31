package JavaThreads;
import java.util.Scanner;

public class Input {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int i=0;

        while(true){
            scanner.nextLine();
            MyThread t = new MyThread(i);
            t.start();
            i++;
        }
    }
}
