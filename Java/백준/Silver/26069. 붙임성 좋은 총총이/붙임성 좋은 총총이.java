import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Set<String> set = new HashSet<>();
        set.add("ChongChong");
        for(int i = 0; i < N; i++) {
            String name1 = sc.next();
            String name2 = sc.next();
            
            if(set.contains(name1))
                set.add(name2);
            if(set.contains(name2))
                set.add(name1);
        }
        System.out.println(set.size());
    }
}