import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            List<Integer> list = new ArrayList<>();
            int n = sc.nextInt();
            if(n == -1)    break;
            
            for(int i = 1; i < n; i++) {
                if(n % i == 0) {
                    list.add(i);
                }
            }
            
            int sum = list.stream().mapToInt(Integer::intValue).sum();
            
            if(sum == n) {
                System.out.println(n + " = " + 
                                  list.stream()
                                   .map(String::valueOf)
                                   .collect(Collectors.joining(" + "))
                                  );
            } else {
                System.out.println(n + " is NOT perfect.");
            }
        }
    }
}