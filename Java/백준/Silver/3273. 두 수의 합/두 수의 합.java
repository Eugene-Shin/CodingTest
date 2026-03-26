import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in))
        ) {
            int n = Integer.parseInt(br.readLine());
            int[] num = new int[1000001];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= n; i++) {
                num[Integer.parseInt(st.nextToken())]++;
            }
            
            int x = Integer.parseInt(br.readLine());
            
            int count = 0;
            int left = 0;
            int right = num.length - 1;
            
            while(left < right) {
                int sum = left + right;
                if(sum == x) {
                    count += num[left] * num[right];
                    left++;
                    right--;
                } else if(sum < x) {
                    left++;
                } else if(sum > x) {
                    right--;
                }
            }
            if(num[left] >= 2) {
                int temp = num[left];
                count += temp * (temp - 1) / 2;
            }
            
            System.out.println(count + "");
        }
    }
}