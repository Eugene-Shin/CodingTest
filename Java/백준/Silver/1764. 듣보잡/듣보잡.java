import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
         ) {
            String[] nums = br.readLine().split("\\s");
            int N = Integer.parseInt(nums[0]);
            int M = Integer.parseInt(nums[1]);
            Set<String> haveNotHeard = new HashSet<>();
            Set<String> haveNotSeen = new HashSet<>();
            for(int i = 0; i < N; i++) {
                haveNotHeard.add(br.readLine());
            }
            for(int i = 0; i < M; i++) {
                haveNotSeen.add(br.readLine());
            }
            Set<String> haveNotSeenOrHeard = new HashSet<>(haveNotHeard);
            haveNotSeenOrHeard.retainAll(haveNotSeen);
            
            List<String> list = new ArrayList<>(haveNotSeenOrHeard);
            list.sort(Comparator.naturalOrder());
            
            bw.write(list.size() + "");
            bw.newLine();
            int listSize = list.size();
            for(int i = 0; i < listSize; i++) {
                bw.write(list.get(i));
                if(i < listSize - 1)    bw.newLine();
            }
        }
    }
}