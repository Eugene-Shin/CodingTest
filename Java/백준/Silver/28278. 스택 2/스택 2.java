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
            Deque<Integer> deque = new LinkedList<>();
            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken());
                //Deque<Integer> deque = new LinkedList<>();
                switch(n) {
                    case 1:
                        deque.push(Integer.parseInt(st.nextToken()));
                        break;
                    case 2:
                        if(deque.isEmpty())
                            bw.write("-1\n");
                        else {
                            bw.write(deque.peek() + "\n");
                            deque.pop();
                        }
                        break;
                    case 3:
                        bw.write(deque.size() + "\n");
                        break;
                    case 4:
                        if(deque.isEmpty())
                            bw.write("1\n");
                        else
                            bw.write("0\n");
                        break;
                    case 5:
                        if(deque.isEmpty())
                            bw.write("-1\n");
                        else
                            bw.write(deque.peek() + "\n");
                        break;
                }
            }
        }
    }
}