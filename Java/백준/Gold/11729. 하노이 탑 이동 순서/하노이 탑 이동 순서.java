import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int N = Integer.parseInt(br.readLine());
            List<Movement> list = new ArrayList<>();
            
            hanoi(N, 1, 3, list);
            System.out.println(list.size());
            for(Movement m : list) {
                bw.write(m.from + " " + m.to + "\n");
            }
        }
    }
    
    static class Movement {
        int from;
        int to;
        
        Movement(int x, int y) {
            this.from = x;
            this.to = y;
        }
    }
    
    public static void hanoi(int N, int from, int to, List<Movement> list) {
        if(N == 0)    return;
        
        hanoi(N - 1, from, 6 - from - to, list);
        list.add(new Movement(from, to));    //hanoi(1, from, to, list);
        hanoi(N - 1, 6 - from - to, to, list);
    }
}