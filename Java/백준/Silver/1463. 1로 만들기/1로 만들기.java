import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static int[] dp = new int[1000001];
    public static void main(String[] args) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in))
        ) {
            int N = Integer.parseInt(br.readLine());
            
            for(int i = 2; i <= N; i++) {
                dp[i] = dp[i - 1] + 1;
                
                if(i % 3 == 0) {
                    dp[i] = Math.min(dp[i], dp[i / 3] + 1);
                }
                
                if(i % 2 == 0) {
                    dp[i] = Math.min(dp[i], dp[i / 2] + 1);
                }
            }
            
            System.out.println(dp[N]);
        }
    }
}