import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int N = sc.nextInt();
            System.out.println(cantor(N));
        }
    }
    
    public static String cantor(int N) {
        int len = (int)Math.pow(3, N);
        char[] arr = new char[len];
        for(int i = 0; i < len; i++) {
            arr[i] = '-';
        }
        recursive(arr, 0, arr.length - 1);
        return new String(arr);
    }
    
    public static void recursive(char[] arr, int p, int q) {
        if(q - p + 1 < 3)    return;
        recursive(arr, p, p + (q - p + 1) / 3 - 1);
        for(int i = p + (q - p + 1) / 3; i < p + 2 * (q - p + 1) / 3; i++)
            arr[i] = ' ';
        recursive(arr, p + 2 * (q - p + 1) / 3, q);
    }
}