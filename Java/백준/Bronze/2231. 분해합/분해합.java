import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int divSum = Integer.parseInt(sc.next());
        
        int cons = 0;
        for(int i = 1; i < divSum; i++) {
            int temp = i;
            String s = i + "";
            for(int j = 0; j < s.length(); j++)
                temp += (s.charAt(j) - '0');
            if(temp == divSum) {
                cons = i;
                break;
            }
        }
        
        System.out.println(cons);
    }
}