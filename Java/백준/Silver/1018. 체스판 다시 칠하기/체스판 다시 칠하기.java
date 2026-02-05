import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] board = new int[N][M];
        int[][] bChess = new int[8][8];
        int[][] wChess = new int[8][8];
        
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if((i + j) % 2 == 0) {
                    bChess[i][j] = 1;
                    wChess[i][j] = 0;
                } else {
                    bChess[i][j] = 0;
                    wChess[i][j] = 1;
                }
            }
        }
        
        for(int i = 0; i < N; i++) {
            String s = sc.next();
            for(int j = 0; j < M; j++) {
                if(s.charAt(j) == 'B')
                    board[i][j] = 1;
                else
                    board[i][j] = 0;
            }
        }
        
        int[][] bChessCount = new int[N - 8 + 1][M - 8 + 1];
        int[][] wChessCount = new int[N - 8 + 1][M - 8 + 1];
        for(int i = 0; i <= N - 8; i++) {
            for(int j = 0; j <= M - 8; j++) {
                for(int k = 0; k < 8; k++) {
                    for(int l = 0; l < 8; l++) {
                        if(bChess[k][l] != board[i + k][j + l])    bChessCount[i][j]++;
                        if(wChess[k][l] != board[i + k][j + l])    wChessCount[i][j]++;
                    }
                }
            }
        }
        
        int bMin = 2500, wMin = 2500;
        for(int i = 0; i <= N - 8; i++) {
            for(int j = 0; j <= M - 8; j++) {
                if(bChessCount[i][j] < bMin)    bMin = bChessCount[i][j];
                if(wChessCount[i][j] < wMin)    wMin = wChessCount[i][j];
            }
        }
        
        System.out.println(Math.min(bMin, wMin));
    }
}