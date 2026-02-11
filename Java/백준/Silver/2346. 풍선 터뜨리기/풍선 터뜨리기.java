import java.io.*;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.ArrayDeque;

public class Main {
    static class Balloon {
        public int num;
        public int move;
    
        Balloon(int num, int move) {
            this.num = num;
            this.move = move;
        }
    }
    
    public static void main(String[] args) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            Deque<Balloon> deque = new ArrayDeque<>();
            for(int i = 1; i <= N; i++) {
                deque.offerLast(new Balloon(i, Integer.parseInt(st.nextToken())));
            }
            
            int next = 1;
            for(int i = 0; i < N; i++) {
                Balloon balloon;
                if(next > 0) {
                    for(int j = 0; j < next - 1; j++) {
                        deque.offerLast(deque.pollFirst());
                    }
                    balloon = deque.pollFirst();
                } else {
                    next = Math.abs(next);
                    for(int j = 0; j < next - 1; j++) {
                        deque.offerFirst(deque.pollLast());
                    }
                    balloon = deque.pollLast();
                }
                
                bw.write(balloon.num + "");
                next = balloon.move;
                if(i < N - 1)    bw.write(" ");
            }
        }
    }
}