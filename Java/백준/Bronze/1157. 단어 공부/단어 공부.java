import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        int[] alphabet = new int[26];
        
        for(char c : word.toCharArray()) {
            if(c >= 'a' && c <= 'z') {
                alphabet[c - 'a']++;
            } else if(c >= 'A' && c <= 'Z') {
                alphabet[c - 'A']++;
            }
        }
        
        int idx = 0;
        int max = 0;
        for(int i = 0; i < alphabet.length; i++) {
            if(alphabet[i] > max) {
                max = alphabet[i];
                idx = i;
            } else if(alphabet[i] == max) {
                idx = -1;
            }
        }
        
        System.out.println(idx == -1 ? "?" : (char)(idx + 'A'));
    }
}