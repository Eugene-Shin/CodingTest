import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in))
        ) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            
            int[][] board = new int[N + 1][M +  1];
            for(int i = 1; i <= N; i++) {
                String s = br.readLine();
                for(int j = 1; j <= M; j++) {
                    if(s.charAt(j - 1) == 'B') {
                        board[i][j] = 1;
                    }
                }
            }
            
            int[][] wMismatch = new int[N + 1][M + 1];
            int[][] bMismatch = new int[N + 1][M + 1];
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= M; j++) {
                    if((i + j) % 2 == 0 && board[i][j] == 1) {
                        wMismatch[i][j] = 1;
                    } else if ((i + j) % 2 == 0 && board[i][j] == 0) {
                        bMismatch[i][j] = 1;
                    } else if ((i + j) % 2 != 0 && board[i][j] == 0) {
                        wMismatch[i][j] = 1;
                    } else if ((i + j) % 2 != 0 && board[i][j] == 1) {
                        bMismatch[i][j] = 1;
                    }
                }
            }
            
            int[][] wPrefix = new int[N + 1][M + 1];
            int[][] bPrefix = new int[N + 1][M + 1];
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= M; j++) {
                    wPrefix[i][j] = wPrefix[i - 1][j] + wPrefix[i][j - 1] - wPrefix[i - 1][j - 1] + wMismatch[i][j];
                    bPrefix[i][j] = bPrefix[i - 1][j] + bPrefix[i][j - 1] - bPrefix[i - 1][j - 1] + bMismatch[i][j];
                }
            }
            
            int min = Integer.MAX_VALUE;
            for(int i = K; i <= N; i++) {
                for(int j = K; j <= M; j++) {
                    int wSum = wPrefix[i][j] - wPrefix[i][j - K] - wPrefix[i - K][j] + wPrefix[i - K][j - K];
                    int bSum = bPrefix[i][j] - bPrefix[i][j - K] - bPrefix[i - K][j] + bPrefix[i - K][j - K];
                    int less = Math.min(wSum, bSum);
                    if(less < min)    min = less;
                }
            }
            
            System.out.println(min);
        }
    }
}