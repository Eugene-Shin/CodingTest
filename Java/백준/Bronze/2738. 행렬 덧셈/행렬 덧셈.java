import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][] matrixA = new int[N][M];
            int[][] matrixB = new int[N][M];
            int[][] matrixSum = new int[N][M];
            
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < M; j++) {
                    matrixA[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < M; j++) {
                    matrixB[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    matrixSum[i][j] = matrixA[i][j] + matrixB[i][j];
                }
            }
            
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    bw.write("" + matrixSum[i][j]);
                    if(j < M - 1)
                        bw.write(" ");
                }
                bw.write("\n");
            }
        }
    }
}