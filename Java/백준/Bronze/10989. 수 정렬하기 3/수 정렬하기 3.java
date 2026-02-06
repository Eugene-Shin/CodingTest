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
            int N = Integer.parseInt(br.readLine());
            int[] count = new int[10001];
            for(int i = 0; i < N; i++) {
                count[Integer.parseInt(br.readLine())]++;
            }
            for(int i = 1; i <= 10000; i++) {
                for(int j = 0; j < count[i]; j++) {
                    bw.write(i + "");
                    bw.newLine();
                }
            }
            
        }
    }
}