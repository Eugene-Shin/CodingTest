import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        int avg = 0, mid = 0;
        for(int i = 0; i < 5; i++) {
            arr[i] = sc.nextInt();
        }
        for(int i = 0; i < 5; i++) {
            avg += arr[i];
        }
        avg /= 5;
        
        for(int i = 0; i < 4; i++) {
            for(int j = i; j >= 0; j--) {
                if(arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        mid = arr[2];
        
        System.out.println(avg);
        System.out.println(mid);
    }
}