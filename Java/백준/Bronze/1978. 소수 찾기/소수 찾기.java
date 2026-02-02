import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in))
        ) {
            int N = Integer.parseInt(br.readLine());
            int count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                int n = Integer.parseInt(st.nextToken());
                boolean isPrime = true;
                if(n == 1)    isPrime = false;
                for(int j = 2; j <= (int) Math.sqrt(n); j++) {
                    if(n % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if(isPrime == true)    count++;
            }
            System.out.println(count);
        }
    }
}