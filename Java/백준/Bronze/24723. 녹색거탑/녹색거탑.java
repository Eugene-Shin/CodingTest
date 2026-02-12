import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();
        
        int cases = 0;
        switch(N) {
            case 1:
                cases = 2;
                break;
            case 2:
                cases = 4;
                break;
            case 3:
                cases = 8;
                break;
            case 4:
                cases = 16;
                break;
            case 5:
                cases = 32;
                break;
        }
        
        System.out.println(cases);
    }
}