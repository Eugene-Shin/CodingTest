import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        try(
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in))
        ) {
            String line = br.readLine().trim();
            
            if(line.isEmpty()) {
                System.out.println(0);
            } else {
                String[] words = line.split("\\s+");
                System.out.println(words.length);
            }
        }
    }
}