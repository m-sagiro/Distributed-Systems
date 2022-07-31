package Factorial;

import java.util.Scanner;

public class Factorial {

    public static int factorial(int n) {
        int e=n;
        n--;
        while(n>0){
            e=e*n;
            n--;
        }
        return e;
    }

    public static void main(String[] args) {

        System.out.println("Gib Zahl ein: ");
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int f = factorial(n);
        System.out.println("Aufgabe1.Factorial: " + f);
    }
}
