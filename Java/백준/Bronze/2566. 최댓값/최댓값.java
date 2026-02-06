import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in))
        ) {
            int[][] matrix = new int[9][9];
            
            int max = -1;
            int row = 0;
            int col = 0;
            for(int i = 0; i < 9; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 9; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                    if(matrix[i][j] > max) {
                        max = matrix[i][j];
                        row = i + 1;
                        col = j + 1;
                    }
                }
            }
            System.out.println(max);
            System.out.println(row + " " + col);
        }
    }
}