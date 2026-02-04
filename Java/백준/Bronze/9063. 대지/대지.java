import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int minX = 10000, minY = 10000, maxX = -10000, maxY = -10000;
        while(T-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            minX = Math.min(minX, x);
            minY = Math.min(minY, y);
            maxX = Math.max(maxX, x);
            maxY = Math.max(maxY, y);
        }
        
        System.out.println((maxX - minX) * (maxY - minY));
    }
}