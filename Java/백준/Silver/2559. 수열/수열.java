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
            int K = Integer.parseInt(st.nextToken());
            
            st = new StringTokenizer(br.readLine());
            
            int[] arr = new int[N + 1];
            int[] prefix = new int[N + 1];
            for(int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            prefix[1] = arr[1];
            for(int i = 2; i <= N; i++) {
                prefix[i] = prefix[i - 1] + arr[i];
            }
            
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < N - K + 1; i++) {
                int sum = prefix[i + K] - prefix[i];
                
                if(sum > max)    max = sum;
            }
            bw.write(max + "");
        }
    }
}