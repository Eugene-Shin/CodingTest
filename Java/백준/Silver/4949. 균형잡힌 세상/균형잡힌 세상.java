import java.util.Scanner;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            String s = sc.nextLine();
            if(".".equals(s))    break;
            
            if(isBalanced(s.substring(0, s.lastIndexOf("."))))
                System.out.println("yes");
            else
                System.out.println("no");
        }
    }
    
    public static boolean isBalanced(String s) {
        Deque<Character> deque = new LinkedList<>();
        for(char c : s.toCharArray()) {
            if(c == '(')
                deque.push('(');
            else if(c == ')') {
                if(!Character.valueOf('(').equals(deque.peek()))    return false;
                deque.pop();
            }
            else if(c == '[')
                deque.push('[');
            else if(c == ']') {
                if(!Character.valueOf('[').equals(deque.peek()))    return false;
                deque.pop();
            }
        }
        if(!deque.isEmpty())    return false;
        return true;
    }
}