import java.util.Scanner;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();
        
        Deque<Integer> deque = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            deque.offerLast(i);
        }
        while(deque.size() > 1) {
            deque.pollFirst();
            deque.offerLast(deque.pollFirst());
        }
        
        System.out.println(deque.pollFirst());
    }
}