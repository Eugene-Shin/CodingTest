import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int N = Integer.parseInt(br.readLine());
            char[][] matrix = new char[N][N];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    matrix[i][j] = '*';
                }
            }
            
            recursive(matrix, 0, 0, N - 1, N - 1);
            
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    bw.write(matrix[i][j]);
                }
                bw.newLine();
            }
        }
    }
    
    public static void recursive(char[][] matrix, int startX, int startY, int endX, int endY) {
        if(endY - startY + 1 < 3 && endX - startX < 3)    return;
        int thirdX = (endX - startX + 1) / 3;
        int thirdY = (endY - startY + 1) / 3;
        //for(int i = 0; i < 9; i++) {
        //    if(i < 3) {
                recursive(matrix, startX, startY, startX + thirdX - 1, startY + thirdY - 1);
                recursive(matrix, startX + thirdX, startY, startX + 2 * thirdX - 1, startY + thirdY - 1);
                recursive(matrix, startX + 2 * thirdX, startY, endX, startY + thirdY - 1);
        //    } else if (i >= 3 && i < 6) {
                recursive(matrix, startX, startY + thirdY, startX + thirdX - 1, startY + 2 * thirdY - 1);
                for(int j = startX + thirdX; j < startX + 2 * thirdX; j++) {
                    for(int k = startY + thirdY; k < startY + 2 * thirdY; k++) {
                        matrix[j][k] = ' ';
                    }
                }
                recursive(matrix, startX + 2 * thirdX, startY + thirdY, endX, startY + 2 * thirdY - 1);
        //    } else {
                recursive(matrix, startX, startY + 2 * thirdY, startX + thirdX - 1, endY);
                recursive(matrix, startX + thirdX, startY + 2 * thirdY, startX + 2 * thirdX - 1, endY);
                recursive(matrix, startX + 2 * thirdX, startY + 2 * thirdY, endX, endY);
        //    }
        //}
    }
}