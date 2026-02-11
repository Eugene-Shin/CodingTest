import java.util.Scanner;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        for(int i = 0; i < T; i++) {
            if(isVPS(sc.next()))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
    
    public static boolean isVPS(String s) {
        Deque<Character> deque = new LinkedList<>();
        for(char c : s.toCharArray()) {
            if(c == '(')
                deque.push('(');
            else {
                if(deque.isEmpty())    return false;
                
                deque.pop();
            }
        }
        if(!deque.isEmpty())    return false;
        return true;
    }
}