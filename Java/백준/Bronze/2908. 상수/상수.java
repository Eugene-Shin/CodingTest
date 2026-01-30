import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb1 = new StringBuilder(sc.next());
        StringBuilder sb2 = new StringBuilder(sc.next());
        sb1.reverse();
        sb2.reverse();
        int a = Integer.parseInt(sb1.toString());
        int b = Integer.parseInt(sb2.toString());
        
        if(a > b) {
            System.out.println(a);
        } else {
            System.out.println(b);
        }
    }
}