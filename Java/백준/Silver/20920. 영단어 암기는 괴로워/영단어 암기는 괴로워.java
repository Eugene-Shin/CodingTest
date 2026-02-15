import java.io.*;
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
            String[] nums = br.readLine().split("\\s");
            int N = Integer.parseInt(nums[0]);
            int M = Integer.parseInt(nums[1]);
            
            Map<String, Integer> map = new HashMap<>();
            
            for(int i = 0; i < N; i++) {
                String word = br.readLine();
                if(word.length() < M)    continue;
                
                map.merge(word, 1, Integer::sum);
            }
            
            List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());
            entryList.sort((a, b) -> {
                if(a.getKey().length() == b.getKey().length() && a.getValue() == b.getValue())
                    return a.getKey().compareTo(b.getKey());
                if(a.getValue() == b.getValue())
                    return b.getKey().length() - a.getKey().length();
                return b.getValue() - a.getValue();
            });
            
            for(Map.Entry<String, Integer> entry : entryList) {
                bw.write(entry.getKey());
                bw.newLine();
            }
        }
    }
}