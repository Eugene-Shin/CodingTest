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
            Deque<Integer> queue = new LinkedList<>();
            
            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                
                switch(st.nextToken()) {
                    case "push":
                        queue.offerLast(Integer.parseInt(st.nextToken()));
                        break;
                    case "pop":
                        if(queue.isEmpty())
                            bw.write("-1\n");
                        else
                            bw.write(queue.pollFirst() + "\n");
                        break;
                    case "size":
                        bw.write(queue.size() + "\n");
                        break;
                    case "empty":
                        if(queue.isEmpty())
                            bw.write("1\n");
                        else
                            bw.write("0\n");
                        break;
                    case "front":
                        if(queue.isEmpty())
                            bw.write("-1\n");
                        else
                            bw.write(queue.peekFirst() + "\n");
                        break;
                    case "back":
                        if(queue.isEmpty())
                            bw.write("-1\n");
                        else
                            bw.write(queue.peekLast() + "\n");
                        break;
                }
            }
        }
    }
}