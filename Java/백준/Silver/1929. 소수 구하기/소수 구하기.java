import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] s = br.readLine().split("\\s");
        int M = Integer.parseInt(s[0]);
        int N = Integer.parseInt(s[1]);
        
        boolean[] primes = new boolean[N + 1];
        for(int i = 2; i <= N; i++) {    //2부터 true로 초기화하고 시작해야 함!!!
            primes[i] = true;
        }
        for(int i = 2; i <= N / i; i++) {
            for(int j = i * i; j <= N; j += i) {
                primes[j] = false;
            }
        }
        
        for(int i = M; i <= N; i++) {
            if(primes[i]) {
                bw.write(i + "");
                bw.newLine();
            }
        }
        bw.flush();
    }
}