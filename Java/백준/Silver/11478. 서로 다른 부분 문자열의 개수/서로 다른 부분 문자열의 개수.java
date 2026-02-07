import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.close();
        
        Set<String> set = new HashSet<>();
        for(int i = 1; i <= s.length(); i++) {
            for(int j = 0; j < s.length() - i + 1; j++) {
                set.add(s.substring(j, j + i));
            }
        }
        
        System.out.println(set.size());
    }
}