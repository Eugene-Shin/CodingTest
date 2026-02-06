import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean[][] paper = new boolean[100][100];
        int area = 0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        for(int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            
            for(int j = y; j < y + 10; j++) {
                for(int k = x; k < x + 10; k++) {
                    paper[j][k] = true;
                }
            }
        }
        
        for(int i = 0; i < 100; i++) {
            for(int j = 0; j < 100; j++) {
                if(paper[i][j] == true)
                    area++;
            }
        }
        
        System.out.println(area);
    }
}