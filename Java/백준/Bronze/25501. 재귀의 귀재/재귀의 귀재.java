import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int T = Integer.parseInt(br.readLine());
            for(int i = 0; i < T; i++) {
                String s = br.readLine();
                bw.write(isPalindrome(s) + " " + call);
                if(i < T - 1)    bw.newLine();
            }
        }
    }
    
    static int call = 0;
    
    public static int recursion(String s, int l, int r){
        call++;
        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1);
    }
    public static int isPalindrome(String s){
        call = 0;
        return recursion(s, 0, s.length()-1);
    }
}