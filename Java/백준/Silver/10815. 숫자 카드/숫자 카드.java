import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            Map<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i < N; i++) {
                int num = Integer.parseInt(st.nextToken());
                map.put(num, num);
            }
            
            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < M; i++) {
                int num = Integer.parseInt(st.nextToken());
                if(map.containsKey(num))    bw.write("1");
                else    bw.write("0");
                if(i < M - 1)    bw.write(" ");
            }
            
        }
    }
}