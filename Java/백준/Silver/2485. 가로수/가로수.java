import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in))
        ) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            for(int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }
            
            int[] diff = new int[N - 1];
            for(int i = 0; i < N - 1; i++) {
                diff[i] = arr[i + 1] - arr[i];
            }
            
            int g = diff[0];
            for(int i = 1; i < N - 1; i++) {
                g = gcd(g, diff[i]);
            }
            
            int min = arr[0];
            int max = arr[arr.length - 1];
            int count = (max - min) / g + 1 - arr.length;
            
            System.out.println(count);
        }
    }
    
    public static int gcd(int a, int b) {
        if(a % b == 0)    return b;
        return gcd(b, a % b);
    }
}