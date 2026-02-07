import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Set;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in))
        ) {
            String[] arr = br.readLine().split(" ");
            int N = Integer.parseInt(arr[0]);
            int M = Integer.parseInt(arr[1]);
            
            Set<String> set = new HashSet<>();
            for(int i = 0; i < N; i++) {
                set.add(br.readLine());
            }
            
            int count = 0;
            for(int i = 0; i < M; i++) {
                if(set.contains(br.readLine()))    count++;
            }
            
            System.out.println(count);
        }
    }
}