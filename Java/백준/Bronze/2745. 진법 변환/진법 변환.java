import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String N = sc.next();
        int B = sc.nextInt();
        int result = 0;
        
        for(int i = 0; i < N.length(); i++) {
            char c = N.charAt(i);
            int n = 0;
            if(c >= 'A') {
                n = c - 'A' + 10;
            } else {
                n = c - '0';
            }
            for(int j = 0; j < N.length() - i - 1; j++) {
                n *= B;
            }
            result += n;
        }
        System.out.println(result);
    }
}