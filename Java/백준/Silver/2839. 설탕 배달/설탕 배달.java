import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int weight = sc.nextInt();
        
        int count = -1;
        
        outer:
        for(int i = 0; i <= weight / 3; i++) {
            for(int j = 0; j <= weight / 5; j++) {
                if(3 * i + 5 * j == weight) {
                    count = i + j;
                    break outer;
                }
            }
        }
        
        System.out.println(count);
    }
}