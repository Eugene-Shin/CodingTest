import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[][] arr = new String[N][2];
        for(int i = 0; i < N; i++) {
            arr[i][0] = sc.next();
            arr[i][1] = sc.next();
        }
        Arrays.sort(arr, (a, b) -> {
            int aNum = Integer.parseInt(a[0]);
            int bNum = Integer.parseInt(b[0]);
            if(aNum == bNum)    return 0;
            return aNum - bNum;
        });
        
        for(int i = 0; i < N; i++) {
            System.out.println(arr[i][0] + " " + arr[i][1]);
        }
    }
}