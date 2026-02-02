import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for(int i = M; i <= N; i++) {
            boolean isPrime = true;
            if(i == 1)    isPrime = false;
            for(int j = 2; j <= (int) Math.sqrt(i); j++) {
                if(i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime == true)    list.add(i);
        }
        if(list.isEmpty()) {
            System.out.println(-1);
        } else {
            System.out.println(list.stream().mapToInt(Integer::intValue).sum());
            System.out.println(list.get(0));
        }
    }
}