import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in))
        ) {
            int X = Integer.parseInt(br.readLine());
            int line = 0;
            int count = 0;
            int pos = 0;
            while(count < X) {
                count += (line += 1);
            }
            
            pos = count - X;
            if(line % 2 == 0) {
                System.out.println(((line + 1) - (pos + 1)) + "/" + (pos + 1));
            }
            else {
                System.out.println((pos + 1) + "/" + ((line + 1) - (pos + 1)));
            }
        }
    }
}