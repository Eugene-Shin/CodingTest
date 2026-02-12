import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        sc.close();
        
        int c = 1;
        for(int i = 0; i < K; i++) {
            c = c * (N - i) / (i + 1);
        }
        System.out.println(c);
    }
}