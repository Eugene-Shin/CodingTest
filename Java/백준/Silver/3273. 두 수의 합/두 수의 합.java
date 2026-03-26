import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in))
        ) {
            int n = Integer.parseInt(br.readLine());
            int[] num = new int[1000001];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                num[Integer.parseInt(st.nextToken())]++;
            }
                
            int x = Integer.parseInt(br.readLine());
            
            int count = 0;
            
            for(int i = 1; i <= x / 2; i++) {
                if(i > 1000000 || x - i > 1000000) continue;
                
                if(i == x - i) {
                    count += num[i] * (num[i] - 1) / 2;
                } else {
                    count += num[i] * num[x - i];
                }
            }
            
            System.out.println(count + "");
        }
    }
}