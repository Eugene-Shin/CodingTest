import java.io.*;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int N = Integer.parseInt(br.readLine());
            Deque<String> deque = new LinkedList<>();
            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                switch(st.nextToken()) {
                    case "1":
                        deque.offerFirst(st.nextToken());
                        break;
                    case "2":
                        deque.offerLast(st.nextToken());
                        break;
                    case "3":
                        bw.write(deque.isEmpty() ? "-1\n" : deque.pollFirst() + "\n");
                        break;
                    case "4":
                        bw.write(deque.isEmpty() ? "-1\n" : deque.pollLast() + "\n");
                        break;
                    case "5":
                        bw.write(deque.size() + "\n");
                        break;
                    case "6":
                        bw.write(deque.isEmpty() ? "1\n" : "0\n");
                        break;
                    case "7":
                        bw.write(deque.isEmpty() ? "-1\n" : deque.peekFirst() + "\n");
                        break;
                    case "8":
                        bw.write(deque.isEmpty() ? "-1\n" : deque.peekLast() + "\n");
                        break;
                }
            }
        }
    }
}