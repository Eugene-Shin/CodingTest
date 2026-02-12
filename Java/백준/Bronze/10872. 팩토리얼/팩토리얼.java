import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();
        
        int fac = 1;
        
        for(int i = 1; i <= N; i++) {
            fac *= i;
        }
        
        System.out.println(fac);
    }
}