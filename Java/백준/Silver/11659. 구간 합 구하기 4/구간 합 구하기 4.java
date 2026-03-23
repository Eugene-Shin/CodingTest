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
            
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[N + 1];
            for(int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            
            int[] prefix = new int[N + 1];
            prefix[1] = arr[1];
            for(int i = 2; i <= N; i++) {
                prefix[i] = prefix[i - 1] + arr[i];
            }
            
            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int sum = prefix[end] - prefix[start - 1];
                
                bw.write(sum + "");
                bw.newLine();
            }
        }
    }
}