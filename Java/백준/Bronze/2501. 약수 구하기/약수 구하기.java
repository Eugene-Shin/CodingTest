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
            int K = Integer.parseInt(st.nextToken());
            int result = 0;
            int count = 0;
            for(int i = 1; i <= N; i++) {
                if(N % i == 0) {
                    result = i;
                    count++;
                }
                if(count == K)    break;
            }
            if(count < K)    result = 0;
            
            System.out.println(result);
        }
    }
}