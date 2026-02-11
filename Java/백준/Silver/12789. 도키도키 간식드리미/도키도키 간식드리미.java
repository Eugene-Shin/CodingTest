import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int N = Integer.parseInt(br.readLine());
            String[] line = br.readLine().split("\\s");
            System.out.println(canReceive(line) ? "Nice" : "Sad");
        }
    }
    
    public static boolean canReceive(String[] sArr) {
        Deque<Integer> stack = new LinkedList<>();
        int next = 1;
        for(String s : sArr) {
            int num = Integer.parseInt(s);
            if(num == next) {
                next++;
            } else {
                stack.push(num);
            }
            
            while (stack.size() != 0 && next == stack.peek()) {
                stack.pop();
                next++;
            }
        }
        
        return stack.isEmpty();
    }
}