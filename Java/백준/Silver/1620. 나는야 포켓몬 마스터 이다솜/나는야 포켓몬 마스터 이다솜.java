import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            String[] arr = br.readLine().split(" ");
            int N = Integer.parseInt(arr[0]);
            int M = Integer.parseInt(arr[1]);
            
            List<String> list = new ArrayList<>();
            Map<String, Integer> map = new HashMap<>();
            for(int i = 0; i < N; i++) {
                String poke = br.readLine();
                list.add(poke);
                map.put(poke, i + 1);
            }
            
            for(int i = 0; i < M; i++) {
                String question = br.readLine();
                char c = question.charAt(0);
                if(c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
                    bw.write(map.get(question) + "");
                } else {
                    bw.write(list.get(Integer.parseInt(question) - 1));
                }
                if(i < M - 1)    bw.newLine();
            }
        }
    }
}