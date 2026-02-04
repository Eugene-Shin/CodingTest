import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        
        int max = Math.max(a, Math.max(b, c));
        int min = Math.min(a, Math.min(b, c));
        if(max >= (a + b + c) - max) {
            System.out.println(2 * ((a + b + c) - max) - 1);
        } else {
            System.out.println(a + b + c);
        }
    }
}