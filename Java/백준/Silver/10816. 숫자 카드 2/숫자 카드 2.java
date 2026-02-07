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
            Map<Integer, Integer> map = new HashMap<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                int card = Integer.parseInt(st.nextToken());
                if(!map.containsKey(card))
                    map.put(card, 1);
                else
                    map.put(card, map.get(card) + 1);
            }
            
            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < M; i++) {
                bw.write(map.getOrDefault(Integer.parseInt(st.nextToken()), 0) + "");
                if(i < M - 1)     bw.write(" ");
            }
        }
    }
}