import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int N = Integer.parseInt(br.readLine());
            int[][] spots = new int[N][2];
            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                spots[i][0] = Integer.parseInt(st.nextToken());
                spots[i][1] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(spots, (a, b) -> {
                if(a[1] == b[1])    return a[0] - b[0];
                return a[1] - b[1];
            });
            
            for(int i = 0; i < N; i++) {
                bw.write(spots[i][0] + " " + spots[i][1]);
                bw.newLine();
            }
        }
    }
}