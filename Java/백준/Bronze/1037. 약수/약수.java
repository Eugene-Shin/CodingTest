import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int count = Integer.parseInt(br.readLine());
            int[] div = new int[count];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < count; i++) {
                div[i] = Integer.parseInt(st.nextToken());
            }
            
            int min = div[0], max = div[0];
            for(int i = 1; i < count; i++) {
                min = Math.min(min, div[i]);
                max = Math.max(max, div[i]);
            }
            
            bw.write(min * max + "");
        }
    }
}