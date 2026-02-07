import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Set;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in))
        ) {
            Set<Integer> setA = new HashSet<>();
            Set<Integer> setB = new HashSet<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int ASize = Integer.parseInt(st.nextToken());
            int BSize = Integer.parseInt(st.nextToken());
            
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < ASize; i++) {
                setA.add(Integer.parseInt(st.nextToken()));
            }
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < BSize; i++) {
                setB.add(Integer.parseInt(st.nextToken()));
            }
            
            Set<Integer> ASubB = new HashSet<>(setA);
            ASubB.removeAll(setB);
            Set<Integer> BSubA = new HashSet<>(setB);
            BSubA.removeAll(setA);
            
            System.out.println(ASubB.size() + BSubA.size());
        }
    }
}