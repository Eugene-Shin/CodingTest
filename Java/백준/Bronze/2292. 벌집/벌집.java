import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int shell = 0;
        int count = 1;
        int d = 1;
        while(count < N) {
            count += 6 * (shell += 1);
        }
        d += shell;
        
        System.out.println(d);
    }
}