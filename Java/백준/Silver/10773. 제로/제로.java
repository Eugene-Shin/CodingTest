import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int K = Integer.parseInt(br.readLine());
            Deque<Integer> deque = new LinkedList<>();
            for(int i = 0; i < K; i++) {
                int n = Integer.parseInt(br.readLine());
                if(n == 0)
                    deque.pop();
                else
                    deque.push(n);
            }
            
            long sum = 0;
            for(int i : deque) {
                sum += i;
            }
            bw.write(sum + "");
        }
    }
}