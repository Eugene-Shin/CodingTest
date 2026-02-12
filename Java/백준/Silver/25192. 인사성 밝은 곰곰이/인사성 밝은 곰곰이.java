import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        Set<String> set = new HashSet<>();
        int count = 0;
        for(int i = 0; i < N; i++) {
            String s = sc.next();
            if("ENTER".equals(s))
                set.clear();
            else {
                if(!set.contains(s)) {
                    set.add(s);
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}