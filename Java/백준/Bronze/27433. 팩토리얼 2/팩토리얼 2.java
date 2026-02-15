import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(fib(N));
    }
    
    public static long fib(int n) {
        if(n <= 1)    return 1;
        return n * fib(n - 1);
    }
}