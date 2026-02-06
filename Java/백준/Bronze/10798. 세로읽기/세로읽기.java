import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            char[][] matrix = new char[5][15];
            for(int i = 0; i < 5; i++) {
                for(int j = 0; j < 15; j++) {
                    matrix[i][j] = '?';
                }
            }
            for(int i = 0; i < 5; i++) {
                String line = br.readLine();
                for(int j = 0; j < line.length(); j++) {
                    matrix[i][j] = line.charAt(j);
                }
            }
            for(int j = 0; j < 15; j++) {
                for(int i = 0; i < 5; i++) {
                    if(matrix[i][j] != '?')
                        bw.write(matrix[i][j]);
                }
            }
        }
    }
}