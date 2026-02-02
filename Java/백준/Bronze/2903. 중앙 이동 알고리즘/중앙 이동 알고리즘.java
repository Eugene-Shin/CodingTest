import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();
        
        System.out.println(f(N) * f(N));
    }
    
    public static int f(int n) {
        if(n == 0)    return 2;
        
        return 2 * f(n - 1) - 1;
    }
}