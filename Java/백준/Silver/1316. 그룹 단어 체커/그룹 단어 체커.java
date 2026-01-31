import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        for(int i = 0; i < n; i++) {
            int[] alp = new int[26];
            String word = sc.next();
            
            int j = 0;
            int preidx = word.charAt(0) - 'a';
            for(; j < word.length(); j++) {
                int idx = word.charAt(j) - 'a';
                
                if(preidx == idx || (preidx != idx && alp[idx] == 0)) {
                    alp[idx]++;
                } else if(preidx != idx && alp[idx] != 0) {
                    break;
                }
                
                preidx = idx;
            }
            if(j == word.length())
                count++;
        }
        
        System.out.println(count);
    }
}