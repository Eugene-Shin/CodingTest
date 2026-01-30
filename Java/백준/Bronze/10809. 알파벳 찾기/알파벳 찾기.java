import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int[] alphabet = new int[26];
        for(int i = 0; i < 26; i++) {
            alphabet[i] = -1;
        }
        for(int i = 0; i < s.length(); i++) {
            if(alphabet[s.charAt(i) - 97] == -1)
                alphabet[s.charAt(i) - 97] = i; 
        }
        for(int i = 0; i < 26; i++) {
            System.out.print(alphabet[i]);
            if(i < 25)
                System.out.print(" ");
        }
    }
}