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
            int M = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            
            int[] num = new int[N + 1];
            for(int i = 1; i <= N; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }
            
            //long[] prefix = new long[N + 1];
            int[] remainder = new int[M];
            int temp = 0;
            for(int i = 1; i <= N; i++) {
                int r = (num[i] + temp) % M;
                remainder[r]++;
                temp = r;
            }
            
            long count = 0;
            //if(remainder[0] >= 1)
                count += (long)remainder[0] * (remainder[0] + 1) / 2;
            for(int i = 1; i < M; i++) {
                if(remainder[i] >= 2)    count += (long)remainder[i] * (remainder[i] - 1) / 2;
            }
            
            System.out.println(count + "");
        }
    }
}