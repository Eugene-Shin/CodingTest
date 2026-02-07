import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        sc.close();
        
        int bunza = a * d + b * c;
        int bunmo = b * d;
        
        int div = gcd(bunza, bunmo);
        bunza /= div;
        bunmo /= div;
        
        System.out.println(bunza + " " + bunmo);
    }
    
    public static int gcd(int a, int b) {
        if(a % b == 0)    return b;
        return gcd(b, a % b);
    }
}