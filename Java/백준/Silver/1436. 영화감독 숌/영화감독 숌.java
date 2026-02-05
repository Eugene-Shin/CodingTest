import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int demon = 666;
        int count = 0;
        while(true) {
            String d = demon + "";
            if(d.contains("666"))    count++;
            if(count == n)    break;
            demon++;
        }
        
        System.out.println(demon);
    }
}