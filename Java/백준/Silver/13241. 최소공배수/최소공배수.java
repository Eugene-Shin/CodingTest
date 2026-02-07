import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextInt();
        long b = sc.nextInt();
        
        System.out.println(a * b / gcd(a, b));
    }
    
    public static long gcd(long a, long b) {
        if(a % b == 0)    return b;
        return gcd(b, a % b);
    }
}