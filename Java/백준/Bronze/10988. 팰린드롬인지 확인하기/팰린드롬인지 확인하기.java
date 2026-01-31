import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int strLen = str.length();
        
        for(int i = 0; i < strLen / 2; i++) {
            if(str.charAt(i) != str.charAt(strLen - 1 - i)) {
                System.out.println(0);
                return;
            }
        }
        
        System.out.println(1);
    }
}