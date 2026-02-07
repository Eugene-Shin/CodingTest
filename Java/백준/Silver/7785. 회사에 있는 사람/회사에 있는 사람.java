import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in))
        ) {
            int N = Integer.parseInt(br.readLine());
            Set<String> set = new HashSet<>();
            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String enterOrLeave = st.nextToken();
                if("enter".equals(enterOrLeave))
                    set.add(name);
                else if("leave".equals(enterOrLeave))
                    set.remove(name);
            }
            List<String> list = new ArrayList<>(set);
            list.sort(Comparator.reverseOrder());
            for(String s : list) {
                System.out.println(s);
            }
        }
    }
}