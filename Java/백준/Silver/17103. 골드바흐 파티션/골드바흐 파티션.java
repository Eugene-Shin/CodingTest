import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int T = Integer.parseInt(br.readLine());
            
            boolean[] isPrime = isPrime(1_000_000);
            
            while(T-- > 0) {
                int num = Integer.parseInt(br.readLine());
                
                if(num == 4) {
                    bw.write("1\n");
                    continue;
                }
                
                int count = 0;
                
                for(int i = 3; i <= num / 2; i += 2) {
                    if(isPrime[i] && isPrime[num - i])
                        count++;
                } 
                
                bw.write(count + "");
                bw.newLine();
            }
        }
    }
    
    public static boolean[] isPrime(int a) {
        boolean[] arr = new boolean[a + 1];
        
        for(int i = 2; i < arr.length; i++) {
            arr[i] = true;
        }
        
        for(int i = 2; i <= a / i; i++) {
            if(!arr[i])    continue;
            for(int j = i * i; j <= a; j += i) {
                arr[j] = false;
            }
        }
        
        return arr;
    }
}