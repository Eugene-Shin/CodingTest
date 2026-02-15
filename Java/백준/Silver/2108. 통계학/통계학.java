import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in))
        ) {
            List<Integer> list = new ArrayList<>();
            int[] count = new int[2 * 4000 + 1];
            int N = Integer.parseInt(br.readLine());
            int avg = 0, min = 4001, max = -4001;
            for(int i = 0; i < N; i++) {
                int num = Integer.parseInt(br.readLine());
                list.add(num);
                avg += num;
                if(num < min)    min = num;
                if(num > max)    max = num;
                count[num + 4000]++;
            }
            avg = (int)Math.round((double)avg / list.size());
            int range = max - min;
            list.sort(null);
            int mid = list.get(list.size() / 2);
            
            int maxFreq = 0;
            for(int i = 0; i < 2 * 4000 + 1; i++) {
                if(maxFreq < count[i])    maxFreq = count[i];
            }
            int maxIdx = 0;
            boolean first = true;
            for(int i = 0; i < 2 * 4000 + 1; i++) {
                if(maxFreq == count[i]) {
                    maxIdx = i;
                    if(!first)    break;
                    first = false;
                }
            }
            int freq = maxIdx - 4000;
            
            System.out.println(avg);
            System.out.println(mid);
            System.out.println(freq);
            System.out.println(range);
        }
    }
}