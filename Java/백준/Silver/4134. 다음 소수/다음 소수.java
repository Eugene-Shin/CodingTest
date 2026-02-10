import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int N = Integer.parseInt(br.readLine());
            for(int i = 0; i < N; i++) {
                long num = Long.parseLong(br.readLine());
                bw.write(findMinPrime(num) + "");
                bw.newLine();
            }
         }
    }
    
    public static long findMinPrime(long num) {
        if(num <= 2)    return 2;
        if(num == 3)    return 3;
        
        long prime = num;
        if(prime % 2 == 0)    prime++;    //한 번만 수행하면 되므로
        //boolean isPrime = true;
        while(true) {
            boolean isPrime = true;    //여기서 초기화!
            
            if(prime % 3 == 0) {    //3의 배수를 따로 초기해 줘야 함!!!!!!!
                prime+=2;
                continue;
            }
            
            for(long i = 5; i * i <= prime; i += 6) {    //num이 아니라 prime!!!
                if(prime % i == 0 || prime % (i + 2) == 0) {
                    isPrime = false;
                    break;
                }
            }

            if(isPrime)    break;
            prime += 2;
        }
        
        
        return prime;
    }
}