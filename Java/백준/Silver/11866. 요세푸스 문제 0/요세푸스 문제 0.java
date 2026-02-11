import java.util.Scanner;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        sc.close();
        
        Deque<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            queue.offerLast(i);
        }
        
        System.out.print("<");
        while(!queue.isEmpty()) {
            for(int i = 0; i < K - 1; i++) {
                queue.offerLast(queue.pollFirst());
            }
            System.out.print(queue.pollFirst());
            
            if(queue.size() > 0)
                System.out.print(", ");
        }
        System.out.print(">");
    }
}