import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            
            int[] sortedArr = arr.clone();
            Arrays.sort(sortedArr);
            int count = 0;
            Map<Integer, Integer> map = new HashMap<>();
            for(int num : sortedArr) {
                if(!map.containsKey(num)) {
                    map.put(num, count);
                    count++;
                }
            }
            
            for(int i = 0; i < N; i++) {
                bw.write(map.get(arr[i]) + "");
                if(i < N - 1)    bw.write(" ");
            }
        }
    }
}