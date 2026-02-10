import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            while(true) {
                int num = Integer.parseInt(br.readLine());
                if(num == 0)    break;
                bw.write(countPrime(num) + "");
                bw.newLine();
            }
        }
    }
    
    public static int countPrime(int num) {
        int count = 0;
        boolean[] isPrime = new boolean[2 * num + 1];
        for(int i = 2; i <= 2 * num; i++) {
            isPrime[i] = true;
        }
        
        for(int i = 2; i <= 2 * num / i; i++) {
            if(!isPrime[i])    continue;
            for(int j = i * i; j <= 2 * num; j += i) {
                isPrime[j] = false;
            }
        }
        
        for(int i = num + 1; i <= 2 * num; i++) {
            if(isPrime[i])    count++;
        }
        
        return count;
    }
}