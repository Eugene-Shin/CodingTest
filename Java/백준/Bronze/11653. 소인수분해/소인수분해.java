import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in))
        ) {
            int N = Integer.parseInt(br.readLine());
            List<Integer> list = new ArrayList<>();
            for(int i = 2; i <= (int) Math.sqrt(N); i++) {
                while(N % i == 0) {
                    list.add(i);
                    N /= i;
                }
            }
            if(N > 1)
                list.add(N);
            
            for(int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        }
    }
}